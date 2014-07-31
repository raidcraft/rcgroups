package de.raidcraft.rcgroups;

import de.raidcraft.api.BasePlugin;
import de.raidcraft.rcgroups.api.Repository;
import de.raidcraft.rcgroups.api.entity.Group;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;

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
