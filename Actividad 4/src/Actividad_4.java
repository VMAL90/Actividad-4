import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class Actividad_4 {
    public static void main(String[] args) throws IOException, InterruptedException {
        AddressBook objContactos = new AddressBook();
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int vOpcion;
        String vRuta;
        String vRespuesta;
        String[] vInfoContacto;

        while(!salir){
            vOpcion = Menu();
            switch (vOpcion){
                case 1:
                    System.out.println("Ingrese la ruta del archivo a cargar:");
                    vRuta = sn.nextLine();
                    objContactos.load(vRuta);
                    break;
                case 2:
                    System.out.println("Ingrese la ruta del archivo a guardar:");
                    vRuta = sn.nextLine();
                    System.out.println("El archivo se reemplazara, ¿Desea continuar? (y/n):");
                    vRespuesta = sn.nextLine();
                    if(vRespuesta.toUpperCase().equals("Y")){
                        objContactos.save(vRuta);
                    }
                    break;
                case 3:
                    LimpiaPantalla();
                    objContactos.list();
                    break;
                case 4:
                    LimpiaPantalla();
                    vInfoContacto = SolicitaNumero_Nombre(1);
                    objContactos.create(vInfoContacto[0],vInfoContacto[1]);
                    break;
                case 5:
                    LimpiaPantalla();
                    vInfoContacto = SolicitaNumero_Nombre(2);
                    objContactos.delete(vInfoContacto[0]);
                    break;
                case 6: salir  = true;
                    break;
                default:
                    System.out.println("Accion invalida...");
                    break;
            }
            System.out.println("Presione Enter...");
            sn.nextLine();

        }
    }

    //Menu interactivo
    public static int Menu() throws IOException, InterruptedException {
        Scanner sn = new Scanner(System.in);
        int vOpcion;
        LimpiaPantalla();
        System.out.println("1. Carga de contactos de archivo.");
        System.out.println("2. Guarda Contactos en archivo.");
        System.out.println("3. Lista de Contactos.");
        System.out.println("4. Nuevo Contacto.");
        System.out.println("5. Elimina Contacto.");
        System.out.println("6. Salir...");

        System.out.println("Escribe el numero de accion:");
        vOpcion = sn.nextInt();
        return vOpcion;
    }

    //Limpia pantalla
    public  static  void LimpiaPantalla() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    //Metodo que solicita datos para agregar o eliminar contactos
    public static String[] SolicitaNumero_Nombre(int pOpcion){
        Scanner sn = new Scanner(System.in);
        String[] vDatosContacto = new String[2];
        if(pOpcion == 1){
        System.out.println("Ingresar el numero de contacto:");
        vDatosContacto[0] = sn.nextLine();
        System.out.println("Ingresar el nombre de contacto:");
        vDatosContacto[1] = sn.nextLine();
        }else{
            System.out.println("Ingresar el numero de contacto:");
            vDatosContacto[0] = sn.nextLine();
        }

        return vDatosContacto;
    }



}
