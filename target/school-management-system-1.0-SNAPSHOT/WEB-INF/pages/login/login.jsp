<%@include file="../includes/header.jsp" %>
<%@include file="../includes/nav.jsp" %>

  <div class="container w-25">

      <%
          String error = request.getParameter("error");
          if(error != null){
              %>

      <div class="alert alert-danger mt-4" role="alert">
      Invalid username password!!
      </div>

              <% } %>
              <h2>Sign in</h2><br>
                <form class="row col float-right" action="/login" method="post" >
                    <div class="form-group" >
                        <label for="formGroupExampleInput">Username</label>
                        <input type="text" name="username" class="form-control" id="formGroupExampleInput"/><br>

                        <label for="formGroupExampleInput1">Password</label>
                        <input type="text" name="password" class="form-control" id="formGroupExampleInput1"/><br>
                    </div>
                    <div>
                    <input type="submit" name="login" value="Login" class="mt-3 btn btn-success" id="formGroupExampleInput2">
                    </div>
                </form>

<%@include file="../includes/footer.jsp" %>
