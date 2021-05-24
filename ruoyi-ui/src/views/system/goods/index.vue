<template>
  <div class="app-container">
    <el-form
      :model="queryParams"
      ref="queryForm"
      :inline="true"
      v-show="showSearch"
      label-width="68px"
    >
      <el-form-item label="店铺名字" prop="shopName">
        <el-input
          v-model="queryParams.shopName"
          placeholder="请输入店铺名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品名" prop="goodsName">
        <el-input
          v-model="queryParams.goodsName"
          placeholder="请输入商品名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="商品价格" prop="price">
        <el-input
          v-model="queryParams.price"
          placeholder="请输入商品价格"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="销售量" prop="salesvolume">
        <el-input
          v-model="queryParams.salesvolume"
          placeholder="请输入销售量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery"
          >搜索</el-button
        >
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
          v-hasPermi="['system:goods:add']"
          >新增</el-button
        >
      </el-col>

      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:goods:export']"
          >导出</el-button
        >
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table
      v-loading="loading"
      :data="goodsList"
      @selection-change="handleSelectionChange"
    >
      <!-- 展开行 -->
      <el-table-column type="expand">
        <template slot-scope="props">
          <div class="expand-container">
            <custom-image
              width="450"
              height="280"
              :url="'/system/goods/getGoodsPicture/' + props.row.goodsId"
            ></custom-image>
            <ul class="expand-container-right">
              <li>
                <el-tag type="success">商品描述</el-tag>
                <p>{{ props.row.goodsDescribe }}</p>
              </li>
              <li>
                <el-tag type="success">美食评分</el-tag
                ><el-rate
                  :disabled="true"
                  v-model="props.row.score"
                  :colors="['#99A9BF', '#F7BA2A', '#FF9900']"
                >
                </el-rate>
              </li>
            </ul>
          </div>
        </template>
      </el-table-column>
      <!-- 其它列 -->
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="商品ID" align="center" prop="goodsId" />
      <el-table-column label="店铺名" align="center">
        <template slot-scope="scope">
          <el-tag >{{ scope.row.shopName }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="商品名" align="center">
        <template slot-scope="scope">
          <el-tag type="warning">{{ scope.row.goodsName }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="商品图片" align="center">
        <template slot-scope="scope">
          <custom-image
              :key="uploadImgUrl"
              width="50"
              height="50"
              :url="'/system/goods/getGoodsPicture/' + scope.row.goodsId"
            ></custom-image>
        </template>
      </el-table-column>
      <el-table-column label="商品价格" align="center" prop="price">
        <template slot-scope="scope">
          <el-tag type="success">{{scope.row.price+"元"}}</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="销售量" align="center" prop="salesvolume" />
      <el-table-column label="是否推荐商品" align="center">
        <template slot-scope="scope">
          <el-switch
            disabled
            v-model="scope.row.goodsRecommend"
            active-color="#13ce66"
            inactive-color="#ff4949"
            :active-value="1"
            :inactive-value="0"
          >
          </el-switch>
        </template>
      </el-table-column>
      <!-- <el-table-column label="评分" align="center" prop="score" />
      <el-table-column label="详细描述" align="center" prop="goodsDescribe" />
      <el-table-column label="商品图片" align="center" prop="goodsLogo" /> -->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:goods:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:goods:remove']"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total > 0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form :key="form.goodsId" ref="form" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="店铺名称" prop="shopId">
          <el-select v-model="form.shopId" placeholder="请选择店铺">
            <el-option
              :key="shop.shopId"
              :label="shop.shopName"
              :value="shop.shopId"
              v-for="shop in shopList"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="商品名" prop="goodsName">
          <el-input v-model="form.goodsName" placeholder="请输入商品名" />
        </el-form-item>
        <el-form-item label="商品价格" prop="price">
          <el-input type="number" v-model="form.price" placeholder="请输入商品价格" />
        </el-form-item>
        <el-form-item label="是否推荐商品">
          <template slot-scope="scope">
            <el-switch
              v-model="form.goodsRecommend"
              active-color="#13ce66"
              inactive-color="#ff4949"
              :active-value="1"
              :inactive-value="0"
            >
            </el-switch>
          </template>
        </el-form-item>
        <!-- 上传商品图片 -->
        <el-form-item label="商品图片">
          <el-row>
            <el-col :span="16">
              <el-upload
                v-if="uploadImgUrl === '' ? false : true"
                class="upload-demo"
                ref="upload"
                :action="upload.url"
                :headers="upload.headers"
                name="picture"
                :data="{ 'goodsId': form.goodsId }"
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
                name="picture"
                :data="{ 'goodsId': goodsId }"
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
        <el-form-item label="详细描述" prop="goodsDescribe">
          <el-input
            type="textarea"
            :rows="3"
            v-model="form.goodsDescribe"
            placeholder="商品的详细描述"
          />
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
import {
  listGoods,
  getGoods,
  delGoods,
  addGoods,
  updateGoods,
  exportGoods,
} from "@/api/system/goods";
import { listShop } from "@/api/system/shop";
import { getToken } from "@/utils/auth";
import CustomImage from "@/components/CustomImage";
export default {
  name: "Goods",
  components: {
    CustomImage,
  },
  data() {
    return {
      // 上传参数
      goodsId:0,
      upload: {
        // 设置上传的请求头部
        headers: { Authorization: "Bearer " + getToken() },
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + "/system/goods/upload/picture",
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
      // 店铺名字列表
      shopList: [],
      // 【请填写功能名称】表格数据
      goodsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        shopName: null,
        goodsName: null,
        price: null,
        salesvolume: null,
        score: null,
      },
      uploadImgUrl: "",
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        shopName: [{ required: true, message: "店铺名字不能为空", trigger: "blur" }],
      },
    };
  },
  watch: {},
  // 组件加载后
  created() {
    this.getList();
    this.getShopNameList();
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
        this.uploadImgUrl = `/system/goods/getGoodsPicture/${this.form.goodsId}?time=${new Date().getTime()}`;
        console.log("图片地址：" + this.$refs.uploadImg.url);
      }, 500);
    },
    /*获得店铺名字列表*/
    getShopNameList() {
      listShop({}).then((response) => {
        let shopList = [];
        response.rows.forEach((shop) => {
          shopList.push({
            shopId: shop.shopId,
            shopName: shop.shopName,
          });
        });
        this.shopList = shopList;
      });
    },
    /** 查询【请填写功能名称】列表 */
    getList() {
      this.loading = true;
      listGoods(this.queryParams).then((response) => {
        this.goodsList = response.rows;
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
        goodsId: null,
        shopId: null,
        shopName: null,
        goodsName: null,
        price: null,
        salesvolume: null,
        score: null,
        describe: null,
        goodsLogo: null,
        goodsRecommend: null,
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
      this.ids = selection.map((item) => item.goodsId);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加商品";
      this.uploadImgUrl = "";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const goodsId = row.goodsId || this.ids;
      this.uploadImgUrl =
        "/system/goods/getGoodsPicture/" + goodsId + "?time=" + new Date().getTime();
      // console.log(this.uploadImgUrl);
      getGoods(goodsId).then((response) => {
        // 删除this.form对象中的goodsLogo
        delete response.data["goodsLogo"];
        // console.log(response.data);
        this.form = response.data;
        this.open = true;
        this.title = "修改商品信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate((valid) => {
        if (valid) {
          if (this.form.goodsId != null) {
            updateGoods(this.form).then((response) => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            delete this.form["goodsLogo"];
            addGoods(this.form).then((response) => {
              console.log(response);
              this.getList();
              // 遍历当前的商品列表
              // goodsList
              setTimeout(() => {
                this.goodsList.forEach((goods) => {
                  if (goods.goodsName === this.form.goodsName) {
                    this.goodsId =  parseInt(goods.goodsId);
                    this.$refs.addupload.data.goodsId = parseInt(goods.goodsId);
                    console.log(this.$refs.addupload.data);
                    // 上传商品图片
                    this.$refs.addupload.submit();
                    setTimeout(() => {
                      this.$refs.addupload.clearFiles();
                      this.uploadImgUrl = `/system/goods/getGoodsPicture/${goods.goodsId}?time=${new Date().getTime()}`;
                    }, 200);
                    // this.submitUpload();
                  }
                });
              }, 500);
              this.open = false;
              this.msgSuccess("新增成功");
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const goodsIds = row.goodsId || this.ids;
      this.$confirm('是否确认删除商品编号为"' + goodsIds + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(function () {
          return delGoods(goodsIds);
        })
        .then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        });
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm("是否确认导出所有商品信息数据项?", "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(function () {
          return exportGoods(queryParams);
        })
        .then((response) => {
          this.download(response.msg);
        });
    },
  },
};
</script>
<style scoped>
.expand-container {
  width: 100%;
  height: 300px;
  display: flex;
  padding: 0 15% 0;
  justify-content: center;
  align-items: center;
  background-color: wheat;
}
.expand-container-right {
  width: 70%;
  list-style: none;
}
.expand-container-right li:nth-child(1) {
  display: flex;
  align-items: flex-start;
  margin-bottom: 10px;
}
.expand-container-right li:nth-child(1) p {
  margin: 0;
  text-indent: 20px;
  line-height: 20px;
  letter-spacing: 2px;
}
.expand-container-right li {
  display: flex;
  align-items: center;
  gap: 10px;
}
/* 商品图片 */
.goods-picture {
  width: 300px;
  height: 300px;
  object-fit: cover;
}
/* 搜索框 */
</style>
