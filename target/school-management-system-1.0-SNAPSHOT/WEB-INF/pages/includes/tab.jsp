<ul class="nav nav-tabs" id="myTab" role="tablist">
    <li class="nav-item" role="presentation">
        <button class="nav-link active" id="province-tab" data-bs-toggle="tab" data-bs-target="#province" type="button" role="tab" aria-controls="home" aria-selected="true">Province</button>
    </li>
    <li class="nav-item" role="presentation">
        <button class="nav-link" id="state-tab" data-bs-toggle="tab" data-bs-target="#state" type="button" role="tab" aria-controls="profile" aria-selected="false">State</button>
    </li>
    <li class="nav-item" role="presentation">
        <button class="nav-link" id="local-tab" data-bs-toggle="tab" data-bs-target="#local" type="button" role="tab" aria-controls="contact" aria-selected="false">Local Level</button>
    </li>
</ul>
<div class="tab-content" id="myTabContent">
    <div class="tab-pane fade show active" id="province" role="tabpanel" aria-labelledby="home-tab">
        <jsp:include page="../province/province.jsp"/>
    </div>
    <div class="tab-pane fade" id="state" role="tabpanel" aria-labelledby="profile-tab">
        <jsp:include page="../state/state.jsp"/>
    </div>
    <div class="tab-pane fade" id="local" role="tabpanel" aria-labelledby="contact-tab">
        <jsp:include page="../local-level/local_level.jsp"/>
    </div>
</div>
