<%@ page import="com.example.schoolmanagementsystem.entity.State" %>
<%@ page import="java.util.List" %>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/nav.jsp"/>
<div class="container">
    <div class="row">
        <h1>State</h1><br>
        <div class="col">
            <a href="/state?action=add" class="btn btn-dark" data-toggle="collapse">Add</a>
        </div>
        <form class="row col float-right" action="/state" method="get" >
            <div class="col-8">
                <input class="form-control mr-sm-2" type="text"  placeholder="Search" aria-label="Search" name="search">
            </div>
            <div class="col-4">
                <input type="submit" class="btn btn-outline-success my-2 my-sm-0" value="Search"/>
<%--                <button class="btn btn-outline-success my-2 my-sm-0" type="submit" name="operation">Search</button>--%>
            </div>
        </form>
    </div>
    <table class="table">
        <tr>
            <th>SN</th>
            <th>Name</th>
            <th>Province</th>
            <th>Actions</th>
        </tr>
        <%
            List<State> states = (List<State>) request.getAttribute("state");
            for(int i = 0; i < states.size(); i++){
        %>
        <tr>
            <td> <%= i+1 %> </td>
            <td> <%= states.get(i).getName() %></td>
            <td> <%= states.get(i).getProvince().getName() %> </td>
            <td>
                <a href="/state?action=edit&id=<%= states.get(i).getId() %>" class="btn btn-success" data-toggle="collapse">Edit</a>
                <a href="/state?action=delete&id=<%= states.get(i).getId() %>" class="btn btn-danger" data-toggle="collapse" onclick="return confirm('Are you sure?');">Delete</a>
            </td>
        </tr>

            <% } %>


<jsp:include page="../../includes/footer.jsp"/>
