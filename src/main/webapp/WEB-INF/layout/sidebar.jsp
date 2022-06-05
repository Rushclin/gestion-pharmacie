<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
			</ul>
			<!-- debut de gestion de categorie -->
					<div class="pcoded-navigation-label"> Gestion Categorie</div>
			<ul class="pcoded-item pcoded-left-item">
				<li class="pcoded-hasmenu">
					<a href="javascript:void(0)" class="waves-effect waves-dark"> 
						<span class="pcoded-micon">
							<i class="feather icon-box"></i>
						</span> 
						<span class="pcoded-mtext">Categorie</span>
					</a>
					<ul class="pcoded-submenu">

						<li class=" "><a href="<c:url value="/?action=categorie"/>" class="waves-effect waves-dark"> <span class="pcoded-mtext">Liste</span>
						</a></li>
						<li class=" "><a href="<c:url value="/?action=nouvelleCategorie"/>" class="waves-effect waves-dark"> <span class="pcoded-mtext">Nouvelle categorie
							</span>
						</a></li>
					</ul>
				</li>
			</ul>
			
				<!--fin de la gestion de la categorie  -->
		</div>
	</div>
</nav>
<!-- [ navigation menu ] end -->
