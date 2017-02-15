//Controller Part
petStore.controller("ViewPetController", [ '$scope', '$http',
		function($scope, $http) {
			// Initialize page with default data which is blank in this example
			$scope.pets = [];

			_refreshPageData();

			function _refreshPageData() {
				$http({
					method : 'GET',
					url : 'petStore/petDetails'
				}).then(function successCallback(response) {
					$scope.pets = response.data;
				}, function errorCallback(response) {
					console.log(response.status);
				});
			}

		} ]);