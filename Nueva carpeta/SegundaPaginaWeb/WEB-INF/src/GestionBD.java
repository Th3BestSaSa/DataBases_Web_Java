import java.sql.*;

public class GestionBD {

	private static final String URL_BD = "jdbc:mysql://localhost:3306/celiagandulduquepractica2";
	private static final String CONTRASENNA = "";
	private static final String USUARIO = "root";
	private static Connection conexion;
	
	
	
	

	public static void abrirConexion() throws SQLException {

		conexion = DriverManager.getConnection(URL_BD, USUARIO, CONTRASENNA);

	}

	public static void cerrarConexion() throws SQLException {

		conexion.close();

	}

	public static int insertarAutor( int Id_Autor,String nombreAutor, String nac, String fnacAutor) throws SQLException {

		int filasAfectadas;
		Statement sentencia = conexion.createStatement();

		filasAfectadas = sentencia.executeUpdate("INSERT INTO autor (Id_Autor"
				+ ",nombreAutor, Nacionalidad, Fnacimiento) VALUES  " + "('"+ Id_Autor +"','"
				+ nombreAutor + "', '" + nac + "', '" + fnacAutor + "')");

		return filasAfectadas;

	}
	public static boolean eliminarLibro(int isbn) throws SQLException {
		boolean eliminar= false;

		if(eliminar==false){
			Statement sentencia = conexion.createStatement();
			int filasAfectadas = sentencia.executeUpdate( "DELETE FROM libro WHERE libro.Isbn =" + isbn);
			eliminar= true;
		}
		return eliminar;
		
	}

	public static int insertarLibro(int isbn, String editorial, String titulo, String idioma, String nombreAutor, int tipo)
			throws SQLException {

		int filasAfectadas;
		if (tipo >6) {
			throw new SQLException ("No existe esa tematica");
		}
		Statement sentencia = conexion.createStatement();
		filasAfectadas = sentencia.executeUpdate("INSERT INTO libro VALUES " + "(" + isbn + ", '" + editorial + "', '"
				+ titulo + "', '" + idioma + "','" + nombreAutor + "', '" + tipo + "')");
		//para hacer la lista de las tematicas debo hacer un select

		return filasAfectadas;
	}

	public static ResultSet consultarAutores() throws SQLException {

		ResultSet resultadoQuery;
		Statement sentencia = conexion.createStatement();
		resultadoQuery = sentencia.executeQuery("select * from autor");

		return resultadoQuery;
	}

	public static ResultSet consultarLibros() throws SQLException {

		ResultSet resultadoQuery;
		Statement sentencia = conexion.createStatement();
		resultadoQuery = sentencia.executeQuery("select * from libro");
				
		return resultadoQuery;

	}

	public static ResultSet consultarAutoresPorNombre(String nombreAutor) throws SQLException {

		ResultSet resultadoQuery;
		Statement sentencia = conexion.createStatement();
		resultadoQuery = sentencia.executeQuery("select * from autor WHERE nombreAutor LIKE '%" + nombreAutor + "%'");

		return resultadoQuery;
	}
	public static int cambiarTematica(String tipo, int isbn) throws SQLException {
		int filasAfectadas;

		Statement sentencia = conexion.createStatement();
		filasAfectadas = sentencia.executeUpdate("UPDATE `libro` SET `Id_Tematica` = '("+tipo+")' WHERE `libro`.`Isbn` = '("+isbn +")'");
		
		return filasAfectadas;
	}
}
