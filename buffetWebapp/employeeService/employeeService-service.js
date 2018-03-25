angular.module('buffetApp')

    .factory('employeeServiceService', function ($http) {
        var svc = {};
        var apiUrl = "http://localhost:8080/buffet";

        svc.saveNewEmployee = function (employee) {
            return $http.post(apiUrl + '/employee', employee);
        }
        svc.getAllEmployee = function () {
            return $http.get(apiUrl + '/employee/all');
        }

        svc.saveUpdateEmployee = function (employee){
            return $http.put(apiUrl + '/employee/'+ employee.id, employee)
        }


        return svc;
    });