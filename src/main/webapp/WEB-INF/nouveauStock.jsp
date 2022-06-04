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
								<h5>Page de stcok</h5>
								<span>Ici, on peut ajouter, modifier et supprimer un stock</span>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="page-header-breadcrumb">
							<ul class=" breadcrumb breadcrumb-title">
								<li class="breadcrumb-item"><a href="index.html"><i
										class="feather icon-home"></i></a></li>
								<li class="breadcrumb-item"><a href="#!">Nouveau stock</a></li>
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
                                            <h5>Nouveau stock</h5>
                                        </div>
                                        <div class="card-block">
											<h4 class="sub-title">Remplissez le formulaire completement</h4>
											
											<form method="POST" action="?action=save-stock">
												<div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Quantite </label>
                                                     <div class="col-sm-10">
                                                          <input required type="number" name="quantiteStock" class="form-control">
                                                     </div>
                                                </div>
                                                
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Fournisseur </label>
													<div class="col-sm-10">
														<select class="js-example-basic-single col-sm-12" required name="idFournisseur">
														<c:forEach var="fournisseur" items="${fournisseurs }">
															<option value="${fournisseur.idFournisseur }">
																<c:out value="${fournisseur.nomFournisseur }"/>
															</option>
														</c:forEach>
														</select>
                                                   	</div>
                                                </div>
                                                
                                                <div class="row">
                                                	<div class="col-md-12">
                                                		<button type="submit" class="btn btn-primary">Valider</button>
                                                		<button type="reset" class="btn btn-danger">Annuler</button>
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