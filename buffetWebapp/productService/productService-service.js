angular.module('buffetApp')

    .factory('productServiceService', function ($http) {
        var svc = {};
        var apiUrl = "http://localhost:8080/buffet";


        svc.getAllProduct = function () {
            return $http.get(apiUrl + '/product/all');
        }


       svc.saveNewProduct = function(product){
           return $http.post(apiUrl + '/product', product);
       }

       svc.saveUpdateProduct = function (product){
        return $http.put(apiUrl + '/product/'+ product.id, product)
    }


        return svc;
    });