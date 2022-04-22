<jsp:include page="../../includes/header.jsp"/>
<jsp:include page="../../includes/nav.jsp"/>
<div class="container">

    <h1>Province : Add</h1></br>



    <form action="/province" method="post">
        <div class="form-group" >
            <label for="formGroupExampleInput">Name</label>
            <input type="text" name="name" class="form-control" id="formGroupExampleInput"/>
        </div>

            <input type="submit" name="operation" value="Add" class="mt-3 btn btn-success" id="formGroupExampleInput2"/>
    </form>

<jsp:include page="../../includes/footer.jsp"/>
