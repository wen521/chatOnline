<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="content-type" content="text/html; charset=gb2312">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
 <style type="text/css">
        *
        {
            margin: 0;
            padding: 0;
        }
        body
        {
            font-size: 15px;
            padding: 00px;
        }
        .menu
        {
            width: 500px;
            border-bottom: solid 1px gray;
        }
        .menu h3
        {
            border: solid 1px gray;
            height: 30px;
            line-height: 30px;
            padding-left: 10px;
            padding:0 5px;
            border-bottom: none;
            cursor: pointer;
           
        }
        .menu p
        {
            border-left: solid 1px gray;
            border-right: solid 1px gray;
            padding: 20px 0;
            padding-left: 5px;
        }
        .changecolor{background-color:red;}
    </style>
    <script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script type="text/javascript">
          $(function () {
            $(".menu p:not(:first)").hide();
            $(".menu h3").css("background", "#ccc");       
            $(".menu h3").hover(function () { $(this).css("background-color", "gray").siblings("h3").css
("background-color", "#ccc");});
            $(".menu h3").mouseleave(function () { 
               $(".menu h3").css("background", "#ccc");}); //离开时将其变为原来颜色
            var index = $(".menu h3").index(this);
            $(".menu h3").click(function () { $(this).next("p").slideToggle().siblings("p").slideUp(); });
        });
    </script>
  </head>
  
  <body>
    <div class="menu">
        <h3>
            社区分类</h3>
        <p>
   <a href="http://game.qq.com/">游戏社区</a><br/><br/>
   <a href="https://www.liba.com/">生活社区</a><br/><br/>
   <a href="http://www.mtime.com/community/">电影社区</a><br/><br/>
   <a href="http://www.china.com/">时事社区</a><br/><br/>
            </p>
	         <h3>
	            我的好友</h3>
	        <p>
	   <a href="https://baike.baidu.com/item/%E6%9D%8E%E8%BF%9E%E6%9D%B0/202569?fr=aladdin">李连杰</a><br/><br/>
	   <a href="https://baike.baidu.com/item/%E5%91%A8%E6%98%9F%E9%A9%B0/169917?fr=aladdin">周星驰</a><br/><br/>
	   <a href="https://baike.baidu.com/item/%E5%91%A8%E6%9D%B0%E4%BC%A6/129156?fr=aladdin">周杰伦</a><br/><br/>
	   <a href="https://baike.baidu.com/item/%E6%88%90%E9%BE%99/71648?fr=aladdin">成龙</a><br/><br/>
	   <a href="https://baike.baidu.com/item/%E6%9D%8E%E5%86%B0%E5%86%B0/347875?fr=aladdin">李冰冰</a><br/><br/>
	   <a href="https://baike.baidu.com/item/%E6%9D%8E%E5%B0%8F%E9%BE%99/32914?fr=aladdin">李小龙</a><br/>
	         </p>
	        <h3>
    </div>
  </body>
</html>