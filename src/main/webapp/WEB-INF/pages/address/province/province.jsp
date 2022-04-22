<%@ page import="java.util.List" %>
<%@ page import="com.example.schoolmanagementsystem.entity.Province" %>
<%@ page import="java.util.ArrayList" %>
<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/nav.jsp"%>

<div class="container">
    <div class="row">
        <h1>Province</h1></br>
        <div class="col">
            <a href="/province?action=add" class="btn btn-dark" data-toggle="collapse">Add</a>
        </div>
        <form class="row col float-right">
            <div class="col-8">
                <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" name="search">
            </div>
            <div class="col-4">
                <input type="submit" class="btn btn-outline-success my-2 my-sm-0" value="Search"/>
            </div>
        </form>
    </div>

        <table class="table">
    <tr>
        <th>SN</th>
        <th>Name</th>
        <th>Action</th>
    </tr>
    <%
        List<Province> provinceList = (List<Province>) request.getAttribute("province");
        for(int i = 0; i < provinceList.size(); i++){
    %>

    <tr>
        <td><%= i+1 %></td>
        <td><%= provinceList.get(i).getName() %></td>
        <td>
            <a href="/province?action=edit&id=<%= provinceList.get(i).getId() %>" class="btn btn-success" data-toggle="collapse">Edit</a>
            <a href="/province?action=delete&id=<%= provinceList.get(i).getId() %>" class="btn btn-danger" data-toggle="collapse" onclick="return confirm('Are you sure?');">Delete</a>
        </td>
    </tr>
    <% } %>

</table>


<%@include file="../../includes/footer.jsp"%>
