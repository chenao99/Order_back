<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="Data.*,java.util.*,com.google.gson.Gson"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>查看订单</title>
  <link href="./css/style1.css"  rel="stylesheet"  media="screen"  type="text/css">
  <link rel="stylesheet" href="../css/reset.css">
  <link rel="stylesheet" href="../css/carts.css">
  <script src="./js/jquery.min.js"></script>
  <script src="./js/jquery.dialog.js"></script>
  <script src="./js/universial.js"></script>
  <script src="./js/carts.js"></script>
  <style type="text/css">a {text-decoration: none}</style>


<body>
<div  class="nav_bg">
        <div class="wrap"> 
            <ul id="nav" class="nav clearfix">
                <li class="nLi" style="font-size: 30px;">
                    <h3 class="e"><a  href="main.jsp" style="font-size: 23px;">首页</a></h3>
                </li>
                <li class="nLi">
                  <h3 class="d"><a  href="info.jsp">发布公告</a></h3>
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
    <div class="projects2">
    <!--  a href = "getMenu">gotoServlet</a>-->
    
    <ul class="rightborder">
        
        <li class="instruct">
            <span style="padding:0px 70px 0 40px;position: relative ;top:25%;"><b>菜品图片</b> </span>
            <span style="padding:0px 100px 0 0px;position: relative ;top:25%;"><b>菜品序号</b> </span>
            <span style="padding:0px 100px 0 0;position: relative ;top:25%;"><b>菜品名称</b> </span>
            <span style="padding:0px 70px 0 30px;position: relative ;top:25%;"><b>菜品金额（每份）</b> </span>
            <span style="padding:0px 80px 0 30px;position: relative ;top:25%;"><b>修改库存数量</b></span>
            <hr>
            <hr>
        </li>
        <div class="cont">
        
            <% 
		    String data=(String)request.getAttribute("data"); 
		    Gson gson = new Gson();
		    ALLMenu allmenu=gson.fromJson(data, ALLMenu.class);
		    if(allmenu.geterror().equals("0")){
		    %>
		    
		    <script type="text/javascript" language="javascript">
			alert("插入菜品成功！");                                            // 弹出错误信息
			</script>	    
		    <%
		    }
		    else if(allmenu.geterror().equals("1")){
	    	%>
		    <script type="text/javascript" language="javascript">
			alert("插入菜品失败！");                                            // 弹出错误信息
			</script>	    
		    <%
		    }
		    else if(allmenu.geterror().equals("3")){
		    	%>
			    <script type="text/javascript" language="javascript">
				alert("插入菜系成功！");                                            // 弹出错误信息
				</script>	    
			    <%
			    }
		    else if(allmenu.geterror().equals("4")){
		    	%>
			    <script type="text/javascript" language="javascript">
				alert("插入菜系失败！");                                            // 弹出错误信息
				</script>	    
			    <%
			    }
		    if(allmenu!=null){
		   
		    %>
		    <form action="changedishesnum">
		    <%
		    	ArrayList<Menu> list=allmenu.results;
		    	for(int i=0;i<list.size();i++){
		    %>
		    <li class="instruct">
            <span style="padding:0px 65px 0 40px;position: relative ;top:25%;"><b><%=list.get(i).getid() %></b> </span>
            <span style="padding:0px 200px 0 40px;position: relative ;top:25%;"><b><%=list.get(i).gettitle() %></b> </span>
        	</li>
            <% 
            		for(int j=0;j<list.get(i).dishes.size();j++){
            %>
            <li class="dishes" id=<%=list.get(i).dishes.get(j).getid() %>>
                <img src=<%=list.get(i).dishes.get(j).geturl() %> width=137px height=80px />
                <span id="one"><%=list.get(i).dishes.get(j).getid() %></span> 
                <span id="two"><%=list.get(i).dishes.get(j).getname() %></span>                          
                <span id="three"><%=list.get(i).dishes.get(j).getprice() %></span>
                <span id="four">
                    <input type="text" name=<%=list.get(i).dishes.get(j).getid()%> value=<%=list.get(i).dishes.get(j).getsum()%> />
                </span>
                <span id="five"></span>
            </li>
            <%
            		}
		    	}
		    %>
		    <li class="dishes">
                <span style="text-align: center;display:block;">修改菜品数量</span> 
                <br>

                <div style="margin:0 auto;width:80px;">

						<input style="color:#FF0033" type="submit" value="确认修改" />
				</div>
                
                
            </li>
		    </form>
		    <%
		    }
		    %>
		    <form action="adddishes">
		    <li class="instruct">
            <span style="padding:0px 65px 0 40px;position: relative ;top:25%;"><b>插入新菜品</b> </span>
        	</li>
        	
		    <li class="dishes" >
                <!--img width=137px height=80px /-->
                <br>
                <div style="text-align: center;display:block;">
                <span >菜系id：<input type="text" style="width:60px;" name="newdishes_kindid"  /></span> 
                <span >菜品id：<input type="text" style="width:60px;" name="newid"  /></span> 
                <span >菜品名称：<input type="text" style="width:60px;" name="newname"  /></span>                          
                <span >菜品金额：<input type="text" style="width:60px;" name="newprice"  /></span>
                <span >剩余数量：<input type="text" style="width:60px;" name="newnum"  /></span>
                </div>
            </li>
           <div style="text-align: center;display:block;">
               <input style="color:#FF0033" type="submit" value="确认插入" />
               </div>
            </form>
            
            
            <form action="adddisheskind">
            <li class="instruct">
            <span style="padding:0px 65px 0 40px;position: relative ;top:25%;"><b>插入新菜系</b> </span>
        	</li>
        	<br>
            <li class="dishes" >
                <!--img width=137px height=80px /-->
                <div style="text-align: center;display:block;">
                <span >菜系id：<input type="text" name="newkindid"  /></span> 
                <span >菜系名称：<input type="text" name="newkindname"  /></span> 
                </div>
                <br>
            
            <div style="text-align: center;display:block;">
            <input style="color:#FF0033" type="submit" value="确认插入" />
            </div>
            </li>
            </form>
        </div>
    </ul>
    </div>


</body>
</html>