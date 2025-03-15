
package Modelos;

import java.util.Date;

public class ClienteComun extends Cliente {
    private String metodosPago;


    public ClienteComun(int id, String nombres, String apellidos, String correo, String direccion, String celular, int edad, String profesion, Date fechaNacimiento,Rol idrol, String user,String pass) {
        super(id, nombres, apellidos, correo, direccion, celular, edad, profesion, fechaNacimiento,idrol,user,pass);
    }

    public ClienteComun(int id, String nombres, String apellidos, String correo, String direccion, String celular, int edad, String profesion, Date fechaNacimiento,Rol idrol, String user,String pass,String metodosPago) {
        super(id, nombres, apellidos, correo, direccion, celular, edad, profesion, fechaNacimiento,idrol,user,pass);
        this.metodosPago = metodosPago;
    }




    
    public String getMetodosPago() {
        return metodosPago;
    }

    public void setMetodosPago(String metodosPago) {
        this.metodosPago = metodosPago;
    }
    
    
    
}
