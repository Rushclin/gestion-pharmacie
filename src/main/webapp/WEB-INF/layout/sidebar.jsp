<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- [ navigation menu ] start -->
<nav class="pcoded-navbar">
	<div class="nav-list">
		<div class="pcoded-inner-navbar main-menu">
			<div class="pcoded-navigation-label">Element</div>
			<ul class="pcoded-item pcoded-left-item">
				<li class="pcoded-hasmenu">
					<a href="javascript:void(0)" class="waves-effect waves-dark"> 
						<span class="pcoded-micon">
							<i class="feather icon-box"></i>
						</span> 
						<span class="pcoded-mtext">Form</span>
					</a>
					<ul class="pcoded-submenu">

						<li class=" "><a href="<c:url value="/?action=form"/>" class="waves-effect waves-dark"> <span class="pcoded-mtext">Form</span>
						</a></li>
						<li class=" "><a href="#" class="waves-effect waves-dark"> <span class="pcoded-mtext">Sous exemple 2
							</span>
						</a></li>
					</ul>
				</li>
				
				<!-- creation menu client -->
				<li class="pcoded-hasmenu">
					<a href="javascript:void(0)" class="waves-effect waves-dark"> 
						<span class="pcoded-micon">
							<i class="feather icon-box"></i>
						</span> 
						<span class="pcoded-mtext">Client</span>
					</a>
					<ul class="pcoded-submenu">

						<li class=" "><a href="<c:url value="/?action=clients"/>" class="waves-effect waves-dark"> <span class="pcoded-mtext">Liste des clients</span>
						</a></li>
						<li class=" "><a href="<c:url value="/?action=addclient"/>" class="waves-effect waves-dark"> <span class="pcoded-mtext">Ajouter un client</span>
						</a></li>
					</ul>
				</li>
			</ul>

		</div>
	</div>
</nav>
<!-- [ navigation menu ] end -->
