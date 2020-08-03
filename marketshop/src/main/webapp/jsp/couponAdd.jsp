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
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/js/couponAdd.js"></script>

<body>
<input hidden value="${pageContext.request.contextPath}" id="path">

<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form">

            <div class="layui-form-item">
                <label for="name" class="layui-form-label">
                    <span class="x-red">*</span>名称</label>
                <div class="layui-input-inline">
                    <input type="text" id="name" name="name" required="" lay-verify="required"
                           lay-reqtext="名称是必填项" autocomplete="off" class="layui-input"></div>
            </div>

            <div class="layui-form-item">
                <label for="startDate" class="layui-form-label">
                    <span class="x-red">*</span>开始时间</label>
                <div class="layui-input-inline">
                    <input class="layui-input" name="startDate" id="startDate" lay-verify="date" autocomplete="off">
                </div>
                <div class="layui-form-mid layui-word-aux"><span id="regNode"></span></div>
            </div>

            <div class="layui-form-item">
                <label for="endDate" class="layui-form-label">
                    <span class="x-red">*</span>结束时间</label>
                <div class="layui-input-inline">
                    <input class="layui-input" name="endDate" id="endDate" lay-verify="date" autocomplete="off">
                </div>
                <div class="layui-form-mid layui-word-aux"><span id="regNode2"></span></div>
            </div>


            <div class="layui-form-item">
                <label for="favorPrice" class="layui-form-label">
                    <span class="x-red">*</span>优惠金额</label>
                <div class="layui-input-inline">
                    <input type="number" id="favorPrice" name="favorPrice" required="" lay-verify="favorPrice||number"
                           autocomplete="off" class="layui-input"></div>
            </div>

            <div class="layui-form-item">
                <label for="limitCount" class="layui-form-label">
                    <span class="x-red">*</span>限领次数</label>
                <div class="layui-input-inline">
                    <input type="text" id="limitCount" name="limitCount" required="" lay-verify="limitCount||number"
                           autocomplete="off" class="layui-input"></div>
            </div>

            <div class="layui-form-item">
                <label for="requirePrice" class="layui-form-label">
                    <span class="x-red">*</span>满额条件</label>
                <div class="layui-input-inline">
                    <input type="text" id="requirePrice" name="requirePrice" required="" lay-verify="favorPrice||number"
                           autocomplete="off" class="layui-input"></div>
            </div>

            <div class="layui-form-item">
                <label for="rule" class="layui-form-label">
                    <span class="x-red">*</span>规则</label>
                <div class="layui-input-inline">
                    <textarea placeholder="请输入内容" id="rule" name="rule" class="layui-textarea"
                              lay-verify="rule"></textarea></div>
            </div>

            <div class="layui-form-item">
                <label for="rule" class="layui-form-label"></label>
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
                rule: [/[\S]+/, "必填项不能为空"],
                limitCount: [/[\S]+/, "必填项不能为空"],
                favorPrice: [/[\S]+/, "必填项不能为空"],
            });

            //监听提交
            form.on('submit(add)',
                function (data) {
                    console.log(data);
                    //发异步，把数据提交给php
                    var path = $("#path").val();
                    var name = $("#name").val();
                    var startDate = $("#startDate").val();
                    var endDate = $("#endDate").val();
                    var limitCount = $("#limitCount").val();
                    var favorPrice = $("#favorPrice").val();
                    var requirePrice = $("#requirePrice").val();
                    var rule = $("#rule").val();
                    var now = new Date().getTime();
                    var startTimeNum = new Date(startDate).getTime();
                    var endTimeNum = new Date(endDate).getTime();

                    var couponInfo = {
                        "name": name,
                        "startDate": startDate,
                        "endDate": endDate,
                        "limitCount": limitCount,
                        "favorPrice": favorPrice,
                        "requirePrice": requirePrice,
                        "rule": rule
                    };
                    if (startTimeNum >= now) {
                        if (endTimeNum > startTimeNum) {
                            $.ajax({
                                url: path + "/couponControl/addCouppon",
                                async: true,
                                type: "post",
                                data: "couponInfo=" + JSON.stringify(couponInfo),
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
                        } else {
                            layer.msg("结束时间不能小于开始时间");
                        }
                    } else {
                        layer.msg("开始时间不能大于当前日期");
                    }

                    return false;
                });

        });</script>

</body>

</html>