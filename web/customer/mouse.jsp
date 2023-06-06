<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>TECHZONE</title>
        <script src="js/jquery-3.3.1.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="fonts/fontawesome/css/all.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Paytone+One&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/home.css">
        <link rel="stylesheet" href="css/category.css">
        <link rel="stylesheet" href="fonts/fontawesome/css/all.min.css">
    </head>
    <body>
        <!-- header -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- end header -->
            <!-- score-top-->
            <button onclick="topFunction()" id="myBtn-scroll" title="Go to top"><i class="fas fa-chevron-up"></i></button>                        
            <!-- product -->
            <section class="menu-slide">
                <div class="container">
                    <div class="row">
                        <nav class="menu__nav col-lg-3 col-md-12 col-sm-0">
                            <ul class="menu__list">
                                <li class="menu__item menu__item--active">
                                    <a href="headphone.jsp" class="menu__link">
                                        <img src="images1/item/headphone.jpg" alt=""  class="menu__item-icon" id="Capa_1" enable-background="new 0 0 512 512" height="512" viewBox="0 0 512 512" width="512">
                                        Tai nghe</a>
                                </li>
                                <li class="menu__item">
                                    <a href="mouse.jsp" class="menu__link">
                                        <img src="images1/item/mouse.jpg" alt="" class="menu__item-icon" id="Capa_1" enable-background="new 0 0 512 512" height="512" viewBox="0 0 512 512" width="512">
                                        Chuột</a>
                                </li>

                                <li class="menu__item">
                                    <a href="keyboard.jsp" class="menu__link">
                                        <img src="images1/item/keyboard.jpg" alt="" class="menu__item-icon"  viewBox="0 0 512 512" width="1012" height="512">

                                        Bàn phím</a>
                                </li>

                            </ul>
                        </nav>
                    </div>
                </div>
            </section>
            <!--chuột-->
            <section  id ='category2' class="product__love">
                <div class="container">
                    <div class="row bg-white">
                        <div class="col-lg-12 col-md-12 col-sm-12 product__love-title">
                            <h2 class="product__love-heading upper">
                                Chuột
                            </h2>
                        </div>
                    </div>
                    <div class="row bg-white">
                        <div class="product__panel-item col-lg-2 col-md-3 col-sm-6">
                            <div class="product__panel-img-wrap">
                                <img src="images1/category/c1.jpg" alt="" class="product__panel-img" style="border-radius: 5px">
                            </div>
                            <h3 class="product__panel-heading">
                                <a href="product.jsp" class="product__panel-link">Chuột Logitech G Pro X Superlight Wireless Red</a>
                            </h3>
                            <div class="product__panel-rate-wrap">
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                            </div>

                            <div class="product__panel-price">
                                <span class="product__panel-price-old-1 "> 
                                    <h2><a href="compareProduct.jsp" class="my-class">SO SÁNH</a></h2>
                                </span>
                                <span class="product__panel-price-current">
                                    291.650đ
                                </span>
                            </div>  

                            <div class="product__panel-price-sale-off">
                                -5%
                            </div>
                        </div>

                        <div class="product__panel-item col-lg-2 col-md-3 col-sm-6">
                            <div class="product__panel-img-wrap">
                                <img src="images1/category/c2.jpg" alt="" class="product__panel-img" >
                            </div>
                            <h3 class="product__panel-heading">
                                <a href="product.jsp" class="product__panel-link">Chuột Logitech G502 X Plus LightSpeed White
                                </a>
                            </h3>
                            <div class="product__panel-rate-wrap">
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                            </div>

                            <div class="product__panel-price">
                                <span class="product__panel-price-old-1 ">
                                    <h2><button><a href="compareProduct.jsp" class="my-class">SO SÁNH</a></button></h2>
                                </span>
                                <span class="product__panel-price-current">
                                    <button>291.650đ</button>
                                </span>
                            </div> 

                            <div class="product__panel-price-sale-off">
                                -5%
                            </div> 
                        </div>

                        <div class="product__panel-item col-lg-2 col-md-3 col-sm-6">
                            <div class="product__panel-img-wrap">
                                <img src="images1/category/c3.jpg" alt="" class="product__panel-img">
                            </div>
                            <h3 class="product__panel-heading">
                                <a href="product.jsp" class="product__panel-link">Chuột Logitech G502 Hero</a>
                            </h3>
                            <div class="product__panel-rate-wrap">
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                            </div>

                            <div class="product__panel-price">
                                <span class="product__panel-price-old-1  ">
                                    <h2><button><a href="compareProduct.jsp" class="my-class">SO SÁNH</a></button></h2>
                                </span>
                                <span class="product__panel-price-current">
                                    <button>291.650đ</button>
                                </span>
                            </div>

                            <div class="product__panel-price-sale-off">
                                -5%
                            </div> 
                        </div>
                        <div class="product__panel-item col-lg-2 col-md-3 col-sm-6">
                            <div class="product__panel-img-wrap">
                                <img src="images1/category/c4.jpg" alt="" class="product__panel-img">
                            </div>
                            <h3 class="product__panel-heading">
                                <a href="product.jsp" class="product__panel-link">Chuột Logitech G502 X Plus LightSpeed</a>
                            </h3>
                            <div class="product__panel-rate-wrap">
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                            </div>

                            <div class="product__panel-price">
                                <span class="product__panel-price-old-1 product__panel-price-old-1-hide">
                                    <h2><button><a href="compareProduct.jsp" class="my-class">SO SÁNH</a></button></h2>
                                </span>
                                <span class="product__panel-price-current">
                                    <button>291.650đ</button>
                                </span>
                            </div> 

                            <!-- <div class="product__panel-price-sale-off">
                               -10%
                           </div>  -->
                        </div>

                        <div class="product__panel-item col-lg-2 col-md-3 col-sm-6">
                            <div class="product__panel-img-wrap">
                                <img src="images1/category/c5.jpg" alt="" class="product__panel-img" >
                            </div>
                            <h3 class="product__panel-heading">
                                <a href="product.jsp" class="product__panel-link">Chuột Logitech G203 LightSync Lilac</a>
                            </h3>
                            <div class="product__panel-rate-wrap">
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                            </div>

                            <div class="product__panel-price">
                                <span class="product__panel-price-old-1 product__panel-price-old-1-hide">
                                    <h2><button><a href="compareProduct.jsp" class="my-class">SO SÁNH</a></button></h2>
                                </span>
                                <span class="product__panel-price-current">
                                    <button>291.650đ</button>
                                </span>
                            </div> 

                            <div class="product__panel-price-sale-off">
                                -10%
                            </div>  
                        </div>

                        <div class="product__panel-item col-lg-2 col-md-3 col-sm-6">
                            <div class="product__panel-img-wrap">
                                <img src="images1/category/c6.jpg" alt="" class="product__panel-img">
                            </div>
                            <h3 class="product__panel-heading">
                                <a href="product.jsp" class="product__panel-link">Chuột Logitech G Pro Hero</a>
                            </h3>
                            <div class="product__panel-rate-wrap">
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                                <i class="fas fa-star product__panel-rate"></i>
                            </div>

                            <div class="product__panel-price">
                                <span class="product__panel-price-old-1 product__panel-price-old-1-hide">
                                    <h2><button><a href="compareProduct.jsp" class="my-class">SO SÁNH</a></button></h2>
                                </span>
                                <span class="product__panel-price-current">
                                    <button>291.650đ</button>
                                </span>
                            </div> 

                            <!-- <div class="product__panel-price-sale-off">
                                -5%
                            </div>  -->
                        </div>

                    </div>
                </div>
            </section>
            <!-- footer -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- end footer -->
        <script src="js/jq.js"></script>
        <script src="js/category.js"></script>
    </body>
</html>