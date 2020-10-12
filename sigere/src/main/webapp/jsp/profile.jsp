<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 
  Project:Sigere
  Developer:Verónica Tofiño
  Contact email:veronicatofino@gmail.com
  Creation date: 05/06/2019
  Last modification: 05/06/2019
  -->
<html>
	<head>
		<title>Perfil</title>
			    <meta charset="utf-8">
			    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		
		<!------ Include the above in your HEAD tag ---------->
		
		<!--
		-->
		<style>
			body {
			  background: rgb(204, 51, 51);
			}
			
			/* Profile container */
			.profile {
			  margin: 20px 0;
			}
			
			/* Profile sidebar */
			.profile-sidebar {
			  padding: 20px 0 10px 0;
			  background: #fff;
			}
			
			.profile-userpic img {
			  float: none;
			  margin: 0 auto;
			  width: 50%;
			  height: 50%;
			  -webkit-border-radius: 50% !important;
			  -moz-border-radius: 50% !important;
			  border-radius: 50% !important;
			}
			
			.profile-usertitle {
			  text-align: center;
			  margin-top: 20px;
			}
			
			.profile-usertitle-name {
			  color: #5a7391;
			  font-size: 16px;
			  font-weight: 600;
			  margin-bottom: 7px;
			}
			
			.profile-usertitle-job {
			  color: #5b9bd1;
			  font-size: 12px;
			  font-weight: 600;
			  margin-bottom: 15px;
			}
			
			.profile-userbuttons {
			  text-align: center;
			  margin-top: 10px;
			}
			
			.profile-userbuttons .btn {
			  text-transform: uppercase;
			  font-size: 11px;
			  font-weight: 600;
			  padding: 6px 15px;
			  margin-right: 5px;
			}
			
			.profile-userbuttons .btn:last-child {
			  margin-right: 0px;
			}
			    
			.profile-usermenu {
			  margin-top: 30px;
			}
			
			.profile-usermenu ul li {
			  border-bottom: 1px solid #f0f4f7;
			}
			
			.profile-usermenu ul li:last-child {
			  border-bottom: none;
			}
			
			.profile-usermenu ul li a {
			  color: #93a3b5;
			  font-size: 14px;
			  font-weight: 400;
			}
			
			.profile-usermenu ul li a i {
			  margin-right: 8px;
			  font-size: 14px;
			}
			
			.profile-usermenu ul li a:hover {
			  background-color: #fafcfd;
			  color: #5b9bd1;
			}
			
			.profile-usermenu ul li.active {
			  border-bottom: none;
			}
			
			.profile-usermenu ul li.active a {
			  color: #5b9bd1;
			  background-color: #f6f9fb;
			  border-left: 2px solid #5b9bd1;
			  margin-left: -2px;
			}
			
			/* Profile Content */
			.profile-content {
			  padding: 20px;
			  background: #fff;
			  min-height: 415px;
			}
			.btn-lg, .btn-info, .btn-lg:visited, .bt-info:visited,.btn-lg:focus, .bt-info:focus,.btn-lg:active, .bt-info:active{
						
			  background-color: black;
			  color: white;
	          border-color: black;
			
			}
	        
	        .btn-lg:hover, .btn-info:hover{
	        	background-color: black;
			  	color: white;
	         	border-color: black;
	        }
		</style>
	</head>
	
	<body>
	<div class="container">
	    <div class="row profile">
			<div class="col-md-3">
				<div class="profile-sidebar">
					<!-- SIDEBAR USERPIC -->
					<div class="profile-userpic">
						<img src="https://static.change.org/profile-img/default-user-profile.svg" class="img-responsive" alt="">
					</div>
					<!-- END SIDEBAR USERPIC -->
					<!-- SIDEBAR USER TITLE -->
					<div class="profile-usertitle">
						<div class="profile-usertitle-name">
							${firstname } ${lastname }
						</div>
						<div class="profile-usertitle-job">
							${email }
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-9">
	            <div class="profile-content">
	            	<h3 style="text-align:center;">¡Tu información!</h3>
	            	<br>
	            	<form:form id="actInfo" action="actualizarperfil" method="post" >
				  	<div class="row">
						<div class="col-sm-6 form-group">
							<label>Nombre</label>
							<input type="text" value=${firstname } name="firstname" class="form-control" disabled>
						</div>	
						<div class="col-sm-6 form-group">
							<label>Apellido</label>
							<input type="text" value=${lastname } name="lastname" class="form-control" disabled>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6 form-group">
							<label>Email</label>
							<input type="email" value=${email } name="email" class="form-control" disabled>
						</div>	
						<div class="col-sm-6 form-group">
							<label>Contraseña</label>
							<input type="password" value=${password } name="password" class="form-control" disabled>
							<br>
							<br>
						</div>	
					</div>
					<div class="row">
						<div class="btnn" style="text-align:center">
	                            <button type="submit" class="btn btn-lg btn-info">Aceptar</button>
						</div>
					</div>
					</form:form>
	            </div>
			</div>
		</div>
	</div>
	<footer class="footer mt-6">
	  <div class="bg-gray-light">
	    <div class="container-xl p-responsive f6 py-4 d-sm-flex flex-justify-between flex-row-reverse flex-items-center">
	      <ul class="list-style-none d-flex text-gray" style="text-align:center; list-style-type:none">
	        <li class="mr-3">Copyright © 2019 Sigere</li>
	      </ul>
	    </div>
	  </div>
	</footer>
	<br>
	<br>
	</body>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
</html>