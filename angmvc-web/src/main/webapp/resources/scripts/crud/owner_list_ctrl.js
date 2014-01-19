'use strict';

(function () {
    var app = angular.module("ownerApp");

    app.controller('OwnerListCtrl', ["$scope", "ownerService", function($scope, ownerService) {
        ownerService.query({},
            function(data) {
                $scope.owners = data;
            },
            function(error) {});
    }]);

}).call(this);