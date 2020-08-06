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
<input type="hidden" value="<%=application.getInitParameter("shopImg")%>" id="shopImg">
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
                    <%--                    <div class="layui-inline layui-show-xs-block">--%>
                    <%--                        <input type="text" name="bossName" placeholder="老板名字" autocomplete="off" class="layui-input"--%>
                    <%--                               id="bossName">--%>
                    <%--                    </div>--%>
                    <div class="layui-inline layui-show-xs-block">
                        <input type="text" name="shopName" placeholder="商店名" autocomplete="off" class="layui-input"
                               id="shopName">
                    </div>
                    <div class="layui-inline layui-show-xs-block">
                        <input type="text" name="bossName" placeholder="老板名字" autocomplete="off" class="layui-input"
                               id="bossName">
                    </div>
                    <div class="layui-inline layui-show-xs-block">


                            <select class="layui-input" name="shopId" lay-filter="aihao" id="sel">

                            </select>

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


    {{#  if(d.stateStr ==='审核不通过'){ }}

    <a class="layui-btn layui-btn-xs layui-btn-disabled">审核不通过</a>
    {{# } else { }}
    {{#  if(d.stateStr ==='审核中'){ }}

    <a class="layui-btn layui-btn-xs layui-btn-disabled">审核中</a>
    <a class="layui-btn layui-btn-xs " lay-event="pass">审核通过</a>
    {{# } else { }}
    <a class="layui-btn layui-btn-xs " lay-event="passing">审核中</a>
    <a class="layui-btn layui-btn-xs layui-btn-disabled">审核通过</a>
    {{# } }}
    <a class="layui-btn layui-btn-xs " lay-event="noPass">审核不通过</a>
    {{# } }}
    <%--    {{#  if(d.stateStr ==='已删除'){ }}--%>
    <%--   --%>
    <%--    {{# } else { }}--%>
    <%--    {{#  if(d.stateStr ==='已启用'){ }}--%>
    <%--  --%>
    <%--    {{# } else { }}--%>
    <%--    <a class="layui-btn layui-btn-xs " lay-event="enable">启用</a>--%>
    <%--    <a class="layui-btn layui-btn-xs layui-btn-disabled" lay-event="disable">禁用</a>--%>
    <%--    {{# } }}--%>
    <%--    <a class="layui-btn layui-btn-xs " lay-event="del">删除</a>--%>
    <%--    {{# } }}--%>
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
<script>layui.use(['table', 'form', 'laytpl', 'layer'],
    function () {
        var table = layui.table
            , form = layui.form
            , laytpl = layui.laytpl;
        var path = $('#path').val();
        var shopImg=$('#shopImg').val();

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

        // //头工具栏事件
        // table.on('toolbar(test)',
        //     function (obj) {
        //         var checkStatus = table.checkStatus(obj.config.id);
        //         switch (obj.event) {
        //             case 'addAdmin':
        //                 var data = checkStatus.data;
        //
        //
        //                 layer.confirm("新增管理员？？", function () {
        //
        //                     layer.open({
        //                         title: '订单详情',
        //                         shadeClose:false,
        //                         maxmin: true,
        //                         type: 2,
        //                         content: path + "/jsp/orderInf.jsp",
        //                         area: ['500px', '600px']
        //                     });
        //
        //                 });
        //
        //
        //                 break;
        //             case 'getCheckLength':
        //                 var data = checkStatus.data;
        //                 layer.msg('选中了：' + data.length + ' 个');
        //                 break;
        //             case 'isAll':
        //                 layer.msg(checkStatus.isAll ? '全选' : '未全选');
        //                 break;
        //         }
        //         ;
        //     });

        $('#search').click(function () {
            layer.msg("搜索中");
            tableIns.reload({
                where: { //设定异步数据接口的额外参数，任意设
                    startTime: $('#start').val()
                    , endTime: $('#end').val()
                    , account: $('#account').val()
                    , shopName: $('#shopName').val()
                    , bossName: $('#bossName').val()
                    ,state:$('#sel').val()
                    //…
                }
                , page: {
                    curr: 1 //重新从第 1 页开始
                }
            });

        });
        //监听行工具事件
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            console.log(obj);
            if (obj.event === 'pass') {

                console.log("obj.event=" + obj.tr.firstChild);
                layer.confirm("是否审核通过？？", function () {


                    $.ajax({
                        url: path + "/shopControl/changeShopState",
                        type: 'post',
                        data: {"id": data.id, "purpose": "pass"},
                        async: true,
                        dataType: 'text',
                        success: function (msg) {
                            if (msg === "success") {
                                layer.msg("success");
                                obj.update({
                                    stateStr: "审核通过",
                                    toolBar: ''
                                });
                                tableIns.reload();
                            } else {
                                layer.msg("fail");
                            }
                        },
                        error: function () {
                            alert("网络错误")
                        }
                    });
                })
            } else if (obj.event === 'passing') {

                layer.confirm("是否审核中？？", function () {


                    $.ajax({
                        url: path + "/shopControl/changeShopState",
                        type: 'post',
                        data: {"id": data.id, "purpose": "passing"},
                        async: true,
                        dataType: 'text',
                        success: function (msg) {
                            if (msg === "success") {
                                layer.msg("success");
                                obj.update({
                                    stateStr: "审核中",
                                    toolBar: ''
                                });
                                tableIns.reload();
                            } else {
                                layer.msg("fail");
                            }
                        },
                        error: function () {
                            alert("网络错误")
                        }
                    });
                })
            } else if (obj.event === 'noPass') {

                layer.confirm("是否审核不通过？？", function () {


                    $.ajax({
                        url: path + "/shopControl/changeShopState",
                        type: 'post',
                        data: {"id": data.id, "purpose": "noPass"},
                        async: true,
                        dataType: 'text',
                        success: function (msg) {
                            if (msg === "success") {
                                layer.msg("success");

                                obj.update({
                                    stateStr: "审核不通过",
                                    toolBar: ''
                                });
                                tableIns.reload();
                            } else {
                                layer.msg("fail");
                            }
                        },
                        error: function () {
                            alert("网络错误")
                        }
                    });
                })
            }

        });

        var tableIns = table.render({
            elem: '#test'
            , height: 700
            // ,toolbar: '#toolbarDemo'
            , url: path + "/shopControl/findShop" //数据接口
            , page: true //开启分页
            , limit: 10
            , id: 'id'
            , cols: [[ //表头
                {checkbox: true, fixed: true}
                , {field: 'name', title: '商店名', sort: true, fixed: 'left', width: 180}
                , {field: 'bossName', title: '老板', sort: true, fixed: 'left', width: 120}
                , {
                    field: 'createTime',
                    width: 200,
                    title: '创建时间',
                    templet: "<div>{{#if(d.createTime!=null){}}{{layui.util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')}}{{#} }}</div>"
                }

                , {field: 'longitude', title: '经度', sort: true, width: 120}
                , {field: 'latitude', title: '经度', sort: true, width: 120}
                , {field: 'pwd', title: '密码', width: 120}
                , {field: 'tel', title: '电话', width: 180}
                , {field: 'verifyID', title: '身份证', width: 180}
                , {field: 'verifyPic', title: '', width: 180,
                    templet: function(d) {

                        return '<div  class="verifyImg" onclick="show_verifyImg(this)" ><img src="'+"http://localhost:8081/"+ d.verifyPic + '" alt="" width="50px" height="50px"></a></div>';
                    }}
                , {field: 'shopPic', title: '', width: 180,
                    templet: function(d){

                        return '<div class="shopImg" onclick="show_shopImg(this)" ><img src="'+"http://localhost:8081/"+d.shopPic+'" alt="" width="50px" height="50px"></a></div>';

                    }
                }
                , {field: 'stateStr', title: '状态', width: 100}
                , {title: '操作', toolbar: '#barDemo', width: 300}

            ]]

        });


        $(function () {
            $.ajax({
                url: path + "/shopControl/findProperty",
                async: true,
                type: "post",
                dataType: "json",
                success: function (msg) {

                    console.log(msg);
                    $("#sel").append(" <option class='layui-input' value='0'>状态</option>");
                    $(msg).each(function (i) {
                        $("#sel").append(
                            " <option class='layui-input' value="+msg[i].value+">"+msg[i].name+"</option>"
                        )

                    });
                    form.render();
                }

            })

        });

    });
//查看照片
function show_verifyImg(t) {

    var t = $(t).find("img");

    console.log("$(t).attr('src')===="+$(t).attr('src'));

    //页面层

    layer.open({

        type: 1,

        skin: 'layui-layer-rim', //加上边框

        area: ['80%', '80%'], //宽高

        shadeClose: true, //开启遮罩关闭

        end: function (index, layero) {

            return false;

        },

        content: '<div style="text-align:center"><img src="'+ $(t).attr('src') + '" /></div>'

    });

}
//查看照片
function show_shopImg(t) {

    var t = $(t).find("img");

    //页面层

    layer.open({

        type: 1,

        skin: 'layui-layer-rim', //加上边框

        area: ['80%', '80%'], //宽高

        shadeClose: true, //开启遮罩关闭

        end: function (index, layero) {

            return false;

        },

        content: '<div style="text-align:center"><img src="'+ $(t).attr('src') + '" /></div>'

    });

}




</script>


<%--<script>--%>
<%--    layui.use('table', function(){--%>
<%--        var path=$("#path");--%>
<%--        var table = layui.table;--%>

<%--        //第一个实例--%>
<%--        table.render({--%>
<%--            elem: '#demo'--%>
<%--            ,height: 312--%>
<%--            ,url: path+'/adminServlet?methodName=listUser' //数据接口--%>
<%--            ,page: true //开启分页--%>
<%--            ,cols: [[ //表头--%>
<%--                {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}--%>
<%--                ,{field: 'username', title: '用户名', width:80}--%>
<%--                ,{field: 'sex', title: '性别', width:80, sort: true}--%>
<%--                ,{field: 'city', title: '城市', width:80}--%>
<%--                ,{field: 'sign', title: '签名', width: 177}--%>
<%--                ,{field: 'experience', title: '积分', width: 80, sort: true}--%>
<%--                ,{field: 'score', title: '评分', width: 80, sort: true}--%>
<%--                ,{field: 'classify', title: '职业', width: 80}--%>
<%--                ,{field: 'wealth', title: '财富', width: 135, sort: true}--%>
<%--            ]]--%>
<%--          --%>
<%--        });--%>

<%--    });--%>
<%--</script>--%>

</html>
