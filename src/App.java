
import Herramientas.Utilidades;
import Modelo.RedSocial;

public class App {
    public static RedSocial red = new RedSocial();
        public static void main(String[] args) throws Exception {
        boolean salir = false;
            while (!salir){
                salir = mostrarMenuPrincipal();
            }
    }

     private static boolean mostrarMenuPrincipal(){
        boolean salir = false;
        System.out.println("****************************");
        System.out.println("****** Menu principal ******");
        System.out.println("****************************");
        System.out.println("1.- Alta usuario");
        System.out.println("2.- Baja usuario");
        System.out.println("3.- Login");
        System.out.println("9.- Salir");

        String opcion = Utilidades.leerString("Opcion :");

        switch (opcion) {
            case "1":
                red.altaUsuario();
                break;
            case "2":
                red. bajaUsuario();
                break;
            case "3":
                red. login();
                break;
            case "9":
                salir = true;
                break;
            default:
                break;
        }
        return salir;
    }

   
}
