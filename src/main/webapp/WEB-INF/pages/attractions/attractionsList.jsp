<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-Hant ">

<head>
	<meta charset="UTF-8">
	<meta name="description" content="Sona Template">
	<meta name="keywords" content="Sona, unica, creative, html">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Attractions</title>

<!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Lora:400,700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Cabin:400,500,600,700&display=swap" rel="stylesheet">

    <!-- Css Styles -->
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
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="/Team3/css/styleA.css" type="text/css">
</head>
<body>
	<div>
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
				<img src="/Team3/img/flag.jpg" alt=""> <span>EN <i
					class="fa fa-angle-down"></i></span>
				<div class="flag-dropdown">
					<ul>
						<li><a href="#">Zi</a></li>
						<li><a href="#">Fr</a></li>
					</ul>
				</div>
			</div>
			<a href="search.controller" class="bk-btn">Customer Data</a>
		</div>
		<nav class="mainmenu mobile-menu">
			<ul>
				<li><a href="origin.controller">Home</a></li>
				<li><a href="showroom.controller">Rooms</a></li>
				<li><a href="giftDisplay.controller">Gifts</a></li>
				<li><a href="searchattractions">Attractions</a>
					<ul class="dropdown">
						<li>
							<a href="addattractions">add Attractions</a>
						</li>
					</ul>
				</li>
				<li><a href="Homepage">Restaurant</a></li>
				<li><a href="searchorder">Orders</a></li>
			</ul>
		</nav>
		<div id="mobile-menu-wrap"></div>
		<div class="top-social">
			<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
				class="fa fa-twitter"></i></a> <a href="#"><i
				class="fa fa-tripadvisor"></i></a> <a href="#"><i
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
								<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
									class="fa fa-twitter"></i></a> <a href="#"><i
									class="fa fa-tripadvisor"></i></a> <a href="#"><i
									class="fa fa-instagram"></i></a>
							</div>
							 <a href="search.controller" class="bk-btn">Customer Data</a>
							<div class="language-option">
								<img src="<c:url value='/img/flag.jpg'/>" alt="">
								<span>EN <i class="fa fa-angle-down"></i></span>
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
							<a href="origin.controller"> 
								<img src="/Team3/img/logo.png" alt="">
							</a>
						</div>
					</div>
					<div class="col-lg-10">
						<div class="nav-menu">
							<nav class="mainmenu">
							  <ul>
								<li><a href="origin.controller">Home</a></li>
								<li><a href="showroom.controller">Rooms</a></li>
								<li><a href="giftDisplay.controller">Gifts</a></li>
								<li><a href="searchattractions">Attractions</a>
									<ul class="dropdown">
										<li>
											<a href="addattractions">add Attractions</a>
										</li>
									</ul>
								</li>
								<li><a href="Homepage">Restaurant</a></li>
							  </ul>
							</nav>
							<a href="searchorder"><i class="fa-solid fa-cart-shopping" style="color: black"></i></a>
							<div class="nav-right search-switch">
								<i class="icon_search"></i>
							</div>
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
                        <h2>景點管理</h2>
<!--                         <div class="bt-option"> -->
<!--                             <a href="./home.html">Home</a> -->
<!--                             <span>Rooms</span> -->
<!--                         </div> -->
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Section End -->
		<!-- 	body -->
	<div>
		<form method="POST" action="likesearchattractions">
			<div class="row">
			    <div class="mx-auto col-sm-6"  style="display: flex;">
				    <input class="form-control" type="text" name="search"  id="search" placeholder="搜尋" size="20" autofocus autocomplete="off">&nbsp;&nbsp;&nbsp;&nbsp;
				    <button type="submit" class="form-control  col-sm-3">Search</button>
			    </div>
			</div>
		</form>
          </div><br>
	<div>
		<table style="height: 100px;" class="table table-hover table-bordered ">
			<thead class="table-light">
				<tr class="align-middle text-center">
					<th scope="col">項目</th>
					<th scope="col" >景點名稱</th>
					<th scope="col" >地址</th>
					<th scope="col" >時間</th>
					<th scope="col" >介紹</th>
					<th scope="col" >電話</th>
					<th scope="col" >圖片</th>
					<th scope="col" >編輯</th>
					<th scope="col" >刪除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var='bean' items='${aBean}'>
					<tr class="align-middle text-center">
						<th scope="row"><c:out value="${ bean.attractionsId }" /></th>
						<td><c:out value="${ bean.name }"/></td>
						<td><c:out value="${ bean.address }"/></td>
						<td width='150px'><c:out value="${ bean.serviceHour } - ${ bean.serviceHour2 }"/></td>
						<td class="AutoNewline"><c:out value="${ bean.introduction }"/></td>
						<td><c:out value="${ bean.phone }"/></td>
						<td class="align-middle"><img src="file?id=${ bean.attractionsId }" class="img img-fluid img-thumbnail d-block mx-auto"></td>
						<td><form method="GET" action="edit"><button class="form-control" name="id" value="${bean.attractionsId}" type="submit">Edit</button></form></td>
<%-- 						<td><form method="POST" action="javascript:"><button class="delete form-control" name="id" value="${bean.attractionsId}" type="submit">Delete</button></form></td> --%>
						<td><button class="delete form-control" name="id" value="${bean.attractionsId}" type="submit">Delete</button></td>
				</c:forEach>
			</tbody>
		</table><hr>
	</div>
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
	</div>
	<!-- Js Plugins -->
	<script src="/Team3/js/jquery-3.3.1.min.js"></script>
    <script src="/Team3/js/bootstrap.min.js"></script>
    <script src="/Team3/js/jquery.magnific-popup.min.js"></script>
    <script src="/Team3/js/jquery.nice-select.min.js"></script>
    <script src="/Team3/js/jquery-ui.min.js"></script>
    <script src="/Team3/js/jquery.slicknav.js"></script>
    <script src="/Team3/js/owl.carousel.min.js"></script>
    <script src="/Team3/js/main.js"></script>
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script src="/Team3/js/attractions.js"></script>
	<script src="https://kit.fontawesome.com/27e0c99202.js" crossorigin="anonymous"></script>
</body>

</html>