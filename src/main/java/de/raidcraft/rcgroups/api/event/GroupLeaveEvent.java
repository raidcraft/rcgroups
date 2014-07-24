package de.raidcraft.rcgroups.api.event;

import de.raidcraft.rcgroups.api.Group;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

/**
 * Called when a player leaves a group.
 */
public class GroupLeaveEvent extends PlayerEvent implements GroupEvent, Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();
    private boolean cancel;
    @Getter
    private Group group;

    public GroupLeaveEvent(final Player who, final Group groupLeaved) {

        super(who);

        this.group = groupLeaved;
    }

    public static HandlerList getHandlerList() {

        return HANDLERS;
    }

    @Override
    public boolean isCancelled() {

        return this.cancel;
    }

    @Override
    public void setCancelled(final boolean cancel) {

        this.cancel = cancel;
    }

    @Override
    public HandlerList getHandlers() {

        return HANDLERS;
    }
}
