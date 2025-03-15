
package Modelos;

import java.util.Date;


public class Cliente {
    private int id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String direccion;
    private String celular;
    private int edad;
    private String profesion;
    private Date fechaNacimiento;

    private Rol idrol;

    private String user;
    private String pass;    


    public Cliente(int id, String nombres, String apellidos, String correo, String direccion, String celular, int edad, String profesion, Date fechaNacimiento , Rol idrol, String user, String pass) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.direccion = direccion;
        this.celular = celular;
        this.edad = edad;

        this.profesion = profesion;
        this.fechaNacimiento = fechaNacimiento;

        this.idrol = idrol;

        this.user=user;
        this.pass=pass;
   
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getEdad() {
        return edad;
    }



    public void setEdad(int edad) {
        this.edad = edad;
    }


    //----------------------------------------------------------------

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    //----------------------------------------------------------------


    public Rol getIdrol() {
        return idrol;
    }

    public void setIdrol(Rol idrol) {
        this.idrol = idrol;

    }

//----------------------------------------------------------------

   

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    



    
}

