# Creating the index page

Note that the body tag in index.jsp containts an "ng-app" attribute.

Note, the ng-app's value "app" matches the angular.module("app", []); command in "resources/scripts/app.js".

Add a new paragraph `<p>{{1+1}}</p>` and refresh the page. The paragraphs content will be 2.

## Controllers and Scopes

Change app.js to the following contents:

```
'use strict';

(function() {
    var app = angular.module("app", []);

    app.controller("MainCtrl", ["$scope", function($scope) {
        $scope.message = "This is a test message";
    }]);
}).call(this);
```

Add the following snippet to index.jsp:

```
<div ng-controller="MainCtrl">
        {{message}}
</div>
```

## Forms and bidirectional updates

app.js:

```
'use strict';

(function() {
    var app = angular.module("app", []);

    app.controller("MainCtrl", ["$scope", function($scope) {
        $scope.message = "This is a test message";
        var person = {
            firstName: "Horst",
            lastName: "Hrubesch",
            birthDate: new Date("1972-09-02"),
            email: "horst@hrubesch.de"
        };
        $scope.person = person;
    }]);
}).call(this);
```

index.jsp

```
<div ng-controller="MainCtrl">
        {{message}}
<form role="form">
        <div class="form-group">
            <label for="firstNameField">First Name</label>
            <input type="text" id="firstNameField" class="form-control" name="firstName" ng-model="person.firstName"
                   required="required"/>
        </div>
        <div class="form-group">
            <label for="lastNameField">Last Name</label>
            <input type="text" id="lastNameField" class="form-control" name="lastName" ng-model="person.lastName"
                   required="required"/>
        </div>
        <div class="form-group">
            <label for="birthDateField">Birth Date</label>
            <input type="text" id="birthDateField" class="form-control" name="birthDate" ng-model="person.birthDate"
                   required="required"/>
        </div>
        <div class="form-group">
            <label for="emailField">Email</label>
            <input type="email" id="emailField" class="form-control" name="email" ng-model="person.email"
                   required="required"/>
        </div>
        <button class="btn btn-primary" type="submit">Save</button>
        <a ng-href="#" class="btn btn-default" >Cancel</a></form>
</form>
<p>Person = {{person|json}}</p>
</div>
```

Add angular-ui to the app:

app.js: Include the ui module in the app module. ``var app = angular.module("app", ['ui']);``

index.jsp: Add **ui-date** to the input field. ``<input type="text" id="birthDateField" class="form-control" name="birthDate" ng-model="person.birthDate" required="required" ui-date="ui-date" />``


## Call Restful Webservices

Navigate to http://localhost:8080/angmvc-web/api/pettypes

### api.js:

Add ng-resource to the app module. ``var app = angular.module("app", ['ui', 'ng-resource']);``

Add a ``$resource`` service to the module.

```
app.factory("petTypeService", ["$resource", function ($resource) {
        return $resource("/angmvc-web/api/pettypes/:id");
}]);
```

Inject the service into the controller:

```
app.controller("MainCtrl", ["$scope", "petTypeService", function($scope, petTypeService) {
   petTypeService.query({},
       function(data) {
      $scope.petTypes = data;
   }, function(error) {
      // for example console.log(error.message);
   });

   // existing code unmodified ...
}
```

### index.jsp

```
<ul>
  <li ng-repeat="petType in petTypes">{{petType.name}}</li>
</ul>
```

change the ``ul`` to:

```
<ul class="sortable" ui-sortable="ui-sortable" ng-model="petTypes">
  <li ng-repeat="petType in petTypes">{{petType.name}}</li>
</ul>
<p>{{petTypes|json}}</p>
```
