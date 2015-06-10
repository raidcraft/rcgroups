package de.raidcraft.rcgroups.exception;

/**
 *
 */
public class GroupPlayerAlreadyInGroupException extends GroupException {

    private static final long serialVersionUID = -7373255210343507618L;

    public GroupPlayerAlreadyInGroupException() {

        super("Player is already in a group");
    }

    public GroupPlayerAlreadyInGroupException(final String message) {

        super(message);
    }
}
