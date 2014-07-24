package de.raidcraft.rcgroups.api.exception;

/**
 *
 */
public class GroupNameAlreadyInUseException extends GroupException {

    private static final long serialVersionUID = -5151921563086497334L;

    public GroupNameAlreadyInUseException() {

        super("Group name already in use");
    }

    public GroupNameAlreadyInUseException(final String message) {

        super(message);
    }
}
