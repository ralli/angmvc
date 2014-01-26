# Components Demonstration

## Show-Hide

### component_directives.js

```JavaScript
'use strict';
(function() {
  var app = angular.module("componentDirectives", []);
  app.directive("showHide", [function() {
    return {
      'restrict': 'EA',
      'scope': {
        'visible': '@'
      },
      'replace': true,
      'template': '<p ng-show="visible">Hello. Visible: {{visible}}</p>'
      }
    }
  }]);
}).call();
```

### component_ctrl.js

```JavaScript
'use strict';

(function() {
  var app = angular.module("componentControllers", []);
  app.controller("MainCtrl", ["$scope", function($scope) {
    $scope.visible = true;
    $scope.date = new Date();
  }]);
}).call();
```

### component_app.js

```JavaScript
'use strict';

(function() {
    var app = angular.module("componentApp", ["componentDirectives", "componentControllers"]);
}).call();
```

### components.jsp

In the pages ``body`` Tag:

```
<div class="container" ng-app="componentApp">
  <div class="container" ng-controller="MainCtrl">
    <label>
      <input type="checkbox" ng-model="visible"/> Visible: {{visible}}
    </label>
    <show-hide visible="{{visible}}">
      This is a test. Visible: {{visible}}.
    </show-hide>
  </div>
</div>
```

At the bottom of the page:

```HTML
<script src="<c:url value="/resources/scripts/crud/owner_create_ctrl.js"/>"></script>
<script src="<c:url value="/resources/scripts/crud/owner_services.js"/>"></script>
<script src="<c:url value="/resources/scripts/crud/owner_directives.js"/>"></script>
```

## Use Jquery-Effects in the show-hide component

### component_directives.js

```JavaScript
'use strict';
(function() {
  var app = angular.module("componentDirectives", []);
  app.directive("showHide", [function() {
    return {
      'restrict': 'EA',
      'scope': {
        'visible': '@'
      },
      'replace': true,
      'transclude': true,
      'template': '<p ng-transclude></p>',
      'link': function(scope, element, attrs) {
        scope.$watch('visible', function(newValue, oldValue) {
           if(newValue !== oldValue) {
             if(newValue === "true")
               $(element).fadeIn();
             else if(newValue === "false")
               $(element).fadeOut();
           }
        });
      }
    }
  }]);
}).call();
```

