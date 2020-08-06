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

        /* 元素 | http://localhost:8081/jsp/login.jsp */

        #msg2 {
            /* margin-left: 5px; */
            /* margin-left: 2px; */
            margin-left: 160px;
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
        <button id="forgetPwd" class="layui-btn" type="button" onclick="forgetPassword()">忘记密码</button>
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
    <div id="sbmit3" style="display: none">
        <form method="post" class="layui-form" >

            <input id="newPwd" name="newPwd" placeholder="请输入新的密码"  type="password" lay-verify="required" class="layui-input" onblur="passNull()">
            <hr class="hr15">
            <input id="oldPwd" name="oldPwd" placeholder="请输入新的密码"  type="password" lay-verify="required" class="layui-input" onblur="npassNull()" >
            <hr class="hr15">
            <input id="tel2" name="tel" placeholder="请输入手机号"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input name="code" lay-verify="required" placeholder="短信验证码"  type="text" class="layui-input">
            <hr class="hr15">
            <button id="forgetPwd2" class="layui-btn" type="button" onclick="forgetPassword2()" >密码登录</button>
            <button id="msg2" class="layui-btn" type="button" >获取短信验证</button>
            <hr class="hr15">
            <input value="保存密码" lay-submit lay-filter="changePwd" style="width:100%;" type="submit">
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
//短信登录
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
                        beforeSend:function () {
                            console.log("beforesend=====")

                            $("#msg").attr("disabled",true);
                            // $("#msg").setAttribute("disabled", true);

                            settime();
                        },
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

            });
            //忘记密码短信验证
            $("#msg2").click(function () {
                var tel=$("#tel2").val();
                console.log("tel2="+tel);
                if(tel.length>0){
                    $.ajax({
                        url:path+"/loginControl/telverify",
                        async:false,
                        type:"post",
                        data:"tel="+tel,
                        dataType:"text",
                        beforeSend:function () {
                            console.log("beforesend=====")

                            $("#msg").attr("disabled",true);
                            // $("#msg").setAttribute("disabled", true);

                            settime();
                        },
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
        if(bt==="短信登录"){
            $("#bt").text("密码登录");
            $("#sbmit1").hide();
            $("#sbmit2").show();
        }else {
            $("#bt").text("短信登录");
            $("#sbmit2").hide();
            $("#sbmit1").show();
        }
        $("#sbmit3").hide();
    }

    function forgetPassword() {
        var  forgetPwd=$("#forgetPwd").text();
        // var  forgetPwd2=$("#forgetPwd2").text();
        console.log("forgetPwd="+ $("#forgetPwd").text());
        if(forgetPwd==="忘记密码"){
            $("#forgetPwd2").text("密码登录");
            $("#sbmit1").hide();
            $("#sbmit3").show();
        }

    }
    function forgetPassword2() {
        // var  forgetPwd=$("#forgetPwd").text();
        var  forgetPwd2=$("#forgetPwd2").text();
        console.log("forgetPwd2="+ $("#forgetPwd2").text());

        if(forgetPwd2==="密码登录"){
            $("#forgetPwd").text("忘记密码");
            $("#sbmit3").hide();
            $("#sbmit1").show();
        }
    }

    function passNull() {
        var newPwd=$("#newPwd").val();
        //密码的规则： 6-16，包含任意的字母、数字，不可以使用其他符号
        var reg = /^([a-zA-Z0-9]){6,16}$/i;
        if(reg.test(newPwd)){
            // $("#sp2").text("符合要求");
            return true;
        }else{
            layer.msg("6-16，包含任意的字母、数字，不可以使用其他符号");
            return false;
        }
    }

    function npassNull() {

        var newPwd = $("#newPwd").val();
        var oldPwd = $("#oldPwd").val();
        console.log("newPwd=" + newPwd);
        console.log("oldPwd=" + oldPwd);
        var reg = /^([a-zA-Z0-9]){6,12}$/i;
        if (reg.test(oldPwd)) {
            if (newPwd === oldPwd) {
                // $(".nPassword").text("符合要求");
                console.log("符合要求");
                return true;
            } else {
                layer.msg("密码输入不一样");
                console.log("密码输入不一样");
                return false;
            }

        } else {
            layer.msg("请填写6到12位密码");
            console.log("请填写6到12位密码");
            return false;
        }
    }

    var countdown=60;
    function settime() {
        var m=$("#msg");

        if (countdown == 0) {
            m.attr("disabled", false);
            m.text("获取短信验证");
            countdown = 60;
            return;
        } else {
            m.attr("disabled", true);
            m.text("重新发送(" + countdown + ")");
            countdown--;
        }
        setTimeout(function() {
            settime()
        },1000)
    }


</script>

</html>
