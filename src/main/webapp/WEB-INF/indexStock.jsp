<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="layout/nav.jsp" />

<div class="pcoded-main-container">
	<div class="pcoded-wrapper">
		
		<c:import url="layout/sidebar.jsp"></c:import>
		
		<div class="pcoded-content">
			<div class="page-header card">
				<div class="row align-items-end">
					<div class="col-lg-8">
						<div class="page-header-title">
							<i class="feather icon-home bg-c-blue"></i>
							<div class="d-inline">
								<h5>Page de stock</h5>
								<span>Ici, on peut ajouter, modifier et supprimer un stock</span>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="page-header-breadcrumb">
							<ul class=" breadcrumb breadcrumb-title">
								<li class="breadcrumb-item"><a href="index.html"><i
										class="feather icon-home"></i></a></li>
								<li class="breadcrumb-item"><a href="#!">Stock</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="pcoded-inner-content">
				<div class="main-body">
					<div class="page-wrapper">
						<div class="page-body">
							<div class="row">
								<div class="col-md-12">
									<div class="card table-card">
										<div class="card-header">
											<h5>Liste des stocks disponible </h5>
											<div class="card-header-right">
												<ul class="list-unstyled card-option">
													<li class="first-opt"><i
														class="feather icon-chevron-left open-card-option"></i></li>
													<li><i class="feather icon-maximize full-card"></i></li>
													<li><i class="feather icon-minus minimize-card"></i></li>
													<li><i class="feather icon-refresh-cw reload-card"></i></li>
													<li><i class="feather icon-trash close-card"></i></li>
													<li><i
														class="feather icon-chevron-left open-card-option"></i></li>
												</ul>
											</div>
										</div>
										<div class="card-block p-b-0">
											<div class="table-responsive">
												<table class="table table-hover m-b-0">
													<thead>
														<tr>
															<th>ID</th>
															<th>Quantite</th>
															<th>Fournisseur</th>
															<th>Date d'ajout</th>
															<th>Enregistreur</th>
															<th>Actions</th>
														</tr>
													</thead>
													<c:if test="${error}">
														<tbody class="text-center">
															<tr>
																<td colspan="6">Une erreur s'est produite lors du chargement, verifiez votre connexion</td>
															</tr>
														</tbody>
													</c:if>
													<c:if test="${ !error }">
														<tbody>
															<c:forEach var="stock" items="${stocks}">
																<tr>
																	<td><c:out value="${stock.idStock }"/></td>
																	<td><c:out value="${stock.quantiteStock }"/></td>
																	<td><c:out value="${stock.idFournisseur }"/></td>
																	<td><c:out value="${stock.dateAjout }"/></td>
																	<td>On doit utiliser les sessions ici</td>
																	<td>
																		<a href="<c:url value="/?action=stock-update&id=${stock.idStock }"/>" class="btn btn-secondary" title="Editer"><i class="fa fa-edit"></i></a>
																		<a href="#" onClick="deleteStock(${stock.idStock})" class="btn btn-danger" title="Supprimer"> <i class="fa fa-trash"></i></a>
																	</td>
																</tr>
															</c:forEach>
														</tbody>
													</c:if>
													<tfoot class="text-center">
														<tr>
															<td colspan="6">Code with ❤️ by OUTSIDER-TEAM</td>
														</tr>
													</tfoot>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div id="styleSelector"></div>
	</div>
</div>

<c:import url="layout/footer.jsp" />

<script>
	function deleteStock(id){
		if(confirm("Voulez-vous vraiment supprimer le stock numero " + id + " ??")){
			// On doit faire un appel via url ici
			window.location.href="${pageContext.request.contextPath}/?action=stock-delete&id="+id
		}
	}
</script>
