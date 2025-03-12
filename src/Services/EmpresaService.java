package Services;

import java.sql.*;
import DB.DataBase;
import Models.Empresa;

public class EmpresaService {
    public void RegistrarEmpresa(Empresa empresa){
        Connection conn = DataBase.conectar();
        if(conn != null){
            try{
                String sql = "INSERT INTO Empresas (nit, razonsocial, telefono, actividad) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, empresa.getNit());
                pstmt.setString(2, empresa.getRazonSocial());
                pstmt.setString(3, empresa.getTelefono());
                pstmt.setString(4, empresa.getActividad());
                pstmt.executeUpdate();
                System.out.println("Empresa creada exitosamente");
            }catch(SQLException ex){
                System.out.println("Error al crear la empresa: " + ex.getMessage());
                ex.printStackTrace();
            }finally{
                DataBase.Desconectar(conn);
            }
        }
    }
}