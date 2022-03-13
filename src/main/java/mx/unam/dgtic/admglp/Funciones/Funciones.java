/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.unam.dgtic.admglp.Funciones;

import jakarta.activation.CommandMap;
import jakarta.activation.MailcapCommandMap;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

/**
 *
 * @author unam
 */
public class  Funciones {
    
    public static boolean mandaCorreo(String subject, String mensaje, String correo) throws Exception {
        boolean salida = false;
        try {
            Properties prop = new Properties();
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.starttls.enable", "true");

            final String username = "dgpe.curso.04@gmail.com";
            final String password = "4M04M1N0V14M4R1";

            Session session = Session.getDefaultInstance(prop, new jakarta.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            String htmlBody = "<strong>SIN HTML</strong>";
            String textBody = mensaje;

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("dgpe.curso.04@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo));
            msg.setSubject(subject);
            MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
            mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
            mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
            mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
            mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
            mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
            CommandMap.setDefaultCommandMap(mc);
            msg.setText(htmlBody);
            msg.setContent(textBody, "text/html");
            Transport.send(msg);

            salida = true;
        } catch (Exception mex) {
            throw new Exception("Error al enviar correo:" + mex.getMessage());
        }
        return salida;
    }
}
