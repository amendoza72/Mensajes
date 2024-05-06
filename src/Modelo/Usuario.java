package Modelo;

import java.util.ArrayList;

import Herramientas.Utilidades;

public class Usuario {
    private ArrayList<Usuario> amigos = new ArrayList<>();
    private ArrayList<Mensaje> mensajes = new ArrayList<>();   

    private RedSocial red;
    private String nick;
    private String nombre;
    private String apellido;
    
    public Usuario(RedSocial red, String nick, String nombre, String apellido) {
        this.red = red;
        this.nick = nick;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNick() {
        return nick;
    }
    

    public String getNombre() {
        return nombre;
    }

    private Usuario buscarAmigo(String nick){
        for (Usuario it : amigos){
            if (it.getNick().equals(nick)){
                return it;
            }
        }
        return null;
    }

    public void login(){
        boolean salir = false;
        while (!salir){
            salir = mostrarMenuUsuario();
        }
    }

    public boolean mostrarMenuUsuario(){
        boolean salir = false;
        System.out.println("**********************************");
        System.out.println("****** Menu Usuario: " + nombre + "  ******");
        System.out.println("*********************************");
        System.out.println("1.- Alta amigo");
        System.out.println("2.- Baja amigo");
        System.out.println("3.- Listado amigos");
        System.out.println("4.- Enviar mensaje");
        System.out.println("5.- Leer mensajes");

        System.out.println("9.- Salir");

        
        String opcion = Utilidades.leerString("Opcion :");

        switch (opcion) {
            case "1":
                altaAmigo();
                break;
            case "2":
                bajaAmigo();
                break;
            case "3":
                listarAmigos();
                break;
            case "4":
                enviarMensaje();
                break;
            case "5":
                leerMensajes();
                break;
            case "9":
                salir = true;
                break;
            default:
                break;
        }
        return salir;
    }

    private void altaAmigo(){
        System.out.println("****************************");
        System.out.println("****** Alta Amigo   ******");
        System.out.println("****************************");
        String nick = Utilidades.leerString("nick");

        Usuario usuario = red.buscarUsuario(nick);

        if (usuario == null){
            System.out.println("Ese nick no existe.");
        }
        else{
            amigos.add(usuario);
        }
       
    }

    private void bajaAmigo(){
        System.out.println("****************************");
        System.out.println("****** Baja Amigo     ******");
        System.out.println("****************************");
        String nick = Utilidades.leerString("nick");

        Usuario usuario = buscarAmigo(nick);

        if (usuario == null){
            System.out.println("Ese nick no existe.");
        }
        else{
            amigos.remove(usuario);
        }
    }

    public void escribirDatos(){
        System.out.println("Nick: " + nick);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
    }

    private void listarAmigos(){
        for (Usuario amigo : amigos) {
            amigo.escribirDatos();
            System.out.println("--------------------------------");
        }
    }

    private void enviarMensaje(){
        System.out.println("****************************");
        System.out.println("****** Enviar mensaje ******");
        System.out.println("****************************");
        String nick = Utilidades.leerString("nick");

        Usuario amigo = buscarAmigo(nick);

        if (amigo == null){
            System.out.println("Ese nick no existe.");
        }
        else{
            String mensaje = Utilidades.leerString("mensaje");
            amigo.grabarMensaje(mensaje, this);
        }
    }

    private void grabarMensaje(String textoMensaje, Usuario de){
        mensajes.add(new Mensaje(textoMensaje, de));
    }

    private void leerMensajes(){
        for (Mensaje mensaje : mensajes) {
            mensaje.escribir();
        }
    }
    
}