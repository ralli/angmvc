'use strict';

(function () {
  var app = angular.module("componentControllers", []);
  app.controller("MainCtrl", ["$scope", function ($scope) {
    $scope.visible = true;
    $scope.date = new Date();
  }]);

  app.controller("BoldTextCtrl", ["$scope", function ($scope) {
    $scope.myBoldText = "My Bold Text";
  }]);

  app.controller("InputCtrl", ["$scope", function ($scope) {
    $scope.myInputText = "My Input Text";
  }]);
}).call();