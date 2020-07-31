$(function () {
    //获取所有权限
    var path= $("#path").val();
    $.ajax({
        url:path+"/menuControl/getAllRole",
        async:false,
        type:"post",
        dataType:"json",
        success:function (list) {
            var str=""
            if(list!=null){
                for (var i = 0; i <list.length ; i++) {
                    if(i=='0') {
                        str+="<p><input type='radio' value='"+list[i].id+"' name='role'  checked onchange='changeRole(this)'>"+list[i].name+"</p>"

                    }else {
                        str+="<p><input type='radio' value='"+list[i].id+"' name='role' onchange='changeRole(this)'>"+list[i].name+"</p>"

                    }
                }
                $("#roleDiv").append(str);
                // layui.form.render('select','mySelectDiv');
            }
        },
        error:function () {
            alert("网络错误")
        }
    })
})
$(function () {

    //获取菜单信息
    console.log($("input[name='role']:checked").val())
    var roleId=$("input[name='role']:checked").val()
    var path= $("#path").val()
    var unselected= $("#unselect-ul");
    var selected=$(".selected-ul")
    unselected.empty()
    selected.empty()
    // console.log(unselected)
    $.ajax({
        url:path+"/menuControl/queryAttr",
        async:true,
        type:"post",
        data:"roleId="+roleId,
        dataType:"json",
        success:function (msg) {
            if(msg!=null) {
                var attrList=msg.attrList;
                var unAttrList=msg.unAttrList;
                //已分配
                for (var i = 0; i <attrList.length ; i++) {
                    var parentMenu =attrList[i];
                    if(parentMenu.parentId=="0"){
                        unselected.append(" <li>" +
                            "                    <input type='checkbox' class='checkboxs parent leftP ' onclick='clickParent(this)' id='left"+parentMenu.id+"' name='"+parentMenu.id+"' value='"+parentMenu.id+"'/> \n" +
                            "                    <label for='left"+parentMenu.id+"'></label> \n" +
                            "                    <span>"+"⭐"+parentMenu.name+"</span> \n" +
                            "                </li>")
                        for (var j = 0; j <attrList.length ; j++) {
                            var menu=attrList[j];
                            if(menu.parentId==parentMenu.id){
                                unselected.append(" <li>" +
                                    "                    <input type='checkbox' class='checkboxs  '  id='"+menu.id+"' name='"+parentMenu.id+"' value='"+menu.id+"'/>\n" +
                                    "                    <label for='"+menu.id+"'></label>\n" +
                                    "                    <span>"+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+menu.name+"</span>\n" +
                                    "                </li>")
                            }
                        }
                    }
                }
                //未分配
                for (var i = 0; i <unAttrList.length ; i++) {
                    var parentMenu =unAttrList[i];
                    if(parentMenu.parentId=="0"){
                        selected.append(" <li>" +
                            "                    <input type='checkbox' class='checkboxs parent rightP ' onclick='clickParent(this)' id='left"+parentMenu.id+"' name='"+parentMenu.id+"' value='"+parentMenu.id+"'/> \n" +
                            "                    <label for='left"+parentMenu.id+"'></label> \n" +
                            "                    <span>"+"⭐"+parentMenu.name+"</span> \n" +
                            "                </li>")
                        for (var j = 0; j <unAttrList.length ; j++) {
                            var menu=unAttrList[j];
                            if(menu.parentId==parentMenu.id){
                                selected.append(" <li>" +
                                    "                    <input type='checkbox' class='checkboxs  '  id='"+menu.id+"' name='"+parentMenu.id+"' value='"+menu.id+"'/>\n" +
                                    "                    <label for='"+menu.id+"'></label>\n" +
                                    "                    <span>"+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+unAttrList[j].name+"</span>\n" +
                                    "                </li>")
                            }
                        }
                    }
                }
            }
        }

    })

})
$(function(){

    //全选函数
    $('.checkbox-all').click(function(){
        if($(this).prop('checked')){
            $(this).parent().next().find('.checkboxs').prop('checked',true);
        }else{
            $(this).parent().next().find('.checkboxs').prop('checked',false);
        }
        btn_status();
    })

    //单个checkbox与全选的关系函数
    $('.select-content').on('click','.checkboxs',function(e){

        var checkedAll = $(this).parents('.select-content').prev().find('.checkbox-all');
        var checkboxs = $(this).prop('checked');
        if(!checkboxs&&checkedAll.prop('checked')){
            checkedAll.prop('checked',false);
        }else if(checkboxs&&!checkedAll.prop('checked')){
            var lis = $(this).parents('ul').children();
            for(var i=0;i<lis.length;i++){
                if($(lis[i]).find('.checkboxs').prop('checked')){
                    if(i==lis.length-1){
                        checkedAll.prop('checked',true)
                    }
                }else{
                    break;
                }
            }
        }
        stopFunc(e);
    });
    $('.select-content').on('click','li',function(){
        $(this).children('.checkboxs').click();
        btn_status();
    })
    // 动态判断改变btn状态
    function btn_status(){
        var btn1 =document.getElementsByClassName('right')[0]
        var btn2 =document.getElementsByClassName('left')[1]
        var left_ul = document.getElementsByClassName('unselect-ul')
        var right_ul = document.getElementsByClassName('selected-ul')
        var left_ul_li = left_ul[0].children
        var right_ul_li = right_ul[0].children
        var left_btn = false
        var right_btn = false
        for(var i=0;i<left_ul_li.length;i++){
            if(left_ul_li[i].firstElementChild.checked == true){
                left_btn = true
            }
        }
        for(var i=0;i<right_ul_li.length;i++){
            if(right_ul_li[i].firstElementChild.checked == true){
                right_btn = true
            }
        }
        if(left_btn){
            btn1.classList.add('btn-cursor')
        }else{
            btn1.classList.remove('btn-cursor')
        }
        if(right_btn){
            btn2.classList.add('btn-cursor')
        }else{
            btn2.classList.remove('btn-cursor')
        }

    }
    // //父级菜单的点击属性
    // $(".parent").click(function () {
    //    var div;
    //     if($(this).hasClass('leftP')){
    //          div="#attr";
    //     }else {
    //          div="#unattr";
    //     }
    //     if($(this).prop('checked')) {
    //         var name= $(this).attr("name")
    //         $(div+" input[name='"+name+"']").prop('checked',true)
    //     }else {
    //         var name= $(this).attr("name")
    //         $(div+" input[name='"+name+"']").prop('checked', false)
    //     }
    // })
    //左右移按钮点击事件
    $('.arrow-btn').click(function(){
        var checkboxs,origin,target,num=0;
        var targetDiv;
        var part;
        if($(this).hasClass('right')){
            origin = $('.unselect-ul');
            target = $('.selected-ul');
            targetDiv="#unattr"
            part=1
        }else{
            origin = $('.selected-ul');
            target = $('.unselect-ul');
            targetDiv="#attr"
            part=2
        }
        checkboxs = origin.find('.checkboxs');
        var arr=[]
        for(var i=0;i<checkboxs.length;i++){
            if($(checkboxs[i]).prop('checked')){
                //克隆选中
                var that = $(checkboxs[i]).parent().clone();
                that.children('input').prop('checked',false);
                // //判断另一边是否有该父级菜单
                // var name= $(checkboxs[i]).attr("name");
                // if($(targetDiv+" input[name='"+name+"']").length>0){
                //     var node=$(targetDiv+" input[name='"+name+"']").last().next().next()[0];
                //     console.log(node)
                //     $(node).after(that)
                // }
                arr.push($(checkboxs[i]).val())
                // // 另外一边添加
                // target.append(that);
                // //原处移除
                // $(checkboxs[i]).parent().remove();
                //选中的元素添加到集合里

            }else{
                num++;
            }
        }
        if(checkboxs.length == num){
            alert('未选中任何一项');
        }else{
            origin.parent().prev().find('.checkbox-all').prop('checked',false);
            console.log( arr)
            if(part=="1"){
                removeAttr(arr);
            }else {
                newAttr(arr);
            }
        }
        btn_status();
    })

})


function stopFunc(e){
    e.stopPropagation?e.stopPropagation():e.cancelBubble=true;
}

function removeAttr(arr) {
    var path= $("#path").val()
    var roleId=$("input[name='role']:checked").val()
    $.ajax({
        url:path+"/menuControl/removeAttr",
        async:true,
        type:"post",
        data:"MenuIdArr="+arr+"&roleId="+roleId,
        dataType:"text",
        beforeSend:function () {
            $(".arrow-btn").prop("disabled","disabled")
        },
        success:function (msg) {

            if(msg!=null) {
                if(msg=="success"){
                    getList(roleId);
                }
            }
        },
        complete:function () {
            $(".arrow-btn").prop("disabled",false)
        },

    })

}

function newAttr(arr) {
    var path= $("#path").val()
    var roleId=$("input[name='role']:checked").val()
    $.ajax({
        url:path+"/menuControl/newAttr",
        async:true,
        type:"post",
        data:"MenuIdArr="+arr+"&roleId="+roleId,
        dataType:"text",
        beforeSend:function () {
            $(".arrow-btn").prop("disabled","disabled")
        },
        success:function (msg) {
            if(msg!=null) {
                if(msg=="success"){
                    getList(roleId);
                }
            }
        },
        complete:function () {
            $(".arrow-btn").prop("disabled",false)
        },

    })
}


function  clickParent(node) {
    var div;
    if($(node).hasClass('leftP')){
        div="#attr";
    }else {
        div="#unattr";
    }
    if($(node).prop('checked')) {
        var name= $(node).attr("name")
        $(div+" input[name='"+name+"']").prop('checked',true)
        console.log( $(div+" input[name='"+name+"']").last().next().next())
    }else {
        var name= $(node).attr("name")
        $(div+" input[name='"+name+"']").prop('checked', false)
    }
}
function changeRole(node) {
    var roleId= $(node).val()
    console.log(roleId)
    getList(roleId)
}
function getList(roleId) {
    var path= $("#path").val()
    var unselected= $("#unselect-ul");
    var selected=$(".selected-ul")
    unselected.empty()
    selected.empty()
    // console.log(unselected)
    $.ajax({
        url:path+"/menuControl/queryAttr",
        async:true,
        type:"post",
        data:"roleId="+roleId,
        dataType:"json",
        success:function (msg) {
            if(msg!=null) {
                var attrList=msg.attrList;
                var unAttrList=msg.unAttrList;
                //已分配
                for (var i = 0; i <attrList.length ; i++) {
                    var parentMenu =attrList[i];
                    if(parentMenu.parentId=="0"){
                        unselected.append(" <li>" +
                            "                    <input type='checkbox' class='checkboxs parent leftP ' onclick='clickParent(this)' id='left"+parentMenu.id+"' name='"+parentMenu.id+"' value='"+parentMenu.id+"'/> \n" +
                            "                    <label for='left"+parentMenu.id+"'></label> \n" +
                            "                    <span>"+"⭐"+parentMenu.name+"</span> \n" +
                            "                </li>")
                        for (var j = 0; j <attrList.length ; j++) {
                            var menu=attrList[j];
                            if(menu.parentId==parentMenu.id){
                                unselected.append(" <li>" +
                                    "                    <input type='checkbox' class='checkboxs  '  id='"+menu.id+"' name='"+parentMenu.id+"' value='"+menu.id+"'/>\n" +
                                    "                    <label for='"+menu.id+"'></label>\n" +
                                    "                    <span>"+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+menu.name+"</span>\n" +
                                    "                </li>")
                            }
                        }
                    }
                }
                //未分配
                for (var i = 0; i <unAttrList.length ; i++) {
                    var parentMenu =unAttrList[i];
                    if(parentMenu.parentId=="0"){
                        selected.append(" <li>" +
                            "                    <input type='checkbox' class='checkboxs parent rightP ' onclick='clickParent(this)' id='left"+parentMenu.id+"' name='"+parentMenu.id+"' value='"+parentMenu.id+"'/> \n" +
                            "                    <label for='left"+parentMenu.id+"'></label> \n" +
                            "                    <span>"+"⭐"+parentMenu.name+"</span> \n" +
                            "                </li>")
                        for (var j = 0; j <unAttrList.length ; j++) {
                            var menu=unAttrList[j];
                            if(menu.parentId==parentMenu.id){
                                selected.append(" <li>" +
                                    "                    <input type='checkbox' class='checkboxs  '  id='"+menu.id+"' name='"+parentMenu.id+"' value='"+menu.id+"'/>\n" +
                                    "                    <label for='"+menu.id+"'></label>\n" +
                                    "                    <span>"+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+unAttrList[j].name+"</span>\n" +
                                    "                </li>")
                            }
                        }
                    }
                }
            }
        }

    })
}
function allRemove() {
    var  x= confirm("是否要取消该角色所有权限？")
    if(x) {
        var checkboxs,origin,target,num=0;
        var targetDiv;
        var part;
        origin = $('.unselect-ul');
        target = $('.selected-ul');
        targetDiv="#unattr"
        part=1;
        checkboxs = origin.find('.checkboxs');
        var arr=[]
        for(var i=0;i<checkboxs.length;i++){
            arr.push($(checkboxs[i]).val())
        }
        origin.parent().prev().find('.checkbox-all').prop('checked',false);
        console.log( arr)
        if(part=="1"){
            removeAttr(arr);
        }else {
            newAttr(arr);
        }

        btn_status2();
    }
}

function allAttr() {
    var  x= confirm("是否要赋予该角色所有权限？")
    if(x) {
        var checkboxs,origin,target,num=0;
        var targetDiv;
        var part;

        origin = $('.selected-ul');
        target = $('.unselect-ul');
        targetDiv="#attr"
        part=2

        checkboxs = origin.find('.checkboxs');
        var arr=[]
        for(var i=0;i<checkboxs.length;i++){
            arr.push($(checkboxs[i]).val())
        }

        origin.parent().prev().find('.checkbox-all').prop('checked',false);
        console.log( arr)
        if(part=="1"){
            removeAttr(arr);
        }else {
            newAttr(arr);
        }

        btn_status2();
    }
}
// 动态判断改变btn状态
function btn_status2(){
    var btn1 =document.getElementsByClassName('right')[0]
    var btn2 =document.getElementsByClassName('left')[1]
    var left_ul = document.getElementsByClassName('unselect-ul')
    var right_ul = document.getElementsByClassName('selected-ul')
    var left_ul_li = left_ul[0].children
    var right_ul_li = right_ul[0].children
    var left_btn = false
    var right_btn = false
    for(var i=0;i<left_ul_li.length;i++){
        if(left_ul_li[i].firstElementChild.checked == true){
            left_btn = true
        }
    }
    for(var i=0;i<right_ul_li.length;i++){
        if(right_ul_li[i].firstElementChild.checked == true){
            right_btn = true
        }
    }
    if(left_btn){
        btn1.classList.add('btn-cursor')
    }else{
        btn1.classList.remove('btn-cursor')
    }
    if(right_btn){
        btn2.classList.add('btn-cursor')
    }else{
        btn2.classList.remove('btn-cursor')
    }

}