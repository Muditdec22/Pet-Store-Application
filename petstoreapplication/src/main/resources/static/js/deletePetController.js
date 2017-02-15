//Controller Part
petStore.controller("DeletePetController", [ '$scope', '$http',
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

			$scope.removePet = function(pet) {
				$http({
					method : 'DELETE',
					url : 'petStore/deletePet/' + pet.petId
				}).then(_success, _error);
			};

			function _success(response) {
				_refreshPageData();
			}

			function _error(response) {
				console.log(response.status);
			}

		} ]);