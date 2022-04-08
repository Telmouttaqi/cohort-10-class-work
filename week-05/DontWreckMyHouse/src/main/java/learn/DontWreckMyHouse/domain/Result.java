package learn.DontWreckMyHouse.domain;

import java.util.ArrayList;

public class Result<T> extends Response {

    private ArrayList<String> messages = new ArrayList<>();

    private T payload;

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }


}