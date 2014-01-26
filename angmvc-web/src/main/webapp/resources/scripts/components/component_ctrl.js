'use strict';

(function() {
  var app = angular.module("componentControllers", []);
  app.controller("MainCtrl", ["$scope", function($scope) {
    $scope.visible = true;
    $scope.date = new Date();
  }]);
}).call();