<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round"
    />
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
    />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/icon?family=Material+Icons"
    />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
    />
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  </head>
  <body>
    <style>
      body {
        font-family: "Varela Round", sans-serif;
      }

      .modal-confirm {
        color: #636363;
        width: 325px;
        font-size: 14px;
      }

      .modal-confirm .modal-content {
        padding: 20px;
        border-radius: 5px;
        border: none;
      }

      .modal-confirm .modal-header {
        border-bottom: none;
        position: relative;
      }

      .modal-confirm h4 {
        text-align: center;
        font-size: 26px;
        margin: 30px 0 -15px;
      }

      .modal-confirm .form-control,
      .modal-confirm .btn {
        min-height: 40px;
        border-radius: 3px;
      }

      .modal-confirm .close {
        position: absolute;
        top: -5px;
        right: -5px;
      }

      .modal-confirm .modal-footer {
        border: none;
        text-align: center;
        border-radius: 5px;
        font-size: 13px;
      }
      .btn.btn-success.btn-block{
          background-color: #f24137;
      }
      .modal-confirm .icon-box {
        color: #fff;
        position: absolute;
        margin: 0 auto;
        left: 0;
        right: 0;
        top: -70px;
        width: 95px;
        height: 95px;
        border-radius: 50%;
        z-index: 9;
        background: #f24137;
        padding: 15px;
        text-align: center;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
      }

      .modal-confirm .icon-box i {
        font-size: 58px;
        position: relative;
        top: 3px;
      }    
      .modal-confirm.modal-dialog {
        margin-top: 80px;
      }

      .modal-confirm .btn {
        color: #fff;
        border-radius: 4px;
        background: #82ce34;
        text-decoration: none;
        transition: all 0.4s;
        line-height: normal;
        border: none;
      }

      .modal-confirm .btn:hover,
      .modal-confirm .btn:focus {
        background: #6fb32b;
        outline: none;
      }

      .trigger-btn {
        display: inline-block;
        margin: 100px auto;
      }
    </style>
    <div class="text-center">
      <!-- Button HTML (to Trigger Modal) -->
      <a href="#myModal" class="trigger-btn" data-toggle="modal"
        >Click to Open Confirm Modal
      </a>
    </div>

    <!-- Modal HTML -->
    <div id="myModal" class="modal fade">
      <div class="modal-dialog modal-confirm">
        <div class="modal-content">
          <div class="modal-header">
            <div class="icon-box">
              <i class="material-icons">&#xE876;</i>
            </div>
            <h4 class="modal-title w-100">Hoàn thành</h4>
          </div>
          <div class="modal-body">
            <p class="text-center">
              Đăng kí tài khoản thành công!
            </p>
          </div>
          <div class="modal-footer">
            <button class="btn btn-success btn-block" data-dismiss="modal">
              OK
            </button>
          </div>
        </div>
      </div>
    </div>
    <script>
      $(document).ready(function () {
        $("#myModal").modal("show");
        $(".trigger-btn").click(); // trigger click event on the button
      });
    </script>
    
  </body>
</html>