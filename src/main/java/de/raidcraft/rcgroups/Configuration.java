package de.raidcraft.rcgroups;

import de.raidcraft.api.config.Comment;
import de.raidcraft.api.config.ConfigurationBase;
import de.raidcraft.api.config.Setting;

/**
 *
 */
public class Configuration extends ConfigurationBase<GroupsPlugin> {

    public static final String CONFIG_NAME = "config.yml";

    @Setting("size.max.party")
    @Comment("Maximum party size [0, Integer.MAX_VALUE]")
    public int maxPartySize = 5;

    @Setting("size.max.raid")
    @Comment("Maximum raid size [0, Integer.MAX_VALUE]")
    public int maxRaidSize = 10;

    @Setting("size.max.squad")
    @Comment("Maximum squad size [0, Integer.MAX_VALUE]")
    public int maxSquadSize = Integer.MAX_VALUE;

    public Configuration(final GroupsPlugin plugin) {

        super(plugin, CONFIG_NAME);
    }
}
