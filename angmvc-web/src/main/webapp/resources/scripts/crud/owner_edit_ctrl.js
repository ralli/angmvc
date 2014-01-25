'use strict';

(function () {
  var app = angular.module("ownerApp");

  app.controller('OwnerEditCtrl', ["$scope", "$routeParams", "$location", "messageService", "ownerService",
    function ($scope, $routeParams, $location, messageService, ownerService) {
      var params = { id: $routeParams.id };

      $scope.checkRequired = function(field) {
        return angular.isDefined(field) && field.$dirty && field.$error.required;
      };

      $scope.checkError = function (field) {
        return angular.isDefined(field) && field.$dirty && field.$invalid;
      };

      $scope.errorClass = function (field) {
        return $scope.checkError(field) ? 'has-error' : '';
      };

      $scope.saveOwner = function () {
        alert(angular.toJson($scope.owner));
        var successCallback = function (/* data */) {
          $location.path("/");
          messageService.showSuccess("Owner successfully updated");
        };

        var errorCallback = function (data) {
          messageService.showError(data.message);
        };

        var params = {  'id': $scope.owner.id };
        var ownerCommand = {
          'firstName': $scope.owner.firstName,
          'lastName': $scope.owner.lastName,
          'address': $scope.owner.address,
          'city': $scope.owner.city,
          'telephone': $scope.owner.telephone
        };
        ownerService.update(params, ownerCommand, successCallback, errorCallback);
      };

      ownerService.get(params,
        function (data) {
          $scope.owner = data;
        },
        function (error) {
          $location.path("/");
          messageService.showError(error.data.message);
        });
    }]);
}).call(this);
