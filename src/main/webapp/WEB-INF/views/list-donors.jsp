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
               <form:form action="/search?page=0&size=5" method="GET" cssClass="form-inline mt-5 mb-5">
       			<div class="input-group mb-5 mr-sm-5">
       			    <div class="input-group-prepend">
       			      <div class="input-group-text"><i class="fa fa-search" aria-hidden="true"></i></div>
       			    </div>
       			    <input type="text" size = "26" class="form-control" placeholder="Search By State/City/Blood Group" name="theSearchName" value = "${theSearchName}">
       			    <input type="submit" value="Search" class="btn btn-info ml-2" />
       			</div>
               </form:form>

			<!-- add html table here -->
		<table class="table text-center table-striped mt-3 table-bordered" border="1">
			<tr class="table-success">
				<th>Sno. #</th>
				<th>First Name
				&nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=firstName,desc"> Desc </a>
                &nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=firstName"> Asc </a> 
				</th>
				<th>Last Name
				&nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=lastName,desc"> Desc </a>
                &nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=lastName"> Asc </a> </th>
				<th>Email
				&nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=email,desc"> Desc </a>
                &nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=email"> Asc </a> </th>
				<th>Mobile Number
				&nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=mobileNumber,desc"> Desc </a>
                &nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=mobileNumber"> Asc </a> </th>
				<th>Gender
				&nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=gender,desc"> Desc </a>
                &nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=gender"> Asc </a> </th>
				<th>State
				&nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=state,desc"> Desc </a>
                &nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=state"> Asc </a> </th>
				<th>City
				&nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=city,desc"> Desc </a>
                &nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=city"> Asc </a> </th>
				<th>Blood Group
				&nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=bloodGroup,desc"> Desc </a>
                &nbsp &nbsp <a href= "/list?page=0&size=5&theSearchName=${theSearchName}&sort=bloodGroup"> Asc </a> </th>
				<th colspan="2">Action</th>
			</tr>
			
			
			<!-- loop over and print donors -->
			<c:set var="index" value="${page * 5 + 1}" />

			<c:forEach var="donor" items="${donors}">
				<!-- construct an "update" link with donor id -->
				<c:url var="updateLink" value="/donor/updateDonorForm">
					<c:param name="donorId" value="${donor.id}"></c:param>
				</c:url>

				<!-- construct an "delete" link with donor id -->
				<c:url var="deleteLink" value="/donor/delete">
					<c:param name="donorId" value="${donor.id}"></c:param>
				</c:url>
				<tr>
                					<td>${index}</td>
                					<td>${donor.firstName}</td>
                					<td>${donor.lastName}</td>
                					<td>${donor.email}</td>
                					<td>${donor.mobileNumber}</td>
                					<td>${donor.gender}</td>
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

				<c:set var="index" value="${index + 1}" />
			</c:forEach>
		</table>
	</div>
	<br><br>
            	<c:choose>
                    <c:when test="${totalPage <= 0}">
                        No Records Found
                    </c:when>
                    <c:otherwise>
                        <c:forEach begin="0" end="${totalPage-1}" varStatus="loop">
                            &nbsp;&nbsp;<a href="/list?page=${loop.index}&size=5&theSearchName=${theSearchName}&sort=${sortBy}">${loop.index + 1}</a>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>


	
	</body>
</html>