package com.example.demo.booking;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail {
    private String pName;
    private String pMailAdresse;
    private String pStatus;

    final String username = "DS.WS.2021.2022@gmail.com";
    final String password = "SoftwareprojektFun#";

    public  void sendMail(){

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        System.out.println(pName);

        System.out.println(pMailAdresse);

        System.out.println(pStatus);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("DS.WS.2021.2022@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(pMailAdresse)
            );
            message.setSubject("Info DeskSharingApp");
            message.setText("Dear "+ pName+","
                    + "\n\n Der Status der Reservierung lautet: "+ pStatus);

            Transport.send(message);

            System.out.println("Mail send Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public Mail(String pName,String pMailAdresse,String pStatus) {
        this.pName=pName;
        this.pStatus=pStatus;
        this.pMailAdresse=pMailAdresse;
        //this.sendMail();
    }

    public Mail() {
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpMailAdresse() {
        return pMailAdresse;
    }

    public void setpMailAdresse(String pMailAdresse) {
        this.pMailAdresse = pMailAdresse;
    }

    public String getpStatus() {
        return pStatus;
    }

    public void setpStatus(String pStatus) {
        this.pStatus = pStatus;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "pName='" + pName + '\'' +
                ", pMailAdresse='" + pMailAdresse + '\'' +
                ", pStatus='" + pStatus + '\'' +
                '}';
    }
}
