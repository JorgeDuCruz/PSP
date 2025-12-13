package org.example;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class MandarMensaje {
    public static void MandarMensaje(Session session){
        //Enviar Mensaje
        try{
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("prueba@java.com"));
            msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse("destino@cualquiera.com"));
            msg.setSubject("Prueba de Agente - Jorge Durán");
            msg.setText("El sistema de notificaciones está activo.");

            Transport.send(msg);
            System.out.println("Mensaje enviado");

        }catch (MessagingException e){
            System.out.println("Error con el mensaje. "+e.getMessage());
        }
    }
}
