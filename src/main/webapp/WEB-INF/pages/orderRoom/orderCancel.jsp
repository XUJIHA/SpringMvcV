<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  --%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Sona Template">
<meta name="keywords" content="Sona, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sona | 取消訂單</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css?family=Lora:400,700&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Cabin:400,500,600,700&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<!-- 絕對路徑 -->
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>">
<!-- 絕對路徑 -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="css/flaticon.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="css/nice-select.css" type="text/css">
<link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">
<!-- Js Plugins -->
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/jquery.slicknav.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/main.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="https://kit.fontawesome.com/27e0c99202.js"
	crossorigin="anonymous"></script>
</head>
<body>

	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Offcanvas Menu Section Begin -->
	<div class="offcanvas-menu-overlay"></div>
	<div class="canvas-open">
		<i class="icon_menu"></i>
	</div>
	<div class="offcanvas-menu-wrapper">
		<div class="canvas-close">
			<i class="icon_close"></i>
		</div>
		<div class="search-icon  search-switch">
			<i class="icon_search"></i>
		</div>
		<div class="header-configure-area">
			<div class="language-option">
				<img src="img/flag.jpg" alt=""> <span>EN <i
					class="fa fa-angle-down"></i></span>
				<div class="flag-dropdown">
					<ul>
						<li><a href="#">Zi</a></li>
						<li><a href="#">Fr</a></li>
					</ul>
				</div>
			</div>
			<a href="<c:url value='search.controller'/>" class="bk-btn">Customer
				Data</a>
		</div>
		<nav class="mainmenu mobile-menu">
			<ul>
				<li><a href="origin.controller">Home</a></li>
				<li><a href="showroom.controller">Rooms</a></li>
				<li><a href="<c:url value='/giftDisplay.controller'/>">Gifts</a></li>
				<li><a href="searchattractions">Attractions</a>
					<ul class="dropdown">
						<li><a href="addattractions">add Attractions</a></li>
					</ul></li>
				<li><a href="<c:url value='Homepage'/>">Restaurant</a></li>
				<li><a href="searchorder">Orders</a></li>
			</ul>
		</nav>
		<div id="mobile-menu-wrap"></div>
		<div class="top-social">
			<a><i class="fa fa-facebook"></i></a> <a><i class="fa fa-twitter"></i></a>
			<a><i class="fa fa-tripadvisor"></i></a> <a><i
				class="fa fa-instagram"></i></a>
		</div>
		<ul class="top-widget">
			<li><i class="fa fa-phone"></i> (12) 345 67890</li>
			<li><i class="fa fa-envelope"></i> info.colorlib@gmail.com</li>
		</ul>
	</div>
	<!-- Offcanvas Menu Section End -->

	<!-- Header Section Begin -->
	<header class="header-section">
		<div class="top-nav">
			<div class="container">
				<div class="row">
					<div class="col-lg-6">
						<ul class="tn-left">
							<li><i class="fa fa-phone"></i> (12) 345 67890</li>
							<li><i class="fa fa-envelope"></i> info.colorlib@gmail.com</li>
						</ul>
					</div>
					<div class="col-lg-6">
						<div class="tn-right">

							<div class="top-social">
								<a><i class="fa fa-facebook"></i></a> <a><i
									class="fa fa-twitter"></i></a> <a><i class="fa fa-tripadvisor"></i></a>
								<a><i class="fa fa-instagram"></i></a>
							</div>
							<a href="<c:url value='search.controller'/>" class="bk-btn">Customer
								Data</a>
							<div class="language-option">
								<img src="img/flag.jpg" alt=""> <span>EN <i
									class="fa fa-angle-down"></i></span>
								<div class="flag-dropdown">
									<ul>
										<li><a href="#">Zi</a></li>
										<li><a href="#">Fr</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="menu-item">
			<div class="container">
				<div class="row">
					<div class="col-lg-2">
						<div class="logo">
							<a href="origin.controller"> <img src="../img/logo.png"
								alt="">
							</a>
						</div>
					</div>
					<div class="col-lg-10">
						<div class="nav-menu">
							<nav class="mainmenu">
								<ul>
									<li><a href="origin.controller">Home</a></li>
									<li><a href="showroom.controller">Rooms</a></li>
									<li><a href="<c:url value='/giftDisplay.controller'/>">Gifts</a></li>
									<li><a href="searchattractions">Attractions</a>
										<ul class="dropdown">
											<li><a href="addattractions">add Attractions</a></li>
										</ul></li>
									<li><a href="<c:url value='Homepage'/>">Restaurant</a></li>
								</ul>
							</nav>
							<a href="searchorder"><i class="fa-solid fa-cart-shopping"
								style="color: #dfa974"></i></a>
							<div class="nav-right search-switch">
								<i class="icon_search"></i>
							</div>
							<div>
								<form method="post" action="logout.controller">
									<button name="userno">Logout</button>
								</form>
							</div>
							<br>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- Header End -->

	<!-- Breadcrumb Section Begin -->
	<div class="breadcrumb-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="breadcrumb-text">
						<h2>訂單管理</h2>
						<div class="bt-option">
							<a href="searchorder">訂單管理&nbsp;</a><span>取消訂單</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Breadcrumb Section End -->
	<section class="blog-details-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-10 offset-lg-1">
					<div class="blog-details-text">
						<div class="leave-comment">

							<h3 style="margin: 10px 0 !important; padding: 5px 0 5px 5px;">聯絡資料</h3>
							<br>
							<form action="cancelorder" method="POST" class="comment-form">
								<div class="row">

									<input type="hidden" name="orderid" id="orderid"
										value="${orderbean.orderid}">


									<div class="col-lg-6">
										房型:<input readonly type="text" name="roomname"
											value="${orderbean.roomname}">

									</div>
									<div class="col-lg-6">
										金額:<input readonly type="text" name="roomprice"
											value="${orderbean.roomprice}">

									</div>
									<div class="col-lg-6">
										入住日期:<input readonly type="date" name="checkindate"
											value="${orderbean.checkindate}">
									</div>
									<div class="col-lg-6">
										退房日期:<input readonly type="date" name="checkoutdate"
											value="${orderbean.checkoutdate}">
									</div>


									<div class="col-lg-6">
										姓名:<input readonly type="text" name="username"
											value="${orderbean.username}">

									</div>
									<div class="col-lg-6">
										信箱:<input readonly type="text" name="useremail"
											value="${orderdetailsbean.useremail}">
									</div>
									<div class="col-lg-6">
										電話:<input readonly type="text" name="userphone"
											value="${orderdetailsbean.userphone}">
									</div>
									<div class="col-lg-6">
										統一編號:<input readonly type="text" name="company"
											value="${orderdetailsbean.company}">
									</div>
									<div class="col-lg-6">
										大人:<input readonly type="number" name="adults"
											value="${orderdetailsbean.adults}">
									</div>
									<div class="col-lg-6">
										小孩:<input readonly type="number" name="children"
											value="${orderdetailsbean.children}">
									</div>
									<div class="col-lg-12 ">
										備註事項:
										<textarea readonly name="notes">${orderdetailsbean.notes}</textarea>
									</div>
									<div class="col-lg-12 text-center">
										<button style="margin: 20px 20px" type="button" class="cancel"
											value="${orderbean.orderid}">取消</button>
									</div>
								</div>
							</form>
							<br> <br>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Blog Details Section End -->



	<!-- Footer Section Begin -->
	<footer class="footer-section">
		<div class="container">
			<div class="footer-text">
				<div class="row">
					<div class="col-lg-4">
						<div class="ft-about">
							<div class="logo">
								<a href="#"> <img src="img/footer-logo.png" alt="">
								</a>
							</div>
							<p>
								We inspire and reach millions of travelers<br /> across 90
								local websites
							</p>
							<div class="fa-social">
								<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
									class="fa fa-twitter"></i></a> <a href="#"><i
									class="fa fa-tripadvisor"></i></a> <a href="#"><i
									class="fa fa-instagram"></i></a> <a href="#"><i
									class="fa fa-youtube-play"></i></a>
							</div>
						</div>
					</div>
					<div class="col-lg-3 offset-lg-1">
						<div class="ft-contact">
							<h6>Contact Us</h6>
							<ul>
								<li>(12) 345 67890</li>
								<li>info.colorlib@gmail.com</li>
								<li>856 Cordia Extension Apt. 356, Lake, United State</li>
							</ul>
						</div>
					</div>
					<div class="col-lg-3 offset-lg-1">
						<div class="ft-newslatter">
							<h6>New latest</h6>
							<p>Get the latest updates and offers.</p>
							<form action="#" class="fn-form">
								<input type="text" placeholder="Email">
								<button type="submit">
									<i class="fa fa-send"></i>
								</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="copyright-option">
			<div class="container">
				<div class="row">
					<div class="col-lg-7">
						<ul>
							<li><a href="#">Contact</a></li>
							<li><a href="#">Terms of use</a></li>
							<li><a href="#">Privacy</a></li>
							<li><a href="#">Environmental Policy</a></li>
						</ul>
					</div>
					<div class="col-lg-5">
						<div class="co-text">
							<p>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								Copyright &copy;
								<script>
									document.write(new Date().getFullYear());
								</script>
								All rights reserved | This template is made with <i
									class="fa fa-heart" aria-hidden="true"></i> by <a
									href="https://colorlib.com" target="_blank">Colorlib</a>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- Footer Section End -->

	<!-- Search model Begin -->
	<div class="search-model">
		<div class="h-100 d-flex align-items-center justify-content-center">
			<div class="search-close-switch">
				<i class="icon_close"></i>
			</div>
			<form class="search-model-form">
				<input type="text" id="search-input" placeholder="Search here.....">
			</form>
		</div>
	</div>
	<!-- Search model end -->
	<script>	
	$(function(){
        $('.cancel').click(function(){
            let orderid=$(this).attr("value");
          /*   let roomname=$("#roomname").val();
            let roomprice=$("#roomprice").val();
            let checkindate=$("#checkindate").val();
            let checkoutdate=$("#checkoutdate").val();
            let username=$("#username").val();
            let useremail=$("#useremail").val();
            let userphone=$("#userphone").val();
            let company=$("#company").val();
            let adults=$("#adults").val();
            let children=$("#children").val();
            let notes=$("#notes").val();
             */
            Swal.fire({
              title: '確定取消此訂單?',
              icon: 'warning',
              showCancelButton: true,
              confirmButtonColor: 'red',
              cancelButtonColor: 'gray',
              confirmButtonText: '確定',
              cancelButtonText:'取消'
            }).then((result) => {
                if (result.isConfirmed) {
                    $.ajax({
                      url:'/Team3/cancelorder',
                      method:"post",
                      dataType:"text",
                      data: {"orderid":orderid,},
                    })
                    	.done(function () {
                    		$(location).attr('href', 'cancelsuccess');
                        	console.log("cancel")
             			})//done
             			.fail(function(error) {
             			    console.log(error)
             			})//fail end 
                }//if
              })//then

          })//click end
	});
	//function end
</script>
	<!-- Js Plugins -->
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<script src="js/jquery.slicknav.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/main.js"></script>

</body>

</html>