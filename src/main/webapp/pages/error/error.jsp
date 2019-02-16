<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>
<!-- Form -->

<el-card shadow="hover">
  <el-container class="main">
    <h2>权限不足</h2>
  </el-container>
</el-card>
</el-main>
<el-footer>{{footer}}</el-footer>
</el-container>
</el-container>
</el-container>
</div>
</body>
<script>
  new Vue({
    el: '#app',
    mixins: [mixin]
  })
</script>
</html>
