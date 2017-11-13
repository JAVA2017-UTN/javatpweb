<!DOCTYPE html>
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">
    <title>Login</title>
    <link href="css/stylesPropios.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">
  </head>
  <body>
    <div class="container">
      <form class="form-signin" name="signin" action="login" method="post">
        <h2 class="form-signin-heading">Login</h2>
        <hr>
        <p class="errorLogueo">USUARIO INCORRECTO / NO HABILITADO</p>
        <label for="inputUser" class="sr-only">User</label>
        <input name="user" id="inputUser" class="form-control" placeholder="User" required="" autofocus="" type="">
        <label for="inputPass" class="sr-only">Password</label>
        <input name="pass" id="inputPass" class="form-control" placeholder="Password" required="" type="Password">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
      </form>

    </div>
</body>
</html>