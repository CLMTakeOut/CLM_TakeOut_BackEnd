<template>
  <el-image
    class="image"
    :src="imgUrl"
    fit="cover"
    :style="{ width: width + 'px', height: height + 'px' }"
  >
    <div slot="placeholder" class="image-slot">Loging....</div>
  </el-image>
</template>

<script>
import { getGoodsPicture } from "@/api/system/goods";
import {getShopLogo} from '@/api/system/shop'
export default {
  data() {
    return {
      imgUrl: "",
    };
  },
  props: {
    url: String,
    width: String,
    height: String,
  },
  created() {
    // console.log("子组件:",this.url);
    //转换图片地址
    if (this.url !== "" && this.url !== undefined) {
      console.log("子组件:", this.url);
      let type = this.url.split("/")[2];
      console.log(type);
      switch (type) {
        case "goods":
          getGoodsPicture(this.url)
            .then((result) => {
              this.imgUrl = URL.createObjectURL(result);
            })
            .catch((err) => {
              console.log(err);
            });
          break;
        case "shop":
          getShopLogo(this.url).then((result) => {
              this.imgUrl = URL.createObjectURL(result);
          }).catch((err) => {
              console.log(err);
          });
          break;
        default:
          break;
      }
    }
  },
};
</script>

<style scoped>
.image {
  background-color: whitesmoke;
  object-fit: cover;
}
.image-slot {
  text-align: center;
  font-weight: bold;
  font-size: 20px;
}
</style>
