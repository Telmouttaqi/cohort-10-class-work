package learn.solar.data;

public class DataException extends Throwable {

    public DataException(String message, Throwable rootCause){

        super(message, rootCause);
    }

}
