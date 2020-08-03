<%--
  Created by IntelliJ IDEA.
  User: wVim
  Date: 2020/8/2
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>图片上传</title>
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
<div>
    <div class="layui-upload">
        <button type="button" class="layui-btn layui-btn-normal" id="testList">选择图片（可多选）</button>
        <div class="layui-upload-list">
            <table class="layui-table">
                <thead><tr><th>标题</th><th>大小</th><th>状态</th><th>操作</th></tr></thead>
                <tbody id="demoList"></tbody>
            </table>
        </div>
        <button type="button" class="layui-btn" id="testListAction">开始上传</button>
    </div>
</div>

<input type="hidden" id="downloadScore" >
</div>
<script>


    layui.use(['form','table','jquery','layer','laytpl','upload'], function(){
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;
        var upload = layui.upload;
        var path = $("#path").val();

        Object.defineProperty(File,"name",{writable:true});

        // 多文件列表示例
        var demoListView = $('#demoList');

        var uploadListIns = upload.render({
            elem: '#testList'
            ,url: path+'/typeIconUploadControl/upload' //改成您自己的上传接口
            ,accept: 'images'
            ,acceptMime: 'image/*'
            // ,exts: suffixStr
            ,multiple: true
            ,auto: false
            ,bindAction: '#testListAction'
            ,choose: function(obj){//选择后的回调,选择的都文件符合accept、acceptMime、exts后才会触发
                var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列，不删除将一直存在files对象中
                // for(var a in window){
                //     if(a=="open"){
                //         window[a]("www.baidu.com");
                        // console.log( typeof window[a]);
                //     }
                // }

                obj.preview(function(index, myFile, result){//预读本地文件，如果是多文件，则会遍历index，为每个index都定义重传和删除的事件
                    var tr = $(['<tr id="upload-'+ index +'">'
                        ,'<td>'+ myFile.name +'</td>'
                        ,'<td>'+ (myFile.size/1024).toFixed(1) +'kb</td>'//kb保留一位小数
                        ,'<td>等待上传</td>'
                        ,'<td>'
                        +'<button class="layui-btn layui-btn-xs demo-edit">重命名</button>'
                        +'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
                        +'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
                        ,'</td>'
                        ,'</tr>'].join(''));//jq对象，此时还没有挂到dom树下

                    //单个重传，执行upload方法即为重传
                    tr.find('.demo-reload').on('click', function(){
                        obj.upload(index, myFile);
                    });

                    //删除
                    tr.find('.demo-delete').on('click', function(){
                        delete files[index]; //删除文件队列对应的文件
                        tr.remove();//删除表格dom
                        uploadListIns.config.elem.next()[0].value = ''; //清空 input myFile 值，以免删除后出现同名文件不可选
                    });

                    // tr.find('.demo-edit').on('click',function(){
                    //     $(this).parent().siblings().eq(0).text("fe556f");
                    //     debugger;
                    //     console.log(obj.pushFile()[index]["name"]);
                    //     console.log("缩印是"+index);
                    //     alert(obj.pushFile()[index] instanceof File);
                    //
                    //     obj.pushFile()[index].name = "fef";//为何无法赋值？？
                    //     obj.resetFile(index, myFile, function () {
                    //         return
                    //
                    //     });
                    //
                    // });

                    obj.resetFile(index, myFile, '123.jpg');

                    demoListView.append(tr);
                });
            }
            ,before: function(obj){//


                obj.preview(function(index, myFile, result){//预读本地文件，如果是多文件，则会遍历index，为每个index都定义重传和删除的事件
                //     tr.find('.demo-edit').on('click',function(){
                        // $(this).parent().siblings().eq(0).text("fe556f");
                        // debugger;
                        // console.log(obj.pushFile()[index]["name"]);
                        // console.log("缩印是"+index);
                        // alert(obj.pushFile()[index] instanceof File);
                        //
                        // obj.pushFile()[index].name = "fef";//为何无法赋值？？

                obj.resetFile(index, myFile, "fjjj.jpg");//无用。
                    // });

                });
            }
            ,done: function(res, index, upload){//每个文件提交一次触发一次，即每个index触发一次
                console.log(JSON.parse(res))
                if(res.code==0){ //上传成功
                    var tr = demoListView.find('tr#upload-'+ index);
                    var tds = tr.children();
                    tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
                    tds.eq(3).html(''); //清空所有操作
                    return delete this.files[index]; //删除文件队列已经上传成功的文件，对应列表tr信息保留
                }
                this.error(index, upload);//上传失败调用error回调函数
            }
            ,error: function(index, upload){//上传失败
                var tr = demoListView.find('tr#upload-'+ index);
                var tds = tr.children();
                tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
                tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
            }
        });








    })
</script>
<input id="path" value="${pageContext.request.contextPath}">

</body>
</html>
