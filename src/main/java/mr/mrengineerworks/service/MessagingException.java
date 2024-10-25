package mr.mrengineerworks.service;

public class MessagingException {
// Custom Exception Class
public class EmailSendException extends RuntimeException {
    public EmailSendException(String message, Throwable cause) {
        super(message, cause);
    }
}

}
