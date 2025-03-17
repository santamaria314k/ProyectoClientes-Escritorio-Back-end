package Services;

import java.sql.*;
import DB.DataBase;
import Models.Empresa;

public class EmpresaService {

    public void RegistrarEmpresa(Empresa empresa) {
        Connection conn = DataBase.conectar();
        if (conn != null) {
            try {
                String sql = "INSERT INTO Empresas (nit, razonsocial, telefono, descripcionActividades, userempresa, passempresa) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, empresa.getNit());
                pstmt.setString(2, empresa.getRazonSocial());
                pstmt.setString(3, empresa.getTelefono());
                pstmt.setString(4, empresa.getActividad());
                pstmt.setString(5, empresa.getUserempresa());
                pstmt.setString(6, empresa.getPassempresa());
                pstmt.executeUpdate();
                System.out.println("Empresa creada exitosamente");
            } catch (SQLException ex) {
                System.out.println("Error al crear la empresa: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                DataBase.Desconectar(conn);
            }
        }
    }

    public void ImprimirEmpresa() {
        Connection conn = DataBase.conectar();
        if (conn != null) {
            try {
                String sql = "SELECT * FROM Empresas";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    System.out.println("///////////////////////////////////////////////////////7///////////");
                    System.out.println("NIT: " + rs.getInt("nit"));
                    System.out.println("RazonSocial: " + rs.getString("razonSocial"));
                    System.out.println("Telefono: " + rs.getString("telefono"));
                    System.out.println("Actividad: " + rs.getString("descripcionActividades"));
                    System.out.println("--------------//-----------//----------//-----------//--------");
                }
            } catch (SQLException ex) {
                System.out.println("Error al imprimir empresas: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                DataBase.Desconectar(conn);
            }
        }
    }

    public void EliminarEmpresa(int nit) {
        Connection conn = DataBase.conectar();
        if (conn != null) {
            try {
                String sql = "DELETE FROM Empresas WHERE nit = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, nit);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Empresa eliminada correctamente.");
                } else {
                    System.out.println("Empresa con NIT " + nit + " no encontrada.");
                }
            } catch (SQLException ex) {
                System.out.println("Error al eliminar empresa: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                DataBase.Desconectar(conn);
            }
        }
    }

    public void ModificarEmpresa(int seleccion, String info, int nit) {
        Connection conn = DataBase.conectar();
        if (conn != null) {
            try {
                String columna = "";
                switch (seleccion) {
                    case 1: columna = "razonSocial"; break;
                    case 2: columna = "telefono"; break;
                    case 3: columna = "descripcionActividades"; break;
                    default: System.out.println("Opción no válida."); return;
                }
                String sql = "UPDATE Empresas SET " + columna + " = ? WHERE nit = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, info);
                pstmt.setInt(2, nit);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Empresa modificada correctamente.");
                } else {
                    System.out.println("Empresa con NIT " + nit + " no encontrada.");
                }
            } catch (SQLException ex) {
                System.out.println("Error al modificar empresa: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                DataBase.Desconectar(conn);
            }
        }
    }
}