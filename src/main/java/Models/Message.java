package Models;

import java.util.Date;

/**
 * Created by hiren on 29/6/16.
 */
public class Message extends CouchDBSchema {

    String From;
    String To;
    String Message;
    Date Created;

    public Message() {
        Created = new Date();
    }

    public Message(String from, String to, String message) {
        From = from;
        To = to;
        Message = message;
        Created = new Date();
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Date getCreated() {
        return Created;
    }

    public void setCreated(Date created) {
        Created = created;
    }
}
