<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="店铺名" prop="shopName">
        <el-input
          v-model="queryParams.shopName"
          placeholder="请输入店铺名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系人" prop="shopContacts">
        <el-input
          v-model="queryParams.shopContacts"
          placeholder="请输入联系人"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="联系电话" prop="shopTelephone">
        <el-input
          v-model="queryParams.shopTelephone"
          placeholder="请输入联系电话"
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
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:shop:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:shop:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="shopList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="店铺ID" align="center" prop="shopId" />
      <el-table-column label="店铺名" align="center" prop="shopName">
        <template slot-scope="scope">
          <el-tag effect="dark">{{scope.row.shopName}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="店铺地址" align="center" prop="shopAddress" />
      <el-table-column label="联系人" align="center" prop="shopContacts">
        <template slot-scope="scope">
          <el-tag type="success">{{scope.row.shopContacts}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="联系电话" align="center" prop="shopTelephone" />
      <el-table-column label="店铺logo" align="center" prop="shopLogo" >
        <template slot-scope="scope">
          <CustomImage 
            :key="uploadImgUrl"
            width="50"
            height="50"
            :url="`/system/shop/getShopLogo/${scope.row.shopId}`"
          ></CustomImage>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:shop:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:shop:remove']"
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
        <el-form-item label="店铺名" prop="shopName">
          <el-input v-model="form.shopName" placeholder="请输入店铺名" />
        </el-form-item>
        <el-form-item label="店铺地址" prop="shopAddress">
          <el-input v-model="form.shopAddress" placeholder="请输入店铺地址" />
        </el-form-item>
        <el-form-item label="联系人" prop="shopContacts">
          <el-input v-model="form.shopContacts" placeholder="请输入联系人" />
        </el-form-item>
        <el-form-item label="联系电话" prop="shopTelephone">
          <el-input type="tel" v-model="form.shopTelephone" placeholder="请输入联系电话" />
        </el-form-item>
        <!-- 上传店铺logo图片 -->
        <el-form-item label="店铺Logo">
          <el-row>
            <el-col :span="16">
              <el-upload
                v-if="uploadImgUrl === '' ? false : true"
                class="upload-demo"
                ref="upload"
                :action="upload.url"
                :headers="upload.headers"
                name="shopLog"
                :data="{ 'shopId': form.shopId }"
                :file-list="upload.fileList"
                list-type="picture"
                :auto-upload="false"
              >
                <el-button slot="trigger" size="small" type="primary"
                  >选择商品图片</el-button
                >
                <el-button
                  style="margin-left: 10px"
                  size="small"
                  type="success"
                  @click="submitUpload"
                  >点击上传</el-button
                >
                <div slot="tip" class="el-upload__tip">
                  只能上传jpg/png文件，且不超过500kb
                </div>
              </el-upload>
              <el-upload
                v-if="uploadImgUrl === '' ? true : false"
                ref="addupload"
                :action="upload.url"
                :headers="upload.headers"
                name="shopLog"
                :data="{ 'shopId': shopId }"
                :file-list="upload.fileList"
                list-type="picture"
                :auto-upload="false"
              >
                <el-button slot="trigger" size="small" type="primary"
                  >选择商品图片</el-button
                >
                <div slot="tip" class="el-upload__tip">
                  只能上传jpg/png文件，且不超过500kb
                </div>
              </el-upload>
            </el-col>
            <el-col :span="8">
              <custom-image
                :key="uploadImgUrl"
                ref="uploadImg"
                width="100"
                height="100"
                v-if="uploadImgUrl === '' ? false : true"
                :url="uploadImgUrl"
              ></custom-image>
            </el-col>
          </el-row>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listShop, getShop, delShop, addShop, updateShop, exportShop } from "@/api/system/shop";
import CustomImage from '../../../components/CustomImage/index';
import { getToken } from "@/utils/auth";
export default {
  name: "Shop",
  components: {
    CustomImage
  },
  data() {
    return {
      // 上传图片的路径
      uploadImgUrl:"",
      // 上传参数
      shopId:0,
      upload: {
        // 设置上传的请求头部
        headers: { Authorization: "Bearer " + getToken() },
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/system/shop/upload/logo",
        // 上传的文件列表
        fileList: [],
      },
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
      shopList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        shopName: null,
        shopAddress: null,
        shopContacts: null,
        shopTelephone: null,
        shopLogo: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        shopName: [
          { required: true, message: "店铺名不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    submitUpload() {
      this.$refs.upload.submit();
      setTimeout(() => {
        this.$refs.upload.clearFiles();
        this.$message({
          message: "图片上传成功！",
          type: "success",
        });
        this.uploadImgUrl = `/system/shop/getShopLogo/${this.form.shopId}?time=${new Date().getTime()}`;
        console.log("图片地址：" + this.$refs.uploadImg.url);
      }, 500);
    },
    /** 查询【请填写功能名称】列表 */
    getList() {
      this.loading = true;
      listShop(this.queryParams).then(response => {
        this.shopList = response.rows;
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
        shopId: null,
        shopName: null,
        shopAddress: null,
        shopContacts: null,
        shopTelephone: null,
        shopLogo: null
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
      this.ids = selection.map(item => item.shopId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "新增店铺";
      this.uploadImgUrl = "";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const shopId = row.shopId || this.ids
       this.uploadImgUrl =
        "/system/shop/getShopLogo/" + shopId + "?time=" + new Date().getTime();
      getShop(shopId).then(response => {
        // 删除this.form对象中的goodsLogo
        delete response.data["shopLogo"];
        this.form = response.data;
        this.open = true;
        this.title = "修改店铺信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.shopId != null) {
            updateShop(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addShop(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
              // 遍历当前的店铺列表
              // goodsList
              setTimeout(() => {
                this.shopList.forEach((shop) => {
                  if (shop.shopName === this.form.shopName) {
                    this.shopId =  parseInt(shop.shopId);
                    this.$refs.addupload.data.shopId = parseInt(shop.shopId);
                    console.log(this.$refs.addupload.data);
                    // 上传店铺Logo
                    this.$refs.addupload.submit();
                    setTimeout(() => {
                      this.$refs.addupload.clearFiles();
                      this.uploadImgUrl = `/system/shop/getShopLogo/${shop.shopId}?time=${new Date().getTime()}`;
                    }, 200);
                    // this.submitUpload();
                  }
                });
              }, 500);
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const shopIds = row.shopId || this.ids;
      this.$confirm('是否确认删除店铺编号为"' + shopIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delShop(shopIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有店铺信息数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportShop(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
