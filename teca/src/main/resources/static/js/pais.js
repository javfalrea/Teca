function buscarPaises() {	
	var nombre = document.getElementById("nombrePais").value.trim();
	var nombreCodificado = encodeURIComponent(nombre);

	fetch("http://localhost:9999/pais/buscarPorNombre?nombre=" + nombreCodificado)
	.then(res => res.text())
	.then(json => {
		const posts = JSON.parse(json);
		let tabla = "";
		posts.forEach(fila => {
			tabla += "<tr>";
			tabla += "<td>" + fila.nombre + "</td>";
			tabla += "<td><img title='" + fila.nombre + "' src='" + fila.bandera + "' style='width:16px; height:auto; display:block; margin:auto;'></td>";
			tabla += "<td><button onclick=\"abrirModificarPais('" + fila.id + "','" + fila.nombre + "','" + fila.bandera + "')\">Modificar</button><button onclick=\"eliminarPais('" + fila.id + "')\">Eliminar</button></td>";
			tabla += "</tr>";
		});	
		
		var contenidoTabla = document.getElementById("contenidoTabla");		
		contenidoTabla.innerHTML = tabla;
	})
	.catch(e => {
		console.log('Error importando archivo: ' + e.message);
	});
}

function abrirCrearPais() {
	var modal = document.getElementById("modalPais");
	modal.style.display = "block";
}

function abrirModificarPais(id, nombre, bandera) {
	document.getElementById("idPais").value = id;
	document.getElementById("nombre").value = nombre;
	document.getElementById("bandera").value = bandera;

	var modal = document.getElementById("modalPais");
	modal.style.display = "block";	
}

function cerrarCrearPais() {
	document.getElementById("idPais").value = "";
	document.getElementById("nombre").value = "";
	document.getElementById("bandera").value = "";
		
	var modal = document.getElementById("modalPais");
	modal.style.display = "none";	
}

function gestionarPais() {
	var idPais = document.getElementById("idPais").value;
	var nombre = document.getElementById("nombre").value;
	var bandera = document.getElementById("bandera").value;

	var nombreCodificado = encodeURIComponent(nombre);
	var banderaCodificada = encodeURIComponent(bandera);
	var url = "";
	var metodo;

	if (idPais != "") {
		var idCodificado = encodeURIComponent(idPais);
		url = "http://localhost:9999/pais/modificar?id=" + idCodificado + "&nombre=" + nombreCodificado + "&bandera=" + banderaCodificada;
		metodo = { method: 'PUT' };
	} else {
		url = "http://localhost:9999/pais/crear?nombre=" + nombreCodificado + "&bandera=" + banderaCodificada;
		metodo = { method: 'POST' };
	}

	fetch(url, metodo)
	.then(res => res.text())
	.then(res => {
		buscarPaises();
		cerrarCrearPais();
	})
	.catch(e => {
		console.log('Error importando archivo: ' + e.message);
	});
}

function eliminarPais(idPais) {
	var idCodificado = encodeURIComponent(idPais);

	if (!confirm("Confirma si quieres eliminarlo")) {
		return;
	}
	fetch("http://localhost:9999/pais/eliminar?id=" + idCodificado, { method: 'DELETE' })
	.then(res => res.text())
	.then(res => {
		buscarPaises();
	})
	.catch(e => {
		console.log('Error importando archivo: ' + e.message);
	});
}
