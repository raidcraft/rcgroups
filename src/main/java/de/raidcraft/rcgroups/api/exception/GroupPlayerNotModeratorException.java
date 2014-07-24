package de.raidcraft.rcgroups.api.exception;

/**
 *
 */
public class GroupPlayerNotModeratorException extends GroupException {

    private static final long serialVersionUID = 8199418111955411889L;

    public GroupPlayerNotModeratorException() {

        super("Player not group moderator");
    }

    public GroupPlayerNotModeratorException(final String message) {

        super(message);
    }
}
