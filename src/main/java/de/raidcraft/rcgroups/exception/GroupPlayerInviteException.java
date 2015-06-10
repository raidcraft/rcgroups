package de.raidcraft.rcgroups.exception;

/**
 *
 */
public class GroupPlayerInviteException extends GroupException {

    private static final long serialVersionUID = 8242525092714083869L;

    public GroupPlayerInviteException() {

        super("Player cannot be invited");
    }

    public GroupPlayerInviteException(final String message) {

        super(message);
    }
}
