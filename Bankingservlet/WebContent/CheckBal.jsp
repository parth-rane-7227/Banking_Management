
<%@ page import="com.bank.services.*" %> 
   
<%@ page import="java.sql.*" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
<head>
<title>Check Balance</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Novus Admin Panel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- font CSS -->
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
 <!-- js-->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/modernizr.custom.js"></script>
<!--webfonts-->
<link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
<!--//webfonts--> 
<!--animate-->
<link href="css/animate.css" rel="stylesheet" type="text/css" media="all">
<script src="js/wow.min.js"></script>
	<script>
		 new WOW().init();
	</script>
<!--//end-animate-->
<!-- Metis Menu -->
<script src="js/metisMenu.min.js"></script>
<script src="js/custom.js"></script>
<link href="css/custom.css" rel="stylesheet">
<!--//Metis Menu -->
</head> 
<body class="cbp-spmenu-push">
	<div class="main-content">
		<!--left-fixed -navigation-->
		<div class=" sidebar" role="navigation">
            <div class="navbar-collapse">
				<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
					<ul class="nav" id="side-menu">
						
						
						<!-- <li>
							<a href="#"><i class=""></i>WELCOME</a>
						</li>
						 -->
						 	<li>
							<a href="index.html"><i class="fa fa-home nav_icon"></i>Home<span class="nav-badge-btm"></span></a>
						
						</li>
							
								<li>
							<a href="Register.html"><i class="fa fa-envelope nav_icon"></i>Menu</a>
							
						</li>	
						
						
			
						
						
					</ul>
					<div class="clearfix"> </div>
					<!-- //sidebar-collapse -->
				</nav>
			</div>
		</div>
		<!--left-fixed -navigation-->
		<!-- header-starts -->
		<div class="sticky-header header-section ">
			<div class="header-left">
				<!--toggle button start-->
				<button id="showLeftPush"><i class="fa fa-bars"></i></button>
				<!--toggle button end-->
				<!--logo -->
				<div class="logo">
					<a href="index.html">
						<h1>SBI</h1>
						<span>Bank</span>
					</a>
				</div>
			
				<div class="clearfix"> </div>
			</div>
			<div class="header-right">
			
				<!--notification menu end -->
			
				<div class="clearfix"> </div>	
			</div>
			<div class="clearfix"> </div>	
		</div>
		<!-- //header-ends -->
		<!-- main content start-->
		<div id="page-wrapper">
			<div class="main-page">
				<div class="tables">
					<h3 class="title1">Balance</h3> 
					
					<div class=" form-grids row form-grids-right">
						<div class="widget-shadow " data-example-id="basic-forms"> 
							<div class="table-responsive bs-example widget-shadow">
								<h4>User Balance:</h4>
							
								
								
						<table class="table table-bordered"> 
							 
								<tr> 
									<th>First Name</th>
									<th>Last Name</th> 
									<th>Account Number</th>
									<th>Account Balance</th> 
									
								</tr> 
								
								
								
								<%

								try
								{
									
									String acnumber = request.getParameter("anumber");
									Connection con = ConnectDB.getConnect();
									PreparedStatement ps1 = con.prepareStatement("select * from account where AccNo=?");
									ps1.setString(1, acnumber);
									ResultSet rs1 = ps1.executeQuery();
									
									while(rs1.next())
									{
								    %>		
						
							
							<tbody> 
							<tr> 
								 <td><%=rs1.getString(1) %></td> 
								  <td><%=rs1.getString(2) %></td> 
								   <td><%=rs1.getString(5) %></td> 
								  <td><%=rs1.getInt(6) %></td> 
							</tr> 
						</tbody>
						       	     <%
									 }
								}
								catch(Exception e)
								{
									e.printStackTrace();
								}
						        
						        %>
						
						
						 </table> 
						 <a href="CheckBalance.html"><button class="button" type="submit">Back</button></a> 
						 
								
							</div>
							<div class="form-body">
							
							
							
								 
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
		
	</div>
	
		<script src="js/classie.js"></script>
		<script>
			var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
				showLeftPush = document.getElementById( 'showLeftPush' ),
				body = document.body;
				
			showLeftPush.onclick = function() {
				classie.toggle( this, 'active' );
				classie.toggle( body, 'cbp-spmenu-push-toright' );
				classie.toggle( menuLeft, 'cbp-spmenu-open' );
				disableOther( 'showLeftPush' );
			};
			
			function disableOther( button ) {
				if( button !== 'showLeftPush' ) {
					classie.toggle( showLeftPush, 'disabled' );
				}
			}
		</script>
	<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->
	<!-- Bootstrap Core JavaScript -->
   <script src="js/bootstrap.js"> </script>
</body>
</html>