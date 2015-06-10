package de.raidcraft.rcgroups.exception;

/**
 *
 */
public class GroupPlayerNotLeaderException extends GroupException {

    private static final long serialVersionUID = 7307013697144637838L;

    public GroupPlayerNotLeaderException() {

        super("Player not group leader");
    }

    public GroupPlayerNotLeaderException(final String message) {

        super(message);
    }
}
