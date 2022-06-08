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
						<li class=" ">
							<a href="#" class="waves-effect waves-dark"> 
								<span class="pcoded-mtext">Sous exemple 2</span>
							</a>
						</li>
					</ul>
				</li>
			</ul>
			<!--  Stock -->
			
			<div class="pcoded-navigation-label">Gerer le stock</div>
			<ul class="pcoded-item pcoded-left-item">
				<li class="pcoded-hasmenu">
					<a href="javascript:void(0)" class="waves-effect waves-dark"> 
						<span class="pcoded-micon">
							<i class="feather icon-box"></i>
						</span> 
						<span class="pcoded-mtext">Stock</span>
					</a>
					<ul class="pcoded-submenu">
						<li class=" ">
							<a href="<c:url value="/?action=stock"/>" class="waves-effect waves-dark"> 
								<span class="pcoded-mtext">Liste stock</span>
							</a>
						</li>
						<li class=" ">
							<a href="<c:url value="/?action=stock-new"/>" class="waves-effect waves-dark"> 
								<span class="pcoded-mtext">Nouveau stock</span>
							</a>
						</li>
					</ul>
				</li>
			</ul>
			<div class="pcoded-navigation-label">Gerer les fournisseurs</div>
			<ul class="pcoded-item pcoded-left-item">
				<li class="pcoded-hasmenu">
					<a href="javascript:void(0)" class="waves-effect waves-dark"> 
						<span class="pcoded-micon">
							<i class="feather icon-box"></i>
						</span> 
						<span class="pcoded-mtext">Fournisseur</span>
					</a>
					<ul class="pcoded-submenu">
						<li class=" "><a href="<c:url value="/?action=fournisseur"/>" class="waves-effect waves-dark"> <span class="pcoded-mtext">Liste des fournisseurs</span>
						</a></li>
						<li class=" "><a href="<c:url value="/?action=addFournisseur"/>" class="waves-effect waves-dark"> <span class="pcoded-mtext">Ajouter un fournisseur</span>
						</a></li>
					</ul>
				</li>
			</ul>
				<div class="pcoded-navigation-label">Gerer les Commandes</div>
			<ul class="pcoded-item pcoded-left-item">
				<li class="pcoded-hasmenu">
					<a href="javascript:void(0)" class="waves-effect waves-dark"> 
						<span class="pcoded-micon">
							<i class="feather icon-box"></i>
						</span> 
						<span class="pcoded-mtext">Commandes</span>
					</a>
					<ul class="pcoded-submenu">
						<li class=" "><a href="<c:url value="/?action=commande"/>" class="waves-effect waves-dark"> <span class="pcoded-mtext">Liste des commandes</span>
						</a></li>
						<li class=" "><a href="<c:url value="/?action=addCommande"/>" class="waves-effect waves-dark"> <span class="pcoded-mtext">Ajouter une commande</span>
						</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>
<!-- [ navigation menu ] end -->
