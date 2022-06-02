<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="layout/nav.jsp"/>

	
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
								<h5>Modifier un founisseur</h5>
								<span>Veuillez remplir les champs pour modifier ce fournisseur</span>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="page-header-breadcrumb">
							<ul class=" breadcrumb breadcrumb-title">
								<li class="breadcrumb-item"><a href="index.html"><i
										class="feather icon-home"></i></a></li>
								<li class="breadcrumb-item"><a href="#!">updateFournisseur</a></li>
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
										<div class="card-header">
                                            <h5>Informations formulaire</h5>
                                        </div>
                                        <div class="card-block">
											<h4 class="sub-title">Modifier les champs du formulaire</h4>
											
											<form>
												<div class="form-group row">
                                                    <label class="col-sm-2 col-form-label" for="nom">Nom du Fournisseur<span style="color: red">*</span></label>
                                                     <div class="col-sm-10">
                                                          <input type="text" value="Simo Academy" class="form-control" id="nom" name="nom" required autofocus>
                                                     </div>
                                                </div>
												<div class="form-group row">
                                                    <label class="col-sm-2 col-form-label" for="adresse">Adresse du Fournisseur<span style="color: red">*</span></label>
                                                     <div class="col-sm-10">
                                                          <input type="text" value="Dschang - Cameroun" class="form-control" id="adresse" name="adresse" required>
                                                     </div>
                                                </div>
												<div class="form-group row">
                                                    <label class="col-sm-2 col-form-label" for="email">Email du Fournisseur<span style="color: red">*</span></label>
                                                     <div class="col-sm-10">
                                                          <input type="email" value="simolarissa6@gmail.com" class="form-control" id="email" name="email" required>
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
	

<c:import url="layout/footer.jsp"/>