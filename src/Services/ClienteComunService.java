package Services;
 
import java.sql.*;
import DB.DataBase;
import Models.ClienteComun;
import java.util.Date;

public class ClienteComunService {

public void RegistrarClienteComun(ClienteComun clientecomun) {
        Connection conn = DataBase.conectar();
        if (conn != null) {
            try {
                conn.setAutoCommit(false); // Iniciar transacción

                String sql = "INSERT INTO clientescomunes (idComun,nombres, apellidoscli, correo, direccion, celular, ocupacion, edad, profesion, fechaNacimiento, idrol, user, pass, metodosPago, idSector) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setInt(1, clientecomun.getIdComun()); 
                pstmt.setString(2, clientecomun.getNombres());
                pstmt.setString(3, clientecomun.getApellidos());
                pstmt.setString(4, clientecomun.getCorreo());
                pstmt.setString(5, clientecomun.getDireccion());
                pstmt.setString(6, clientecomun.getCelular());
                pstmt.setString(7, clientecomun.getOcupacion());
                pstmt.setInt(8, clientecomun.getEdad());
                pstmt.setString(9, clientecomun.getProfesion());
                pstmt.setDate(10, new java.sql.Date(clientecomun.getFechaNacimiento().getTime()));
                pstmt.setInt(11, clientecomun.getIdrol().getIdrol());
                pstmt.setString(12, clientecomun.getUser());
                pstmt.setString(13, clientecomun.getPass());
                pstmt.setString(14, clientecomun.getMetodosPago());
                pstmt.setInt(15, clientecomun.getIdsector().getIdsector());

                pstmt.executeUpdate();

                conn.commit(); // Confirmar transacción
                System.out.println("Cliente comun creado exitosamente");
            } catch (SQLException ex) {
                try {
                    conn.rollback(); // Deshacer transacción en caso de error
                } catch (SQLException rollbackEx) {
                    System.out.println("Error al deshacer la transacción: " + rollbackEx.getMessage());
                }
                System.out.println("Error al crear el cliente comun: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                try {
                    conn.setAutoCommit(true); // Restaurar auto-commit
                } catch (SQLException autoCommitEx) {
                    System.out.println("Error al restaurar auto-commit: " + autoCommitEx.getMessage());
                }
                DataBase.Desconectar(conn);
            }
        }
    }

    public void ImprimirClienteComun() {
        Connection conn = DataBase.conectar();
        if (conn != null) {
            try {
                String sql = "SELECT * FROM clientescomunes";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    System.out.println("///////////////////////////////////////////////////////7///////////");
                    System.out.println("ID: " + rs.getInt("idComun"));
                    System.out.println("Nombres: " + rs.getString("nombres"));
                    System.out.println("Apellidos: " + rs.getString("apellidoscli"));
                    System.out.println("Correo: " + rs.getString("correo"));
                    System.out.println("Direccion: " + rs.getString("direccion"));
                    System.out.println("Celular: " + rs.getString("celular"));
                    System.out.println("Ocupacion: " + rs.getString("ocupacion"));
                    System.out.println("Edad: " + rs.getInt("edad"));
                    System.out.println("Profesion: " + rs.getString("profesion"));
                    System.out.println("Fecha Nacimiento: " + rs.getDate("fechaNacimiento"));
                    System.out.println("Rol ID: " + rs.getInt("idrol"));
                    System.out.println("Usuario: " + rs.getString("user"));
                    System.out.println("Contraseña: " + rs.getString("pass"));
                    System.out.println("Metodos Pago: " + rs.getString("metodosPago"));
                    System.out.println("Esta en el sector: " + rs.getString("idsector"));
                    
                    System.out.println("--------------//-----------//----------//-----------//--------");
                }
            } catch (SQLException ex) {
                System.out.println("Error al imprimir clientes: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                DataBase.Desconectar(conn);
            }
        }
    }

    public void EliminarClienteComun(int idComun) {
        Connection conn = DataBase.conectar();
        if (conn != null) {
            try {
                String sql = "DELETE FROM clientescomunes WHERE idComun = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, idComun);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Cliente comun eliminado correctamente.");
                } else {
                    System.out.println("Cliente comun con ID " + idComun + " no encontrado.");
                }
            } catch (SQLException ex) {
                System.out.println("Error al eliminar cliente: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                DataBase.Desconectar(conn);
            }
        }
    }

    public void ModificarClienteComun(int seleccion, String info, int idComun, int edad, Date fechaNacimiento) {
        Connection conn = DataBase.conectar();
        if (conn != null) {
            try {
                String columna = "";
                switch (seleccion) {
                    case 1: columna = "nombres"; break;
                    case 2: columna = "apellidoscli"; break;
                    case 3: columna = "correo"; break;
                    case 4: columna = "direccion"; break;
                    case 5: columna = "celular"; break;
                    case 6: columna = "ocupacion"; break;
                    case 7: columna = "edad"; break;
                    case 8: columna = "profesion"; break;
                    case 9: columna = "user"; break;
                    case 10: columna = "pass"; break;
                    case 11: columna = "fechaNacimiento"; break;
                    case 12: columna = "metodosPago"; break;                   
                    default: System.out.println("Opción no válida."); return;
                }
                String sql = "UPDATE clientescomunes SET " + columna + " = ? WHERE idComun = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                if (seleccion == 7) {
                    pstmt.setInt(1, edad);
                } else if (seleccion == 11) {
                    pstmt.setDate(1, new java.sql.Date(fechaNacimiento.getTime()));
                } else {
                    pstmt.setString(1, info);
                }
                pstmt.setInt(2, idComun);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Cliente modificado correctamente.");
                } else {
                    System.out.println("Cliente con ID " + idComun + " no encontrado.");
                }
            } catch (SQLException ex) {
                System.out.println("Error al modificar cliente: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                DataBase.Desconectar(conn);
            }
        }
    }
}