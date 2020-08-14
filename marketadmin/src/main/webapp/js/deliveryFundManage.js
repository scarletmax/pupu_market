$(function () {

    layui.use('table', function () {
        var table = layui.table;
        var path = $("#path").val()
        //第一个实例

        tabResult = table.render({
            elem: '#demo'
            , height: 312
            , url: path + "/deliveryFundControl/findFundList" //数据接口
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
                {field: 'deliverymanId', title: '配送员ID', sort: true}
                , {field: 'income', title: '提现金额', sort: true}
                , {
                    field: 'createTime',
                    title: '申请时间',
                    width: 200,
                    templet: "<div>{{layui.util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"
                }
                , {field: 'serial', title: '流水号', sort: true,}
                , {field: 'stateStr', title: '状态', sort: true,}
                , {title: '操作', field: "toolBar", templet: '#tools', align: "left"}
                , {field: 'id', title: '记录id', hide: true}

            ]]


        });
        table.on('tool(demo)', function (obj) {
            var data = obj.data;
            console.log(obj.tr)
            if (obj.event === 'examine') {
                layer.confirm('确定审核通过吗？', function (index) {
                    if (examine(data.id,data.serial,data.income)) {
                        obj.update({
                            stateStr: '成功',
                            toolBar: ''
                        });
                    }
                });
            } else if (obj.event === 'unExamine') {
                layer.confirm('确定审核不通过吗？', function (index) {
                    if (unExamine(data.id, "失败")) {
                        obj.update({
                            stateStr: '失败',
                            toolBar: ''

                        });
                    }

                });

            }
        });


    });


})

function examine(id,serial,income) {
    var path= $("#path").val();


    location.href =path+ "/alipay/index?WIDout_trade_no="+serial+"&WIDtotal_amount="+income+"&WIDsubject="+serial+"&WIDbody="+""

}



// function examine(id,state) {
//     var path= $("#path").val();
//     var str="";
//     $.ajax({
//         url:path+"/deliveryFundControl/examine",
//         async:false,
//         type:"post",
//         data:"id="+id+"&state="+state,
//         dataType:"text",
//         success:function (msg) {
//             if(msg == "success") {
//                 layer.msg('操作成功')
//                 str="success"
//             }else if(msg == "fail"){
//                 layer.msg("操作失败")
//             }
//         },
//         error:function () {
//             alert("网络错误")
//         }
//     })
//     console.log(str)
//     if(str=="success" ){
//         return true
//     }
//     return  false;
// }

function unExamine(id,state) {
    // var id= id;
    // var state=state;
    var path= $("#path").val();
    var str="";
    $.ajax({
        url:path+"/deliveryFundControl/unExamine",
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