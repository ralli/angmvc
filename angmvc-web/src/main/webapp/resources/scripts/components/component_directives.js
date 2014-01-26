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