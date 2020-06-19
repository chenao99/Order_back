                                                     <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="Data.*,java.util.*,com.google.gson.Gson"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>营业额显示</title>
<link href="./css/style1.css"  rel="stylesheet"  media="screen"  type="text/css">
  <link rel="stylesheet" href="../css/reset.css">
  <link rel="stylesheet" href="../css/carts.css">
  <script src="./js/jquery.min.js"></script>
  <script src="./js/jquery.dialog.js"></script>
  <script src="./js/universial.js"></script>
  <script src="./js/carts.js"></script>
</head>

<style>
	#page-header {
	    background-color:#3399CC;
	    color:white;
	    text-align:center;
	    padding:5px;
	}
	#page-wrap {
	    line-height:30px;
	    background-color:#eeeeee;
	    height:100%;
	    width:100%;
	    float:left;
	    padding:5px; 
	}
	#page-footer {
	    background-color:black;
	    color:white;
	    clear:both;
	    text-align:center;
	    padding:5px; 
	}
	
	
	div {
	    display: block;
	}
	
	ol, ul ,li{
	    padding-left: 0;
	    list-style-type: none;
	}
	
	ul, menu, dir {
	    display: block;
	    list-style-type: disc;
	    -webkit-margin-before: 1em;
	    -webkit-margin-after: 1em;
	    -webkit-margin-start: 0px;
	    -webkit-margin-end: 0px;
	    -webkit-padding-start: 40px;
	}
	
	li {
	    display: list-item;
	    text-align: -webkit-match-parent;
	    float:left;
	}
	
	.addr-em-hidden, .clearfix:after, .dialog-address .modify, .shopping-cart .disabled-food a.minus, .shopping-cart .disabled-food a.plus, .shopping-cart .discount-food a.minus, .shopping-cart .discount-food a.plus, .unvisialbe {
	    visibility: hidden;
	}
	
	.rest-li:nth-child(4n+2) .rest-outer {
	    left: 242px;
	}
	.rest-list .transition {
	    transition: left .5s;
	}
	home_dce239b8.css:1
	.rest-outer {
	    padding: 20px 16px 0;
	    background-color: #fff;
	}
	home_dce239b8.css:1
	.rest-outer, .restaurant {
	    width: 210px;
	    height: 250px;
	}
	home_dce239b8.css:1
	.imgsort-wrapper, .notice, .rest-list, .rest-outer, .restaurant .others {
	    overflow: hidden;
	}
	
	.content{
	margin:0 auto; 
	width:800px;
	}
</style>

<body>


	
	<table align="center" width="100%">
	    <tr>
	        <th>每日营业额</th>
	    </tr>
	    
	</table>
	
	
   <div class="content" style="width:50%">
  	<div class="display_none">
  		<canvas  id="popChart2" width="800" height="600">
  	</div>
  </div>
  <script src="./js/jquery.js"></script>
	<script src="./js/Chart.js"></script>
	<script type="text/javascript">
    var popCanvas2 =document.getElementById("popChart2").getContext("2d");
	<%
	String data=(String)request.getAttribute("data"); 
    Gson gson = new Gson();
    turnover turnover=gson.fromJson(data, turnover.class);
    ArrayList<String> dateList=turnover.date;
    ArrayList<Double> priceList=turnover.affiche;
    System.out.println(dateList);
	%>
	var priceLists=<%=priceList%>;
	var dateLists=<%=dateList%>;
    var lineChart = new Chart(popCanvas2, {
        type: 'line',
        data: {
          labels:dateLists,
          datasets: [{
            label:'营业额',
            data: priceLists,
            backgroundColor:[
            'rgba(255, 99, 132, 0.6)',
            'rgba(54, 162, 235, 0.6)',
            'rgba(255, 206, 86, 0.6)',
            'rgba(153, 102, 255, 0.6)'
            ]
          }]
        }
      });
    $(function(){
    	$(".left li").click(
    		function(){
    			var divShow = $(".content").children("div");
    			if(!$(this).hasClass("selected")){
    				var index = $(this).index();   
    				$(this).addClass("selected");            
            $(this).siblings("li").removeClass("selected");                     
            $(divShow[index]).show("fast");
            $(divShow[index]).siblings("div").hide("fast");
          }
    		}
    	)
    })
    </script>

</body>
</html>