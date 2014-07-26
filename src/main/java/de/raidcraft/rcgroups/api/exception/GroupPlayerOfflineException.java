package de.raidcraft.rcgroups.api.exception;

/**
 *
 */
public class GroupPlayerOfflineException extends GroupException {

    private static final long serialVersionUID = -1590774281694356673L;

    public GroupPlayerOfflineException() {

        super("Player is not online");
    }

    public GroupPlayerOfflineException(final String message) {

        super(message);
    }
}