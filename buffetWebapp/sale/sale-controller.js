angular.module('buffetApp')

    .controller('saleController', function ($scope, saleService, $location) {


        $scope.initSale = function () {

            $scope.sale = {};

            $scope.sale.employee = {};

            $scope.sale.saleTime = null;

            $scope.sale.saleProducts = [];

            $scope.saleProduct = {};

            $scope.saleProduct.product = {};
        }



        $scope.getAllEmployee = function () {
            saleService.getAllEmployee()
                .then(function (response) {
                    $scope.employees = response.data;
                },
                function (error) {
                    console.log(error)

                });

        }

        $scope.getAllProduct = function () {
            saleService.getAllProduct()
                .then(function (response) {
                    $scope.products = response.data;
                },
                function (error) {
                    console.log(error)

                });

        }

        $scope.init = function () {
            $scope.initSale();
            $scope.getAllEmployee();
            $scope.getAllProduct();

        }

        $scope.pushSaleProduct = function () {

            if (!(typeof $scope.sale.employee == "string" &&
                typeof $scope.saleProduct.product == "string" &&
                $scope.saleProduct.quantity > 0)) {

                alert("Valamelyik mező(k) érvénytelen érték van megadva, vagy nincs kitöltve")
            } else {
                $scope.saleProduct.product = JSON.parse($scope.saleProduct.product);
                $scope.saleProduct.productName = $scope.saleProduct.product.productName;
                var foundProduct = false;
                for (var i = 0; i < $scope.sale.saleProducts.length; i++) {
                    if ($scope.sale.saleProducts[i].product.id == $scope.saleProduct.product.id) {
                        $scope.sale.saleProducts[i].quantity += $scope.saleProduct.quantity;
                        foundProduct = true;
                        break;
                    }
                }
                if (!foundProduct) {
                    $scope.sale.saleProducts.push($scope.saleProduct);
                }

                $scope.saleProduct = {};

                document.getElementById("employeeSelect").setAttribute("disabled", "true")
            }
        }


        $scope.deleteSaleProduct = function (saleProduct) {

            for (var i = 0; i < $scope.sale.saleProducts.length; i++) {
                if ($scope.sale.saleProducts[i] == saleProduct) {
                    $scope.sale.saleProducts.splice(i, 1);

                }
            }

        }


        $scope.updateSaleProduct = function (saleProduct) {
            $scope.saleProduct = saleProduct;
            $scope.saleProduct.product = JSON.stringify(saleProduct.product);
            $scope.deleteSaleProduct(saleProduct);
        }

        $scope.saveSale = function (sale) {
            if ($scope.sale.saleProducts.length > 0) {
                sale.employee = JSON.parse(sale.employee);
                sale.saleTime = new Date().getTime();
                saleService.createSale(sale)
                    .then(function (response) {
                        alert("Sikeres mentés")
                        $scope.initSale();
                        document.getElementById("employeeSelect").removeAttribute("disabled")
                    },
                    function (error) {
                        alert("Nem sikerült a mentés")
                        document.getElementById("employeeSelect").removeAttribute("disabled")

                    });
            }
            else {
                alert("Nem sikerült a mentés, mert üres a felvett termékek listája")
            }
        }

        $scope.deleteSale = function (sale) {
            $scope.initSale();
            document.getElementById("employeeSelect").removeAttribute("disabled")
        }
    });