
package Modelos;


public class OfertaEmpresa {
    private int idoferta;
    private String descripcionOferta;
    private Empresa nit;


    public OfertaEmpresa(int idoferta, Empresa nit, String descripcionOferta) {
        this.idoferta = idoferta;
        this.descripcionOferta = descripcionOferta;
        this.nit = nit;
    }

    public int getIdoferta() {
        return idoferta;
    }

    public void setIdoferta(int idoferta) {
        this.idoferta = idoferta;
    }

   

    public String getDescripcionOferta() {
        return descripcionOferta;
    }

    public void setDescripcionOferta(String descripcionOferta) {
        this.descripcionOferta = descripcionOferta;
    }
    


    public Empresa getNit() {
        return nit;
    }

    public void setNit(Empresa nit) {
        this.nit = nit;
    }






    
}
