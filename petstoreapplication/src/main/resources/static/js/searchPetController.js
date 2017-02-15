//Controller Part
petStore.controller("SearchPetController", [ '$scope', '$http',
		function($scope, $http) {
			//Initialize page with default data which is blank in this example
			$scope.pets = [];

			$scope.pet = null;

			$scope.form = {
				petId : ""
			};
			
			$scope.table="display:none";

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

			$scope.searchPet = function(petId) {
				$http({
					method : 'GET',
					url : 'petStore/searchPet/' + petId.petId
				}).then(function successCallback(response) {
					$scope.pet = response.data;
					_clearForm();
				}, function errorCallback(response) {
					console.log(response.status);
				});

				//Clear the form
				function _clearForm() {
					$scope.table="display";
					$scope.form.petId = "";
				}
			}

		} ]);