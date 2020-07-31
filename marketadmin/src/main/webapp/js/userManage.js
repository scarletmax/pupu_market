$(function () {
    var path = $("#path").val();
    $.ajax({
        url: path + "/adminControl/findUserState",
        async: false,
        type: "post",
        dataType: "json",
        success: function (list) {
            if (list != null) {
                var str = "<option value=''>用户状态</option>"
                for (var i = 0; i < list.length; i++) {
                    str += "<option value='" + list[i] + "'>" + list[i] + "</option>"
                }

                $('select').append(str);
                // layui.form.render('select', 'mySelectDiv');
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

        tabResult = table.render({
            elem: '#demo'
            , height: 312
            , url: path + "/adminControl/findUserList" //数据接口
            , page: true //开启分页
            , limit: 10
            , id: 'id'
            , parseData: function (res) {
                res.data = res.data.map(function (d) {
                    d['toolBar'] = '';
                    console.log(d);
                    return d;
                });
                console.log("res=" + res)
                return res;
            }
            , cols: [[ //表头
                {field: 'account', title: '账号', sort: true}
                , {field: 'name', title: '姓名', sort: true}
                , {
                    field: 'regTime',
                    title: '注册时间',
                    templet: "<div>{{layui.util.toDateString(d.regTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"
                }
                , {field: 'levelName', title: '等级名称', sort: true,}
                , {field: 'point', title: '积分', sort: true,}
                , {field: 'stateStr', title: '状态', sort: true,}
                , {title: '操作', field: "toolBar", templet: '#tools', align: "left"}
                , {field: 'id', title: '用户id', hide: true}

            ]]


        });
        table.on('tool(demo)', function (obj) {
            var data = obj.data;
            console.log(obj.tr)
            if (obj.event === 'enableAdmin') {
                layer.confirm('确定启用该用户吗？', function (index) {
                    if (updateState(data.id, "启用")) {
                        obj.update({
                            stateStr: '启用',
                            toolBar: ''
                        });
                    }
                });
            } else if (obj.event === 'stopAdmin') {
                layer.confirm('确定禁用该用户吗？', function (index) {
                    if (updateState(data.id, "禁用")) {
                        obj.update({
                            stateStr: '禁用',
                            toolBar: ''

                        });
                    }

                });
            }
        });


    });
    $("#search").click(function () {
        var account = $("#account").val();
        var name = $("#name").val();
        var path = $("#path").val()
        var stateStr = $("#mySelect").val()

        tabResult.reload({
            url: path + "/adminControl/findUserList" //数据接口
            , page: true
            , where: {
                account: account,
                name: name,
                stateStr: stateStr
            }

        })

    })

})


function updateState(id, state) {
// var id= id;
// var state=state;
    var path = $("#path").val();
    var str = "";
    $.ajax({
        url: path + "/adminControl/updateUserState",
        async: false,
        type: "post",
        data: "id=" + id + "&state=" + state,
        dataType: "text",
        success: function (msg) {
            if (msg == "success") {
                layer.msg('操作成功')
                str = "success"
            } else if (msg == "fail") {
                layer.msg("操作失败")
            }
        },
        error: function () {
            alert("网络错误")
        }
    })
    console.log(str)
    if (str == "success") {
        return true
    }
    return false;
}
$(function () {
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });
        laydate.render({
            elem: '#end' //指定元素
        });
    });
})