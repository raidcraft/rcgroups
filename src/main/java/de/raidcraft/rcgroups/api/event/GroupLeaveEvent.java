package de.raidcraft.rcgroups.api.event;

import de.raidcraft.api.events.RCPlayerEvent;
import de.raidcraft.rcgroups.api.Group;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

/**
 * Called when a player leaves a group.
 */
public class GroupLeaveEvent extends RCPlayerEvent implements GroupEvent, Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();
    @Getter
    private final Group group;
    private boolean cancel;

    public GroupLeaveEvent(final Player who, final Group groupLeaved) {

        super(who);

        this.group = groupLeaved;
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