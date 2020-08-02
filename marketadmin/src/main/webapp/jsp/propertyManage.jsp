<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/7
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>商店管理员管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/X-admin/css/font.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/X-admin/css/xadmin.css">
    <script src="<%=request.getContextPath()%>/static/X-admin/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/X-admin/js/xadmin.js"></script>

</head>

<body>
<input type="hidden" value="<%=request.getContextPath()%>" id="path">
<div class="x-nav">
            <span class="layui-breadcrumb">
                <a href="">首页</a>
                <a href="">演示</a>
                <a>
                    <cite>导航元素</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
    </a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <%--                    <form class="layui-form layui-col-space5">--%>
                    <div class="layui-inline layui-show-xs-block">
                        <input class="layui-input" autocomplete="off" placeholder="开始日" name="start" id="start">
                    </div>
                    <div class="layui-inline layui-show-xs-block">
                        <input class="layui-input" autocomplete="off" placeholder="截止日" name="end" id="end"></div>
                    <div class="layui-inline layui-show-xs-block">
                        <input type="text" name="userName" placeholder="管理员名字" autocomplete="off" class="layui-input"
                               id="userName">
                    </div>
                    <div class="layui-inline layui-show-xs-block">
                        <input type="text" name="shopName" placeholder="商店名" autocomplete="off" class="layui-input"
                               id="shopName">
                    </div>
                    <div class="layui-inline layui-show-xs-block">
                        <input type="text" name="account" placeholder="账号" autocomplete="off" class="layui-input"
                               id="account">
                    </div>
                    <div class="layui-inline layui-show-xs-block">
                        <button class="layui-btn" id="search"><%--lay-submit="" lay-filter="search"--%>
                            <i class="layui-icon">&#xe615;</i></button>
                    </div>
                    <%--                    </form>--%>
                </div>
                <div class="layui-card-body layui-table-body layui-table-main">
                    <table id="test" class="layui-table layui-form" lay-filter="test">

                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
<%--        <button class="layui-btn layui-btn-sm" lay-event="getCheckData"> 获取选中行数据</button>--%>
<%--        <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>--%>
<%--        <button class="layui-btn layui-btn-sm" lay-event="isAll"> 验证是否全选</button>--%>
        <button class="layui-btn layui-btn-sm" lay-event="addAdmin">新增管理员</button>
    </div>
</script>


<script id="barDemo" type="text/html">

    <a class="layui-btn layui-btn-xs " lay-event="changeState">修改参数</a>

</script>
<%--<script type="text/html" id="switchTpl">--%>
<%--    <!-- 这里的checked的状态只是演示 -->--%>
<%--        <input type="checkbox" name="userSex" value="{{d.userSex}}" lay-skin="switch" lay-text="女|男" lay-filter="userSex" {{ d.userSex==--%>
<%--               10003 ?'checked': ''}} >--%>
<%--</script>--%>
<script>layui.use('laydate',
    function () {
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素

        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素

        });

    });</script>
<script>

    var b=false;
    var propertyDate;

    layui.use(['table', 'form', 'laytpl', 'layer'],
    function () {
        var table = layui.table
            , form = layui.form
            , laytpl = layui.laytpl;
        var path = $('#path').val();

        //监听单元格编辑
        table.on('edit(test)',
            function (obj) {
                var value = obj.value //得到修改后的值
                    ,
                    data = obj.data //得到所在行所有键值
                    ,
                    field = obj.field; //得到字段
                layer.msg('[ID: ' + data.id + '] ' + field + ' 字段更改为：' + value);
            });

        //头工具栏事件
        table.on('toolbar(test)',
            function (obj) {
                var checkStatus = table.checkStatus(obj.config.id);
                switch (obj.event) {
                    case 'addAdmin':
                        var data = checkStatus.data;
                        b=true;

                        layer.confirm('新增管理员？', {
                            btn: ['确定','取消'] //按钮
                        }, function(){
                            layer.msg("打开新窗口")
                            layer.open({
                                title: '订单详情',
                                shadeClose:false,
                                maxmin: true,
                                type: 2,
                                content: path + "/jsp/property-edit.jsp",
                                area: ['500px', '400px']
                            });
                        },
                        );



                        break;
                    case 'getCheckLength':
                        var data = checkStatus.data;
                        layer.msg('选中了：' + data.length + ' 个');
                        break;
                    case 'isAll':
                        layer.msg(checkStatus.isAll ? '全选' : '未全选');
                        break;
                };
            });

        $('#search').click(function () {
            layer.msg("搜索中");
            tableIns.reload({
                where: { //设定异步数据接口的额外参数，任意设
                    startTime: $('#start').val()
                    , endTime: $('#end').val()
                    , account: $('#account').val()
                    , shopName: $('#shopName').val()
                    , userName: $('#userName').val()
                    //…
                }
                , page: {
                    curr: 1 //重新从第 1 页开始
                }
            });

        });
        //监听行工具事件
        table.on('tool(test)', function (obj) {
            propertyDate = obj.data;
            console.log(obj);
            if (obj.event === 'changeState') {

                b=false ;
                layer.confirm('是否修改参数值和名称？', {
                        btn: ['确定','取消'] //按钮
                    }, function(){
                        layer.msg("打开新窗口");
                        layer.open({
                            title: '订单详情',
                            shadeClose:false,
                            maxmin: true,
                            type: 2,
                            content: path + "/jsp/property-edit.jsp",
                            area: ['500px', '400px']
                        });
                    },
                );
            }

        });

        var tableIns = table.render({
            elem: '#test'
            , height: 700
            // ,toolbar: '#toolbarDemo'
            , url: path + "/propertyControl/findProperty" //数据接口
            , page: true //开启分页
            , limit: 10
            , id: 'id'
            , cols: [[ //表头
                {checkbox: true, fixed: true}
                , {field: 'typeText', title: '参数名称中文', sort: true, width: 150}
                , {field: 'type', title: '参数名称英文', width: 150}
                , {field: 'name', title: '属性名', sort: true, width: 150}
                , {field: 'value', title: '属性值', sort: true, width: 150}

                , {title: '操作', toolbar: '#barDemo', width: 300}

            ]]

        });

    });</script>


</html>
