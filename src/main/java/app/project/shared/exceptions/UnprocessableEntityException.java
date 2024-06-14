package app.project.shared.exceptions;

public class UnprocessableEntityException extends RuntimeException {

    public UnprocessableEntityException(Class<?> entityClass) {
        super("Invalid data from " + entityClass.getSimpleName());
    }

    public UnprocessableEntityException(String msgError) {
        super(msgError);
    }
}
