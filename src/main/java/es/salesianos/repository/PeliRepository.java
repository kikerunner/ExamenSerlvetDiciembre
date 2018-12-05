package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.model.Actor;
import es.salesianos.model.Pelicula;

public class PeliRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	AbstractConnection manager = new H2Connection();
	Actor personaendatabase = null;
	
	
	
	public List<Pelicula>searchAll() {
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = conn
					.prepareStatement("SELECT * FROM FILM");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Pelicula peliculaInDatabase = new Pelicula();
				peliculaInDatabase.setCod(resultSet.getInt(1));
				peliculaInDatabase.setTitle((resultSet.getString(2)));
				peliculaInDatabase.setCodOwner((resultSet.getInt(3)));
				
				peliculas.add(peliculaInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
		}

		manager.close(conn);
		return peliculas;
		
	}
	
	public Pelicula searchOne(Pelicula pelicula) {
		Pelicula peliculaInDatabase = null;
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = conn
					.prepareStatement("SELECT * FROM FILM WHERE COD = ?");
			preparedStatement.setInt(1, pelicula.getCodOwner());
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				peliculaInDatabase = new Pelicula();
				peliculaInDatabase.setCod(resultSet.getInt(1));
				peliculaInDatabase.setTitle((resultSet.getString(2)));
				peliculaInDatabase.setCodOwner((resultSet.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
		}

		manager.close(conn);
		return peliculaInDatabase;
		
	}
	

	
	
	public void insertPelicula(Pelicula pelicula) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO FILM(TITTLE,CODOWNER) VALUES (?, ?)");
			preparedStatement.setString(1, pelicula.getTitle());
			preparedStatement.setInt(2, pelicula.getCodOwner());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
		}

		manager.close(conn);
	}
	
	public Actor selectOwnerByPet(String nomMascota){
		Actor personaendatabase = null;
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = conn
					.prepareStatement("SELECT p.CodPersona, p.nombre, p.apellido FROM Mascotas AS m, Personas as p WHERE p.codPersona = m.codPersona AND m.nomMascota = ?");
			preparedStatement.setString(1, nomMascota);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				personaendatabase = new Actor();
				//personaendatabase.setCodPersona(resultSet.getInt(1));
				personaendatabase.setName(resultSet.getString(2));
				//personaendatabase.setApellido(resultSet.getString(3));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
		}

		manager.close(conn);
		return personaendatabase;
	}
	
	public Pelicula selectOnePlicula(int CodPersona) {
		Pelicula personaInDatabase = null;
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = conn
					.prepareStatement("SELECT * FROM FILM WHERE Cod = ?");
			preparedStatement.setInt(1, CodPersona);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
			personaInDatabase = new Pelicula();
			personaInDatabase.setCod((resultSet.getInt(1)));
			personaInDatabase.setTitle((resultSet.getString(2)));
			personaInDatabase.setCodOwner((resultSet.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
		}

		manager.close(conn);
		return personaInDatabase;
	}
	
	public void borrarPelicula(Pelicula pelicula) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("DELETE FROM Film WHERE COD = ?");	
			preparedStatement.setInt(1, pelicula.getCod());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}
}
