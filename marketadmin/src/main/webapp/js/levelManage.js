$(function () {

    layui.use('table', function () {
        var table = layui.table;
        var path = $("#path").val()
        //第一个实例

        tabResult = table.render({
            elem: '#demo'
            , height: 312
            , url: path + "/levelControl/findLevelList" //数据接口
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
                {field: 'name', title: '等级名称', sort: true}
                , {field: 'minPoint', title: '等级最小积分', sort: true}
                , {field: 'maxPoint', title: '等级最大积分', sort: true,}
                , {title: '操作', field: "toolBar", templet: '#tools', align: "left"}
                , {field: 'id', title: '等级id', hide: true}
            ]]
        });
        table.on('tool(demo)', function (obj) {
            var data = obj.data;
            console.log(obj.tr)
            if (obj.event === 'updateLevel') {
                window.tempData = data;
                layer.open({
                    title: '修改等级',
                    shadeClose:false,
                    maxmin: true,
                    type: 2,
                    content: path + "/jsp/levelEdit.jsp",
                    area: ['500px', '400px']
                });
            } else if (obj.event === 'deleteLevel') {
                layer.confirm('确定删除该等级吗？', function (index) {
                    if (deleteLevel(data.id)) {
                    }

                });
            }
        });


    });
})

function add() {
    var path= $("#path").val()
    layui.use('layer', function () {
        layer.open({
            title: '添加等级信息',
            shadeClose:false,
            maxmin: true,
            type: 2,
            content: path + "/jsp/levelAdd.jsp",
            area: ['500px', '400px']
        });
    });
}

// function updateLevel(id) {
//     var path= $("#path").val();
//     var str="";
//     $.ajax({
//         url:path+"/adminControl/updateLevel",
//         async:false,
//         type:"post",
//         data:"id="+id,
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

function deleteLevel(id) {
    var path= $("#path").val();
    var str="";
    $.ajax({
        url:path+"/levelControl/deleteLevel",
        async:false,
        type:"post",
        data:"id="+id,
        dataType:"text",
        success:function (msg) {
            if(msg == "success") {
                layer.msg('删除成功')
                str="success"
            }else if(msg == "fail"){
                layer.msg("删除失败")
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