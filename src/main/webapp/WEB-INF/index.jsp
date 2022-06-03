<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
								<h5>Page de dashboard</h5>
								<span>On doit afficher les elements du dshboard ici</span>
							</div>
						</div>
					</div>
					<div class="col-lg-4">
						<div class="page-header-breadcrumb">
							<ul class=" breadcrumb breadcrumb-title">
								<li class="breadcrumb-item"><a href="index.html"><i
										class="feather icon-home"></i></a></li>
								<li class="breadcrumb-item"><a href="#!">Dashboard</a></li>
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
											<h5>Liste </h5>
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
															<th>Name</th>
															<th>Product Code</th>
															<th>Customer</th>
															<th>Status</th>
															<th>Rating</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td>Sofa</td>
															<td>#PHD001</td>
															<td>abc@gmail.com</td>
															<td><label class="label label-danger">Out
																	Stock</label></td>
															<td><a href="#!"><i
																	class="fa fa-star f-12 text-c-yellow"></i></a> <a href="#!"><i
																	class="fa fa-star f-12 text-c-yellow"></i></a> <a href="#!"><i
																	class="fa fa-star f-12 text-c-yellow"></i></a> <a href="#!"><i
																	class="fa fa-star f-12 text-default"></i></a> <a href="#!"><i
																	class="fa fa-star f-12 text-default"></i></a></td>
														</tr>
														<tr>
															<td>Computer</td>
															<td>#PHD002</td>
															<td>cdc@gmail.com</td>
															<td><label class="label label-success">In
																	Stock</label></td>
															<td><a href="#!"><i
																	class="fa fa-star f-12 text-c-yellow"></i></a> <a href="#!"><i
																	class="fa fa-star f-12 text-c-yellow"></i></a> <a href="#!"><i
																	class="fa fa-star f-12 text-default"></i></a> <a href="#!"><i
																	class="fa fa-star f-12 text-default"></i></a> <a href="#!"><i
																	class="fa fa-star f-12 text-default"></i></a></td>
														</tr>
														<tr>
															<td>Mobile</td>
															<td>#PHD003</td>
															<td>pqr@gmail.com</td>
															<td><label class="label label-danger">Out
																	Stock</label></td>
															<td><a href="#!"><i
																	class="fa fa-star f-12 text-c-yellow"></i></a> <a href="#!"><i
																	class="fa fa-star f-12 text-c-yellow"></i></a> <a href="#!"><i
																	class="fa fa-star f-12 text-c-yellow"></i></a> <a href="#!"><i
																	class="fa fa-star f-12 text-c-yellow"></i></a> <a href="#!"><i
																	class="fa fa-star f-12 text-default"></i></a></td>
														</tr>
														<tr>
															<td>Coat</td>
															<td>#PHD004</td>
															<td>bcs@gmail.com</td>
															<td><label class="label label-success">In
																	Stock</label></td>
															<td><a href="#!"><i
																	class="fa fa-star f-12 text-c-yellow"></i></a> <a href="#!"><i
																	class="fa fa-star f-12 text-c-yellow"></i></a> <a href="#!"><i
																	class="fa fa-star f-12 text-c-yellow"></i></a> <a href="#!"><i
																	class="fa fa-star f-12 text-default"></i></a> <a href="#!"><i
																	class="fa fa-star f-12 text-default"></i></a></td>
														</tr>
														<tr>
															<td>Watch</td>
															<td>#PHD005</td>
															<td>cdc@gmail.com</td>
															<td><label class="label label-success">In
																	Stock</label></td>
															<td><a href="#!"><i
																	class="fa fa-star f-12 text-c-yellow"></i></a> <a href="#!"><i
																	class="fa fa-star f-12 text-c-yellow"></i></a> <a href="#!"><i
																	class="fa fa-star f-12 text-default"></i></a> <a href="#!"><i
																	class="fa fa-star f-12 text-default"></i></a> <a href="#!"><i
																	class="fa fa-star f-12 text-default"></i></a></td>
														</tr>
														<tr>
															<td>Shoes</td>
															<td>#PHD006</td>
															<td>pqr@gmail.com</td>
															<td><label class="label label-danger">Out
																	Stock</label></td>
															<td><a href="#!"><i
																	class="fa fa-star f-12 text-c-yellow"></i></a> <a href="#!"><i
																	class="fa fa-star f-12 text-c-yellow"></i></a> <a href="#!"><i
																	class="fa fa-star f-12 text-c-yellow"></i></a> <a href="#!"><i
																	class="fa fa-star f-12 text-c-yellow"></i></a> <a href="#!"><i
																	class="fa fa-star f-12 text-default"></i></a></td>
														</tr>
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
