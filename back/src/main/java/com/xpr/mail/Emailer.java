package com.xpr.mail;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@PropertySource("classpath:application.properties")
public class Emailer {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Emailer.class);

    @Value("${spring.mail.properties.mail.smtp.auth:}")
    private String smtpAuth;

    @Value("${spring.mail.properties.mail.smtp.starttls.enable:}")
    private String smtpStartTLS;

    @Value("${spring.mail.host:}")
    private String smtpHost;

    @Value("${spring.mail.port:0}")
    private int smtpPort;

    @Value("${spring.mail.username:}")
    private String smtpUser;

    @Value("${spring.mail.sender:}")
    private String sender;

    @Value("${spring.mail.password:}")
    private String smtpPassword;

    @Value("${spring.mail.debug:}")
    private String debug;

    @Value("${mail.smtp.auth.mechanisms:}")
    private String authMechanisms;

    @Value("${mail.smtp.auth.xoauth2.disable:}")
    private String xoauth2Disable;

    @Value("${mail.smtp.ehlo:}")
    private String smtpEhlo;


    private Session session = null;
    private ExecutorService executorService;

    @PostConstruct
    private void initSession(){
        try{
            Properties props = new Properties();
            props.put("mail.smtp.auth", smtpAuth);
            props.put("mail.smtp.starttls.enable", smtpStartTLS);
            props.put("mail.smtp.host", smtpHost);
            props.put("mail.smtp.port", smtpPort);
            props.put("mail.smtp.ssl.trust", smtpHost);
            props.put("mail.protocol.user", smtpUser);
            props.put("mail.debug", debug);
            props.put("mail.smtp.auth.mechanisms", authMechanisms);
            props.put("mail.smtp.auth.xoauth2.disable", xoauth2Disable);
            props.put("mail.smtp.ehlo", smtpEhlo);
            session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(smtpUser, smtpPassword);
                }
            });
            executorService = Executors.newFixedThreadPool(10);
        }
        catch (Exception e){
            session = null;
            logger.error(e.getMessage(), e);
        }
    }

    public void sendEmail(String recipients, String subject, String content){
        sendEmail(sender, recipients, subject, content, null, null, null);
    }

    public void sendEmail(String recipients, String subject, String content, List<String> attachments, String cc){
        sendEmail(sender, recipients, subject, content, attachments, cc, null);
    }

    public void sendEmail(String recipients, String subject, String content, List<String> attachments, String cc, String bcc){
        sendEmail(sender, recipients, subject, content, attachments, cc, bcc);
    }

    public void sendEmail(String sender, String recipients, String subject, String content){
        sendEmail(sender, recipients, subject, content, null, null, null);
    }

    public void sendEmail(String sender, String recipients, String subject, String content, List<String> attachments, String cc, String bcc){
        executorService.execute(new Runnable() {
            public void run() {
                _sendEmail(sender, recipients, subject, content, attachments, cc, bcc);
            }
        });
    }

    private void _sendEmail(String sender, String recipients, String subject, String content, List<String> attachments, String cc, String bcc){
        try{
            if(session==null)
                initSession();
            // System.out.println(" ==> sender: " + sender);
            // System.out.println(" ==> recipients: " + recipients);
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(sender, false));
            recipients = recipients.replace(";", ",");
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
            if(cc!=null) {
                cc = cc.replace(";", ",");
                msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
            }
            if(bcc!=null) {
                bcc = bcc.replace(";", ",");
                msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bcc));
            }
            msg.setSubject(subject);
            msg.setContent(content, "text/html; charset=UTF-8");
            msg.setSentDate(new Date());
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(content, "text/html; charset=UTF-8");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            MimeBodyPart attachPart = new MimeBodyPart();
            if(attachments!=null) {
                for(String attachment : attachments) {
                    attachPart.attachFile(attachment);
                    multipart.addBodyPart(attachPart);
                }
            }
            msg.setContent(multipart);
            Transport.send(msg);
        }
        catch (Exception e){
            logger.error(e.getMessage(), e);
        }
    }

}
