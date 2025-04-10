import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

public class ConsultarAutorServlet extends HttpServlet {
	

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            GestionBD.abrirConexion();
            ResultSet autores = GestionBD.consultarAutores();

            out.println("<html><body><h1>Autores</h1><ul>");
            while (autores.next()) {
                out.println("<li>ID: " + autores.getInt("Id_Autor")
                        + ", Nombre: " + autores.getString("nombreAutor")
                        + ", Nacionalidad: " + autores.getString("Nacionalidad")
                        + ", Fecha de nacimiento: " + autores.getDate("Fnacimiento") + "</li>");
            }
            out.println("</ul></body></html>");

            autores.close();
            GestionBD.cerrarConexion();
        } catch (SQLException e) {
            out.println("Error: " + e.getMessage());
        }
    }
}
