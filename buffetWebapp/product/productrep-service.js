angular.module('buffetApp')

    .factory('productrepService', function ($http) {
        var svc = {};
        var apiUrl = "http://localhost:8080/buffet";

        svc.getAllProductReport = function () {
            return $http.post(apiUrl + '/productreport');
        }


        return svc;
    });