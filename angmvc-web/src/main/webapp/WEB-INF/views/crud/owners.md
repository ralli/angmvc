# Setup

### owner_app.js:

```JavaScript
(function () {
    var app = angular.module("ownerApp", ['ngResource', 'ngRoute', 'ui']);

    app.config(["$routeProvider", "$locationProvider",
        function ($routeProvider, $locationProvider) {
            $locationProvider.html5Mode(false);
            $locationProvider.hashPrefix("!");
            $routeProvider
                .when('/', {
                    templateUrl: 'resources/scripts/crud/list.tpl.html',
                    controller: 'OwnerListCtrl'
                });
        }
    ]);
}).call(this);
```

### owner_services.js

```JavaScript
'use strict';

(function() {
    var app = angular.module("ownerApp");

    app.factory("ownerService", ["$resource", function($resource) {
        return $resource("api/owners/:id");
    }]);
}).call(this);
```

### owner_list_ctrl.js

```JavaScript
'use strict';

(function () {
    var app = angular.module("ownerApp");

    app.controller('OwnerListCtrl', ["$scope", "ownerService", function($scope, ownerService) {
        ownerService.query({},
            function(data) {
                $scope.owners = data;
            },
            function(error) {});
    }]);

}).call(this);
```

### list.tpl.html

```HTML
<h1>Owners</h1>

<p>{{owners}}</p>
```

Add a Table:

```HTML
<table class="table table-bordered table-condensed">
<thead>
<tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Address</th>
    <th>City</th>
    <th>Telephone</th>
    <th>Pets</th>
    <th>Actions</th>
</tr>
</thead>
<tbody>
<tr ng-repeat="owner in owners">
    <td>{{owner.firstName}}</td>
    <td>{{owner.lastName}}</td>
    <td>{{owner.address}}</td>
    <td>{{owner.city}}</td>
    <td>{{owner.telephone}}</td>
    <td>{{owner.petNames.join(", ")}}</td>
    <td>Action</td>
</tr>
</tbody>
</table>
```

## Showing owners

### owner_app.js
```JavaScript
$routeProvider
    .when('/:id', {
        templateUrl: 'resources/scripts/crud/show.tpl.html',
        controller: 'OwnerShowCtrl'
    });
```

### list.tpl.html
```HTML
<td><a href="#!/{{owner.id}}"></a></td>
```

### owner_show_ctrl.js
```JavaScript
'use strict';

(function () {
    var app = angular.module("ownerApp");

    app.controller('OwnerShowCtrl', ["$scope", "$routeParams", "ownerService", function($scope, $routeParams, ownerService) {
        var params = { id: $routeParams.id };
        ownerService.get(params,
            function(data) {
                $scope.owner = data;
            },
            function(error) {});
    }]);
}).call(this);
```

### show.tpl.html

```HTML
<div class="form-horizontal">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">Owner</h3>
        </div>
        <div class="panel-body">
            <div class="form-group">
                <label class="col-sm-2 control-label">First Name</label>
                <div class="col-sm-10">
                    <input type="text" disabled class="form-control" value="{{owner.firstName}}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Last Name</label>
                <div class="col-sm-10">
                    <input type="text" disabled class="form-control" value="{{owner.lastName}}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Address</label>
                <div class="col-sm-10">
                    <input type="text" disabled class="form-control" value="{{owner.address}}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">City</label>
                <div class="col-sm-10">
                    <input type="text" disabled class="form-control" value="{{owner.city}}"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Telephone</label>
                <div class="col-sm-10">
                    <input type="text" disabled class="form-control" value="{{owner.telephone}}"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <a href="#!/" class="btn btn-primary">Back to List</a>
                    <a href="#!/{{owner.id}}/edit" class="btn btn-default">Edit</a>
                </div>
            </div>
        </div>
    </div>
</div>
```

## Add Error Handling to Show owner

### owner_services.js

```JavaScript
app.factory("messageService", function () {
    var result = {};
    result.showError = function (message) {
        toastr.error(message);
    };

    result.showSuccess = function (message) {
        toastr.success(message);
    };

    result.showInfo = function (message) {
        toastr.info(message);
    };

    result.showWarning = function (message) {
        toastr.warning(message);
    };

    return result;
});
```

### owner_show_ctrl.js

```
    app.controller('OwnerShowCtrl', ["$scope", "$routeParams", "$location", "messageService", "ownerService",
        function ($scope, $routeParams, $location, messageService, ownerService) {
```

and in ownerService.get():

```HTML
function (error) {
    $location.path("/");
    messageService.showError(error.data.message);
});
```

Now check

http://localhost:8080/angmvc-web/api/owners/0

and

http://localhost:8080/angmvc-web/owners#!/0
