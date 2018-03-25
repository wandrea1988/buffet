angular.module('buffetApp', ["ngRoute"]);

angular.module('buffetApp')
    .config(

    function ($routeProvider, $locationProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'home/home.html',
                controller: 'homeController',

            })

            .when('/sale', {
                templateUrl: 'sale/sale.html',
                controller: 'saleController',
            })


            .when('/employee', {
                templateUrl: 'employee/employeerep.html',
                controller: 'employeerepController',
            })
            .when('/product', {
                templateUrl: 'product/productrep.html',
                controller: 'productrepController'
            })
            .when('/employeeservice', {
                templateUrl: 'employeeService/employeeService.html',
                controller: 'employeeServiceController'
            })
            .when('/productservice', {
                templateUrl: 'productService/productService.html',
                controller: 'productServiceController'
            })
            ;
        $locationProvider.html5Mode(false);
    })