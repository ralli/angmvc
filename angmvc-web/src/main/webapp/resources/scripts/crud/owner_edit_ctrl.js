'use strict';

(function () {
    var app = angular.module("ownerApp");

    app.controller('OwnerEditCtrl', ["$scope", "$routeParams", "$location", "messageService", "ownerService",
        function ($scope, $routeParams, $location, messageService, ownerService) {
            var params = { id: $routeParams.id };

            $scope.checkError = function(field) {
                return angular.isDefined(field) && field.$dirty && field.$invalid;
            }

            $scope.errorClass = function(field) {
                return $scope.checkError(field) ? 'has-error' : '';
            }

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
