package de.raidcraft.rcgroups;

import de.raidcraft.api.BasePlugin;
import de.raidcraft.rcgroups.api.model.Repository;
import de.raidcraft.rcgroups.api.entity.Group;
import lombok.Getter;

/**
 * The entry point for the Groups Plugin.
 */
public class GroupsPlugin extends BasePlugin {

    @Getter
    private Configuration config;
    @Getter
    private Repository<Group> groupRepository;

    @Override
    public void enable() {

        this.config = new Configuration(this);
        this.groupRepository = new Repository<>();

    }

    @SuppressWarnings("AssignmentToNull")
    @Override
    public void disable() {

        this.config.save();
        this.groupRepository = null;
    }
}
