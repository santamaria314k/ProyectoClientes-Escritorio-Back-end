package Models;

public class PQRS {
    private int idPQRS;
    private String tipoComentario;
    private String descripcion;
    private int idComun; // Almacenamos el idComun como un entero

    public PQRS(int idPQRS, int idComun, String tipoComentario, String descripcion) {
        this.idPQRS = idPQRS;
        this.tipoComentario = tipoComentario;
        this.descripcion = descripcion;
        this.idComun = idComun;
    }

    public int getIdPQRS() {
        return idPQRS;
    }

    public void setIdPQRS(int idPQRS) {
        this.idPQRS = idPQRS;
    }

    public int getIdComun() {
        return idComun;
    }

    public void setIdComun(int idComun) {
        this.idComun = idComun;
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