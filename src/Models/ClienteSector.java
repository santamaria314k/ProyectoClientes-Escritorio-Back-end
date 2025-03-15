
package Models;


public class ClienteSector {
    private int id;
    private ClienteComun clienteId;
    private Sector sectorId;

    public ClienteSector(int id, ClienteComun clienteId, Sector sectorId) {
        this.id = id;
        this.clienteId = clienteId;
        this.sectorId = sectorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClienteComun getClienteId() {
        return clienteId;
    }

    public void setClienteId(ClienteComun clienteId) {
        this.clienteId = clienteId;
    }

    public Sector getSectorId() {
        return sectorId;
    }

    public void setSectorId(Sector sectorId) {
        this.sectorId = sectorId;
    }
    
    
}
