<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!-- 
  Project:Sigere
  Developer:Verónica Tofiño
  Contact email: veronicatofino@gmail.com
  Creation date: 01/05/2019
  Last modification: 15/05/2019
  -->


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	
	<title>Crear Requerimiento</title>
	<style>
		body {
		  padding-top: 20px;
		  padding-bottom: 20px;
		  background-color:#ffffff;
		}
		
		input[type="radio"]{
  			margin: 0px 0px 0px 18px;
		}
		
		/* Everything but the jumbotron gets side spacing for mobile first views */
		.header,
		.marketing,
		.footer {
		  padding-right: 15px;
		  padding-left: 15px;
		}
		
		/* Custom page header */
		.header {
		  border-bottom: 1px solid #e5e5e5;
		}
		/* Make the masthead heading the same height as the navigation */
		.header h3 {
		  padding-bottom: 19px;
		  margin-top: 0;
		  margin-bottom: 0;
		  line-height: 40px;
		}
		
		/* Custom page footer */
		.footer {
		  padding-top: 19px;
		  color: #777;
		  border-top: 1px solid #e5e5e5;
		}
		
		/* Customize container */
		@media (min-width: 768px) {
		  .container {
		    max-width: 730px;
		  }
		}
		.container-narrow > hr {
		  margin: 30px 0;
		}
		
		/* Main marketing message and sign up button */
		.jumbotron {
		  text-align: center;
		  border-bottom: 1px solid #e5e5e5;
		}
		.jumbotron .btn {
		  padding: 14px 24px;
		  font-size: 21px;
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
		
		/* Supporting marketing content */
		.marketing {
		  margin: 40px 0;
		}
		.marketing p + h4 {
		  margin-top: 28px;
		}
		
		.well{
			
		
		}
		
		/* Responsive: Portrait tablets and up */
		@media screen and (min-width: 768px) {
		  /* Remove the padding we set earlier */
		  .header,
		  .marketing,
		  .footer {
		    padding-right: 0;
		    padding-left: 0;
		  }
		  /* Space out the masthead */
		  .header {
		    margin-bottom: 30px;
		  }
		  /* Remove the bottom border on the jumbotron for visual effect */
		  .jumbotron {
		    border-bottom: 0;
		  }
		  .btn-primary,
	      .btn-primary:hover,
	      .btn-primary:active,
	      .btn-primary:visited,
	      .btn-primary:focus {
	          background-color: #990000;
	          border-color:  #990000;
	      }
	   	}
	   	
	   	textarea {
		   resize: none;
		}
	</style>
<!------ Include the above in your HEAD tag ---------->
<body>
	<div class="container">
	    <h1 class="well">Crear Nuevo Requerimiento</h1>
		<div class="col-lg-12 well">
			<div class="row">
					<form:form id="regReq" modelAttribute="object" action="crearrequerimiento" method="post" enctype="multipart/form-data">
						<div class="col-sm-12">
							<div class="row">
								<div class="col-sm-6 form-group">
									<label>Id</label>
									<input type="text" placeholder="Escriba el id..." name="reqId" class="form-control" required>
								</div>	
								<div class="col-sm-6 form-group">
									<label>Tipo</label>
									<select name="type" class="form-control">
			                            <option value="RF">Requerimiento Funcional</option>
			                            <option value="RNF">Requerimiento No Funcional</option>
	                        		</select>
								</div>
							</div>
							<div class="row">	
								<div class="col-sm-6 form-group">
									<label>Nombre</label>
									<input type="text" placeholder="Escriba el nombre..." name="name" class="form-control" required>
								</div>	
								<div class="col-sm-6 form-group">
    								<label>Versión</label>
    								<input type="text" placeholder="Escriba la versión..." name="version" class="form-control" required>
    							</div>
							</div>	
							<div class="row">
								<div class="col-sm-6 form-group">
									<label>Descripción</label>
									<textarea name="description" placeholder="Escriba la descripción" rows="5" class="form-control" required></textarea>
								</div>
								<div class="col-sm-6 ">
                                	<center>
									<img src="https://i.ibb.co/jD4yfCp/req.png"  width="140" height="150" align="center">
                                    </center>
								</div>	

							</div>
							<div class="row">
			    				<div class="a">
			    					<label>Diagrama de secuencia</label>
			    					<!-- <input type="file" id="input-file-now" class="file-upload" name="contextDiagram"/><br> -->
				    				<pre>
										Name: <input type="text" name="nameDiagram">					
										Photo: <input type="file" name="image">
										<!--  <input type="submit" value="Submit">-->
									</pre>
			    				</div>
			    			</div>
								
							<input type="hidden" name="status" value="creado">	
							<input type="hidden" id="projId" name="projectId">
  							<input type="hidden" id="idd" name="id">
							<div class="row" style="align:center; padding-top:10px" >
                            	<center>
                                  <div class="col-sm-5">
                                      <button type="submit" class="btn btn-lg btn-info">Aceptar</button>
                                  </div>
                                  <div class="col-sm-5 ">
                                      <button type="button" id="idForm" class="btn btn-lg btn-info">Cancelar</button>
                                  </div>
                                  
                                </center>
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
								document.getElementById("projId").value=getQueryVariable();
								document.getElementById("idForm").onclick= function(){
									location.href="http://localhost:8080/sigere/proyecto?id="+ getQueryVariable();
								}
							</script>
						</div>
					</form:form> 
			</div>
		</div>
	</div>
	<script>
		
	</script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>
