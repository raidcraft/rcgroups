package de.raidcraft.rcgroups.api.event;

import de.raidcraft.api.events.RCPlayerEvent;
import de.raidcraft.rcgroups.api.Group;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

/**
 * Called when a player joins a group.
 */
public class GroupJoinEvent extends RCPlayerEvent implements GroupEvent, Cancellable {

    @Getter
    private final Group group;
    private boolean cancel;

    public GroupJoinEvent(final Player playerJoined, final Group groupJoined) {

        super(playerJoined);

        this.group = groupJoined;
        this.cancel = false;
    }

    @Override
    public boolean isCancelled() {

        return this.cancel;
    }

    @Override
    public void setCancelled(final boolean cancel) {

        this.cancel = cancel;
    }
}