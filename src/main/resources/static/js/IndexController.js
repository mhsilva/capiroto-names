var app = angular.module('CapirotoNames');
app.controller('IndexController', [ '$scope', '$http', function($scope, $http) {
	$scope.nome;
	$scope.nomesList;
	
	$scope.refresh = function() {
		$http({
			url : "/api/capiroto",
			method : "GET",
			headers : {
				'Content-Type' : 'application/json'
			},
			params : {
				type : "single"
			},
		}).then(function(response) {
			$scope.nome = response.data[0].nome;
		});
		$http({
			url : "/api/capiroto",
			method : "GET",
			headers : {
				'Content-Type' : 'application/json'
			},
			params : {
				type : "many"
			},
		}).then(function(response) {
			$scope.nomesList = response.data;
		});
	};

	$scope.adicionar = function() {
		$http({
			url : "/api/capiroto",
			method : "POST",
			data : {
				nome : $scope.novoNome
			},
			headers : {
				'Content-Type' : 'application/json'
			}
		});
		$scope.refresh();
	};
	
	$scope.deleteRow = function(row, index) {
		$http({
			url : "/api/capiroto",
			method : "DELETE",
			params : {
				id : row.x.id,
				nome : row.x.nome
			},
			headers : {
				'Content-Type' : 'application/json'
			}
		});
		$scope.nomesList.splice(index, 1);
	};
} ]);