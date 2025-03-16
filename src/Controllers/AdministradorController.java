
package Controllers;

import Models.Administrador;
import Services.AdministradorService;

public class AdministradorController {
    public AdministradorService adminService;

    public AdministradorController() {
        this.adminService = new AdministradorService();
    }

    public void RegistrarAdministrador(Administrador nuevoAdmin) {
        adminService.RegistrarAdministrador(nuevoAdmin);
    }

    public void ImprimirAdministrador() {
        adminService.ImprimirAdministrador();
    }

    public void EliminarAdministrador(int idAdmin) {  // Se corrigió el parámetro
        adminService.EliminarAdministrador(idAdmin);
    }

    public void ModificarAdministrador(int opcionModificacionAdmin, String datoAdmin, int idAdmin) {
    adminService.ModificarAdministrador(opcionModificacionAdmin, datoAdmin, idAdmin);
    }

}

