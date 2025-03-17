package Services;

import java.sql.*;
import DB.DataBase;
import Models.PQRS;

public class PqrsService {

    public void RegistrarPqrs(PQRS pqrs) {
        String sql = "INSERT INTO pqrs (tipoComentario, descripcion, idClienteComun) VALUES (?, ?, ?)";

        try (Connection conn = DataBase.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, pqrs.getTipoComentario());
            pstmt.setString(2, pqrs.getDescripcion());

            if (pqrs.getIdClienteComun() != null) {
                pstmt.setInt(3, pqrs.getIdClienteComun().getIdClienteComun());
            } else {
                pstmt.setNull(3, java.sql.Types.INTEGER);
            }

            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected > 0 ? "Comentario creado exitosamente." : "No se insertó ningún registro.");

        } catch (SQLException ex) {
            System.out.println("Error al crear el comentario: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void ImprimirPqrs() {
        String sql = "SELECT * FROM pqrs";

        try (Connection conn = DataBase.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("///////////////////////////////////////////////////////");
                System.out.println("ID PQRS: " + rs.getInt("idPQRS"));
                System.out.println("Comentario: " + rs.getString("tipoComentario"));
                System.out.println("Descripcion: " + rs.getString("descripcion"));
                System.out.println("ID Cliente: " + rs.getInt("idClienteComun"));
                System.out.println("------------------------------------------------------");
            }

        } catch (SQLException ex) {
            System.out.println("Error al imprimir los PQRS: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void EliminarPqrs(int idPQRS) { 
        String sql = "DELETE FROM pqrs WHERE idPQRS = ?";

        try (Connection conn = DataBase.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idPQRS);
            int rowsAffected = pstmt.executeUpdate();

            System.out.println(rowsAffected > 0 ? "PQRS eliminado correctamente." : "PQRS con ID " + idPQRS + " no encontrado.");

        } catch (SQLException ex) {
            System.out.println("Error al eliminar PQRS: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void ModificarPqrs(int seleccion, String info, int idPQRS) {
        String columna;
        switch (seleccion) {
            case 1: columna = "tipoComentario"; break;
            case 2: columna = "descripcion"; break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        String sql = "UPDATE pqrs SET " + columna + " = ? WHERE idPQRS = ?";

        try (Connection conn = DataBase.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, info);
            pstmt.setInt(2, idPQRS);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected > 0 ? "PQRS modificado correctamente." : "PQRS con ID " + idPQRS + " no encontrado.");

        } catch (SQLException ex) {
            System.out.println("Error al modificar PQRS: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}





