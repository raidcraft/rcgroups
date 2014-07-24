package de.raidcraft.rcgroups.api.exception;

/**
 *
 */
public class GroupNameToLongException extends GroupException {

    private static final long serialVersionUID = -8689207787262654767L;

    public GroupNameToLongException() {

        super("Group name too long");
    }

    public GroupNameToLongException(final String message) {

        super(message);
    }
}