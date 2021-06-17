<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="entity.Ranking"%>
<%@ page import="entity.Partidas"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">

<script
	src="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/js/adminlte.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/css/adminlte.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
	integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
	integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="assets/css/slicknav.css">
<link rel="stylesheet" href="assets/css/flaticon.css">
<link rel="stylesheet" href="assets/css/progressbar_barfiller.css">
<link rel="stylesheet" href="assets/css/gijgo.css">
<link rel="stylesheet" href="assets/css/animate.min.css">
<link rel="stylesheet" href="assets/css/animated-headline.css">
<link rel="stylesheet" href="assets/css/magnific-popup.css">
<link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
<link rel="stylesheet" href="assets/css/themify-icons.css">
<link rel="stylesheet" href="assets/css/slick.css">
<link rel="stylesheet" href="assets/css/nice-select.css">
<link rel="stylesheet" href="assets/css/style.css">


<style type="text/css">
#content-tabble {
	border-collapse: collapse;
	margin: 25px 0;
	font-size: 0.9em;
	min-width: 400px;
	overflow: hidden;
	border-radius: 5px 5px 0 0;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

#content-tabble tbody tr {
	border-bottom: 1px solid #dddddd;
}

#content-tabble tbody tr:nth-of-type(even) {
	background-color: #f3f3f3;
}

#content-tabble tbody tr:last-of-type {
	border-bottom: 2px solid #009879;
}

#content-tabble tbody tr.active-row {
	font-weight: bold;
	color: Grey;
}

#BT {
	height: 50px;
	width: 200px;
	background-clip: content-box;
	color: gray;
	border-radius: 5px;
	border-bottom-left-radius: inherit;
	font-size: 17px;
	font-style: oblique;
	overflow: hidden;
	border-radius: 5px 5px 0 0;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

#content-tabble th {
	background-color: write;
	font-size-adjust: none;
}

body h1 {
	font-style: italic;
	font-size: 30px;
}
</style>

</head>
<body>
	<%
	if (session.getAttribute("usuario") == null) {

		response.sendRedirect("Login.jsp");

	}
	%>
	<header>
		<div class="header-area header-transparent"
			style="border: 2px; border-color: black;">
			<div class="main-header ">
				<div class="header-bottom  header-sticky">
					<div class="container-fluid">
						<div class="row align-items-center">
							<div class="col-xl-2 col-lg-2">
								<div class="logo">
									<a href="index.html"><img
										src="assets/img/logo/icons8-english-mustache-64.png" alt=""></a>
								</div>
							</div>
							<div class="col-xl-10 col-lg-10">
								<div
									class="menu-wrapper d-flex align-items-center justify-content-end">
									<!-- Main-menu -->
									<div class="main-menu d-none d-lg-block">
										<nav>
											<ul id="navigation">
												<li><a href="index.html">Home</a></li>
												<li class="button-header margin-left "><a
													href="Principal.jsp" class="btn">SAIR</a></li>
											</ul>
										</nav>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<section class="pricing-card-area fix">
		<div class="container" style="margin-top: 10%">
			<div class="row justify-content-center">
				<div class="col-xl-8 col-lg-8">
					<div class="section-tittle text-center mb-90">
						<h2>Tabelas copa do Brasil 2021</h2>
						<p>Primeira fase da copa do Brasil 2021 ,conta com 80 times
							divididos em 40 confrontos. Outras 12 equipes entram na disputa
							apenas na terceira fase.A primeira fase da competição foi
							disputada nos dias 9, 10, 11, 16, 17, 18, 25, 26 e 27 de março;</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xl-6 col-lg-6 col-md-6 col-sm-10">
					<div class="single-card text-center mb-30">
						<div class="card-top">
							<img src="assets/img/icon/price1.svg" alt="">
							<h4>Tabela de classificação</h4>
						</div>
						<div class="card-body table-responsive p-0" style="height: 500px;">
							<table class="table table-head-fixed text-nowrap"
								id="content-tabble">
								<thead>
									<tr>
										<th>COLOCAÇÃO</th>
										<th>ESCUDO</th>
										<th>GOLS</th>
										<th>TIMES</th>
									</tr>
								</thead>
								<tbody id="colocacao">
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="col-xl-6 col-lg-6 col-md-6 col-sm-10">
					<div class="single-card text-center mb-30">
						<div class="card-top">
							<img src="assets/img/logo/icons8-soccer-ball-64.png" alt="">
							<h4>Detalhes dos jogos</h4>
						</div>
						<div class="card-body table-responsive p-0" style="height: 500px;">
							<table class="table table-head-fixed text-nowrap"
								id="content-tabble">
								<thead>
									<tr>
										<th>DATA</th>
										<th>HORA</th>
										<th>TIME DA CASA</th>
										<th>PLACAR</th>
										<th>TIME VISITANTE</th>
									</tr>
								</thead>
								<tbody id="jogos">
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>

		</div>
	</section>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$
									.ajax({
										type : "GET",
										url : "tabelaservlet",
										success : function(data) {

											$
													.each(
															data,
															function(i, item) {
																$("#jogos")
																		.append(
																				'<tr>')
																		.append(
																				'<td>'
																						+ item.data_realizacao
																						+ '</td>')
																		.append(
																				'<td>'
																						+ item.hora_realizacao
																						+ '</td>')
																		.append(
																				'<td>'
																						+ item.nome_time_mandante
																						+ '</td>')
																		.append(
																				'<td>'
																						+ item.placar_mandante
																						+ ' x '
																						+ item.placar_mandante
																						+ '</td>')
																		.append(
																				'<td>'
																						+ item.nome_time_visitante
																						+ '</td>')
																		.append(
																				'</tr>')
															});
										}
									})
							$
									.ajax({
										type : "GET",
										url : "tabela2servlet",
										success : function(data) {
											console.log(data);
											$
													.each(
															data,
															function(i, item) {
																$("#colocacao")
																		.append(
																				'<tr>')
																		.append(
																				'<td>'
																						+ (i + 1)
																						+ 'º</td>')
																		.append(
																				'<td> <img src = "' + item.escudo + '"width="50" height="100"></td>')
																		.append(
																				'<td>'
																						+ item.gols
																						+ '</td>')
																		.append(
																				'<td>'
																						+ item.nome_popular
																						+ '</td>')
																		.append(
																				'</tr>')
															});
										}
									})
						})
	</script>
	<script src="./assets/js/vendor/modernizr-3.5.0.min.js"></script>

	<!-- Jquery Mobile Menu -->
	<script src="./assets/js/jquery.slicknav.min.js"></script>

	<!-- Jquery Slick , Owl-Carousel Plugins -->
	<script src="./assets/js/owl.carousel.min.js"></script>
	<script src="./assets/js/slick.min.js"></script>
	<!-- One Page, Animated-HeadLin -->
	<script src="./assets/js/wow.min.js"></script>
	<script src="./assets/js/animated.headline.js"></script>
	<script src="./assets/js/jquery.magnific-popup.js"></script>

	<!-- Date Picker -->
	<script src="./assets/js/gijgo.min.js"></script>

	<!-- Video bg -->
	<script src="./assets/js/jquery.vide.js"></script>

	<!-- Nice-select, sticky -->
	<script src="./assets/js/jquery.nice-select.min.js"></script>
	<script src="./assets/js/jquery.sticky.js"></script>
	<!-- Progress -->
	<script src="./assets/js/jquery.barfiller.js"></script>

	<!-- counter , waypoint,Hover Direction -->
	<script src="./assets/js/jquery.counterup.min.js"></script>
	<script src="./assets/js/waypoints.min.js"></script>
	<script src="./assets/js/jquery.countdown.min.js"></script>
	<script src="./assets/js/hover-direction-snake.min.js"></script>

	<!-- contact js -->
	<script src="./assets/js/contact.js"></script>
	<script src="./assets/js/jquery.form.js"></script>
	<script src="./assets/js/jquery.validate.min.js"></script>
	<script src="./assets/js/mail-script.js"></script>
	<script src="./assets/js/jquery.ajaxchimp.min.js"></script>

	<!-- Jquery Plugins, main Jquery -->
	<script src="./assets/js/plugins.js"></script>
	<script src="./assets/js/main.js"></script>
</body>
</html>