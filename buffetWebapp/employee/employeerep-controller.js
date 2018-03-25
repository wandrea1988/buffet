angular.module('buffetApp')

    .controller('employeerepController', function ($scope, employeerepService, $location) {


        $scope.init = function () {
            employeerepService.getAllEmployeeReport()
                .then(function (response) {
                    $scope.employeereports = response.data;
                    $scope.labels = [];
                    $scope.data = [];
                    for (var i = 0; i < $scope.employeereports.length; i++) {
                        var employeeName = $scope.employeereports[i].employeeName;
                        var amount = $scope.employeereports[i].sumPrice;
                        $scope.labels.push(employeeName);
                        $scope.data.push(amount);
                    }
                    $scope.createChartEmployee();
                },
                function (error) {
                    console.log(error)
                }
                );
        }


        $scope.saveEmployeeReport = function () {
            var frame = document.createElement("iframe");
            document.body.appendChild(frame);
            frame.setAttribute("style", "display:none");
            var form = document.createElement("form");
            form.action = "http://localhost:8080/buffet/employeereporttofile";
            frame.appendChild(form);
            form.method = "POST";
            form.submit();
            frame.remove();
        }

        $scope.createChartEmployee = function () {
            if($scope.data.length>0){

            var ctx = document.getElementById('employeeChart').getContext('2d');
            var chart = new Chart(ctx, {

                type: 'bar',


                data: {
                    labels: $scope.labels,
                    datasets: [{
                        label: "Dolgozó fogyasztása az aktuális hónapban (Ft)",
                        backgroundColor: 'lightblue',
                        borderColor: 'azure',
                        data: $scope.data,
                    }]
                },

                options: {
                    scales: {
                        yAxes: [{
                            scaleLabel: {
                                display: true,
                                labelString: 'Fogyasztás (Ft)',
                            },

                            ticks: {
                                min: 0
                            }
                        }]
                    },

                }
            });
        }
    }
    });