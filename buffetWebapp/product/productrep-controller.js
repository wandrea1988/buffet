angular.module('buffetApp')

    .controller('productrepController', function ($scope, productrepService, $location) {



        $scope.init = function () {
            productrepService.getAllProductReport()
                .then(function (response) {
                    $scope.productreports = response.data;
                    $scope.labels = [];
                    $scope.data = [];
                    $scope.colors = [];
                    for (var i = 0; i < $scope.productreports.length; i++) {
                        var productName = $scope.productreports[i].productName;
                        var quantity = $scope.productreports[i].sumQuantity;
                        $scope.labels.push(productName);
                        $scope.data.push(quantity);
                        var color = "rgb(" + Math.floor(Math.random() * 256) + "," + Math.floor(Math.random() * 256) + "," + Math.floor(Math.random() * 256) + ")";

                        $scope.colors.push(color);
                    } $scope.createChartProduct();
                },
                function (error) {
                    console.log(error)
                }
                );
        }


        $scope.saveProductReport = function () {
            var frame = document.createElement("iframe");
            document.body.appendChild(frame);
            frame.setAttribute("style", "display:none");
            var form = document.createElement("form");
            form.action = "http://localhost:8080/buffet/productreporttofile";
            frame.appendChild(form);
            form.method = "POST";
            form.submit();
            frame.remove();
        }


        $scope.createChartProduct = function () {
            if($scope.data.length>0){
            var ctx = document.getElementById('productChart').getContext('2d');
            var chart = new Chart(ctx, {

                type: 'doughnut',
                   data: {
                    labels: $scope.labels,
                    datasets: [{
                        label: "Termékek fogyása az aktuális hónapban",
                        backgroundColor: $scope.colors,
                        borderColor: 'azure',
                        data: $scope.data,
                    }]
                },
              


            });
        }
        }
    });