'use strict';

(function () {
    var app = angular.module("app", ['ui', 'ngResource']);

    app.controller("MainCtrl", ["$scope", "petTypeService", function ($scope, petTypeService) {
        petTypeService.query({},
            function (data) {
                $scope.petTypes = data;
            },
            function (error) {
                // example console.log(error.message);
            }
        );

        $scope.message = "This is a test message";
        //noinspection UnnecessaryLocalVariableJS
        var person = {
            firstName: "Horst",
            lastName: "Hrubesch",
            birthDate: new Date("1972-09-02"),
            email: "horst@hrubesch.de",
            password: "secret",
            passwordConfirmation: "secret"
        };

        $scope.person = person;
        $scope.submitPerson = function (person) {
            alert(person.firstName);
        };
    }]);

    app.factory("petTypeService", ["$resource", function ($resource) {
        return $resource("/angmvc-web/api/pettypes/:id");
    }]);

}).call(this);