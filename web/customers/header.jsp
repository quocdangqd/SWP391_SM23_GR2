<%-- 
    Document   : header
    Created on : May 25, 2023, 4:18:53 PM
    Author     : laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<header id="header">
    <!-- header top -->
    <div class="header__top">
        <div class="container">
            <section class="row flex">
                <div class="col-lg-5 col-md-0 col-sm-0 heade__top-left">
                    <span>TECHZONE - LỰA CHỌN ĐỂ VƯƠN XA</span>
                </div>
                <nav class="col-lg-7 col-md-0 col-sm-0 header__top-right">
                    <ul class="header__top-list">
                        <li class="header__top-item">
                            <a href="#" class="header__top-link">

                                Tài khoản của tôi</a>
                        </li>
                        <li class="header__top-item">
                            <a href="#" class="header__top-link">Giỏ hàng</a>
                        </li>
                        <li class="header__top-item">
                            <a href="#" class="header__top-link">Thanh toán</a>
                        </li>
                        <li class="header__top-item">
                            <a href="login.jsp" class="header__top-link">Đăng nhập</a>
                        </li>
                        <li class="header__top-item">
                            <a href="register.jsp" class="header__top-link">Đăng ký</a>
                        </li>
                    </ul>
                </nav>
            </section>
        </div>
    </div>
    <!--end header top -->

    <!-- header bottom -->
    <div class="header__bottom">
        <div class="container">
            <section class="row">
                <div class="col-lg-3 col-md-4 col-sm-12 header__logo">
                    <h1 class="header__heading">
                        <a href="homepage.jsp" class="header__logo-link">
                            <img src="images1/logo1.png" alt="Logo" class="header__logo-img">
                        </a>
                    </h1>
                </div>

                <div class="col-lg-6 col-md-7 col-sm-0 header__search">
                    <select name="" id="" class="header__search-select">
                        <option value="0">All</option>
                        <option value="1">Tai nghe</option>
                        <option value="2">Chuột</option>
                        <option value="3">Bàn phím</option>

                    </select>
                    <input type="text" class="header__search-input" placeholder="Tìm kiếm tại đây...">
                    <button class="header__search-btn">
                        <div class="header__search-icon-wrap">
                            <i class="fas fa-search header__search-icon"></i>
                        </div>
                    </button>
                </div>

                <div class="col-lg-2 col-md-0 col-sm-0 header__call">
                    <div class="header__call-icon-wrap">
                        <i class="fas fa-phone-alt header__call-icon"></i>  
                    </div>
                    <div class="header__call-info">
                        <div class="header__call-text">
                            Tư vấn khách hàng
                        </div>
                        <div class="header__call-number">
                            039.882.3232
                        </div>
                    </div>
                </div>

                <a href="listCart.jsp" class="col-lg-1 col-md-1 col-sm-0 header__cart">
                    <div class="header__cart-icon-wrap">
                        <span class="header__notice">4</span>
                        <i class="fas fa-shopping-cart header__nav-cart-icon"></i>
                    </div>
                </a>
            </section>
        </div>   
    </div>
    <!--end header bottom -->

    <!-- header nav -->
    <div class="header__nav">
        <div class="container">
            <section class="row">
                <div class="header__nav-menu-wrap col-lg-3 col-md-0 col-sm-0">
                    <i class="fas fa-bars header__nav-menu-icon"></i>
                    <div class="header__nav-menu-title">Danh mục sản phẩm</div>
                </div>

                <div class="header__nav col-lg-9 col-md-0 col-sm-0">
                    <ul class="header__nav-list">
                        <li class="header__nav-item">
                            <a href="homepage.jsp" class="header__nav-link">TRANG CHỦ</a>
                        </li>
                        <li class="header__nav-item">
                            <a href="listProduct.jsp" class="header__nav-link">SẢN PHẨM</a>
                        </li>
                        <li class="header__nav-item">
                            <a href="compareProduct.jsp" class="header__nav-link">SO SÁNH SẢN PHẨM</a>
                        </li>  
                        <li class="header__nav-item">
                            <a href="checkout2.jsp" class="header__nav-link">THANH TOÁN</a>
                        </li>               
                        <li class="header__nav-item">
                            <a href="contact.jsp" class="header__nav-link">LIÊN HỆ</a>
                        </li>
                    </ul>
                </div>
            </section>
        </div>
    </div>
</header>
<!--end header nav -->