<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/13
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/layui/css/layui.css">
<script src="<%=request.getContextPath()%>/static/js/jquery-3.5.1.js" charset="utf-8"></script>
<script src="<%=request.getContextPath()%>/static/layui/layui.js" charset="utf-8"></script>

<style>

    .row-main {
        width: 100%;
        height: 100%;
        background: url(../dist/images/bg.jpg)
    }

    .row {

        width: 1000px;
        height: 600px;

        /*-moz-box-shadow: 2px 2px 10px #909090;!*firefox*!*/
        /*-webkit-box-shadow: 2px 2px 10px #909090;!*safari或chrome*!*/
        /*box-shadow:2px 2px 10px #909090;!*opera或ie9*!*/

    }

    .row-1 {

        height: 50px;
        background-color: #262626;
        -moz-box-shadow: 2px 2px 10px #909090; /*firefox*/
        -webkit-box-shadow: 2px 2px 10px #909090; /*safari或chrome*/
        box-shadow: 2px 2px 10px #909090; /*opera或ie9*/
    }

    .row-2 {
        height: 100%;
        -moz-box-shadow: 2px 2px 10px #909090; /*firefox*/
        -webkit-box-shadow: 2px 2px 10px #909090; /*safari或chrome*/
        box-shadow: 2px 2px 10px #909090; /*opera或ie9*/
    }

    .row-2-1 {
        background-color: #383838;
        height: 100%;
        -moz-box-shadow: 2px 2px 10px #909090; /*firefox*/
        -webkit-box-shadow: 2px 2px 10px #909090; /*safari或chrome*/
        box-shadow: 2px 2px 10px #909090; /*opera或ie9*/
    }

    .row-2-2 {
        background-color: #F7F7F7;
        height: 70%;
        -moz-box-shadow: 2px 2px 10px #909090; /*firefox*/
        -webkit-box-shadow: 2px 2px 10px #909090; /*safari或chrome*/
        box-shadow: 2px 2px 10px #909090; /*opera或ie9*/

    }

    .row-2-3 {
        background-color: #E0E0E0;
        height: 30%;
        -moz-box-shadow: 2px 2px 10px #909090; /*firefox*/
        -webkit-box-shadow: 2px 2px 10px #909090; /*safari或chrome*/
        box-shadow: 2px 2px 10px #909090; /*opera或ie9*/

    }

    .row-2-1 li {
        background-color: #383838;
    }

    .bt {
        margin-left: 350px;
    }

    .row-2-2 .time {
        text-align: center;
    }

    .row-2-2 .main {
        width: 90%;
        margin-left: 5%;
        /*background-color: white;*/

    }

    .row-2-2 .text {
        /*max-width: 80%;*/
        /*!*position: fixed;*!*/
        /*margin-left: 10%;*/
        /*background-color: whitesmoke;*/

        display: inline-block;
        position: relative;
        padding: 0 10px;
        max-width: calc(90% - 40px);
        min-height: 30px;
        line-height: 2.5;
        font-size: 9pt;
        text-align: left;
        word-break: break-all;
        background-color: #fafafa;
        border-radius: 4px;
        margin-left: 20px;
    }

    .row-2-2 .text2 {
        /*max-width: 80%;*/
        /*!*position: fixed;*!*/
        /*margin-right: 10%;*/
        /*background-color: #b2e281;*/
        /*padding-top: 8px;*/
        /*padding-bottom: 8px;*/
        /*border-radius: 5px;*/
        display: inline-block;
        position: relative;
        padding: 0 10px;
        max-width: calc(90% - 40px);
        min-height: 30px;
        line-height: 2.5;
        font-size: 9pt;
        text-align: left;
        word-break: break-all;
        background-color: #b2e281;
        border-radius: 4px;
        margin-right: 20px;
    }

    .row-2-2 .self {
        width: 90%;
        margin-right: 5%;
        float: right;
        text-align: right;
    }

    .row-2-2 .avatar {

        /*position: fixed;*/
        float: left;
        width: 30px;
        height: 30px;
    }

    .row-2-2 .avatar2 {

        /*position: fixed;*/
        float: right;
        width: 30px;
        height: 30px;
    }

    .row-label {
        text-align: center;
        font-size: 20px;
        color: rgba(154, 154, 154, 0.82);
    }

</style>
<body>
<input type="hidden" value="<%=request.getContextPath()%>" id="path">
<div class="row-main">
    <div class="layui-container row">

        <div class="layui-row row-1">
            <div class="layui-col-xs3 ">

            </div>
            <div class="layui-col-xs6 ">
                <label class="row-label">掌上超市客服聊天界面</label>
            </div>
            <div class="layui-col-xs3 ">

            </div>
        </div>

        <div class="layui-row row-2">
            <div class="layui-col-xs3 row-2-1">
                <div class="grid-demo grid-demo-bg1">


                    <ul class="layui-nav layui-nav-tree layui-inline" style="margin-right: 10px;" lay-filter="demo">
                        <li class="layui-nav-item" id="num">在线人数：0</li>
                        <li class="layui-nav-item layui-nav-itemed">
                            <a href="javascript:;">聊天对象</a>
                            <dl class="layui-nav-child" id="row-li">

                                <%--                            <dd><a href="javascript:;" >选项一</a></dd>--%>
                                <%--                            <dd><a href="javascript:;">选项二</a></dd>--%>
                                <%--                            <dd><a href="javascript:;">选项三</a></dd>--%>
                                <%--                            <dd><a href="">跳转项</a></dd>--%>
                            </dl>
                        </li>


                    </ul>
                </div>


            </div>

            <div class="layui-col-xs9 row-2-2">
                <div id="info1" class="grid-demo" style="height:300px;overflow-y:auto">
                    6/12
                    <ul id="info"><!--v-for-start-->
                        <li><p class="time"><span>11:26</span></p>
                            <div class="main">
                                <img class="avatar" width="30" height="30" src="../dist/images/2.png">
                                <div class="text">Hello，这是一个聊天面板。
                                </div>
                            </div>
                        </li>
                        <li><p class="time"><span>11:26</span></p>
                            <div class="main">
                                <img class="avatar" width="30" height="30" src="../dist/images/2.png">
                                <div class="text">现在可以进行客服聊天了</div>
                            </div>
                        </li>
                        <li><p class="time"><span>11:26</span></p>
                            <div class="main self">
                                <img class="avatar2" width="30" height="30" src="../dist/images/1.jpg">
                                <div class="text2">聊天说明</div>
                            </div>
                        </li>
                        <li><p class="time"><span>11:26</span></p>
                            <div class="main self">
                                <img class="avatar2" width="30" height="30" src="../dist/images/1.jpg">
                                <div class="text2">客服可以接收用户发来的消息，并进行回复</div>
                            </div>
                        </li>
                        <li><p class="time"><span>11:34</span></p>
                            <div class="main self"><img class="avatar2" width="30" height="30"
                                                        src="../dist/images/1.jpg">
                                <div class="text2">好了，看看都有谁反馈问题了。。。</div>
                            </div>
                        </li><!--v-for-end--></ul>


                </div>
            </div>
            <div class="layui-col-xs9 row-2-3">
                <div class="grid-demo">
                    <%--                    <div class="layui-form-item layui-form-text">--%>
                    <%--                       --%>
                    <%--                    </div>--%>
                    <%--                    <div class="layui-input-block">--%>
                    <textarea class="layui-textarea" placeholder="请输入内容" id="data"></textarea>
                    <%--                    </div>--%>
                    <div class="layui-form-item bt">
                        <div class="layui-input-block">
                            <%--                      <input type="text" value="小张" id="name">name</input>--%>
                            <%--                        <input type="text" value="1" id="userId">userId</input>--%>
                            <button style="display: none" class="layui-btn layui-btn-sm" id="login" onclick="login()">登录
                            </button>
                            <button class="layui-btn layui-btn-sm" onclick='SendData()'>立即提交
                            </button>
                            <button onclick="resetM()" id="resetMsg" class="layui-btn layui-btn-primary layui-btn-sm"
                                    type="reset">重置
                            </button>
                        </div>
                    </div>

                </div>
            </div>
        </div>

    </div>
</div>


<script>
    layui.use(['element', 'layer'], function () {
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
        var layer = layui.layer;

        //监听导航点击
        element.on('nav(demo)', function (elem) {
            //console.log(elem)
            layer.msg(elem.text());
        });
    });
</script>
<script type="text/javascript">


    $(function () {
        var path = $("#path").val();

        //下载用户并保存数组
        $("#login").click();

        $.ajax({
            url: path + "/chatControl/findSaveAcc",
            type: 'post',
            // data: {"acc": "admin125g"},
            async: true,
            dataType: 'json',
            success: function (msg) {

          console.log("聊天用户="+msg);

          if(msg.length>0){
              console.log("聊天=="+msg[0].chatAcc);
              console.log("聊天长度=="+msg.length);
              for (var i = 0; msg.length >i; i++) {
                  chatUserId.push(msg[i].chatAcc);
                  chatUser.push(msg[i].chatUser);
                  /*添加到用户栏*/
                  $("#row-li").append(" <dd><a onclick='changeInfo(this)' href=\"javascript:;\" id=" + "id" + msg[i].chatAcc + " value=" + msg[i].chatAcc + ">" + msg[i].chatUser + "</a></dd>");
                  /*创建聊天面板*/
                  document.getElementById("info1").innerHTML += " <ul id= " + msg[i].chatAcc + "></ul>";
                  $("#" + msg[i].chatAcc).hide();
                  /*下载聊天记录*/
                  $.ajax({
                      url: path + "/chatControl/findChatMsg",
                      type: 'post',
                      data: {"acc":msg[i].chatAcc},
                      async: false,
                      dataType: 'json',
                      success: function (msg) {
                          console.log("聊天记录"+msg);
                          if(msg.length>0){
                              console.log("聊天内容"+msg[0].msg);

                              for (var i = 0; msg.length > i; i++) {
                                  console.log(msg[i].chatAcc);


                                  //添加聊天记录
                                  if (msg[i].chatAcc == 'admin125g') {
                                      /*发送聊天*/
                                      console.log("msg[i].chatAcc="+msg[i].chatOtherAcc)
                                      document.getElementById(msg[i].chatOtherAcc).innerHTML += " <li><p class=\"time\"><span>" + msg[i].chatTime + "</span></p>\n" +
                                          "                        <div class=\"main self\">\n" +
                                          "                            <img class=\"avatar2\" width=\"30\" height=\"30\" src=\"../dist/images/1.jpg\">\n" +
                                          "                            <div class=\"text2\"> " + msg[i].msg + "</div>\n" +
                                          "                        </div>\n" +
                                          "                    </li>";

                                  } else {
                                      document.getElementById(msg[i].chatAcc).innerHTML += " <li><p class=\"time\"><span>" + msg[i].chatTime + "</span></p>\n" +
                                          "                        <div class=\"main\">\n" +
                                          "                            <img class=\"avatar\" width=\"30\" height=\"30\" src=\"../dist/images/2.png\">\n" +
                                          "                            <div class=\"text\">" + msg[i].msg + "</div>\n" +
                                          "                        </div>\n" +
                                          "                    </li>";
                                  }
                              }
                          }

                      },
                      error: function () {
                          alert("网络错误")
                      }
                  });
              }
          }



            }
        });



    });
    var ws;
    var chatUser = [];
    var chatUserId = [];

    function login() {
        if (!ws) {
            // var user = document.getElementById("name").value;
            // var userId = document.getElementById("userId").value;
            // var otherId = document.getElementById("otherId").value;
            // var other = document.getElementById("other").value;
            // var user = "B";
            // var other ="A";
            try {
                // ws = new WebSocket("ws://127.0.0.1:8010/websocket/" + user+"/"+otherId+"/"+userId+"/"+other);//连接服务器
                // ws = new WebSocket("ws://127.0.0.1:8010/websocket/" + "admin125g"+"/"+user+"/"+"admin125g"+"/"+userId);//连接服务器
                ws = new WebSocket("ws://127.0.0.1:8080/websocket/" + "admin125g" + "/" + "admin125g");
                ws.onopen = function (event) {
                    console.log("已经与服务器建立了连接...");
                    // alert("登陆成功，可以开始聊天了")

                };
                ws.onmessage = function (event) {
                    var d = JSON.stringify(event.data);
                    var v = eval("(" + event.data + ")");

                    console.log("接收到服务器发送的数据..." + event.data);

                    console.log("消息..." + v.msg);
                    console.log("对方账号..." + v.chatAcc);
                    console.log("对方名称..." + v.charUser);
                    var myDate = new Date();

                    if (chatUserId.length > 0) {  /*保存上线的用户到数组*/
                        var a = 0;
                        for (var i = 0; chatUserId.length > i; i++) {
                            a++
                            console.log("chatUserId=" + chatUserId[i]);
                            if (chatUserId[i] == v.chatAcc) {
                                break;
                            }
                        }
                        if (a == chatUserId.length) {
                            chatUserId.push(v.chatAcc);
                            chatUser.push(v.charUser);
                        }

                    } else {
                        chatUserId.push(v.chatAcc);
                        chatUser.push(v.charUser);
                    }
                    /* $("#"+v.userId).length>0*//*判断id是否存在*/
                    if (!$("#" + v.chatAcc).length > 0) { /*判断是否存在改用户聊天面板*/
                        /*添加到用户栏*/
                        $("#row-li").append(" <dd><a onclick='changeInfo(this)' href=\"javascript:;\" id=" + "id" + v.chatAcc + " value=" + v.chatAcc + ">" + v.charUser + "</a></dd>");
                        /*创建聊天面板*/
                        document.getElementById("info1").innerHTML += " <ul id= " + v.chatAcc + "></ul>";

                        /*判断面板是否显示*/
                        // if($(v.userId).css('display')=='none'){
                        //
                        //     $(v.userId).show();
                        //     $("#info").hide();
                        // }
                        // $(v.userId).hide();
                        //保存用户到数据库
                        saveAcc(v.chatAcc,v.charUser);
                    }
                    document.getElementById("num").innerHTML = "聊天人数:" + chatUserId.length;
                    //  /*设置消息颜色红色,并隐藏面板*/
                    // if($("#"+"id"+v.userId).css("background-color") != "rgb(0, 150, 136)"){
                    //     $("#"+"id"+v.userId).css("background-color","#cc5229");
                    //     $(v.userId).hide();
                    // }
                    for (var i = 0; chatUserId.length > i; i++) {
                        /*判断是否为选中*/
                        if ($("#" + "id" + chatUserId[i]).css("background-color") == "rgb(0, 150, 136)") {

                            $(v.chatAcc).show();
                            break;
                        }
                    }
                    $("#info").hide();

                    document.getElementById(v.chatAcc).innerHTML += " <li><p class=\"time\"><span>" + myDate.toLocaleString() + "</span></p>\n" +
                        "                        <div class=\"main\">\n" +
                        "                            <img class=\"avatar\" width=\"30\" height=\"30\" src=\"../dist/images/2.png\">\n" +
                        "                            <div class=\"text\">" + v.msg + "</div>\n" +
                        "                        </div>\n" +
                        "                    </li>";
                    var div = document.getElementById("info1");
                    div.scrollTop = div.scrollHeight;
                    /*设置消息颜色红色,并隐藏面板*/
                    if ($("#" + "id" + v.chatAcc).css("background-color") != "rgb(0, 150, 136)") {
                        $("#" + "id" + v.chatAcc).css("background-color", "#cc5229");
                        $("#" + v.chatAcc).hide();
                    }

                };
                ws.onclose = function (event) {
                    console.log("已经与服务器断开连接...");
                };
                ws.onerror = function (event) {
                    console.log("WebSocket异常！");
                };
            } catch (ex) {
                alert(ex.message);
            }
            document.getElementById("login").innerHTML = "退出";
        } else {
            ws.close();
            ws = null;
        }
    }

    function SendData() {
        var data = document.getElementById("data").value;
        var myDate = new Date();

        if (chatUserId.length > 0) {
            var a = 0;
            for (var i = 0; chatUserId.length > i; i++) {

                console.log($("#" + "id" + chatUserId[i]).css("background-color"))
                if ($("#" + "id" + chatUserId[i]).css("background-color") == "rgb(0, 150, 136)") {
                    /*发送聊天*/
                    document.getElementById(chatUserId[i]).innerHTML += " <li><p class=\"time\"><span>" + myDate.toLocaleString() + "</span></p>\n" +
                        "                        <div class=\"main self\">\n" +
                        "                            <img class=\"avatar2\" width=\"30\" height=\"30\" src=\"../dist/images/1.jpg\">\n" +
                        "                            <div class=\"text2\"> " + $("#data").val() + "</div>\n" +
                        "                        </div>\n" +
                        "                    </li>";

                    $("#data").val("");
                    try {
                        ws.send(chatUser[i] + "=:" + chatUserId[i] + "=:" + data);

                    } catch (ex) {
                        alert(ex.message);
                    }
                    break;
                }
                a++;
            }
            if (a == chatUserId.length) {
                alert("请选择聊天对象")
            }

        } else {
            /*发送聊天*/
            document.getElementById("info").innerHTML += " <li><p class=\"time\"><span>" + myDate.toLocaleString() + "</span></p>\n" +
                "                        <div class=\"main self\">\n" +
                "                            <img class=\"avatar2\" width=\"30\" height=\"30\" src=\"../dist/images/1.jpg\">\n" +
                "                            <div class=\"text2\"> 当前没有选择聊天对象------" + $("#data").val() + "----</div>\n" +
                "                        </div>\n" +
                "                    </li>";

        }

        /*滚动条自动下滑*/
        var div = document.getElementById("info1");
        div.scrollTop = div.scrollHeight;

    };

    function changeInfo(node) {
        console.log("node=" + this);
        // console.log("id="+node.id);
        console.log("value=" + $(node).attr('value'));
        console.log("text=" + $(node).text());
        var UserId = $(node).attr('value');
        for (var i = 0; chatUserId.length > i; i++) {
            $("#" + "id" + chatUserId[i]).removeAttr("style");
            $("#" + chatUserId[i]).hide();
        }
        $(node).css("background-color", "#009688");
        $("#info").hide();
        $("#" + UserId).show();
    }

    function resetM() {

        $("#data").val("");
    }

    function saveAcc(acc,charUser) {
        /*保存上线的用户到数据库*/
        var path = $("#path").val();
        $.ajax({
            url: path + "/chatControl/insertSaveAcc",
            type: 'post',
            data: {"chatAcc": acc,"charUser":charUser},
            async: true,
            dataType: 'text',
            success: function (msg) {
                console.log(msg)
                if (msg === 'success') {
                    console.log("保存成功")
                }

            }
        })
    }

</script>

</body>


</html>
