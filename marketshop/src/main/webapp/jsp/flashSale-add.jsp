<%--
  Created by IntelliJ IDEA.
  User: wVim
  Date: 2020/8/9
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>新增秒杀</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=no, minimum-scale=0.8, initial-scale=1,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/lib/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/css/xadmin.css">
    <script src="${pageContext.request.contextPath}/static/X-admin/lib/layui/layui.js"></script>
    <script src="${pageContext.request.contextPath}/static/X-admin/js/xadmin.js"></script>
</head>
<body>
<div class="layui-fluid" style="background-color: #f7f0de">
    <div class="layui-row">
        <div class="layui-col-md8 layui-col-md-offset2">
            <div class="layui-card" style="height: 400px">
                <div class="layui-card-header" style="text-align: center">
                    新增秒杀
                </div>
                <div class="layui-card-body">
                    <form class="layui-form" lay-filter="formTest">
                        <div class="layui-form-item layui-hide">
                            <label for="goodsId" class="layui-form-label">商品id</label>
                            <div class="layui-input-inline"><input type="text" id="goodsId" name="goodsId" lay-verify="required" autocomplete="off" class="layui-input"></div>
                        </div>
                        <div class="layui-form-item">
                            <label for="timeRange" class="layui-form-label">时间范围</label>
                            <div class="layui-input-inline"><input style="width: 300px" type="text" id="timeRange" name="timeRange" lay-verify="required" autocomplete="off" class="layui-input"></div>
                        </div>
                        <div class="layui-form-item layui-hide">
                            <label for="startTime" class="layui-form-label">开始时间</label>
                            <div class="layui-input-inline"><input type="text" id="startTime" name="startTime" lay-verify="needTime" autocomplete="off" class="layui-input"></div>
                        </div>
                        <div class="layui-form-item layui-hide">
                            <label for="endTime" class="layui-form-label">结束时间</label>
                            <div class="layui-input-inline"><input type="text" id="endTime" name="endTime"  lay-verify="needTime" autocomplete="off" class="layui-input"></div>
                        </div>
                        <div class="layui-form-item">
                            <label for="restCount" class="layui-form-label">秒杀总数量</label>
                            <div class="layui-input-inline"><input type="text" id="restCount" name="restCount" lay-verify="noPositive" autocomplete="off" class="layui-input"></div>
                        </div>
                        <div class="layui-form-item">
                            <label for="limitBuy" class="layui-form-label">限购数量</label>
                            <div class="layui-input-inline"><input type="text" id="limitBuy" name="limitBuy" lay-verify="noPositive" autocomplete="off" class="layui-input"></div>
                        </div>
                        <div class="layui-form-item">
                            <label for="flashPrice" class="layui-form-label">秒杀价</label>
                            <div class="layui-input-inline"><input type="text" id="flashPrice" name="flashPrice"  lay-verify="money" autocomplete="off" class="layui-input"></div>
                        </div>
                        <div class="layui-form-item" style="float: right">
                            <button type="button" class="layui-btn" lay-filter="edit" lay-submit="">确认新增</button>
                        </div>
                    </form>


                </div>
            </div>
        </div>
    </div>
</div>

<script>
    layui.use(['form', 'layer','jquery','laydate'], function() {
        var $ = layui.jquery;
        var form = layui.form;
        var  layer = layui.layer;
        var laydate = layui.laydate;
        var path =$("#path").val();


        laydate.render({
            elem: '#timeRange' //指定元素
            ,type: 'datetime'
            ,range: '到'
            ,format: 'yyyy-MM-dd HH:mm:ss'
            ,done: function(value, date, endDate){
                // debugger;
                // console.log(typeof value);
                var startTime = value.split(" 到 ")[0];
                // console.log(startTime);
                var endTime = value.split(" 到 ")[1];
                // console.log(endTime);

                var dateStr = startTime.split(" ")[0];
                var timeStr = startTime.split(" ")[1];
                var dateStrArr = dateStr.split("-");
                var timeStrArr = timeStr.split(":");
                var startTime1 =new Date(dateStrArr[0],dateStrArr[1]-1,dateStrArr[2],timeStrArr[0],timeStrArr[1],timeStrArr[2]);

                if(startTime1<new Date()){
                    // $("#timeRange").val("");
                    layer.msg("秒杀开始时间必须是一个将来的时间！");
                }else if(startTime==endTime){
                    // $("#timeRange").val("");
                    layer.msg("请选择一个有长度的时间范围！");
                }else{
                    $("#startTime").val(startTime);
                    $("#endTime").val(endTime);
                    console.log("时间范围的value"+$("#timeRange").val());
                }
                // console.log(value); //得到日期生成的值，如：2017-08-18
                // console.log(date); //得到日期时间对象：{year: 2017, month: 8, date: 18, hours: 0, minutes: 0, seconds: 0}
                // console.log(endDate); //得结束的日期时间对象，开启范围选择（range: true）才会返回。对象成员同上。
            }
        });

        form.verify({
            needTime:function(value){
                if(value==""){
                    return "请输入正确的时间范围";
                }
            }
            ,noPositive:function(value){
                if(!/^[1-9]\d*|0$/.test(value)){
                    return "请输入非负整数数量";
                }
                if(value>window.count){
                    return "本商品总数不足，请补货或减少秒杀数量"//20个余量？？
                }
            }
            ,money:function(value){
                if(!/(^[1-9]\d*(\.\d{1,2})?$)|(^0(\.\d{1,2})?$)/.test(value)){
                    return "请输入正确的价格，正整数或者保留两位小数";
                }
            }

        });


        //监听提交
        form.on('submit(edit)', function(data) {
            console.log("表单提交的数据"+JSON.stringify(data.field));
            $.ajax({
                url:path+"/flashSaleControl/insertFlashSale",
                async:false,
                type:"POST",
                data:data.field,
                dataType:"json",
                success:function(res){
                    console.log("插入秒杀记录的返回结果"+res);
                    if(res==1){
                        layer.alert("新增成功", {icon: 6}, function() {
                            //关闭当前frame
                            xadmin.close();
                            // 可以对父窗口进行刷新
                            xadmin.father_reload();
                        });
                    }else if(res==-1){
                        layer.msg("数量不足，请刷新",{time:1000});
                    }
                },
                error:function (xhr,textStatus) {
                    layer.alert("错误:"+textStatus, {icon: 2});
                },
            });
            return false;
        });

        $(function () {
            form.val("formTest", {
                "goodsId": parent.tempData.id//选中列id作为新增列的父级id
            });
            window.count = parent.tempData.totalCount;
        })

    });
</script>

</body>
<input id="path" value="${pageContext.request.contextPath}" type="hidden">
</html>
