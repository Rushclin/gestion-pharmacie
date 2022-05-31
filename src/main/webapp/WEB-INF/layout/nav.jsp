<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<title>Gestion pharmacie</title>
		<!--  Inclusion du CSS du template  -->
		<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">
    	<link href="https://fonts.googleapis.com/css?family=Quicksand:500,700" rel="stylesheet">
		<style>
			<%@ include file="../assets/bower_components/bootstrap/css/bootstrap.min.css" %>
			<%@ include file="../assets/inc/pages/waves/css/waves.min.css" %>
			<%@ include file="../assets/inc/icon/feather/css/feather.css" %>
			<%@ include file="../assets/inc/icon/font-awesome/css/font-awesome.min.css" %>
			<%@ include file="../assets/bower_components/chartist/css/chartist.css" %>
			<%@ include file="../assets/inc/css/style.css" %>
			<%@ include file="../assets/inc/css/widget.css" %>
			<%@ include file="../assets/inc/css/pages.css" %>
			<%@ include file="../assets/inc/css/component.css" %>
		</style>
		
	</head>
	<body>
	
	<!-- [ Pre-loader ] start -->

    <!-- [ Pre-loader ] end -->
    <div id="pcoded" class="pcoded">
        <div class="pcoded-overlay-box"></div>
        <div class="pcoded-container navbar-wrapper">
            <!-- [ Header ] start -->
            <nav class="navbar header-navbar pcoded-header">
                <div class="navbar-wrapper">
                    <div class="navbar-logo">
                        <a href="index.html">
                        <!--  Logo ici -->
                            <!-- <img class="img-fluid" src="files/assets/images/logo.png" alt="Theme-Logo" /> -->
                            PHARMACIE DU CENTRE
                        </a>
                        <a class="mobile-menu" id="mobile-collapse" href="#!">
                            <i class="feather icon-menu icon-toggle-right"></i>
                        </a>
                        <a class="mobile-options waves-effect waves-light">
                            <i class="feather icon-more-horizontal"></i>
                        </a>
                    </div>
                    <div class="navbar-container container-fluid">
                        <ul class="nav-left">
                            <li class="header-search">
                                <div class="main-search morphsearch-search">
                                    <div class="input-group">
                                        <span class="input-group-prepend search-close">
										<i class="feather icon-x input-group-text"></i>
									</span>
                                        <input type="text" class="form-control" placeholder="Enter Keyword">
                                        <span class="input-group-append search-btn">
										<i class="feather icon-search input-group-text"></i>
									</span>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <a href="#!" onclick="javascript:toggleFullScreen()" class="waves-effect waves-light">
                                <i class="full-screen feather icon-maximize"></i>
                            </a>
                            </li>
                        </ul>
                        <ul class="nav-right">
                            <li class="user-profile header-notification">

                                <div class="dropdown-primary dropdown">
                                    <div class="dropdown-toggle" data-toggle="dropdown">
                                        <span>John Doe</span>
                                        <i class="feather icon-chevron-down"></i>
                                    </div>
                                    <ul class="show-notification profile-notification dropdown-menu" data-dropdown-in="fadeIn" data-dropdown-out="fadeOut">
                                        <li>
                                            <a href="#!">
                                            <i class="feather icon-settings"></i> Parametres

                                        </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                            <i class="feather icon-user"></i> Profil
                                        </a>
                                        </li>
                                        <li>
                                            <a href="email-inbox.html">
                                            <i class="feather icon-mail"></i> Messages
                                        </a>
                                        </li>
                                        <li>
                                            <a href="auth-sign-in-social.html">
                                            <i class="feather icon-log-out"></i> Quitter
                                        </a>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            
