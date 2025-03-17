package proyectoclientes.escritorio;
/**
//administador
import Controllers.AdministradorController;
import Models.Administrador;


//cliente potencial
import Models.ClientePotencial;
import Controllers.ClientePotencialController;

**/
//Pqrs
import Models.ClienteComun;
import Controllers.PqrsController;
import Models.PQRS;


//cliente
import Controllers.AdministradorController;
import Controllers.ClienteController;
import Models.Cliente;

//rol
import Models.Rol;

//empresa
import Controllers.EmpresaController;
import Models.Administrador;
import Models.Empresa;


import java.util.Scanner;
import java.util.Date;
import java.util.InputMismatchException;
import java.text.SimpleDateFormat;
import java.text.ParseException;




public class Main {


    public static void main(String[] args) {
        
       Scanner escanear = new Scanner(System.in);
       
       /*
        ClienteController clienteControl = new ClienteController();

        try {
            String nombres = "";
            String apellidoscli = "";
            String correo = "";
            String direccion = "";
            String celular = "";
            String ocupacion = "";
            int edadCliente = 0;
            String profesion = "";
            String fechaNacimientoCliente = "";
            Rol idrol = new Rol(1, "Cliente");
            String user = "";
            String pass = "";

            System.out.println("Ingrese los nombres del cliente: ");
            nombres = escanear.nextLine();

            System.out.println("Ingrese los apellidos del cliente: ");
            apellidoscli = escanear.nextLine();

            System.out.println("Ingrese el correo del cliente: ");
            correo = escanear.nextLine();

            System.out.println("Ingrese la direccion del cliente: ");
            direccion = escanear.nextLine();

            System.out.println("Ingrese el celular del cliente: ");
            celular = escanear.nextLine();

            System.out.println("Ingrese la ocupacion del cliente: ");
            ocupacion = escanear.nextLine();

            System.out.println("Ingrese la edad: ");
            edadCliente = escanear.nextInt();
            escanear.nextLine();

            System.out.println("Ingrese la fecha de nacimiento (YYYY-MM-DD): ");
            fechaNacimientoCliente = escanear.nextLine();

            System.out.println("Ingrese la profesion del cliente: ");
            profesion = escanear.nextLine();

            System.out.println("Ingrese el usuario del cliente: ");
            user = escanear.nextLine();

            System.out.println("Ingrese la contraseña del cliente: ");
            pass = escanear.nextLine();

            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNacimiento = formatoFecha.parse(fechaNacimientoCliente);

            Cliente cliente1 = new Cliente(0, nombres, apellidoscli, correo, direccion, celular, ocupacion, edadCliente, profesion, fechaNacimiento, idrol, user, pass);
            clienteControl.InsertarCliente(cliente1);
            clienteControl.MostrarDatosCliente();

            String datoCliente = "";
            int opcionModificacionCliente = 0;
            int idcliModificacion = 0;
            int idcliEliminar = 0;
            int edadClienteModificacion = 0;
            Date fechaNacimientoClienteModificacion = null;

            System.out.println("Ingrese el ID del cliente que desea modificar: ");
            idcliModificacion = escanear.nextInt();

            System.out.println("Ingrese 1 para modificar nombres, 2 para apellidos, 3 para correo, 4 para direccion, 5 para celular, 6 para ocupacion, 7 para edad, 8 para profesion, 9 para usuario, 10 para contraseña, 11 para fecha de nacimiento: ");
            opcionModificacionCliente = escanear.nextInt();
            escanear.nextLine();

            if (opcionModificacionCliente == 7) {
                System.out.println("Ingrese la nueva edad: ");
                edadClienteModificacion = escanear.nextInt();
                escanear.nextLine();
            } else if (opcionModificacionCliente == 11) {
                System.out.println("Ingrese la nueva fecha de nacimiento (YYYY-MM-DD): ");
                String fechaNacimientoStr = escanear.nextLine();
                try {
                    fechaNacimientoClienteModificacion = formatoFecha.parse(fechaNacimientoStr);
                } catch (ParseException e) {
                    System.out.println("Error: Formato de fecha incorrecto. Use YYYY-MM-DD.");
                    return;
                }
            } else {
                System.out.println("Ingrese el dato: ");
                datoCliente = escanear.nextLine();
            }

            clienteControl.ModificarCliente(idcliModificacion, String.valueOf(opcionModificacionCliente), datoCliente, edadClienteModificacion, fechaNacimientoClienteModificacion);
            clienteControl.MostrarDatosCliente();

            System.out.println("Ingrese el ID del cliente a eliminar: ");
            idcliEliminar = escanear.nextInt();
            clienteControl.EliminarRegistroCliente(idcliEliminar);
            clienteControl.MostrarDatosCliente();

        } catch (InputMismatchException e) {
            System.out.println("Error: Ingresaste un tipo de dato incorrecto.");
        } catch (ParseException e) {
            System.out.println("Error: Formato de fecha incorrecto. Use YYYY-MM-DD.");
        } catch (Exception e) {
            System.out.println("Error de conexión");
            e.printStackTrace();
        } finally {
            System.out.println("--------//------CLIENTE-FIN-------//---------");
        }
        
        
        
        
        
             
//Empresa --------------------------------vs5 & bd  

 try {
            
            EmpresaController empresaControl = new EmpresaController();

            int nitEmpresa;
            String razonSocialEmpresa = "";
            String telefonoEmpresa = "";
            String actividadEmpresa = "";

            System.out.println("Ingrese el nit: ");
            nitEmpresa = escanear.nextInt();
            System.out.println("Ingrese la razon social: ");
            razonSocialEmpresa = escanear.next();
            System.out.println("Ingrese su telefono: ");
            telefonoEmpresa = escanear.next();
            System.out.println("Ingrese su actividad: ");
            actividadEmpresa = escanear.next();

            Empresa empresa1 = new Empresa(nitEmpresa, razonSocialEmpresa, telefonoEmpresa, actividadEmpresa);
            empresaControl.InsertarEmpresa(empresa1);
            empresaControl.MostrarDatos();

            String datoEmpresa;
            int opcionModificacionEmpresa;
            int nitModificacion;
            int nitEliminar;

            System.out.println("Ingrese el nit de la empresa que desea modificar: ");
            nitModificacion = escanear.nextInt();
            System.out.println("Ingrese 1 para modificar razon social, 2 para telefono, 3 para actividad: ");
            opcionModificacionEmpresa = escanear.nextInt();
            System.out.println("Ingrese el dato: ");
            datoEmpresa = escanear.next();
            escanear.nextLine();
            empresaControl.ModificarEmpresa(nitModificacion, String.valueOf(opcionModificacionEmpresa), datoEmpresa);
            empresaControl.MostrarDatos();
            
            
            System.out.println("Ingrese el nit de la empresa a eliminar: ");
            nitEliminar = escanear.nextInt();
            empresaControl.EliminarRegistro(nitEliminar);
            empresaControl.MostrarDatos();

        } catch (InputMismatchException e) {
            System.out.println("Error: Ingresaste un tipo de dato incorrecto.");
        } finally {
             System.out.println("--------//------EMPRESA-FIN-------//---------");
        }
        
           
        
        
        
        
        
        
        
        
        
      

        
        
        
        //administrador ----------------------------vs4
        
        AdministradorController adminControl = new AdministradorController();
        int idAdmin;
        String nombreAdmin;
        String userAdmin;
        String passAdmin;
        Rol idrol = new Rol(2, "Administrador"); // Se crea solo una vez

        System.out.println("Ingrese el Id: ");
        idAdmin = escanear.nextInt();
        escanear.nextLine(); // Consumir nueva línea pendiente

        System.out.println("Ingrese su nombre Admin: ");
        nombreAdmin = escanear.nextLine();

        System.out.println("Ingrese su user Admin: ");
        userAdmin = escanear.next();

        System.out.println("Ingrese el pass de admin: ");
        passAdmin = escanear.next();

        Administrador admin1 = new Administrador(idAdmin, nombreAdmin, userAdmin, passAdmin, idrol);
        adminControl.RegistrarAdministrador(admin1);
        adminControl.ImprimirAdministrador();

        // Modificar Administrador
        String datoAdmin;
        int idModificacionAdmin;
        int opcionModificacionAdmin;

        System.out.println("Ingrese el id del administrador que desea modificar: ");
        idModificacionAdmin = escanear.nextInt();
        System.out.println("Ingrese 1 para modificar nombre, 2 para usuario o 3 para contraseña: ");
        opcionModificacionAdmin = escanear.nextInt();
        escanear.nextLine(); // Consumir nueva línea pendiente

        System.out.println("Ingrese el nuevo valor: ");
        datoAdmin = escanear.nextLine();

        adminControl.ModificarAdministrador(opcionModificacionAdmin, datoAdmin, idModificacionAdmin);
        adminControl.ImprimirAdministrador();

        // Eliminar Administrador
        int idEliminarAdmin;
        System.out.println("Ingrese el id del admin a eliminar: ");
        idEliminarAdmin = escanear.nextInt();
        adminControl.EliminarAdministrador(idEliminarAdmin);
        adminControl.ImprimirAdministrador();

        escanear.close(); // Cerrar scanner al final

*/

    //Pqrs ----------------------------vs4
        
        PqrsController pqrsControl = new PqrsController(); 
        int idPQRS;
        String tipoComentario;
        String descripcion;

        System.out.println("Ingrese el Id del PQRS: ");
        idPQRS = escanear.nextInt();
        escanear.nextLine(); // Consumir nueva línea pendiente

        System.out.println("Ingrese el tipo de comentario: ");
        tipoComentario = escanear.nextLine();

        System.out.println("Ingrese la descripción: ");
        descripcion = escanear.nextLine();

        System.out.println("Ingrese el ID del Cliente Común: ");
        int idClienteComun = escanear.nextInt();

        ClienteComun cliente = new ClienteComun(idClienteComun, "Nombre", "Apellido", "correo@example.com", "Direccion", "123456789", "Ocupacion", 30, "Profesion", null, null, "usuario", "contraseña", "Tarjeta");
        PQRS pqrs = new PQRS(idPQRS, cliente, tipoComentario, descripcion);

        pqrsControl.RegistrarPqrs(pqrs);
        pqrsControl.ImprimirPqrs();

        // Modificar PQRS
        String nuevoValor;
        int idModificacion;
        int opcionModificacion;

        System.out.println("Ingrese el id del PQRS que desea modificar: ");
        idModificacion = escanear.nextInt();
        System.out.println("Ingrese 1 para modificar el tipo de comentario, 2 para modificar la descripción: ");
        opcionModificacion = escanear.nextInt();
        escanear.nextLine(); // Consumir nueva línea pendiente

        System.out.println("Ingrese el nuevo valor: ");
        nuevoValor = escanear.nextLine();

        pqrsControl.ModificarPqrs(opcionModificacion, nuevoValor, idModificacion);
        pqrsControl.ImprimirPqrs();

        // Eliminar PQRS
        int idEliminar;
        System.out.println("Ingrese el id del PQRS a eliminar: ");
        idEliminar = escanear.nextInt();
        pqrsControl.EliminarPqrs(idEliminar);
        pqrsControl.ImprimirPqrs();

        escanear.close(); // Cerrar scanner al final
        
        
        /**
        
          //ClientePotencial  vs -------------------------------------------4
        
        int idClientePotencial;
        String nombresClientePotencial = "";
        String apellidoClientePotencial = "";
        String celularClientePotencial = "";
        int edadClientePotencial;
        String ocupacionClientePotencial = "";
        String interesesClientePotencial = "";
        
        System.out.println("Ingrese el Id del Cliente Potencial: ");
        idClientePotencial = leerDato.nextInt();
        System.out.println("Ingrese su nombre del Cliente Potencial: ");
        nombresClientePotencial = leerDato.next();
        System.out.println("Ingrese su apellido del Cliente Potencial: ");
        apellidoClientePotencial = leerDato.next();
        System.out.println("Ingrese el celular del ClientePotencial: ");
        celularClientePotencial = leerDato.next();
        System.out.println("Ingrese la edad del Cliente Potencial");
        edadClientePotencial = leerDato.nextInt();
        System.out.println("Ingrese la ocupacion del Cliente Potencial ");
        ocupacionClientePotencial = leerDato.next();
        System.out.println("Ingrese el interes del Cliente Potencial ");
        interesesClientePotencial = leerDato.next();
        
        ClientePotencial CliePoten1 = new ClientePotencial(idClientePotencial, nombresClientePotencial, apellidoClientePotencial, celularClientePotencial, edadClientePotencial, ocupacionClientePotencial, interesesClientePotencial);
        ClientePotencialControl.CrearClientePotencial(CliePoten1);
        ClientePotencialControl.ImprimirDatosClientePotencial();
        
        //variables
        int idCpModificacion;
        int opcionModificacionCp;
        int CpEliminar; 
        String datoCp;
        
        System.out.println("Ingrese el id del Cliente POtencial que desea modificar: ");
        idCpModificacion = leerDato.nextInt();
        System.out.println("Ingrese 1 para nombre, 2 para apellido, 3 para celular, 4 para edad, 5 para ocupacion, 6 para actividades: ");
        opcionModificacionCp = leerDato.nextInt();
        System.out.println("Ingrese el dato: ");
        datoCp = leerDato.next();
        ClientePotencialControl.ModificarDatosPotencial(idCpModificacion, opcionModificacionCp, datoCp);
        ClientePotencialControl.ImprimirDatosClientePotencial();
        
        //elimninar
        System.out.println("Ingrese el id de cliente potencial a eliminar: ");
        CpEliminar = leerDato.nextInt();
        ClientePotencialControl.EliminarDatosClientePotencial(CpEliminar);
        ClientePotencialControl.ImprimirDatosClientePotencial();
        
        
        
        **/
        
        
        
        
        
     
  
    
        
        
    }
    
}
