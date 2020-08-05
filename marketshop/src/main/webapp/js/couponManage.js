$(function () {
    var path = $("#path").val();
    $.ajax({
        url: path + "/couponControl/findCouponState",
        async: false,
        type: "post",
        dataType: "json",
        success: function (list) {
            if (list != null) {
                var str = "<option value=''>优惠券状态</option>"
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
            , url: path + "/couponControl/findCouponList" //数据接口
            , page: true //开启分页
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
                {field: 'name', title: '优惠券名称', sort: true}
                // ,{field: 'uploadTime' , title: '上传时间' ,width:200,templet : "<div>{{layui.util.toDateString(d.uploadTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"}
                , {field: 'favorPrice', title: '优惠额度', sort: true,}
                , {field: 'limitCount', title: '限用次数', sort: true,}
                , {field: 'requirePrice', title: '消费金额', sort: true,}
                , {field: 'rule', title: '使用规则', sort: true,}
                , {field: 'stateStr', title: '状态', sort: true,}
                , {title: '操作', field: "toolBar", templet: '#tools', align: "left"}
                , {field: 'id', title: '优惠券id', hide: true}

            ]]


        });
        table.on('tool(demo)', function (obj) {
            var data = obj.data;
            console.log(obj.tr)
            if (obj.event === 'enable') {
                layer.confirm('确定启用该优惠券吗？', function (index) {
                    if (updateState(data.id, "启用")) {
                        obj.update({
                            stateText: '启用',
                            toolBar: ''
                        });
                    }
                });
            } else if (obj.event === 'stop') {
                layer.confirm('确定停用该优惠券吗？', function (index) {
                    if (updateState(data.id, "停用")) {
                        obj.update({
                            stateText: '停用',
                            toolBar: ''

                        });
                    }

                });
            }
        });


    });
    $("#search").click(function () {
        var name = $("#name").val();
        var favor = $("#favor").val();
        var stateStr = $("#mySelect").val();
        var path = $("#path").val();

        tabResult.reload({
            url: path + "/couponControl/findCouponList" //数据接口
            , page: false
            , where: {
                name: name,
                favor: favor,
                stateStr: stateStr
            }

        })

    })

})

function add() {
    var path= $("#path").val()
    layui.use('layer', function () {
        layer.open({
            title: '添加优惠券',
            shadeClose:false,
            maxmin: true,
            type: 2,
            content: path + "/jsp/couponAdd.jsp",
            area: ['500px', '400px']
        });
    });
}

function updateState(id,state) {
    var path= $("#path").val();
    var str="";
    $.ajax({
        url:path+"/couponControl/updateState",
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
