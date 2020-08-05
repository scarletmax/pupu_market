<%--
  Created by IntelliJ IDEA.
  User: maaaax
  Date: 2020/7/5
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html  class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>后台登录-X-admin2.2</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/css/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/css/xadmin.css">

<%--    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>--%>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.js" charset="utf-8"></script>

    <script src="${pageContext.request.contextPath}/static/X-admin/lib/layui/layui.js" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/js/login.js" charset="utf-8"></script>

<%--    <!--[if lt IE 9]>--%>
<%--    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>--%>
<%--    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>--%>
<%--    <![endif]-->--%>
    <style>

        /* 元素 | http://localhost:8081/jsp/login.jsp */

        #bt {
            margin-left: 200px;
        }

    </style>
</head>
<body class="login-bg">
<input hidden value="${pageContext.request.contextPath}" id="path">

<div class="login layui-anim layui-anim-up">
    <div class="message">掌上超市分店管理系统</div>
    <div id="darkbannerwrap"></div>
    <div id="sbmit1">
    <form method="post" class="layui-form" >

        <input name="account" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
        <hr class="hr15">
        <input name="pwd" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
        <hr class="hr15">
        <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
        <hr class="hr20" >

     </form>
    </div>
    <div id="sbmit2" style="display: none">
        <form method="post" class="layui-form" >

            <input id="tel" name="tel" placeholder="请输入手机号"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input name="code" lay-verify="required" placeholder="短信验证码"  type="password" class="layui-input">
            <hr class="hr15">
            <button id="msg" class="layui-btn" type="button" >获取短信验证</button>
            <hr class="hr15">
            <input value="登录" lay-submit lay-filter="telLogin" style="width:100%;" type="submit">
            <hr class="hr20" >


        </form>
    </div>
    <div>
        <a href="<%=request.getContextPath()%>/jsp/regis.jsp" class="r_a"> <span style="font-size: larger"> >>>注册</span></a>
        <button id="bt" class="layui-btn" type="button" onclick="changeSbmit()">短信登录</button>

    </div>

</div>

</body>

<script>
    layui.use(['layer', 'laypage'],
        function () {
            var layer = layui.layer;
            var laypage = layui.laypage;
            var path = $('#path').val();

            $("#msg").click(function () {
                var tel=$("#tel").val();
                console.log("tel="+tel);
                if(tel.length>0){
                    $.ajax({
                        url:path+"/loginControl/telverify",
                        async:false,
                        type:"post",
                        data:"tel="+tel,
                        dataType:"text",
                        success:function (msg) {

                            if(msg==="success"){
                                layer.msg("已发送短信")
                            }else {
                                layer.msg("短信发送错误")
                            }
                        },
                        error:function () {

                            layer.msg("网络错误")

                        }

                    })
                }else {
                    layer.msg("请填写手机号")
                }

            })


        });
    function changeSbmit() {
        var  bt=$("#bt").text();
        console.log("bt="+ $("#bt").text());
        if(bt=="短信登录"){
            $("#bt").text("密码登录");
            $("#sbmit1").hide();
            $("#sbmit2").show();
        }else {
            $("#bt").text("短信登录");
            $("#sbmit2").hide();
            $("#sbmit1").show();
        }

    }




</script>

</html>
