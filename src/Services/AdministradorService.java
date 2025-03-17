package Services;

import java.sql.*;
import DB.DataBase;
import Models.Administrador;

public class AdministradorService {

    public void RegistrarAdministrador(Administrador administrador) {
        Connection conn = DataBase.conectar();
        if (conn != null) {
            try {
                String sql = "INSERT INTO Administradores (nombreAdmin, userAdmin, passAdmin, idrol) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, administrador.getNombreAdmin()); 
                pstmt.setString(2, administrador.getUserAdmin());
                pstmt.setString(3, administrador.getPassAdmin());
                pstmt.setInt(4, administrador.getIdrol().getIdrol());
                pstmt.executeUpdate();
                System.out.println("Administrador creado exitosamente");
            } catch (SQLException ex) {
                System.out.println("Error al crear el Administrador: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                DataBase.Desconectar(conn);
            }
        }
    }

    public void ImprimirAdministrador() {
        Connection conn = DataBase.conectar();
        if (conn != null) {
            try {
                String sql = "SELECT * FROM Administradores";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    System.out.println("///////////////////////////////////////////////////////");
                    System.out.println("ID Admin: " + rs.getInt("idAdmin"));
                    System.out.println("Nombre Admin: " + rs.getString("nombreAdmin")); 
                    System.out.println("Usuario Admin: " + rs.getString("userAdmin"));
                    System.out.println("Contraseña: " + rs.getString("passAdmin"));
                    System.out.println("ID Rol: " + rs.getInt("idrol"));
                    System.out.println("------------------------------------------------------");
                }
            } catch (SQLException ex) {
                System.out.println("Error al imprimir Administradores: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                DataBase.Desconectar(conn);
            }
        }
    }

    public void EliminarAdministrador(int idAdmin) { 
        Connection conn = DataBase.conectar();
        if (conn != null) {
            try {
                String sql = "DELETE FROM Administradores WHERE idAdmin = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, idAdmin);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Administrador eliminado correctamente.");
                } else {
                    System.out.println("Administrador con ID " + idAdmin + " no encontrado.");
                }
            } catch (SQLException ex) {
                System.out.println("Error al eliminar Administrador: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                DataBase.Desconectar(conn);
            }
        }
    }

    public void ModificarAdministrador(int seleccion, String info, int idAdmin) {
        Connection conn = DataBase.conectar();
        if (conn != null) {
            try {
                String columna = "";
                switch (seleccion) {
                    case 1: columna = "nombreAdmin"; break;
                    case 2: columna = "userAdmin"; break;
                    case 3: columna = "passAdmin"; break;
                    default:
                        System.out.println("Opción no válida.");
                        return;
                }

                String sql = "UPDATE Administradores SET " + columna + " = ? WHERE idAdmin = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, info); 
                pstmt.setInt(2, idAdmin); // Filtrado por ID

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Administrador modificado correctamente.");
                } else {
                    System.out.println("Administrador con ID " + idAdmin + " no encontrado.");
                }
            } catch (SQLException ex) {
                System.out.println("Error al modificar Administrador: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                DataBase.Desconectar(conn);
            }
        }
    }
}

/**
package Services;

import DB.DataBase;
import Models.Administrador;

public class AdministradorService {
    public DataBase dbAdmin;
    
    public AdministradorService(){
        this.dbAdmin = new DataBase();
    }
    
    public void CrearAdministrador(Administrador admin){
        this.dbAdmin.getAdministrador().add(admin);
    }
    
    public void ImprimirDatos(){
        for(int i = 0; i< this.dbAdmin.getAdministrador().size(); i++){
            System.out.println("Inicio Datos----------------------------------------------------");
            System.out.println("ID " + this.dbAdmin.getAdministrador().get(i).getIdAdministrador());
            System.out.println("Nombres: " + this.dbAdmin.getAdministrador().get(i).getNombre());
            System.out.println("Apellidos " + this.dbAdmin.getAdministrador().get(i).getApellido());
            System.out.println("Usuario " + this.dbAdmin.getAdministrador().get(i).getUsuario());
            System.out.println("Contraseña " + this.dbAdmin.getAdministrador().get(i).getContraseña());
            System.out.println("E-mail: " + this.dbAdmin.getAdministrador().get(i).getEmail());
            System.out.println("Teléfono " + this.dbAdmin.getAdministrador().get(i).getTelefono());
            System.out.println("Fin Datos****************************************************");
        }
    }
    
    public void EliminarAdmin(int id){
        for(int i = 0; i< this.dbAdmin.getAdministrador().size(); i++){
            if(this.dbAdmin.getAdministrador().get(i).getIdAdministrador() == id){
                this.dbAdmin.getAdministrador().remove(i);
            }
        }
    }
    
    public void ModificarAdministrador(int id, int opcion, String dato){
        for(int i = 0; i< this.dbAdmin.getAdministrador().size(); i++){
            if(this.dbAdmin.getAdministrador().get(i).getIdAdministrador() == id){
            switch (opcion) {
                case 1 -> this.dbAdmin.getAdministrador().get(i).setNombre(dato);
                case 2 -> this.dbAdmin.getAdministrador().get(i).setApellido(dato);
                case 3 -> this.dbAdmin.getAdministrador().get(i).setUsuario(dato);
                case 4 -> this.dbAdmin.getAdministrador().get(i).setContraseña(dato);
                case 5 -> this.dbAdmin.getAdministrador().get(i).setUsuario(dato);
                case 6 -> this.dbAdmin.getAdministrador().get(i).setTelefono(dato);
                default -> {
                    System.out.println("No es válida la opción");
                }
            }
        }
    }
    
}
}
**/