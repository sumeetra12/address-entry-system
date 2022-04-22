<%@ page import="java.util.List" %>
<%@ page import="com.example.schoolmanagementsystem.entity.Province" %>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/nav.jsp"/>

<div class="container">
    <h1>Province : Edit</h1><br>

    <form action="/province" method="post">
        <%
            Province province = (Province) request.getAttribute("province");
        %>
        <div class="form-group" >
            <input type="hidden" name="id" value="<%= province.getId() %>"/></br>
            <label for="formGroupExampleInput">Name</label>
            <input type="text" name="change-name" value="<%= province.getName() %>" class="form-control" id="formGroupExampleInput"/>
        </div>

        <input type="submit" name="operation" value="Update" class="mt-3 btn btn-success" id="formGroupExampleInput2"/>
    </form>

<jsp:include page="../../includes/footer.jsp"/>
