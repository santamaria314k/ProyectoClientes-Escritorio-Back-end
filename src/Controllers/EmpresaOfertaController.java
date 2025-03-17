
package Controllers;

import Models.OfertaEmpresa;
import Services.OfertaEmpresaService;


public class EmpresaOfertaController {
    public OfertaEmpresaService ofertaempresaservicio;
    
    public EmpresaOfertaController(){
        this.ofertaempresaservicio = new OfertaEmpresaService();
    }
    
    public void MostrarOfertasEmpresas(){
        ofertaempresaservicio.ImprimirOfertasEmpresa();
    }
    
    public void RegistrarOfertaEmpresa(OfertaEmpresa oferta){
        ofertaempresaservicio.IngresarOfertaEmpresa(oferta);
    }
    
    public void ModificarOfertaEmpresa(int id, String oferta){
        ofertaempresaservicio.ModificarOfertaEmpresa(id, oferta);
    }
    
    public void EliminarOfertaEmpresa(int id){
        ofertaempresaservicio.EliminarOferta(id);
    }
}
