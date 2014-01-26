'use strict';

(function () {
  var app = angular.module("ownerApp");

  app.directive("sample", function () {
    return {
      'restrict': "EA",
      'scope': {
        "message": "@"
      },
      'template': "<b>{{message}}</b>"
    };
  });

  app.directive("deleteLink", ["$http", function($http) {
    return {
      'restrict': 'EA',
      'scope': {
        'deleteHref': '@',
        'success': '=',
        'error': '='
      },
      'transclude': true,
      'template': "<a ng-click=\"clicked();\" ng-transclude></a>",
      'link': function(scope) {
        scope.clicked = function() {
          var successCallback = function(data, status, headers, config) {
            if(angular.isDefined(scope.success)) {
              scope.success(data, status, headers, config);
            }
          };

          var errorCallback = function(data, status, headers, config) {
            if(angular.isDefined(scope.error)) {
              scope.error(data, status, headers, config);
            }
          };

          $http({'method': 'POST', url: scope.deleteHref})
            .success(successCallback)
            .error(errorCallback);

          return false;
        }
      }
    }
  }]);
}).call();
