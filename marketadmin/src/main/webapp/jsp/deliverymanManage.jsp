
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.2</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.js" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/static/X-admin/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/static/X-admin/js/xadmin.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/js/deliverymanManage.js"></script>

</head>
<body>
<input hidden value="${pageContext.request.contextPath}" id="path">

<div class="x-nav">
          <span class="layui-breadcrumb">
            <a href="">首页</a>
            <a href="">演示</a>
            <a>
              <cite>导航元素</cite></a>
          </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">



                    <div class="layui-inline layui-show-xs-block">
                        <input type="text" name="name"  placeholder="请输入派送员姓名" autocomplete="off" class="layui-input" id="name">
                    </div>
                        <div class="layui-inline layui-show-xs-block">
                            <input type="text" name="account"  placeholder="请输入派送员账号" autocomplete="off" class="layui-input" id="account">
                        </div>
                        <div class="layui-form layui-input-inline layui-show-xs-block " lay-filter="mySelectDiv">
                            <select name="" id="mySelect" lay-filter="mySelect">
                            </select>
                        </div>

                    <div class="layui-inline layui-show-xs-block">
                        <button class="layui-btn"  id="search" lay-filter="search"><i class="layui-icon">&#xe615;</i></button>
                    </div>

                    <%--                    </form>--%>
                </div>
                <div class="layui-card-header">
                    <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
                    <button class="layui-btn" onclick="xadmin.open('添加用户','./member-add.html',600,400)"><i class="layui-icon"></i>添加</button>
                </div>
                <div class="layui-card-body layui-table-body layui-table-main">
                    <table id="demo" class="layui-table layui-form" lay-filter="demo">

                    </table>
                </div>

<%--                <div class="layui-hide" id="tools">--%>
<%--                    <a class="layui-btn layui-btn-xs" lay-event="downFile">下载</a>--%>
<%--                    <a class="layui-btn layui-btn-xs" lay-event="pass">审核通过</a>--%>
<%--                    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">审核不通过</a>--%>
<%--                </div>--%>

                <script type="text/html" id="tools">
                    {{#  if(d.stateStr =='审核中'){ }}
                    <a class="layui-btn layui-btn-xs" lay-event="pass">审核通过</a>
                    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">审核不通过</a>
                    {{# }if(d.stateStr =='审核不通过') { }}
                    {{# }if(d.stateStr =='禁用') { }}
                    <a class="layui-btn layui-btn-xs" lay-event="enable">启用</a>
                    {{# }if(d.stateStr =='启用') { }}
                    <a class="layui-btn layui-btn-xs" lay-event="disable">禁用</a>
                    {{#  } }}
               </script>




                <script type="text/html" id="passed">
                    <a class="layui-btn layui-btn-xs" lay-event="passed">已审核通过</a>
                </script>
                <script type="text/html" id="unPassed">
                    <a class="layui-btn layui-btn-xs" lay-event="unPassed">审核未通过</a>
                </div>

                <div class="page">

                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>
</body>
<script>
    layui.use(['laydate','form'], function(){
        var laydate = layui.laydate;
        var  form = layui.form;


        // 监听全选
        form.on('checkbox(checkall)', function(data){

            if(data.elem.checked){
                $('tbody input').prop('checked',true);
            }else{
                $('tbody input').prop('checked',false);
            }
            form.render('checkbox');
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#end' //指定元素
        });


    });

    /*用户-停用*/
    function member_stop(obj,id){
        layer.confirm('确认要停用吗？',function(index){

            if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});

            }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
            }

        });
    }

    /*用户-删除*/
    function member_del(obj,id){
        layer.confirm('确认要删除吗？',function(index){
            //发异步删除数据
            $(obj).parents("tr").remove();
            layer.msg('已删除!',{icon:1,time:1000});
        });
    }



    function delAll (argument) {
        var ids = [];

        // 获取选中的id
        $('tbody input').each(function(index, el) {
            if($(this).prop('checked')){
                ids.push($(this).val())
            }
        });

        layer.confirm('确认要删除吗？'+ids.toString(),function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
    }
</script>
</html>
