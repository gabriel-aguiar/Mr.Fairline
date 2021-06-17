<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="entity.Ranking"%>
<%@ page import="entity.Partidas"%>
<%@ page import="entity.Graficos"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">

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
<script
	src="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/js/adminlte.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/admin-lte@3.1/dist/css/adminlte.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>

<!--                                   JAVA SCRIPT                    -->

<script type="text/javascript"
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$.ajax({
							url : "graficoservlet",
							dataTYPE : "JSON",
							success : function(result) {
								google.charts.load('current', {
									'packages' : [ 'corechart' ]
								});
								google.charts.setOnLoadCallback(function() {
									drawChartPie(result)
								});
							}
						});

						function drawChartPie(result) {
							var dataLine = new google.visualization.DataTable();
							dataLine.addColumn('string', 'nome_popular');
							dataLine.addColumn('number', 'gols');
							var dataArray = [];
							$.each(result,
									function(i, obj) {
										dataArray.push([ obj.nome_popular,
												obj.gols, ]);
									});
							dataLine.addRows(dataArray);
							var options = {
								pieSliceText : 'value-and-percentage',
								width : 1100,
								height : 450,
								title : 'Top equipes com o melhor ataque jogando como mandante copa do Brasil 2021',
							};
							var chart = new google.visualization.PieChart(
									document.getElementById('drawChartPie'));
							chart.draw(dataLine, options);
						}
					});
</script>

<script type="text/javascript">
	$(document).ready(
			function() {
				$.ajax({
					url : "grafico2servlet",
					dataTYPE : "JSON",
					success : function(result) {
						google.charts.load('current', {
							'packages' : [ 'corechart' ]
						});
						google.charts.setOnLoadCallback(function() {
							drawChartCol(result)
						});

						console.log(result);

					}

				});

				function drawChartCol(result) {
					var data = new google.visualization.DataTable();
					data.addColumn('string', 'nome_popular');
					data.addColumn('number', 'gols');
					data.addColumn({
						role : 'style'
					});
					data.addColumn({
						role : 'annotation'
					});
					var dataArray = [];
					$.each(result, function(i, obj) {
						var pct = obj.gols2;
						if (pct < 0) {
							dataArray.push([ obj.nome_popular2, pct,
									'color: red', pct + '%' ]);
						} else {
							dataArray.push([ obj.nome_popular2, pct,
									'color: green', pct + '%' ]);
						}
					});
					data.addRows(dataArray);
					var options = {
						title : 'Percentual de gols top 15',
						width : 950,
						height : 450,
						legend : 'none',
					};
					var chart = new google.visualization.ColumnChart(document
							.getElementById('drawChartCol'));
					chart.draw(data, options);
				}

			});
</script>

<style type="text/css">
body h1 {
	font-style: italic;
	color: white;
	text-align: center;
}
</style>
</head>
<body>
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
	<section class="testimonial-area section-bg1">
		<div class="container" style="margin-top: 10%">
			<div class="row justify-content-center">
				<div class="col-xl-8 col-lg-8">
					<div class="section-tittle text-center mb-90">
						<h2>Gráfico copa do Brasil 2021</h2>
						<p>Top 5 equipes com o melhor ataque jogando como mandante
							copa do Brasil 2021</p>
						<br>
					</div>
				</div>
			</div>

			<div class="testimonial-wrapper">
				<div class="row align-items-center justify-content-center">
					<div class=" col-lg-10 col-md-12 col-sm-11">
						<div class="h1-testimonial-active">
							<div class="single-testimonial text-center mt-55"
								style="background-color: #FFFFFF; height: 600px; width: 400px">
								<div class="testimonial-caption">
									<img src="assets/img/icon/quotes-sign.png" alt=""
										class="quotes-sign">
									<div id="drawChartPie"></div>
									<p>Brook presents your services with flexible, convenient
										and cdpose layouts. You can select your favorite layouts &
										elements for cular ts with unlimited ustomization
										possibilities. Pixel-perfect replica;ition of thei designers
										ijtls intended csents your se.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="testimonial-wrapper">
				<div class="row align-items-center justify-content-center">
					<div class=" col-lg-10 col-md-12 col-sm-11">
						<div class="h1-testimonial-active">
							<div class="single-testimonial text-center mt-55"
								style="background-color: #FFFFFF; height: 600px; width: 400px">
								<div class="testimonial-caption">
									<img src="assets/img/icon/quotes-sign.png" alt=""
										class="quotes-sign">
									<div id="drawChartCol"></div>
									<p>Brook presents your services with flexible, convenient
										and cdpose layouts. You can select your favorite layouts &
										elements for cular ts with unlimited ustomization
										possibilities. Pixel-perfect replica;ition of thei designers
										ijtls intended csents your se.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
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