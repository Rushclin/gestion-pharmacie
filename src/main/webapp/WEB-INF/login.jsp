<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">
    	<link href="https://fonts.googleapis.com/css?family=Quicksand:500,700" rel="stylesheet">
		<style>
			<%@ include file="assets/bower_components/bootstrap/css/bootstrap.min.css" %>
			<%@ include file="assets/inc/pages/waves/css/waves.min.css" %>
			<%@ include file="assets/inc/icon/feather/css/feather.css" %>
			<%@ include file="assets/inc/icon/font-awesome/css/font-awesome.min.css" %>
			<%@ include file="assets/bower_components/chartist/css/chartist.css" %>
			<%@ include file="assets/inc/css/style.css" %>
			<%@ include file="assets/inc/css/widget.css" %>
			<%@ include file="assets/inc/css/pages.css" %>
			<%@ include file="assets/inc/css/component.css" %>
		</style>
		
	</head>
	<body>
	
	
	<section class="login-block">
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-12">
                    <form class="md-float-material form-material" method="POST" action="?action=dashboard">
                        <div class="text-center">
                            <h3>PHARMACIE DU CENTRE</h3>
                        </div>
                        <div class="auth-box card">
                            <div class="card-block">
                                <div class="row m-b-20">
                                    <div class="col-md-12">
                                        <h3 class="text-center txt-primary">CONNEXION</h3>
                                    </div>
                                </div>
                                <p class="text-muted text-center p-b-5">Bienvenue cher fidele utilisateur</p>
                                <div class="form-group form-primary">
                                    <input type="text" name="login" class="form-control" required="">
                                    <span class="form-bar"></span>
                                    <label class="float-label">Login ou email</label>
                                </div>
                                <div class="form-group form-primary">
                                    <input type="password" name="password" class="form-control" required="">
                                    <span class="form-bar"></span>
                                    <label class="float-label">Mot de passe</label>
                                </div>
                                <div class="row m-t-25 text-left">
                                    <div class="col-12">
                                        <div class="checkbox-fade fade-in-primary">
                                            <label>
                                                <input type="checkbox" value="">
                                                <span class="cr">
                                                	<i class="cr-icon icofont icofont-ui-check txt-primary"></i>
                                                </span>
                                                <span class="text-inverse">Se souvenir de moi</span>
                                            </label>
                                        </div>
                                        <div class="forgot-phone text-right float-right">
                                            <a href="#" class="text-right f-w-600"> Mot de passe oublie?</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="row m-t-30">
                                    <div class="col-md-12">
                                        <button type="submit" class="btn btn-primary btn-md btn-block waves-effect text-center m-b-20">SE CONNECTER</button>
                                        
                                    </div>
                                </div>
                                <p class="text-inverse text-left">Pas de compte, cree le <a href="#"> <b> ici </b></a></p>
                            </div>
                        </div>
                    </form>
                    </div>
                </div>
            </div>
    </section>
    





	<script>
		<%@ include file="assets/bower_components/jquery/js/jquery.min.js" %>
		<%@ include file="assets/bower_components/jquery-ui/js/jquery-ui.min.js" %>
		<%@ include file="assets/bower_components/popper.js/js/popper.min.js" %>
		<%@ include file="assets/bower_components/bootstrap/js/bootstrap.min.js" %>
		
		<%@ include file="assets/inc/pages/waves/js/waves.min.js" %>

		<%@ include file="assets/bower_components/jquery-slimscroll/js/jquery.slimscroll.js" %>
		
		<%@ include file="assets/inc/pages/chart/float/jquery.flot.js" %>
		<%@ include file="assets/inc/pages/chart/float/jquery.flot.categories.js" %>
		<%@ include file="assets/inc/pages/chart/float/curvedLines.js" %>
		<%@ include file="assets/inc/pages/chart/float/jquery.flot.tooltip.min.js" %>
			
		<%@ include file="assets/inc/pages/widget/amchart/amcharts.js" %>
		<%@ include file="assets/inc/pages/widget/amchart/serial.js" %>
		<%@ include file="assets/inc/pages/widget/amchart/light.js" %>
		
		<%@ include file="assets/inc/js/pcoded.min.js" %>
		<%@ include file="assets/inc/js/vertical/vertical-layout.min.js" %>
		<%@ include file="assets/inc/pages/dashboard/custom-dashboard.min.js" %>
		
		<%@ include file="assets/inc/js/script.min.js" %>
	</script>
	<script type="javascript" scr="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.29.0/feather.js"></script>
	
	</body>
</html>