$(function () {
    var path = $("#path").val();
    $.ajax({
        url: path + "/adminControl/findAdminState",
        async: false,
        type: "post",
        dataType: "json",
        success: function (list) {
            if (list != null) {
                var str = "<option value=''>管理员状态</option>"
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
            , url: path + "/adminControl/findAdminList" //数据接口
            , page: false //开启分页
            , limit: 5
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
                // {checkbox: true, fixed: true }
                {field: 'account', title: '账号', sort: true}
                , {field: 'name', title: '姓名', sort: true}
                // ,{field: 'uploadTime' , title: '上传时间' ,width:200,templet : "<div>{{layui.util.toDateString(d.uploadTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"}
                , {field: 'roleName', title: '角色', sort: true,}
                , {field: 'stateText', title: '状态', sort: true,}
                , {title: '操作', field: "toolBar", templet: '#tools', align: "left"}
                , {field: 'id', title: '管理员id', hide: true}

            ]]


        });
        table.on('tool(demo)', function (obj) {
            var data = obj.data;
            console.log(obj.tr)
            if (obj.event === 'enableAdmin') {
                layer.confirm('确定启用该用户吗？', function (index) {
                    if (updateState(data.id, "启用")) {
                        obj.update({
                            stateText: '启用',
                            toolBar: ''
                        });
                    }
                });
            } else if (obj.event === 'stopAdmin') {
                layer.confirm('确定禁用该用户吗？', function (index) {
                    if (updateState(data.id, "禁用")) {
                        obj.update({
                            stateText: '禁用',
                            toolBar: ''

                        });
                    }

                });
            } else if (obj.event === 'resetPwd') {
                layer.confirm('确定重置该用户密码吗？', function (index) {
                    if (resetPwd(data.id)) {

                    }

                });
            }else if (obj.event === 'deleteAdmin') {
                layer.confirm('确定删除该用户吗？', function (index) {
                    if (updateState(data.id, "已删除")) {
                        obj.update({
                            stateText: '已删除',
                            toolBar: ''

                        });
                    }

                });
                // layer.alert('编辑行：<br>'+ JSON.stringify(data))
            }
        });


    });
    $("#search").click(function () {
        var account = $("#account").val();
        var name = $("#name").val();
        var path = $("#path").val()
        var stateText = $("#mySelect").val()

        tabResult.reload({
            url: path + "/adminControl/findAdminList" //数据接口
            , page: false
            , where: {
                account: account,
                name: name,
                stateText: stateText
            }

        })

    })

})

function add() {
    var path= $("#path").val()
    layui.use('layer', function () {
        layer.open({
            title: '添加管理员账号',
            shadeClose:false,
            maxmin: true,
            type: 2,
            content: path + "/jsp/adminAdd.jsp",
            area: ['500px', '400px']
        });
    });
}

function updateState(id,state) {
    // var id= id;
    // var state=state;
    var path= $("#path").val();
    var str="";
    $.ajax({
        url:path+"/adminControl/updateState",
        async:false,
        type:"post",
        data:"id="+id+"&state="+state,
        dataType:"text",
        success:function (msg) {
            if(msg == "success") {
                layer.msg('操作成功')
                str="success"
            }else if(msg == "fail"){
                layer.msg("操作失败")
            }
        },
        error:function () {
            alert("网络错误")
        }
    })
    console.log(str)
    if(str=="success" ){
        return true
    }
    return  false;
}

function resetPwd(id) {
    var path= $("#path").val();
    var str="";
    $.ajax({
        url:path+"/adminControl/resetPwd",
        async:false,
        type:"post",
        data:"id="+id,
        dataType:"text",
        success:function (msg) {
            if(msg == "success") {
                layer.msg('重置成功')
                str="success"
            }else if(msg == "fail"){
                layer.msg("重置失败")
            }
        },
        error:function () {
            alert("网络错误")
        }
    })
    console.log(str)
    if(str=="success" ){
        return true
    }
    return  false;
}