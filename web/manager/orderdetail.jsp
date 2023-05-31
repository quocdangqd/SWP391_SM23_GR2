<%-- 
    Document   : orderdetail
    Created on : May 28, 2023, 6:38:55 AM
    Author     : laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="icon" href="image/icon.png" type="image/x-icon"/>
        <title>Hệ thống quản lý</title>
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
        <link href="../dist/css/style.min.css" rel="stylesheet" />
    </head>

    <body onload="time()" class="app sidebar-mini rtl">
        <!-- Navbar-->
        <header class="app-header">
            <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                            aria-label="Hide Sidebar"></a>
            <!-- Navbar Right Menu-->
            <ul class="app-nav">


                <!-- User Menu-->
                <li><a class="app-nav__item" href="/homepage.jsp"><i class='bx bx-log-out bx-rotate-180'></i> </a>

                </li>
            </ul>
            <div
                class="navbar-collapse collapse" id="navbarSupportedContent" data-navbarbg="skin5">
                <!-- ============================================================== -->
                <!-- toggle and nav items -->
                <!-- ============================================================== -->
                <ul class="navbar-nav float-start me-auto">
                    <li class="nav-item dropdown">
                        <a
                            class="nav-link dropdown-toggle waves-effect waves-dark"
                            href="#"
                            id="2"
                            role="button"
                            data-bs-toggle="dropdown"
                            aria-expanded="false"
                            >
                            <i class="font-24 mdi mdi-comment-processing"></i>
                        </a>
                        <ul
                            class="
                            dropdown-menu dropdown-menu-end
                            mailbox
                            animated
                            bounceInDown
                            "
                            aria-labelledby="2"
                            >
                            <ul class="list-style-none">
                                <li>
                                    <div class="">
                                        <!-- Message -->
                                        <a href="javascript:void(0)" class="link border-top">
                                            <div class="d-flex no-block align-items-center p-10">
                                                <span
                                                    class="
                                                    btn btn-success btn-circle
                                                    d-flex
                                                    align-items-center
                                                    justify-content-center
                                                    "
                                                    ><i class="mdi mdi-calendar text-white fs-4"></i
                                                    ></span>
                                                <div class="ms-2">
                                                    <h5 class="mb-0">Event today</h5>
                                                    <span class="mail-desc"
                                                          >Just a reminder that event</span
                                                    >
                                                </div>
                                            </div>
                                        </a>
                                        <!-- Message -->
                                        <a href="javascript:void(0)" class="link border-top">
                                            <div class="d-flex no-block align-items-center p-10">
                                                <span
                                                    class="
                                                    btn btn-info btn-circle
                                                    d-flex
                                                    align-items-center
                                                    justify-content-center
                                                    "
                                                    ><i class="mdi mdi-settings fs-4"></i
                                                    ></span>
                                                <div class="ms-2">
                                                    <h5 class="mb-0">Settings</h5>
                                                    <span class="mail-desc"
                                                          >You can customize this template</span
                                                    >
                                                </div>
                                            </div>
                                        </a>
                                        <!-- Message -->
                                        <a href="javascript:void(0)" class="link border-top">
                                            <div class="d-flex no-block align-items-center p-10">
                                                <span
                                                    class="
                                                    btn btn-primary btn-circle
                                                    d-flex
                                                    align-items-center
                                                    justify-content-center
                                                    "
                                                    ><i class="mdi mdi-account fs-4"></i
                                                    ></span>
                                                <div class="ms-2">
                                                    <h5 class="mb-0">Pavan kumar</h5>
                                                    <span class="mail-desc"
                                                          >Just see the my admin!</span
                                                    >
                                                </div>
                                            </div>
                                        </a>
                                        <!-- Message -->
                                        <a href="javascript:void(0)" class="link border-top">
                                            <div class="d-flex no-block align-items-center p-10">
                                                <span
                                                    class="
                                                    btn btn-danger btn-circle
                                                    d-flex
                                                    align-items-center
                                                    justify-content-center
                                                    "
                                                    ><i class="mdi mdi-link fs-4"></i
                                                    ></span>
                                                <div class="ms-2">
                                                    <h5 class="mb-0">Luanch Admin</h5>
                                                    <span class="mail-desc"
                                                          >Just see the my new admin!</span
                                                    >
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                </li>
                            </ul>
                        </ul>
                    </li>
                    <!-- ============================================================== -->
                    <!-- End Messages -->
                    <!-- ============================================================== -->

                    <!-- ============================================================== -->
                    <!-- User profile and search -->
                    <!-- ============================================================== -->
                    <li class="nav-item dropdown">
                        <a
                            class="
                            nav-link
                            dropdown-toggle
                            text-muted
                            waves-effect waves-dark
                            pro-pic
                            "
                            href="#"
                            id="navbarDropdown"
                            role="button"
                            data-bs-toggle="dropdown"
                            aria-expanded="false"
                            >
                            <img
                                src="../assets/images/users/1.jpg"
                                alt="user"
                                class="rounded-circle"
                                width="31"
                                />
                        </a>
                        <ul
                            class="dropdown-menu dropdown-menu-end user-dd animated"
                            aria-labelledby="navbarDropdown"
                            >
                            <a class="dropdown-item" href="javascript:void(0)"
                               ><i class="mdi mdi-account me-1 ms-1"></i> My Profile</a
                            >
                            <a class="dropdown-item" href="javascript:void(0)"
                               ><i class="mdi mdi-wallet me-1 ms-1"></i> My Balance</a
                            >
                            <a class="dropdown-item" href="javascript:void(0)"
                               ><i class="mdi mdi-email me-1 ms-1"></i> Inbox</a
                            >
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="javascript:void(0)"
                               ><i class="mdi mdi-settings me-1 ms-1"></i> Account
                                Setting</a
                            >
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="javascript:void(0)"
                               ><i class="fa fa-power-off me-1 ms-1"></i> Logout</a
                            >
                            <div class="dropdown-divider"></div>
                            <div class="ps-4 p-10">
                                <a
                                    href="javascript:void(0)"
                                    class="btn btn-sm btn-success btn-rounded text-white"
                                    >View Profile</a
                                >
                            </div>
                        </ul>
                    </li>
                </ul>
            </div>
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
                <li><a class="app-menu__item " href="homepage.jsp"><i class='app-menu__icon bx bx-tachometer'></i><span
                            class="app-menu__label">Bảng điều khiển</span></a></li>

                <li><a class="app-menu__item" href="productmanager.jsp"><i
                            class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Danh sách sản phẩm</span></a>
                </li>
                <li><a class="app-menu__item active" href="ordermanager.jsp"><i class='app-menu__icon bx bx-task'></i><span
                            class="app-menu__label">Danh sách đơn hàng</span></a></li>
                <li><a class="app-menu__item" href="accountmanager.jsp"><i class='app-menu__icon bx bx-run'></i><span
                            class="app-menu__label">Đánh giá </span></a></li>
                <li><a class="app-menu__item" href="incomemanager.jsp"><i
                            class='app-menu__icon bx bx-pie-chart-alt-2'></i><span class="app-menu__label">Báo cáo doanh thu</span></a>
                </li>
            </ul>
        </aside>
        <main class="app-content">
            <div class="app-title">
                <ul class="app-breadcrumb breadcrumb side">
                    <li class="breadcrumb-item active"><a href="#"><b>Danh sách đơn hàng</b></a></li>
                </ul>
                <div id="clock"></div>
            </div>
            <div class="page-wrapper">
                <!-- Container fluid  -->
                <!-- ============================================================== -->
                <div class="container-fluid">
                    <!-- ============================================================== -->
                    <!-- Start Page Content -->
                    <!-- ============================================================== -->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card card-body printableArea">
                                <h3><b>Hóa đơn</b> <span class="pull-right">#5669626</span></h3>
                                <hr />
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="pull-left">
                                            <address>
                                                <div>Đơn vị bán:
                                                    &nbsp;<b class="text-danger text-uppercase" >TechZone</b>
                                                </div>
                                                <div>Địa chỉ: 
                                                    <b class="text-secondary">Thạch Hòa, Thạch Thất, Hà Nội.</b>
                                                </div>
                                                <div>Số điện thoại: 
                                                    <b class="text-secondary">0198724681</b>
                                                </div>
                                            </address>
                                        </div>
                                        <div class="pull-right text-end">
                                            <address>
                                                <div>Người mua:
                                                    &nbsp;<b class="text-danger text-uppercase" >Bún bò huế </b>
                                                </div>
                                                <div>Địa chỉ: 
                                                    <b class="text-secondary">Bình Yên, Thạch Thất, Hà Nội.</b>
                                                </div>
                                                <div>Số điện thoại: 
                                                    <b class="text-secondary">0276544681</b>
                                                </div>
                                                
                                                <p class="mt-4">
                                                    <b>Ngày đặt:</b>
                                                    <i class="mdi mdi-calendar"></i> 23/01/2022
                                                </p>
                                                <p>
                                                    <b>Ngày nhận:</b>
                                                    <i class="mdi mdi-calendar"></i> 24/01/2022
                                                </p>
                                            </address>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="table-responsive mt-5" style="clear: both">
                                            <table class="table table-hover">
                                                <thead>
                                                    <tr>
                                                        <th class="text-center">#</th>
                                                        <th>Tên hàng hóa, dịch vụ </th>
                                                        <th class="text-end">Số lương</th>
                                                        <th class="text-end">Đơn giá</th>
                                                        <th class="text-end">Thành tiền</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td class="text-center">1</td>
                                                        <td>Milk Powder</td>
                                                        <td class="text-end">2</td>
                                                        <td class="text-end">$24</td>
                                                        <td class="text-end">$48</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="text-center">2</td>
                                                        <td>Air Conditioner</td>
                                                        <td class="text-end">3</td>
                                                        <td class="text-end">$500</td>
                                                        <td class="text-end">$1500</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="text-center">3</td>
                                                        <td>RC Cars</td>
                                                        <td class="text-end">20</td>
                                                        <td class="text-end">%600</td>
                                                        <td class="text-end">$12000</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="text-center">4</td>
                                                        <td>Down Coat</td>
                                                        <td class="text-end">60</td>
                                                        <td class="text-end">$5</td>
                                                        <td class="text-end">$300</td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="4" class="text-lg-right">Cộng tiền hàng:</td>
                                                        <td class="text-end">$13,848</td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="4" class="text-lg-right">Cộng tiền thuế GTGT (VAT 10%):</td>
                                                        <td class="text-end">$138</td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="4" class="text-lg-right"><b>Tổng cộng tiền thanh toán:</b></td>
                                                        <td class="text-end"><b>$13,986<b></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="clearfix"></div>
                                        <hr/>
                                        <div class="pull-right text-end">
                                            <button class="btn btn-danger text-white" type="submit">
                                                Proceed to payment
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- ============================================================== -->
                    <!-- End PAge Content -->
                    <!-- ============================================================== -->
                    <!-- ============================================================== -->
                    <!-- Right sidebar -->
                    <!-- ============================================================== -->
                    <!-- .right-sidebar -->
                    <!-- ============================================================== -->
                    <!-- End Right sidebar -->
                    <!-- ============================================================== -->
                </div>
                <!-- ============================================================== -->
                <!-- End Container fluid  -->
                <!-- ============================================================== -->
            </div>
        </main>
        <!-- Essential javascripts for application to work-->
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="src/jquery.table2excel.js"></script>
        <script src="js/main.js"></script>
        <!-- The javascript plugin to display page loading on top-->
        <script src="js/plugins/pace.min.js"></script>
        <!-- Page specific javascripts-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
        <!-- Data table plugin-->
        <script type="text/javascript" src="js/plugins/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="js/plugins/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript">$('#sampleTable').DataTable();</script>
        <script src="../assets/libs/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap tether Core JavaScript -->
        <script src="../assets/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
        <!-- slimscrollbar scrollbar JavaScript -->
        <script src="../assets/libs/perfect-scrollbar/dist/perfect-scrollbar.jquery.min.js"></script>
        <script src="../assets/extra-libs/sparkline/sparkline.js"></script>
        <!--Wave Effects -->
        <script src="../dist/js/waves.js"></script>
        <!--Menu sidebar -->
        <script src="../dist/js/sidebarmenu.js"></script>
        <!--Custom JavaScript -->
        <script src="../dist/js/custom.min.js"></script>
        <script>
        function deleteRow(r) {
            var i = r.parentNode.parentNode.rowIndex;
            document.getElementById("myTable").deleteRow(i);
        }
        jQuery(function () {
            jQuery(".trash").click(function () {
                swal({
                    title: "Cảnh báo",

                    text: "Bạn có chắc chắn là muốn xóa nhân viên này?",
                    buttons: ["Hủy bỏ", "Đồng ý"],
                })
                        .then((willDelete) => {
                            if (willDelete) {
                                swal("Đã xóa thành công.!", {

                                });
                            }
                        });
            });
        });
        oTable = $('#sampleTable').dataTable();
        $('#all').click(function (e) {
            $('#sampleTable tbody :checkbox').prop('checked', $(this).is(':checked'));
            e.stopImmediatePropagation();
        });

        //EXCEL
        // $(document).ready(function () {
        //   $('#').DataTable({

        //     dom: 'Bfrtip',
        //     "buttons": [
        //       'excel'
        //     ]
        //   });
        // });


        //Thời Gian
        function time() {
            var today = new Date();
            var weekday = new Array(7);
            weekday[0] = "Chủ Nhật";
            weekday[1] = "Thứ Hai";
            weekday[2] = "Thứ Ba";
            weekday[3] = "Thứ Tư";
            weekday[4] = "Thứ Năm";
            weekday[5] = "Thứ Sáu";
            weekday[6] = "Thứ Bảy";
            var day = weekday[today.getDay()];
            var dd = today.getDate();
            var mm = today.getMonth() + 1;
            var yyyy = today.getFullYear();
            var h = today.getHours();
            var m = today.getMinutes();
            var s = today.getSeconds();
            m = checkTime(m);
            s = checkTime(s);
            nowTime = h + " giờ " + m + " phút " + s + " giây";
            if (dd < 10) {
                dd = '0' + dd
            }
            if (mm < 10) {
                mm = '0' + mm
            }
            today = day + ', ' + dd + '/' + mm + '/' + yyyy;
            tmp = '<span class="date"> ' + today + ' - ' + nowTime +
                    '</span>';
            document.getElementById("clock").innerHTML = tmp;
            clocktime = setTimeout("time()", "1000", "Javascript");

            function checkTime(i) {
                if (i < 10) {
                    i = "0" + i;
                }
                return i;
            }
        }
        //In dữ liệu
        var myApp = new function () {
            this.printTable = function () {
                var tab = document.getElementById('sampleTable');
                var win = window.open('', '', 'height=700,width=700');
                win.document.write(tab.outerHTML);
                win.document.close();
                win.print();
            }
        }
        //     //Sao chép dữ liệu
        //     var copyTextareaBtn = document.querySelector('.js-textareacopybtn');

        // copyTextareaBtn.addEventListener('click', function(event) {
        //   var copyTextarea = document.querySelector('.js-copytextarea');
        //   copyTextarea.focus();
        //   copyTextarea.select();

        //   try {
        //     var successful = document.execCommand('copy');
        //     var msg = successful ? 'successful' : 'unsuccessful';
        //     console.log('Copying text command was ' + msg);
        //   } catch (err) {
        //     console.log('Oops, unable to copy');
        //   }
        // });


        //Modal
        $("#show-emp").on("click", function () {
            $("#ModalUP").modal({backdrop: false, keyboard: false})
        });
        </script>
    </body>
</html>
