<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Welcome to Blood Donor Group</title>
	</head>
	<body>
	<div class="container mt-4">
		<h2 class="bg-success text-center text-white p-3 rounded"><a href="${pageContext.request.contextPath}/donor/list" class="text-white headerLink">Donor List</a></h2>

		<!-- put button: Add Donor -->
		<input type="button" class="btn btn-outline-info" value="Add Donor" onclick="window.location.href='addDonorForm'; return false;"/>
		<!--  add a search box -->
        <form:form action="search" method="POST" cssClass="form-inline mt-3 mb-4">
			<div class="input-group mb-2 mr-sm-2">
			    <div class="input-group-prepend">
			      <div class="input-group-text"><i class="fa fa-search" aria-hidden="true"></i></div>
			    </div>
			    <input type="text" class="form-control" placeholder="Search By State/City" name="theSearchName">
			    <input type="submit" value="Search" class="btn btn-info ml-2" />
			</div>
        </form:form>
			<!-- add html table here -->
		<table class="table text-center table-striped mt-3 table-bordered" border="1">
			<tr class="table-success">
				<th>#</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Mobile Number</th>
				<th>State</th>
				<th>City</th>
				<th>Blood Group</th>
				<th colspan="2">Action</th>
			</tr>
			<!-- loop over and print donors -->
			<c:set var="index" value="0" />
			<c:forEach var="donor" items="${donors }">
				<!-- construct an "update" link with donor id -->
				<c:url var="updateLink" value="/donor/updateDonorForm">
					<c:param name="donorId" value="${donor.id}"></c:param>
				</c:url>

				<!-- construct an "delete" link with donor id -->
				<c:url var="deleteLink" value="/donor/delete">
					<c:param name="donorId" value="${donor.id}"></c:param>
				</c:url>

				<c:set var="index" value="${index + 1}" />
				<tr>
					<td>${index}</td>
					<td>${donor.firstName}</td>
					<td>${donor.lastName}</td>
					<td>${donor.email}</td>
					<td>${donor.mobileNumber}</td>
					<td>${donor.state}</td>
					<td>${donor.city}</td>
					<td>${donor.bloodGroup}</td>
					<td>
						<!-- display the update link -->
						<a href="${updateLink}" class="btn btn-info btn-sm">Update</a>
					</td>
					<td>
						<a href="${deleteLink}" class="btn btn-danger btn-sm" onclick="if (!(confirm('Are you sure you want to delete this donor?'))) return false">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</body>
</html>