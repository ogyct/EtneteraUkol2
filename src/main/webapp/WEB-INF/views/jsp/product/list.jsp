<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>etnShop</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<div class="container">
	<h2>Products</h2>
	<form name="product" method="post"> 
		<input name="searchText" type="text" value=""/>
		<input type="submit" value="Search" formaction="/etnshop/product/search"/>
		<input type="submit" value="Reset search result" formaction="/etnshop/product/list"/>
	</form>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Serial</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="product">
			<form name="product" method="post">
				<tr>
					<td><input name="id" type="text" value="${product.id}" readonly/></td>
					<td><input name="name" type="text" value="${product.name}"/> </td>
					<td><input name="serial" type="text" value="${product.serial}"/> </td>
					<td><input type="submit" value="UPDATE" formaction="/etnshop/product/update"/></td>
					<td><input type="submit" value="DELETE" formaction="/etnshop/product/delete"/></td>
					
				</tr>
				</form>
			</c:forEach>
				<form name="product" method="post">
				<tr>
					<td><input name="id" type="text" value="" readonly/></td>
					<td><input name="name" type="text" value=""/> </td>
					<td><input name="serial" type="text" value=""/> </td>
					<td><input type="submit" value="Create" formaction="/etnshop/product/insert"/></td>		
				</tr>
				</form>
		</tbody>
	</table>
	
	<hr>
	<p>
		<a class="btn btn-primary btn-lg" href="/etnshop" role="button">Back
			to homepage</a>
	</p>
	<footer>
		<p>&copy; Etnetera a.s. 2015</p>
	</footer>
</div>

<spring:url value="/resources/core/css/bootstrap.min.js"
	var="bootstrapJs" />

<script src="${bootstrapJs}"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>