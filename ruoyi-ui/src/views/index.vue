<template>
  <div class="home">
    <h2>这是首页</h2>
  </div>
</template>

<script>
export default {
  name: "index",
  data() {
    return {

    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
  },
};
</script>

<style scoped lang="scss">
.home{
  text-align: center;
}
</style>

