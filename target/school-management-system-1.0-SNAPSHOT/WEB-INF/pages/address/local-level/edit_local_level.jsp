<%@ page import="com.example.schoolmanagementsystem.entity.LocalLevel" %>
<%@ page import="com.example.schoolmanagementsystem.entity.State" %>
<%@ page import="java.util.List" %>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/nav.jsp"/>
<div class="container">
    <h1>Local Level : Edit</h1></br>
<form action="/local-level" method="post">
    <%
        LocalLevel localLevel = (LocalLevel) request.getAttribute("local-level");
    %>

    <div class="form-group" >
        <input type="hidden" name="id" value="<%= localLevel.getId() %>" /><br>
        <label for="formGroupExampleInput">Name</label>
        <input type="text" name="name" value="<%= localLevel.getName() %>" class="form-control" id="formGroupExampleInput"/><br>
        <label for="formGroupExampleInput">State</label>
    </div>

    <select class="form-select" name="state" id="state">
        <%
            List<State> state = (List<State>) request.getAttribute("state");
            for(int i = 0; i < state.size(); i++){
        %>
        <option value="<%= localLevel.getState().getId() %>" <% if(state.get(i).getId() == localLevel.getState().getId()){  %> selected <% } %>> <%= localLevel.getState().getName() %> </option>
        <% } %>
    </select><br>
    <input type="submit" name="operation" value="Update" class="mt-3 btn btn-success" id="formGroupExampleInput2">
</form>

<jsp:include page="../../includes/footer.jsp"/>
