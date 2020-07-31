$(function () {
    var path = $("#path").val();
    $.ajax({
        url: path + "/adminControl/findAdminRole",
        async: false,
        type: "post",
        dataType: "json",
        success: function (list) {
            if (list != null) {
                var str = "<option value=''>管理员角色</option>"
                for (var i = 0; i < list.length; i++) {
                    str += "<option value='" + list[i] + "'>" + list[i] + "</option>"
                }

                $('select').append(str);
                layui.form.render('select','mySelectDiv');
            }
        },
        error: function () {
            alert("网络错误")
        }
    })

})



$(document).ready(function(){
    $("#account").blur(function(){
        var account=$("#account").val();
        var path = $("#path").val();
        if (account!=""&&account.trim()!="") {
            $.ajax({
                    url: path + "/adminControl/findAccount",
                    async: true,
                    type: "POST",
                    data: "account=" + account ,
                    datatype: "text",
                    success: function (msg) {
                        $("#regNode").empty();
                        if (msg=="success") {
                            $("#regNode").text("该账号可以使用");
                        } else {
                            $("#regNode").text("该账号已存在");
                        }
                    },
                    error: function () {
                        alert("网络繁忙！");
                    }

                }
            );
        }



    });
});