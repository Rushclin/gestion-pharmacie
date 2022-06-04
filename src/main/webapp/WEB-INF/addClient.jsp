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
								<h5>Formulaire du client</h5>
								<span>Ajouter un client</span>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="page-header-breadcrumb">
							<ul class=" breadcrumb breadcrumb-title">
								<li class="breadcrumb-item"><a href="index.html"><i
										class="feather icon-home"></i></a></li>
								<li class="breadcrumb-item"><a href="#!">Client</a></li>
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
									<div class="card">
										<!-- <div class="card-header">
											<h5>Liste</h5>
										</div> -->
										<div class="card-block">
											<h4 class="sub-title">Veuillez remplir tout les champs</h4>

											<form action="clients">
											<input type="hidden" name="action" value="createClient" />
												<div class="form-group row">
													<label for="nomClient" class="col-sm-2 col-form-label">Nom du client<span style="color: red">*</span></label>
													<div class="col-sm-10">
														<input type="text" class="form-control" name="nomClient" required>
													</div>
												</div>
												<div class="form-group row">
													<label for="telephoneClient" class="col-sm-2 col-form-label">Téléphone du client<span style="color: red">*</span></label>
													<div class="col-sm-10">
														<input type="number" class="form-control" name="telephoneClient" required>
													</div>
												</div>
												<div class="form-group row">
													<label for="emailClient" class="col-sm-2 col-form-label">Email du client<span style="color: red">*</span></label>
													<div class="col-sm-10">
														<input type="text" class="form-control" name="emailClient" required>
													</div>
												</div>
										 
												<div class="row">
													<div class="col-md-12">
														<button class="btn btn-primary">Valider</button>
													</div>
												</div>
											</form>
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