package mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Amirsam
 * Date: 10/27/11
 * Time: 8:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class Amirsam {
    public static void main(String[] args) throws Exception {
        MailManager m = new MailManager();

        //
        m.sendMessage("smtp.gmail.com", "465", "anjoman.mathcs.aut@gmail.com",
                new String[]{"sajad.dadgar98@gmail.com"}, "sharif123", "hooo123<br/>test<p>haha</p><script>alert('salam')</script>", "text/html", new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("anjoman.mathcs.aut@gmail.com", "Sd0050550555");
                    }
                });
    }

    public static void main1(String[] args)throws Exception {
        MailManager m = new MailManager();
        m.removeMessage("pop.gmail.com","rezaeft123456@gmail.com","myjava123","inbox",1) ;

    }
       public static void main11(String[] args)throws Exception {
        MailManager m = new MailManager();
       ArrayList<MessageRepository> a = m.getMessages("pop.gmail.com","rezaeft123456@gmail.com","myjava123","inbox") ;
           for (MessageRepository messageRepository : a) {
               System.out.println(messageRepository.getContent());
               System.out.println(messageRepository.getReceivedDate());
               System.out.println(messageRepository.getSender());
               System.out.println(messageRepository.getSentDate());
               System.out.println(messageRepository.getSubject());
           }

    }
}
