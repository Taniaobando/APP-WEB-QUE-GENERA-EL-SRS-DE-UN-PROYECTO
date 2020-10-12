<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 
  Project:Sigere
  Developer:Verónica Tofiño
  Contact email:veronicatofino@gmail.com
  Creation date: 19/05/2019
  Last modification: 19/05/2019
  -->
<!doctype html>
<html>
	<head>
	    <title>Eliminar requerimiento</title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <!-- Bootstrap CSS -->
	    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
		<style>
/*-------------------------------------------------- Pop up ------------------------------------------------------------------------*/	        
		/* The Modal (background) */
			/* The Modal (background) */
			.modal {
				display:block;
			    position: fixed;
			    z-index: 1;
			    left: 0;
			    top: 0;
			    width: 100%;
			    height: 100%;
			    overflow: auto;
			    background-color: rgba(0,0,0,0.4);
			}
			
			/* Modal Content */
			.modal-content {
			    background-color: #fefefe;
			    margin: 4% auto 15% auto;
			    border: 1px solid #888;
			    width: 40%; 
				padding-bottom: 30px;
			}
			
			/* The Close Button (x) */
			.close {
			    position: absolute;
			    right: 25px;
			    top: 0;
			    color: #000;
			    font-size: 35px;
			    font-weight: bold;
			}
			.close:hover,.close:focus {
			    color: red;
			    cursor: pointer;
			}
			
			/* Add Zoom Animation */
			.animate {
			    animation: zoom 0.6s
			}
			@keyframes zoom {
			    from {transform: scale(0)} 
			    to {transform: scale(1)}
			}
			.btn, .btn:hover, .btn:active {
	          background-color:#333;
	          border: none;
	          color: white;
	          font-size: 20px;
	          cursor: pointer;
	          float:bottom;
	        }
/*----------------------------------------------------------------------------------------------------------------------------------*/

		</style>
	</head>
	<body>
	<!-- The Modal -->
		
		<div id="myModal" class="modal">
			<form:form id="deleteReq" action="eliminarrequerimiento" method="post">
			  <!-- Modal content -->
			  <div class="modal-content">
			    <div class="modal-header">
			      <span class="close">&times;</span>
			      <h2>Confirmación de eliminación</h2>
			    </div>
			    <div class="modal-body">
			      <p>¿Está seguro que desea eliminar el requerimiento <B>${reqId} ${name}</B> ?</p>
			    </div>
			    <input type="hidden" id="idd" name="id">
			    <input type="hidden" id="projectId" name="projectId" value=${projectId }>
			    <div class="modal-footer">
			        <button type="submit" class="btn ">Aceptar</button>
				    <button type="button" class="btn cancel" id="idForm">Cancelar</button>  
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
						location.href="http://localhost:8080/sigere/proyecto?id="+ ${projectId};
					}
				</script>
		  	   </div>
		    </form:form>
		</div>		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	  	
	</body>