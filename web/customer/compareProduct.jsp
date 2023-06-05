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

                        <div class="container pb-5 mb-2">
                            <div class="comparison-table">
                                <table class="table table-bordered">
                                    <thead class="bg-secondary">
                                        <tr>
                                            <td class="align-middle">
                                                <select class="form-control custom-select" id="compare-criteria" data-filter="trigger">
                                                    <option value="all">Comparison criteria *</option>
                                                    <option value="summary">Summary</option>
                                                    <option value="general">General</option>
                                                    <option value="multimedia">Multimedia</option>
                                                    <option value="performance">Performance</option>
                                                    <option value="design">Design</option>
                                                    <option value="display">Display</option>
                                                    <option value="storage">Storage</option>
                                                    <option value="camera">Camera</option>
                                                    <option value="battery">Battery</option>
                                                    <option value="price">Price &amp; rating</option>
                                                </select><small class="form-text text-muted">* Choose criteria to filter table below.</small>
                                                <div class="pt-3">
                                                    <div class="custom-control custom-checkbox">
                                                        <input class="custom-control-input" type="checkbox" id="differences">
                                                        <label class="custom-control-label" for="differences">Show differences only</label>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="comparison-item"><span class="remove-item"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-x"><line x1="18" y1="6" x2="6" y2="18"></line><line x1="6" y1="6" x2="18" y2="18"></line></svg></span>
                                                    <a class="comparison-item-thumb" href="shop-single.html"><img src="https://www.bootdey.com/image/160x160/FF0000/000000" alt="Apple iPhone Xs Max"></a><a class="comparison-item-title" href="shop-single.html">Apple iPhone Xs Max</a>
                                                    <button class="btn btn-pill btn-outline-primary btn-sm" type="button" data-toggle="toast" data-target="#cart-toast">Add to Cart</button>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="comparison-item"><span class="remove-item"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-x"><line x1="18" y1="6" x2="6" y2="18"></line><line x1="6" y1="6" x2="18" y2="18"></line></svg></span>
                                                    <a class="comparison-item-thumb" href="shop-single.html"><img src="https://www.bootdey.com/image/160x160/1E90FF/000000" alt="Google Pixel 3 XL"></a><a class="comparison-item-title" href="shop-single.html">Google Pixel 3 XL</a>
                                                    <button class="btn btn-pill btn-outline-primary btn-sm" type="button" data-toggle="toast" data-target="#cart-toast">Add to Cart</button>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="comparison-item"><span class="remove-item"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewbox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-x"><line x1="18" y1="6" x2="6" y2="18"></line><line x1="6" y1="6" x2="18" y2="18"></line></svg></span>
                                                    <a class="comparison-item-thumb" href="shop-single.html"><img src="https://www.bootdey.com/image/160x160/FF8C00/000000" alt="Samsung Galaxy S10+"></a><a class="comparison-item-title" href="shop-single.html">Samsung Galaxy S10+</a>
                                                    <button class="btn btn-pill btn-outline-primary btn-sm" type="button" data-toggle="toast" data-target="#cart-toast">Add to Cart</button>
                                                </div>
                                            </td>
                                        </tr>
                                    </thead>
                                    <tbody id="summary" data-filter="target">
                                        <tr class="bg-secondary">
                                            <th class="text-uppercase">Summary</th>
                                            <td><span class="text-dark font-weight-semibold">Apple iPhone Xs Max</span></td>
                                            <td><span class="text-dark font-weight-semibold">Google Pixel 3 XL</span></td>
                                            <td><span class="text-dark font-weight-semibold">Samsung Galaxy S10+</span></td>
                                        </tr>
                                        <tr>
                                            <th>Performance</th>
                                            <td>Hexa Core</td>
                                            <td>Octa Core</td>
                                            <td>Octa Core</td>
                                        </tr>
                                        <tr>
                                            <th>Display</th>
                                            <td>6.5-inch</td>
                                            <td>6.3-inch</td>
                                            <td>6.4-inch</td>
                                        </tr>
                                        <tr>
                                            <th>Storage</th>
                                            <td>64 GB</td>
                                            <td>64 GB</td>
                                            <td>128 GB</td>
                                        </tr>
                                        <tr>
                                            <th>Camera</th>
                                            <td>Dual 12-megapixel</td>
                                            <td>12.2-megapixel</td>
                                            <td>12,16,12-megapixel</td>
                                        </tr>
                                        <tr>
                                            <th>Battery</th>
                                            <td>3,174 mAh</td>
                                            <td>3,430 mAh</td>
                                            <td>4,100 mAh</td>
                                        </tr>
                                    </tbody>
                                    <tbody id="general" data-filter="target">
                                        <tr class="bg-secondary">
                                            <th class="text-uppercase">General</th>
                                            <td><span class="text-dark font-weight-semibold">Apple iPhone Xs Max</span></td>
                                            <td><span class="text-dark font-weight-semibold">Google Pixel 3 XL</span></td>
                                            <td><span class="text-dark font-weight-semibold">Samsung Galaxy S10+</span></td>
                                        </tr>
                                        <tr>
                                            <th>Quick charging</th>
                                            <td>Yes</td>
                                            <td>Yes</td>
                                            <td>Yes</td>
                                        </tr>
                                        <tr>
                                            <th>Operating system</th>
                                            <td>iOS v12</td>
                                            <td>Android v9.0 Pie </td>
                                            <td>Android v9.0 with Samsung One UI </td>
                                        </tr>
                                        <tr>
                                            <th>Sim slots</th>
                                            <td>Single SIM, GSM</td>
                                            <td>Single SIM, GSM</td>
                                            <td>Hybrid SIM slot, GSM</td>
                                        </tr>
                                        <tr>
                                            <th>Launch date</th>
                                            <td>September 12, 2018 (Official)</td>
                                            <td>November 1, 2018 (Official)</td>
                                            <td>February 20, 2019 (Official)</td>
                                        </tr>
                                        <tr>
                                            <th>Sim size</th>
                                            <td>SIM1: Nano</td>
                                            <td>SIM1: Nano</td>
                                            <td>SIM1: Nano SIM2: Nano (Hybrid)</td>
                                        </tr>
                                        <tr>
                                            <th>Network</th>
                                            <td>4G: Available (supports Indian bands) 3G: Available, 2G: Available</td>
                                            <td>4G: Available (supports Indian bands) 3G: Available, 2G: Available</td>
                                            <td>4G: Available (supports Indian bands) 3G: Available, 2G: Available</td>
                                        </tr>
                                        <tr>
                                            <th>Fingerprint sensor</th>
                                            <td>None (Face ID)</td>
                                            <td>Back cover</td>
                                            <td>In-screen</td>
                                        </tr>
                                    </tbody>
                                    <tbody id="multimedia" data-filter="target">
                                        <tr class="bg-secondary">
                                            <th class="text-uppercase">Multimedia</th>
                                            <td><span class="text-dark font-weight-semibold">Apple iPhone Xs Max</span></td>
                                            <td><span class="text-dark font-weight-semibold">Google Pixel 3 XL</span></td>
                                            <td><span class="text-dark font-weight-semibold">Samsung Galaxy S10+</span></td>
                                        </tr>
                                        <tr>
                                            <th>Loudspeaker</th>
                                            <td>Yes</td>
                                            <td>Yes</td>
                                            <td>Yes</td>
                                        </tr>
                                        <tr>
                                            <th>FM radio</th>
                                            <td>No</td>
                                            <td>No</td>
                                            <td>No</td>
                                        </tr>
                                        <tr>
                                            <th>Headphone jack</th>
                                            <td>No</td>
                                            <td>No</td>
                                            <td>Yes</td>
                                        </tr>
                                    </tbody>
                                    <tbody id="performance" data-filter="target">
                                        <tr class="bg-secondary">
                                            <th class="text-uppercase">Performance</th>
                                            <td><span class="text-dark font-weight-semibold">Apple iPhone Xs Max</span></td>
                                            <td><span class="text-dark font-weight-semibold">Google Pixel 3 XL</span></td>
                                            <td><span class="text-dark font-weight-semibold">Samsung Galaxy S10+</span></td>
                                        </tr>
                                        <tr>
                                            <th>Processor</th>
                                            <td>Apple A12 Bionic</td>
                                            <td>Qualcomm Snapdragon 845 (2.5GHz octa-core)</td>
                                            <td>Octa-core Qualcomm Snapdragon 855</td>
                                        </tr>
                                        <tr>
                                            <th>Graphics</th>
                                            <td>Apple GPU (4-core graphics)</td>
                                            <td>Adreno 630</td>
                                            <td>Mali-G72 MP18</td>
                                        </tr>
                                        <tr>
                                            <th>Architecture</th>
                                            <td>64 bit</td>
                                            <td>64 bit</td>
                                            <td>64 bit</td>
                                        </tr>
                                        <tr>
                                            <th>RAM</th>
                                            <td>4 GB</td>
                                            <td>4 GB</td>
                                            <td>8 GB</td>
                                        </tr>
                                    </tbody>
                                    <tbody id="design" data-filter="target">
                                        <tr class="bg-secondary">
                                            <th class="text-uppercase">Design</th>
                                            <td><span class="text-dark font-weight-semibold">Apple iPhone Xs Max</span></td>
                                            <td><span class="text-dark font-weight-semibold">Google Pixel 3 XL</span></td>
                                            <td><span class="text-dark font-weight-semibold">Samsung Galaxy S10+</span></td>
                                        </tr>
                                        <tr>
                                            <th>Build material</th>
                                            <td>Case: AluminiumBack: Mineral Glass</td>
                                            <td>Case: AluminiumBack: Aluminium</td>
                                            <td>Case: AluminiumBack: Mineral Glass</td>
                                        </tr>
                                        <tr>
                                            <th>Thickness</th>
                                            <td>7.7 mm</td>
                                            <td>7.9 mm</td>
                                            <td>8.5 mm</td>
                                        </tr>
                                        <tr>
                                            <th>Width</th>
                                            <td>70.9 mm</td>
                                            <td>76.7 mm</td>
                                            <td>73.8 mm</td>
                                        </tr>
                                        <tr>
                                            <th>Height</th>
                                            <td>143.6 mm</td>
                                            <td>157.9 mm</td>
                                            <td>158.1 mm</td>
                                        </tr>
                                        <tr>
                                            <th>Weight</th>
                                            <td>174 grams</td>
                                            <td>175 grams</td>
                                            <td>189 grams</td>
                                        </tr>
                                        <tr>
                                            <th>Waterproof</th>
                                            <td>Yes Water resistant (up to 30 minutes in a depth of 1 meter), IP67</td>
                                            <td>Yes Water resistant (up to 30 minutes in a depth of 1 meter), IP67</td>
                                            <td>Yes Water resistant (up to 30 minutes in a depth of 1.5 meter), IP68</td>
                                        </tr>
                                        <tr>
                                            <th>Colors</th>
                                            <td>Silver, Space Grey</td>
                                            <td>Black, Black and White</td>
                                            <td>Midnight Black, Coral Blue, Lilac Purple</td>
                                        </tr>
                                    </tbody>
                                    <tbody id="display" data-filter="target">
                                        <tr class="bg-secondary">
                                            <th class="text-uppercase">Display</th>
                                            <td><span class="text-dark font-weight-semibold">Apple iPhone Xs Max</span></td>
                                            <td><span class="text-dark font-weight-semibold">Google Pixel 3 XL</span></td>
                                            <td><span class="text-dark font-weight-semibold">Samsung Galaxy S10+</span></td>
                                        </tr>
                                        <tr>
                                            <th>Display type</th>
                                            <td>Super Retina OLED</td>
                                            <td>'flexible' OLED</td>
                                            <td>Super AMOLED</td>
                                        </tr>
                                        <tr>
                                            <th>Pixel density</th>
                                            <td>458 ppi</td>
                                            <td>522 ppi</td>
                                            <td>522 ppi</td>
                                        </tr>
                                        <tr>
                                            <th>Screen protection</th>
                                            <td>Yes</td>
                                            <td>Corning Gorilla Glass v5</td>
                                            <td>Corning Gorilla Glass v5</td>
                                        </tr>
                                        <tr>
                                            <th>Screen size</th>
                                            <td>6.5 inches</td>
                                            <td>6.3 inches</td>
                                            <td>6.4 inches</td>
                                        </tr>
                                        <tr>
                                            <th>Screen resolution</th>
                                            <td>1125 x 2436 pixels</td>
                                            <td>1440 x 2880 pixels</td>
                                            <td>1440 x 2960 pixels </td>
                                        </tr>
                                        <tr>
                                            <th>Touch screen</th>
                                            <td>Yes, 3D Touch Touchscreen, Multi-touch</td>
                                            <td>Yes, Capacitive Touchscreen, Multi-touch</td>
                                            <td>Yes, Capacitive Touchscreen, Multi-touch</td>
                                        </tr>
                                    </tbody>
                                    <tbody id="storage" data-filter="target">
                                        <tr class="bg-secondary">
                                            <th class="text-uppercase">Storage</th>
                                            <td><span class="text-dark font-weight-semibold">Apple iPhone Xs Max</span></td>
                                            <td><span class="text-dark font-weight-semibold">Google Pixel 3 XL</span></td>
                                            <td><span class="text-dark font-weight-semibold">Samsung Galaxy S10+</span></td>
                                        </tr>
                                        <tr>
                                            <th>Internal memory</th>
                                            <td>64 GB</td>
                                            <td>64 GB</td>
                                            <td>128 GB</td>
                                        </tr>
                                        <tr>
                                            <th>Expandable memory</th>
                                            <td>No</td>
                                            <td>No</td>
                                            <td>Yes Up to 1 TB</td>
                                        </tr>
                                    </tbody>
                                    <tbody id="camera" data-filter="target">
                                        <tr class="bg-secondary">
                                            <th class="text-uppercase">Camera</th>
                                            <td><span class="text-dark font-weight-semibold">Apple iPhone Xs Max</span></td>
                                            <td><span class="text-dark font-weight-semibold">Google Pixel 3 XL</span></td>
                                            <td><span class="text-dark font-weight-semibold">Samsung Galaxy S10+</span></td>
                                        </tr>
                                        <tr>
                                            <th>Settings</th>
                                            <td>Exposure compensation, ISO control</td>
                                            <td>Exposure compensation, ISO control</td>
                                            <td>Exposure compensation</td>
                                        </tr>
                                        <tr>
                                            <th>Aperture</th>
                                            <td>F2.2</td>
                                            <td>F2.4</td>
                                            <td>F1.7</td>
                                        </tr>
                                        <tr>
                                            <th>Camera features</th>
                                            <td>10 x Digital zoom, Optical zoom, Auto flash, Face detection, Touch to focus</td>
                                            <td>Fixed zocus</td>
                                            <td>Wide angle selfie</td>
                                        </tr>
                                        <tr>
                                            <th>Image resolution</th>
                                            <td>4000 x 3000 pixels</td>
                                            <td>4000 x 3000 pixels</td>
                                            <td>4000 x 3000 pixels</td>
                                        </tr>
                                        <tr>
                                            <th>Sensor</th>
                                            <td>BSI sensor</td>
                                            <td>CMOS image sensor</td>
                                            <td>CMOS image sensor</td>
                                        </tr>
                                        <tr>
                                            <th>Autofocus</th>
                                            <td>Yes</td>
                                            <td>No</td>
                                            <td>Yes</td>
                                        </tr>
                                        <tr>
                                            <th>Shooting modes</th>
                                            <td>Continuos shooting, High dynamic range mode (HDR), Burst mode</td>
                                            <td>Continuos shooting, High dynamic range mode (HDR)</td>
                                            <td>Continuos shooting, High dynamic range mode (HDR)</td>
                                        </tr>
                                        <tr>
                                            <th>Optical image stabilisation</th>
                                            <td>Yes, Dual optical image stabilization</td>
                                            <td>Yes</td>
                                            <td>Yes</td>
                                        </tr>
                                        <tr>
                                            <th>Flash</th>
                                            <td>Yes, Retina flash</td>
                                            <td>Yes, Dual LED flash</td>
                                            <td>Yes, LED flash</td>
                                        </tr>
                                    </tbody>
                                    <tbody id="battery" data-filter="target">
                                        <tr class="bg-secondary">
                                            <th class="text-uppercase">Battery</th>
                                            <td><span class="text-dark font-weight-semibold">Apple iPhone Xs Max</span></td>
                                            <td><span class="text-dark font-weight-semibold">Google Pixel 3 XL</span></td>
                                            <td><span class="text-dark font-weight-semibold">Samsung Galaxy S10+</span></td>
                                        </tr>
                                        <tr>
                                            <th>Talktime</th>
                                            <td>Up to 21 hours(4G)</td>
                                            <td>Up to 24 hours(4G)</td>
                                            <td>Up to 25 hours(4G)</td>
                                        </tr>
                                        <tr>
                                            <th>Quick charging</th>
                                            <td>Yes, fast, 50 % in 30 minutes</td>
                                            <td>Yes</td>
                                            <td>Yes</td>
                                        </tr>
                                        <tr>
                                            <th>Wireless charging</th>
                                            <td>Yes</td>
                                            <td>Yes</td>
                                            <td>Yes</td>
                                        </tr>
                                        <tr>
                                            <th>Type</th>
                                            <td>Li-ion</td>
                                            <td>Li-ion</td>
                                            <td>Li-ion</td>
                                        </tr>
                                        <tr>
                                            <th>Capacity</th>
                                            <td>3,174 mAh</td>
                                            <td>3,430 mAh</td>
                                            <td>4,100 mAh</td>
                                        </tr>
                                    </tbody>
                                    <tbody id="price" data-filter="target">
                                        <tr class="bg-secondary">
                                            <th class="text-uppercase">Price &amp; rating</th>
                                            <td><span class="text-dark font-weight-semibold">Apple iPhone Xs Max</span></td>
                                            <td><span class="text-dark font-weight-semibold">Google Pixel 3 XL</span></td>
                                            <td><span class="text-dark font-weight-semibold">Samsung Galaxy S10+</span></td>
                                        </tr>
                                        <tr>
                                            <th>Price</th>
                                            <td>$1,099</td>
                                            <td>$899</td>
                                            <td>$1,000</td>
                                        </tr>
                                        <tr>
                                            <th>Rating</th>
                                            <td>4.5/5</td>
                                            <td>4.5/5</td>
                                            <td>4.5/5</td>
                                        </tr>
                                        <tr>
                                            <th></th>
                                            <td>
                                                <button class="btn btn-outline-primary btn-block" type="button" data-toggle="toast" data-target="#cart-toast">Add to Cart</button>
                                            </td>
                                            <td>
                                                <button class="btn btn-outline-primary btn-block" type="button" data-toggle="toast" data-target="#cart-toast">Add to Cart</button>
                                            </td>
                                            <td>
                                                <button class="btn btn-outline-primary btn-block" type="button" data-toggle="toast" data-target="#cart-toast">Add to Cart</button>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>

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