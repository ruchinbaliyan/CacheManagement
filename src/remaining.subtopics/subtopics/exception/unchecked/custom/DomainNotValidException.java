package remaining.subtopics.exception.unchecked.custom;

public class DomainNotValidException extends RuntimeException {

    public DomainNotValidException(String message) {
        super(message);
    }
}
