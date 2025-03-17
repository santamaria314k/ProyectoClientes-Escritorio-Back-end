
package Controllers;

import Models.EmpresaSector;
import Services.EmpresaSectorService;


public class EmpresaSectorController {
    private EmpresaSectorService empresaSectorServicio;

    public EmpresaSectorController() {
        this.empresaSectorServicio = new EmpresaSectorService();
    }
    
    public void RegistrarTipoSector (EmpresaSector empresaSector){
        empresaSectorServicio.InsertarEmpresaSector(empresaSector);
    }
    
    public void MostrarSectoresEmpresa(){
        empresaSectorServicio.ImprimirEmpresaSector();
    }
    
    public void ModificarEmpresaSector(int sector){
        empresaSectorServicio.EditarEmpresaSector(sector);
    }
    
    public void EliminarEmpresaSector(){
        empresaSectorServicio.BorrarEmpresaSector();
    }
}
