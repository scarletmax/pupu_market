<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>订单统计</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/order_count.css">
    <script src="${pageContext.request.contextPath}/static/EChars/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/EChars/js/echarts.js"></script>
    <script src="${pageContext.request.contextPath}/static/EChars/js/json2.js"></script>
    <script  charset="utf-8"  src="${pageContext.request.contextPath}/js/echarsOrderCount.js"></script>
</head>
<body>
<h1>订单统计</h1>
<input id="weekBtn" type="button" value="本周"  onclick="toWeek()" disabled style="background-color:grey;">
<input id="monthBtn" type="button" value="本月" onclick="toMonth()">
<input id="yearBtn" type="button" value="近半年" onclick="toYear()">
<input type="hidden" id="path" value="${pageContext.request.contextPath}">

<span id="numMsg">数量</span><br>
	 <div id="echarts_div"></div>
<%--	 <div id="echarts_div2"></div>--%>
</body>
</html>