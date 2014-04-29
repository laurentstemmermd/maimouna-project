<!doctype html>

<html>
<head>
  <meta charset="utf-8">
  <title>Embedded Jetty Template</title>

  <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link href="//netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">

  <!--
  IMPORTANT:
  This is Heroku specific styling. Remove to customize.
  -->
  <link href="http://heroku.github.com/template-app-bootstrap/heroku.css" rel="stylesheet">
  <style type="text/css">
    .instructions {
      display: none;
    }

    .instructions li {
      margin-bottom: 10px;
    }

    .instructions h2 {
      margin: 18px 0;
    }

    .instructions blockquote {
      margin-top: 10px;
    }

    .screenshot {
      margin-top: 10px;
      display: block;
    }

    .screenshot a {
      padding: 0px;
      line-height: 1;
      display: inline-block;
      text-decoration: none;
    }

    .screenshot img {
      border: 1px solid #ddd;
      -webkit-border-radius: 4px;
      -moz-border-radius: 4px;
      border-radius: 4px;
      -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075);
      -moz-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075);
      box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075);
    }

    .modal {
      width: 800px;
      margin-left: -400px;
      height: 650px;
      margin-top: -325px;
    }

    .modal .modal-body {
      text-align: center;
      max-height: 650px;
    }
  </style>
  <!-- /// -->
  <script type="text/javascript">
    <!--
    function appname() {
      return location.hostname.substring(0, location.hostname.indexOf("."));
    }

    function showInstructions(eid) {
      var instructions = ["#eclipse-instructions", "#cli-instructions"];
      for (i in instructions) {
        if (instructions[i] != eid) {
          $(instructions[i]).hide();
        }
      }
      $(eid).show();
    }
    // -->
  </script>
</head>

<body>
<div class="navbar navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container">
      <a href="/" class="brand">QoS Tracking</a>
      <!--
      IMPORTANT:
      This is Heroku specific markup. Remove to customize.
      -->
      <a href="/" class="brand" id="heroku">par <strong>Maimouna</strong></a>
      <!-- /// -->
    </div>
  </div>
</div>

<div class="container" id="getting-started">
<div class="row">
<div class="span8 offset2">
    <% Boolean error = ("true".equals(request.getParameter("error"))); %>
<% if(error) { %>
<h1 class="alert alert-error">Probleme de connexion !</h1>
<% } %>


<div class="page-header">
  <h1>Veuillez vous authentifier</h1>
</div>
</div>
</div>
  <form accept-charset="UTF-8" action="/login" class=" form-vertical" id="new_admin" method="post"><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" />
    <input name="authenticity_token" type="hidden" value="2c2a1ZnGGXwFI7+VxKKtvExqRPjmBCl7gU6lPbDYzc4=" /></div>
    <p>
    <div class="control-group"><label class="control-label" for="admin_email">Email</label><div class="controls"><input id="login" name="login" size="30" type="email" /></div></div>
  </p>
  <p>
      <div class="control-group"><label class="control-label" for="admin_password">Mot de passe</label><div class="controls"><input id="admin_password" name="password" size="30" type="password" /></div></div>
  </p>
    <div><input class="btn btn-success" name="commit" type="submit" value="Connexion" /></div>
  </form>
</div>
<script src="//code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/2.3.2/js/bootstrap.min.js"></script>
</body>
</html>
