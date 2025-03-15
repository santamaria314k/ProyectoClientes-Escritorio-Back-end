
package Modelos;

import java.util.Date;


public class ClientePotencial extends Cliente{
    private String comoConocioEmpresa;
    private String intereses;





    public ClientePotencial(int id, String nombres, String apellidos, String correo, String direccion, String celular, int edad, String profesion, Date fechaNacimiento,Rol idrol,String user,String pass) {
        super(id, nombres, apellidos, correo, direccion, celular, edad, profesion, fechaNacimiento ,idrol,user,pass);
    }

    public ClientePotencial(int id, String nombres, String apellidos, String correo, String direccion, String celular, int edad, String profesion, Date fechaNacimiento,Rol idrol,String user,String pass, String comoConocioEmpresa, String intereses ) {
        super(id, nombres, apellidos, correo, direccion, celular, edad, profesion, fechaNacimiento,idrol,user,pass);
        this.comoConocioEmpresa = comoConocioEmpresa;
        this.intereses = intereses;
    }



    //Metodos Accesores Propios de la clase 

    public String getComoConocioEmpresa() {
        return comoConocioEmpresa;
    }

    public void setComoConocioEmpresa(String comoConocioEmpresa) {
        this.comoConocioEmpresa = comoConocioEmpresa;
    }

    public String getIntereses() {
        return intereses;
    }

    public void setIntereses(String intereses) {
        this.intereses = intereses;
    }

    
}
