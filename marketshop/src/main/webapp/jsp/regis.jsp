<%--
  Created by IntelliJ IDEA.
  User: maaaax
  Date: 2020/7/5
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>后台登录-X-admin2.2</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/css/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/X-admin/css/xadmin.css">

    <%--    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>--%>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.js" charset="utf-8"></script>

    <script src="${pageContext.request.contextPath}/static/X-admin/lib/layui/layui.js" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/js/regis.js" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/js/moveMap.js" charset="utf-8"></script>
    <script type="text/javascript" src="//api.map.baidu.com/api?v=2.0&ak=UUftmgWr60AqpWKxtkXSMY9hFvSnzzUY"></script>

    <%--    <!--[if lt IE 9]>--%>
    <%--    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>--%>
    <%--    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>--%>
    <%--    <![endif]-->--%>
    <style>

        /* 元素 | http://localhost:8081/jsp/login.jsp */

        .login {
            max-width: 600px;
        }

        /* 元素 | http://localhost:8081/jsp/regis.jsp */

        div.layui-form-item:nth-child(1) {
            margin-top: 20px;
        }

        /* login.css | http://localhost:8081/static/X-admin/css/login.css */

        .login input[type="text"], .login input[type="file"], .login input[type="password"], .login input[type="email"], select {
            /* height: 50px; */
            height: 40px;
        }

        #l-map {
            width: 600px;
            height: 600px;
        }

        /* 内联 #3 | http://localhost:8081/jsp/regis.jsp */

        .map1 {
            /* top: 20px; */
            /*position: relative;*/
            /*float: right;*/
            /*top: -1000px;*/
            /*right: 50px;*/
            border: 1px solid #189F92;
        }

        .map-x {
            text-align: right;
            padding-right: 50px;
            background-color: #189F92;
        }

        #box {
            position: relative;
            float: right;
            top: -1000px;
            width: 600px;
            height: 650px;
            background: #fef4eb;
            padding: 5px;
            margin: 50px;
            border: 1px solid #f60;
        }

        #box .title {
            height: 25px;
            background: #f60;
        }


    </style>
</head>
<body class="login-bg">
<input hidden value="${pageContext.request.contextPath}" id="path">

<div class="login layui-anim layui-anim-up layui-anim-scaleSpring">
    <div class="message">掌上超市分店管理系统</div>
    <div class="body">
        <div class="center">
            <form class="layui-form form" action="">
                <div class="layui-form-item">
                    <label class="layui-form-label">店铺名称</label>
                    <div class="layui-input-inline">
                        <input id="name" type="text" name="name" required lay-verify="required" placeholder="请输入店铺名称"
                               autocomplete="off" class="layui-input" onblur="verifyName()">
                    </div>
                    <div class="layui-form-mid layui-word-aux name">请输入你的店铺名称</div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">输入店铺地址</label>
                    <div class="layui-input-inline">
                        <%--                        <input id="suggestId" type="text" name="suggestId" required lay-verify="required"--%>
                        <%--                               placeholder="请输入店铺地址" autocomplete="off" class="layui-input"  value="" onblur="openMap()">--%>
                        <button style="display: none" id="setTop" class="layui-btn" data-method="setTop">多窗口模式，层叠置顶
                        </button>
                        <div id="r-result"><input onblur="openMap()" type="text" id="suggestId" size="20" value="百度"/>
                        </div>

                    </div>
                    <%--                    <div class="layui-input-inline">--%>
                    <%--                        <input name="code" lay-verify="required" placeholder="短信验证码"  type="text" class="layui-input">--%>
                    <%--                    </div>--%>
                    <div class="layui-form-mid layui-word-aux address">请输入你的店铺地址</div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">经度</label>
                    <div class="layui-input-inline">
                        <input id="longitude" type="text" name="longitude" required lay-verify="required"
                               autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux ">点击地图选择店铺的确切位置</div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">纬度</label>
                    <div class="layui-input-inline">
                        <input id="latitude" type="text" name="latitude" required lay-verify="required"
                               autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux ">点击地图选择店铺的确切位置</div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">你的名字</label>
                    <div class="layui-input-inline">
                        <input id="bossName" type="text" name="bossName" required lay-verify="required"
                               placeholder="请输入你的名字号" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux bossName">请输入你的名字号</div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">你的身份证号</label>
                    <div class="layui-input-inline">
                        <input id="verifyID" type="text" name="verifyID" required lay-verify="identity"
                               placeholder="请输入你的身份证号" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux verifyID">请输入你的身份证号</div>
                </div>

                <%--上传文件--%>
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
                    <legend>选择商店照片上传</legend>
                </fieldset>

                <div class="layui-upload upload1">
                    <button class="layui-btn layui-btn-normal" id="test1" type="button">选择商店照片</button>
                    <button style="display: none" class="layui-btn  hide" id="test2" type="button">开始上传</button>
                </div>
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
                    <legend>选择身份证照片上传</legend>
                </fieldset>

                <div class="layui-upload upload2">
                    <button class="layui-btn layui-btn-normal" id="test3" type="button">选择身份证照片</button>
                    <button style="display: none" class="layui-btn  hide" id="test4" type="button">开始上传</button>
                </div>


                <div class="layui-form-item">
                    <label class="layui-form-label">密码框</label>
                    <div class="layui-input-inline">
                        <input id="pwd" type="password" name="pwd" required lay-verify="required" placeholder="请输入密码"
                               autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux pwd">请填写6到12位密码</div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">确认密码框</label>
                    <div class="layui-input-inline">
                        <input id="nPassword" type="password" name="nPassword" required lay-verify="required"
                               placeholder="请再次输入密码" autocomplete="off" class="layui-input" onblur="npassNull()">
                    </div>
                    <div class="layui-form-mid layui-word-aux nPassword">请填写6到12位密码</div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">手机号</label>
                    <div class="layui-input-inline">
                        <input id="tel" type="text" name="tel" required lay-verify="required|phone|number"
                               placeholder="请输入手机号" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-form-mid layui-word-aux tel">请输入你的电话号码</div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">短信验证码</label>
                    <div class="layui-input-inline">
                        <input id="code" type="text" name="code" required lay-verify="required|number"
                               placeholder="请输入短信验证码" autocomplete="off" class="layui-input" onblur="verifyTel()">
                    </div>
                    <div class="layui-form-mid layui-word-aux">请输入你的短信验证码</div>
                    <button id="msg" class="layui-btn" type="button">获取短信验证</button>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">商店介绍</label>
                    <div class="layui-input-block">
                        <textarea id="info" name="info" class="layui-textarea" placeholder="请输入内容"
                                  lay-verify="required"></textarea>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button id="regis" class="layui-btn" lay-submit lay-filter="regis">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>


            <div class="regisClass">
                <a href="<%=request.getContextPath()%>/jsp/login.jsp" class="r_a"> <span style="font-size: larger"> >>>登录</span></a>
            </div>
        </div>
    </div>

</div>

<%--<div id="box" class="map1" style="display: none" >--%>
<%--   <div class="map-x"><label onclick="mapHide()" style="font-size: 30px">x</label></div>--%>
<%--    <div id="l-map" ></div>--%>
<%--    <div id="searchResultPanel" style="border:1px solid #C0C0C0;width:500px;height:500px; display:none;"></div>--%>
<%--</div>--%>

<div id="box">
    <h2 class="title"><label id="boxhide" onclick="mapHide()" style="font-size: 30px">x</label></h2>
<%--    <div class="map-x"><label onclick="mapHide()" style="font-size: 30px">x</label></div>--%>
        <div id="l-map" ></div>
        <div id="searchResultPanel" style="border:1px solid #C0C0C0;width:500px;height:500px; display:none;"></div>
</div>

</body>

<script>
    //Demo
    layui.use(['form', 'upload', 'layer'], function () {
        var form = layui.form;
        var $ = layui.jquery
            , upload = layui.upload,
            layer = layui.layer;
        var path = $("#path").val();

        //监听提交表单信息
        form.on('submit(regis)', function (data) {
            // layer.msg(JSON.stringify(data.field));

            var uv = verifyName();
            var np = npassNull();
            console.log("uv=" + uv + "  np=" + np + " tel=" + $(".tel").text());

            if ($(".upload1:has(span)").length > 0) {
                if ($(".upload2:has(span)").length > 0) {

                    if ($(".name").text() === "店铺名可以使用" && np && $(".tel").text() === "手机号可以使用") {
                        $.ajax({
                            url: path + "/regisControl/insertShop",
                            async: true,
                            type: "post",
                            data: {
                                "name": $("#name").val(),
                                "address": $("#suggestId").val(),
                                "bossName": $("#bossName").val(),
                                "verifyID": $("#verifyID").val(),
                                "pwd": $("#pwd").val(),
                                "tel": $("#tel").val(),
                                "info": $("#info").val(),
                                "code": $("#code").val(),
                                "longitude": $("#longitude").val(),
                                "latitude": $("#latitude").val()
                            },
                            dataType: "text",
                            success: function (msg) {
                                if (msg === "success") {

                                    $("#test2").click();


                                } else if (msg === "vCodeError") {
                                    layer.msg("验证码错误");
                                    changeImg();
                                } else if (msg === "error") {
                                    layer.msg("账号或者密码错误");
                                    changeImg();
                                } else if (msg === "null") {
                                    layer.msg("账号不存在");
                                    changeImg();
                                }

                            },
                            error: function (xhr, textStatus, errorThrown) {
                                alert("网络错误")
                            }
                        });
                    } else {
                        layer.msg("手机号或商店名填写不准确")
                    }

                } else {
                    layer.msg("请上传身份证照片");
                }

            } else {
                layer.msg("请上传商店照片");
            }


            return false;
        });


        //上传店铺照片
        upload.render({
            elem: '#test1'
            , url: path + "/regisControl/uploadShopPic"//改成您自己的上传接口
            , auto: false
            //,multiple: true
            , bindAction: '#test2'
            , exts: 'jpg|png|gif|bmp|jpeg'
            , done: function (res) {
                // layer.msg('上传成功');
                console.log(res);
                $("#test4").click();

            }
            , error: function () {
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }
        });
        //上传身份证照片
        upload.render({
            elem: '#test3'
            , url: path + "/regisControl/uploadVerifyPic"//改成您自己的上传接口
            , auto: false
            //,multiple: true
            , bindAction: '#test4'
            , exts: 'jpg|png|gif|bmp|jpeg'
            , done: function (res) {
                // layer.msg('上传成功');
                console.log(res);
                $.ajax({
                    url: path + "/regisControl/insertInfo",
                    async: true,
                    type: "post",
                    dataType: "text",
                    before: function () {

                        $("#regis").attr("disabled", disabled);

                    }
                    , success: function (msg) {
                        if (msg === "success") {
                            layer.msg('注册成功，等待审核');

                            location.href = "../jsp/login.jsp"

                        } else if (msg === 'codeFail') {
                            layer.msg('短信验证失败');
                        } else {
                            layer.msg('注册失败');
                        }
                    }
                })
            }
            , error: function () {
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }

        });
        //短信验证
        $("#msg").click(function () {
            var tel = $("#tel").val();
            console.log("tel=" + tel);


            if (tel.length > 0) {
                $.ajax({
                    url: path + "/loginControl/telverify",
                    async: false,
                    type: "post",
                    data: "tel=" + tel,
                    dataType: "text",
                    beforeSend: function () {
                        console.log("beforesend=====")

                        $("#msg").attr("disabled", true);
                        // $("#msg").setAttribute("disabled", true);

                        settime();
                    }
                    , success: function (msg) {

                        if (msg === "success") {
                            layer.msg("已发送短信")

                        } else {
                            layer.msg("短信发送错误")
                        }
                    },
                    error: function () {

                        layer.msg("网络错误")

                    }

                })
            } else {
                layer.msg("请填写手机号")
            }

        })
        $("#setTop").click(function () {
            //多窗口模式，层叠置顶
            layer.open({
                type: 2 //此处以iframe举例
                , title: '当你选择该窗体时，即会在最顶端'
                , area: ['390px', '260px']
                , shade: 0
                , maxmin: true
                , content: "<div id=\"l-map\"></div>\n" +
                    "<div id=\"searchResultPanel\" style=\"border:1px solid #C0C0C0;width:500px;height:500px; display:none;\"></div>"
                , btn: ['确定位置', '关闭窗口'] //只是为了演示
                , yes: function () {
                    // $(that).click();
                }
                , btn2: function () {
                    layer.closeAll();
                }

                , zIndex: layer.zIndex //重点1
                , success: function (layero) {
                    layer.setTop(layero); //重点2
                }
            });
        })


    });
    var countdown = 60;

    function settime() {
        var m = $("#msg");

        if (countdown == 0) {
            m.attr("disabled", false);
            m.text("获取短信验证");
            countdown = 60;
            return;
        } else {
            m.attr("disabled", true);
            m.text("重新发送(" + countdown + ")");
            countdown--;
        }
        setTimeout(function () {
            settime()
        }, 1000)
    }

    function openMap() {
        // $("#setTop").click();
        $("#box").show()
    }

    function mapHide() {
        $("#box").hide()
    }

    $(function () {
        $("#boxhide").click();
    })
</script>

<script type="text/javascript">
    // 百度地图API功能
    function G(id) {
        return document.getElementById(id);
    }

    var map = new BMap.Map("l-map");
    map.centerAndZoom("北京", 12);                   // 初始化地图,设置城市和地图级别。

    var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
        {
            "input": "suggestId"
            , "location": map
        });

    ac.addEventListener("onhighlight", function (e) {  //鼠标放在下拉列表上的事件
        var str = "";
        var _value = e.fromitem.value;
        var value = "";
        if (e.fromitem.index > -1) {
            value = _value.province + _value.city + _value.district + _value.street + _value.business;
        }
        str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;

        value = "";
        if (e.toitem.index > -1) {
            _value = e.toitem.value;
            value = _value.province + _value.city + _value.district + _value.street + _value.business;
        }
        str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
        G("searchResultPanel").innerHTML = str;
    });

    var myValue;
    ac.addEventListener("onconfirm", function (e) {    //鼠标点击下拉列表后的事件
        var _value = e.item.value;
        myValue = _value.province + _value.city + _value.district + _value.street + _value.business;
        G("searchResultPanel").innerHTML = "onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;

        setPlace();
    });

    function setPlace() {
        map.clearOverlays();    //清除地图上所有覆盖物
        function myFun() {
            var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
            map.centerAndZoom(pp, 18);
            map.addOverlay(new BMap.Marker(pp));    //添加标注
        }

        var local = new BMap.LocalSearch(map, { //智能搜索
            onSearchComplete: myFun
        });
        local.search(myValue);
    }

    //地图点击事件
    function showInfo(e) {
        layer.msg(e.point.lng + ", " + e.point.lat);
        $("#longitude").val(e.point.lng)
        $("#latitude").val(e.point.lat)

    }

    map.addEventListener("click", showInfo);

    //自动定位
    // var geolocation = new BMap.Geolocation();
    // geolocation.getCurrentPosition(function(r){
    //     if(this.getStatus() == BMAP_STATUS_SUCCESS){
    //         var mk = new BMap.Marker(r.point);
    //         map.addOverlay(mk);
    //         map.panTo(r.point);
    //         alert('您的位置：'+r.point.lng+','+r.point.lat);
    //     }
    //     else {
    //         alert('failed'+this.getStatus());
    //     }
    // },{enableHighAccuracy: true})
    //关于状态码
    //BMAP_STATUS_SUCCESS	检索成功。对应数值“0”。
    //BMAP_STATUS_CITY_LIST	城市列表。对应数值“1”。
    //BMAP_STATUS_UNKNOWN_LOCATION	位置结果未知。对应数值“2”。
    //BMAP_STATUS_UNKNOWN_ROUTE	导航结果未知。对应数值“3”。
    //BMAP_STATUS_INVALID_KEY	非法密钥。对应数值“4”。
    //BMAP_STATUS_INVALID_REQUEST	非法请求。对应数值“5”。
    //BMAP_STATUS_PERMISSION_DENIED	没有权限。对应数值“6”。(自 1.1 新增)
    //BMAP_STATUS_SERVICE_UNAVAILABLE	服务不可用。对应数值“7”。(自 1.1 新增)
    //BMAP_STATUS_TIMEOUT	超时。对应数值“8”。(自 1.1 新增)
</script>


</html>
