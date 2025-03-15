
package Models;


public class Clientela {
    private int id;
    private Empresa idEmpresa;
    private ClienteComun idClienteComun;

    public Clientela(int id, Empresa idEmpresa, ClienteComun idClienteComun) {
        this.id = id;
        this.idEmpresa = idEmpresa;
        this.idClienteComun = idClienteComun;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public ClienteComun getIdClienteComun() {
        return idClienteComun;
    }

    public void setIdClienteComun(ClienteComun idClienteComun) {
        this.idClienteComun = idClienteComun;
    }
    
    
}
