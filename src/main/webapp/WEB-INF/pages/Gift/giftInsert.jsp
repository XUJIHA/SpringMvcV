<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value='/css/Left.css' />" rel="stylesheet"
  type="text/css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${AppName}</title>
  
<link href="<c:url value='/css/Insert.css' />" rel="stylesheet" type="text/css" />

<script type="text/javascript">
function setFocus(fld) {
     document.getElementById(fld).focus();
}

</script>

</head>
<div id='main' align='center'>
<form  id="form1" name="form1" method="post" 
       action="giftInsert.controller"  enctype="multipart/form-data" >
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
        </button>
    </div>
  </div>
  <div class="right">
      <div class="log">
          <div class="logo">新增商品<br><br></div>
          <div class="block">
               <div class="lw">名字&emsp;
              <input type="text" class="inputbox" name="souvenir_name"id="souvenir_name"value="${requestScope.souvenir_name}"  ><br>
              <font color='red' size='-1'>
              ${ErrMsg.errsouvenir_name}
           </font>
        </div> 
                <div class="lw">編號&emsp;
              <input type="text" class="inputbox" name="souvenir_no" id="souvenir_no" 
              value="${requestScope.souvenir_no}"><br>
              <font color='red' size='-1'>
              ${ErrMsg.errSouvenir_no}
              
           </font>
        </div> 
			 <div class="lw">介紹&emsp;
			  <textarea class="te" name="souvenir_des"  type="text" id="souvenir_des" 
              value="${requestScope.souvenir_des}">
                </textarea>
           <font color='red' size='-1'>
              ${ErrMsg.errSouvenir_des}
           </font>
             
        </div> 
             <div class="block">
               <div class="lw">價錢&emsp;
              <input type="text" class="inputbox" name="souvenir_price"  id="souvenir_price" 
              value="${requestScope.souvenir_price}"><br>
              <font color='red' size='-1'>
              ${ErrMsg.errSouvenir_price}
           </font>
        </div> 
                 <div class="block">
               <div class="lw">數量&emsp;
              <input class="inputbox"  name="souvenir_num"  type="text" id="souvenir_num" 
              value="${requestScope.souvenir_num}"><br>
              <font color='red' size='-1'>
              ${ErrMsg.errSouvenir_num}
           </font>
        </div> 
          </div>
      </div>
      <tr height='36' class="title_font">
        <td width="45">圖片</td>
        <td colspan="1">
            <input style="background:#FFFFFF" class='InputClass'  type="file"
            name="souvenir_pic" size="40" /><br>
            <font color='red' size='-1'>${ErrMsg.errSouvenir_pic}</font></td>
<%--              value="${requestScope.souvenir_pic}" --%>
    </tr>
    <input type="submit" name="Submit" class="insert login" value="新增">
</div>
</form>
</div>
<p>&nbsp;</p>
<c:remove var="ErrMsg" scope='session'/>
</body>
</html>