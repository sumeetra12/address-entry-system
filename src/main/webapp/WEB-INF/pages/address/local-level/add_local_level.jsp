<%@ page import="com.example.schoolmanagementsystem.entity.State" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.schoolmanagementsystem.entity.Province" %>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/nav.jsp"/>
<div class="container">
    <h1>Local Level : Add</h1>
    <form action="/local-level" method="post">
        <div class="form-group" >
            <label for="formGroupExampleInput">Name</label>
            <input type="text" name="name" class="form-control" id="formGroupExampleInput"/><br>
        </div>

        <label for="formGroupExampleInput">State:</label>
        <select class="form-select" name="state" id="state">
            <%
                List<State> stateList = (List<State>) request.getAttribute("state");
                for(int i = 0; i < stateList.size(); i++){
            %>
            <option value="<%= stateList.get(i).getId() %>"><%= stateList.get(i).getName() %></option>
            <% } %>
        </select><br>

        <input type="submit" name="operation" value="Add" class="mt-3 btn btn-success" id="formGroupExampleInput2">
    </form>
<jsp:include page="../../includes/footer.jsp"/>
