import org.lightcouch.CouchDbClient;

/**
 * Created by hiren on 29/6/16.
 */
public class DB {
    private static CouchDbClient dbClient = null;

    public DB() {
        dbClient = new CouchDbClient("messages", true, "http", "127.0.0.1", 5984, null, null);
    }

    public static CouchDbClient getInstance() {
        if (dbClient == null) {
            new DB();
        }
        return dbClient;
    }
}
