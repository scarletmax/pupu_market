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


</head>
<body>
<input type="hidden" value="<%=request.getContextPath()%>" id="path">
<br/>
<form class="layui-form" action="" lay-filter="myForm">
    <div class="layui-form-item">
        <label class="layui-form-label">账号</label>
        <div class="layui-input-inline">
            <input id="account" name="account" class="layui-input" type="text" placeholder="请输入账号" autocomplete="off" lay-verify="required"
                   lay-reqtext="账号是必填项，不能为空？" onblur="verify()">
        </div>
        <div class="layui-form-mid layui-word-aux" ><span id="verify"></span></div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-inline">
            <input name="userName" class="layui-input" type="text" placeholder="请输入" autocomplete="off" lay-verify="required" lay-reqtext="用户名是必填项，不能为空？">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">验证手机</label>
            <div class="layui-input-inline">
                <input name="tel" class="layui-input" type="tel" autocomplete="off" lay-verify="required|phone" lay-reqtext="验证手机是必填项，不能为空？">
            </div>
        </div>

    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input name="pwd" class="layui-input" type="password" placeholder="请输入密码" autocomplete="off" lay-verify="pass" lay-reqtext="密码是必填项，不能为空？">
        </div>
        <div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>
    </div>


    <div class="layui-form-item">
        <label class="layui-form-label">商店</label>
        <div class="layui-input-inline">
            <select name="shopId" lay-filter="aihao" id="sel">

            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" type="button" lay-filter="demo1" lay-submit="">立即提交</button>
            <button class="layui-btn layui-btn-primary" type="reset">重置</button>
        </div>
    </div>
</form>


</body>

<script>
    layui.use(['table','form','layer'], function () {
        var form = layui.form;
        var table = layui.table;
        var layer = layui.layer;
        var $  = layui.jquery;

        var path=$("#path").val();


        $(function () {
            $.ajax({
                url: path + "/shopControl/shopList",
                async: true,
                type: "post",
                dataType: "json",
                success: function (msg) {

                    console.log(msg);
                    $(msg).each(function (i) {

                        $("#sel").append(
                               " <option class='op' value="+msg[i].id+">"+msg[i].name+"</option>"
                           )

                    });
                    form.render();
                }

            })

        });
        form.on('submit(demo1)', function(data){
            // layer.alert(JSON.stringify(data.field), {
            //     title: '最终的提交信息'
            // });
            $.ajax({
                url: path + "/shopControl/insertShopAdmin",
                async: true,
                type: "post",
                data:data.field,
                dataType: "text",
                success: function (msg) {

                    console.log(msg);
                    if(msg==="success"){

                        layer.msg("创建成功");
                        setTimeout(function () {
                            var index = parent.layer.getFrameIndex(window.name);//关闭当前窗口
                            parent.layer.close(index);
                        },1500)

                        // parent.location.reload();//刷新当前窗口

                    }else {
                        layer.msg("创建失败")
                    }
                }
                ,error:function () {
                    layer.msg("网络失败")
                }
            });
            return false;
        });

    });

    function verify() {

        console.log($("#account").val());
        var account=$("#account").val();
        if(account.length>0){
            var path=$("#path").val();
            $.ajax({
                url:path+"/shopControl/verifyAccount",
                async:true,
                type:"post",
                data:"account="+account,
                dataType:"Text",
                success:function (msg) {

                    console.log(msg);
                    if(msg=="success"){

                        // alert("账号可以使用")
                        $("#verify").text("账号可以使用");
                        console.log( $("#verify").text());
                    }else if(msg=="fail"){
                        // alert("账号已被注册");
                        $("#verify").text("账号已被注册");

                    }
                }
            })
        }else {
            $("#verify").text("账号不能为空")
        }
    }



</script>

</html>
