package Services;

import java.sql.*;
import DB.DataBase;
import Models.Cliente;
import java.util.Date;

public class ClienteService {

    public void RegistrarCliente(Cliente cliente) {
        Connection conn = DataBase.conectar();
        if (conn != null) {
            try {
                String sql = "INSERT INTO Clientes (idcli, nombres, apellidoscli, correo, direccion, celular, ocupacion, edad, profesion, fechaNacimiento, idrol, user, pass) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, cliente.getId());
                pstmt.setString(2, cliente.getNombres());
                pstmt.setString(3, cliente.getApellidos());
                pstmt.setString(4, cliente.getCorreo());
                pstmt.setString(5, cliente.getDireccion());
                pstmt.setString(6, cliente.getCelular());
                pstmt.setString(7, cliente.getOcupacion());
                pstmt.setInt(8, cliente.getEdad());
                pstmt.setString(9, cliente.getProfesion());
                pstmt.setDate(10, new java.sql.Date(cliente.getFechaNacimiento().getTime()));
                pstmt.setInt(11, cliente.getIdrol().getIdrol());
                pstmt.setString(12, cliente.getUser());
                pstmt.setString(13, cliente.getPass());
                pstmt.executeUpdate();
                System.out.println("Cliente creado exitosamente");
            } catch (SQLException ex) {
                System.out.println("Error al crear el cliente: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                DataBase.Desconectar(conn);
            }
        }
    }

    public void ImprimirCliente() {
        Connection conn = DataBase.conectar();
        if (conn != null) {
            try {
                String sql = "SELECT * FROM Clientes";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    System.out.println("///////////////////////////////////////////////////////7///////////");
                    System.out.println("ID: " + rs.getInt("idcli"));
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

    public void EliminarCliente(int idcli) {
        Connection conn = DataBase.conectar();
        if (conn != null) {
            try {
                String sql = "DELETE FROM Clientes WHERE idcli = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, idcli);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Cliente eliminado correctamente.");
                } else {
                    System.out.println("Cliente con ID " + idcli + " no encontrado.");
                }
            } catch (SQLException ex) {
                System.out.println("Error al eliminar cliente: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                DataBase.Desconectar(conn);
            }
        }
    }

    public void ModificarCliente(int seleccion, String info, int idcli, int edad, Date fechaNacimiento) {
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
                    default: System.out.println("Opción no válida."); return;
                }
                String sql = "UPDATE Clientes SET " + columna + " = ? WHERE idcli = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                if (seleccion == 7) {
                    pstmt.setInt(1, edad);
                } else if (seleccion == 11) {
                    pstmt.setDate(1, new java.sql.Date(fechaNacimiento.getTime()));
                } else {
                    pstmt.setString(1, info);
                }
                pstmt.setInt(2, idcli);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Cliente modificado correctamente.");
                } else {
                    System.out.println("Cliente con ID " + idcli + " no encontrado.");
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