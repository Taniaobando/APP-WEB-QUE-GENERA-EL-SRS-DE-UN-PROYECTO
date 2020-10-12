<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 
  Project:Sigere
  Developer:Verónica Tofiño
  Contact email:veronicatofino@gmail.com
  Creation date: 15/05/2019
  Last modification: 31/05/2019
  -->
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Bootstrap CSS -->
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">			
	<title>Enviar nueva nota</title>
	<style>
		body{
			background-color: #990000;
		}
		.contact{
			padding: 4%;
			height: 400px;
		}
		.col-md-3{
			background: #5B616A;
			padding: 4%;
			border-top-left-radius: 0.5rem;
			border-bottom-left-radius: 0.5rem;
		}
		.contact-info{
			margin-top:10%;
			text-align:center;
		}
		.contact-info img{
			margin-bottom: 15%;
		}
		.contact-info h2{
			margin-bottom: 10%;
		}
		.col-md-9{
			background: #fff;
			padding: 3%;
			border-top-right-radius: 0.5rem;
			border-bottom-right-radius: 0.5rem;
		}
		.contact-form label{
			font-weight:600;
		}
		.contact-form button{
			background: black;
			color: #fff;
			font-weight: 600;
			width: 25%;
		}
		.contact-form button:focus{
			box-shadow:none;
		}
	</style>
</head>
<body>
<!-- All the bootstrap of the create note was took from: https://bootsnipp.com/snippets/qr1zR -->
<div class="container contact">
	<div class="row">
		<div class="col-md-3">
			<div class="contact-info">
				<img src="https://image.ibb.co/kUASdV/contact-image.png" alt="image"/>
				<h2>Enviar una nueva nota</h2>
				<h4>¡Envía una nota para otro miembro de tu proyecto!</h4>
			</div>
		</div>
		<div class="col-md-9">
			<form:form id="createNote" modelAttribute="object" action="enviarnota" method="post">            
				<div class="contact-form">
					<div class="form-group">
					  <label class="control-label col-sm-2" for="receiver">Nombre de usuario:</label>
					  <div class="col-sm-10">
						<input type="text" class="form-control" id="receiver" placeholder="Ingrese el nombre del usuario..." name="receiver">
					  </div>
					</div>
					<div class="form-group">
					  <label class="control-label col-sm-2" for="nte">Nota:</label>
					  <div class="col-sm-10">
						<textarea class="form-control" rows="5" id="nte" name="nte"></textarea>
					  </div>
					</div>
					<input type="hidden" id="idd" name="id">
					<div class="form-group">        
					  <div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Enviar</button>
						<button type="button" id="idForm" class="btn btn-default">Cancelar</button>
					  </div>
					</div>
				</div>
				<script>
					function getQueryVariable(){
						var query = window.location.search.substring(1);
						var vars = query.split("&");
						for (var i=0;i<vars.length;i++) {
							var pair = vars[i].split("=");
						    if(pair[0] == "id")
						    	var id=pair[1];
						    	{return id}
						}
						return(false);
					}
					document.getElementById("idd").value = getQueryVariable();
					document.getElementById("idForm").onclick= function(){
						location.href="http://localhost:8080/sigere/proyecto?id="+ getQueryVariable();
					}
				</script>
			</form:form>
		</div>
	</div>
</div>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>
