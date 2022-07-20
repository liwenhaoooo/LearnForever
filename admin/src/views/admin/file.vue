<template>
  <div>
    <p>
      <button v-on:click="list(1)" class="btn btn-white btn-default btn-round">
        <i class="ace-icon fa fa-refresh"></i>
        Refresh
      </button>
    </p>

    <pagination ref="pagination" v-bind:list="list" v-bind:itemCount="8"></pagination>

    <table id="simple-table" class="table  table-bordered table-hover">
      <thead>
      <tr>
            <th>id</th>
            <th>Relative paths</th>
            <th>File name</th>
            <th>Suffix</th>
            <th>Szie</th>
            <th>Uses</th>
            <th>Download link</th>
      </tr>
      </thead>

      <tbody>
      <tr v-for="file in files">
              <td>{{file.id}}</td>
              <td>{{file.path}}</td>
              <td>{{file.name}}</td>
              <td>{{file.suffix}}</td>
              <td>{{file.size | formatFileSize}}</td>
              <td>{{FILE_USE | optionKV(file.use)}}</td>
              <td>
                <a :href="getHref(file.path )" style="width:100%;margin-top: 5px;" name="mylink" class="my_link_button" download="111" >Download</a>
              </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
  import Pagination from "../../components/pagination";
  export default {
    components: {Pagination},
    name: "file-file",
    data: function() {
      return {
        file: {},
        files: [],
        FILE_USE: FILE_USE,
      }
    },
    mounted: function() {
      let _this = this;
      _this.$refs.pagination.size = 5;
      _this.list(1);
      // sidebar激活样式方法一
      // this.$parent.activeSidebar("file-file-sidebar");

    },
    methods: {
      /**
       * 获取下载文件的url
       */
      getHref:function(val){
        return 'https://learn-forever.oss-eu-west-1.aliyuncs.com/'+val+'?response-content-type=application/octet-stream'
      },
      /**
       * 获取下载文件的url
       */
      getFileName:function(val){
        return val
      },
      /**
       * 列表查询
       */
      list(page) {
        let _this = this;
        Loading.show();
        _this.$ajax.post(process.env.VUE_APP_SERVER + '/file/admin/file/list', {
          page: page,
          size: _this.$refs.pagination.size,
        }).then((response)=>{
          Loading.hide();
          let resp = response.data;
          _this.files = resp.content.list;
          _this.$refs.pagination.render(page, resp.content.total);

        })
      },
    }
  }
</script>
<style>
.my_link_button {
  display: block;
  width: 100px;
  height: 30px;
  background: #FFFAFA;
  margin-top: 20px;
  font-size: 8px;
  text-decoration:none;
  text-align: center;
  line-height: 28px;
  color:black;
}

.my_link_button_select {
  display: block;
  width: 100px;
  height: 30px;
  background: #0081c2;
  margin-top: 20px;
  font-size: 8px;
  text-decoration:none;
  text-align: center;
  line-height: 28px;
  color:white;
}

.my_link_button:hover {
  text-decoration: none;
  color: white;
  background: #0081c2
}
</style>