<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="base.jsp"%>
</head>
<body>
<div class="row">
	<div class="col-md-6 offset-md-3">
		<h1 class="text-center mb-3">Update Product Details</h1>
		<form action="${pageContext.request.contextPath}/handle-product" method="post">
		    
			<div class="form-group">
			    <label for="id">Product Id</label>
			    <input type="number" class="form-control" name="id"  value="${product.id }" />
		    </div>
			<div class="form-group">
			    <label for="name">Product Name</label>
			    <input type="text" class="form-control" name="name" id="name" aria-describedby="emailHelp" placeholder="Enter the product name" value="${product.name }">
		    </div>
		    
		    <div class="form-group">
			    <label for="description">Product Description</label>
			    <textarea class="form-control" name="description" id="description" row="5" placeholder="Enter the product description">${product.description }</textarea>
		    </div>
		    
		    <div class="form-group">
			    <label for="description">Product Price</label>
			    <input type="text" class="form-control" name="price" id="price" placeholder="Enter the product price" value="${product.price }">
		    </div>
			
			<div class="container text-center" >
				<a href="${pageContext.request.contextPath }/" class="btn btn-outline-danger">Back</a>
				<button type="submit" class="btn btn-warning">Update</button>
			</div>
		</form>
	</div>
</div>

</body>
</html>