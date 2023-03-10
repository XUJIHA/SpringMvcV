<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Sona Template">
    <meta name="keywords" content="Sona, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sona | Template</title>

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
        <div class="search-icon search-switch">
            <i class="icon_search"></i>
        </div>
        <div class="header-configure-area">
            <div class="language-option">
                <img src="img/flag.jpg" alt="">
                <span>EN <i class="fa fa-angle-down"></i></span>
                <div class="flag-dropdown">
                    <ul>
                        <li><a href="#">Zi</a></li>
                        <li><a href="#">Fr</a></li>
                    </ul>
                </div>
            </div>
           <a href="<c:url value='search.controller' />" class="bk-btn">Customer Data</a>
        </div>
        <nav class="mainmenu mobile-menu">
			<ul>
				<li><a href="origin.controller">Home</a></li>
				<li><a href="showroom.controller">Rooms</a></li>
				<li><a href="<c:url value='/giftDisplay.controller'/>">Gifts</a></li>
				<li><a href="searchattractions">Attractions</a>
					<ul class="dropdown">
						<li>
							<a href="addattractions">add Attractions</a>
						</li>
					</ul>
				</li>
				<li><a href="<c:url value='Homepage'/>">Restaurant</a></li>
				<li><a href="searchorder">Orders</a></li>
			</ul>
		</nav>
        <div id="mobile-menu-wrap"></div>
        <div class="top-social">
            <a href="#"><i class="fa fa-facebook"></i></a>
            <a href="#"><i class="fa fa-twitter"></i></a>
            <a href="#"><i class="fa fa-tripadvisor"></i></a>
            <a href="#"><i class="fa fa-instagram"></i></a>
        </div>
        <ul class="top-widget">
            <li><i class="fa fa-phone"></i> (12) 345 67890</li>
            <li><i class="fa fa-envelope"></i> info.colorlib@gmail.com</li>
        </ul>
    </div>
    <!-- Offcanvas Menu Section End -->

    <!-- Header Section Begin -->
    <header class="header-section header-normal">
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
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-tripadvisor"></i></a>
                                <a href="#"><i class="fa fa-instagram"></i></a>
                            </div>
                            <a href="<c:url value='search.controller' />" class="bk-btn">Customer Data</a>
                            <div class="language-option">
                                <img src="img/flag.jpg" alt="">
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
                           <a href="origin.controller"> <img src="./img/logo.png" alt=""></a>
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
									        <li>
									            <a href="addattractions">add Attractions</a>
									        </li>
									    </ul>
									</li>
									<li><a href="<c:url value='Homepage'/>">Restaurant</a></li>
								</ul>
							</nav>
							<a href="searchorder"><i class="fa-solid fa-cart-shopping"
                                style="color: black"></i></a>
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
                        <div class="bt-option">
                            <a href="<c:url value='/ShowAllServlet' />" style="color: darkgray"><b>??????????????????</b></a>
                            <span>Rooms</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Section End -->

    <!-- Room Details Section Begin -->
    <section class="room-details-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="room-details-item">
                        <img src="<c:url value='/ShowImgServlet?roomId=${bean.roomId}' />" width="860" height="500" alt="">
                        <div class="rd-text">
                            <div class="rd-title">
                                <h3>${bean.name}</h3>
                                <div class="rdt-right">
                                    <div class="rating">
                                        <i class="icon_star"></i>
                                        <i class="icon_star"></i>
                                        <i class="icon_star"></i>
                                        <i class="icon_star"></i>
                                        <i class="icon_star-half_alt"></i>
                                    </div>
                                    <form action="checkroom" method="post">
                                    <input type="hidden" name="roomId" value="${bean.roomId}">
                                    <input type="submit" value="????????????" style="font-size:20px">
                                    </form>
                                </div>
                            </div>
                            <h2>$${bean.price}<span>/??????</span></h2>
                            <table>
                                <tbody>
                                    <tr>
                                        <td class="r-o">??????:</td>
                                        <td>${bean.size} ???</td>
                                    </tr>
                                    <tr>
                                        <td class="r-o">??????:</td>
                                        <td>?????? ${bean.capacity} ???</td>
                                    </tr>
                                    <tr>
                                        <td class="r-o">??????:</td>
                                        <td>${bean.bed} ??????</td>
                                    </tr>
                                    <tr>
                                        <td class="r-o">??????:</td>
                                        <td>${bean.equipment}</td>
                                    </tr>
                                </tbody>
                            </table>
                            <p class="f-para">??????:???${bean.description}</p>
                            
                        </div>
                    </div>
<!--                     <div class="rd-reviews"> -->
<!--                         <h4>Reviews</h4> -->
<!--                         <div class="review-item"> -->
<!--                             <div class="ri-pic"> -->
<!--                                 <img src="img/room/avatar/avatar-1.jpg" alt=""> -->
<!--                             </div> -->
<!--                             <div class="ri-text"> -->
<!--                                 <span>27 Aug 2019</span> -->
<!--                                 <div class="rating"> -->
<!--                                     <i class="icon_star"></i> -->
<!--                                     <i class="icon_star"></i> -->
<!--                                     <i class="icon_star"></i> -->
<!--                                     <i class="icon_star"></i> -->
<!--                                     <i class="icon_star-half_alt"></i> -->
<!--                                 </div> -->
<!--                                 <h5>Brandon Kelley</h5> -->
<!--                                 <p>Neque porro qui squam est, qui dolorem ipsum quia dolor sit amet, consectetur, -->
<!--                                     adipisci velit, sed quia non numquam eius modi tempora. incidunt ut labore et dolore -->
<!--                                     magnam.</p> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                         <div class="review-item"> -->
<!--                             <div class="ri-pic"> -->
<!--                                 <img src="img/room/avatar/avatar-2.jpg" alt=""> -->
<!--                             </div> -->
<!--                             <div class="ri-text"> -->
<!--                                 <span>27 Aug 2019</span> -->
<!--                                 <div class="rating"> -->
<!--                                     <i class="icon_star"></i> -->
<!--                                     <i class="icon_star"></i> -->
<!--                                     <i class="icon_star"></i> -->
<!--                                     <i class="icon_star"></i> -->
<!--                                     <i class="icon_star-half_alt"></i> -->
<!--                                 </div> -->
<!--                                 <h5>Brandon Kelley</h5> -->
<!--                                 <p>Neque porro qui squam est, qui dolorem ipsum quia dolor sit amet, consectetur, -->
<!--                                     adipisci velit, sed quia non numquam eius modi tempora. incidunt ut labore et dolore -->
<!--                                     magnam.</p> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                     <div class="review-add"> -->
<!--                         <h4>Add Review</h4> -->
<!--                         <form action="#" class="ra-form"> -->
<!--                             <div class="row"> -->
<!--                                 <div class="col-lg-6"> -->
<!--                                     <input type="text" placeholder="Name*"> -->
<!--                                 </div> -->
<!--                                 <div class="col-lg-6"> -->
<!--                                     <input type="text" placeholder="Email*"> -->
<!--                                 </div> -->
<!--                                 <div class="col-lg-12"> -->
<!--                                     <div> -->
<!--                                         <h5>You Rating:</h5> -->
<!--                                         <div class="rating"> -->
<!--                                             <i class="icon_star"></i> -->
<!--                                             <i class="icon_star"></i> -->
<!--                                             <i class="icon_star"></i> -->
<!--                                             <i class="icon_star"></i> -->
<!--                                             <i class="icon_star-half_alt"></i> -->
<!--                                         </div> -->
<!--                                     </div> -->
<!--                                     <textarea placeholder="Your Review"></textarea> -->
<!--                                     <button type="submit">Submit Now</button> -->
<!--                                 </div> -->
<!--                             </div> -->
<!--                         </form> -->
<!--                     </div> -->
                </div>
                <div class="col-lg-4">
                    <div class="room-booking">
                        <h3>????????????</h3>
                        <form action="#">
                            <div class="check-date">
                                <label for="date-in">Check In:</label>
                                <input type="text" class="date-input" id="date-in" name="checkin">
                                <i class="icon_calendar"></i>
                            </div>
                            <div class="check-date">
                                <label for="date-out">Check Out:</label>
                                <input type="text" class="date-input" id="date-out" name="checkout">
                                <i class="icon_calendar"></i>
                            </div>
                            <div class="select-option">
                                <label for="guest">??????:</label>
                                <select id="guest">
                                    <option value="">${bean.capacity} ???</option>
                                </select>
                            </div>
                            <div class="select-option">
                                <label for="room">??????</label>
                                <select id="room">
                                    <option value="">1 ??????</option>
                                </select>
                            </div>
                            <button type="submit" formaction="<c:url value='/TestDate' />">??????</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Room Details Section End -->

    <!-- Footer Section Begin -->
    <footer class="footer-section">
        <div class="container">
            <div class="footer-text">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="ft-about">
                            <div class="logo">
                                <a href="#">
                                    <img src="img/footer-logo.png" alt="">
                                </a>
                            </div>
                            <p>We inspire and reach millions of travelers<br /> across 90 local websites</p>
                            <div class="fa-social">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-tripadvisor"></i></a>
                                <a href="#"><i class="fa fa-instagram"></i></a>
                                <a href="#"><i class="fa fa-youtube-play"></i></a>
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
                                <button type="submit"><i class="fa fa-send"></i></button>
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
                        <div class="co-text"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Search model Begin -->
    <div class="search-model">
        <div class="h-100 d-flex align-items-center justify-content-center">
            <div class="search-close-switch"><i class="icon_close"></i></div>
            <form class="search-model-form">
                <input type="text" id="search-input" placeholder="Search here.....">
            </form>
        </div>
    </div>
    <!-- Search model end -->

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