package proyectoclientes.escritorio;
/**
//administador
import Controllers.AdministradorController;
import Models.Administrador;


//cliente potencial
import Models.ClientePotencial;
import Controllers.ClientePotencialController;

**/

//cliente
import Controllers.ClienteController;
import Models.Cliente;

//empresa
import Controllers.EmpresaController;
import Models.Empresa;


import java.util.Scanner;

import java.util.InputMismatchException;




public class Main {


    public static void main(String[] args) {
        
       
        
        Scanner escanear = new Scanner(System.in);

        //cliente ----------------------------vs5 & bd
        
        ClienteController clienteController = new ClienteController();
        
        String nombres = "";
        String apellidoscli = "";
        String celular = "";
        String ocupacion = "";
        int edad = 0;

        try {
            System.out.println("Ingrese los nombres del cliente: ");
            nombres = escanear.nextLine();
            
            System.out.println("Ingrese los apellidos del cliente: ");
            apellidoscli = escanear.nextLine();
            
            System.out.println("Ingrese el celular del cliente: ");
            celular = escanear.nextLine();
            
            System.out.println("Ingrese la ocupacion del cliente: ");
            ocupacion = escanear.nextLine();
            
            System.out.println("edad del cliente: ");
            edad = escanear.nextInt();
            
            
            Cliente clientess = new Cliente(0, nombres, apellidoscli, celular, ocupacion, edad);
            clienteController.InsertarCliente(clientess);
            clienteController.MostrarDatosCliente();

            // modificar 
            int idModificarcli;
            int opcionModificarcli;
            String info;
            int edadModificar;

            System.out.println("Ingrese el id del cliente que desea modificar: ");
            idModificarcli = escanear.nextInt();
           
            System.out.println("Ingrese 1 para modificar nombres, 2 para apellidos, 3 para celular, 4 para ocupacion, 5 para edad: ");
            opcionModificarcli = escanear.nextInt();
            escanear.nextLine();

            if(opcionModificarcli == 5){
                System.out.println("Ingrese la edad: ");
                edadModificar = escanear.nextInt();
                clienteController.ModificarCliente(idModificarcli, opcionModificarcli, "", edadModificar);
            } else {

                System.out.println("Ingrese la informacion: ");
                info = escanear.nextLine();
                clienteController.ModificarCliente(idModificarcli, opcionModificarcli, info, 0);
            }

            clienteController.MostrarDatosCliente();

            // eliminar
            int idEliminarcli;

            System.out.println("Ingrese el id del cliente a eliminar: ");
            idEliminarcli = escanear.nextInt();
            clienteController.EliminarRegistroCliente(idEliminarcli);
            clienteController.MostrarDatosCliente();

        } catch (InputMismatchException  e) {
            System.out.println("Error: Ingresaste un tipo de dato incorrecto.");
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
        
           
        
        
        
        
        
        
        
        
        
      

        
        /**
        
        //administrador ----------------------------vs4
        
        ClientePotencialController ClientePotencialControl = new ClientePotencialController();
        AdministradorController adminControl = new AdministradorController();
        int id = 0;
        String dato = "";
        String nombre = "";
        String apellidos = "";
        String usuario = "";
        String contraseña = "";
        String email = "";
        String telefono = "";
        
        System.out.println("Ingrese el Id: ");
        id = leerDato.nextInt();
        System.out.println("Ingrese su nombre: ");
        nombre = leerDato.next();
        System.out.println("Ingrese su apellido: ");
        apellidos = leerDato.next();
        System.out.println("Ingrese el usuario: ");
        usuario = leerDato.next();
        System.out.println("Ingrese la contraseña: ");
        contraseña = leerDato.next();
        System.out.println("Ingrese su correo: ");
        email = leerDato.next();
        System.out.println("Ingrese su teléfono: ");
        telefono = leerDato.next();
        
        Administrador admin1 = new Administrador(id, nombre, apellidos, usuario, contraseña, email, telefono);
        adminControl.InsertarAdministrador(admin1);
        adminControl.MostrarDatos();
        

        
        //modificar
        int idEliminar;
        int idModificacion;
        int opcionModificacion;
        
        
        System.out.println("Ingrese el id del administrador que desea modificar: ");
        idModificacion = leerDato.nextInt();
        System.out.println("Ingrese 1 para modificar nombre, 2 para apellido, 3 para usuario, 4 para correo, 5 para contraseña o 6 para teléfono: ");
        opcionModificacion = leerDato.nextInt();
        System.out.println("Ingrese el dato: ");
        dato = leerDato.next();
        adminControl.ModificarAdministrador(idModificacion, opcionModificacion, dato);
        adminControl.MostrarDatos();
        
        
        //eliminar
        
        System.out.println("Ingrese el id del admin a eliminar: ");
        idEliminar = leerDato.nextInt();
        adminControl.EliminarRegistro(idEliminar);
        adminControl.MostrarDatos();
        
        **/
        
        
    
        
        
        
        
        
        
        
        
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
