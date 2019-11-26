<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h1>Create Product</h1>
	<form class="form-group" action="CreateServlet" method="POST">
	
		<div class="input-group">
			<div class="input-group-prepend">
				<div class="input-group-text">Id</div>
			</div>
			<input class="form-control" type="text" id="txtIdProduct" name="txtIdProduct" disabled placeholder="Id Product Generated Automatically">
		</div>
		
		<div class="input-group">
			<div class="input-group-prepend">
				<div class="input-group-text">Name</div>
			</div>
			<input class="form-control" type=text id="txtProductName" name="txtProductName" placeholder="Product Name" required>
		</div>

		<div class="input-group">
			<div class="input-group-prepend">
				<div class="input-group-text">Price</div>
			</div>
			<input class="form-control" type="text" id="txtProductPrice" name="txtProductPrice" placeholder="Product Price">
		</div>
					  
		<p>
			<input class="btn btn-danger" type="submit" value="Add Product">
		</p>
	</form>
	
	<a href="index.jsp"><input class="btn btn-success" type="button" value="Return"></a>
		
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>