
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Crud</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    <body>
        <div class="container">
            
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="editproduct" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">Edit Product</h4>
                     
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>ID</label>
                                    <input value="${p.productID}" name="id" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>Category</label>
                                    <select name="category" class="form-select" aria-label="Default select example">
                                     <c:forEach items="${categoriesList}" var="c">
                                            <option ${(p.categories.categoryID == c.categoryID)?"selected":""} value="${c.categoryID}">${c.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Name</label>
                                    <input value="${p.name}" name="name" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Description</label>
                                    <textarea name="description" class="form-control" required>${p.desciption}</textarea>
                                </div>
                                <div class="form-group">
                                    <label>Image</label>
                                    <input value="${p.picture}" name="image" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Image2</label>
                                    <input value="${p.picture2}" name="image2" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Image3</label>
                                    <input value="${p.picture3}" name="image3" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Quantity</label>
                                    <input value="${p.quantity}" name="quantity" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Price</label>
                                    <input value="${p.price}" name="price" type="text" class="form-control" required>
                                </div>
                                <<div class="form-group">
                                    <label>Status</label>
                                    <input value="${p.status}" name="status" type="text" class="form-control" required>
                                </div>
                                
                               
                                        <c:forEach items="${listCategories}" var="o">
                                            <option ${(product.categoryId == o.cid)?"selected":""} value="${o.cid}">${o.cname}</option>
                                        </c:forEach>
                                            
                                    </select>
                                </div>


                            <div class="modal-footer">
                                <input type="submit" class="btn btn-success" value="Edit">
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>


        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>

