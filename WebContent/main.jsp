<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>商家首页</title>

</head>



<style>

	body{
		background-image:url('./images/background.jpg');
		background-repeat:repeat-x;
	}
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
	/*重置样式*/
	ol,ul,li{margin:0; padding:0;}
	li{list-style: none;}
	body{margin: 0;font-family: 'Microsoft YaHei', Arial, Helvetica, sans-serif;}
	/*外层布局*/
	.wrap{background: #EEEEEE;padding: 30px 0 40px;min-width: 640px;}
	/*列表容器设置相对定位*/
	.wrap .content{position: relative;width: 560px;z-index: 0;height: 400px;margin:0 auto;}
	/*用伪元素绝对定位，做出两条线，并设置为垂直居中、水平居中（居中是方便从中间向四周延伸）*/
	.wrap .content::before{content:"";position: absolute;z-index: 2;width: 560px;height: 1px;background: #ddd;left: 50%;margin-left: -280px;top: 50%;transition: all .4s ease-out;}
	.wrap .content::after{content:"";position: absolute;z-index: 2;height: 400px;width: 1px;background: #ddd;left: 50%;top: 50%;margin-top: -200px;transition: all .4s ease-out;}
	/*当鼠标经过列表容器时，使两条横线变长（分别增加了宽度、高度）*/
	.wrap .content:hover::before{width:580px;margin-left: -290px;}
	.wrap .content:hover::after{height:420px;margin-top: -210px;}
	/*用绝对定位设置四个列表的位置*/
	.wrap .content .list{position: absolute;z-index: 1;width: 280px;height: 200px;background: #fff;text-align: center;line-height: 200px;transition: all .4s ease-out;}
	.wrap .content .list:nth-child(1){left: 0;top: 0;}
	.wrap .content .list:nth-child(2){left: 280px;top: 0;}
	.wrap .content .list:nth-child(3){left: 0;top: 200px;}
	.wrap .content .list:nth-child(4){left: 280px;top: 200px;}
	/*当鼠标经过列表容器时，在四个列表相邻的部分添加margin，使其从中间向四周扩散（不改变宽高）*/
	.wrap .content:hover .list{margin: 10px;background: #3399CC;box-shadow: 0px 1px 10px rgba(0,0,0,.3)}
	/*要使元素形成扩散的效果，还需要移动其4个顶点的位置*/
	.wrap .content:hover .list:nth-child(1){margin-top: -10px;margin-left: -10px;}
	.wrap .content:hover .list:nth-child(2){margin-top: -10px;margin-left: 10px;}
	.wrap .content:hover .list:nth-child(3){margin-top: 10px;margin-left: -10px;}
	.wrap .content:hover .list:nth-child(4){margin-top: 10px;margin-left: 10px;}
	/*设置链接文字样式及变色*/
	.wrap .content .list a{font-size: 28px;color: #333;text-decoration: none;display: block;width: 100%;height: 100%;transition: all .3s ease 0s;}
	.wrap .content:hover a{color: #fff;}
</style>

<body>
	<div id="page-header">
		<h1>商家管理系统</h1>
	</div>
	<div class="wrap">
	<ul class="content">
	<li class="list">
	<a href="/Order/getalldishes_web">修改菜品</a>
	</li>
	<li class="list">
	<a rel="nofollow"  class="a-one" href="/Order/getturnover">查看营业额</a>
	</li>
	<li class="list">
	<a rel="nofollow"  class="a-one" href="info.jsp">发表公告</a>
	</li>
	<li class="list">
	<a href="/Order/FindallOrder">查看订单详细</a>
	</li>
	</ul>
	</div>
</body>
</html>