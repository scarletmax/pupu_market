<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>添加管理员</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.js" charset="utf-8"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/static/X-admin/lib/layui/layui.js"
            charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/X-admin/js/xadmin.js"></script>


<body>
<input hidden value="${pageContext.request.contextPath}" id="path">

<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form">

            <div class="layui-form-item">
                <label for="name" class="layui-form-label">
                    <span class="x-red">*</span>等级名称</label>
                <div class="layui-input-inline">
                    <input type="text" id="name" name="name" required="" lay-verify="required"
                           lay-reqtext="名称是必填项，岂能为空？" autocomplete="off" class="layui-input"></div>
            </div>

            <div class="layui-form-item">
                <label for="min_point" class="layui-form-label">
                    <span class="x-red">*</span>等级最小积分</label>
                <div class="layui-input-inline">
                    <input type="number" id="min_point" name="min_point" required="" lay-verify="level||number"
                      min="0"     autocomplete="off" class="layui-input"></div>
            </div>

            <div class="layui-form-item">
                <label for="max_point" class="layui-form-label">
                    <span class="x-red">*</span>等级最大积分</label>
                <div class="layui-input-inline">
                    <input type="number" id="max_point" name="max_point" required="" lay-verify="level||number"
                           min="0"       autocomplete="off" class="layui-input"></div>
            </div>

            <div class="layui-form-item">
                <label for="max_point" class="layui-form-label"></label>
                <button class="layui-btn layui-btn-lg" lay-filter="add" lay-submit="">添加</button>
            </div>
    </div>
    </form>
</div>
</div>
<script>

    layui.use(['form', 'layer'],
        function () {
            $ = layui.jquery;
            var form = layui.form,
                layer = layui.layer;

            //自定义验证规则
            form.verify({
                level: [/[\S]+/, "必填项不能为空"],
            });

            //监听提交
            form.on('submit(add)',
                function (data) {
                    console.log(data);
                    //发异步，把数据提交给php
                    var path = $("#path").val();
                    var name = $("#name").val();
                    var min_point = $("#min_point").val();
                    var max_point = $("#max_point").val()

                    var levelInfo = {
                        "name": name,
                        "minPoint": min_point,
                        "maxPoint": max_point,
                    };
                    $.ajax({
                        url: path + "/levelControl/addLevel",
                        async: true,
                        type: "post",
                        data: "levelInfo=" + JSON.stringify(levelInfo),
                        dataType: "text",
                        success: function (msg) {
                            if (msg == "success") {
                                layer.alert("新增成功", {
                                        icon: 6
                                    },
                                    function () {
                                        //关闭当前frame
                                        xadmin.close();
                                        // 可以对父窗口进行刷新
                                        xadmin.father_reload();
                                    });
                            } else if (msg == "fail") {
                                layer.msg("保存失败")
                            }
                        },
                        error: function () {
                            alert("网络错误")
                        }
                    })

                    return false;
                });

        });</script>

</body>

</html>