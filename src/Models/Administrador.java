
package Models;

public class Administrador {
    private int idAdmin;  // Se agrega el ID del Administrador
    private String nombreAdmin;  // Se corrige el tipo de dato a String
    private String userAdmin;
    private String passAdmin;
    private Rol idrol; 
    
    Rol rolAdmin = new Rol(2, "Administrador");
    public Administrador(int idAdmin, String nombreAdmin, String userAdmin, String passAdmin, Rol idrol) {
        this.idAdmin = idAdmin;  // Se asigna el ID
        this.nombreAdmin = nombreAdmin;
        this.userAdmin = userAdmin;
        this.passAdmin = passAdmin;
        this.idrol = idrol;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNombreAdmin() {
        return nombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }

    public String getUserAdmin() {
        return userAdmin;
    }

    public void setUserAdmin(String userAdmin) {
        this.userAdmin = userAdmin;
    }

    public String getPassAdmin() {
        return passAdmin;
    }

    public void setPassAdmin(String passAdmin) {
        this.passAdmin = passAdmin;
    }

    public Rol getIdrol() {
        return idrol;
    }

    public void setIdrol(Rol idrol) {
        this.idrol = idrol;
    }
}

    







    

