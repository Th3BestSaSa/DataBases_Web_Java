import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.*;

public class IntroducirAutorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        int idAutor = Integer.parseInt(request.getParameter("idAutor"));
        String nombre = request.getParameter("nombreAutor");
        String nacionalidad = request.getParameter("nacionalidad");
        String fechaNacimiento = request.getParameter("fechaNacimiento");

        try {
            GestionBD.abrirConexion();
            GestionBD.insertarAutor(idAutor, nombre, nacionalidad, fechaNacimiento);
            GestionBD.cerrarConexion();
            response.sendRedirect("databases.html"); // redireccionar a página principal
        } catch (SQLException e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}

