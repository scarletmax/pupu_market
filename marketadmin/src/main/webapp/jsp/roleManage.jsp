<%--
  Created by IntelliJ IDEA.
  User: wVim
  Date: 2020/7/13
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>平台角色管理</title>
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
                    <div class="layui-row">
                        <div class="layui-col-md4">
                            角色管理
                        </div>
                    </div>
                </div>
                <div class="layui-card-body">
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

        var tableIns = table.render({
            elem: '#test'//容器id
            ,id:'idTest'//结合checkStatus使用
            ,height: 550
            ,toolbar: '#toolbarDemo'
            ,url: '${pageContext.request.contextPath}/roleControl/searchRoleList' //数据接口
            ,method:'get'
            ,request: {
                pageName: 'curPage' //改变页码的参数名称，默认：page，接在url后
                ,limitName: 'pageSize' //改变每页数据量的参数名，默认：limit，接在url后
            }
            ,page: false
            ,parseData: function(res){ //res 即为原始返回的数据
                return {
                    "code": res.code, //解析数据接口返回状态
                    "msg": "", //解析提示文本
                    "count": res.count, //解析数据长度
                    "data": res.data //解析数据列表[]
                };
            }
            ,cols: [[ //表头
                {field: 'id', title: 'ID', align:'center', sort: true}
                ,{field: 'name', title: '角色名称', align:'center', sort: true}
                ,{field: 'operation', title: '操作',  sort: true,align:'center',toolbar: '#barDemo'}
            ]]
        });

        // 头部工具栏监听事件
        table.on('toolbar(test)', function(obj){
            if(obj.event=='添加角色'){
                xadmin.open('添加角色','${pageContext.request.contextPath}/jsp/role-add.jsp',600,400);
            }
        });


        table.on('tool(test)', function(obj){ //注：tool 显示是工具条的事件名，test 是 table的lay-filter=属性值
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的自定义事件名（也可以是表头的 event 参数对应的事件名）
            var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

            if(layEvent=='修改'){
                window.tempData = data;
                xadmin.open('修改角色','${pageContext.request.contextPath}/jsp/role-edit.jsp',600,400);
            }else if(layEvent=='删除'){
                layer.msg("该功能暂未开放");
            }
        });


    });
</script>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="添加角色">添加角色</button>
    </div>
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="修改">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="删除">删除</a>
</script>

<input id="path" value="${pageContext.request.contextPath}" type="hidden">

</html>
