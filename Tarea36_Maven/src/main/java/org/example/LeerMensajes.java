package org.example;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;

import java.util.Properties;

public class LeerMensajes {
    public static void leerMensajes(Properties props, Session session, int msgs){
        props.put("mail.pop3.host","pop3.mailtrap.io");
        props.put("mail.pop3.port","9950");
        props.put("mail.pop3.starttls.enable","true");

        try {
            Store store = session.getStore("pop3");
            store.connect("863f7db32b6f21", "5523bcfe2fefeb");

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] mensajes;
            int cantidadMsgs = inbox.getMessageCount();
            if (cantidadMsgs<=msgs || msgs<0){
                mensajes = inbox.getMessages();
            }
            else {
                mensajes = inbox.getMessages(1,msgs);
            }
            for (Message m : mensajes) {
                System.out.println("Remitente: " + InternetAddress.toString(m.getFrom()));
                System.out.println("Asunto: " + m.getSubject());
            }
        }catch (NoSuchProviderException e) {
            System.out.println("Error con la sesión. "+e.getMessage());
        } catch (MessagingException e) {
            System.out.println("Error con la conexión. "+e.getMessage());
        }
    }
}
