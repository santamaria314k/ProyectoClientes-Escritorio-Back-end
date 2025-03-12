package Controllers;

import Models.Empresa;
import Services.EmpresaService;

public class EmpresaController {
    public EmpresaService EmpresaService;

    public EmpresaController() {
        this.EmpresaService = new EmpresaService();
    }

    public void InsertarEmpresa(Empresa nuevaEmpresa) {
        EmpresaService.RegistrarEmpresa(nuevaEmpresa);
    }

    public void MostrarDatos() {
        EmpresaService.ImprimirEmpresa();
    }

    public void EliminarRegistro(int nit) {
        EmpresaService.EliminarEmpresa(nit);
    }

    public void ModificarEmpresa(int nitModificacion, String opcionModificacionEmpresa, String datoEmpresa) {
        int opcionInt = 0;
        try {
            opcionInt = Integer.parseInt(opcionModificacionEmpresa);
        } catch (NumberFormatException e) {
            System.out.println("Opción no válida. Debe ser un número.");
            return;
        }
        EmpresaService.ModificarEmpresa(opcionInt, datoEmpresa, nitModificacion);
    }
}