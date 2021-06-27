<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Recupera��o de senha</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="manifest" href="site.webmanifest">
<link rel="shortcut icon" type="image/x-icon"
	href="assets/img/logo/icons8-soccer-ball-35.png">

<!-- CSS here -->
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
</head>
<body>
	<div style="background-color: rgb(90, 1, 102)">
		<div id="preloader-active">
			<div
				class="preloader d-flex align-items-center justify-content-center">
				<div class="preloader-inner position-relative">
					<div class="preloader-circle"></div>
					<div class="preloader-img pere-text">
						<img src="assets/img/logo/icons8-soccer-ball-64.png" alt="">
					</div>
				</div>
			</div>
		</div>

		<main class="login-body">
			<form name="formuser" class="form-default"
				action="recuperacaoservlet" method="POST">
				<div class="login-form">
					<h2>Informe os dados a baixo para recuperar a senha</h2>
					<div class="form-input">
						<label for="name">Email</label> <input required name="email"
							id="email" type="email" name="email">
					</div>
					<div class="form-input">
						<label for="name">Nova senha</label> <input required name="nsenha"
							id="nsenha" type="password" name="nsenha">
					</div>
					<div class="form-input">
						<label for="name">Confirma��o de senha</label> <input required
							name="rep_senha" id="rep_senha" type="password" name="rep_senha">
					</div>
					<div class="form-input pt-30">
						<td colspan="2"><input type="submit" value="Salvar"
							onclick="return validar()" /></td>
						<!--<li class="button-header justify-content-center" type="submit" name="submit"><a class="btn">CADASTRAR</a></li>-->
					</div>
					<br> <a href="Login.jsp" class="registration text-center"
						style="color: white">Sair</a>
				</div>
			</form>
		</main>
		<div id="back-top">
			<a title="P�gina inicial" href="index.html"> <i
				class="fas fa-level-up-alt"></i></a>
		</div>
	</div>
</body>

<script type="text/javascript">
			function validar(){
				var nsenha = formuser.nsenha.value;
				var rep_senha = formuser.rep_senha.value;
				
				if(nsenha == "" || nsenha.length <= 5){
					alert('Preencha o campo senha com minimo 6 caracteres');
					formuser.nsenha.focus();
					return false;
				}
				
				if(rep_senha == "" || rep_senha.length <= 5){
					alert('Preencha o campo senha com minimo 6 caracteres');
					formuser.rep_senha.focus();
					return false;
				}
				
				if (nsenha != rep_senha) {
					alert('Senhas diferentes');
					formuser.nsenha.focus();
					return false;
				} else {
					alert("Sua senha foi alterada com sucesso!");
				}
			}
		</script>

<script src="./assets/js/vendor/modernizr-3.5.0.min.js"></script>
<!-- Jquery, Popper, Bootstrap -->
<script src="./assets/js/vendor/jquery-1.12.4.min.js"></script>
<script src="./assets/js/popper.min.js"></script>
<script src="./assets/js/bootstrap.min.js"></script>
<!-- Jquery Mobile Menu -->
<script src="./assets/js/jquery.slicknav.min.js"></script>

<!-- Video bg -->
<script src="./assets/js/jquery.vide.js"></script>

<!-- Jquery Slick , Owl-Carousel Plugins -->
<script src="./assets/js/owl.carousel.min.js"></script>
<script src="./assets/js/slick.min.js"></script>
<!-- One Page, Animated-HeadLin -->
<script src="./assets/js/wow.min.js"></script>
<script src="./assets/js/animated.headline.js"></script>
<script src="./assets/js/jquery.magnific-popup.js"></script>

<!-- Date Picker -->
<script src="./assets/js/gijgo.min.js"></script>
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
<%
if (session.getAttribute("Status") != null && session.getAttribute("Status") == ("ERROR")) {
	//response.sendRedirect("Login.jsp");
%>
<script type="text/javascript">
	alert("USUARIO OU SENHA INCORRETO - FAVOR SE N�O TIVER CADASTRO FAZER");
</script>
<%
}
%>
</html>