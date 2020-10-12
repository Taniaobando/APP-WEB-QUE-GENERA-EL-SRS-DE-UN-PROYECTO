<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 
  Project:Sigere
  Developer:Laura Arango
  Contact email: lauarangom@gmail.com
  Creation date: 30/04/2019
  Last modification: 15/05/2019
  -->
<!doctype html>
<html>
<head>
	<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<title>Creación de proyecto</title>
    <style>
		body{
		    background-color: #525252;
		}
		.centered-form{
			margin-top: 60px;
		}
		
		.centered-form .panel{
			background: rgba(255, 255, 255, 0.8);
			box-shadow: rgba(0, 0, 0, 0.3) 20px 20px 20px;
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
        h3 {
        	font-size:110%;
        }
    </style>
    
</head>
<body>
	<div class="container">
        <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
        	<div class="panel panel-default">
        		<div class="panel-heading">
			    		<h3 class="panel-title">Crear un nuevo proyecto </h3>
			 			</div>
			 			<div class="panel-body">
			    		<form:form id="regProject" modelAttribute="object" action="crearproyecto" method="post" enctype="multipart/form-data">
			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<p>Nombre:</p>
			                			<input type="text" name="name" id="name" class="form-control input-sm" placeholder="Escriba el nombre" required>
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<center>
									<img src="https://i.ibb.co/RYk6LNM/proyecto.png"  width="140" height="150" align="center">
                                    </center>
			    				</div>
			    			</div>
			    			<div class="form-group">
			    				<p>Descripción:</p>
			    				<textarea name="description" placeholder="Escriba la descripción" rows="5" class="form-control" required></textarea>
							</div>

			    			<div class="row">
			    				<div class="a">
			    					<!-- <input type="file" id="input-file-now" class="file-upload" name="contextDiagram"/><br> -->
			    				<pre>
									Name: <input type="text" name="nameDiagram">
									Photo: <input type="file" name="image">	
									<!--  <input type="submit" value="Submit">-->
								</pre>
			    				
			    				</div>
			    			</div>
			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<button type="submit" class="btn btn-lg btn-info">Aceptar</button>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					 <button type="button" id="idForm" class="btn btn-lg btn-info" onclick="window.location.href='http://localhost:8080/sigere/bienvenido?firstname=${firstname}'">Cancelar</button>
			    				</div>
			    			</div>
			
			    		</form:form>
			    		
						<!--<form action="guardarimagen" method="post" enctype="multipart/form-data">
						
						<pre>
								
							Name: <input type="text" name="name">
														
							Photo: <input type="file" name="image">
							
										
							<input type="submit" value="Submit">
						
						</pre>
						
						</form>-->
						
						
			    	</div>
	    		</div>
    		</div>
    	</div>
    </div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</body>
</html>