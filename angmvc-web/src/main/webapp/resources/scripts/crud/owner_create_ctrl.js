'use strict';

(function () {
    var app = angular.module("ownerApp");

    app.controller('OwnerCreateCtrl', ["$scope", "$location", "messageService", "ownerService",
        function ($scope, $location, messageService, ownerService) {
            $scope.checkRequired = function(field) {
                return angular.isDefined(field) && field.$dirty && field.$error.required;
            };

            $scope.checkError = function(field) {
                return angular.isDefined(field) && field.$dirty && field.$invalid;
            };

            $scope.errorClass = function(field) {
                return $scope.checkError(field) ? 'has-error' : '';
            };

            $scope.saveOwner = function() {
                var success = function(data) {
                    $location.path("/");
                    messageService.showSuccess("Successfully saved owner");

                };
                var error = function(error) {
                    messageService.showError("Error saving owner");
                };
               ownerService.save(angular.toJson($scope.owner), success, error);
            };

            $scope.owner = {};
        }]);
}).call(this);
