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
                    <label for="goodsId" class="layui-form-label">
                        <span class="x-red">*</span>商品编号（id）</label>
                    <div class="layui-input-inline">
                        <input type="text" id="goodsId" name="goodsId"  required=""  lay-verify="required" autocomplete="off" class="layui-input"></div>
                    (可在商品管理中查询）
                </div>
                <div class="layui-form-item">
                    <label for="mySelect3" class="layui-form-label">
                        <span class="x-red">*</span>广告类型</label>
                    <div class="layui-form layui-input-inline layui-show-xs-block " lay-filter="mySelectDiv">
                        <select name="typeStr" id="mySelect3" lay-filter="mySelect3">
                            <option value="首页轮播图广告">首页轮播图广告</option>
                            <option value="首页静态广告">首页静态广告</option>
                        </select>
                    </div>

                </div>

                <div class="layui-form-item">
                    <label for="adPic" class="layui-form-label">
                        <span class="x-red">*</span> 广告图片</label>
                    <div class="layui-upload" id="adPic">
                        <button type="button" class="layui-btn layui-btn-normal" id="test8">选择图片</button>
                        <button type="button" class="layui-btn" id="test9" >开始上传</button>
                    </div>
                </div>

            <div class="layui-form-item">
                <label for="adPic" class="layui-form-label"></label>
                <button class="layui-btn layui-btn-lg" lay-filter="add" lay-submit="">添加</button>
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
    layui.use(['form', 'layer'],
    function() {
        $ = layui.jquery;
        var form = layui.form,
            layer = layui.layer;
        // var list= parent.tempList
        // if(list!=null){
        //     for (var i = 0; i <list.length ; i++) {
        //         str+="<option value='"+list[i]+"'>"+list[i]+"</option>"
        //     }
        //     $('#mySelect3').append(str);
        //     // layui.form.render('select','mySelectDiv');
        // }

        //自定义验证规则
        form.verify({
            point: function(value) {
                if (value<=0) {
                    return '请输入大于0的整数';
                }
            }
        });

        //监听提交
        form.on('submit(add)',
            function(data) {
                console.log(data);
                //发异步，把数据提交给php
                var path= $("#path").val();
                var title=$("#title").val();
                var goodsId=$("#goodsId").val()
                var typeStr=$("#mySelect3").val();

                var adInfo={"title":title,"goodId":goodsId,"typeStr":typeStr};
                $.ajax({
                    url:path+"/adControl/newAd",
                    async:true,
                    type:"post",
                    data:"adJson="+JSON.stringify(adInfo),
                    dataType:"text",
                    success:function (msg) {
                        if(msg == "success") {
                            layer.alert("新增成功", {
                                    icon: 6
                                },
                                function() {
                                    parent.reload()
                                    // 获得frame索引
                                    var index = parent.layer.getFrameIndex(window.name);
                                    //关闭当前frame
                                    parent.layer.close(index);
                                });
                        }else if(msg == "fail"){
                            layer.msg("新增失败")
                        }else if(msg == "noPic") {
                            layer.msg("新增失败，请先上传广告图片")
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