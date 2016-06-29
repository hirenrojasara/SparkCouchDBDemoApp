import Controller.MessageController;
import Services.MessageService;
import org.lightcouch.CouchDbClient;
import spark.Filter;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

/**
 * Created by hiren on 29/6/16.
 */
public class SparkMiddleware {

    public static void Setup() {

        // Listen Port
        port(9090);

        // HOOK which will run before request handled
        before(new Filter() {
            public void handle(Request request, Response response) throws Exception {
                System.out.println("Middleware Called - BEFORE");
            }
        });

        // HOOK which will run after request handled and before sent to Client
        after(new Filter() {
            public void handle(Request request, Response response) throws Exception {
                response.type("application/json");
                System.out.println("Middleware Called - AFTER");
            }
        });
    }

    public static void SetupRoutes() {

        CouchDbClient dbClient = DB.getInstance();

        new MessageController(new MessageService(dbClient));

    }
}
