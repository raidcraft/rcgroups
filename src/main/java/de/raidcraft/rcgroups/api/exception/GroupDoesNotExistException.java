package de.raidcraft.rcgroups.api.exception;

/**
 *
 */
public class GroupDoesNotExistException extends GroupException {

    private static final long serialVersionUID = 1567902878054013008L;

    public GroupDoesNotExistException() {

        super("Group does not exist");
    }

    public GroupDoesNotExistException(final String message) {

        super(message);
    }
}
