
package Models;


public class ClienteEmpresa {
    private int id;
    private Empresa empresa;
    private ClienteComun clienteComun;

    public ClienteEmpresa(int id, Empresa empresa, ClienteComun clienteComun) {
        this.id = id;
        this.empresa = empresa;
        this.clienteComun = clienteComun;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public ClienteComun getClienteComun() {
        return clienteComun;
    }

    public void setClienteComun(ClienteComun clienteComun) {
        this.clienteComun = clienteComun;
    }

    
    
    
}
