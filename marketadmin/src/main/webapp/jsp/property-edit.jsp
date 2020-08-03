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
        <label class="layui-form-label">参数名称中文</label>
        <div class="layui-input-inline">
            <input name="typeText" class="layui-input" type="text" disabled="disabled" placeholder="请输入"
                   autocomplete="off" id="typeText">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">参数名称英文</label>
        <div class="layui-input-inline">
            <input name="type" class="layui-input" type="text" disabled="disabled" placeholder="请输入" autocomplete="off"
                   id="type">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">属性名</label>
            <div class="layui-input-inline">
                <input name="name" class="layui-input" type="tel" autocomplete="off" lay-verify="required"
                       id="name" lay-reqtext="不能为空？" onblur="haveName(this.value)">
            </div>
            <div class="layui-form-mid layui-word-aux" id="namePrompt">选择修改的属性名</div>
        </div>

    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">属性值</label>
        <div class="layui-input-inline">
            <input name="value" class="layui-input" type="number" placeholder="请输入密码" autocomplete="off" id="value"
                   lay-reqtext="不能为空？" onblur="haveValue(this.value)">
        </div>
        <div class="layui-form-mid layui-word-aux" id="valuePrompt">选择修改的属性值</div>
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


    layui.use(['table', 'form', 'layer'], function () {

        var form = layui.form;
        var table = layui.table;
        var layer = layui.layer;
        var $ = layui.jquery;

        var propertyDate = parent.propertyDate;

        $("#name").attr("placeholder", propertyDate.name);
        $("#typeText").attr("placeholder", propertyDate.typeText);
        $("#type").attr("placeholder", propertyDate.type);
        $("#value").attr("placeholder", propertyDate.value);


        var path = $("#path").val();


        form.on('submit(demo1)', function (data) {
            // layer.alert(JSON.stringify(data.field), {
            //     title: '最终的提交信息'
            // });
            var propertyDate = parent.propertyDate;

            $.ajax({
                url: path + "/propertyControl/changeProperty",
                async: true,
                type: "post",
                data: {"value":$("#value").val(),"name":$("#name").val(),"type":propertyDate.type,"id":propertyDate.id},
                dataType: "text",
                success: function (msg) {

                    console.log(msg);
                    if (msg === "success") {

                        layer.msg("更改成功");
                        // setTimeout(function () {
                        //     var index = parent.layer.getFrameIndex(window.name);//关闭当前窗口
                        //     parent.layer.close(index);
                        // }, 1500)
                        setTimeout(function () {
                            parent.location.reload();//刷新当前窗口
                            parent.layer.close(index);
                        }, 1000)


                    } else {
                        layer.msg("更改失败")
                    }
                }
                , error: function () {
                    layer.msg("网络失败")
                }
            });
            return false;
        });

    });

    function haveName(node) {
        var propertyDate = parent.propertyDate;
        var path = $("#path").val();
        var value=propertyDate.value;
        var type=propertyDate.type;
        console.log("value=="+value);
        console.log("type="+type);
        console.log("node=="+node);
        if(node!=null&&node!==""){
            $.ajax({
                url: path + "/propertyControl/haveName",
                async: true,
                type: "post",
                data: {"value":propertyDate.value,"name":node,"type":propertyDate.type},
                dataType: "text",
                success: function (msg) {

                    if(msg==="success"){
                        layer.msg("存在相同的名称");
                        $("#namePrompt").text("存在相同的名称")

                    }else {
                        layer.msg("可以使用")
                        $("#namePrompt").text("可以使用")
                    }

                }
            })
        }

    }
    function haveValue(node) {
        var propertyDate = parent.propertyDate;
        var path = $("#path").val();
        var value=propertyDate.value;
        var type=propertyDate.type;
        var name=$("#name").val();
        console.log("value=="+value);
        console.log("type="+type);
        console.log("node=="+node);

            if(name!=null&&name!==""){
                $.ajax({
                    url: path + "/propertyControl/haveValue",
                    async: true,
                    type: "post",
                    data: {"value":node,"name":name,"type":propertyDate.type},
                    dataType: "text",
                    success: function (msg) {

                        if(msg==="success"){
                            layer.msg("存在相同的名称");
                            $("#namePrompt").text("存在相同的名称")

                        }else {
                            layer.msg("可以使用")
                            $("#namePrompt").text("可以使用")
                        }

                    }
                })

        }else {
                $("#namePrompt").text("不能为空")
            }

    }

</script>

</html>
