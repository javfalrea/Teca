package com.teca.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class General {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static final Connection conexion() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/teca", "root", "");
	}
	
	public static Long obtenerClaveGenerada(PreparedStatement ps) throws SQLException {
		ResultSet claveGenerada = ps.getGeneratedKeys();
		if(claveGenerada.next()) {
			return claveGenerada.getLong(1);
		} else {
			throw new SQLException("No se pudo obtener el id del género asociado.");
		}
	}

}
