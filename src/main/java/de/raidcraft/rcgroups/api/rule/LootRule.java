package de.raidcraft.rcgroups.api.rule;

/**
 * Loot share rules.
 */
public enum LootRule {

    /**
     * Normal Minecraft loot rule.
     */
    NONE,

    /**
     * Free For All. Same as `NONE`.
     */
    FFA,

    /**
     * One person in the group, designated by the leader, loots all corpses.
     */
    MASTER,

    /**
     * A random person in the group, receives the loot.
     */
    RANDOM,

    /**
     * Group members take turns looting corpses.
     */
    ROUND
}
