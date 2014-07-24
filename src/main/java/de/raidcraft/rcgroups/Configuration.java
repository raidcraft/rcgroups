package de.raidcraft.rcgroups;

import de.raidcraft.api.config.ConfigurationBase;

/**
 *
 */
public class Configuration extends ConfigurationBase<GroupPlugin> {


    public Configuration(final GroupPlugin plugin) {

        super(plugin, "config.yml");
    }
}
