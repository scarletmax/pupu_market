function verifyName() {

    console.log($("#name").val());
    var name = $("#name").val();
        var path = $("#path").val();
        $.ajax({
            url: path + "/regisControl/verifyName",
            async: true,
            type: "post",
            data: "name=" + name,
            dataType: "text",
            success: function (msg) {

                console.log(msg);
                if (msg === "success") {

                    // alert("账号可以使用")
                    $(".name").text("店铺名可以使用");

                    console.log($(".name").text());
                    return true;
                } else if (msg === "fail") {
                    // alert("账号已被注册");
                    $(".name").text("店铺名已被注册");
                    return false;
                }
            }
        })
}

// $(function () {
//
//
//     layui.use('layer', function () {
//         var layer = layui.layer;
//
//
//         var uv = verifyName();
//         var np = npassNull();
//
//
//         console.log("uv=" + uv + "  np=" + np);
//         var path = $("#path").val();
//
//         $("#regis").click(function () {
//             if (uv && np) {
//                 $.ajax({
//                     url: path + "/regisControl/insertShop",
//                     async: true,
//                     type: "post",
//                     data: {
//                         "name": $("#name").val(),
//                         "address": $("#address").val(),
//                         "bossName": $("#bossName").val(),
//                         "verifyID": $("#verifyID").val(),
//                         "pwd": $("#pwd").val(),
//                         "tel": $("#tel").val(),
//                         "info": $("#info").val()
//                     },
//                     dataType: "text",
//                     success: function (msg) {
//                         if (msg == "success") {
//                             layer.msg('注册成功，等待审核');
//                             location.href = path + "/jsp/main.jsp";
//
//                         } else if (msg == "vCodeError") {
//                             layer.msg("验证码错误")
//                             changeImg();
//                         } else if (msg == "error") {
//                             layer.msg("账号或者密码错误")
//                             changeImg();
//                         } else if (msg == "null") {
//                             layer.msg("账号不存在")
//                             changeImg();
//                         }
//
//                     },
//                     error: function (xhr, textStatus, errorThrown) {
//                         alert("网络错误")
//                     }
//                 });
//             }else {
//                 layer.msg("填写不准确")
//             }
//             return false;
//         });
//
//
//     });
// });







function npassNull() {

    var pwd = $("#pwd").val();
    var uPassword2 = $("#nPassword").val();
    console.log("pwd=" + pwd);
    console.log("uPassword2=" + uPassword2);
    var reg = /^([a-zA-Z0-9]){6,12}$/i;
    if (reg.test(uPassword2)) {
        if (pwd === uPassword2) {
            $(".nPassword").text("符合要求");
            console.log("符合要求")
            return true;
        } else {
            $(".nPassword").text("密码输入不一样");
            console.log("密码输入不一样")
            return false;
        }

    } else {
        $(".nPassword").text("请填写6到12位密码");
        console.log("请填写6到12位密码")
        return false;
    }
}