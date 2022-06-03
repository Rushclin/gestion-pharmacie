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
								<h5>Page de formulaire</h5>
								<span>Le petit formulaire</span>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="page-header-breadcrumb">
							<ul class=" breadcrumb breadcrumb-title">
								<li class="breadcrumb-item"><a href="index.html"><i
										class="feather icon-home"></i></a></li>
								<li class="breadcrumb-item"><a href="#!">Formulaire</a></li>
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
                                            <h5>PRODUIT</h5>
                                        </div>
                                        <div class="card-block">
											<h4 class="sub-title">Remplissez le formulaire completement pour un Produit</h4>
											
											<form action="ControllerServlet" method="post">
											<input type="hidden" name="action" value="create" />
												<div class="form-group row">
                                                    <label class="col-sm-2 col-form-label"  >NOM</label>
                                                     <div class="col-sm-10">
                                                          <input type="text" class="form-control" name="nomProduit">
                                                     </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label" >CODE</label>
                                                     <div class="col-sm-10">
                                                          <input type="number" class="form-control" name="codeProduit">
                                                     </div>
                                                </div>
                                                 <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label" >Disponiblite</label><br>
                                                    </div>
                                                    <div class="form-group column">
                                                  <div class="col-sm-10">
                                                    <div class="col-sm-10">
                                                    <label class="col-sm-2 col-form-label" >YES</label>
                                                          <input type="radio" class="form-control" name="disponibilite" value="YES">
                                                          </div>
                                                       <div class="col-sm-10">
                                                       <label class="col-sm-2 col-form-label" >NO</label>
                                                          <input type="radio" class="form-control" name="disponibilite" value="NO">
                                                          </div>
                                                          <div class="col-sm-10">
                                                          <label class="col-sm-2 col-form-label" >IN 30MINS</label>
                                                          <input type="radio" class="form-control" name="disponibilite" value="IN30mins">
                                                          </div>
                                                     </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label" >POIDS</label>
                                                     <div class="col-sm-10">
                                                          <input type="text" class="form-control" name="poids">
                                                     </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label" >DESCRIPTION</label>
                                                     <div class="col-sm-10">
                                                          <textarea type="text" class="form-control" name="descriptionProduit"> </textarea>
                                                     </div>
                                                </div>
                                               <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label" >ORIGIN</label>
                                                     <div class="col-sm-10">
                                                          <input type="text" class="form-control" name="originProduit">
                                                     </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label" >PRIX</label>
                                                     <div class="col-sm-10">
                                                          <input type="number" class="form-control" name="prix">
                                                     </div>
                                                </div>
                                                <div class="row">
                                                	<div class="col-md-12">
                                                		<button class="btn btn-primary">Ajouter</button>
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