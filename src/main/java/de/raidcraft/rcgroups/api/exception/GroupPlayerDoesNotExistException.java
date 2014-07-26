package de.raidcraft.rcgroups.api.exception;

/**
 *
 */
public class GroupPlayerDoesNotExistException extends GroupException {

    private static final long serialVersionUID = 1899697980504040794L;

    public GroupPlayerDoesNotExistException() {

        super("Player does not exist");
    }

    public GroupPlayerDoesNotExistException(final String message) {

        super(message);
    }
}