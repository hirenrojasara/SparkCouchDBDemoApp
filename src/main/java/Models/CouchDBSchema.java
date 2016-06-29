package Models;

/**
 * Parent Class For ALL CouchDB Models
 *
 * Created by hiren on 29/6/16.
 */
public class CouchDBSchema {
    String _id;
    String _rev;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_rev() {
        return _rev;
    }

    public void set_rev(String _rev) {
        this._rev = _rev;
    }


}
