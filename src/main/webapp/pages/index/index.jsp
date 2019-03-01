<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<div align="center">
  <canvas id="q" width="1920" height="900"></canvas>
</div>

<%@ include file="../layout/footer.jsp" %>


<script>
  $(document).ready(function () {
    $('.el-main').css('padding','0')
    //设备宽度
    var s = window.screen;
    var width = q.width = s.width;
    var height = q.height;
    var yPositions = Array(300).join(0).split('');
    var ctx = q.getContext('2d');
    var draw = function () {
      ctx.fillStyle = 'rgba(0,0,0,.05)';
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
        navActive: '0'
      }
    }
  })
</script>
</html>
