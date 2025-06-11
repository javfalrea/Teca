function buscarGeneros() {	
	var nombre = document.getElementById("nombreGenero").value.trim();
	fetch("http://localhost:9999/buscar_genero?nombre=" + nombre)
	.then(res => res.text())
	.then(json => {
		const posts = JSON.parse(json);
		let tabla = "";
		posts.forEach(fila => {
			tabla += "<tr>";
			tabla += "<td>" + fila.codigo + "</td>";
			tabla += "<td>" + fila.nombre + "</td>";
			tabla += "<td><button onclick=\"abrirModificarGenero('" + fila.id + "','" + fila.codigo + "','" + fila.nombre + "')\">Modificar</button><button onclick=\"eliminarGenero('" + fila.id + "')\">Eliminar</button></td>";
			tabla += "<td><button onclick=\"abrirAgregarGenero('" + fila.id + "')\">Agregar género</button></td>";
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

function abrirModificarGenero(id, codigo, nombre) {
	document.getElementById("idGenero").value = id;
	document.getElementById("codigo").value = codigo;
	document.getElementById("nombre").value = nombre;

	var modal = document.getElementById("modalGenero");
	modal.style.display = "block";	
}

function cerrarCrearGenero() {
	document.getElementById("idGenero").value = "";
	document.getElementById("codigo").value = "";
	document.getElementById("nombre").value = "";
		
	var modal = document.getElementById("modalGenero");
	modal.style.display = "none";	
}

function gestionarGenero() {
	var idGenero = document.getElementById("idGenero").value;
	var codigo = document.getElementById("codigo").value;
	var nombre = document.getElementById("nombre").value;
	
	var url="";
	
	if(idGenero != "") {
		url = "http://localhost:9999/modificar_genero?idGenero=" + idGenero + "&codigo=" + codigo + "&nombre=" + nombre;
	} else {
		url = "http://localhost:9999/crear_genero?codigo=" + codigo + "&nombre=" + nombre;
	}
	
	fetch(url)
	.then(res => res.text())
	.then(res => {
		buscarGeneros();
		cerrarCrearGenero();
	})
	.catch(e => {
		console.log('Error importando archivo' + e.message);
	});
	
}

function abrirAgregarGenero(id) {
	document.getElementById("idAgregarGenero").value = id;
	var modal = document.getElementById("modalAgregarGenero");
	modal.style.display = "block";
}

function cerrarAgregarGenero() {
	document.getElementById("idAgregarGenero").value = "";
	document.getElementById("pelicula").selectedIndex = 0;
		
	var modal = document.getElementById("modalAgregarGenero");
	modal.style.display = "none";	
}

function gestionarAgregarGenero(idGenero) {
	var idGenero = document.getElementById("idAgregarGenero").value;
	var pelicula = document.getElementById("pelicula").value;
	
	
	fetch("http://localhost:9999/anadir_genero?idPelicula=" + pelicula + "&idGenero=" + idGenero)
	.then(res => res.text())
	.then(res => {
		buscarGeneros();
		cerrarAgregarGenero();
	})
	.catch(e => {
		console.log('Error importando archivo' + e.message);
	});
	
}

function eliminarGenero(idGenero) {
	if(!confirm("Confirma si quieres eliminarlo")) {
		return;
	}
	fetch("http://localhost:9999/eliminar_genero?id=" + idGenero)
	.then(res => res.text())
	.then(res => {
		buscarGeneros();
	})
	.catch(e => {
		console.log('Error importando archivo' + e.message);
	})
}

function cargaInicial() {	
	let selectPelicula = document.getElementById("pelicula"); 
	
	fetch("buscar_peliculas?titulo=&participante=&idPais=0&idGenero=0")
	.then(res => res.text())
	.then(json => {
		const posts = JSON.parse(json);
		let opt = document.createElement("option");
		opt.value = 0;
		opt.text = "";
		selectPelicula.add(opt);
		posts.forEach(pelicula => {
			opt = document.createElement("option");
			opt.value = pelicula.id;
			opt.text = pelicula.titulo;
			selectPelicula.add(opt);
		});
	})
}
