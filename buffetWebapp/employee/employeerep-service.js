angular.module('buffetApp')

    .factory('employeerepService', function ($http) {
        var svc = {};
        var apiUrl = "http://localhost:8080/buffet";

        svc.getAllEmployeeReport = function () {
            return $http.post(apiUrl + '/employeereport');
        }



        return svc;
    });