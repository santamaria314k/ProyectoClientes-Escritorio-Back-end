
package Models;



public class Administrador  {
    private int nombreAdmin;
    private String userAdmin;
    private String passAdmin;
    private Rol idrol;

    
	public Administrador(int nombreAdmin, String userAdmin, String passAdmin, Rol idrol) {
		this.nombreAdmin = nombreAdmin;
		this.userAdmin = userAdmin;
		this.passAdmin = passAdmin;
		this.idrol = idrol;
	}


	public int getNombreAdmin() {
		return nombreAdmin;
	}


	public void setNombreAdmin(int nombreAdmin) {
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
