<%@ page import="java.util.List" %>
<%@ page import="com.example.schoolmanagementsystem.entity.State" %>
<%@ page import="com.example.schoolmanagementsystem.entity.Province" %>
<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/nav.jsp"/>
<div class="container">
    <h1>State : Add</h1>
<form action="/state" method="post">
    <div class="form-group" >
        <label for="formGroupExampleInput">Name</label>
        <input type="text" name="name" class="form-control" id="formGroupExampleInput"/><br>
    </div>
    Province :  <select class="form-select" name = "province" id = "province">
                    <%
                        List<Province> provinceList = (List<Province>) request.getAttribute("province");
                        for(int i = 0; i < provinceList.size(); i++){
                    %>
                       <option value="<%= provinceList.get(i).getId()%>"> <%= provinceList.get(i).getName() %> </option>

                    <% } %>
                </select>
    <br>
    <input type="submit" name="operation" value="Add" class="mt-3 btn btn-success" id="formGroupExampleInput2">
</form>



<jsp:include page="../../includes/footer.jsp"/>