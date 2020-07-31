$(function () {
        var path= $("#path").val();
        $.ajax({
            url:path+"/deliverymanControl/getAllState",
            async:false,
            type:"post",
            dataType:"json",
            success:function (list) {
                if(list!=null){
                    var str="<option value=''>派送员状态</option>"
                    for (var i = 0; i <list.length ; i++) {
                        str+="<option value='"+list[i]+"'>"+list[i]+"</option>"
                    }
                    $('select').append(str);
                    // layui.form.render('select','mySelectDiv');
                }
            },
            error:function () {
                alert("网络错误")
            }
        })

})
$(function () {

    layui.use('table', function(){
        var table = layui.table;
        var path = $("#path").val()
        //第一个实例

        tabResult=table.render({
            elem: '#demo'
            ,height: 312
            ,url: path+"/deliverymanControl/showTable" //数据接口
            ,page: true //开启分页
            ,limit:5
            ,id:'id'
            ,parseData:function(res){
                res.data = res.data.map(function(d){d['toolBar']=''; console.log(d);return d;});
                console.log("res="+res)
                return res;
            }
            ,cols: [[ //表头
                // {checkbox: true, fixed: true }
                {field: 'account', title: '账号', sort: true, fixed: 'left',width:150}
                ,{field: 'name', title: '派送员姓名',width:170}
                ,{field: 'tel', title: '电话',width:210}
                ,{field: 'idCard', title: '身份证号',width:190}
                ,{field: 'sex', title: '性别',width:120}
                ,{field: 'stateStr', title: '状态',width:120}
                ,{title: '操作' ,field:"toolBar", templet:'#tools',align:"left",width:300}

            ]]
        });
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            console.log(obj.tr)
            if(obj.event === 'downFile'){
                layer.msg('ID：'+ data.id + ' 的查看操作');
            } else if(obj.event === 'del'){
                layer.confirm('确定不通过该派送员的申请吗？', function(index){
                    // obj.del();
                    // layer.close(index);
                    if(updateState(data.id,"审核不通过")) {
                        obj.update({
                            stateStr:'审核不通过',
                            toolBar:''
                        });
                    }
                });
            } else if(obj.event === 'pass'){
                layer.confirm('确定通过该派送员的申请吗？', function(index){
                    if(updateState(data.id,"启用")){
                        obj.update({
                            stateStr:'启用',
                            toolBar:''
                        });
                    }
                });
                // layer.alert('编辑行：<br>'+ JSON.stringify(data))
            }
            else if(obj.event === 'enable'){
                layer.confirm('确定启用该派送员吗？', function(index){
                    if(updateState(data.id,"启用")){
                        obj.update({
                            stateStr:'启用',
                            toolBar:''
                        });
                    }
                });
                // layer.alert('编辑行：<br>'+ JSON.stringify(data))
            }else if(obj.event === 'disable'){
                layer.confirm('确定禁用该派送员？', function(index){
                    if(updateState(data.id,"禁用")){
                        obj.update({
                            stateStr:'禁用',
                            toolBar:''
                        });
                    }
                });
                // layer.alert('编辑行：<br>'+ JSON.stringify(data))
            }
        });


    });
    function reload(){
        var name= $("#name").val();
        var account=$("#account")
        var path=$("#path").val()
        var state=$("#mySelect").val()
        tabResult.reload({
            url: path+"/deliverymanControl/showTable" //数据接口
            ,where:{
                name:name,
                account:account,
                state:state
            },page: {
                curr:1
            }

        })
    }
    $("#search").click(function () {
        var name= $("#name").val();
        var account=$("#account").val()
        var path=$("#path").val()
        var state=$("#mySelect").val()

        tabResult.reload({
            url: path+"/deliverymanControl/showTable" //数据接口
            ,where:{
                name:name,
                account:account,
                state:state
            },page: {
                curr:1
            }

        })

    })

})

function updateState(id,state) {
    // var id= id;
    // var state=state;
    var path= $("#path").val();
    var str="";
    $.ajax({
        url:path+"/deliverymanControl/updateState",
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