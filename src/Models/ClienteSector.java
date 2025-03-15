
package Models;


public class ClienteSector {
    private int id;
    private ClienteComun cliente;
    private Sector sector;

    public ClienteSector(int id, ClienteComun cliente, Sector sector) {
        this.id = id;
        this.cliente = cliente;
        this.sector = sector;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClienteComun getCliente() {
        return cliente;
    }

    public void setCliente(ClienteComun cliente) {
        this.cliente = cliente;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    
    
    
}
