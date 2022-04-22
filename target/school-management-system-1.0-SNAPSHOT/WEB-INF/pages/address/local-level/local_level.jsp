<%@ page import="com.example.schoolmanagementsystem.entity.LocalLevel" %>
<%@ page import="java.util.List" %>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/nav.jsp"/>
<div class="container">
    <h1>Local Level</h1><br>
    <div class="row">
        <div class="col">
            <a href="/local-level?action=add" class="col btn btn-dark" data-toggle="collapse">Add</a>
        </div>
        <form class="row col float-right">
            <div class="col-8">
                <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" name="search"/>
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
            <th>State</th>
            <th>Province</th>
            <th>Action</th>
        </tr>
        <%
            List<LocalLevel> localLevelList = (List<LocalLevel>) request.getAttribute("local-level");
            for(int i = 0; i < localLevelList.size(); i++){
        %>
        <tr>
            <td> <%= i+1 %> </td>
            <td> <%= localLevelList.get(i).getName() %> </td>
            <td> <%= localLevelList.get(i).getState().getName() %> </td>
            <td> <%= localLevelList.get(i).getState().getProvince().getName() %> </td>
            <td>
                <a href="/local-level?action=edit&id=<%= localLevelList.get(i).getId() %>" class="btn btn-success" data-toggle="collapse">Edit</a>
                <a href="/local-level?action=delete&id=<%= localLevelList.get(i).getId() %>" class="btn btn-danger" data-toggle="collapse" onclick="return confirm('Are you sure?');">Delete</a>
            </td>
        </tr>
        <% } %>

    </table>

<jsp:include page="../../includes/footer.jsp"/>
