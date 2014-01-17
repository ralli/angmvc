<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <title>My first Page</title>
    <link href="<c:url value="/webjars/bootstrap/3.0.2/css/bootstrap.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/webjars/font-awesome/3.0.2/css/font-awesome.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/webjars/jquery-ui/1.10.2/themes/base/minified/jquery-ui.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/webjars/angular-ui/0.4.0/angular-ui.min.css" />" rel="stylesheet"/>
</head>
<body>
<p><c:out value="${message}"/></p>
<script src="<c:url value="/webjars/jquery/1.10.2/jquery.min.js"/>"></script>
<script src="<c:url value="/webjars/jquery-ui/1.10.2/ui/minified/jquery-ui.min.js"/>"></script>
<script src="<c:url value="/webjars/jquery-ui/1.10.2/ui/i18n/jquery.ui.datepicker-de.js"/>"></script>
<script src="<c:url value="/webjars/angularjs/1.1.4/angular.min.js"/>"></script>
<script src="<c:url value="/webjars/angularjs/1.1.4/angular-resource.min.js"/>"></script>
<script src="<c:url value="/webjars/angularjs/1.1.4/angular-bootstrap.min.js"/>"></script>
<script src="<c:url value="/webjars/angularjs/1.1.4/i18n/angular-locale_de.js"/>"></script>
<script src="<c:url value="/webjars/angular-ui/0.4.0/angular-ui.min.js"/>"></script>
<script src="<c:url value="/webjars/bootstrap/3.0.2/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/webjars/underscorejs/1.5.2/underscore-min.js"/>"></script>
</body>