<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@include file="includes/header.jsp" %>
<%@include file="includes/nav.jsp" %>
<div class="container">
    <div class="container">
        <div class="mt-4 p-5 bg-success text-white rounded">
            <h2 class="text-center">Welcome to School Information System</h2>


            <%
                if(!status){
            %>
            <div class="d-flex justify-content-center text-center">
                <a href="/login" class="mt-5 btn btn-dark" data-toggle="collapse">Login</a>
            </div>
             <% } %>
        </div>

    </div>

<%@include file="includes/footer.jsp" %>