package Services;

import DB.DataBase;
import Models.Cliente;
import java.sql.*;

public class ClienteService {

    public void CrearCliente(Cliente cliente) {
        Connection conn = DataBase.conectar();
        if (conn != null) {
            try {
                String sql = "INSERT INTO Clientes (nombres, apellidoscli, celular, ocupacion, edad) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, cliente.getNombres());
                pstmt.setString(2, cliente.getApellidos());
                pstmt.setString(3, cliente.getCelular());
                pstmt.setString(4, cliente.getOcupacion());
                pstmt.setInt(5, cliente.getEdad());
                pstmt.executeUpdate();
                System.out.println("Cliente creado correctamente.");
            } catch (SQLException ex) {
                System.out.println("Error al crear cliente: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                DataBase.Desconectar(conn);
            }
        }
    }

    public void Imprimir() {
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
                    System.out.println("Celular: " + rs.getString("celular"));
                    System.out.println("Ocupación: " + rs.getString("ocupacion"));
                    System.out.println("Edad: " + rs.getInt("edad"));
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

    public void ModificarCliente(int idcli, int seleccion, String info, int edad) {
        Connection conn = DataBase.conectar();
        if (conn != null) {
            try {
                String columna = "";
                switch (seleccion) {
                    case 1: columna = "nombres"; break;
                    case 2: columna = "apellidoscli"; break;
                    case 3: columna = "celular"; break;
                    case 4: columna = "ocupacion"; break;
                    case 5: columna = "edad"; break;
                    default: System.out.println("Opción no válida."); return;
                }
                String sql = "UPDATE Clientes SET " + columna + " = ? WHERE idcli = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                if(seleccion == 5){
                    pstmt.setInt(1, edad);
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