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
	background-color: purple;
	font-size-adjust: none;
}

body h1 {
	font-style: italic;
	font-size: 30px;
}
</style>

</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-4" style="left: 500px">
				<div class="card">
					<!-- /.card-header -->
					<div class="card-body table-responsive p-0" style="height: 790px;">
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
			<div class="col-4" style="left: 500px">
				<div class="card">
					<!-- /.card-header -->
					<div class="card-body table-responsive p-0" style="height: 790px;">
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
	<script type="text/javascript">
		$(document).ready(function() {
			$.ajax({
		        type : "GET",
		        url : "tabelaservlet",
		        success : function(data) {
		           
		            $.each(data, function(i, item) {
		                $("#jogos")
		                    .append('<tr>')
		                    .append('<td>' + item.data_realizacao + '</td>')
		                    .append('<td>' + item.hora_realizacao + '</td>')
		                    .append('<td>' + item.nome_time_mandante + '</td>')
		                    .append('<td>' + item.placar_mandante + ' x ' + item.placar_mandante + '</td>')
		                    .append('<td>' + item.nome_time_visitante + '</td>')
		                    .append('</tr>')
		            });
		        }
		    })
		    $.ajax({
		        type : "GET",
		        url : "tabela2servlet",
		        success : function(data) {
		           console.log(data);
		            $.each(data, function(i, item) {
		                $("#colocacao")
		                    .append('<tr>')
		                    .append('<td>' + (i + 1) + 'º</td>')
		                    .append('<td> <img src = "' + item.escudo + '"width="50" height="100"></td>')
		                    .append('<td>' + item.gols + '</td>')
		                    .append('<td>' + item.nome_popular + '</td>')
		                    .append('</tr>')
		            });
		        }
		    })
		})
	</script>
</body>
</html>