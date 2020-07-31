<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/30
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单详情</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/X-admin/css/font.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/X-admin/css/xadmin.css">
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/static/X-admin/lib/layui/css/modules/laydate/default/laydate.css">
    <%--    <script src="<%=request.getContextPath()%>/web/X-admin/lib/layui/lay/modules/jquery.js" charset="utf-8"></script>--%>
    <script src="<%=request.getContextPath()%>/static/js/jquery-3.5.1.js" charset="utf-8"></script>
    <script src="<%=request.getContextPath()%>/static/X-admin/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/X-admin/js/xadmin.js"></script>
    <script src="<%=request.getContextPath()%>/static/layui/lay/modules/form.js" charset="utf-8"></script>

</head>
<body>
<input type="hidden" value="<%=request.getContextPath()%>" id="path">
<div style="padding: 20px; background-color: #F2F2F2;">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">订单编号:<label id="orderNum"></label></div>
                <div class="layui-card-body">
                    <div class="layui-card-header"><h2>收货人：<label id="name"></label></h2></div>
                    <div class="layui-card-body">
                        <div>地址：<label id="address"></label></div>
                        <div>门牌号：<label id="roomNum"></label></div>
                        <div>电话：<label id="tel"></label></div>
                        <div>创建时间:<label id="createTime"></label></div>
                        <div>到达时间：<label id="receiveTime"></label></div>
                        <div>结束时间：<label id="finishTime"></label></div>
                        <div>订单账号：<label id="userName"></label></div>
                    </div>

                        <div class="layui-card-header"><h2>商店名：<label id="shopName"></label></h2></div>
                    <div class="layui-card-body">
                        <label id="goodsInf"></label>

                    </div>

                        <div class="layui-card-header"><h2>快递员：<label id="deliverymanName"></label></h2></div>
                    <div class="layui-card-body">
                        <div>快递评价:<label id="deliveryComment"></label></div>
                        <div>评价时间:<label id="deliverytime"></label></div>
                        <div>当前评分:<label id="deliverymanScore"></label></div>
                    </div>
                    <div class="layui-card-header"><h2>优惠券：<label id="dcouponName"></label></h2></div>
                    <div class="layui-card-body">
                        <label id="dcouponInf"></label>

                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

</body>

<script>
    ;layui.use('table', function () {

        var orderInf = parent.orderInf;

        var path = $("#path").val();

        $("#orderNum").text(orderInf.orderNum);
        $("#name").text(orderInf.name);
        $("#address").text(orderInf.address);
        $("#roomNum").text(orderInf.roomNum);
        $("#tel").text(orderInf.tel);
        // {{#if(d.createTime!=null){}}{{layui.util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')}}{{#} }}
        $("#createTime").text(orderInf.createTime);
        $("#receiveTime").text(orderInf.receiveTime);
        $("#finishTime").text(orderInf.finishTime);
        $("#userName").text(orderInf.userName);
        $("#shopName").text(orderInf.shopName);
        $("#goodsName").text(orderInf.goodsName);
        $("#goodsComment").text(orderInf.goodsComment);
        $("#deliverymanName").text(orderInf.deliverymanName);
        $("#deliveryComment").text(orderInf.deliveryComment);
        $("#deliverytime").text(orderInf.deliverytime);
        $("#dcouponName").text(orderInf.couponName)

        var id = orderInf.id;
        var couponId=orderInf.couponId;
        console.log("couponId="+couponId);

        $(function () {
            $.ajax({
                url: path + "/CommentControl/findDeliverymanComment",
                async: true,
                type: "post",
                data: "id=" + id,
                dataType: "json",
                success: function (msg) {

                    console.log(msg);
                    if (msg.length > 0) {
                        $("#deliveryComment").text(" " + msg[0].comment);
                        $("#deliverymanScore").text(" " + msg[0].point + "分");
                        $("#deliverytime").text(" " + msg[0].createTime);
                    }


                }

            })

        });
        $.ajax({
            url: path + "/CommentControl/findGoodsComment",
            async: true,
            type: "post",
            data: "id=" + id,
            dataType: "json",
            success: function (msg) {

                console.log(msg);

                $(msg).each(function (i) {

                    $("#goodsInf").append(

                        " <div class=\"layui-card-body\"><div >商品名：<label id=\"goodsName\">" + msg[i].goodsName + "</label></div>\n" +
                        "<div>评价：<label id=\"goodsComment\">" + msg[i].comment + "</label></div>" +
                        "                    <div>评价时间：<label id=\"goodsComment\">" + msg[i].createTime + "</label></div></div>" +

                        "  </div>")

                });
                // $("#deliveryComment").text(" "+msg[0].comment);
                // $("#deliverymanScore").text(" "+msg[0].point+"分");
                // $("#deliverytime").text(" "+msg[0].createTime);
            }
        });
        $.ajax({
            url: path + "/couponControl/findCouponUser",
            async: true,
            type: "post",
            data: "id=" + couponId,
            dataType: "json",
            success: function (msg) {

                console.log(msg);

                $(msg).each(function (i) {

                    $("#dcouponInf").append(

                        " <div class=\"layui-card-body\">" +
                        " <div>使用时间:<label id=\"dcouponTime\">"+msg[i].createTime+"</label></div>\n" +
                        " <div>状态:<label id=\"dcouponRule\">" + msg[i].stateStr + "</label></div>"+
                        // " <div>规则:<label id=\"dcouponRule\">" + msg[i].rule + "</label></div>"+

                        "</div>" +

                        "  </div>")

                });
            }
        })



    });


</script>

</html>
