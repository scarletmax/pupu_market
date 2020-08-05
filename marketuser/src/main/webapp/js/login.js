function changeImg() {
    var path= $("#path").val();
    $("#verifyCode").attr("src",path+"/verifyCodeControl/getVerify?time="+new Date().getTime());
}
$(function  () {
    layui.use('form', function(){
        var form = layui.form;
        form.on('submit(login)', function(data){
            var adminJson = JSON.stringify(data.field)
            var path =$ ("#path").val();

            $.ajax({
                url:path+"/loginControl/login",
                async:true,
                type:"post",
                data:"adminJson="+adminJson,
                dataType:"text",
                success:function (msg) {
                    if(msg == "success") {
                        layer.msg('登录成功')
                        location.href=path+"/menuControl/getMenu";
                    }else if(msg == "vCodeError"){
                        layer.msg("验证码错误")
                        changeImg();
                    }else if(msg == "error"){
                        layer.msg("账号或者密码错误")
                        changeImg();
                    }else if(msg == "null"){
                        layer.msg("账号不存在")
                        changeImg();
                    }

                },
                error:function (xhr,textStatus,errorThrown) {
                    alert("网络错误")
                }
            })
            return false;
        });
    });
})

