<%--
  Created by IntelliJ IDEA.
  User: wVim
  Date: 2020/7/13
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>修改菜单</title>
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
<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form" lay-filter="formTest">
            <div class="layui-form-item layui-hide">
                <label for="id" class="layui-form-label">菜单id</label>
                <div class="layui-input-inline"><input type="text" id="id" name="id" lay-verify="required" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="name" class="layui-form-label">菜单名称</label>
                <div class="layui-input-inline"><input type="text" id="name" name="name" lay-verify="required" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="menuLevel" class="layui-form-label">菜单等级</label>
                <div class="layui-input-inline"><input type="text" id="menuLevel" name="menuLevel"  lay-verify="required" autocomplete="off" class="layui-input" disabled></div>
            </div>
            <div class="layui-form-item">
                <label for="url" class="layui-form-label">菜单url</label>
                <div class="layui-input-inline"><input type="text" id="url" name="url" lay-verify="" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="iconUrl" class="layui-form-label">菜单图标url</label>
                <div class="layui-input-inline"><input type="text" id="iconUrl" name="iconUrl" lay-verify="" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <button type="button" class="layui-btn" lay-filter="edit" lay-submit="">确认修改</button>
            </div>
        </form>
    </div>
</div>
<script>
    layui.use(['form', 'layer','jquery'], function() {
        var $ = layui.jquery;
        var form = layui.form;
        var  layer = layui.layer;
        var path =$("#path").val();


        form.verify({
            nameRepeat: function(value){
                var flag = 1;//1表示不重复
                $.ajax({
                    url:path+"/menuControl/isMenuRepeat",
                    async:false,
                    data:{"name":value},
                    dataType:"text",
                    success:function(res){
                        if(res!=0){
                            flag=2;
                        }
                    },
                    error:function (xhr,textStatus) {
                        layer.alert("错误:"+textStatus, {icon: 2});
                        flag=3;
                    },
                });
                if(flag != 1){
                    return '该菜单已存在';
                }
            }
        });


        //监听提交
        form.on('submit(edit)', function(data) {
            console.log(JSON.stringify(data.field));
            $.ajax({
                url:path+"/menuControl/editMenu",
                async:false,
                type:"POST",
                data:data.field,
                dataType:"json",
                success:function(res){
                    console.log(res);
                    if(res==1){
                        layer.alert("修改成功", {icon: 6}, function() {
                            //关闭当前frame
                            xadmin.close();
                            // 可以对父窗口进行刷新
                            xadmin.father_reload();
                        });
                    }
                },
                error:function (xhr,textStatus) {
                    layer.alert("错误:"+textStatus, {icon: 2});
                },
            });
            return false;
         });

        $(function () {
            form.val("formTest", {
                "id": parent.tempData.id
                ,"name": parent.tempData.name
                ,"menuLevel":parent.tempData.menuLevel
                ,"url":  parent.tempData.url
                ,"iconUrl":  parent.tempData.iconUrl
            });

        })

    });
</script>

</body>
<input id="path" value="${pageContext.request.contextPath}" type="hidden">
</html>
