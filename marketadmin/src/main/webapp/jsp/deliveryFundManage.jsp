<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.2</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.js" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/static/X-admin/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/static/X-admin/js/xadmin.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/js/deliveryFundManage.js"></script>


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
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"
       onclick="location.reload()" title="刷新">
        <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
</div>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                <div class="layui-card-body layui-table-body layui-table-main">
                    <table id="demo" class="layui-table layui-form" lay-filter="demo">

                    </table>
                </div>


                <script type="text/html" id="tools">
                    {{#  if(d.stateStr =='处理中'){ }}
                    <a class="layui-btn layui-btn-xs" lay-event="examine">审核通过</a>
                    <a class="layui-btn layui-btn-xs" lay-event="unExamine">审核不通过</a>
                    {{# }if(d.stateStr =='审核通过') { }}
                    {{# }if(d.stateText =='审核不通过') { }}
                    {{#  } }}
                </script>

            </div>
        </div>
    </div>
</div>
</div>
</div>
</div>
</body>
</html>
