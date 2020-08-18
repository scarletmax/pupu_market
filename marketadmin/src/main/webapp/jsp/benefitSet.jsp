
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


                    <div class="layui-form-item">
                        <label for="benefit" class="layui-form-label">
                            <span class="x-red">*</span>设置配送员每单的收益</label>
                        <div class="layui-input-inline">
                            <input type="number" id="benefit" name="benefit" required=""
                                    autocomplete="off" class="layui-input"></div>
                    </div>
                    <div class="layui-inline layui-show-xs-block">
                        <button class="layui-btn"  id="search" lay-filter="search" onclick="set()"><i class="layui-icon">&#xe642;</i></button>

                   </div>

                    </div>
                    </div>
                    </div>
                    </div>
</div>

                    </body>
<script>
    $(function () {
        var path= $("#path").val();
        $.ajax({
            url:path+"/deliverymanControl/queryBenefit",
            async:true,
            dataType:"text",
            success:function (res) {
               $("#benefit").val(res)
            },
            error:function () {
                alert("网络错误")
            }
        })
    })
    function set() {
        var path= $("#path").val();
        var benefit=$("#benefit").val();
        var returnVal = true;
        var inputZ=benefit;
        var ArrMen= inputZ.split(".");    //截取字符串
       if(benefit>0 && benefit<=20){
           if(ArrMen.length==2){
               if(ArrMen[1].length>1){    //判断小数点后面的字符串长度
                   layer.msg("只能输入1位小数")
               }else {
                   console.log(benefit)
                   $.ajax({
                       url:path+"/deliverymanControl/setBenefit",
                       async:true,
                       data:{benefit:benefit},
                       dataType:"text",
                       success:function (res) {
                           if(res=="success"){
                               layer.msg("设置成功")
                           }
                       },
                       error:function () {
                           alert("网络错误")
                       }
                   })
               }
           }else {
               console.log(benefit)
               $.ajax({
                   url:path+"/deliverymanControl/setBenefit",
                   async:true,
                   data:{benefit:benefit},
                   dataType:"text",
                   success:function (res) {
                       if(res=="success"){
                           layer.msg("设置成功")
                       }
                   },
                   error:function () {
                       alert("网络错误")
                   }
               })
           }
       }else {
           layer.msg("只能输入0-20的小数")
       }
    }
</script>

</html>
