<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="Data.*,java.util.*,com.google.gson.Gson"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>订单查询</title>
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
</style>

<body>


        
<div id="page-header">
		<h1>商家管理订单系统</h1>
	<form action="FindOrderBystate" method="post">
	<div> 
     <label>订单编号：</label><input id="search_sn" style="width:100px" name="order_id">
     <label>客户id：</label><input id="search_username" style="width:100px" name="cus_id">
     <label>订单状态：</label><input id="search_status" style="width:100px" name="state">
     <input type="submit"  value="提交"> 
     </div>
     </form>
	</div>
	
		
	<table align="center" width="100%">
	    <tr>
	        <th >订单编号</th>
	        <th>客户id</th>
	        <th>订单内容</th>
	        <th>订单总价格</th>
	        <th>订单状态</th>
	    </tr>
	    
	    <% 
	    String data=(String)request.getAttribute("data"); 
	    Gson gson = new Gson();
	    Allorder allorder=gson.fromJson(data, Allorder.class);
	    if(allorder.orderList!=null){
	    	for(int i=0;i<allorder.orderList.size();i++){
	    %>
	    <tr>
	        <th rowspan=<%=allorder.orderList.get(i).dishes.size()%>><%=allorder.orderList.get(i).getorder_id() %></th>
	        <th rowspan=<%=allorder.orderList.get(i).dishes.size()%>><%=allorder.orderList.get(i).getcus_id() %></th>
			<th><%=allorder.orderList.get(i).dishes.get(0).getname() %></th>
	        <th rowspan=<%=allorder.orderList.get(i).dishes.size()%>><%=allorder.orderList.get(i).getpriceall() %></th>
	        <th rowspan=<%=allorder.orderList.get(i).dishes.size()%>><%=allorder.orderList.get(i).getstate() %></th>
	    </tr> 
	    <%
		    for(int j=1;j<allorder.orderList.get(i).dishes.size();j++){
		    %>
		    <tr>
		    	<th><%=allorder.orderList.get(i).dishes.get(j).getname() %></th>
		    </tr>
		    <%
		    }
		%>
	    <%
	    	}
	    }
	    %>
	    
	    
	    
	</table>

</body>
</html>