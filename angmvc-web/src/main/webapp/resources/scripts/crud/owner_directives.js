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
        'deleteHref': '@'
      },
      'transclude': true,
      'template': "<a ng-click=\"clicked();\" ng-transclude></a>",
      'link': function(scope) {
        scope.clicked = function() {
          $http({'method': 'POST', url: scope.deleteHref});
          return false;
        }
      }
    }
  }]);
}).call();
