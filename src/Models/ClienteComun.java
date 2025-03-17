package Models;

import Models.Sector;
import java.util.Date;

public class ClienteComun extends Cliente {
    private int idComun;
    private String metodosPago;
    private Sector idsector;

    public ClienteComun(int idComun, int idcli, String nombres, String apellidoscli, String correo, String direccion, String celular, String ocupacion, int edad, String profesion, Date fechaNacimiento, Rol idrol, String user, String pass, String metodosPago, Sector idsector) {
        super(idcli, nombres, apellidoscli, correo, direccion, celular, ocupacion, edad, profesion, fechaNacimiento, idrol, user, pass);
        this.idComun = idComun;
        this.metodosPago = metodosPago;
        this.idsector = idsector;
    }

    public int getIdComun() {
        return idComun;
    }

    public void setIdComun(int idComun) {
        this.idComun = idComun;
    }

    public String getMetodosPago() {
        return metodosPago;
    }

    public void setMetodosPago(String metodosPago) {
        this.metodosPago = metodosPago;
    }

    public Sector getIdsector() {
        return idsector;
    }

    public void setIdsector(Sector idsector) {
        this.idsector = idsector;
    }
}

