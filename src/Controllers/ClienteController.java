package Controllers;

import Models.Cliente;
import Services.ClienteService;
import java.util.Date;

public class ClienteController {
    public ClienteService ClienteService;

    public ClienteController() {
        this.ClienteService = new ClienteService();
    }

    public void InsertarCliente(Cliente nuevoCliente) {
        ClienteService.RegistrarCliente(nuevoCliente);
    }

    public void MostrarDatosCliente() {
        ClienteService.ImprimirCliente();
    }

    public void EliminarRegistroCliente(int idcli) {
        ClienteService.EliminarCliente(idcli);
    }

    public void ModificarCliente(int idcliModificacion, String opcionModificacionCliente, String datoCliente, int edadCliente, Date fechaNacimientoCliente) {
        int opcionInt = 0;

        try {
            opcionInt = Integer.parseInt(opcionModificacionCliente);
        } catch (NumberFormatException e) {
            System.out.println("Opción no válida. Debe ser un número.");
            return;
        }

        ClienteService.ModificarCliente(opcionInt, datoCliente, idcliModificacion, edadCliente, fechaNacimientoCliente);
    }
}