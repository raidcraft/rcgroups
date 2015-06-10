package de.raidcraft.rcgroups.exception;

/**
 *
 */
public class GroupException extends Exception {

    private static final long serialVersionUID = 1121987037712622323L;

    public GroupException() {

        super("Group exception");
    }

    public GroupException(final String message) {

        super(message);
    }
}
