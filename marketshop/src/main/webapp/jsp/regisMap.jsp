<%--
  Created by IntelliJ IDEA.
  User: maaaax
  Date: 2020/7/5
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
            <!-- 将百度地图API引入，设置好自己的key -->
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=UUftmgWr60AqpWKxtkXSMY9hFvSnzzUY"></script>
</head>
<body>
<label>纬度：</label>
<input type="text" id="lat" value="" readonly>

<label>经度：</label>
<input type="text" id="lng" value="" readonly>

<label>地址 ：</label>
<input type="text" id="address" readonly>
<button type="button" id="open">
    点击显示地图获取地址经纬度
</button>

<div id="allmap" style="width: 60%; height: 60%; position: absolute; display: none"></div>

<div id="r-result">请输入:<input type="text" id="test" size="20" style="width:150px;" /></div>
<div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>




</body>

<script type="text/javascript">
    document.getElementById('open').onclick = function () {
        if (document.getElementById('allmap').style.display == 'none') {
            document.getElementById('allmap').style.display = 'block';
        } else {
            document.getElementById('allmap').style.display = 'none';
        }
    }

    var map = new BMap.Map("allmap");
    var geoc = new BMap.Geocoder();   //地址解析对象
    var markersArray = [];
    var geolocation = new BMap.Geolocation();


    var point = new BMap.Point(116.404412, 39.914714);
    map.centerAndZoom(point, 12); // 中心点
    geolocation.getCurrentPosition(function (r) {
        if (this.getStatus() == BMAP_STATUS_SUCCESS) {
            var mk = new BMap.Marker(r.point);
            map.addOverlay(mk);
            map.panTo(r.point);
            map.enableScrollWheelZoom(true);
        }
        else {
            alert('failed' + this.getStatus());
        }
    }, {enableHighAccuracy: true})
    map.addEventListener("click", showInfo);


    //清除标识
    function clearOverlays() {
        if (markersArray) {
            for (i in markersArray) {
                map.removeOverlay(markersArray[i])
            }
        }
    }
    //地图上标注
    function addMarker(point) {
        var marker = new BMap.Marker(point);
        markersArray.push(marker);
        clearOverlays();
        map.addOverlay(marker);
    }
    //点击地图时间处理
    function showInfo(e) {
        document.getElementById('lng').value = e.point.lng;
        document.getElementById('lat').value =  e.point.lat;
        geoc.getLocation(e.point, function (rs) {
            var addComp = rs.addressComponents;
            var address = addComp.province + addComp.city + addComp.district + addComp.street + addComp.streetNumber;
            if (confirm("确定要地址是" + address + "?")) {
                document.getElementById('allmap').style.display = 'none';
                document.getElementById('address').value = address;
            }
        });
        addMarker(e.point);
    }

    // 百度地图API功能
    function G(id) {
        return document.getElementById(id);
    }

    var ac = new BMap.Autocomplete({"input" : "test"});

    ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
        var str = "";
        var _value = e.fromitem.value;
        var value = "";
        if (e.fromitem.index > -1) {
            value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        }
        str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
        value = "";
        if (e.toitem.index > -1) {
            _value = e.toitem.value;
            value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        }
        str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
        G("searchResultPanel").innerHTML = str;
    });

    var myValue;
    ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
        var _value = e.item.value;
        myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
        G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
    });



</script>
</html>
