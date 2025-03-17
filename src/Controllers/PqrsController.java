package Controllers;

import Models.PQRS;
import Services.PqrsService;

public class PqrsController {
    private PqrsService pqrsService;

    public PqrsController() {
        this.pqrsService = new PqrsService();
    }

    public void RegistrarPqrs(PQRS nuevoPqrs) {
        pqrsService.RegistrarPqrs(nuevoPqrs);
    }

    public void ImprimirPqrs() {
        pqrsService.ImprimirPqrs();
    }

    public void EliminarPqrs(int idPQRS) {
        pqrsService.EliminarPqrs(idPQRS);
    }

    public void ModificarPqrs(int seleccion, String info, int idPQRS) {
        pqrsService.ModificarPqrs(seleccion, info, idPQRS);
    }
}