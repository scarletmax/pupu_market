<%--
  Created by IntelliJ IDEA.
  User: maaaax
  Date: 2020/7/5
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.2</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/X-admin/css/font.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/X-admin/css/xadmin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/EChars/css/style.css">

    <script src="<%=request.getContextPath()%>/static/X-admin/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/X-admin/js/xadmin.js"></script>

    <script src="${pageContext.request.contextPath}/static/EChars/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/EChars/js/echarts.js"></script>
    <script src="${pageContext.request.contextPath}/static/EChars/js/json2.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<input type="hidden" value="<%=request.getContextPath()%>" id="path">
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-body ">
                    <blockquote class="layui-elem-quote">欢迎管理员：
                        <span class="x-red">${adminName}</span>！当前时间:2018-04-25 20:50:53
                    </blockquote>
                </div>
            </div>
        </div>
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">数据统计</div>
                <div class="layui-card-body ">
                    <ul class="layui-row layui-col-space10 layui-this x-admin-carousel x-admin-backlog">
                        <li class="layui-col-md3 layui-col-xs6">
                            <a href="javascript:;" class="x-admin-backlog-body">
                                <h3>总库存</h3>
                                <p>
                                    <cite id="totalInventory">66</cite></p>
                            </a>
                        </li>
                        <li class="layui-col-md3 layui-col-xs6">
                            <a href="javascript:;" class="x-admin-backlog-body">
                                <h3>商品总销量</h3>
                                <p>
                                    <cite id="totalSales">12</cite></p>
                            </a>
                        </li>
                        <li class="layui-col-md3 layui-col-xs6">
                            <a href="javascript:;" class="x-admin-backlog-body">
                                <h3>订单总数</h3>
                                <p>
                                    <cite id="totalOrder">99</cite></p>
                            </a>
                        </li>
                        <li class="layui-col-md3 layui-col-xs6">
                            <a href="javascript:;" class="x-admin-backlog-body">
                                <h3>总营业额</h3>
                                <p>
                                    <cite id="totalAmount">67</cite></p>
                            </a>
                        </li>

                    </ul>
                </div>
            </div>
        </div>

        <!--折线统计图-->
        <div class="layui-col-sm12 layui-col-md6">
            <div class="layui-card">
                <div class="layui-card-header">商店销量排名</div>
                <div class="layui-card-body" style="min-height: 280px;">
                    <div id="main1" class="layui-col-sm12" style="height: 300px;"></div>

                </div>
            </div>
        </div>

        <div class="layui-col-sm12 layui-col-md6">
            <div class="layui-card">
                <div class="layui-card-header">商店种类排名</div>
                <div class="layui-card-body" style="min-height: 280px;">
                    <div id="main3" class="layui-col-sm12" style="height: 300px;"></div>

                </div>
            </div>
        </div>


        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">开发团队</div>
                <div class="layui-card-body ">
                    <table class="layui-table">
                        <tbody>
                        <tr>
                            <th>版权所有</th>
                            <td>xuebingsi(xuebingsi)
                                <a href="http://x.xuebingsi.com/" target="_blank">访问官网</a></td>
                        </tr>
                        <tr>
                            <th>开发者</th>
                            <td>老李</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <style id="welcome_style"></style>
        <div class="layui-col-md12">
            <blockquote class="layui-elem-quote layui-quote-nm">感谢layui,百度Echarts,jquery,本系统由x-admin提供技术支持。</blockquote>
        </div>
    </div>
</div>

<script>

    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main1'));
    var path = $("#path").val();

    // 指定图表的配置项和数据
    var option = {
        grid: {
            top: '5%',
            right: '1%',
            left: '1%',
            bottom: '10%',
            containLabel: true
        },
        tooltip: {
            trigger: 'axis'
        },
        xAxis: {
            type: 'category',
            data: (function () {
                var arr = [];
                $.ajax({
                    url: path + "/goodsRankControl/findgoodsRank",
                    type: 'post',
                    // data: {"id": data.id, "purpose": "enable"},
                    async: false,
                    dataType: 'json',
                    success: function (msg) {
                        // console.log("msg="+msg);
                        var rows = eval(msg);

                        //调用函数获取值，转换成数组模式

                        for (var i = 0; i < rows.length; i++) {
                            arr.push(rows[i].goodsName);
                            // console.log(arr);
                        }
                    }
                });
                return arr;

            })(),
            axisLabel: {
                interval: 0,//横轴信息全部显示
                rotate: -15,//-15度角倾斜显示
            },
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            name: '用户量',
            data: (function () {
                var arr = [];
                $.ajax({
                    url: path + "/goodsRankControl/findgoodsRank2",
                    type: 'post',
                    // data: {"id": data.id, "purpose": "enable"},
                    async: false,
                    dataType: 'json',
                    success: function (msg) {
                        // console.log("msg="+msg);
                        var rows = eval(msg);

                        //调用函数获取值，转换成数组模式

                        for (var i = 0; i < rows.length; i++) {
                            arr.push(rows[i].tatol);

                        }
                    }
                });
                return arr;

            })(),
            type: 'line',
            smooth: true
        }]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

    var arrName = [];
    var arrCo = [];
   var str=[];
    $(function () {

        $.ajax({
            url: path + "/goodsTypeRankControl/findGoodsTypeRank",
            type: 'post',
            // data: {"id": data.id, "purpose": "enable"},
            async: false,
            dataType: 'json',
            success: function (msg) {
                console.log("msg=" + msg);
                var rows = eval(msg);

                //调用函数获取值，转换成数组模式

                $(msg).each(function (i) {

                    arrName.push(msg[i].name);
                    var listGoods = new Object;
                    listGoods.name=msg[i].name;
                    listGoods.value=msg[i].value;
                    str.push(listGoods);
                });


                console.log("arrName=" + arrName);
                // listGoods = JSON.stringify(msg);
                // console.log("listGoods=" + listGoods)
                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('main3'));

               // var  option = {
               //      backgroundColor: '#2c343c',
               //
               //      title: {
               //          text: 'Customized Pie',
               //          left: 'center',
               //          top: 20,
               //          textStyle: {
               //              color: '#cc5229'
               //          }
               //      },
               //
               //      tooltip: {
               //          trigger: 'item',
               //          formatter: '{a} <br/>{b} : {c} ({d}%)'
               //      },
               //
               //      visualMap: {
               //          show: false,
               //          min: 20,
               //          max: 600,
               //          inRange: {
               //              colorLightness: [0, 1]
               //          }
               //      },
               //      series: [
               //          {
               //              name: '访问来源',
               //              type: 'pie',
               //              radius: '55%',
               //              center: ['50%', '50%'],
               //              data: str.sort(function (a, b) { return a.value - b.value; }),
               //              roseType: 'radius',
               //              label: {
               //                  color: 'rgba(255, 255, 255, 0.3)'
               //              },
               //              labelLine: {
               //                  lineStyle: {
               //                      color: 'rgba(255, 255, 255, 0.3)'
               //                  },
               //                  smooth: 0.2,
               //                  length: 10,
               //                  length2: 20
               //              },
               //              itemStyle: {
               //                  color: '#c23531',
               //                  shadowBlur: 200,
               //                  shadowColor: 'rgba(0, 0, 0, 0.5)'
               //              },
               //
               //              animationType: 'scale',
               //              animationEasing: 'elasticOut',
               //              animationDelay: function (idx) {
               //                  return Math.random() * 200;
               //              }
               //          }
               //      ]
               //  };



                // 指定图表的配置项和数据
                var option = {
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        data:arrName
                    },

                    series: [
                        {
                            name: '访问来源',
                            type: 'pie',
                            radius: '55%',
                            center: ['50%', '60%'],
                            data:  str.sort(function (a, b) { return a.value - b.value; }),
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                };

                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            }
        });

    });

    $(function () {
        $.ajax({
            url: path + "/shopStatisticsControl/shopStatistics",
            type: 'post',
            // data: {"id": data.id, "purpose": "enable"},
            async: true,
            dataType: 'json',
            success: function (msg) {
                console.log("msf="+msg);
                $("#totalInventory").text(msg.totalInventory);
                $("#totalSales").text(msg.totalSales);
                $("#totalOrder").text(msg.totalOrder);
                $("#totalAmount").text(msg.totalAmount);
            },
            error:function () {

                alert("网络失败")
            }
        })
    })

</script>
</body>

</html>
