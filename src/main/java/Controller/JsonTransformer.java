package Controller;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * Created by hiren on 29/6/16.
 */
public class JsonTransformer implements ResponseTransformer {

    public String render(Object o) throws Exception {
        return new Gson().toJson(o);
    }
}