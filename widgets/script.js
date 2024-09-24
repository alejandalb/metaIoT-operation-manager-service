self.onInit = function() {
    document.getElementById('apiButton').addEventListener('click', function() {
      axios.post('http://localhost:8080/op/publish', {
        type: "UPDATE",
        targetDevice: {
          group: "SEMAFOROS",
          deviceType: "SENSOR"
        },
        packages: [
          {
            name: "paho-mqtt",
            version: "3.75"
          },
          {
            name: "lib-curl",
            version: "7.38"
          }
        ]
      }, {
        headers: {
          'accept': '*/*',
          'Content-Type': 'application/json'
        }
      })
      .then(function (response) {
        console.log('Data:', response.data);
      })
      .catch(function (error) {
        console.error('Error:', error);
      });
    });
  };
  