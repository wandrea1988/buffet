angular.module('buffetApp')

    .factory('saleService', function ($http) {
        var svc = {};
        var apiUrl = "http://localhost:8080/buffet";

        svc.getAllEmployee = function () {
            return $http.get(apiUrl + '/employee/all');
        }


        svc.getAllProduct = function () {
            return $http.get(apiUrl + '/product/all');
        }

        svc.createSale = function (sale) {
            return $http.post(apiUrl + '/sale', sale);
        }




        return svc;
    });