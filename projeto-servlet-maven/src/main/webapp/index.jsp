<html>
<body>
<h2>Hello World! Home</h2>

<script>
	var data = JSON.stringify({
	  "nome": "willians2",
	  "idade": 36,
	  "email": "masculo@gmail.com"
	});

	var xhr = new XMLHttpRequest();
	xhr.withCredentials = true;

	xhr.addEventListener("readystatechange", function () {
	  if (this.readyState === 4) {
	    console.log(this.responseText);
	    document.write("sucesso: " + this.responseText);
	  }
	});

	
	function buscar(){
		xhr.open("POST", "http://localhost:8080/projeto-servlet-maven/buscar");
		xhr.setRequestHeader("Content-Type", "application/json");
		xhr.setRequestHeader("cache-control", "no-cache");
		xhr.setRequestHeader("Postman-Token", "e1a90ffe-21d7-4c46-ac22-2223491f5fab");
	
		xhr.send(data);
	}
</script>

<button onClick="buscar()">agora vai buscar</button>
</body>
</html>
