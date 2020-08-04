<%--
  Created by IntelliJ IDEA.
  User: wVim
  Date: 2020/8/1
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>平台商品分类管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=no, minimum-scale=0.8, initial-scale=1,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/lib/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/static/X-admin/lib/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/static/X-admin/js/xadmin.js"></script>
</head>
<body style="background-color: #bfdff6">
<div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">演示</a>
            <a><cite>导航元素</cite></a>
          </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新"><i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>

</div>
<div class="layui-fluid" style="height: 85%">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">
                    平台商品分类管理
                </div>
                <div class="layui-card-body">
                    <form class="layui-form layui-col-space5" lay-filter="formTest"  >
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="name"  placeholder="请输入商品类型名称" autocomplete="off" class="layui-input" id="name" >
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <select class="layui-form-select" name="parentId" >
                                <option value="">请选择分类级别</option>
                                <option value="0">一级分类</option>
                                <option value="1">二级分类</option>
                            </select>
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <select class="layui-form-select" name="state" ></select>
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <button type="button" class="layui-btn"  title="搜索" lay-submit=""  lay-filter="go"><i class="layui-icon">&#xe615;</i></button>
                        </div>
                    </form>
                    <table id="test" lay-filter="test"></table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    layui.use(['form','table','jquery','layer','laytpl','laydate'], function(){
        var $ = layui.jquery;
        var form = layui.form;
        var table = layui.table;
        var layer = layui.layer;
        var laydate = layui.laydate;
        var laytpl = layui.laytpl;

        var path = $("#path").val();

        $(function () {
            $.ajax({
                url:path+"/typeControl/findTypeState",
                async:false,
                type:"POST",
                dataType:"json",
                success:function(res){
                    window.properties = res;
                    $("select[name=state]").append("<option value=''>分类状态</option>")
                    $(res).get().forEach(function (item) {
                        $("select[name=state]").append("<option value='"+item.value+"'>"+item.name+"</option>")
                    });
                    form.render();
                },
                error:function (xhr,textstatus) {
                    layer.alert("错误:"+textstatus, {icon: 2});
                },
            });
        });


        var tableIns = table.render({
            elem: '#test'//容器id
            ,id:'idTest'//结合checkStatus使用
            ,toolbar: '#toolbarDemo'
            ,height: 550
            ,url: '${pageContext.request.contextPath}/typeControl/searchTypeList' //数据接口
            ,method:'get'
            ,request: {
                pageName: 'curPage' //改变页码的参数名称，默认：page，接在url后
                ,limitName: 'pageSize' //改变每页数据量的参数名，默认：limit，接在url后
            }
            ,page: { //可以是boolean值，也支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem,这两个参数需要将table模块的page设为false，单独使用laypage模块并render）
                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip','refresh'] //自定义分页布局排版
                ,limit:12 //每页显示12条数据
                ,limits:[3,6,9,12,15,20]//可选每页分页数
                ,curr: 1 //设定初始在第 1 页
                ,groups: 3 //只显示 3 个连续页码
                ,first: '到首页' //显示首页
                ,last: '到尾页' //显示尾页
                ,theme: '#ccc75e'//主题颜色
            }
            ,parseData: function(res){ //res 即为原始返回的数据
                console.log(res);
                res.data=res.data.map(function (item) {
                    if(item.parentId==0){
                        item.menuLevel="一级分类";
                    }else{
                        item.menuLevel="二级分类";
                    }
                    return item;
                });
                return {
                    "code": res.code, //解析数据接口返回状态
                    "msg": "", //解析提示文本
                    "count": res.count, //解析数据长度
                    "data": res.data //解析数据列表[]
                };
            }
            ,cols: [[ //表头
                ,{field: 'id', title: 'ID',  sort: true, hide:true}
                ,{field: 'name', title: '分类名称', align:'center', sort: true}
                // ,{field: 'parentId', title: '父分类id', align:'center', sort: true, hide:true}
                ,{field: 'menuLevel', title: '分类级别', align:'center', sort: true}
                ,{field:'', title: '分类图标'
                    ,templet: function(d){
                        var iconUrl = "${pageContext.request.contextPath}/upload/typeIcon"+d.iconUrl;
                        return '<div id="'+'myIcon'+d.id+'"><img src="'+iconUrl+'"></div>';
                    }
                }
                ,{field: '', title: '分类状态', align:'center', sort: true ,templet: function(d){
                        var temp;
                        window.properties.forEach(function (item) {
                            if(d.state==item.value){
                                temp=item.name;
                                return;
                            }
                        })
                        return temp;
                    }}
                ,{field: 'operation', title: '操作',  sort: true,align:'center',toolbar: '#barDemo'}
            ]]
            ,done: function(res, curr, count){
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                res.data.forEach(function (item) {
                    layer.photos({
                        photos: ('#myIcon'+item.id)
                        ,anim: 5 //0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
                    });
                });

            }
        });

        form.on('submit(go)',function (data) {
            tableIns.reload({
                where: {
                    name: data.field.name
                    ,parentId: $("select[name=parentId]").children(":selected").val()
                    ,state:$("select[name=state]").children(":selected").val()
                }
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
            return false;
        });



        // 头部工具栏监听事件
        table.on('toolbar(test)', function(obj){
            if(obj.event=='添加一级分类'){
                window.tempData={id:"0",menuLevel:"一级分类"};
                xadmin.open('新增分类','${pageContext.request.contextPath}/jsp/type-add.jsp',600,400);
            }if(obj.event=='分类图片上传'){
                window.open('${pageContext.request.contextPath}/jsp/typeIconUpload.jsp','_blank');
            }
        });

        //行工具栏监听事件
        table.on('tool(test)', function(obj){ //注：tool 显示是工具条的事件名，test 是 table的lay-filter=属性值
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的自定义事件名（也可以是表头的 event 参数对应的事件名）
            var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

            if(layEvent=='修改'){
                window.tempData = data;
                xadmin.open('修改分类','${pageContext.request.contextPath}/jsp/type-edit.jsp',600,400);
            }else if(layEvent=='添加子分类'){
                window.tempData = data;
                window.tempData.menuLevel="二级分类";
                xadmin.open('新增分类','${pageContext.request.contextPath}/jsp/type-add.jsp',600,400);
            }else if(layEvent=='切换状态'){
                if(true){
                    $.ajax({
                        url:path+"/typeControl/changeTypeState",
                        async:false,
                        type:"POST",
                        data:"id="+data.id+"&state="+data.state,
                        dataType:"text",
                        success:function(res){
                            console.log(res);
                            if(res!=0){
                                layer.msg("操作成功",{time:1000});
                                tableIns.reload();
                            }else{
                                layer.msg("操作失败",{time:1000});
                            }
                        },
                        error:function (xhr,textStatus) {
                            layer.alert("错误:"+textStatus, {icon: 2});
                        },
                    });
                }
            }
        });



    });
</script>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
<%--        <button class="layui-btn layui-btn-sm" lay-event="分类图片上传">分类图片上传</button>--%>
        <button class="layui-btn layui-btn-sm" lay-event="添加一级分类">添加一级分类</button>
    </div>
</script>
<script type="text/html" id="barDemo">
    {{#  if(d.menuLevel=='一级分类'){ }}
    <a class="layui-btn layui-btn-xs" lay-event="修改">修改</a>
    <a class="layui-btn layui-btn-xs" lay-event="添加子分类">添加子分类</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="切换状态">切换状态</a>
    {{#  }else if(d.menuLevel=='二级分类'){ }}
    <a class="layui-btn layui-btn-xs" lay-event="修改">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="切换状态">切换状态</a>
    {{#  } }}
</script>

<input id="path" value="${pageContext.request.contextPath}" type="hidden">

</html>

