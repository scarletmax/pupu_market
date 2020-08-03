var nameArr = [];
var valueArr = [];
var obArr = [];

$(function() {
	var path= $("#path").val()
	$.ajax({
		method : "POST",
		url : path + "/dataAnalysisControl/getOrderNumByWeek",
		dataType : "text",
		success : function(msg) {
			var data = JSON.parse(msg);
			var arr= data;
			var count=getCount(arr)
			document.getElementById("numMsg").innerText="本周订单总数为："+count+"";
			for (var i = 0; i < arr.length; i++) {
				// 普通柱状图使用的数据
				nameArr.push(arr[i].name);//名字
				valueArr.push(arr[i].num);//值


			}
			createEchars();// 创建普通柱状图
			// rose();// 创建南丁格尔玫瑰圆饼图
		},
		error : function() {
			alert("服务器正忙");
		}
	});
});
function getCount(arr) {
	var count=0;
	for (var i = 0; i <arr.length ; i++) {
		count+=arr[i].num;
	}
	return count;
}
//普通柱状图
function createEchars() {

	//基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('echarts_div'));//dark为暗黑主题 不要可以去掉

	// 指定图表的配置项和数据
	var option = {
		title : {
			text : ''
		},
		tooltip : {},
		legend : {
			data : [ '柱状数据表' ]
		},
		xAxis : {
			data : nameArr
		},
		yAxis : {},
		series : [ {
			name : '数据',
			type : 'bar',
			data : valueArr,
			showAllSymbol: true
		} ],
		// dataZoom: [{
		// 	type: 'slider',
		// 	show: true, //flase直接隐藏图形
		// 	xAxisIndex: [0],
		// 	left: '9%', //滚动条靠左侧的百分比
		// 	bottom: -5,
		// 	start: 0,//滚动条的起始位置
		// 	end: 80 //滚动条的截止位置（按比例分割你的柱状图x轴长度）
		// }] ,
	};
	
	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option,true);

}
function init() {
	 nameArr = [];
	 valueArr = [];
	 // obArr = [];
}
function toWeek() {
	document.getElementById("weekBtn").disabled = true;
	document.getElementById("monthBtn").disabled = false;
	document.getElementById("yearBtn").disabled = false;

	document.getElementById("weekBtn").style.backgroundColor="grey";
	document.getElementById("monthBtn").style.backgroundColor="#008B8B";
	document.getElementById("yearBtn").style.backgroundColor="#008B8B";
	var path=$("#path").val()
	var url = path + "/dataAnalysisControl/getOrderNumByWeek";
	var str="本周总订单数为："
	showTable(url,str);
}
function toMonth() {
	document.getElementById("weekBtn").disabled = false;
	document.getElementById("monthBtn").disabled = true;
	document.getElementById("yearBtn").disabled = false;

	document.getElementById("weekBtn").style.backgroundColor="#008B8B";
	document.getElementById("monthBtn").style.backgroundColor="grey";
	document.getElementById("yearBtn").style.backgroundColor="#008B8B";
	var path=$("#path").val()
	var url = path + "/dataAnalysisControl/getOrderNumByMonth";
	var str="本月总总订单数为："
	showTable(url,str);
}
function toYear() {
	document.getElementById("weekBtn").disabled = false;
	document.getElementById("monthBtn").disabled = false;
	document.getElementById("yearBtn").disabled = true;

	document.getElementById("weekBtn").style.backgroundColor="#008B8B";
	document.getElementById("monthBtn").style.backgroundColor="#008B8B";
	document.getElementById("yearBtn").style.backgroundColor="grey";
	var path=$("#path").val()
	var url = path + "/dataAnalysisControl/getOrderNumByYear";
	var str="近半年总订单数为："
	showTable(url,str);

}

function showTable(url,str) {
	init()
	$.ajax({
		method : "POST",
		url : url,
		dataType : "text",
		success : function(msg) {
			var data = JSON.parse(msg);
			var arr= data;
			var count=getCount(arr)
			document.getElementById("numMsg").innerText=str+count+"";
			for (var i = 0; i < arr.length; i++) {
				// 普通柱状图使用的数据
				nameArr.push(arr[i].name);//名字
				valueArr.push(arr[i].num);//值
				// // 南丁格尔玫瑰圆饼图使用的数据
				// obArr.push({
				// 	value : arr[i].num,
				// 	name : arr[i].name
				// });

			}
			createEchars();// 创建普通柱状图
			// rose();// 创建南丁格尔玫瑰圆饼图
		},
		error : function() {
			alert("服务器正忙");
		}
	});
}
// //南丁格尔玫瑰图
// function rose() {
//
// 	//基于准备好的dom，初始化echarts实例
// 	var myChart2 = echarts.init(document.getElementById('echarts_div2'),"dark");//dark为暗黑主题 不要可以去掉
//
// 	var option = {
// 		title : {
// 			text : 'ECharts 南丁格尔玫瑰图'
// 		},
// 		series : [ {
// 			name : '访问来源',
// 			type : 'pie',
// 			roseType: 'angle',//南丁格尔玫瑰图样式  去掉则显示基本圆饼图
// 			radius : '55%',
// 			data : obArr
// 		} ]
// 	};
//
//
// 	myChart2.setOption(option);
// }
