<%--
  Created by IntelliJ IDEA.
  User: wVim
  Date: 2020/8/1
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>新增类型</title>
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

<%--    <button type="button" class="layui-btn layui-btn-normal" id="testList">选择图片</button>--%>
<%--    <button type="button" class="layui-btn" id="testListAction">开始上传</button>--%>
    <div class="layui-row">
        <form class="layui-form" lay-filter="formTest">
            <div class="layui-form-item layui-hide">
                <label for="parentId" class="layui-form-label">父类型id</label>
                <div class="layui-input-inline"><input type="text" id="parentId" name="parentId" lay-verify="required" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="name" class="layui-form-label">类型名称</label>
                <div class="layui-input-inline"><input type="text" id="name" name="name" lay-verify="required" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="menuLevel" class="layui-form-label">类型等级</label>
                <div class="layui-input-inline"><input type="text" id="menuLevel" name="menuLevel"  lay-verify="required" autocomplete="off" class="layui-input" disabled></div>
            </div>
            <div class="layui-form-item">
                <%--预览的图片--%>
                <div class="layui-upload">
                    <button type="button" class="layui-btn" id="test1">上传图片</button>
                    <div class="layui-upload-list">
                        <img class="layui-upload-img" id="demo1">
                        <p id="demoText"></p><%--上传结果显示--%>
                    </div>
                </div>
                <%--隐藏的url--%>
                <label for="iconUrl" class="layui-form-label" >类型图标url</label>
                <div class="layui-input-inline"><input type="text" id="iconUrl" name="iconUrl" lay-verify="" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <button type="button" class="layui-btn" lay-filter="edit" lay-submit="">确认新增</button>
            </div>
        </form>
    </div>
</div>
</div>
<script>




    layui.use(['form', 'layer','jquery'], function() {
        var $ = layui.jquery;
        var form = layui.form;
        var  layer = layui.layer;
        var path =$("#path").val();

        //普通图片上传
        var uploadInst = upload.render({
            elem: '#test1'
            ,url: path+'/uploadControl/typeIconUpload' //改成您自己的上传接口
            ,accept: 'images'
            ,acceptMime: 'image/*'
                // ,exts: suffixStr
            ,multiple: false
            ,auto: true
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){
                console.log(JSON.parse(res));
                //如果上传成功
                if(res.code == 0){
                    var demoText = $('#demoText');
                    demoText.html('<span style="color: #FF5722;">上传成功</span>');
                    $(#iconUrl).val(res.data.filePath);
                }
                //上传失败
                this.error();
            }
            ,error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });

        // // 多文件列表示例
        // var demoListView = $('#demoList');
        //
        // var uploadListIns = upload.render({
        //     elem: '#testList'
        //     ,url: path+'/typeControl/upload' //改成您自己的上传接口
        //     ,accept: 'images'
        //     ,acceptMime: 'image/*'
        //     // ,exts: suffixStr
        //     ,multiple: false
        //     ,auto: false
        //     ,bindAction: '#testListAction'
        //     ,choose: function(obj){//选择后的回调,选择的都文件符合accept、acceptMime、exts后才会触发
        //         var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列，不删除将一直存在files对象中
        //
        //
        //     }
        //     ,done: function(res, index, upload){//每个文件提交一次触发一次，即每个index触发一次
        //         console.log(JSON.parse(res))
        //         if(res.code==0){ //上传成功
        //             var tr = demoListView.find('tr#upload-'+ index);
        //             var tds = tr.children();
        //             tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
        //             tds.eq(3).html(''); //清空所有操作
        //             return delete this.files[index]; //删除文件队列已经上传成功的文件，对应列表tr信息保留
        //         }
        //         this.error(index, upload);//上传失败调用error回调函数
        //     }
        //     ,error: function(index, upload){//上传失败
        //         var tr = demoListView.find('tr#upload-'+ index);
        //         var tds = tr.children();
        //         tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
        //         tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
        //     }
        // });


        form.verify({
            nameRepeat: function(value){
                console.log("正在执行验证");
                var flag = 1;//1表示不重复
                $.ajax({
                    url:path+"/menuController/isMenuRepeat",
                    async:false,
                    data:{"name":value},
                    dataType:"text",
                    success:function(res){
                        console.log("该名称的数e量"+res);
                        if(res!=0){//不重复时改变flag值
                            flag=2;
                        }
                    },
                    error:function (xhr,textStatus) {
                        layer.alert("错误:"+textStatus, {icon: 2});
                        flag=3;
                    },
                });
                if(flag ==2){
                    return '该菜单已存在';
                }else if(flag ==3){
                    return '服务器错误';
                }
            }
        });







        //监听提交
        form.on('submit(edit)', function(data) {
            console.log("表单提交的数据"+JSON.stringify(data.field));
            $.ajax({
                url:path+"/typeControl/addType",
                async:false,
                type:"POST",
                data:data.field,
                dataType:"json",
                success:function(res){
                    if(res==1){
                        layer.alert("新增成功", {icon: 6}, function() {
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
                "parentId": parent.tempData.id//选中列id作为新增列的父级id
                ,"menuLevel":parent.tempData.menuLevel
            });

        })

    });
</script>

</body>
<input id="path" value="${pageContext.request.contextPath}" type="hidden">
</html>
