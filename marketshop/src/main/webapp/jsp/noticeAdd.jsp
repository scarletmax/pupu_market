<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>添加推送</title>
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
            src="${pageContext.request.contextPath}/js/noticeAdd.js"></script>

<body>
<input hidden value="${pageContext.request.contextPath}" id="path">

<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form">

            <div class="layui-form-item">
                <label for="title" class="layui-form-label">
                    <span class="x-red">*</span>标题</label>
                <div class="layui-input-inline">
                    <input type="text" id="title" name="title" required="" lay-verify="required"
                           lay-reqtext="标题是必填项" autocomplete="off" class="layui-input"></div>
            </div>

            <div class="layui-form-item">
                <label for="content" class="layui-form-label">
                    <span class="x-red">*</span>内容</label>
                <div class="layui-input-inline">
                    <input type="text" id="content" name="content" required="" lay-verify="required"
                           lay-reqtext="标题是必填项" autocomplete="off" class="layui-input"></div>
            </div>




            <div class="layui-form-item">
                <div class="layui-upload">
                    <label for="test1" class="layui-form-label">
                        <span class="x-red">*</span>选择推送照片</label>
                    <div class="layui-upload upload1">
                        <button class="layui-btn layui-btn-normal" id="test1" type="button">选择推送照片</button>
                        <button class="layui-btn" id="test2" type="button" style="display:none;">开始上传</button>
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <label for="startDate" class="layui-form-label">
                    <span class="x-red">*</span>推送时间</label>
                <div class="layui-input-inline">
                    <input class="layui-input" name="startDate" id="startDate" lay-verify="date" autocomplete="off">
                </div>
                <div class="layui-form-mid layui-word-aux"><span id="regNode"></span></div>
            </div>



            <div class="layui-form-item">
                <label for="startDate" class="layui-form-label"></label>
                <button id="regis" class="layui-btn" lay-submit lay-filter="regis">立即提交</button>
            </div>
    </div>
    </form>
</div>
</div>
<script>

    var path = $("#path").val();
    layui.use(['form', 'layer', 'upload', 'laydate'],
        function () {
            $ = layui.jquery;
            var form = layui.form,
                layer = layui.layer,
                upload = layui.upload;

            //自定义验证规则
            form.verify({
                required: [/[\S]+/, "必填项不能为空"],
            });

            upload.render({
                elem: '#test1'
                , url: path + "/noticeControl/addNoticePic"//改成您自己的上传接口
                , auto: false
                , bindAction: '#test2'
                , exts: 'jpg|png|gif|bmp|jpeg'
                , done: function (res) {
                    $.ajax({
                        url: path + "/noticeControl/insertNoticeInfo",
                        async: true,
                        type: "post",
                        dataType: "text",
                        success: function (msg) {
                            if (msg === "success") {
                                // layer.msg('添加推送成功');
                                layer.alert("添加推送成功", {
                                        icon: 6
                                    },
                                    function () {
                                        //关闭当前frame
                                        xadmin.close();
                                        // 可以对父窗口进行刷新
                                        xadmin.father_reload();
                                    });
                            }else{
                                layer.msg('添加推送失败');
                            }
                        }
                    })
                }
                , error: function () {
                    //演示失败状态，并实现重传
                    var demoText = $('#demoText');
                    demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                    demoText.find('.demo-reload').on('click', function () {
                        uploadInst.upload();
                    });
                }

            });

            //监听提交
            form.on('submit(regis)',
                function (data) {
                    console.log(data);
                    //发异步，把数据提交给php
                    var path = $("#path").val();
                    var title = $("#title").val();
                    var content = $("#content").val();
                    var noticeTime = $("#startDate").val();
                    var now = new Date().getTime();
                    var startTimeNum = new Date(noticeTime).getTime();

                    var noticeInfo = {
                        "title": title,
                        "noticeTime": noticeTime,
                        "content": content
                    };
                    if ($(".upload1:has(span)").length > 0) {
                            $.ajax({
                                url: path + "/noticeControl/addNotice",
                                async: true,
                                type: "post",
                                data: "noticeInfo=" + JSON.stringify(noticeInfo),
                                dataType: "text",
                                success: function (msg) {
                                    if (msg == "success") {
                                        $("#test2").click();
                                    } else if (msg == "fail") {
                                        layer.msg("保存失败")
                                    }
                                },
                                error: function () {
                                    alert("网络错误")
                                }
                            })
                        } else {
                        layer.msg("开始时间不能大于当前日期");
                    }

                    return false;
                });

        });</script>

</body>

</html>