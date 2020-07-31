$(function () {
    var path = $("#path").val();
    $.ajax({
        url: path + "/pointControl/findPointState",
        async: false,
        type: "post",
        dataType: "json",
        success: function (list) {
            if (list != null) {
                var str = "<option value=''>积分类型</option>"
                for (var i = 0; i < list.length; i++) {
                    str += "<option value='" + list[i] + "'>" + list[i] + "</option>"
                }

                $('select').append(str);
                // layui.form.render('select','mySelectDiv');
            }
        },
        error: function () {
            alert("网络错误")
        }
    })

})
$(function () {

    layui.use('table', function () {
        var table = layui.table;
        var path = $("#path").val()
        //第一个实例
        tabResult = table.render({
            elem: '#demo'
            , height: 312
            , url: path + "/pointControl/findPointList" //数据接口
            , page: true //开启分页
            , limit: 10
            , id: 'id'
            , cols: [[
                {field: 'userId', title: '用户ID', sort: true}
                , {field: 'userName', title: '用户姓名', sort: true}
                , {field: 'pointNum', title: '积分数量', sort: true,}
                , {field: 'stateStr', title: '积分类型', sort: true,}
                , {field: 'id', title: '积分id', hide: true}

            ]]
        });
    });
    $("#search").click(function () {
        var userId = $("#account").val();
        var userName = $("#name").val();
        var path = $("#path").val()
        var stateStr = $("#mySelect").val()

        tabResult.reload({
            url: path + "/pointControl/findPointList" //数据接口
            , page: true
            , where: {
                userId: userId,
                userName: userName,
                stateStr: stateStr
            }

        })

    })

})

