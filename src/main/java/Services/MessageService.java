package Services;

import Models.Message;
import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;

import java.util.List;

/**
 * Created by hiren on 29/6/16.
 */
public class MessageService {

    CouchDbClient dbClient = null;

    public MessageService(CouchDbClient dbClient) {
        this.dbClient = dbClient;
    }

    public List<Message> getAllMessages() {
        List<Message> messages = dbClient.view("_all_docs").includeDocs(true).query(Message.class);
        return messages;
    }

    public Response addMessage(Message message) {
        //TODO: Validation
        Response response = dbClient.save(message);
        return response;
    }

    public Response updateMessage(Message message) {
        Response response = dbClient.update(message);
        return  response;
    }

    public Response deleteMessage(Message message) {
        return dbClient.remove(message);
    }

}
