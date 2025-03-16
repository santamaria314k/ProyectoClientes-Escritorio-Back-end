
package Services;

import java.sql.*;
import DB.DataBase;
import Models.EmpresaSector;
public class EmpresaSectorService {
    public void InsertarEmpresaSector(EmpresaSector empresaSector){
        Connection conn = DataBase.conectar();
        if (conn != null) {
            try {
                String sql = "INSERT INTO EmpresasSectores (id, idSector, idEmpresa) VALUES (?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, empresaSector.getId());
                pstmt.setInt(2, empresaSector.getSector().getId());
                pstmt.setInt(3, empresaSector.getEmpresa().getNit());
                pstmt.executeUpdate();
                System.out.println("sector de la empresa ingresado exitosamente");
            } catch (SQLException ex) {
                System.out.println("Error al ingresar el sector de la empresa: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                DataBase.Desconectar(conn);
            }
        }
    }
    
    public void ImprimirEmpresaSector(){
        Connection conn = DataBase.conectar();
        if(conn != null){
            try{
                String sql = "SELECT Empresas.razonSocial AS NombreEmpresa, Empresas.nit AS NIT, Sectores.descripcionSector AS Sector FROM Empresas INNER JOIN EmpresasSectores ON Empresas.nit = EmpresasSectores.idEmpresa INNER JOIN Sectores ON EmpresasSectores.idSector = Sectores.idSector";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                
                while(rs.next()){
                    System.out.println("///////////////////////////////////////////////////////7///////////");
                    System.out.println("Nit: " + rs.getInt("NIT"));
                    System.out.println("Empresa: " + rs.getString("NombreEmpresa"));
                    System.out.println("Sector: " + rs.getString("Sector"));
                    System.out.println("--------------//-----------//----------//-----------//--------");
                }
            }catch (SQLException ex){
                System.out.println("Error al imprimir los sectores: " + ex.getMessage());
                ex.printStackTrace();
            }finally{
                DataBase.Desconectar(conn);
            }
        }
    }
    
    public void EditarEmpresaSector(int sector){
        Connection conn = DataBase.conectar();
        if(conn != null){
            try{
                String sql = "UPDATE EmpresasSectores SET idSector = ? WHERE EmpresasSectores.id = 1";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, sector);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Sector modificado correctamente.");
                } else {
                    System.out.println("Sector con ID " + sector + " no encontrado.");
                }
            }catch (SQLException ex) {
                System.out.println("Error al modificar el sector: " + ex.getMessage());
                ex.printStackTrace();
            }finally{
                DataBase.Desconectar(conn);
            }
        }
    }
    
    public void BorrarEmpresaSector(){
        Connection conn = DataBase.conectar();
        if(conn != null){
            try{
                String sql = "DELETE FROM empresassectores WHERE EmpresasSectores.id = 1";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Sector de empresa eliminado correctamente.");
                } else {
                    System.out.println("Sector de la empresa no encontrado");
                }
            }catch(SQLException ex){
                System.out.println("Error al eliminar el sector de la empresa: " + ex.getMessage());
                ex.printStackTrace();
            }finally{
                DataBase.Desconectar(conn);
            }
        }
    }
}
