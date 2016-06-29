package Controller;

import Enums.ResponseType;

/**
 * Created by hiren on 29/6/16.
 */
public class AppResponse<T> {

    ResponseType Status;
    T Data;

    public AppResponse(ResponseType status, T data) {
        Status = status;
        Data = data;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }

    public ResponseType getStatus() {
        return Status;
    }

    public void setStatus(ResponseType status) {
        Status = status;
    }

}
