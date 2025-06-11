var idSerieVolver;

function getIdTemporadaDesdeUrl() {
	const params = new URLSearchParams(window.location.search);
	return params.get('id');
}

function cargarDetalleTemporada() {

	const id = getIdTemporadaDesdeUrl();

	fetch(`http://localhost:9999/temporada/buscarPorId?id=${encodeURI(id)}`)
		.then(res => res.json())
		.then(p => {
			document.getElementById("titulo").textContent = p.serie.titulo;
			document.getElementById("numero").textContent = p.numero;
			document.getElementById("anioEstreno").textContent = p.anioEstreno;
			document.getElementById("numCapitulos").textContent = p.numCapitulos;
			document.getElementById("duracionMedia").textContent = p.duracionMedia;
			document.getElementById("sinopsis").textContent = p.sinopsis;
			document.getElementById("imagen").innerHTML = "<img title='" + p.serie.titulo + "' src='" + p.serie.imagen + "'>";
			idSerieVolver = p.serie.id;
		})
		.catch(e => console.log("Error: " + e.message));

}

function volverPaginaSerie() {
	window.location.href = `detalleSerie.html?id=${encodeURI(idSerieVolver)}`;
}

function abrirModificarTemporada() {
	var id = getIdTemporadaDesdeUrl();
	
	fetch(`http://localhost:9999/temporada/buscarPorId?id=${encodeURI(id)}`)
		.then(res => res.json())
		.then(p => {
			document.getElementById("numeroT").value = p.numero;
			document.getElementById("anioEstrenoT").value = p.anioEstreno;
			document.getElementById("numCapitulosT").value = p.numCapitulos;
			document.getElementById("duracionMediaT").value = p.duracionMedia;
			document.getElementById("sinopsisT").value = p.sinopsis;
		})
		.catch(e => console.log("Error: " + e.message));
	var modal = document.getElementById("modalTemporada");
	modal.style.display = "block";
}

function cerrarCrearTemporada() {
	var modal = document.getElementById("modalTemporada");
	modal.style.display = "none";
} 

function crearTemporada() {
	var id = getIdTemporadaDesdeUrl();
	var numero = document.getElementById("numeroT").value;
	var anioEstreno = document.getElementById("anioEstrenoT").value;
	var numCapitulos = document.getElementById("numCapitulosT").value;
	var duracionMedia = document.getElementById("duracionMediaT").value;
	var sinopsis = document.getElementById("sinopsisT").value;
	
	var url = "http://localhost:9999/temporada/modificar?id=" + id + "&numero=" + numero + "&anioEstreno=" + anioEstreno + "&numCapitulos=" + numCapitulos + "&duracionMedia=" + duracionMedia + "&sinopsis=" + sinopsis  + "&idSerie=" + idSerieVolver;

	fetch(url, { method:'PUT' })
	.then(res => res.text())
	.then(res => {
		cargarDetalleTemporada();
		cerrarCrearTemporada();
	})
	.catch(e => {
		console.log('Error importando archivo' + e.message);
	});
	
}
