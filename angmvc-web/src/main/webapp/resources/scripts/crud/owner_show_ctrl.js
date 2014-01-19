'use strict';

(function () {
    var app = angular.module("ownerApp");

    app.controller('OwnerShowCtrl', ["$scope", "$routeParams", "$location", "messageService", "ownerService",
        function ($scope, $routeParams, $location, messageService, ownerService) {
            var params = { id: $routeParams.id };

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
