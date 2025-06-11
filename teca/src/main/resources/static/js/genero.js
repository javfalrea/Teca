function buscarGeneros() {	
	var nombre = document.getElementById("nombreGenero").value.trim();
	var nombreCodificado = encodeURIComponent(nombre);
	
	fetch("http://localhost:9999/genero/buscarPorNombre?nombre=" + nombreCodificado)
	.then(res => res.text())
	.then(json => {
		const posts = JSON.parse(json);
		let tabla = "";
		posts.forEach(fila => {
			tabla += "<tr>";
			tabla += "<td>" + fila.nombre + "</td>";
			tabla += "<td><button onclick=\"abrirModificarGenero('" + fila.id + "','" + fila.nombre.replace(/'/g, "\\'") + "')\">Modificar</button><button onclick=\"eliminarGenero('" + fila.id + "')\">Eliminar</button></td>";
			tabla += "</tr>";
		});	
		
		var contenidoTabla = document.getElementById("contenidoTabla");		
		contenidoTabla.innerHTML = tabla;
	})
	.catch(e => {
		console.log('Error importando archivo: ' + e.message);
	});
}

function abrirCrearGenero() {
	var modal = document.getElementById("modalGenero");
	modal.style.display = "block";
}

function abrirModificarGenero(id, nombre) {
	document.getElementById("idGenero").value = id;
	document.getElementById("nombre").value = nombre;

	var modal = document.getElementById("modalGenero");
	modal.style.display = "block";	
}

function cerrarCrearGenero() {
	document.getElementById("idGenero").value = "";
	document.getElementById("nombre").value = "";
		
	var modal = document.getElementById("modalGenero");
	modal.style.display = "none";	
}

function gestionarGenero() {
	var id = document.getElementById("idGenero").value;
	var nombre = document.getElementById("nombre").value;
	var nombreCodificado = encodeURIComponent(nombre);
	
	var url = "";
	var metodo;

	if (id != "") {
		var idCodificado = encodeURIComponent(id);
		url = "http://localhost:9999/genero/modificar?id=" + idCodificado + "&nombre=" + nombreCodificado;
		metodo = {method:'PUT'};
	} else {
		url = "http://localhost:9999/genero/crear?nombre=" + nombreCodificado;
		metodo = {method:'POST'};
	}
	
	fetch(url, metodo)
	.then(res => res.text())
	.then(res => {
		buscarGeneros();
		cerrarCrearGenero();
	})
	.catch(e => {
		console.log('Error importando archivo: ' + e.message);
	});
}

function eliminarGenero(idGenero) {
	if (!confirm("Confirma si quieres eliminarlo")) {
		return;
	}
	var idCodificado = encodeURIComponent(idGenero);

	fetch("http://localhost:9999/genero/eliminar?id=" + idCodificado, { method: 'DELETE' })
	.then(res => res.text())
	.then(res => {
		buscarGeneros();
	})
	.catch(e => {
		console.log('Error importando archivo: ' + e.message);
	});
}
