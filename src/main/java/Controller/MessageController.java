package Controller;

import Enums.ResponseType;
import Models.Message;
import Services.MessageService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;

import static spark.Spark.*;

/**
 * Created by hiren on 29/6/16.
 */

public class MessageController {

    public MessageController(final MessageService service) {

        /**
         * Get All Messages
         */
        get("/messages", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                try {
                    List<Message> messages = service.getAllMessages();
                    return new AppResponse<List<Message>>(ResponseType.success, messages);
                } catch (Exception e) {
                    return new AppResponse<Exception>(ResponseType.failure, e);
                }
            }
        }, new JsonTransformer());

        /**
         * Add New Message
         */
        post("/messages", new Route() {
            public Object handle(Request request, Response response) throws Exception {

                try {
                    Gson gson = new GsonBuilder().create();
                    Message message = gson.fromJson(request.body() , Message.class);

                    org.lightcouch.Response couchResponse = service.addMessage(message);
                    if (couchResponse.getError() == null) {
                        return new AppResponse<org.lightcouch.Response>(ResponseType.success, couchResponse);
                    } else {
                        return new AppResponse<String>(ResponseType.failure, couchResponse.getReason());
                    }

                } catch (Exception e) {
                    return new AppResponse<Exception>(ResponseType.failure, e);
                }
            }
        }, new JsonTransformer());

        put("/messages/:id", new Route() {

            public Object handle(Request request, Response response) throws Exception {
                try {
                    Gson gson = new GsonBuilder().create();
                    Message message = gson.fromJson(request.body() , Message.class);
                    message.set_id(request.params("id"));

                    org.lightcouch.Response couchResponse = service.updateMessage(message);

                    if (couchResponse.getError() == null) {
                        return new AppResponse<org.lightcouch.Response>(ResponseType.success, couchResponse);
                    } else {
                        return new AppResponse<String>(ResponseType.failure, couchResponse.getReason());
                    }

                } catch (Exception e) {
                    return new AppResponse<Exception>(ResponseType.failure, e);
                }
            }

        }, new JsonTransformer());

        delete("/messages/:id", new Route() {
            public Object handle(Request request, Response response) throws Exception {
                Gson gson = new GsonBuilder().create();
                Message message = gson.fromJson(request.body() , Message.class);
                message.set_id(request.params("id"));

                org.lightcouch.Response couchResponse = service.deleteMessage(message);

                try{
                    if (couchResponse.getError() == null) {
                        return new AppResponse<org.lightcouch.Response>(ResponseType.success, couchResponse);
                    } else {
                        return new AppResponse<String>(ResponseType.failure, couchResponse.getReason());
                    }
                } catch (Exception e) {
                    return new AppResponse<Exception>(ResponseType.failure, e);
                }

            }
        }, new JsonTransformer());
    }
}
