package de.raidcraft.rcgroups.api.exception;

/**
 *
 */
public class GroupPlayerNotInGroupException extends GroupException {

    private static final long serialVersionUID = 7549999867559169493L;

    public GroupPlayerNotInGroupException() {

        super("Player not in group");
    }

    public GroupPlayerNotInGroupException(final String message) {

        super(message);
    }
}