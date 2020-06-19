<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html charset="UTF-8">
<title>login</title>
<script type="text/javascript">
<script src="./js/login.js"></script>

<style type="text/css">
*{
	margin: 0;
	padding: 0;
}
#wrap {
	height: 719px;
	width: 100;
	background-image: url(4.jpg);
	background-repeat: no-repeat;
	background-position: center center;
	position: relative;
}
#head {
	height: 120px;
	width: 100;
	background-color: #191970;
	text-align: center;
	position: relative;
}
#foot {
	width: 100;
	height: 126px;
	background-color: #191970;
	position: relative;
}
#wrap .logGet {
	height: 408px;
	width: 368px;  
	position: absolute;
	background-color: #FFFFFF;
	top: 20%;
	right: 15%;
}
.logC a button {
	width: 100%;
	height: 45px;
	margin:5px 5px;
	background-color: #4B0082;
	border: none;
	color: white;
	font-size: 18px;
}
.logD a button {
	width: 50%;
	height: 45px;
	background-color: #4B0082;
	border: none;
	color: white;
	font-size: 18px;
}
.logGet .logD.logDtip .p1 {
	display: inline-block;
	font-size: 28px;
	margin-top: 30px;
	width: 86%;
}
#wrap .logGet .logD.logDtip {
	width: 86%;
	border-bottom: 1px solid #4B0082;
	margin-bottom: 60px;
	margin-top: 0px;
	margin-right: auto;
	margin-left: auto;
}
.logGet .lgD img {
	position: absolute;
	top: 12px;
	left: 8px;
}
.logGet .lgD input {
	width: 100%;
	height: 42px;
	text-indent: 2.5rem;
}
#wrap .logGet .lgD {
	width: 86%;
	position: relative;
	margin-bottom: 30px;
	margin-top: 30px;
	margin-right: auto;
	margin-left: auto;
}
#wrap .logGet .logC {
	width: 86%;
	margin-top: 0px;
	margin-right: auto;
	margin-bottom: 0px;
	margin-left: auto;
}
.title {
	font-family: "宋体";
	color: #FFFFFF;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);  /* 使用css3的transform来实现 */
	font-size: 36px;
	height: 40px;
	width: 30%;
}
.sidetitle {
	font-family: "宋体";
	color: #FFFFFF;
	position: absolute;
	top: 50%;
	left: 80%;
	transform: translate(-50%, -50%);  /* 使用css3的transform来实现 */
	font-size: 12px;
	height: 40px;
	width: 30%;
}
 
.copyright {
	font-family: "宋体";
	color: #FFFFFF;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);  /* 使用css3的transform来实现 */
	height: 60px;
	width: 40%;
	text-align:center;
}
	
#background 
{ 
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    overflow: hidden;
    background-color: #211f1f; 
    display:none\8;
} 
#background .bg-photo 
{
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    display: none;
    overflow: hidden;
    -webkit-background-size: cover !important;
    -moz-background-size: cover !important;
    -o-background-size: cover !important;
    background-size: cover !important;
} 

#background .bg-photo-1 
{ 
    background: url('https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1577368942619&di=010029c520ef86bb372fd1d2d264c075&imgtype=0&src=http%3A%2F%2Fbpic.588ku.com%2Fback_pic%2F05%2F81%2F01%2F635c305a69e5d52.jpg') no-repeat center center;
} 

#background-ie { 
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    overflow: hidden;
    background-color: #211f1f;
}

#foot .copyright .img {
	width: 100%;
	height: 24px;
	position: relative;
}
.copyright .img .icon {
	display: inline-block;
	width: 24px;
	height: 24px;
	margin-left: 22px;
	vertical-align: middle;
	background-image: url(%E7%94%B5%E5%AD%90%E9%82%AE%E4%BB%B6.png);
	background-repeat: no-repeat;
	vertical-align: middle;
	margin-right: 5px;
}
	
.copyright .img .icon1 {
	display: inline-block;
	width: 24px;
	height: 24px;
	margin-left: 22px;
	vertical-align: middle;
	background-image: url(%E5%9C%B0%E5%9D%80.png);
	background-repeat: no-repeat;
	vertical-align: middle;
	margin-right: 5px;
}
.copyright .img .icon2 {
	display: inline-block;
	width: 24px;
	height: 24px;
	margin-left: 22px;
	vertical-align: middle;
	background-image: url(%E8%81%94%E7%B3%BB%E6%96%B9%E5%BC%8F.png);
	background-repeat: no-repeat;
	vertical-align: middle;
	margin-right: 5px;
}
#foot .copyright p {
	height: 24px;
	width: 100%;
}
</style>
</head>
<body>
<div id="background">
<div class="bg-photo bg-photo-1" style="display: block;"></div>
</div>
<div class="header" id="head">
  <div class="title">点餐商家客户端系统</div>
  <div class="sidetitle">
      注：请使用用户1234登录，密码为wpy</div>
</div>


<div class="wrap" id="wrap">

	<div class="logGet">
			<!-- 头部提示信息 -->
			<%
			String errorInfo = (String)request.getAttribute("data");         // 获取错误属性
			if(errorInfo != null) {
			%>
			<script type="text/javascript" language="javascript">
			alert("<%=errorInfo%>");                                            // 弹出错误信息
			window.location='login.jsp' ;                            // 跳转到登录界面
			</script>
			<%
			}
			%>
			
			<form name="form1" action="/Order/loginweb"  method="post">
			
			<div class="logD logDtip">
				<p class="p1">店家登录</p>
			</div>
			
			<!-- 输入框 -->
			<div class="lgD">
				<img src="img/logName.png" width="20" height="20" alt=""/>
				<input name="username" type="text" 
					placeholder="输入用户名" />
			</div>
			<div class="lgD">
				<img src="img/logPwd.png" width="20" height="20" alt=""/>
				<input name="password" type="password"
					placeholder="输入用户密码" />
			</div>
		  
            <br/> 
            <div class="lgD">
            <input type="submit"  value="提交"> 
            </div>
            
        </form>
         
		</div>
</div>
	
<div class="footer" id="foot">
  <div class="copyright">
    <p>Copyright © 2019 吴攀雨版权声明.</p>
  </div>
	
</div>

</body>
</html>