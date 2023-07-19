<%-- 
    Document   : compareProduct
    Created on : May 26, 2023, 7:26:38 AM
    Author     : laptop
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <style>
            h1{
                text-align: center;
                margin: 20px 0px 20px 0px;
            }
            u{
                font-size: 25px;
            }
        </style>
    </head>
    <body>
        <!-- header -->
        <jsp:include page="header.jsp"></jsp:include>
            <!--end header-->
            <!-- score-top-->
            <h1>So sánh: <u>${product1.getName()}</u> VS <u>${product2.getName()}</u></h1>
        <div class="container pb-5 mb-2">
            <div class="comparison-table">
                <table class="table table-bordered">
                    <thead class="bg-secondary">
                        <tr style="text-align: center">
                            <td>
                                <input value="${product1.getName()}"  id='input1' oninput="searchFunct('input1','productList1')" type="text" name="name" style="padding: 0 12px; width: 320px; text-align: center"><br>
                                <ul id="productList1" style="list-style: none;"> 
                                </ul>
                                <img src="${product1.getPicture()}" width="180px" height="180px" style="margin: 10px 0px 10px 0px"/><br>
                                Giá chỉ có: ${product1.getSalePrice()}<br>
                                <a href="ProductDetailController?ProductID=${product1.getProductID()}" target="target"><h5>Xem chi tiết</h5></a>
                            </td>
                            <td>
                                <input value="${product2.getName()}"  id='input2' oninput="searchFunct('input2','productList2')" type="text" name="name" style="padding: 0 12px; width: 320px; text-align: center"><br>
                                <ul id="productList2" style="list-style: none;"> 
                                </ul>
                                <c:if test="${product2!=null}">
                                    <img src="${product2.getPicture()}" width="180px" height="180px" style="margin: 10px 0px 10px 0px"/><br>
                                </c:if>
                                <c:if test="${product2==null}">
                                    <img  width="180px" height="180px" style="margin: 10px 0px 10px 0px"/><br>
                                </c:if>
                                Giá chỉ có: ${product2.getSalePrice()}<br>
                                <a href="ProductDetailController?ProductID=${product2.getProductID()}" target="target"><h5>Xem chi tiết</h5></a>
                            </td>
                        </tr>
                    </thead>
                </table>
            </div>
        </div>
        <div class="container pb-5 mb-2">
            <div class="comparison-table">
                <table class="table table-bordered">
                    <tbody id="summary" data-filter="target">
                        <tr class="bg-secondary">
                            <th class="text-uppercase">Summary</th>
                            <td>${product1.getName()}</td>
                            <td>${product2.getName()}</td>
                        </tr>
                        <tr>
                            <th>Type</th>
                            <td>${product1.getType()}</td>
                            <td>${product2.getType()}</td>
                        </tr>
                        <tr>
                            <th>Frequency</th>
                            <td>${product1.getFrequency()}</td>
                            <td>${product2.getFrequency()}</td>
                        </tr>
                        <tr>
                            <th>Sensitive</th>
                            <td>${product1.getSensitive()}</td>
                            <td>${product2.getSensitive()}</td>
                        </tr>
                        <tr>
                            <th>Impedance</th>
                            <td>${product1.getImpedance()}</td>
                            <td>${product2.getImpedance()}</td>
                        </tr>
                        <tr>
                            <th>Material</th>
                            <td>${product1.getMeterial()}</td>
                            <td>${product2.getMeterial()}</td>
                        </tr>
                        <tr>
                            <th>Size</th>
                            <td>${product1.getSize()}</td>
                            <td>${product2.getSize()}</td>
                        </tr>
                        <tr>
                            <th>Battery</th>
                            <td>${product1.getBattery()}</td>
                            <td>${product2.getBattery()}</td>
                        </tr>
                        <tr>
                            <th>Connection_distance</th>
                            <td>${product1.getConnection_distance()}</td>
                            <td>${product2.getConnection_distance()}</td>
                        </tr>
                        <tr>
                            <th>Wire_length</th>
                            <td>${product1.getWire_length()}</td>
                            <td>${product2.getWire_length()}</td>
                        </tr>
                    </tbody>
                    <tbody id="price" data-filter="target">
                        <tr class="bg-secondary">
                            <th class="text-uppercase">Price &amp; rating</th>
                            <td>${product1.getName()}</td>
                            <td>${product2.getName()}</td>
                        </tr>
                        <tr>
                            <th>Price</th>
                            <td>${product1.getSalePrice()}đ</td>
                            <td>${product2.getSalePrice()}đ</td>
                        </tr>
                        <tr>
                            <th>Rating</th>
                            <td>${product1.getRate()==null?"0":product1.getRate()}/5</td>
                            <td>${product2.getRate()==null?"0":product2.getRate()}/5</td>
                        </tr>
                        <!--                        <tr>
                                                    <th></th>
                                                    <td>
                                                        <button class="btn btn-outline-primary btn-block" type="button" data-toggle="toast" data-target="#cart-toast">Thêm vào giỏ hàng</button>
                                                    </td>
                                                    <td>
                                                        <button class="btn btn-outline-primary btn-block" type="button" data-toggle="toast" data-target="#cart-toast">Thêm vào giỏ hàng</button>
                                                    </td>
                                                </tr>-->
                    </tbody>
                </table>
            </div>
        </div>

        <!--footer-->
        <jsp:include page="footer.jsp"></jsp:include>
        <!--end footer-->
        <button onclick="topFunction()" id="myBtn-scroll" title="Go to top"><i class="fas fa-chevron-up"></i></i></button>
    <script>
        function searchFunct(input, ulType) {
            event.preventDefault();
            var inputValue = document.getElementById(input).value.trim();
            $.ajax({
                url: '/TechZone/view/CompareProductController',
                type: "post", //send it through get method
                data: {
                    productNameInput: inputValue,
                    inputType: input
                },
                success: function (data) {
                    var row = document.getElementById(ulType);
                    row.innerHTML = data;
//                    row.innerHTML += data;
                },
                error: function (xhr) {
                    //Do Something to handle error
                }
            });
        }

    </script>
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