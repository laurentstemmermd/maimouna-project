<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form class="form-inline" action="<c:url value="/login" />" method="post">
	<div class="form-group">
		<label class="sr-only" for="username">Username</label>
		<input type="text" placeholder="Username" name="username" id="username" class="form-control input-sm" />
	</div>
	<div class="form-group">
		<label class="sr-only" for="password">Password</label>
		<input type="password" placeholder="Password" name="password" id="password" class="form-control input-sm" />
	</div>
	<button type="submit" class="btn btn-default btn-sm">Sign in</button>
</form>
