package Modelo;

import java.util.ArrayList;

import Herramientas.Utilidades;

public class RedSocial {
    ArrayList<Usuario> usuarios = new ArrayList<>();

     public Usuario buscarUsuario(String nick){
        for (Usuario it : usuarios){
            if (it.getNick().equals(nick)){
                return it;
            }
        }
        return null;
    }

    public void altaUsuario(){
        System.out.println("****************************");
        System.out.println("****** Alta Usuario   ******");
        System.out.println("****************************");
        String nick = Utilidades.leerString("nick");

        Usuario usuario = buscarUsuario(nick);

        if (usuario != null){
            System.out.println("Ese código ya existe.");
        }
        else{
            String nombre = Utilidades.leerString("nombre usuario: ");
            String apellido = Utilidades.leerString("apellido usuario: ");
            usuarios.add(new Usuario(this, nick, nombre, apellido));
        }
    }


    public void bajaUsuario(){
        System.out.println("****************************");
        System.out.println("****** Baja Usuario   ******");
        System.out.println("****************************");
        String nick = Utilidades.leerString("nick");

        Usuario usuario = buscarUsuario(nick);

        if (usuario == null){
            System.out.println("Ese nick no existe.");
        }
        else{
                usuarios.remove(usuario);
        }
    }

    public void login(){
        System.out.println("****************************");
        System.out.println("****** Login Usuario   ******");
        System.out.println("****************************");
        String nick = Utilidades.leerString("nick");

        Usuario usuario = buscarUsuario(nick);

        if (usuario == null){
            System.out.println("Ese nick no existe.");
        }
        else{
            usuario.login();
        }
    }

}
