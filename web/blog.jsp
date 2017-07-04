<%--
  Created by IntelliJ IDEA.
  User: miral
  Date: 6/29/2017
  Time: 9:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <title>Blog</title>
    <%! String name;%>
    <%
        if (session != null) {

            name = (String) session.getAttribute("USER");

        } else {
            response.sendRedirect("index.jsp");
        }
    %>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-sm-12 col-md-12 col-lg-12">

            <nav class="navbar navbar-fixed-top navbar-inverse " style="background-color: #286090;color: white"
                 role="navigation">

                <div class="navbar-header  ">
                    <h3>Welcome <%=name%>
                    </h3>

                </div>
                <div>
                    <form action="LogoutController" method="post"><a class="pull-right"><span
                            class="glyphicon glyphicon-log-in"></span>
                        <input type="submit" value="Logout"></a></form>
                </div>
            </nav>
        </div>
    </div>
    <div class="row " style="margin:0 auto;">

        <br>
        <br>
        <div class="col-sm-6 col-md-4 col-lg-4" style="margin:0 auto;">

            <h1 class="text-center "> Add blog</h1>

            <div>


                <form class="form-horizontal" method="post" action="BlogController">

                    <input type="text" class="form-control" name="title" placeholder="Title" required autofocus>

                    <textarea cols="30" rows="10" class="form-control" name="blog" placeholder="Enter Content"
                              required></textarea>

                    <button class="btn text-center btn-primary btn-block" type="submit">Submit</button>


                </form>

            </div>


        </div>


    </div>

</div>
</body>
</html>
