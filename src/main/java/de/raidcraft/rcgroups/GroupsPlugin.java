package de.raidcraft.rcgroups;

import de.raidcraft.api.BasePlugin;
import lombok.Getter;

/**
 * The entry point for the Groups Plugin.
 */
public class GroupsPlugin extends BasePlugin {

    @Getter
    private Configuration config;

    @Override
    public void enable() {

        this.config = new Configuration(this);

    }

    @Override
    public void disable() {

        this.config.save();
    }
}
