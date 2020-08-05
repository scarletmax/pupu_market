<%--
  Created by IntelliJ IDEA.
  User: wVim
  Date: 2020/8/4
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>商品详情</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=no, minimum-scale=0.8, initial-scale=1,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/lib/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/static/X-admin/lib/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/static/X-admin/js/xadmin.js"></script>
</head>
<body>
<div style="padding: 20px; background-color: #F2F2F2;">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">名称:<label id="name"></label></div>
                <div class="layui-card-body">
                    <div class="layui-card-header"></div>
                    <div class="layui-card-body">
                        <div>市场价：<label id="price"></label></div>
                        <div>一级分类：<label id="parentTypeString"></label></div>
                        <div>二级分类：<label id="typeString"></label></div>
                        <div>是否掌柜推荐：<label id="recommended"></label></div>
                        <div>是否特价：<label id="special"></label></div>
                        <div>特别价格：<label id="specialPrice"></label></div>
                        <div>剩余总数：<label id="totalCount"></label></div>
                        <div>状态：<label id="stateStr"></label></div>
                    </div>
                    <div class="layui-card-header">详细信息</div>
                    <div class="layui-card-body">
                        <div>介绍：<label id="intro"></label></div>
                        <div><p>图片：</p>
                            <button id="albumBtn">查看商品图册</button>
                        </div>
                        <div id="infoPicContent"><p>长图：</p>
                            <img id="infoPic"  src="">
                        </div>

                    </div>
                    <div class="layui-card-header">秒杀信息</div>
                    <div class="layui-card-body">
                        <span>AAAA</span>

                    </div>


                </div>
            </div>
        </div>

    </div>
</div>
<script>
    layui.use(['form', 'layer','jquery'], function() {
        var $ = layui.jquery;
        var form = layui.form;
        var  layer = layui.layer;
        var path =$("#path").val();



        $(function () {
            var data = window.parent.tempData;
            $("#name").text(data.name);
            $("#price").text(data.price);
            if(data.recommended==0){
                $("#recommended").text("否");
            }else{
                $("#recommended").text("是");
            }
            if(data.special==0){
                $("#special").text("否");
            }else{
                $("#special").text("是");
            }
            $("#specialPrice").text(data.specialPrice);
            $("#parentTypeString").text(data.parentTypeString);
            $("#typeString").text(data.typeString);
            $("#stateStr").text(data.stateStr);
            $("#totalCount").text(data.totalCount);
            $("#albumBtn").click(function () {
                layer.photos({
                    photos: data.album
                    ,anim: 5 //0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
                });
            })
            console.log(data.album);
            $("#infoPic").attr("src","${pageContext.request.contextPath}/upload/goods_pic/主板.jpg");
            layer.photos({
                photos: '#infoPicContent'
                ,anim: 5 //0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
            });

        })

    });
</script>
</body>
</html>
