package app.project.shared.exceptions;

public class ForeignKeyException extends RuntimeException {

    public ForeignKeyException(Class<?> entityClass, Long idEntity, Class<?> foreignEntityClass, Long foreignIdEntity) {
        super("There is another " + foreignEntityClass.getSimpleName() + " with ID: " + foreignIdEntity
                + ". New Teacher should have distinct " + foreignEntityClass.getSimpleName());
    }
}
