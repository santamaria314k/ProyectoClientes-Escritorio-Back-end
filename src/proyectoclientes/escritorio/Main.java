package proyectoclientes.escritorio;


//Modelos 
import Models.Cliente;
import Models.ClienteComun;
import Models.Administrador;       
import Models.PQRS;       
        
        
//Controladores        
import Controllers.ClienteController;
import Controllers.ClienteComunController;
import Controllers.AdministradorController;
import Controllers.PqrsController;



//rol
import Models.Rol;
import Controllers.RolController;

//empresa
import Controllers.EmpresaController;
import Controllers.EmpresaOfertaController;
import Controllers.EmpresaSectorController;
import Models.Empresa;
import Models.EmpresaSector;
import Models.OfertaEmpresa;
import Models.Sector;







//packages
import java.util.Scanner;
import java.util.Date;
import java.util.InputMismatchException;
import java.text.SimpleDateFormat;
import java.text.ParseException;




public class Main {


    public static void main(String[] args) {
        
       Scanner escanear = new Scanner(System.in);
       
       
        RolController rolControl = new RolController();

        try {
            System.out.println("Ingrese el nombre del rol: ");
            String nombreRol = escanear.nextLine();

            Rol rol = new Rol(0, nombreRol); // El ID se genera automáticamente en la base de datos
            rolControl.RegistrarRol(rol);
            rolControl.ImprimirRoles();

            System.out.println("Ingrese el id del rol que desea modificar: ");
            int idModificacion = escanear.nextInt();
            escanear.nextLine(); // Consumir nueva línea pendiente

            System.out.println("Ingrese el nuevo nombre del rol: ");
            String nuevoNombre = escanear.nextLine();

            rolControl.ModificarRol(nuevoNombre, idModificacion);
            rolControl.ImprimirRoles();

            System.out.println("Ingrese el id del rol a eliminar: ");
            int idEliminar = escanear.nextInt();
            rolControl.EliminarRol(idEliminar);
            rolControl.ImprimirRoles();

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
            escanear.nextLine();
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        } finally {
            System.out.println("--------//------ROL FIN-------//---------");
            escanear.nextLine();
        }
       
       
        
        
        
        
     
             //------------------CLIENTE COMUN------------------ VS- 5
        
        
        ClienteComunController clienteComunControl = new ClienteComunController();

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
            String metodosPago = "";
            Sector idSector = new Sector(1, "sector");

            System.out.println("Ingrese los nombres del cliente comun: ");
            nombres = escanear.nextLine();
            
            
            System.out.println("Ingrese los apellidos del cliente comun: ");
            apellidoscli = escanear.nextLine();

            System.out.println("Ingrese el correo del cliente comun: ");
            correo = escanear.nextLine();

            System.out.println("Ingrese la direccion del cliente comun: ");
            direccion = escanear.nextLine();

            System.out.println("Ingrese el celular del cliente comun: ");
            celular = escanear.nextLine();

            System.out.println("Ingrese la ocupacion del cliente comun: ");
            ocupacion = escanear.nextLine();

            System.out.println("Ingrese la edad comun: ");
            edadCliente = escanear.nextInt();
            escanear.nextLine();

            System.out.println("Ingrese la fecha de nacimiento (YYYY-MM-DD): ");
            fechaNacimientoCliente = escanear.nextLine();
            escanear.nextLine();

            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNacimiento = formatoFecha.parse(fechaNacimientoCliente);

            System.out.println("Ingrese la profesion del cliente comun: ");
            profesion = escanear.nextLine();
            
            System.out.println("Ingrese el metodo de pago del cliente comun: ");
            metodosPago = escanear.nextLine();
            

            System.out.println("Ingrese el usuario del cliente comun: ");
            user = escanear.nextLine();

            System.out.println("Ingrese la contraseña del cliente comun: ");
            pass = escanear.nextLine();

            ClienteComun clientec = new ClienteComun(0,0,  nombres, apellidoscli, correo, direccion, celular, ocupacion, edadCliente, profesion, fechaNacimiento, idrol, user, pass, metodosPago, idSector);
            clienteComunControl.InsertarClienteComun(clientec);
            clienteComunControl.MostrarDatosClienteComun();

            String datoCliente = "";
            int opcionModificacionCliente = 0;
            int idcliModificacion = 0;
            int idcliEliminar = 0;
            int edadClienteModificacion = 0;
            Date fechaNacimientoClienteModificacion = null;

            System.out.println("Ingrese el ID del cliente comun que desea modificar: ");
            idcliModificacion = escanear.nextInt();

            System.out.println("Ingrese 1 para modificar nombres, 2 para apellidos, 3 para correo, 4 para direccion, 5 para celular, 6 para ocupacion, 7 para edad, 8 para profesion, 9 para usuario, 10 para contraseña, 11 para fecha de nacimiento:, 12 para metodos de pago ");
            opcionModificacionCliente = escanear.nextInt();
            escanear.nextLine();

            if (opcionModificacionCliente == 7) {
                System.out.println("Ingrese la nueva edad: ");
                edadClienteModificacion = escanear.nextInt();
                escanear.nextLine();
            } else if (opcionModificacionCliente == 11) {
                System.out.println("Ingrese la nueva fecha de nacimiento (YYYY-MM-DD): ");
                String fechaNacimientoStri = escanear.nextLine();
                try {
                    fechaNacimientoClienteModificacion = formatoFecha.parse(fechaNacimientoStri);
                } catch (ParseException e) {
                    System.out.println("Error: Formato de fecha incorrecto. Use ContentValues.putNull(MediaStore.Images.ImageColumns.DATE_TAKEN).");
                    return;
                }
            } else {
                System.out.println(" cm Ingrese el dato: ");
                datoCliente = escanear.nextLine();
            }

            clienteComunControl.ModificarClienteComun(idcliModificacion, String.valueOf(opcionModificacionCliente), datoCliente, edadClienteModificacion, fechaNacimientoClienteModificacion);
            clienteComunControl.MostrarDatosClienteComun();

            System.out.println("Ingrese el ID del cliente a eliminar: ");
            idcliEliminar = escanear.nextInt();
            clienteComunControl.EliminarRegistroCliente(idcliEliminar);
            clienteComunControl.MostrarDatosClienteComun();

        } catch (InputMismatchException e) {
            System.out.println("Error: Ingresaste un tipo de dato incorrecto.");
        } catch (ParseException e) {
            System.out.println("Error: Formato de fecha incorrecto. Use ContentValues.putNull(MediaStore.Images.ImageColumns.DATE_TAKEN).");
        } catch (Exception e) {
            System.out.println("Error de conexión");
            e.printStackTrace();
        } finally {
            System.out.println("--------//------CLIENTE COMUN-FIN-------//---------");
            escanear.nextLine();
        }


        
        
       
      
       
       
               //-------------------------CLIENTE  --------------------------
          

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
            escanear.nextLine();
        }
        

       
       
       
       
       
        
        
        
        

       
       
       
       


        
        
        
        
        //Pqrs ----------------------------vs-5 con db
     
         PqrsController pqrsControl = new PqrsController();

        try {
            System.out.println("Ingrese el tipo de comentario: ");
            String tipoComentario = escanear.nextLine();

            System.out.println("Ingrese la descripción: ");
            String descripcion = escanear.nextLine();

            System.out.println("Ingrese el ID del Cliente Común: ");
            int idComun = escanear.nextInt();
            escanear.nextLine();

            PQRS pqrs = new PQRS(0, idComun, tipoComentario, descripcion);
            pqrsControl.RegistrarPqrs(pqrs);
            pqrsControl.ImprimirPqrs();

            System.out.println("Ingrese el id del PQRS que desea modificar: ");
            int idModificacion = escanear.nextInt();
            System.out.println("Ingrese 1 para modificar el tipo de comentario, 2 para modificar la descripción: ");
            int opcionModificacion = escanear.nextInt();
            escanear.nextLine();

            System.out.println("Ingrese el nuevo valor: ");
            String nuevoValor = escanear.nextLine();

            pqrsControl.ModificarPqrs(opcionModificacion, nuevoValor, idModificacion);
            pqrsControl.ImprimirPqrs();

            System.out.println("Ingrese el id del PQRS a eliminar: ");
            int idEliminar = escanear.nextInt();
            pqrsControl.EliminarPqrs(idEliminar);
            pqrsControl.ImprimirPqrs();

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
            escanear.nextLine();
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        } finally {
            System.out.println("--------//------PQRS FIN-------//---------");
            escanear.nextLine();
        }
        
        
        
        
        
        

       
        

            // Adminsitrador con conexion a DB  VS-5
            
            AdministradorController adminControl = new AdministradorController();
            Rol idrol = new Rol(2, "Administrador");

        try {
          
            int idAdmin = 0;
           

            System.out.println("Ingrese su nombre Admin:");
            String nombreAdmin = escanear.nextLine();

            System.out.println("Ingrese su user Admin:");
            String userAdmin = escanear.next();

            System.out.println("Ingrese el pass de admin:");
            String passAdmin = escanear.next();

            Administrador admin1 = new Administrador(idAdmin, nombreAdmin, userAdmin, passAdmin, idrol);
            adminControl.RegistrarAdministrador(admin1);
            adminControl.ImprimirAdministrador();

            System.out.println("Ingrese el id del admin a modificar:");
            int idModificacionAdmin = escanear.nextInt();

            System.out.println("Ingrese 1 para modificar nombre, 2 para usuario o 3 para contraseña:");
            int opcionModificacionAdmin = escanear.nextInt();
            escanear.nextLine();

            System.out.println("Ingrese el nuevo valor:");
            String datoAdmin = escanear.nextLine();

            adminControl.ModificarAdministrador(opcionModificacionAdmin, datoAdmin, idModificacionAdmin);
            adminControl.ImprimirAdministrador();

            System.out.println("Ingrese el id del admin a eliminar:");
            int idEliminarAdmin = escanear.nextInt();
            adminControl.EliminarAdministrador(idEliminarAdmin);
            adminControl.ImprimirAdministrador();

        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada inválida. Asegúrese de ingresar el tipo de dato correcto.");
            escanear.nextLine();
        } finally {
            System.out.println("--------//------ADFMINISTRADOR-FIN-------//---------");
            escanear.nextLine();
        }

       
       
       
        
        
        
        
        
        
        
        
        
               
                    
//Empresa --------------------------------vs5 & bd  

 try {
            
            EmpresaController empresaControl = new EmpresaController();
            EmpresaSectorController empresaSectorControl = new EmpresaSectorController();
            EmpresaOfertaController empresaOfertaContol = new EmpresaOfertaController();

            int nitEmpresa;
            String razonSocialEmpresa = "";
            String telefonoEmpresa = "";
            String actividadEmpresa = "";
            String userempresa = "";
            String passempresa = "";
            int sectorPerteneciente;
            int idoferta;
            String oferta;

            System.out.println("Ingrese el nit: ");
            nitEmpresa = escanear.nextInt();
            escanear.nextLine();
            
            System.out.println("Ingrese la razon social: ");
            razonSocialEmpresa = escanear.nextLine();
            
            System.out.println("Ingrese su telefono: ");
            telefonoEmpresa = escanear.nextLine();
            
            System.out.println("Ingrese su actividad: ");
            actividadEmpresa = escanear.nextLine();
            
            System.out.println("Ingrese un nombre de usuario: ");
            userempresa = escanear.nextLine();
            
            System.out.println("Ingrese una contraseña: ");
            passempresa = escanear.nextLine();
            
            System.out.println("Ingrese el numero del sector al que pertenece la empresa. "
                    + "1. Alimentario "
                    + "2. Textil "
                    + "3. Químico "
                    + "4. Militar "
                    + "5. Siderúrgica "
                    + "6. Cementera "
                    + "7. Turística "
                    + "8. Forestal "
                    + "9. Automovilística ");
            sectorPerteneciente = escanear.nextInt();
            
            System.out.println("Ingrese el id de la oferta: ");
            idoferta = escanear.nextInt();
            escanear.nextLine();
            
            System.out.println("Ingrese la oferta: ");
            oferta = escanear.nextLine();

            Empresa empresa1 = new Empresa(nitEmpresa, razonSocialEmpresa, telefonoEmpresa, actividadEmpresa, userempresa, passempresa);
            empresaControl.InsertarEmpresa(empresa1);
            OfertaEmpresa ofertaEmpresa1 = new OfertaEmpresa(idoferta, empresa1, oferta);
            empresaOfertaContol.RegistrarOfertaEmpresa(ofertaEmpresa1);
            empresaControl.MostrarDatos();
            empresaOfertaContol.MostrarOfertasEmpresas();
            
            Sector sector1;
            switch (sectorPerteneciente){
                case 1: sector1 = new Sector(sectorPerteneciente, "Alimentario"); break;
                case 2: sector1 = new Sector(sectorPerteneciente, "Textil"); break;
                case 3: sector1 = new Sector(sectorPerteneciente, "Químico"); break;
                case 4: sector1 = new Sector(sectorPerteneciente, "Militar"); break;
                case 5: sector1 = new Sector(sectorPerteneciente, "Siderúrgica"); break;
                case 6: sector1 = new Sector(sectorPerteneciente, "Cementera"); break;
                case 7: sector1 = new Sector(sectorPerteneciente, "Turística"); break;
                case 8: sector1 = new Sector(sectorPerteneciente, "Forestal"); break;
                case 9: sector1 = new Sector(sectorPerteneciente, "Automovilística"); break;
                default: System.out.println("Opción no válida."); return;
            }
            
            EmpresaSector empresaSector1 = new EmpresaSector(1, sector1, empresa1);
            empresaSectorControl.RegistrarTipoSector(empresaSector1);
            empresaSectorControl.MostrarSectoresEmpresa();

            String datoEmpresa;
            String nuevaOferta;
            int opcionModificacionEmpresa;
            int nitModificacion;
            int opcionModificacionSector;
            int idofertaModificacion;
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
            System.out.println("Ingrese el numero del sector al que quiere cambiar: " 
                    + "1. Alimentario "
                    + "2. Textil "
                    + "3. Químico "
                    + "4. Militar "
                    + "5. Siderúrgica "
                    + "6. Cementera "
                    + "7. Turística "
                    + "8. Forestal "
                    + "9. Automovilística ");
            opcionModificacionSector = escanear.nextInt();
            empresaSectorControl.ModificarEmpresaSector(opcionModificacionSector);
            System.out.println("Ingrese el id de la oferta a modificar: ");
            idofertaModificacion = escanear.nextInt();
            escanear.nextLine();
            
            System.out.println("Ingrese la oferta modificada: ");
            nuevaOferta = escanear.nextLine();
            empresaOfertaContol.ModificarOfertaEmpresa(idofertaModificacion, nuevaOferta);
            empresaControl.MostrarDatos();
            empresaSectorControl.MostrarSectoresEmpresa();
            empresaOfertaContol.MostrarOfertasEmpresas();
            
            
            System.out.println("Ingrese el id de la oferta que desea eliminar: ");
            idoferta = escanear.nextInt();
            escanear.nextLine();
            empresaOfertaContol.EliminarOfertaEmpresa(idoferta);
            empresaSectorControl.EliminarEmpresaSector();
            System.out.println("Ingrese el nit de la empresa a eliminar: ");
            nitEliminar = escanear.nextInt();
            empresaControl.EliminarRegistro(nitEliminar);
            empresaControl.MostrarDatos();
            empresaOfertaContol.MostrarOfertasEmpresas();

        }
catch (InputMismatchException e) {
            System.out.println("Error: Ingresaste un tipo de dato incorrecto.");
        } finally {
             System.out.println("--------//------EMPRESA-FIN-------//---------");
        }
        
       
       
        
        
        
        
        
        
        
        
        
        
   

        
    }
    
}
