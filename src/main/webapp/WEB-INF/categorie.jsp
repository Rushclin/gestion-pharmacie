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
								<h5>Liste des categories</h5>
								<span>Ici la liste des diff�rents categories de la
									pharmacie</span>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="page-header-breadcrumb">
							<ul class=" breadcrumb breadcrumb-title">
								<li class="breadcrumb-item"><a href="index.html"><i
										class="feather icon-home"></i></a></li>
								<li class="breadcrumb-item"><a href="#!">Categorie</a></li>
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
											<h5>Liste</h5>
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
															<th>#</th>
															<th>Nom</th>
															<th>Description</th>
															<th>Actions</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="categorie" items="${ListCategorie}">
															<tr>
																<td><c:out value="${categorie.idCategorie }" /></td>
																<td><c:out value="${ categorie.nomCategorie}" /></td>
																<td><c:out  value="${categorie.description }" /> </td>
																
																<td>
																	<div class="d-inline-block dropdown">
																		<a
																			href="<c:url value="/?action=searchCategorie&idCategorie=${ categorie.idCategorie }"/>">
																			<button type="button"
																				class="btn-shadow btn btn-primary">
																				<i class="fa fa-edit"></i>
																			</button>
																		</a> <a
																			href="<c:url value="/?action=deleteCategorie&idCategorie=${ categorie.idCategorie }"/>">
																			<button type="button"
																				class="btn-shadow btn btn-danger">
																				<i class="fa fa-trash"></i>
																			</button>
																		</a>
																	</div>
																</td>
															</tr>
														</c:forEach>
													</tbody>
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
