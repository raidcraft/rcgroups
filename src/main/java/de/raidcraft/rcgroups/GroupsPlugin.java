package de.raidcraft.rcgroups;

import de.raidcraft.RaidCraft;
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

        // register ourself as a group component.
        RaidCraft.registerComponent(GroupsPlugin.class, this);

        // create the config
        this.config = configure(new Configuration(this));
    }

    @SuppressWarnings("AssignmentToNull")
    @Override
    public void disable() {

        RaidCraft.unregisterComponent(GroupsPlugin.class);

        this.config.save();
        this.config = null;
    }
}
