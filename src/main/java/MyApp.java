import java.util.Date;

/**
 * Created by hiren on 29/6/16.
 */
public class MyApp {

    public static void main(String[] args) {
        System.out.println("App Started at : " + new Date());

        // Setup Spark Middleware
        SparkMiddleware.Setup();

        // Setup HTTP Routes.
        SparkMiddleware.SetupRoutes();

    }
}
