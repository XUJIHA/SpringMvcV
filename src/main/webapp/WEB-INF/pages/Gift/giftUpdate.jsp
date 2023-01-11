<%@page import="hotel.gift.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
               "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/css/update.css' />" rel="stylesheet" type="text/css" />
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
<script type="text/javascript">

function setFocus()
{
     document.getElementById("souvenir_name").focus();
}


$(function(){
    $('.delete').click(function(){
        let id=$(this).attr("value");
        console.log(id)
        Swal.fire({
          title: 'Are you sure?',
          text: "You won't be able to revert this!",
          icon: 'warning',
          showCancelButton: true,
          confirmButtonColor: '#3085d6',
          cancelButtonColor: '#d33',
          confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                  url:'/Team3/deleteGift',
                  method:"post",
                  dataType:"text",
                  data: {"souvenir_id":id},
                })
                    .done(function () {
                        $(location).attr('href', '${pageContext.request.contextPath}/maintainGift.controller')
//                         location.reload();
                        console.log("delete")
                     })//done
                     .fail(function(error) {
                         console.log(error)
                     })//fail end
            }//if
          })//then

      });//click end
      //edit
//       $('.update').click(function(){
//           let id=$(this).attr("value");
//           let name=$("#souvenir_name").val();
//           let no=$("#souvenir_no").val();
//           let price=$("#souvenir_price").val();
//           let des=$("#souvenir_des").val();
//           let num=$("#souvenir_num").val();
//           let pic=$("#souvenir_pic").val();
// //           let filename=$("#FileName").val();
          
//           console.log(id)
//           Swal.fire({
//             title: 'Are you sure?',
//             text: "You won't be able to revert this!",
//             icon: 'warning',
//             showCancelButton: true,
//             confirmButtonColor: '#3085d6',
//             cancelButtonColor: '#d33',
//             confirmButtonText: 'Yes, update it!'
//           }).then((result) => {
//               if (result.isConfirmed) {
//                   $.ajax({
//                     url:'/Team3/updateGift',
//                     method:"post",
//                     dataType:"text",
//                     data: {"souvenir_id":id},"souvenir_no":no,"souvenir_name":name,"souvenir_price":price,
//                     "souvenir_des":des,"souvenir_num":num,"souvenir_pic":pic
//                   })
//                       .done(function () {
//                           $(location).attr('href', '"gift/giftMaintain')
//                           console.log("update")
//                        })//done
//                        .fail(function(error) {
//                            console.log(error)
//                        })//fail end
//               }//if
//             })//then

//         })//click end
     
});
        //function end
// function updateSouvenir() {
// 	    document.forms[0].action="/updateGift" ;
// 		document.forms[0].method="POST";
// 		document.forms[0].submit();

// }
   

</script>

</head>
<div id='main'>
<center>
<%-- <c:choose> --%>
<%--    <c:when test="${not empty param.souvenir_id }"> --%>
<%--      <c:set var="souvenir_name" value='${bean.souvenir_name}' /> --%>
<%--      <c:set var="souvenir_no" value='${bean.souvenir_no}' /> --%>
<%--      <c:set var="souvenir_price" value='${bean.souvenir_price}' /> --%>
<%--      <c:set var="souvenir_des" value='${bean.souvenir_des}' /> --%>
<%--      <c:set var="souvenir_num" value='${bean.souvenir_num}' /> --%>
<%--    </c:when> --%>
<%--    <c:otherwise> --%>
<!--      <c:out value="第二次"/> --> 
<%--      <c:set var="souvenir_name" value='${bean.souvenir_name}' /> --%>
<%--      <c:set var="souvenir_no" value='${bean.souvenir_no}' /> --%>
<%--      <c:set var="souvenir_price" value='${bean.souvenir_price}' /> --%>
<%--      <c:set var="souvenir_des" value='${bean.souvenir_des}' /> --%>
<%--      <c:set var="souvenir_num" value='${bean.souvenir_num}' /> --%>
<%--    </c:otherwise> --%>
<%-- </c:choose> --%>
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

<div id="backToMaintainList">
     <a href="/maintainGift.controller">回維護首頁</a>    
</div>     
 

 <div class="right">
<!--  <form action="/updateGift" method="POST" enctype="multipart/form-data"> -->
 <form action="<c:url value='/updateGift/${bean.souvenir_id}'/>" method="post" enctype="multipart/form-data">
      <div class="log">
          <div class="logo">更新伴手禮資料<br><br></div>
          <div class="block">
               <div class="lw">名字&emsp;
              <input type="text" class="inputbox" name="souvenir_name"id="souvenir_name"value="${bean.souvenir_name}"  ><br>
              <font color='red' size='-1'>
              ${ErrMsg.errsouvenir_name}
           </font>
        </div> 
                <div class="lw">編號&emsp;
              <input type="text" class="inputbox" name="souvenir_no" id="souvenir_no" 
              value="${bean.souvenir_no}"><br>
              <font color='red' size='-1'>
              ${ErrMsg.errSouvenir_no}
           </font>
        </div> 
			 <div class="lw">介紹&emsp;
			  <textarea class="te" name="souvenir_des"  type="text" id="souvenir_des" 
              >${bean.souvenir_des}
                </textarea>
           <font color='red' size='-1'>
              ${ErrMsg.errSouvenir_des}
           </font>
             
        </div> 
             <div class="block">
               <div class="lw">價錢&emsp;
              <input type="text" class="inputbox" name="souvenir_price"  id="souvenir_price" 
              value="${bean.souvenir_price}"><br>
              <font color='red' size='-1'>
              ${ErrMsg.errSouvenir_price}
           </font>
        </div> 
                 <div class="block">
               <div class="lw">數量&emsp;
              <input class="inputbox"  name="souvenir_num"  type="text" id="souvenir_num" 
              value="${bean.souvenir_num}"><br>
              <font color='red' size='-1'>
              ${ErrMsg.errSouvenir_num}
           </font>
        </div> 
          </div>
      </div>
      <tr height='36' class="title_font">
        <td width="45">圖片</td>
        <td colspan="1">
            <tr>
             <td><img style="height:80px; width:80px; border-radius:30px;"
                     src="${pageContext.request.contextPath}/getSouImage/${bean.souvenir_id}"  />
             </td>
             <td colspan='2'>
                 <input style="background:#FFFFFF" class='InputClass'  type="file" 
                      name="souvenir_pic" size="40" />
                 <font color='red' size='-1'>
                    ${ErrMsg.errSouvenir_pic} 
                 </font>
             </td>
           </tr>
           </td>
         <input  type="submit" value="儲存">
<!--         	</div><br> -->
        </form>
</div>

<tr height='35'>
 
<td colspan='6' align='center'>
        <input name="souvenir_id" type="hidden" id="souvenir_id" value ="${bean.souvenir_id}>" />        
<!--        <input type="button"  class="login"name="update" value="修改" onclick='updateSouvenir()'/> -->
<%-- 			<form action="../updateGift/${bean.souvenir_id}?bea" ><input type="submit" class="login" value="修改"></form> --%>
<%--         <a onclick="return up(this)" href="${pageContext.request.contextPath}/updateGift/${bean.souvenir_id}">修改</a> --%>
     	<td>
<%--      	<a href="${updateLink}">Update</a> --%>
        &nbsp;&nbsp;&nbsp;
        
       <button type="button" class="delete login" name="souvenir_id" value="${bean.souvenir_id}" type="submit">刪除</button>

  </td>
  </td>
  </tr>
</table>
</div>
</div>
</form>
<p>&nbsp;</p>
</center>
</div>
</body>
</html>