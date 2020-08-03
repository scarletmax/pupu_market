$(function () {
    layui.use('table', function(){
        var table = layui.table;
        var path = $("#path").val()
        //第一个实例

         tabResult=table.render({
            elem: '#demo'
            ,height: 400
            ,url: path+"/logControl/showTable" //数据接口
            ,page: true //开启分页
            ,limit:5
             ,id:'id'
            ,cols: [[ //表头
                 {field: 'occurTime' , title: '操作时间' ,templet : "<div>{{layui.util.toDateString(d.occurTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"}
                 ,{field: 'operator', title: '操作者'}
                ,{field: 'type', title: '操作类型'}
                ,{field: 'opr', title: '操作'}


            ]]


        });
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                layer.msg('ID：'+ data.id + ' 的查看操作');
            } else if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                layer.alert('编辑行：<br>'+ JSON.stringify(data))
            }
        });


    });



    $("#search").click(function () {
        var startDate=$("#start").val();
        var endDate=$("#end").val();
        var operator= $("#account").val();
        var path=$("#path").val()
        tabResult.reload({
            url: path+"/logControl/showTable" //数据接口
            ,where:{
                endDate:endDate,
                startDate:startDate,
                operator:operator
            },page: {
                curr:1
            }

    })

    })



})