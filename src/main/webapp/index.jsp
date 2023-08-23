<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
width=100%;
background-repeat:no-repeat;
background-size:cover;
}


.title img {
    height: 69px;
    position: absolute;
    top: 13%;
    border-radius: 12px;
    left: 30%;
}
.sign a {
    left: 63%;
    color: #f558ff;
    background: #050530b0;
    border: 3px solid;
    font-size: 30px;
}
.login a{
    left: 29%;
    color: #f558ff;
    background: #050530b0;
    border: 3px solid;
    font-size: 30px;

}
a {
    color: #fff;
    padding: 0.6rem 1.2rem;
    background: #da5767;
    border: 2px solid #da5767;
    transition: .3s;
    border-radius: 7px;
    text-decoration: none;
    position: absolute;
    top: 55%;
    left: 180px;
    font-size: 30px;
}
a:hover {
    font-size: 55px;
}

</style>
</head>
<body style="background-image: url(https://wallpapercave.com/wp/wp7932324.jpg) ;">
<div class="title" ><img alt="" src="./imgtry/title.png"></div>

   <div class="login">
      <a href="./login.jsp">Login</a>                       
          </div>
          <div class="sign">
          <a href="./signup.jsp">SignUp</a>
          </div>
</body>
</html>