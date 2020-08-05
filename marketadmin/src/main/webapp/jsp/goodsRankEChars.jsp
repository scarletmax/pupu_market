<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>EChars插件使用案例</title>

	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/EChars/css/style.css">


<%--	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/order_count.css">--%>
	<script src="${pageContext.request.contextPath}/static/EChars/js/jquery-3.4.1.js"></script>
	<script src="${pageContext.request.contextPath}/static/EChars/js/echarts.js"></script>
	<script src="${pageContext.request.contextPath}/static/EChars/js/json2.js"></script>

</head>


<body>
<input type="hidden" value="<%=request.getContextPath()%>" id="path">
<div id="echarts_div"  style="width: 1000px;height:800px;"></div>




<script type="text/javascript">

	// $(function () {
	// 	var arr=[];
	// 	$.ajax({
	// 		url: path + "/goodsRankControl/findgoodsRank",
	// 		type: 'post',
	// 		// data: {"id": data.id, "purpose": "enable"},
	// 		async: false,
	// 		dataType: 'json',
	// 		success: function (msg) {
	// 			console.log("msg="+msg);
	// 			var rows=eval(msg);
	//
	// 			//调用函数获取值，转换成数组模式
	//
	// 			for(var i=0;i<rows.length;i++)
	// 			{
	// 				arr.push(rows[i].accountUse);
	//
	// 			}
	// 	}
	// 	});
	// 	return arr;
	// });
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('echarts_div'));
var path=$("#path").val();
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '商品销量排名'
        },
        tooltip: {},
        legend: {
            data: ['销量']
        },
		xAxis : [ {
			type : 'category',
			data: (function () {
				var arr=[];
				$.ajax({
					url: path + "/goodsRankControl/findgoodsRank",
					type: 'post',
					// data: {"id": data.id, "purpose": "enable"},
					async: false,
					dataType: 'json',
					success: function (msg) {
						console.log("msg="+msg);
						var rows=eval(msg);

						//调用函数获取值，转换成数组模式

						for(var i=0;i<rows.length;i++)
						{
							arr.push(rows[i].goodsName);
							console.log(arr);
						}
					}
				});
				return arr;

			})(),
			axisLabel:{
				interval:0,//横轴信息全部显示
				rotate:-15,//-15度角倾斜显示
			},
		} ],

        yAxis: {},
        series: [{
            name: '销量',
            type: 'bar',
            data: (function () {
				var arr=[];
				$.ajax({
					url: path + "/goodsRankControl/findgoodsRank2",
					type: 'post',
					// data: {"id": data.id, "purpose": "enable"},
					async: false,
					dataType: 'json',
					success: function (msg) {
						console.log("msg="+msg);
						var rows=eval(msg);

						//调用函数获取值，转换成数组模式

						for(var i=0;i<rows.length;i++)
						{
							arr.push(rows[i].tatol);

						}
					}
				});
				return arr;

			})()
        }],
		grid: {
			y2: 150  //增加柱形图纵向的高度
		},

    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);





</script>
</body>
</html>