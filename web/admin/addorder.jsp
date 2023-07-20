<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <link rel="icon" href="image/icon.png" type="image/x-icon"/>
        <title>Danh sách đơn hàng | Quản trị Admin</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <!-- or -->
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

        <!-- Font-icon css-->
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">

    </head>

    <body onload="time()" class="app sidebar-mini rtl">
        <!-- Navbar-->
        <header class="app-header">
            <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                            aria-label="Hide Sidebar"></a>
            <!-- Navbar Right Menu-->
            <ul class="app-nav">


                <!-- User Menu-->
                <li><a class="app-nav__item" href="../view/homepage"><i class='bx bx-log-out bx-rotate-180'></i> </a>

                </li>
            </ul>
        </header>
        <!-- Sidebar menu-->
        <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
        <aside class="app-sidebar">
            <div class="app-sidebar__user">
                <div>
                    <a href="homepage.jsp"><img src="image/logo1.png" alt="Logo" height="45px" width="225px"/></a>
                </div>
            </div>
            <hr>
            <ul class="app-menu">
                <li><a class="app-menu__item" href="AdminHomepageController"><i class='app-menu__icon bx bx-tachometer'></i><span
                            class="app-menu__label">Bảng điều khiển</span></a></li>
                <li><a class="app-menu__item " href="ManagerUserController"><i class='app-menu__icon bx bx-id-card'></i> <span
                            class="app-menu__label">Quản lý người dùng</span></a></li>
                <li><a class="app-menu__item" href="productmanager.jsp"><i
                            class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Quản lý sản phẩm</span></a>
                </li>
                <li><a class="app-menu__item active" href="OrderController"><i class='app-menu__icon bx bx-task'></i><span
                            class="app-menu__label">Quản lý đơn hàng</span></a></li>
                <li><a class="app-menu__item" href="incomemanager.jsp"><i
                            class='app-menu__icon bx bx-pie-chart-alt-2'></i><span class="app-menu__label">Báo cáo doanh thu</span></a>
                </li>
            </ul>
        </aside>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb">
                    <li class="breadcrumb-item">Danh sách đơn hàng</li>
                    <li class="breadcrumb-item"><a href="#">Thêm đơn hàng</a></li>
                </ul>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="tile">
                        <h3 class="tile-title">Tạo mới đơn hàng</h3>
                        <div class="tile-body">
                            <form class="row">
                                <div class="form-group  col-md-4">
                                    <label class="control-label">ID đơn hàng</label>
                                    <input class="form-control" type="text">
                                </div>
                                <div class="form-group  col-md-4">
                                    <label class="control-label">Tên khách hàng</label>
                                    <input class="form-control" type="text" >
                                </div>
                                <div class="form-group  col-md-4">
                                    <label class="control-label">Số điện thoại khách hàng</label>
                                    <input class="form-control" type="number" >
                                </div>
                                <div class="form-group  col-md-4">
                                    <label class="control-label">Địa chỉ khách hàng</label>
                                    <input class="form-control" type="text" >
                                </div>
                                <div class="form-group  col-md-4">
                                    <label class="control-label">Tên người bán</label>
                                    <input class="form-control" type="text">
                                </div>
                                <div class="form-group  col-md-4">
                                    <label class="control-label">Số hiệu người bán</label>
                                    <input class="form-control" type="text">
                                </div>
                                <div class="form-group  col-md-4">
                                    <label class="control-label">Ngày làm đơn hàng</label>
                                    <input class="form-control" type="date" >
                                </div>
                                <div class="form-group  col-md-4">
                                    <label class="control-label">Tên sản phẩm cần bán</label>
                                    <input class="form-control" type="text">
                                </div>
                                <div class="form-group  col-md-4">
                                    <label class="control-label">Mã sản phẩm</label>
                                    <input class="form-control" type="text">
                                </div>
                                <div class="form-group  col-md-4">
                                    <label class="control-label">Số lượng</label>
                                    <input class="form-control" type="number">
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="exampleSelect1" class="control-label">Tình trạng</label>
                                    <select class="form-control" id="exampleSelect1">
                                        <option>-- Chọn tình trạng --</option>
                                        <option>Đã xử lý</option>
                                        <option>Đang chờ</option>
                                        <option>Đã hủy</option>
                                    </select>
                                </div>
                                <div class="form-group  col-md-4">
                                    <label class="control-label">Ghi chú đơn hàng</label>
                                    <textarea class="form-control" rows="4" ></textarea>
                                </div>  

                        </div>
                        <button class="btn btn-save" type="button">Lưu lại</button>
                        <a class="btn btn-cancel" href="ordermanager.jsp">Hủy bỏ</a>
                    </div>
                    </main>
                    <!-- Essential javascripts for application to work-->
                    <script src="js/jquery-3.2.1.min.js"></script>
                    <script src="js/popper.min.js"></script>
                    <script src="js/bootstrap.min.js"></script>
                    <script src="js/main.js"></script>
                    <!-- The javascript plugin to display page loading on top-->
                    <script src="js/plugins/pace.min.js"></script>
                    </body>
                    </html>
