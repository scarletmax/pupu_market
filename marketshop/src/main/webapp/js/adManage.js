var tempData;
var tempObj;
var tempList;
$(function () {
        var path= $("#path").val();
        $.ajax({
            url:path+"/adControl/getAllType",
            async:false,
            type:"post",
            dataType:"json",
            success:function (list) {
                if(list!=null){
                    tempList=list;
                    var str="<option value=''>广告类型</option>"
                    for (var i = 0; i <list.length ; i++) {
                        str+="<option value='"+list[i]+"'>"+list[i]+"</option>"
                    }
                    $('#mySelect').append(str);
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
            ,url: path+"/adControl/showTable" //数据接口
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
                {field: 'title', title: '标题' ,fixed: 'left'}
                ,{field: 'goodName', title: '广告商品'}
                ,{field: 'typeStr', title: '广告类型'}
                ,{field: 'picUrl', title: '图片地址'},
                {field:'', title: '广告图片'
                    ,templet: function(d){
                        var picUrl = "../upload/adPic"+d.picUrl;
                        return '<div id="'+'myIcon'+d.id+'"><img src="'+picUrl+'"></div>';
                    }
                }
                ,{field: 'stateStr', title: '状态'}
                ,{title: '操作' ,field:"toolBar", templet:'#tools',align:"left"}
            ]]
        });
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            console.log(obj.tr)
             if(obj.event === 'enable'){
                layer.confirm('确定启用该广告吗？', function(index){
                    if(updateState(data.id,1)){
                        obj.update({
                            stateStr:'启用中',
                            toolBar:''
                        });
                    }
                });
                // layer.alert('编辑行：<br>'+ JSON.stringify(data))
            }else if(obj.event === 'disable'){
                layer.confirm('确定停用该广告吗？', function(index){
                    if(updateState(data.id,2)){
                        obj.update({
                            stateStr:'已停用',
                            toolBar:''
                        });
                    }
                });
                // layer.alert('编辑行：<br>'+ JSON.stringify(data))
            }else if(obj.event === 'edit'){
                 tempData=data;
                 tempObj=obj;
                 layui.use('layer', function () {
                     layer.open({
                         title: '编辑广告信息',
                         shadeClose:false,
                         maxmin: true,
                         type: 2,
                         content: path + "/jsp/adEdit.jsp",
                         area: ['500px', '400px']
                     });
                 });
                 // layer.alert('编辑行：<br>'+ JSON.stringify(data))
             }
        });


    });
    function reload(){
        var goodName= $("#goodName").val();
        var path=$("#path").val()
        var state=$("#mySelect2").val()
        var typeStr=$("#mySelect").val()
        var title=$("#title").val()
        tabResult.reload({
            url: path+"/adControl/showTable" //数据接口
            ,where:{
                title:title,
                goodName:goodName,
                state:state,
                typeStr:typeStr
            },page: {
                curr:1
            }

        })
    }
    $("#search").click(function () {
        var goodName= $("#goodName").val();
        var path=$("#path").val()
        var state=$("#mySelect2").val()
        var typeStr=$("#mySelect").val()
        var title=$("#title").val()

        tabResult.reload({
            url: path+"/adControl/showTable" //数据接口
            ,where:{
                title:title,
                goodName:goodName,
                state:state,
                typeStr:typeStr
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
        url:path+"/adControl/updateState",
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
            }else if(msg == "unavailable"){
                layer.msg("已超过可启用广告上限（轮播图3个，静态1个），请停用相关广告后再启用")
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

function updateType(obj) {
    var goodName= $("#goodName").val();
    var path=$("#path").val()
    var state=$("#mySelect2").val()
    var typeStr=$("#mySelect").val()
    var title=$("#title").val()
    tabResult.reload({
        url: path+"/adControl/showTable" //数据接口
        ,where:{
            title:title,
            goodName:goodName,
            state:state,
            typeStr:typeStr
        },page: {
            curr:1
        }

    })
}
function reload() {
    var goodName= $("#goodName").val();
    var path=$("#path").val()
    var state=$("#mySelect2").val()
    var typeStr=$("#mySelect").val()
    var title=$("#title").val()
    tabResult.reload({
        url: path+"/adControl/showTable" //数据接口
        ,where:{
            title:title,
            goodName:goodName,
            state:state,
            typeStr:typeStr
        },page: {
            curr:1
        }

    })
}
function add() {
    var path= $("#path").val()
    layui.use('layer', function () {
        layer.open({
            title: '添加新广告',
            shadeClose:false,
            maxmin: true,
            type: 2,
            content: path + "/jsp/adAdd.jsp",
            area: ['500px', '400px']
        });
    });
}