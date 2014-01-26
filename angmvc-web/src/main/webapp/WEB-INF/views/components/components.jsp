<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
  <title>Owners</title>
  <link href="<c:url value="/webjars/bootstrap/3.0.2/css/bootstrap.min.css" />" rel="stylesheet"/>
  <link href="<c:url value="/webjars/font-awesome/3.0.2/css/font-awesome.min.css" />" rel="stylesheet"/>
  <link href="<c:url value="/webjars/jquery-ui/1.10.2/themes/base/minified/jquery-ui.min.css" />" rel="stylesheet"/>
  <link href="<c:url value="/webjars/angular-ui/0.4.0/angular-ui.min.css" />" rel="stylesheet"/>
  <link href="<c:url value="/webjars/toastr/2.0.1/toastr.css" />" rel="stylesheet"/>
  <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet"/>
</head>
<body>
<%@include file="../_menu.jsp" %>
<div class="container" ng-app="componentApp">
  <div class="container" ng-controller="MainCtrl">
    <label>
      <input type="checkbox" ng-model="visible"/> Visible: {{visible}}
    </label>
    <show-hide visible="{{visible}}">
      This is a test. Visible: {{visible}}. Date: {{date}}.
    </show-hide>
  </div>
</div>
<script src="<c:url value="/webjars/jquery/1.10.2/jquery.min.js"/>"></script>
<script src="<c:url value="/webjars/jquery-ui/1.10.2/ui/minified/jquery-ui.min.js"/>"></script>
<script src="<c:url value="/webjars/jquery-ui/1.10.2/ui/i18n/jquery.ui.datepicker-de.js"/>"></script>
<script src="<c:url value="/webjars/angularjs/1.2.8/angular.min.js"/>"></script>
<script src="<c:url value="/webjars/angularjs/1.2.8/angular-resource.min.js"/>"></script>
<script src="<c:url value="/webjars/angularjs/1.2.8/angular-cookies.min.js"/>"></script>
<script src="<c:url value="/webjars/angularjs/1.2.8/angular-sanitize.min.js"/>"></script>
<script src="<c:url value="/webjars/angularjs/1.2.8/angular-route.min.js"/>"></script>
<script src="<c:url value="/webjars/angularjs/1.2.8/i18n/angular-locale_de.js"/>"></script>
<script src="<c:url value="/webjars/angular-ui/0.4.0/angular-ui.min.js"/>"></script>
<script src="<c:url value="/webjars/bootstrap/3.0.2/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/webjars/underscorejs/1.5.2/underscore-min.js"/>"></script>
<script src="<c:url value="/webjars/toastr/2.0.1/toastr.min.js"/>"></script>

<script src="<c:url value="/resources/scripts/components/component_app.js"/>"></script>
<script src="<c:url value="/resources/scripts/components/component_directives.js"/>"></script>
<script src="<c:url value="/resources/scripts/components/component_ctrl.js"/>"></script>

</body>