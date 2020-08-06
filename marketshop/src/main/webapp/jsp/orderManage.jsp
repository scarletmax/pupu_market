<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/29
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.2</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/X-admin/css/font.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/X-admin/css/xadmin.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/X-admin/lib/layui/css/modules/laydate/default/laydate.css">
    <%--    <script src="<%=request.getContextPath()%>/web/X-admin/lib/layui/lay/modules/jquery.js" charset="utf-8"></script>--%>
    <script src="<%=request.getContextPath()%>/static/js/jquery-3.5.1.js" charset="utf-8"></script>
    <script src="<%=request.getContextPath()%>/static/X-admin/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/X-admin/js/xadmin.js"></script>
    <script src="<%=request.getContextPath()%>/static/layui/lay/modules/form.js" charset="utf-8"></script>
    <%--    <script src="<%=request.getContextPath()%>/web/staticFile/layui-v2.5.6/layui.all.js" charset="utf-8"></script>--%>
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
                        <input type="text" name="fileName" placeholder="请输入快递员" autocomplete="off"
                               class="layui-input"
                               id="deliverymanName">
                    </div>
<%--                        <div class="layui-inline layui-show-xs-block">--%>
<%--                            <input type="text" name="fileName" placeholder="请输入商店名" autocomplete="off"--%>
<%--                                   class="layui-input"--%>
<%--                                   id="shopName">--%>
<%--                        </div>--%>
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="fileName" placeholder="请输入用户名" autocomplete="off"
                                   class="layui-input"
                                   id="userName">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="fileName" placeholder="请输入收货人" autocomplete="off"
                                   class="layui-input"
                                   id="receiptName">
                        </div>

                    <div class="layui-inline layui-show-xs-block" >

<%--                        <select  id="fileType">--%>
<%--                            <option>--请选择类型--</option>--%>
<%--                            <c:forEach var="i" items="${fileList}">--%>

<%--                                <option>${i.typeSuffix} </option>--%>
<%--                            </c:forEach>--%>
<%--                        </select>--%>

                    </div>

                    <div class="layui-inline layui-show-xs-block">
                        <button class="layui-btn"  id="search"><%--lay-submit="" lay-filter="search"--%>
                            <i class="layui-icon">&#xe615;</i></button>
                    </div>
                    <%--                    </form>--%>
                </div>
                <div class="layui-card-body layui-table-body layui-table-main">
                    <table id="test" class="layui-table layui-form"
<%--                           lay-data="{url:'<%=request.getContextPath()%>/order/orderlist',page:true,toolbar: '#toolbarDemo',id:'test'}"--%>
                           lay-filter="test">
<%--                        <thead>--%>
<%--                        <tr>--%>
<%--                            <th lay-data="{type:'checkbox'}">ID</th>--%>
<%--                            <th lay-data="{field:'id', width:30, sort: true}">ID</th>--%>
<%--                            <th lay-data="{field:'shopName', width:120, sort: true, edit: 'text'}">商店名</th>--%>
<%--                            <th lay-data="{field:'totalPrice', width:120, sort: true, edit: 'text'}">订单总价</th>--%>
<%--                            <th lay-data="{field:'createTime', width:120, sort: true, edit: 'text'}">创建时间</th>--%>
<%--                            <th lay-data="{field:'receiveTime', width:120, sort: true, edit: 'text'}">送达时间</th>--%>
<%--                                                        <th lay-data="{field:'finishTime', width:120, sort: true, edit: 'text'}">结束时间</th>--%>
<%--                                                        <th lay-data="{field:'stateStr', width:120, sort: true, edit: 'text'}">订单状态</th>--%>
<%--                            <th lay-data="{field:'orderNum', width:120, sort: true, edit: 'text'}">订单号</th>--%>
<%--                            <th lay-data="{field:'name', edit: 'text', minWidth: 100}">接收者名称</th>--%>
<%--                            <th lay-data="{field:'address', edit: 'text', minWidth: 100}">地址</th>--%>
<%--                            <th lay-data="{field:'roomNum', sort: true,width:120, edit: 'text'}">门牌号</th>--%>
<%--                            <th lay-data="{field:'longitude', sort: true,width:120, edit: 'text'}">经度</th>--%>
<%--                            <th lay-data="{field:'latitude', sort: true,width:120, edit: 'text'}">纬度</th>--%>
<%--                            <th lay-data="{field:'tel', sort: true,width:120, edit: 'text'}">电话</th>--%>
<%--                            <th lay-data="{field:'deliverymanName', sort: true,width:120, edit: 'text'}">送货员名称</th>--%>
<%--                            <th lay-data="{field:'userName', sort: true,width:120, edit: 'text'}">用户名</th>--%>
<%--&lt;%&ndash;                            <th lay-data="{field:'roomNum', sort: true,width:120, edit: 'text'}">门牌号</th>&ndash;%&gt;--%>
<%--                            <th lay-data="{field:'couponName', sort: true,width:120, edit: 'text'}">优惠券名</th>--%>

<%--                            <th lay-data="{fixed: 'right', width:250, align:'center', toolbar: '#barDemo'}">操作</th>--%>
<%--                        </tr>--%>
<%--                        </thead>--%>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="getCheckData"> 获取选中行数据</button>
        <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
        <button class="layui-btn layui-btn-sm" lay-event="isAll"> 验证是否全选</button>
    </div>
</script>
<script type="text/html" id="switchTpl">
    <!-- 这里的checked的状态只是演示 -->
    <%--    <input type="checkbox" name="sex" value="{{d.id}}" lay-skin="switch" lay-text="女|男" lay-filter="sexDemo" {{ d.id==--%>
    <%--           10003?'checked': ''}} >--%>
</script>

var orderInf;

<script>

    layui.use('laydate',
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
    layui.use('table',
        function () {
            var table = layui.table;
            var form = layui.form;
            var path=$('#path').val();


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
                        case 'getCheckData':
                            var data = checkStatus.data;
                            layer.alert(JSON.stringify(data));
                            break;
                        case 'getCheckLength':
                            var data = checkStatus.data;
                            layer.msg('选中了：' + data.length + ' 个');
                            break;
                        case 'isAll':
                            layer.msg(checkStatus.isAll ? '全选' : '未全选');
                            break;
                    }
                    ;
                });





        });


</script>

<script>

    $(function () {
        var path=$('#path').val();
        layui.use(
            'table',function () {
                var table = layui.table;
                var form = layui.form;


                console.log("dddddd");
             var tableIns =  table.render({
                    elem: '#test'
                    ,height: 700
                    ,url: path+"/order/orderlist" //数据接口
                    ,page: true //开启分页
                    ,limit:10
                    ,id:'id'
                    ,couponId:'couponId'
                    ,cols: [[ //表头
                        {checkbox: true, fixed: true}
                        ,{field: 'shopName', title: '商店名', sort: true, fixed: 'left',width:100}
                        ,{field: 'totalPrice', title: '订单总价', sort: true, fixed: 'left',width:120}
                        ,{field: 'createTime' ,width:200, title: '创建时间' ,templet : "<div>{{#if(d.createTime!=null){}}{{layui.util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')}}{{#} }}</div>"}
                        ,{field: 'receiveTime' ,width:200, title: '送达时间' ,templet : "<div>{{#if(d.receiveTime!=null){}}{{layui.util.toDateString(d.receiveTime, 'yyyy-MM-dd HH:mm:ss')}}{{#} }}</div>"}
                        ,{field: 'finishTime' ,width:200, title: '结束时间' ,templet : "<div>{{#if(d.finishTime!=null){}}{{layui.util.toDateString(d.finishTime, 'yyyy-MM-dd HH:mm:ss')}}{{#} }}</div>"}
                        ,{field: 'stateStr', title: '订单状态', sort: true,width:80}
                        ,{field: 'orderNum', title: '订单号',width:110}
                        ,{field: 'name', title: '收货人',width:100}
                        ,{field:'address',title:'地址',width:90}
                        ,{field: 'roomNum', title: '门牌号',width:90}

                        ,{field: 'longitude', title: '经度',width:110}
                        ,{field: 'latitude', title: '纬度',width:100}
                        ,{field:'tel',title:'收货人电话',width:120}
                        ,{field: 'deliverymanName', title: '送货员名称',width:90}

                        ,{field:'userName',title:'用户名',width:90}
                        ,{field: 'couponName', title: '优惠券名',width:90}
                        ,{title: '操作' ,toolbar:'#barDemo',width:300}

                    ]]


                });
                $('#search').click(function () {
                    // alert("c");*/
                    console.log("来了="+$('#start').val());
                    tableIns.reload({
                        where: { //设定异步数据接口的额外参数，任意设
                            startTime:$('#start').val()
                            , endTime:$('#end').val()
                            ,deliverymanName:$('#deliverymanName').val()
                            ,shopName:$('#shopName').val()
                            ,userName:$('#userName').val()
                            ,receiptName:$('#receiptName').val()
                            //…
                        }
                        , page: {
                            curr: 1 //重新从第 1 页开始
                        }
                    });

                });

                table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"

                    console.log("sdfsdf");
                    // debugger
                    orderInf = obj.data; //获得当前行数据
                    var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                    var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

                    if(layEvent === 'viewOrder'){ //审核
                        //do something
                        layui.use('layer', function () {
                            layer.open({
                                title: '订单详情',
                                shadeClose:false,
                                maxmin: true,
                                type: 2,
                                content: path + "/jsp/orderInf.jsp",
                                area: ['500px', '600px']
                            });
                        });

                    }else if (obj.event === 'enable') {

                        console.log("obj.event="+obj.tr.firstChild);
                        layer.confirm("是否接单？？", function () {


                            $.ajax({
                                url: path + "/order/changeState",
                                type: 'post',
                                data: {"id": orderInf.id, "purpose": "enable"},
                                async: true,
                                dataType: 'text',
                                success: function (msg) {
                                    if (msg === "success") {
                                        layer.msg("success");
                                        obj.update({
                                            stateStr: "已接单",
                                            toolBar:''
                                        });
                                        tableIns.reload();
                                    } else {
                                        layer.msg("fail");
                                    }
                                },
                                error:function () {
                                    alert("网络错误")
                                }
                            });
                        })
                    } else if (obj.event === 'disable') {

                        layer.confirm("拒绝接单？？", function () {


                            $.ajax({
                                url: path + "/order/changeState",
                                type: 'post',
                                data: {"id": orderInf.id, "purpose": "disable"},
                                async: true,
                                dataType: 'text',
                                success: function (msg) {
                                    if (msg === "success") {
                                        layer.msg("success");
                                        obj.update({
                                            stateStr: "订单取消",
                                            toolBar:''
                                        });
                                        tableIns.reload();
                                    } else {
                                        layer.msg("fail");
                                    }
                                },
                                error:function () {
                                    alert("网络错误")
                                }
                            });
                        })
                    }



                });
            })

        //监听行工具事件
        // table.on('tool(test)', function (obj) {
        //     var data = obj.data;
        //     console.log(obj);
        //     if (obj.event === 'enable') {
        //
        //         console.log("obj.event="+obj.tr.firstChild);
        //         layer.confirm("是否接单？？", function () {
        //
        //
        //             $.ajax({
        //                 url: path + "/order/changeState",
        //                 type: 'post',
        //                 data: {"id": data.id, "purpose": "enable"},
        //                 async: true,
        //                 dataType: 'text',
        //                 success: function (msg) {
        //                     if (msg === "success") {
        //                         layer.msg("success");
        //                         obj.update({
        //                             stateStr: "已接单",
        //                             toolBar:''
        //                         });
        //                         tableIns.reload();
        //                     } else {
        //                         layer.msg("fail");
        //                     }
        //                 },
        //                 error:function () {
        //                     alert("网络错误")
        //                 }
        //             });
        //         })
        //     } else if (obj.event === 'disable') {
        //
        //         layer.confirm("拒绝接单？？", function () {
        //
        //
        //             $.ajax({
        //                 url: path + "/order/changeState",
        //                 type: 'post',
        //                 data: {"id": data.id, "purpose": "disable"},
        //                 async: true,
        //                 dataType: 'text',
        //                 success: function (msg) {
        //                     if (msg === "success") {
        //                         layer.msg("success");
        //                         obj.update({
        //                             stateStr: "订单取消",
        //                             toolBar:''
        //                         });
        //                         tableIns.reload();
        //                     } else {
        //                         layer.msg("fail");
        //                     }
        //                 },
        //                 error:function () {
        //                     alert("网络错误")
        //                 }
        //             });
        //         })
        //     }
        //
        // });
    })
</script>

<script type="text/html" id="barDemo">
<%--    <a class="layui-btn layui-btn-xs" lay-event="download">下载</a>--%>
<%--    <a class="layui-btn layui-btn-xs" lay-event="pass">通过审核</a>--%>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="viewOrder">查看订单详情</a>


{{#  if(d.stateStr ==='订单取消'){ }}

<a class="layui-btn layui-btn-xs layui-btn-disabled">已取消</a>
{{# } else { }}
{{#  if(d.stateStr ==='未接单'){ }}

<a class="layui-btn layui-btn-xs " lay-event="enable">接单</a>
<a class="layui-btn layui-btn-xs "  lay-event="disable">拒绝接单</a>
{{# } else { }}
<a class="layui-btn layui-btn-xs layui-btn-warm layui-btn-disabled" >已接单</a>
{{# } }}

{{# } }}

</script>



</html>