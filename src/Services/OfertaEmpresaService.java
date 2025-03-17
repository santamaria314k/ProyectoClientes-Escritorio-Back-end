
package Services;

import java.sql.*;
import DB.DataBase;
import Models.OfertaEmpresa;
public class OfertaEmpresaService {
    public void IngresarOfertaEmpresa(OfertaEmpresa oferta){
        Connection conn = DataBase.conectar();
        if(conn != null){
            try{
                String sql = "INSERT INTO OfertasEmpresa (idoferta, descripcionOferta, nit) VALUES (?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, oferta.getIdoferta());
                pstmt.setString(2, oferta.getDescripcionOferta());
                pstmt.setInt(3, oferta.getNit().getNit());
                pstmt.executeUpdate();
                System.out.println("Oferta ingresada exitosamente");
            } catch (SQLException ex){
                System.out.println("Error al ingresar la oferta: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                DataBase.Desconectar(conn);
            }
        }
    }
    
    public void ModificarOfertaEmpresa(int ofertaid, String nuevaOferta){
        Connection conn = DataBase.conectar();
        if(conn != null){
            try{
                String sql = "UPDATE OfertasEmpresa SET descripcionOferta = ? WHERE OfertasEmpresa.idoferta = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, nuevaOferta);
                pstmt.setInt(2, ofertaid);
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Oferta modificada correctamente.");
                } else {
                    System.out.println("Oferta con id " + ofertaid + " no encontrada.");
                }
            } catch (SQLException ex){
                System.out.println("Error al modificar la oferta: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                DataBase.Desconectar(conn);
            }
        }
    }
    
    public void ImprimirOfertasEmpresa(){
        Connection conn = DataBase.conectar();
        if(conn != null){
            try{
                String sql = "SELECT nit, descripcionOferta FROM OfertasEmpresa";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    System.out.println("///////////////////////////////////////////////////////7///////////");
                    System.out.println("NIT: " + rs.getInt("nit"));
                    System.out.println("Oferta: " + rs.getString("descripcionOferta"));
                    System.out.println("--------------//-----------//----------//-----------//--------");
                }
            }catch(SQLException ex){
                System.out.println("Error al listar las ofertas: " + ex.getMessage());
                ex.printStackTrace();
            }finally{
                DataBase.Desconectar(conn);
            }
        }
    }
    
    public void EliminarOferta(int id){
       Connection conn = DataBase.conectar();
       if(conn != null){
           try{
               String sql = "DELETE FROM OfertasEmpresa WHERE idoferta = ?";
               PreparedStatement pstmt = conn.prepareStatement(sql);
               pstmt.setInt(1, id);
               int rowsAffected = pstmt.executeUpdate();
               if (rowsAffected > 0) {
                    System.out.println("Oferta eliminada correctamente.");
                } else {
                    System.out.println("Oferta con id " + id + " no encontrada.");
                }
            }catch(SQLException ex){
                System.out.println("Error al eliminar la oferta: " + ex.getMessage());
                ex.printStackTrace();
            }finally{
               DataBase.Desconectar(conn);
            }
        }
    }
}
