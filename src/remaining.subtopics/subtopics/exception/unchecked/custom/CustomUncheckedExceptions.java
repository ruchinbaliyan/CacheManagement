package remaining.subtopics.exception.unchecked.custom;

public class CustomUncheckedExceptions {

    public static void main(String[] args) {
        RegistrationService service = new RegistrationService();
        service.validateEmail("abc@gmail1.com");
    }
}
