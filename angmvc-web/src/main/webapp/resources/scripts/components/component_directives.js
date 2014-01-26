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
      'template': '<div ng-transclude></div>',
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

  app.directive("boldText", function() {
    return {
      'restrict': 'EA',
      'scope': {
        'text': '@'
      },
      'template': '<b>{{text}}</b>'
    };
  });

  app.directive("panel", function() {
    return {
      'restrict': 'EA',
      'templateUrl': 'resources/scripts/components/panel.tpl.html',
      'transclude': true,
      'scope': {
        'title': '@'
      }
    };
  });

  app.directive("inputText", function() {
    return {
      'restrict': 'EA',
      'scope': {
        'text': '='
      },
      'template': '<input type="text" ng-model="text" class="form-control">'
    }
  });
}).call();

