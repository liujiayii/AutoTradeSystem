<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<div align="center" @click="show = !show">
  <canvas id="q" width="1920" height="900"></canvas>
</div>
<div @click="show = !show" class="index" style="position: absolute;top:10%;left: 10%">
  <transition name="el-zoom-in-top">
    <h3 v-show="show" class="title" style="font-size: 32px; color: #fff;">欢迎使用喔驰管理系统</h3>
  </transition>
  <transition name="el-zoom-in-center">
    <div v-show="show" style="background: url('/static/img/1.png');width: 1400px;height: 594px"></div>
  </transition>
</div>
<%@ include file="../layout/footer.jsp" %>


<script>
  $(document).ready(function () {
    $('.el-main').css('padding', '0').css('position', 'relative')
    //设备宽度
    var s = window.screen;
    var width = q.width = s.width;
    var height = q.height;
    var yPositions = Array(300).join(0).split('');
    var ctx = q.getContext('2d');
    var draw = function () {
      ctx.fillStyle = 'rgba(25,25,30,.05)';
      ctx.fillRect(0, 0, width, height);
      ctx.fillStyle = 'green';/*代码颜色*/
      ctx.font = '10pt Georgia';
      yPositions.map(function (y, index) {
        text = String.fromCharCode(1e2 + Math.random() * 330);
        x = (index * 10) + 10;
        q.getContext('2d').fillText(text, x, y);
        if (y > Math.random() * 1e4) {
          yPositions[index] = 0;
        } else {
          yPositions[index] = y + 10;
        }
      });
    };
    RunMatrix();

    function RunMatrix() {
      Game_Interval = setInterval(draw, 30);
    }
  });
</script>
<script>
  new Vue({
    el: '#app',
    mixins: [mixin],
    data: function () {
      return {
        navActive: '0',
        show: false
      }
    },
    mounted() {
      this.show = !this.show
    }
  })
</script>
</html>
