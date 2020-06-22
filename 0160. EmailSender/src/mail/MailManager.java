package mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.Security;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @author amirsam bahador
 * @version 3.0
 */
public class MailManager {
    /**
     * @param authenticator
     * @param content_type
     * @param message
     * @param subject
     * @param to
     * @param from
     * @param smtp_port_number
     * @param smtp_host_address
     * @return boolean
     * @throws Exception
     */
    public boolean sendMessage(String smtp_host_address, String smtp_port_number, String from, String[] to, String subject, String message, String content_type, Authenticator authenticator) throws Exception {

        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

        new MailManager().sendSSLMessage(to, subject,
                message, from, smtp_host_address, smtp_port_number, authenticator, content_type);
        return true;
    }

    private void sendSSLMessage(String recipients[], String subject,
                                String message, String from, String smtp_host_address, String smtp_port_number, Authenticator authenticator, String content_type) throws MessagingException {

        Properties props = new Properties();
        props.put("mail.smtp.host", smtp_host_address);
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "false");
        props.put("mail.smtp.port", smtp_port_number);
        props.put("mail.smtp.socketFactory.port", smtp_port_number);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");


        Session session = Session.getInstance(props, authenticator);
        Message msg = new MimeMessage(session);
        InternetAddress addressFrom = new InternetAddress(from);
        msg.setFrom(addressFrom);

        InternetAddress[] addressTo = new InternetAddress[recipients.length];
        for (int i = 0; i < recipients.length; i++) {
            addressTo[i] = new InternetAddress(recipients[i]);
        }
        msg.setRecipients(Message.RecipientType.TO, addressTo);
        msg.setSubject(subject);
        msg.setContent(message, content_type);
        Transport.send(msg);

    }

    /**
     * @param pop_server_name
     * @param full_email_address
     * @param email_password
     * @param box_name
     * @param id
     * @return boolean
     * @throws Exception
     */
    public boolean removeMessage(String pop_server_name, String full_email_address, String email_password, String box_name, int id) throws Exception {
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        Session session = Session.getInstance(props, null);
        Store store = session.getStore("imaps");
        store.connect(pop_server_name, full_email_address, email_password);
        Folder inbox = store.getFolder(box_name);
        inbox.open(Folder.READ_WRITE);
        javax.mail.Message messages[] = inbox.getMessages();
        messages[id - 1].setFlag(Flags.Flag.DELETED, true);
        inbox.close(true);
        store.close();
        return true;
    }

    /**
     * @param pop_server_name
     * @param full_email_address
     * @param email_password
     * @param box_name
     * @return ArrayList
     * @throws Exception
     */
    public ArrayList getMessages(String pop_server_name, String full_email_address, String email_password, String box_name) throws Exception {
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        Session session = Session.getInstance(props, null);
        Store store = session.getStore("imaps");
        store.connect(pop_server_name, full_email_address, email_password);
        Folder inbox = store.getFolder(box_name);
        inbox.open(Folder.READ_ONLY);
        javax.mail.Message messages[] = inbox.getMessages();
        ArrayList mymessages = new ArrayList();
        for (javax.mail.Message message : messages) {
            MessageRepository mymsg = new MessageRepository();
            mymsg.setSubject(message.getSubject());
            ArrayList sender = new ArrayList();
            int i = 0;
            while (message.getReplyTo().length != i) {
                sender.add(message.getReplyTo()[i]);
                i++;
            }
            mymsg.setSender(sender);
            ArrayList receiver = new ArrayList();
            i = 0;
            while (message.getAllRecipients().length != i) {
                receiver.add(message.getAllRecipients()[i]);
                i++;
            }
            mymsg.setReceiver(receiver);
            mymsg.setSentDate(message.getSentDate() + "");
            mymsg.setReceivedDate(message.getReceivedDate() + "");
            try {
                mymsg.setContent(((MimeMultipart) message.getContent()).getBodyPart(0).getContent() + "");
            } catch (Exception e) {
                mymsg.setContent(message.getContent() + "");
            }
            mymessages.add(mymsg);
        }
        inbox.close(true);
        store.close();
        return mymessages;
    }


}  