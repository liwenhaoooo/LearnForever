<template>
  <div>
    <h1>您好，欢迎进入管理系统</h1>
  </div>
</template>

<script>
export default {
  name: "welcome",
  mounted:function (){
  this.$parent.activeSidebar("welcome-sidebar");
  },
  methods:{
  }
}
</script>
