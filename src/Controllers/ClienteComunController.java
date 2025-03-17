

package Controllers;

import Models.ClienteComun;
import Services.ClienteComunService;
import java.util.Date;

public class ClienteComunController {
    public ClienteComunService ClienteComunService;

    public ClienteComunController() {
        this.ClienteComunService = new ClienteComunService();
    }

    public void InsertarClienteComun(ClienteComun nuevoClienteComun) {
        ClienteComunService.RegistrarClienteComun(nuevoClienteComun);
    }

    public void MostrarDatosClienteComun() {
        ClienteComunService.ImprimirClienteComun();
    }

    public void EliminarRegistroCliente(int idcli) {
        ClienteComunService.EliminarClienteComun(idcli);
    }

    public void ModificarClienteComun(int idcliModificacion, String opcionModificacionCliente, String datoCliente, int edadCliente, Date fechaNacimientoCliente) {
        int opcionInt = 0;

        try {
            opcionInt = Integer.parseInt(opcionModificacionCliente);
        } catch (NumberFormatException e) {
            System.out.println("Opción no válida. Debe ser un número.");
            return;
        }

        ClienteComunService.ModificarClienteComun(opcionInt, datoCliente, idcliModificacion, edadCliente, fechaNacimientoCliente);
    }
}