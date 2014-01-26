'use strict';

(function () {
  var app = angular.module("ownerApp");

  app.controller('OwnerListCtrl', ["$scope", "ownerService", "messageService", function ($scope, ownerService, messageService) {
    $scope.deleteSuccess = function (data, status, headers, config) {
      $scope.reload();
      messageService.showSuccess("Successfully deleted owner");
    };

    $scope.deleteError = function (data, status, headers, config) {
      messageService.showError("Error deleting owner");
    };

    $scope.reload = function () {
      ownerService.query({},
        function (data) {
          $scope.owners = data;
        },
        function (error) {
        });
    }

    $scope.reload();
  }]);

}).call(this);