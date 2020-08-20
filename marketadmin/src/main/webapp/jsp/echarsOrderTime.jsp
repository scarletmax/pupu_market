<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单时间统计</title>
    <style>
        .btn {
            width: 80px;
            height: 30px;
            border: 1px solid #60707F;
            color: #60707F;
            background-color: white;
        }

    </style>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/EChars/css/style.css">
    <script src="${pageContext.request.contextPath}/static/EChars/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/EChars/js/echarts.js"></script>
    <script src="${pageContext.request.contextPath}/static/EChars/js/json2.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/static/X-admin/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/static/X-admin/js/xadmin.js"></script>

    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/js/echarsOrderTime.js"></script>
</head>
<body>
<input type="hidden" id="path" value="${pageContext.request.contextPath}">
<div  style="text-align: center ">
    <div>
        <div class="layui-inline layui-show-xs-block">
           查询日期： <input class="layui-input" autocomplete="off"  name="selectDay" id="selectDay">
        </div>

        <div class="layui-inline layui-show-xs-block">
            <button class="layui-btn" id="search" onclick="findOrderAddByTime()"><i class="layui-icon">&#xe615;</i>
            </button>
        </div>
    </div>
</div>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;该时间内订单量为：<span
        id="total"></span>
</div>
<div id="echarts_div" style="width: 80%"></div>
</body>
</html>