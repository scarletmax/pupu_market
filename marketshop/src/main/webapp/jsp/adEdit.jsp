<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>修改类型</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.js" charset="utf-8"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/static/X-admin/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/X-admin/js/xadmin.js"></script>


<body>
<input hidden value="${pageContext.request.contextPath}" id="path">

<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form">
             <div class="layui-form-item">
                <label for="title" class="layui-form-label">
                    <span class="x-red">*</span>广告标题</label>
                <div class="layui-input-inline">
                    <input type="text" id="title" name="title" required="" lay-verify="required" autocomplete="off" class="layui-input">
                </div>

                <div class="layui-form-item">
                    <label for="goodName" class="layui-form-label">
                        <span class="x-red">*</span>商品名称</label>
                    <div class="layui-input-inline">
                        <input type="text" id="goodName" name="goodName" readonly autocomplete="off" class="layui-input"></div>
               (不可修改）
                </div>
                <div class="layui-form-item">
                    <label for="typeStr" class="layui-form-label">
                        <span class="x-red">*</span>广告类型</label>
                    <div class="layui-input-inline">
                        <input type="text" id="typeStr" name="typeStr" readonly autocomplete="off" class="layui-input"></div>
               （不可修改）
                </div>
                <div class="layui-form-item">
                    <div class="layui-upload">
                        重新上传图片
                        <button type="button" class="layui-btn layui-btn-normal" id="test8">选择图片</button>
                        <button type="button" class="layui-btn" id="test9" >开始上传</button>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label for="typeStr" class="layui-form-label"></label>
                    <button class="layui-btn layui-btn-lg" lay-filter="add" lay-submit="">修改</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    layui.use('upload', function(){
        var $ = layui.jquery
            ,upload = layui.upload;
        var path=$("#path").val()
        //选完文件后不自动上传
        upload.render({
            elem: '#test8'
            ,url: path+"/adControl/upload" //改成您自己的上传接口
            ,auto: false
            ,accept:"images"
            //,multiple: true
            ,bindAction: '#test9'
            ,before: function(){
            }
            ,done: function(res){
                console.log(res)
                if(res.code==1){
                    layer.msg("系统不支持该类型文件")
                }else if(res.code==0) {
                    layer.msg("上传成功");
                }

                console.log(res)
            },error: function(){
                //演示失败状态，并实现重传
                layer.msg("上传失败");
            }
        });

    });
</script>
<script>
    var id;
    layui.use(['form', 'layer'],
    function() {
        $ = layui.jquery;
        var form = layui.form,
            layer = layui.layer;
        var data=parent.tempData
        $("#title").val(data.title);
        $("#goodName").val(data.goodName);
        $("#typeStr").val(data.typeStr);
        id=data.id;
        //自定义验证规则
        form.verify({

        });

        //监听提交
        form.on('submit(add)',
            function(data) {
                console.log(data);
                var path= $("#path").val();
                var title=$("#title").val();
                var goodName=$("#goodName").val()
                var typeStr=$("#typeStr").val();
                var adInfo={"id":id,"title":title};
                var adJson=JSON.stringify(adInfo);
                $.ajax({
                    url:path+"/adControl/updateAd",
                    async:true,
                    type:"post",
                    data:"adJson="+adJson,
                    dataType:"text",
                    success:function (msg) {
                        if(msg == "success") {
                            layer.alert("保存成功", {
                                    icon: 6
                                },
                                function() {
                                   //向父界面传值
                                    parent.updateType(JSON.parse(adJson))
                                    // 获得frame索引
                                    var index = parent.layer.getFrameIndex(window.name);
                                    //关闭当前frame
                                    parent.layer.close(index);
                                });
                        }else if(msg == "fail"){
                            layer.msg("保存失败")
                        }
                    },
                    error:function () {
                        alert("网络错误")
                    }
                })

                return false;
            });

    });</script>

</body>

</html>