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

function verifyTel() {

    console.log($("#tel").val());
    var name = $("#tel").val();
    var path = $("#path").val();
    $.ajax({
        url: path + "/regisControl/verifyTel",
        async: true,
        type: "post",
        data: "tel=" + tel,
        dataType: "text",
        success: function (msg) {

            console.log(msg);
            if (msg === "success") {

                // alert("账号可以使用")
                $(".tel").text("手机号可以使用");

                return true;
            } else if (msg === "fail") {
                // alert("账号已被注册");
                $(".tel").text("手机号已被注册");
                return false;
            }
        }
    })
}

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