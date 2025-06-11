package com.teca.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teca.entities.Serie;
import com.teca.entities.SerieValoracion;
import com.teca.entities.Usuario;
import com.teca.util.General;

@Service
public class SerieValoracionService {
	
	@Autowired
	private SerieService s;

	@Autowired
	private UsuarioService u;

	public SerieValoracion crear(Long idSerie, Long idUsuario, Boolean vista, Double valoracion, Boolean fav, String critica) throws SQLException {

		Connection conn = General.conexion();

		String insertValoracion = "INSERT INTO serie_valoracion (id_serie, id_usuario, vista, valoracion, fav, critica) VALUES (?, ?, ?, ?, ?, ?)";

		PreparedStatement ps = conn.prepareStatement(insertValoracion, Statement.RETURN_GENERATED_KEYS);
		ps.setLong(1, idSerie);
		ps.setLong(2, idUsuario);
		ps.setBoolean(3, vista);
		ps.setDouble(4, valoracion);
		ps.setBoolean(5, fav);
		ps.setString(6, critica);

		int respuesta = ps.executeUpdate();
		if (respuesta != 1) {
			throw new SQLException("No se ha podido crear la valoracion");
		}

		Serie serie = s.buscarPorId(idSerie);

		Usuario usuario = u.buscarPorId(idUsuario);

		SerieValoracion serieValoracion = new SerieValoracion(serie, usuario, vista, valoracion, fav, critica);

		ps.close();
		conn.close();

		return serieValoracion;
	}

	public SerieValoracion modificar(Long idSerie, Long idUsuario, Boolean vista, Double valoracion, Boolean fav, String critica) throws SQLException {
		Connection conn = General.conexion();

		String updateValoracion = "UPDATE serie_valoracion SET vista = ?, valoracion = ?, fav = ?, critica = ? WHERE id_serie = ? AND id_usuario = ?";

		PreparedStatement ps = conn.prepareStatement(updateValoracion);
		ps.setBoolean(1, vista);
		ps.setDouble(2, valoracion);
		ps.setBoolean(3, fav);
		ps.setString(4, critica);
		ps.setLong(5, idSerie);
		ps.setLong(6, idUsuario);

		int respuesta = ps.executeUpdate();
		if (respuesta != 1) {
			throw new SQLException("No se ha podido modificar la valoración");
		}

		Serie serie = s.buscarPorId(idSerie);

		Usuario usuario = u.buscarPorId(idUsuario);

		SerieValoracion serieValoracion = new SerieValoracion(serie, usuario, vista, valoracion, fav, critica);

		ps.close();
		conn.close();

		return serieValoracion;
	}

	public void eliminar(Long idSerie, Long idUsuario) throws SQLException {
		Connection conn = General.conexion();

		String deleteValoracion = "DELETE FROM serie_valoracion WHERE id_serie = ? AND id_usuario = ?";

		PreparedStatement ps = conn.prepareStatement(deleteValoracion);
		ps.setLong(1, idSerie);
		ps.setLong(2, idUsuario);

		int respuesta = ps.executeUpdate();
		if (respuesta != 1) {
			throw new SQLException("No se ha podido eliminar la valoración");
		}

		ps.close();
		conn.close();
	}

	public SerieValoracion buscarPorSerieYUsuario(Long idSerie, Long idUsuario) throws SQLException {
		Connection conn = General.conexion();

		String selectValoracion = "SELECT * FROM serie_valoracion WHERE id_serie = ? AND id_usuario = ?";

		PreparedStatement ps = conn.prepareStatement(selectValoracion);
		ps.setLong(1, idSerie);
		ps.setLong(2, idUsuario);

		ResultSet rs = ps.executeQuery();
		rs.next();
		Boolean vista = rs.getBoolean("vista");
		Double valoracion = rs.getDouble("valoracion");
		Boolean fav = rs.getBoolean("fav");
		String critica = rs.getString("critica");

		Serie serie = s.buscarPorId(idSerie);

		Usuario usuario = u.buscarPorId(idUsuario);

		SerieValoracion serieValoracion = new SerieValoracion(serie, usuario, vista, valoracion, fav, critica);

		ps.close();
		conn.close();

		return serieValoracion;
	}

}
