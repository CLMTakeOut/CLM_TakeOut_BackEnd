<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="订单ID" prop="orderId">
        <el-input
          v-model="queryParams.orderId"
          placeholder="请输入订单ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户ID" prop="customerId">
        <el-input
          v-model="queryParams.customerId"
          placeholder="请输入用户ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:order:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="orderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="订单ID" align="center" prop="orderId" />
      <el-table-column label="订单编号" align="center" prop="orderNumber"/>
      <el-table-column label="客户名" align="center" prop="customer.customerName">
        <template slot-scope="scope">
          <el-popover trigger="hover" placement="top">
            <p><el-tag>客户姓名</el-tag>&nbsp;&nbsp;{{ scope.row.customer.customerName}}</p>
            <p><el-tag>客户性别</el-tag>&nbsp;&nbsp;{{ scope.row.customer.sex }}</p>
            <p><el-tag>客户电话</el-tag>&nbsp;&nbsp;{{ scope.row.customer.telephone }}</p>
            <div slot="reference" class="name-wrapper">
              <el-tag type="success">{{scope.row.customer.customerName}}</el-tag>
            </div>
          </el-popover>
        </template>
      </el-table-column>
      <el-table-column label="下单时间" align="center" prop="orderTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.orderTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="配送地址" align="center" prop="dispatchAddress" width="180">
        <template slot-scope="scope">
          <el-tag type="warning">{{scope.row.dispatchAddress}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="订单状态" align="center">
        <template slot-scope="scope">
          {{scope.row.orderStatus===0?'未付款':(scope.row.orderStatus===1?'正在进行...':(scope.row.orderStatus===2?'已完成':""))}}
        </template>
      </el-table-column>
      <el-table-column label="操作" width="300" align="center" >
        <template slot-scope="scope">
          <el-button
            size="mini"
            icon="el-icon-search"
            type="warning"
            v-hasPermi="['system:order:edit']"
            @click="handleDetails(scope.row)"
          >订单详情</el-button>
          <el-button
            size="mini"
            icon="el-icon-edit"
            type="primary"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:order:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="danger"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:order:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改【请填写功能名称】对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="下单时间" prop="orderTime">
          <el-date-picker clearable size="small"
            v-model="form.orderTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择下单时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="订单状态" prop="orderStatus">
          <el-select v-model="form.orderStatus" placeholder="请选择订单状态" >
            <el-option label="未付款 0" value="0"></el-option>
            <el-option label="正在进行 1" value="1"></el-option>
            <el-option label="已完成 2" value="2"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

<!-- 显示商品详情 -->
    <el-dialog
      :title="detailsTitle"
      :visible.sync="detailsDialogVisible"
      width="30%"
      top="100vh"
      center>
      <ul class="details-list">
        <li v-for="details in orderDetails" :key="details.orderGoodsId">
          <custom-image
              width="60"
              height="60"
              :url="'/system/goods/getGoodsPicture/' + details.goodsId"
            ></custom-image>
          <span><el-tag>{{details.goods.goodsName}}</el-tag></span>
          <span><el-tag type="warning">{{details.goods.price}}元</el-tag></span>
          <span>x&nbsp;{{details.goodsAmount}}</span>
        </li>
      </ul>
      <span slot="footer" class="dialog-footer">
        <span style="font-size:18px;line-height: 35px;"><label>订单总价：</label>{{totalPrice}}元</span>
        <el-button type="primary" @click="detailsDialogVisible = false">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { listOrder, getOrder,getOrderDetails, delOrder, updateOrder, exportOrder } from "@/api/system/order";
import CustomImage from "@/components/CustomImage";
export default {
  name: "Order",
  components: {
    CustomImage
  },
  data() {
    return {
      // 详情弹出框
      detailsDialogVisible: false,
      detailsTitle: "",
      orderDetails:[],
      // 订单总价
      totalPrice: 0,
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 【请填写功能名称】表格数据
      orderList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        orderId: null,
        customerId: null,
        goodsId: null,
        orderTime: null,
        orderStatus: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        customerId: [
          { required: true, message: "用户id(外键)不能为空", trigger: "blur" }
        ],
        shopId: [
          { required: true, message: "店铺id(外键)不能为空", trigger: "blur" }
        ],
        goodsId: [
          { required: true, message: "商品id(外键)不能为空", trigger: "blur" }
        ],
        orderTime: [
          { required: true, message: "下单时间不能为空", trigger: "blur" }
        ],
        orderStatus: [
          { required: true, message: "订单状态不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
    
  },
  methods: {
    // 点击商品详情
    handleDetails(row){
      this.detailsDialogVisible = true;
      this.detailsTitle = "订单编号:"+row.orderNumber;
      // 发送获取详情请求
      getOrderDetails(row.orderId).then((result) => {
        this.orderDetails = result.data;
        let total = 0;
        result.data.forEach(item => {
          total += item.goods.price*item.goodsAmount;
        });
        this.totalPrice = total;
        console.log(result.data);
      }).catch((err) => {
        console.log(err);
      });
    },
    /** 查询【请填写功能名称】列表 */
    getList() {
      this.loading = true;
      listOrder(this.queryParams).then(response => {
        this.orderList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        orderId: null,
        customerId: null,
        shopId: null,
        goodsId: null,
        orderTime: null,
        orderStatus: "0"
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.orderId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const orderId = row.orderId || this.ids
      getOrder(orderId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改订单状态";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.orderId != null) {
            updateOrder(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const orderIds = row.orderId || this.ids;
      this.$confirm('是否确认删除订单编号为"' + orderIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delOrder(orderIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有【请填写功能名称】数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportOrder(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
<style scoped>
  .details-list{
    list-style: none;
    padding: 0;
  }
  .details-list li{
    display: flex;
    justify-content: start;
    align-items: center;
    /* gap: 20; */
    margin-bottom: 20px;
  }
  .details-list li span:nth-of-type(1){
    flex: 3;
    text-align: center;
  }
  .details-list li span:nth-of-type(2){
    flex: 3;
    text-align: center;
  }
  .details-list li span:nth-of-type(3){
    flex: 3;
    text-align: center;
    font-size: 18px;
  }
  .details-list li span{
    font-weight: bold;
  }
  /* 弹出框底部 */
  .dialog-footer{
    padding: 0;
    display: flex;
    justify-content: flex-end;
    align-content: center;
    gap: 30px;
  }
</style>