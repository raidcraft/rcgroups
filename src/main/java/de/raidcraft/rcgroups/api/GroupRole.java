package de.raidcraft.rcgroups.api;

/**
 * The role of a player in a Group.
 */
public enum GroupRole {

    /**
     * The leader of the group can invite members to the group, uninvite
     * current members to remove them from the group, or promote another
     * group member to be leader.
     */
    LEADER,

    /**
     * Same as a leader, but can not remove a leader from the group and
     * can not promote another group member to be leader.
     */
    MODERATOR,

    /**
     * Just a peasant.
     */
    MEMBER
}
