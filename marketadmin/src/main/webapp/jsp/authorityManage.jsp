
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>权限管理</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.js" charset="utf-8"></script>
    <script charset="utf-8" type="text/javascript" src="${pageContext.request.contextPath}/js/authorityManage.js"></script>
    <script charset="utf-8" type="text/javascript" src="${pageContext.request.contextPath}/static/js/demoicon.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/authority.css">

</head>
<body>
<input hidden id="path" value="${pageContext.request.contextPath}">
<h1>权限管理</h1>
<div class="selection-container" id="firstDiv">
    <div class="select-box ">
        <div class="select-box-title">
            <span>角色</span>
        </div>
        <div id="roleDiv">
            <%--       <p> <input type="radio" value="1" name="role" checked onchange="changeRole(this)">超级管理员</p>--%>
            <%--        <p><input type="radio" value="2" name="role" onchange="changeRole(this)">普通管理员</p>--%>
        </div>
    </div>
    <div class="select-box left">
        <div class="select-box-title">
            <input type="checkbox" class="checkbox-all" id="checkbox-all1" />
            <label for="checkbox-all1"></label>
            <span>已分配菜单</span>
        </div>
        <div id="attr" class="select-content">
            <ul class="unselect-ul" id="unselect-ul">

            </ul>
        </div>
    </div>
    <div class="arrows-box">
        <div class="arrow-btns">

            <button class="arrow-btn right">
                <svg class="icon icon-seach" aria-hidden="true">
                    <use xlink:href="#icon-com-dajiantouyou"></use>
                </svg>
            </button>
            <button class="arrow-btn left">
                <svg class="icon icon-seach" aria-hidden="true">
                    <use xlink:href="#icon-com-dajiantouzuo"></use>
                </svg>
            </button>
            <button class="allMove" onclick="allRemove()"> >></button><br>
            <button class="allMove" onclick="allAttr()"><< </button>
        </div>
    </div>
    <div class="select-box right">
        <div class="select-box-title">
            <input type="checkbox" class="checkbox-all" id="checkbox-all2" />
            <label for="checkbox-all2"></label>
            <span>未分配菜单</span>
        </div>
        <div id="unattr"  class="select-content">
            <ul class="selected-ul" id="selected-ul">

            </ul>
        </div>
    </div>
</div>





</body>
</html>