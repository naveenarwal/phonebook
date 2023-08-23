<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
   if(session.getAttribute("login")==null)
   {
	   response.sendRedirect("./login.jsp");
   }
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=PT+Sans');
body{
width=100%;
background-repeat:no-repeat;
background-size:cover;
}img {
    position: absolute;
    width: 400px;
    border-radius: 15px;
    left: 36%;
    top: 10%;
}
button.btn.btn-outline-info {
    position: absolute;
    font-size: 35px;
    top: 33%;
    left: 20%;
    width:250px;
    border: 2px solid color red;
    border: 3px solid;
}

#add{
  background-image: url('./imgtry/addCont.gif');
  background-size: 100% 100%;
  background-repeat: no-repeat;
  color: #3ad2ff;

}

#add:hover{
background:transparent;
}

#view:hover{
background:transparent;

}


#view{
 left: 41%;
 border: 3px solid;
 border: 3px solid;
    background: transparent;
    color: #ff15e2;
      background-image: url('./imgtry/viewContact.gif');
  background-size: 100% 100%;
  background-repeat: no-repeat;
 
}


#edit{
    left: 62%;
        color: #3ad2ff;
      background-image: url('./imgtry/edit.gif');
  background-size: 100% 100%;
  background-repeat: no-repeat;
}

#edit:hover{
background:transparent;
}

#search{
top:63%;
left:30%;
  background-image: url('./imgtry/search.gif');
  background-size: 100% 100%;
  background-repeat: no-repeat;
}

#search:hover{
background:transparent;
color:#3ad2ff;
}

#delete{
top:63%;
left:53%;
  color: #ff15e2;
    background-image: url('./imgtry/delete.gif');
  background-size: 100% 100%;
  background-repeat: no-repeat;
}

#delete:hover{
background:transparent;
color:#f53bef;
}
.logout img{
    position: absolute;
    width: 105px;
    border-radius: 15px;
    left: 85%;
    top: 68%;
    height: 106px;
}

.logout img:hover{

   border:3px solid #28c3ff;
}



</style>
</head>
<body style="background-image: url(https://img.freepik.com/premium-photo/blue-purple-neon-square-black-brick-wall-background_161844-394.jpg?w=2000) ;">
   <img src="./imgtry/welcome.jpeg" alt="logo">
   <div class="add-Cont">
   <a href="./addContact.jsp" id= "addCont"><button type="button" class="btn btn-outline-info" id="add" >ADD<br>CONTACTS</button></a>
   </div>
   <div class="add-Cont">
  <button type="button" class="btn btn-outline-info" id="view">VIEW<br>CONTACTS</button>
   </div>
      <div class="add-Cont">
  <button type="button" class="btn btn-outline-info" id="edit">EDIT<br>CONTACTS</button>
   </div>
   <div class="add-Cont">
   <button type="button" class="btn btn-outline-info" id="search">SEARCH<br>CONTACTS</button>
   </div>
   <div class="add-Cont">
  <button type="button" class="btn btn-outline-info" id="delete">DELETE<br>CONTACTS</button>
   </div>
   
   <div class="add-Cont">
  <a href="./logoutServlet" class="logout" id="logout"><img alt="logout" src="./imgtry/logout.jpeg"></a>
   </div>
  
</body>
</html>