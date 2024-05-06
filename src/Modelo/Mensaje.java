package Modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Mensaje {
    String texto;
    Usuario de;
    Date fechaMensaje;

    public Mensaje(String texto, Usuario de) {
        this.texto = texto;
        this.de = de;
        Calendar calendar = Calendar.getInstance();
        fechaMensaje = calendar.getTime();
    }

    public void escribir(){
        System.out.println("Mensaje de: " + de.getNick() + " - " + de.getNombre());

        String patron = "MM/dd/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(patron);
        System.out.println("El día: " + df.format(fechaMensaje));
        System.out.println("Mensaje: " + texto);
    }
}
