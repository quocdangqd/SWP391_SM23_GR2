<%-- 
    Document   : compareProduct
    Created on : May 26, 2023, 7:26:38 AM
    Author     : laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>TECHZONE</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-3.3.1.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="fonts/fontawesome/css/all.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Paytone+One&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/compare.css">
        <link rel="stylesheet" href="css/product.css">
        
    </head>
    <body>
        <!-- header -->
        <jsp:include page="header.jsp"></jsp:include>
            <!--end header-->
            <!-- score-top-->
            <button onclick="topFunction()" id="myBtn-scroll" title="Go to top"><i class="fas fa-chevron-up"></i></button>
            <!-- product -->
            <section class="product">
                <div class="container">
                    <div class="row bg-white pt-4 pb-4 border-bt pc">
                        <nav class="menu__nav col-lg-3 col-md-12 col-sm-0">
                            <ul class="menu__list">
                                <li class="menu__item menu__item--active">
                                    <a href="#" class="menu__link">
                                        <img src="images1/item/headphone.jpg" alt=""  class="menu__item-icon" id="Capa_1" enable-background="new 0 0 512 512" height="512" viewBox="0 0 512 512" width="512">
                                        Tai nghe</a>
                                </li>
                                <li class="menu__item">
                                    <a href="#" class="menu__link">
                                        <img src="images1/item/mouse.jpg" alt="" class="menu__item-icon" id="Capa_1" enable-background="new 0 0 512 512" height="512" viewBox="0 0 512 512" width="512">
                                        Chuột</a>
                                </li>
                                <li class="menu__item">
                                    <a href="#" class="menu__link">
                                        <img src="images1/item/keyboard.jpg" alt="" class="menu__item-icon"  viewBox="0 0 512 512" width="1012" height="512">
                                        Bàn phím</a>
                                </li>

                            </ul>
                        </nav>
                        </section>
                        
                        <!--footer-->
                    <jsp:include page="footer.jsp"></jsp:include>
                    <!--end footer-->

                    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
                    <script type="text/javascript">
                $(function () {
                    $('[data-filter="trigger"]').on("change", function () {
                        var t = $(this).find("option:selected").val().toLowerCase();

                        $('[data-filter="target"]').css("display", "none");
                        $("#" + t).css("display", "table-row-group");
                        if (t === "all") {
                            $('[data-filter="target"]').css("display", "table-row-group")
                        }
                        $(this).css("display", "block");
                    });
                })
                    </script>
                    </body>
                    </html>