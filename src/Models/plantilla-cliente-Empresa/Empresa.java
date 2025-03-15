
package Modelos;


public class Empresa {
    private int nit;
    private String razonSocial;
    private String industria;
    private String descripcionActividades;

    private String userempresa;
    private String passempresa;

  

    public Empresa(int nit, String razonSocial, String industria, String descripcionActividades,String userempresa,String passempresa) {
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.industria = industria;
        this.descripcionActividades = descripcionActividades;
        
        this.userempresa = userempresa;
        this.passempresa = passempresa;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getIndustria() {
        return industria;
    }

    public void setIndustria(String industria) {
        this.industria = industria;
    }

    public String getDescripcionActividades() {
        return descripcionActividades;
    }

    public void setDescripcionActividades(String descripcionActividades) {
        this.descripcionActividades = descripcionActividades;
    }


    
    public String getUserempresa() {
        return userempresa;
    }

    public void setUserempresa(String userempresa) {
        this.userempresa = userempresa;
    }

    public String getPassempresa() {
        return passempresa;
    }

    public void setPassempresa(String passempresa) {
        this.passempresa = passempresa;
    }

    



    
    
}
