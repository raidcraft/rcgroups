package de.raidcraft.rcgroups.api.rule;

/**
 * Experience share rule.
 */
public enum ExpRule {

    /**
     * Normal Minecraft rule.
     */
    NONE,

    /**
     * Shares experience evenly between all group members.
     */
    EVEN,

    /**
     * Free For All. Same as `NONE`.
     */
    FFA,

    /**
     * All experience goes to one player.
     */
    MASTER,

    /**
     * Shares experience with a random group member.
     */
    RANDOM,

    /**
     * Group members take experience turns.
     */
    ROUND
}
