package org.example;

import jakarta.mail.*;

import java.util.Properties;

public class Main {
    static void main() {
        //Preparando sesión
        Properties props = new Properties();
        props.put("mail.smtp.host","sandbox.smtp.mailtrap.io");
        props.put("mail.smtp.port","2525");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("863f7db32b6f21","5523bcfe2fefeb");
            }
        });

        //MandarMensaje.MandarMensaje(session);

        //Leer mensajes
        LeerMensajes.leerMensajes(props,session,-1);



    }
}
