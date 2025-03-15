
package Models;


public class EmpresaSector {
    private int id;
    private Sector sector;
    private Empresa empresa;

    public EmpresaSector(int id, Sector sector, Empresa empresa) {
        this.id = id;
        this.sector = sector;
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    
}
