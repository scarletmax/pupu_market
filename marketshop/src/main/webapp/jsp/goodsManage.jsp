<%--
  Created by IntelliJ IDEA.
  User: wVim
  Date: 2020/8/3
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>分店商品管理</title>
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
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">
                    分店商品管理
                </div>
                <div class="layui-card-body">
                    <form class="layui-form layui-col-space5" lay-filter="formTest"  >
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="name"  placeholder="请输入商品名称" autocomplete="off" class="layui-input" id="name" >
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <select class="layui-form-select" name="parentTypeId" lay-filter="selectDemo">
                                <option value="">一级分类</option>
                            </select>
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <select class="layui-form-select" name="typeId">
                                <option value="">请先选择一级分类</option>
                            </select>
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="price_min" placeholder="起始价格" lay-verify="" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="price_max" placeholder="终止价格" lay-verify="" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-inline layui-show-xs-block">
                            <select class="layui-form-select" name="state" >
                                <option value="">请选择商品状态</option>
                            </select>
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




        var tableIns = table.render({
            elem: '#test'//容器id
            ,id:'idTest'//结合checkStatus使用
            ,toolbar: '#toolbarDemo'
            ,height: 480
            ,url: '${pageContext.request.contextPath}/goodsControl/searchGoodsList' //数据接口
            ,method:'get'
            ,where: {}//查询条件
            ,request: {
                pageName: 'curPage' //改变页码的参数名称，默认：page，接在url后
                ,limitName: 'pageSize' //改变每页数据量的参数名，默认：limit，接在url后
            }
            ,page: { //可以是boolean值，也支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem,这两个参数需要将table模块的page设为false，单独使用laypage模块并render）
                layout: ['limit', 'count', 'prev', 'page', 'next', 'skip','refresh'] //自定义分页布局排版
                ,limit:10 //每页显示6条数据
                ,limits:[3,6,9,12,15,20]//可选每页分页数
                ,curr: 1 //设定初始在第 1 页
                ,groups: 3 //只显示 3 个连续页码
                ,first: '到首页' //显示首页
                ,last: '到尾页' //显示尾页
                ,theme: '#ccc75e'//主题颜色
            }
            ,parseData: function(res){ //res 即为原始返回的数据
                console.log(res);
                console.log(res.album);
                return {
                    "code": res.code, //解析数据接口返回状态
                    "msg": "", //解析提示文本
                    "count": res.count, //解析数据长度
                    "data": res.data //解析数据列表[]
                };
            }
            ,cols: [[ //表头
                {type:'checkbox'}
                ,{field: 'name', title: '商品名称', width: '180px',align:'center', sort: true}
                ,{field: 'price', title: '价格',width: '100px', align:'center', sort: true}
                ,{ title: '特价状态',width: '100px', align:'center', sort: true,templet:function (d) {
                        return d.special==1?'<span style="color: #cc1c2f;">是</span>':'<span style="color: #3734cc;">否</span>';
                    }}
                ,{ title: '推荐状态', width: '100px',align:'center', sort: true ,templet:function (d) {
                    return d.recommended==1?'<span style="color: #cc1c2f;">是</span>':'<span style="color: #3734cc;">否</span>';
                    }}
                ,{field: 'specialPrice',width: '100px', title: '特价', align:'center', sort: true}
                ,{field: 'parentTypeString',width: '100px', title: '一级分类', align:'center', sort: true}
                ,{field: 'typeString', title: '二级分类',width: '150px', align:'center', sort: true}
                ,{field: 'totalCount', title: '剩余总数',width: '150px', align:'center', sort: true}
                ,{field: 'stateStr', title: '商品状态', width: '150px',align:'center', sort: true}
                ,{field: 'operation', title: '操作', width: '250px', align:'center',toolbar: '#barDemo'}
            ]]
        });

        form.verify({
            money: function(value){
                if(!/(?!^0*(\.0{1,2})?$)^\d{1,13}(\.\d{1,2})?$/.test(value)){
                    return "只能填数字";
                }
            }
           ,bigger : function(value){
                if(value<=$("input[name=price_min]").val()){
                    return "最大价格应大于最小价格";
                }
            }
        });

        form.on('submit(go)',function (data) {
            tableIns.reload({
                where: {
                    name: data.field.name
                    ,parentTypeId: $("select[name=parentTypeId]").children("option:selected").val()
                    ,typeId: $("select[name=typeId]").children("option:selected").val()
                    ,state: $("select[name=state]").children("option:selected").val()
                    ,price_min:data.field.price_min
                    ,price_max:data.field.price_max
                }
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
            return false;
        });

        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            var idArr = [];
            if(obj.event=="上架"){
                checkStatus.data.forEach(function (item) {
                    if(item.stateStr="待上架"){
                        idArr.push(item.id);
                    }
                });
                $.ajax({
                    url:path+"/goodsControl/putaway?idArr="+idArr,
                    async:false,
                    type:"GET",
                    dataType:"text",
                    before:function(){
                        if(idArr.length==0){
                            layer.msg("请选择状态为待上架中的商品上架！");
                            return false;
                        }
                    }
                    ,success:function(res){
                        console.log(res);
                        if(res!=0){
                            layer.msg("选中项中状态为待上架的商品已成功上架",{time:1000});
                            tableIns.reload();
                        }else{
                            layer.msg("操作失败",{time:1000});
                        }
                    },
                    error:function (xhr,textStatus) {
                        layer.alert("错误:"+textStatus, {icon: 2});
                    },
                });
            }if(obj.event=="下架") {
                checkStatus.data.forEach(function (item) {
                    if (item.stateStr == "销售中"||item.stateStr == "补货中") {
                        idArr.push(item.id);
                    }
                });
                $.ajax({
                    url: path + "/goodsControl/unshelve?idArr="+idArr,
                    async: false,
                    type: "GET",
                    dataType: "text",
                    before:function(){
                        if(idArr.length==0){
                            layer.msg("请选择状态为销售中/补货中的商品下架！");
                            return false;
                        }
                    }
                    ,success: function (res) {
                        console.log(res);
                        if (res != 0) {
                            layer.msg("选中项中状态为销售中/补货中的商品已成功下架", {time: 1000});
                            tableIns.reload();
                        } else {
                            layer.msg("操作失败", {time: 1000});
                        }
                    },
                    error: function (xhr, textStatus) {
                        layer.alert("错误:" + textStatus, {icon: 2});
                    },
                });
            }if(obj.event=="删除") {
                checkStatus.data.forEach(function (item) {
                    if (item.stateStr = "待上架") {
                        idArr.push(item.id);
                    }
                });
                $.ajax({
                    url:path+"/goodsControl/deleteGoods?idArr="+idArr,
                    async:false,
                    type:"GET",
                    dataType:"text",
                    before:function(){
                        if(idArr.length==0){
                            layer.msg("请选择待上架的商品删除！");
                            return false;
                        }
                    }
                    ,success:function(res){
                        console.log(res);
                        if(res!=0){
                            layer.msg("选中项中状态为待上架的商品已成功删除",{time:1000});
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

        });


        //行工具栏监听事件
        table.on('tool(test)', function(obj){ //注：tool 显示是工具条的事件名，test 是 table的lay-filter=属性值
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的自定义事件名（也可以是表头的 event 参数对应的事件名）
            var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

            if(layEvent=='查看详情'){
                window.tempData = data;
                xadmin.open('商品详情','${pageContext.request.contextPath}/jsp/good-detail.jsp',600,400);
            }else if(layEvent=='修改'){
                window.tempData = data;
                window.tempData.menuLevel="二级菜单"
                xadmin.open('新增菜单','${pageContext.request.contextPath}/jsp/menu-add.jsp',600,400);
            }else if(layEvent=='开启特价'){
                $.ajax({
                    url:path+"/goodsControl/startSpecial",
                    async:false,
                    type:"POST",
                    data:"id="+data.id,
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
            }else if(layEvent=='终止特价'){
                $.ajax({
                    url:path+"/goodsControl/endSpecial",
                    async:false,
                    type:"POST",
                    data:"id="+data.id,
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
            }else if(layEvent=='开启推荐'){
                $.ajax({
                    url:path+"/goodsControl/startRecommended",
                    async:false,
                    type:"POST",
                    data:"id="+data.id,
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
            }else if(layEvent=='终止推荐'){
                $.ajax({
                    url:path+"/goodsControl/endRecommended",
                    async:false,
                    type:"POST",
                    data:"id="+data.id,
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

        });



        $(function () {
            $.ajax({
                url:path+"/propertyControl/enumGoodsState",
                async:false,
                type:"POST",
                dataType:"json",
                success:function(res){
                    $(res).get().forEach(function (item) {
                        $("select[name=state]").append("<option value='"+item.value+"'>"+item.name+"</option>")
                    });
                    form.render();
                },
                error:function (xhr,textStatus) {
                    layer.alert("错误:"+textStatus, {icon: 2});
                },
            });

            $.ajax({
                url:path+"/typeControl/parentTypeList",
                async:false,
                type:"POST",
                dataType:"json",
                success:function(res){
                    $(res).get().forEach(function (item) {
                        $("select[name=parentTypeId]").append("<option value='"+item.id+"'>"+item.name+"</option>")
                    });
                    //
                    $("select[name=parentTypeId]").change(function () {
                        // alert("gaibian")


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
                            console.log(res)
                            $("select[name=typeId]").find($("option")).remove();
                            $("select[name=typeId]").append("<option value=''>二级分类</option>")
                            $(res).get().forEach(function (item) {
                                $("select[name=typeId]").append("<option value='"+item.id+"'>"+item.name+"</option>")
                            });
                            form.render();
                        },
                        error:function (xhr,textStatus) {
                            layer.alert("错误:"+textStatus, {icon: 2});
                        },
                    });
                }else{
                    $("select[name=typeId]").find($("option")).remove();
                    $("select[name=typeId]").append("<option value=''>请先选择一级分类</option>")
                }
            });







        })

    });
</script>

<input id="path" value="${pageContext.request.contextPath}">

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="新增商品">新增商品</button>
        <button class="layui-btn layui-btn-sm" lay-event="上架">上架</button>
        <button class="layui-btn layui-btn-sm" lay-event="下架">下架</button>
    </div>
</script>

<script type="text/html" id="barDemo">
    {{#  if(d.stateStr=='待上架'){ }}
    <a class="layui-btn layui-btn-xs" lay-event="查看详情">查看详情</a>
    <a class="layui-btn layui-btn-xs" lay-event="修改">修改</a>
<%--    <a class="layui-btn layui-btn-xs" lay-event="上架">上架</a>--%>
<%--    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="删除">删除</a>--%>
    {{#  }else if(d.stateStr=='销售中'||d.stateStr=='补货中'){ }}
    <a class="layui-btn layui-btn-xs" lay-event="查看详情">查看详情</a>
    <a class="layui-btn layui-btn-xs" lay-event="修改">修改</a>
        {{#  if(d.special=='0'){ }}
        <a class="layui-btn layui-btn-xs" lay-event="开启特价">开启特价</a>
        {{#  }else{ }}
        <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="终止特价">终止特价</a>
        {{#  } }}

        {{#  if(d.recommended=='0'){ }}
        <a class="layui-btn layui-btn-xs" lay-event="开启推荐">开启推荐</a>
        {{#  }else{ }}
        <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="终止推荐">终止推荐</a>
        {{#  } }}
<%--    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="下架">下架</a>--%>
    {{#  }else if(d.stateStr=='已下架'){ }}
    <a class="layui-btn layui-btn-xs" lay-event="查看详情">查看详情</a>
    {{#  } }}
</script>

</html>
