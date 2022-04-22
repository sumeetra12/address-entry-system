<%@ page import="com.example.schoolmanagementsystem.entity.State" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.schoolmanagementsystem.entity.Province" %>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/nav.jsp"/>
<div class="container">
<form action="/state" method="post">
    <%
        State state = (State) request.getAttribute("state");
    %>
    <div class="form-group" >
        <input type="hidden" name="id" value="<%= state.getId() %>" /><br>
        <label for="formGroupExampleInput">Name</label>
        <input type="text" name="name" value="<%= state.getName() %>" class="form-control" id="formGroupExampleInput"/><br>
        <label for="formGroupExampleInput">Province</label>
    </div>
        <select class="form-select" name="changeProvince" id="changeProvince">
            <%
                List<Province> provinceList = (List<Province>) request.getAttribute("province");
                for(int i = 0; i < provinceList.size(); i++){
            %>

            <option value="<%= provinceList.get(i).getId() %>" <% if(provinceList.get(i).getId() == state.getProvince().getId()){  %> selected <% } %>> <%= provinceList.get(i).getName() %> </option>

            <% } %>
        </select>
        <br>
        <input type="submit" name="operation" value="Update" class="mt-3 btn btn-success" id="formGroupExampleInput2"/>
</form>

<jsp:include page="../../includes/footer.jsp"/>