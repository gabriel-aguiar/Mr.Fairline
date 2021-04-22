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
	$(document).ready(
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
					$.each(result, function(i, obj) {
						dataArray.push([ obj.nome_popular, obj.gols, ]);
					});
					dataLine.addRows(dataArray);
					var options = {
						pieSliceText : 'value-and-percentage',
						title : 'TOP 5 TIMES DA CASA',
						width : 1600,
						height : 500,
					};
					var chart = new google.visualization.PieChart(document
							.getElementById('drawChartPie'));
					chart.draw(dataLine, options);
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
	<div class="col-lg-12">
		<div id="drawChartPie" style="border: 1px solid #ccc"></div>
	</div>
</body>
</html>