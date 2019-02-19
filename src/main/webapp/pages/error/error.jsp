<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<el-card shadow="hover">
  <el-container class="main">
    <h2>权限不足</h2>
  </el-container>
</el-card>
<%@ include file="../layout/footer.jsp" %>
<script>
  new Vue({
    el: '#app',
    mixins: [mixin],
    data() {
      return {
        navActive: ''
      }
    }
  })
</script>
</html>
