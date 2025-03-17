

package Models;

import java.util.Date;

public class ClienteComun extends Cliente {

    private String metodosPago;

   

    
    
    
    public ClienteComun(int idcli, String nombres, String apellidoscli, String correo, String direccion, String celular, String ocupacion, int edad, String profesion, Date fechaNacimiento, Rol idrol, String user, String pass, String metodosPago) {
        super(idcli, nombres, apellidoscli, correo, direccion, celular, ocupacion, edad, profesion, fechaNacimiento, idrol, user, pass);
        this.metodosPago = metodosPago;
    }

    
    
    public String getMetodosPago() {
        return metodosPago;
    }

    public void setMetodosPago(String metodosPago) {
        this.metodosPago = metodosPago;
    }

    
}


