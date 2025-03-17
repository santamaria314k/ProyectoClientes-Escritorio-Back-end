
package Models;


public class PQRS {
    private int idPQRS;
    private String tipoComentario;
    private String descripcion;
    private ClienteComun idClienteComun;


    public PQRS(int idPQRS, ClienteComun idClienteComun, String tipoComentario, String descripcion) {
        this.idPQRS = idPQRS;
        this.tipoComentario = tipoComentario;
        this.descripcion = descripcion;
        this.idClienteComun = idClienteComun;
    }

    public int getIdPQRS() {
        return idPQRS;
    }

    public void setIdPQRS(int idPQRS) {
        this.idPQRS = idPQRS;
    }

    public ClienteComun getIdClienteComun() {
        return idClienteComun;
    }

    public void setIdClienteComun(ClienteComun idClienteComun) {
        this.idClienteComun = idClienteComun;
    }

    public String getTipoComentario() {
        return tipoComentario;
    }

    public void setTipoComentario(String tipoComentario) {
        this.tipoComentario = tipoComentario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}


