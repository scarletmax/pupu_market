<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/30
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单详情</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/X-admin/css/font.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/X-admin/css/xadmin.css">
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/static/X-admin/lib/layui/css/modules/laydate/default/laydate.css">
    <%--    <script src="<%=request.getContextPath()%>/web/X-admin/lib/layui/lay/modules/jquery.js" charset="utf-8"></script>--%>
    <script src="<%=request.getContextPath()%>/static/js/jquery-3.5.1.js" charset="utf-8"></script>
    <script src="<%=request.getContextPath()%>/static/X-admin/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/X-admin/js/xadmin.js"></script>
    <script src="<%=request.getContextPath()%>/static/layui/lay/modules/form.js" charset="utf-8"></script>

</head>
<body>
<input type="hidden" value="<%=request.getContextPath()%>" id="path">
<form class="layui-form" action="">
    <div class="layui-form-item">
        <label class="layui-form-label">单行输入框</label>
        <div class="layui-input-block">
            <input name="title" class="layui-input" type="text" placeholder="请输入标题" autocomplete="off" lay-verify="title">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">验证必填项</label>
        <div class="layui-input-block">
            <input name="username" class="layui-input" type="text" placeholder="请输入" autocomplete="off" lay-verify="required" lay-reqtext="用户名是必填项，岂能为空？">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">验证手机</label>
            <div class="layui-input-inline">
                <input name="phone" class="layui-input" type="tel" autocomplete="off" lay-verify="required|phone">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">验证邮箱</label>
            <div class="layui-input-inline">
                <input name="email" class="layui-input" type="text" autocomplete="off" lay-verify="email">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">多规则验证</label>
            <div class="layui-input-inline">
                <input name="number" class="layui-input" type="text" autocomplete="off" lay-verify="required|number">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">验证日期</label>
            <div class="layui-input-inline">
                <input name="date" class="layui-input" id="date" type="text" placeholder="yyyy-MM-dd" autocomplete="off" lay-verify="date">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">验证链接</label>
            <div class="layui-input-inline">
                <input name="url" class="layui-input" type="tel" autocomplete="off" lay-verify="url">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">验证身份证</label>
        <div class="layui-input-block">
            <input name="identity" class="layui-input" type="text" placeholder="" autocomplete="off" lay-verify="identity">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">自定义验证</label>
        <div class="layui-input-inline">
            <input name="password" class="layui-input" type="password" placeholder="请输入密码" autocomplete="off" lay-verify="pass">
        </div>
        <div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">范围</label>
            <div class="layui-input-inline" style="width: 100px;">
                <input name="price_min" class="layui-input" type="text" placeholder="￥" autocomplete="off">
            </div>
            <div class="layui-form-mid">-</div>
            <div class="layui-input-inline" style="width: 100px;">
                <input name="price_max" class="layui-input" type="text" placeholder="￥" autocomplete="off">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">单行选择框</label>
        <div class="layui-input-block">
            <select name="interest" lay-filter="aihao">
                <option value=""></option>
                <option value="0">写作</option>
                <option value="1" selected="">阅读</option>
                <option value="2">游戏</option>
                <option value="3">音乐</option>
                <option value="4">旅行</option>
            </select>
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">分组选择框</label>
            <div class="layui-input-inline">
                <select name="quiz">
                    <option value="">请选择问题</option>
                    <optgroup label="城市记忆">
                        <option value="你工作的第一个城市">你工作的第一个城市</option>
                    </optgroup>
                    <optgroup label="学生时代">
                        <option value="你的工号">你的工号</option>
                        <option value="你最喜欢的老师">你最喜欢的老师</option>
                    </optgroup>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">搜索选择框</label>
            <div class="layui-input-inline">
                <select name="modules" lay-search="" lay-verify="required">
                    <option value="">直接选择或搜索选择</option>
                    <option value="1">layer</option>
                    <option value="2">form</option>
                    <option value="3">layim</option>
                    <option value="4">element</option>
                    <option value="5">laytpl</option>
                    <option value="6">upload</option>
                    <option value="7">laydate</option>
                    <option value="8">laypage</option>
                    <option value="9">flow</option>
                    <option value="10">util</option>
                    <option value="11">code</option>
                    <option value="12">tree</option>
                    <option value="13">layedit</option>
                    <option value="14">nav</option>
                    <option value="15">tab</option>
                    <option value="16">table</option>
                    <option value="17">select</option>
                    <option value="18">checkbox</option>
                    <option value="19">switch</option>
                    <option value="20">radio</option>
                </select>
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">联动选择框</label>
        <div class="layui-input-inline">
            <select name="quiz1">
                <option value="">请选择省</option>
                <option value="浙江" selected="">浙江省</option>
                <option value="你的工号">江西省</option>
                <option value="你最喜欢的老师">福建省</option>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="quiz2">
                <option value="">请选择市</option>
                <option value="杭州">杭州</option>
                <option disabled="" value="宁波">宁波</option>
                <option value="温州">温州</option>
                <option value="温州">台州</option>
                <option value="温州">绍兴</option>
            </select>
        </div>
        <div class="layui-input-inline">
            <select name="quiz3">
                <option value="">请选择县/区</option>
                <option value="西湖区">西湖区</option>
                <option value="余杭区">余杭区</option>
                <option value="拱墅区">临安市</option>
            </select>
        </div>
        <div class="layui-form-mid layui-word-aux">此处只是演示联动排版，并未做联动交互</div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">复选框</label>
        <div class="layui-input-block">
            <input name="like[write]" title="写作" type="checkbox">
            <input name="like[read]" title="阅读" type="checkbox" checked="">
            <input name="like[game]" title="游戏" type="checkbox">
        </div>
    </div>

    <div class="layui-form-item" pane="">
        <label class="layui-form-label">原始复选框</label>
        <div class="layui-input-block">
            <input name="like1[write]" title="写作" type="checkbox" checked="" lay-skin="primary">
            <input name="like1[read]" title="阅读" type="checkbox" lay-skin="primary">
            <input name="like1[game]" title="游戏" disabled="" type="checkbox" lay-skin="primary">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">开关-默认关</label>
        <div class="layui-input-block">
            <input name="close" type="checkbox" lay-skin="switch" lay-text="ON|OFF">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">开关-默认开</label>
        <div class="layui-input-block">
            <input name="open" type="checkbox" checked="" lay-filter="switchTest" lay-skin="switch" lay-text="ON|OFF">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">单选框</label>
        <div class="layui-input-block">
            <input name="sex" title="男" type="radio" checked="" value="男">
            <input name="sex" title="女" type="radio" value="女">
            <input name="sex" title="禁用" disabled="" type="radio" value="禁">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">普通文本域</label>
        <div class="layui-input-block">
            <textarea class="layui-textarea" placeholder="请输入内容"></textarea>
        </div>
    </div>
    <!--<div class="layui-form-item layui-form-text">
      <label class="layui-form-label">编辑器</label>
      <div class="layui-input-block">
        <textarea class="layui-textarea layui-hide" name="content" lay-verify="content" id="LAY_demo_editor"></textarea>
      </div>
    </div>-->
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" type="submit" lay-filter="demo1" lay-submit="">立即提交</button>
            <button class="layui-btn layui-btn-primary" type="reset">重置</button>
        </div>
    </div>
</form>


</body>

<script>
    ;layui.use('table', function () {

        var orderInf = parent.orderInf;

        var path = $("#path").val();

        $("#orderNum").text(orderInf.orderNum);
        $("#name").text(orderInf.name);
        $("#address").text(orderInf.address);
        $("#roomNum").text(orderInf.roomNum);
        $("#tel").text(orderInf.tel);
        // {{#if(d.createTime!=null){}}{{layui.util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')}}{{#} }}
        $("#createTime").text(orderInf.createTime);
        $("#receiveTime").text(orderInf.receiveTime);
        $("#finishTime").text(orderInf.finishTime);
        $("#userName").text(orderInf.userName);
        $("#shopName").text(orderInf.shopName);
        $("#goodsName").text(orderInf.goodsName);
        $("#goodsComment").text(orderInf.goodsComment);
        $("#deliverymanName").text(orderInf.deliverymanName);
        $("#deliveryComment").text(orderInf.deliveryComment);
        $("#deliverytime").text(orderInf.deliverytime);
        $("#dcouponName").text(orderInf.couponName)

        var id = orderInf.id;
        var couponId=orderInf.couponId;
        console.log("couponId="+couponId);

        $(function () {
            $.ajax({
                url: path + "/CommentControl/findDeliverymanComment",
                async: true,
                type: "post",
                data: "id=" + id,
                dataType: "json",
                success: function (msg) {

                    console.log(msg);
                    if (msg.length > 0) {
                        $("#deliveryComment").text(" " + msg[0].comment);
                        $("#deliverymanScore").text(" " + msg[0].point + "分");
                        $("#deliverytime").text(" " + msg[0].createTime);
                    }


                }

            })

        });
        $.ajax({
            url: path + "/CommentControl/findGoodsComment",
            async: true,
            type: "post",
            data: "id=" + id,
            dataType: "json",
            success: function (msg) {

                console.log(msg);

                $(msg).each(function (i) {

                    $("#goodsInf").append(

                        " <div class=\"layui-card-body\"><div >商品名：<label id=\"goodsName\">" + msg[i].goodsName + "</label></div>\n" +
                        "<div>评价：<label id=\"goodsComment\">" + msg[i].comment + "</label></div>" +
                        "                    <div>评价时间：<label id=\"goodsComment\">" + msg[i].createTime + "</label></div></div>" +

                        "  </div>")

                });
                // $("#deliveryComment").text(" "+msg[0].comment);
                // $("#deliverymanScore").text(" "+msg[0].point+"分");
                // $("#deliverytime").text(" "+msg[0].createTime);
            }
        });
        $.ajax({
            url: path + "/couponControl/findCouponUser",
            async: true,
            type: "post",
            data: "id=" + couponId,
            dataType: "json",
            success: function (msg) {

                console.log(msg);

                $(msg).each(function (i) {

                    $("#dcouponInf").append(

                        " <div class=\"layui-card-body\">" +
                        " <div>使用时间:<label id=\"dcouponTime\">"+msg[i].createTime+"</label></div>\n" +
                        " <div>状态:<label id=\"dcouponRule\">" + msg[i].stateStr + "</label></div>"+
                        // " <div>规则:<label id=\"dcouponRule\">" + msg[i].rule + "</label></div>"+

                        "</div>" +

                        "  </div>")

                });
            }
        })



    });


</script>

</html>
