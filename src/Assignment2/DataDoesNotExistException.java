package Assignment2;

public class DataDoesNotExistException extends Exception{
    public DataDoesNotExistException(String errMsg) {
        super(errMsg);
    }
}
