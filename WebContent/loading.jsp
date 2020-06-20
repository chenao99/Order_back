<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>loading</title>

	<span style="font-size:18px;"> 
	</span>
	<span style="font-size:24px;">
	<meta http-equiv="refresh" content="3;URL=main.jsp"> 
	</span> 

</head>

<style>
	@-moz-keyframes loader {
	    0%, 10%, 100% {
	        width: 80px;
	        height: 80px;
	    }
	    65% {
	        width: 150px;
	        height: 150px;
	    }
	}
	@-webkit-keyframes loader {
	    0%, 10%, 100% {
	        width: 80px;
	        height: 80px;
	    }
	    65% {
	        width: 150px;
	        height: 150px;
	    }
	}
	@keyframes loader {
	    0%, 10%, 100% {
	        width: 80px;
	        height: 80px;
	    }
	    65% {
	        width: 150px;
	        height: 150px;
	    }
	}
	@-moz-keyframes loaderBlock {
	    0%, 30% {
	        -moz-transform: rotate(0);
	        transform: rotate(0);
	    }
	    55% {
	        background-color: #f37272;
	    }
	    100% {
	        -moz-transform: rotate(90deg);
	        transform: rotate(90deg);
	    }
	}
	@-webkit-keyframes loaderBlock {
	    0%, 30% {
	        -webkit-transform: rotate(0);
	        transform: rotate(0);
	    }
	    55% {
	        background-color: #f37272;
	    }
	    100% {
	        -webkit-transform: rotate(90deg);
	        transform: rotate(90deg);
	    }
	}
	@keyframes loaderBlock {
	    0%, 30% {
	        -moz-transform: rotate(0);
	        -ms-transform: rotate(0);
	        -webkit-transform: rotate(0);
	        transform: rotate(0);
	    }
	    55% {
	        background-color: #f37272;
	    }
	    100% {
	        -moz-transform: rotate(90deg);
	        -ms-transform: rotate(90deg);
	        -webkit-transform: rotate(90deg);
	        transform: rotate(90deg);
	    }
	}
	@-moz-keyframes loaderBlockInverse {
	    0%, 20% {
	        -moz-transform: rotate(0);
	        transform: rotate(0);
	    }
	    55% {
	        background-color: #f37272;
	    }
	    100% {
	        -moz-transform: rotate(-90deg);
	        transform: rotate(-90deg);
	    }
	}
	@-webkit-keyframes loaderBlockInverse {
	    0%, 20% {
	        -webkit-transform: rotate(0);
	        transform: rotate(0);
	    }
	    55% {
	        background-color: #f37272;
	    }
	    100% {
	        -webkit-transform: rotate(-90deg);
	        transform: rotate(-90deg);
	    }
	}
	@keyframes loaderBlockInverse {
	    0%, 20% {
	        -moz-transform: rotate(0);
	        -ms-transform: rotate(0);
	        -webkit-transform: rotate(0);
	        transform: rotate(0);
	    }
	    55% {
	        background-color: #f37272;
	    }
	    100% {
	        -moz-transform: rotate(-90deg);
	        -ms-transform: rotate(-90deg);
	        -webkit-transform: rotate(-90deg);
	        transform: rotate(-90deg);
	    }
	}
	.loader {
	    position: absolute;
	    top: 50%;
	    left: 50%;
	    width: 80px;
	    height: 80px;
	    -moz-transform: translate(-50%, -50%) rotate(45deg) translate3d(0, 0, 0);
	    -ms-transform: translate(-50%, -50%) rotate(45deg) translate3d(0, 0, 0);
	    -webkit-transform: translate(-50%, -50%) rotate(45deg) translate3d(0, 0, 0);
	    transform: translate(-50%, -50%) rotate(45deg) translate3d(0, 0, 0);
	    -moz-animation: loader 1.2s infinite ease-in-out;
	    -webkit-animation: loader 1.2s infinite ease-in-out;
	    animation: loader 1.2s infinite ease-in-out;
	}
	.loader span {
	    position: absolute;
	    display: block;
	    width: 40px;
	    height: 40px;
	    background-color: #ee4040;
	    -moz-animation: loaderBlock 1.2s infinite ease-in-out both;
	    -webkit-animation: loaderBlock 1.2s infinite ease-in-out both;
	    animation: loaderBlock 1.2s infinite ease-in-out both;
	}
	.loader span:nth-child(1) {
	    top: 0;
	    left: 0;
	}
	.loader span:nth-child(2) {
	    top: 0;
	    right: 0;
	    -moz-animation: loaderBlockInverse 1.2s infinite ease-in-out both;
	    -webkit-animation: loaderBlockInverse 1.2s infinite ease-in-out both;
	    animation: loaderBlockInverse 1.2s infinite ease-in-out both;
	}
	.loader span:nth-child(3) {
	    bottom: 0;
	    left: 0;
	    -moz-animation: loaderBlockInverse 1.2s infinite ease-in-out both;
	    -webkit-animation: loaderBlockInverse 1.2s infinite ease-in-out both;
	    animation: loaderBlockInverse 1.2s infinite ease-in-out both;
	}
	.loader span:nth-child(4) {
	    bottom: 0;
	    right: 0;
	}
	body {
	    background-color: #584e4a;
	}
</style>

<body>

	<div class="loader">
	    <span></span>
	    <span></span>
	    <span></span>
	    <span></span>
	</div>


</body>
</html>