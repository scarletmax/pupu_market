$(function () {
    var path = $("#path").val();
    $.ajax({
        url: path + "/noticeControl/findNoticeState",
        async: false,
        type: "post",
        dataType: "json",
        success: function (list) {
            if (list != null) {
                var str = "<option value=''>推送消息状态</option>"
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
            , url: path + "/noticeControl/findNoticeList" //数据接口
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
                {field: 'title', title: '推送消息标题', sort: true}
                , {field: 'content', title: '推送消息内容', sort: true}
                , {
                    field: 'noticeTime',
                    title: '推送时间',
                    templet: "<div>{{layui.util.toDateString(d.noticeTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"
                }
                // , {field: 'picUrl', title: '推送图片', sort: true,}
                , {field: 'stateStr', title: '状态', sort: true,}
                , {title: '操作', field: "toolBar", templet: '#tools', align: "left"}
                , {field: 'id', title: '推送消息id', hide: true}

            ]]


        });
        table.on('tool(demo)', function (obj) {
            var data = obj.data;
            console.log(obj.tr)
            if (obj.event === 'noticeMsg') {
                layer.confirm('确定推送该消息吗？', function (index) {
                    if (updateState(data.id, "已推送")) {
                        obj.update({
                            stateStr: '已推送',
                            toolBar: ''
                        });
                    }
                });
            } else if (obj.event === 'deleteMsg') {
                layer.confirm('确定删除该消息吗？', function (index) {
                    if (updateState(data.id, "已删除")) {
                        obj.update({
                            stateStr: '已删除',
                            toolBar: ''

                        });
                    }

                });
            }else if (obj.event === 'updateMsg') {
                window.tempData = data;
                    layer.open({
                        title: '修改推送消息',
                        shadeClose:false,
                        maxmin: true,
                        type: 2,
                        content: path + "/jsp/noticeEdit.jsp",
                        area: ['500px', '400px']
                    });

            }
        });


    });
    $("#search").click(function () {
        var name = $("#name").val();
        var path = $("#path").val();
        var stateStr = $("#mySelect").val();
        var startDate = $("#start").val();
        var endDate = $("#end").val();

        var startTimeNum = new Date(startDate).getTime();
        var endTimeNum = new Date(endDate).getTime();
        if (endTimeNum > startTimeNum){
            tabResult.reload({
                url: path + "/noticeControl/findNoticeList" //数据接口
                , page: true
                , where: {
                    name: name,
                    stateStr: stateStr,
                    startDate:startDate,
                    endDate:endDate
                }

            })
        }else{
            layer.msg("结束时间不能小于开始时间");
        }



    })

})

function add() {
    var path= $("#path").val()
    layui.use('layer', function () {
        layer.open({
            title: '添加推送消息',
            shadeClose:false,
            maxmin: true,
            type: 2,
            content: path + "/jsp/noticeAdd.jsp",
            area: ['500px', '400px']
        });
    });
}


function updateState(id, state) {
    var path = $("#path").val();
    var str = "";
    $.ajax({
        url: path + "/noticeControl/updateNoticeState",
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