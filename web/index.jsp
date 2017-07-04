<%--
  Created by IntelliJ IDEA.
  User: miral
  Date: 6/27/2017
  Time: 12:37 PM
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
    <title>Login</title>

</head>
<body>


<div class="container">

    <div class="row">

        <div class="col-sm-6 col-md-4 col-lg-4">

            <h1 >Login</h1>
            <div>


                <form class="form-horizontal" method="post" action="LoginController">

                    <input type="text" class="form-control" name="user" placeholder="Email" required autofocus>

                    <input type="password" class="form-control" name="pass" placeholder="Password" required>

                    <button class="btn text-center btn-primary btn-block" type="submit">Submit</button>


                </form>

            </div>


        </div>

    </div>

</div>

</body>
</html>
