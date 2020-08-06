<%--
  Created by IntelliJ IDEA.
  User: wVim
  Date: 2020/8/5
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>修改商品</title>
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
<div class="layui-fluid" style="background-color: #f7f0de">
    <div class="layui-row">
        <div class="layui-col-md8 layui-col-md-offset2">
            <div class="layui-card">
                <div class="layui-card-header" style="text-align: center">
                    修改商品
                </div>
                <div class="layui-card-body">
                    <form class="layui-form" lay-filter="formTest">
                        <div class="layui-form-item  layui-hide">
                            <label for="name" class="layui-form-label">商品id</label>
                            <div class="layui-input-inline"><input type="text" id="id" name="id" lay-verify="required" autocomplete="off" class="layui-input"></div>
                        </div>
                        <div class="layui-form-item">
                            <label for="name" class="layui-form-label">商品名称</label>
                            <div class="layui-input-inline"><input type="text" id="name" name="name" lay-verify="required" autocomplete="off" class="layui-input"></div>
                        </div>
                        <div class="layui-form-item">
                            <label for="intro" class="layui-form-label">商品简介</label>
                            <div class="layui-input-inline"><input type="text" id="intro" name="intro"  lay-verify="required" autocomplete="off" class="layui-input"></div>
                        </div>
                        <div class="layui-form-item">
                            <label for="price" class="layui-form-label">市场价</label>
                            <div class="layui-input-inline"><input type="text" id="price" name="price" lay-verify="money" autocomplete="off" class="layui-input"></div>
                        </div>
                        <div class="layui-form-item">
                            <label for="specialPrice" class="layui-form-label">特价价格</label>
                            <div class="layui-input-inline"><input type="text" id="specialPrice" name="specialPrice" autocomplete="off" class="layui-input"></div>
                        </div>
                        <div class="layui-form-item">
                            <label for="parentTypeId" class="layui-form-label">一级分类</label>
                            <div class="layui-input-inline">
                                <select class="layui-form-select" name="parentTypeId" id="parentTypeId" lay-filter="selectDemo" lay-verify="selection">
                                    <option value="">一级分类</option>
                                </select>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="typeId" class="layui-form-label">二级分类</label>
                            <div class="layui-input-inline">
                                <select class="layui-form-select" name="typeId" id="typeId" lay-verify="selection">
                                    <option value="">请先选择一级分类</option>
                                </select>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="totalCount" class="layui-form-label">剩余总数</label>
                            <div class="layui-input-inline"><input type="text" id="totalCount" name="totalCount" lay-verify="noPositive" autocomplete="off" class="layui-input"></div>
                        </div>

                        <div class="layui-form-item layui-upload">
                            <label for="test1" class="layui-form-label" >大图</label>
                            <button type="button" class="layui-btn" id="test1">选择图片</button>
                            <button type="button" class="layui-btn" id="testAction">上传图片</button>
                            <p style="display: inline-block" id="demoText"></p><%--上传结果显示--%>
                            <div class="layui-upload-list">
                                <img class="layui-upload-img" id="demo1">
                            </div>
                        </div>

                        <%--隐藏返回的url，标识--%>
                        <input type="text" name="infoPic" style="display: none" lay-verify="picRequest" value="">
                        <input type="hidden" name="pic1">
                        <input type="hidden" name="pic2">
                        <input type="hidden" name="pic3">
                        <input type="hidden" name="pic4">

                        <div class="layui-form-item">
                            <button type="button" class="layui-btn" lay-filter="edit" lay-submit="">确认修改</button>
                        </div>

                        <table class="layui-table">
                            <thead><tr><th>图片1</th><th>图片2</th><th>图片3</th><th>图片4</th></tr></thead>
                            <tbody>
                            <tr>
                                <td><img id="pic1" src=""></td>
                                <td><img id="pic2" src=""></td>
                                <td><img id="pic3" src=""></td>
                                <td><img id="pic4" src=""></td>
                            </tr>
                            <tr>
                                <td>
                                    <button type="button" class="layui-btn" id="picTest1" >选择图片</button>
                                    <button type="button" class="layui-btn" id="picTestAction1">上传图片</button>
                                    <p style="display: inline-block" id="demoText1"></p><%--上传结果显示--%>
                                </td>
                                <td>
                                    <button type="button" class="layui-btn" id="picTest2" >选择图片</button>
                                    <button type="button" class="layui-btn" id="picTestAction2">上传图片</button>
                                    <p style="display: inline-block" id="demoText2"></p><%--上传结果显示--%>
                                </td>
                                <td>
                                    <button type="button" class="layui-btn" id="picTest3" >选择图片</button>
                                    <button type="button" class="layui-btn" id="picTestAction3">上传图片</button>
                                    <p style="display: inline-block" id="demoText3"></p><%--上传结果显示--%>
                                </td>
                                <td>
                                    <button type="button" class="layui-btn" id="picTest4" >选择图片</button>
                                    <button type="button" class="layui-btn" id="picTestAction4">上传图片</button>
                                    <p style="display: inline-block" id="demoText4"></p><%--上传结果显示--%>
                                </td>
                            </tr>
                            </tbody>
                        </table>

                    </form>


                </div>


            </div>
        </div>
    </div>
</div>
<script>
    layui.use(['form', 'layer','jquery','upload','carousel'], function() {
        var $ = layui.jquery;
        var form = layui.form;
        var  layer = layui.layer;
        var  upload = layui.upload;
        var carousel = layui.carousel;
        var path =$("#path").val();



        //监听提交
        form.on('submit(edit)', function(data) {
            console.log(JSON.stringify(data.field));
            $.ajax({
                url:path+"/goodsControl/editGoods",
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

        //多张图片
        var uploadInst = upload.render({
            elem: '#album'
            ,url: path+'/goodsControl/detailPicUpload' //改成您自己的上传接口
            ,accept: 'images'
            ,acceptMime: 'image/*'
            ,multiple: true
            ,number:4
            ,auto: false
            ,bindAction:'#albumAction'
            ,choose: function(obj){
                //预读本地文件示例，不支持ie8
                $("#carousel").find("img").attr("src","");
                var a = 0;
                obj.preview(function(index, file, result){
                    a++;
                    var b="#pic"+a;
                    $(b).attr('src', result); //图片链接（base64）
                });
                carousel.render({
                    elem: '#carousel'
                    ,width: '80%' //设置容器宽度
                    ,height: '350px' //设置容器宽度
                    ,arrow: 'always' //始终显示箭头
                });
            }
            ,before:function (obj) {
                window.returnCount=0;//确定上传时清空上传索引值
                $("#returnUrlDiv").children().remove();
            }
            ,done: function(res, index, upload){
                console.log(res);
                console.log(res.data[0]);
                //如果上传成功,由于分次上传多图片因此不能保存在session中
                if(res.code == 0){
                    returnCount++;
                    $("#returnUrlDiv").append("<input name='pic"+returnCount+"' value=''>");
                    $("#returnUrlDiv").children("input:last-child").attr("value",res.data[0]);

                    var albumText = $('#albumText');
                    albumText.html('<span style="color: #5bff39;">上传成功</span>');
                }else{
                    //上传失败
                    this.error();
                }
            }
            ,error: function(index,upload){
                //演示失败状态，并实现重传
                var albumText = $('#albumText');
                albumText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                albumText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
            // ,allDone: function(obj){ //当文件全部被提交后，才触发
            //     console.log(obj.total); //得到总文件数
            //     console.log(obj.successful); //请求成功的文件数
            //     console.log(obj.aborted); //请求失败的文件数
            // }

        });

        //指定图片上传替换
        var uploadInst = upload.render({
            elem: '#picTest1'
            ,url: path+'/goodsControl/detailPicUpload' //改成您自己的上传接口
            ,accept: 'images'
            ,acceptMime: 'image/*'
            ,multiple: false
            ,auto: false
            ,bindAction:'#picTestAction1'
            ,choose: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $("#pic1").attr('src', result); //图片链接（base64）
                });
            }
           ,before(){
                $("input[name=pic1]").attr("value","");//非必要
            }
            ,done: function(res){
                console.log(res);
                console.log(res.data[0]);
                //如果上传成功
                if(res.code == 0){
                    $("#demoText1").html('<span style="color: #5bff39;">上传成功</span>');
                    $("input[name=pic1]").attr("value",res.data[0]);
                }else{
                    //上传失败
                    this.error();
                }
            }
            ,error: function(){
                //演示失败状态，并实现重传
                $('#demoText1').html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                $('#demoText1').find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });

        var uploadInst2 = upload.render({
            elem: '#picTest2'
            ,url: path+'/goodsControl/detailPicUpload' //改成您自己的上传接口
            ,accept: 'images'
            ,acceptMime: 'image/*'
            ,multiple: false
            ,auto: false
            ,bindAction:'#picTestAction2'
            ,choose: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $("#pic2").attr('src', result); //图片链接（base64）
                });
            }
            ,before(){
                $("input[name=pic2]").attr("value","");
            }
            ,done: function(res){
                console.log(res);
                console.log(res.data[0]);
                //如果上传成功
                if(res.code == 0){
                    $("#demoText1").html('<span style="color: #5bff39;">上传成功</span>');
                    $("input[name=pic2]").attr("value",res.data[0]);
                }else{
                    //上传失败
                    this.error();
                }
            }
            ,error: function(){
                //演示失败状态，并实现重传
                $('#demoText1').html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                $('#demoText1').find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });

        var uploadInst3 = upload.render({
            elem: '#picTest3'
            ,url: path+'/goodsControl/detailPicUpload' //改成您自己的上传接口
            ,accept: 'images'
            ,acceptMime: 'image/*'
            ,multiple: false
            ,auto: false
            ,bindAction:'#picTestAction3'
            ,choose: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $("#pic3").attr('src', result); //图片链接（base64）
                });
            }
            ,before(){
                $("input[name=pic3]").attr("value","");
            }
            ,done: function(res){
                console.log(res);
                console.log(res.data[0]);
                //如果上传成功
                if(res.code == 0){
                    $("#demoText3").html('<span style="color: #5bff39;">上传成功</span>');
                    $("input[name=pic3]").attr("value",res.data[0]);
                }else{
                    //上传失败
                    this.error();
                }
            }
            ,error: function(){
                //演示失败状态，并实现重传
                $('#demoText1').html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                $('#demoText1').find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });

        var uploadInst4 = upload.render({
            elem: '#picTest4'
            ,url: path+'/goodsControl/detailPicUpload' //改成您自己的上传接口
            ,accept: 'images'
            ,acceptMime: 'image/*'
            ,multiple: false
            ,auto: false
            ,bindAction:'#picTestAction4'
            ,choose: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $("#pic4").attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){
                console.log(res);
                console.log(res.data[0]);
                //如果上传成功
                if(res.code == 0){
                    $("#demoText4").html('<span style="color: #5bff39;">上传成功</span>');
                    $("input[name=pic4]").attr("value",res.data[0]);
                }else{
                    //上传失败
                    this.error();
                }
            }
            ,before(){
                $("input[name=pic4]").attr("value","");
            }
            ,error: function(){
                //演示失败状态，并实现重传
                $('#demoText1').html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                $('#demoText1').find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });

        // function toUpload() {
        //     window.myIndex = this.val();
        //     if(this.val()=="1"){
        //         uploadInst.reload({
        //             elem: '#picTest1'
        //             ,bindAction:'#picTestAction1'
        //         })
        //
        //     }else if(this.val()=="2"){
        //         uploadInst.reload({
        //             elem: '#picTest2'
        //             ,bindAction:'#picTestAction2'
        //         })
        //     }
        //
        //
        // }


        //一张大图上传
        var uploadInst = upload.render({
            elem: '#test1'
            ,url: path+'/goodsControl/detailPicUpload' //改成您自己的上传接口
            ,accept: 'images'
            ,acceptMime: 'image/*'
            ,multiple: false
            ,auto: false
            ,bindAction:'#testAction'
            ,choose: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){
                console.log(res);
                console.log(res.data[0]);
                //如果上传成功
                if(res.code == 0){
                    var demoText = $('#demoText');
                    demoText.html('<span style="color: #5bff39;">上传成功</span>');
                    $("input[name=infoPic]").attr("value",res.data[0]);
                }else{
                    //上传失败
                    this.error();
                }
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

        //表单验证
        form.verify({
            selection:function(value){
                if(value==""){
                    return "分类不能为空";
                }
            }
            ,noPositive:function(value){
                if(!/^[1-9]\d*|0$/.test(value)){
                    return "请输入非负整数数量";
                }
            }
            ,money:function(value){
                if(!/(^[1-9]\d*(\.\d{1,2})?$)|(^0(\.\d{1,2})?$)/.test(value)){
                    return "请输入正确的价格，正整数或者保留两位小数";
                }
            }
            ,nameRepeat: function(value){
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
            console.log("商品修改表单提交的数据"+data.field);
            $.ajax({
                url:path+"/goodsControl/editGoods",
                async:false,
                type:"POST",
                data:data.field,
                dataType:"json",
                success:function(res){
                    if(res==1){
                        layer.alert("修改成功", {icon: 6}, function() {
                            // 关闭当前frame
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



        //加载时需要做的事
        $(function () {
            var data = window.parent.tempData;
            $("input[name=id]").val(data.id);
            $("input[name=name]").val(data.name);
            $("input[name=intro]").val(data.intro);
            $("input[name=price]").val(data.price);
            $("input[name=specialPrice]").val(data.specialPrice);
            $("input[name=totalCount]").val(data.totalCount);
            $("input[name=name]").val(data.name);
            $("#demo1").attr("src","../upload/goods_pic"+data.infoPic);
            $("#pic1").attr("src","../upload/goods_pic"+data.pic1);
            $("#pic2").attr("src","../upload/goods_pic"+data.pic2);
            $("#pic3").attr("src","../upload/goods_pic"+data.pic3);
            $("#pic4").attr("src","../upload/goods_pic"+data.pic4);




            //分类这里需要回显
            //分类这里不用回显
            $.ajax({
                url:path+"/typeControl/parentTypeList",
                async:false,
                type:"POST",
                dataType:"json",
                success:function(res){
                    $(res).get().forEach(function (item) {
                        $("select[name=parentTypeId]").append("<option value='"+item.id+"'>"+item.name+"</option>");
                    });
                    form.render();
                },
                error:function (xhr,textStatus) {
                    layer.alert("错误:"+textStatus, {icon: 2});
                },
            });
            //使用layui的selecct回调实现二级联动
            form.on('select(selectDemo)', function(data){
                // console.log(data.elem); //得到select原始DOM对象
                // console.log(data.value); //得到被选中的值
                // console.log(data.othis); //得到美化后的DOM对象
                var value = data.value;
                if(value!=""){
                    $.ajax({
                        url:path+"/typeControl/typeList?parentTypeId="+value,
                        async:false,
                        type:"GET",
                        dataType:"json",
                        success:function(res){
                            console.log(res);
                            $("select[name=typeId]").find($("option")).remove();
                            $("select[name=typeId]").append("<option value=''>二级分类</option>");
                            $(res).get().forEach(function (item) {
                                $("select[name=typeId]").append("<option value='"+item.id+"'>"+item.name+"</option>");
                            });
                            form.render();
                        },
                        error:function (xhr,textStatus) {
                            layer.alert("错误:"+textStatus, {icon: 2});
                        },
                    });
                }else{
                    $("select[name=typeId]").find($("option")).remove();
                    $("select[name=typeId]").append("<option value=''>请先选择一级分类</option>");
                }
            });
            //二级回显

            // var str2 = "option[value="+data.typeId+"]";
            // $("select[name=typeId]").children(str2).attr("select",true);
            // form.render();
        })

    });
</script>

</body>
<input id="path" value="${pageContext.request.contextPath}" type="hidden">
</html>
