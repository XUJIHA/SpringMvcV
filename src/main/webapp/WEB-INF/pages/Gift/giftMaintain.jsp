<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value='/css/maintain.css' />" rel="stylesheet" type="text/css" />
<title>Gift Maintain</title>
</head>
<body>
<!-- 下列敘述設定變數funcName的值為BMT，top.jsp 會用到此變數 -->
<c:set var="funcName" value="BMT" scope="session" />

<div id='main' align='center'>
 <font color='red' size='-1'>${successMsg.success}${SouDeleteMsg}</font><br/>
     <c:remove var="successMsg" scope='session'/>
     <c:remove var="SouDeleteMsg" />
<div class="card">
  <div class="left">
	<div id="container">

        <button class="learn-more">
            <span class="circle" aria-hidden="true">
                <span class="icon arrow"></span>
            </span>
            <span class="button-text">
            	<a href="<c:url value='/maintainGift.controller' />">
                    維護 </a>
            </span>
        </button><br><br>
        <button class="learn-more">
            <span class="circle" aria-hidden="true">
                <span class="icon arrow"></span>
            </span>
            <span class="button-text">
            
            	<a href="<c:url value='/giftpreinsert.controller' />">
                    新增 </a>
            </span>
        </button><br><br>
         <button class="learn-more">
            <span class="circle" aria-hidden="true">
                <span class="icon arrow"></span>
            </span>
            <span class="button-text">
            
            	<a href="<c:url value='/giftDisplay.controller' />">
                    商品頁面 </a>
            </span>
        </button>
    </div>
  </div>
<div class="right">

<table id="insert">
	<!--   購物車的標題   -->
	<TR>
		<TD colspan='3'>
		<TABLE width="680" >
			<TR height='5'>
				<TD align='center'>&nbsp;</TD>
			</TR>
			<TR height='30'>
				<TD align='center'><FONT color='#8000FA' size='+2'
					style="font-weight: 900;"> 伴手禮資料維護</FONT></TD>
			</TR>
			<TR height='5'>
				<TD align='center'>
				
				</TD>
			</TR>
		</TABLE>
		</TD>
	</TR>
	
		<c:forEach varStatus="stVar" var="bean" items="${beans}">
		<!-- 用兩種顏色交替使用作為顯示商品資料的背景底色 -->
		 <c:set var="rowColor" value="#EEF2F5" />
      <c:if test="${ stVar.count % 2 == 0 }">
         <c:set var="rowColor" value="#FCF9DA" />
      </c:if>

		<tr height='18' >
			<td width='600' colspan='2' align='left'>
			<table width='600'>
				<tr bgColor="${rowColor}" class="souname">
					<TD   class="name">伴手禮名：<a
						href="giftPreupdate.controller/${bean.souvenir_id}">${bean.souvenir_name}</a>
					</TD>
<!-- 					<TD   class="name">伴手禮名： -->
<%-- 						<form class="form123" action="<c:url value='/giftPreupdate.controller' />" method="post" > --%>
<%-- 							<input type="hidden" name="SOUID" value="${bean.souvenir_id}"> --%>
<%-- 								<a href="#" class="name123">${bean.souvenir_name}</a> --%>
<!-- 						</form> -->
<!-- 					</TD> -->
				</tr>
			</table>
			</td>
			<td rowspan='3' width='80'><!-- 
                 getImage所對應的Servlet會到資料庫讀取圖片並傳送給前端的瀏覽器
              --> <img style="height:80px; width:80px; border-radius:30px;"
				src="getSouImage/${bean.souvenir_id}"></td>
		</tr>
		
<!-- 		  以上為書名資料   -->
		<TR height='18' ">
			<TD width='600' align='left'>
			<TABLE width='600'>
				<TR>
					<TD width='400' align="left" >編號：${bean.souvenir_no}</TD>
<!-- 					<TD width='200' align="left"> -->
<%-- 					介紹：${entry.value.souvenir_des}</TD> --%>
				</TR>
				<TR>
<%-- 					<TD width='400' align="left">編號：${entry.value.souvenir_no}</TD> --%>
					<TD width='200' align="left">
					介紹：${bean.souvenir_des}</TD>
				</TR>
			</TABLE>
			</TD>
		</TR>
		<!--   以上為作者、出版社資料   -->
		<TR >
			<TD width='600' align='left'>
			<TABLE  width='600'>
				<TR>
					<TD width='140' align="left">訂價：<fmt:formatNumber
						value="${bean.souvenir_price}" pattern="####" />元</TD>
					
					<TD width='140' align="left">
					數量：${bean.souvenir_num}</TD>
				</TR>
			</TABLE>
			</TD>
		</tr>
		<!--   以上為書號、訂價、實售資料   -->
	</c:forEach>
</TABLE>
</div>
</div>
</div>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<!-- <script> -->
<!-- // $(".name123").on("click",function(){ -->
<!-- // // 	console.log() -->
<!-- //    $(this).parent('.form123').submit(); -->
<!-- // }); -->
<!-- </script> -->

</body>
</html>
