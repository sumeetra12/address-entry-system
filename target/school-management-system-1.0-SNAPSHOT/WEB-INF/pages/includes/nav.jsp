<%@ page import="jakarta.servlet.http.HttpSession" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="/">SIS</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse d-flex justify-content-between" id="navbarNavDropdown">
                <ul class="navbar-nav">

                        <li class="nav-item">
                                <a class="nav-link" href="/">Home</a>
                        </li>
                        <%
                                HttpSession httpSession = request.getSession(false);
                                Boolean status = httpSession != null &&  httpSession.getAttribute("isLoggedIn") != null && (Boolean) httpSession.getAttribute("isLoggedIn");
                                if(status){
                        %>
                        <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Address</a>
                                <ul class="dropdown-menu">
                                        <li><a class="dropdown-item" href="/province">Province</a></li>
                                        <li><a class="dropdown-item" href="/state">State</a></li>
                                        <li><a class="dropdown-item" href="/local-level">Local Level</a></li>
                                </ul>
                        </li>
                </ul>

<%--                my-2 my-lg-0--%>
                <div class="navbar-nav nav-item my-2 my-lg-0">
                        <a class="nav-link" href="/logout">Logout</a>
                </div>
                <% } %>
        </div>
</nav>