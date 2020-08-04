
$(function () {
    layui.use('laydate', function () {
        var laydate = layui.laydate;
        //执行一个laydate实例
        laydate.render({
            elem: '#startDate',//指定元素
            trigger: 'click',

        });
        laydate.render({
            elem: '#endDate',//指定元素
            trigger: 'click',
        });
    });
})
