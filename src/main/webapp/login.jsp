<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    if(session.getAttribute("login")!=null)
    {
    	if((Boolean)session.getAttribute("login"))
    	{
    		response.sendRedirect("./dashboard.jsp");
    	}
    }
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=PT+Sans');
body{
  background: #fff;
  background-image:url(https://img.freepik.com/free-vector/geometric-shapes-neon-lights-background_52683-33066.jpg?w=2000);
  background-repeat:no-repeat;
  background-attachment:fixed;
  background-size:cover;
  font-family: 'PT Sans', sans-serif;
}
.card {
    border: 0.40rem solid #f8f9fa;
    top: 10%;
    background: #000000c7;
}

h2{
  padding-top: 1.5rem;
}
a:hover{
  text-decoration: none;
  color:white;
   
    background-color: #df8c96;
    border-color: #df8c96;
  transition: .3s;
  
}
a{
  color:white; 
  padding: 0.6rem 1.2rem;
  background: #da5767;
  border: 2px solid #da5767;
  transition:.3s;
  border-radius:7px;
  text-decoration: none;
}
.card{
  border: 0.40rem solid #f8f9fa;
  top: 10%;
  background: #00000052;
}
.form-control{
  background-color: #f8f9fa;
  padding: 20px;
  padding: 25px 15px;
  margin-bottom: 1.3rem;
}

.form-control:focus {

    color: #000000;
    background-color: #ffffff;
    border: 3px solid #da5767;
    outline: 0;
    box-shadow: none;
}

.form-control:hover {
    color: #000000;
    background-color: #ffffff;
    border: 3px solid #da5767;
    outline: 0;
    box-shadow: none;
}

.btn{
  padding: 0.6rem 1.2rem;
  background: #da5767;
  border: 2px solid #da5767;
}
.btn-primary:hover {
    background-color: #df8c96;
    border-color: #df8c96;
  transition: .3s;
}

</style>
</head>
<body><div class="container">
  <div class="row justify-content-center">
  <div class="col-md-5">
   <div class="card">
     <h2 class="card-title text-center" style=color:indianred><b>LOGIN</b></h2>
      <div class="card-body py-md-4">
       <form _lpchecked="1" action="./UserServlet" method="post">
        <div class="form-group">
             <input type="email" class="form-control" id="email" name="email" placeholder="Email" required>
                            </div>                                                      
   <div class="form-group">
     <input type="password" class="form-control" id="password" name="password"  placeholder="Password" required>
   </div>
   <div class="d-flex flex-row align-items-center justify-content-between">
      <a href="./signup.jsp">SignUp</a>
        <input type="hidden" name="action" value="login">
                                <button class="btn btn-primary">LOGIN</button>
          </div>
       </form>
     </div>
  </div>
</div>
</div>
</div>

</body>
</html>
</body>
</html>