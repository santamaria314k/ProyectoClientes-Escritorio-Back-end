package Controllers;

import Models.Rol;
import Services.RolService;

public class RolController {
    private RolService rolService;

    public RolController() {
        this.rolService = new RolService();
    }

    public void RegistrarRol(Rol rol) {
        rolService.RegistrarRol(rol);
    }

    public void ImprimirRoles() {
        rolService.ImprimirRoles();
    }

    public void EliminarRol(int idRol) {
        rolService.EliminarRol(idRol);
    }

    public void ModificarRol(String nuevoNombre, int idRol) {
        rolService.ModificarRol(nuevoNombre, idRol);
    }
}