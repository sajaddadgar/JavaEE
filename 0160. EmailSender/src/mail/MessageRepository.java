package mail;

import java.util.ArrayList;

/**
 * @author amirsam bahador
 * @version 3.0
 */
public class MessageRepository {
    private String subject;
    private String content;

    /**
     * @return String
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject
     * @return void
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return String
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     * @return void
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return ArrayList
     */
    public ArrayList getSender() {
        return sender;
    }

    /**
     * @param sender
     * @return void
     */
    public void setSender(ArrayList sender) {
        this.sender = sender;
    }

    /**
     * @return String
     */
    public String getSentDate() {
        return sentDate;
    }

    /**
     * @param sentDate
     * @return void
     */
    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    /**
     * @return String
     */
    public String getReceivedDate() {
        return receivedDate;
    }

    /**
     * @param receivedDate
     * @return void
     */
    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    /**
     * @return ArrayList
     */
    public ArrayList getReceiver() {
        return receiver;
    }

    /**
     * @param receiver
     * @return void
     */
    public void setReceiver(ArrayList receiver) {
        this.receiver = receiver;
    }

    private ArrayList sender;
    private String sentDate;
    private String receivedDate;
    private ArrayList receiver;


}
