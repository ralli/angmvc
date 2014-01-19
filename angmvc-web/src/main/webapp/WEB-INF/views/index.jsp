<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <title>My first Page</title>
    <link href="<c:url value="/webjars/bootstrap/3.0.2/css/bootstrap.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/webjars/font-awesome/3.0.2/css/font-awesome.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/webjars/jquery-ui/1.10.2/themes/base/minified/jquery-ui.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/webjars/angular-ui/0.4.0/angular-ui.min.css" />" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet"/>
</head>
<body>
<%@include file="_menu.jsp" %>
<div class="container" ng-app="app">
    <p>{{1+1}}</p>

    <div ng-controller="MainCtrl">
        {{message}}

        <form role="form" ng-submit="submitPerson(person)">
            <div class="form-group">
                <label for="firstNameField">First Name</label>
                <input type="text" id="firstNameField" class="form-control" name="firstName" ng-model="person.firstName"
                       required="required" maxlength="80"/>
            </div>
            <div class="form-group">
                <label for="lastNameField">Last Name</label>
                <input type="text" id="lastNameField" class="form-control" name="lastName" ng-model="person.lastName"
                       required="required" maxlength="80"/>
            </div>
            <div class="form-group">
                <label for="birthDateField">Birth Date</label>
                <input type="text" id="birthDateField" class="form-control" name="birthDate" ng-model="person.birthDate"
                       required="required" ui-date="ui-date" />
            </div>
            <div class="form-group">
                <label for="emailField">Email</label>
                <input type="email" id="emailField" class="form-control" name="email" ng-model="person.email"
                       required="required" maxlength="80"/>
            </div>
            <div class="form-group">
                <label for="emailField">Password</label>
                <input type="password" id="passwordField" class="form-control" name="password" ng-model="person.password"
                       required="required" maxlength="80"/>
            </div>
            <div class="form-group">
                <label for="passwordConfirmationField">Password Confirmation</label>
                <input type="password" id="passwordConfirmationField" class="form-control" name="passwordConfirmation" ng-model="person.passwordConfirmation"
                       required="required" maxlength="80"/>
            </div>
            <button class="btn btn-primary" type="submit">Save</button>
            <a ng-href="#" class="btn btn-default" >Cancel</a></form>
        </form>
        <p>Person = {{person|json}}</p>

        <ul class="sortable" ui-sortable="ui-sortable" ng-model="petTypes">
            <li ng-repeat="petType in petTypes">{{petType.name}}</li>
        </ul>
        <p>{{petTypes|json}}</p>
    </div>

</div>
<script src="<c:url value="/webjars/jquery/1.10.2/jquery.min.js"/>"></script>
<script src="<c:url value="/webjars/jquery-ui/1.10.2/ui/minified/jquery-ui.min.js"/>"></script>
<script src="<c:url value="/webjars/jquery-ui/1.10.2/ui/i18n/jquery.ui.datepicker-de.js"/>"></script>
<script src="<c:url value="/webjars/angularjs/1.2.8/angular.min.js"/>"></script>
<script src="<c:url value="/webjars/angularjs/1.2.8/angular-resource.min.js"/>"></script>
<script src="<c:url value="/webjars/angularjs/1.2.8/i18n/angular-locale_de.js"/>"></script>
<script src="<c:url value="/webjars/angular-ui/0.4.0/angular-ui.min.js"/>"></script>
<script src="<c:url value="/webjars/bootstrap/3.0.2/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/webjars/underscorejs/1.5.2/underscore-min.js"/>"></script>

<script src="<c:url value="/resources/scripts/index/app.js"/>"></script>

</body>