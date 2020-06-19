<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>店家发布公告</title>
<link href="./css/style1.css"  rel="stylesheet"  media="screen"  type="text/css">
  <link rel="stylesheet" href="../css/reset.css">
  <link rel="stylesheet" href="../css/carts.css">
  <script src="./js/jquery.min.js"></script>
  <script src="./js/jquery.dialog.js"></script>
  <script src="./js/universial.js"></script>
  <script src="./js/carts.js"></script>
  <style type="text/css">a {text-decoration: none}</style>
  
</head>
<style>
        body{
            position:absolute;
            top:0px;
            left:0px;
            right:0px;
            bottom:0px;
            padding:0px;
            margin:0px;
            font-size:16px;
            font-family: "微软雅黑";
        }
        .title{
            background:#2196f3;
            width:100%;
            height:60px;
            line-height:60px;
            text-align:left;
            text-indent:2rem;
            font-size:20px;
        }
        .content{
            position:absolute;
            left:0px;
            right:0px;
            top:60px;
            bottom:0px;
            border:1px solid black;
            background-color:#FFFFF0;
        }
        .search{
            position:absolute;
            left:30px;
            right:30px;
            top:0px;
            border:1px solid black;
            height:30px;
            text-align:left;
            background-color:#A9A9A9;
        }
        .table{
            position:absolute;
            left:30px;
            right:30px;
            top:30px;
            bottom:40px;
            border:1px solid black;
            text-align:left;
        }
        .table-title{
            position:absolute;
            left:0px;
            right:0px;
            top:0px;
            border:1px solid black;
            height:25px;
            background-color: #DB7093;
        }
        .table-list{
            position:absolute;
            left:0px;
            right:0px;
            top:25px;
            bottom:0px;
            border:1px solid black;
            background-color: #FFC0CB;
        }
        .table-btns{
            position:absolute;
            left:30px;
            right:30px;
            bottom:0px;
            border:1px solid black;
            height:40px;
            line-height:40px;
        }
    </style>
<body style="text-align:center;">
<div  class="nav_bg">
        <div class="wrap"> 
            <ul id="nav" class="nav clearfix">
                <li class="nLi" style="font-size: 30px;">
                    <h3 class="e"><a  href="main.jsp" style="font-size: 23px;">首页</a></h3>
                </li>
                <li class="nLi">
                  <h3 class="d"><a  href="/Order/getalldishes_web">添加菜品</a></h3>
                </li>
                <li class="nLi ">
                  <h3 class="d"><a href="/Order/FindallOrder">全部订单</a></h3>
                  
                </li>
          
                <li class="nLi ">
                  <h3 class="d"><a href="/Order/getturnover">营业额统计</a></h3>
                </li>
            </ul>
        </div>
    </div>

<div class="title">公告栏</div>
    <!--内容区-->
    <div class="content">
    		<%
			String errorInfo = (String)request.getAttribute("data");         // 获取错误属性
			if(errorInfo != null) {
			%>
			<script type="text/javascript" language="javascript">
			alert("<%=errorInfo%>");                                            // 弹出错误信息
			</script>
			<%
			}
			%>
        
        <!--表格区-->
        <form action="addaffiche">
        <div class="table">
        <div style="text-align: center;display:block;">              
            <div class="table-title">编辑公告</div>
        </div>
            <div class="table-list">
            <textarea id="editor" name="content" type="text/plain" style="width: 1200px ; height: 400px">
			这里可以书写
			</textarea>
            </div>
        </div>
        <div class="table-btns">
        <hr>
        <input style="color:#FF0033" type="submit" value="确认发布" />
		</div>
		</form>
    </div>
</body>
</html>