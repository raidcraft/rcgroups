package de.raidcraft.rcgroups.event;

import de.raidcraft.rcgroups.type.Group;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

/**
 * Called when a player leaves a group.
 */
public class GroupLeaveEvent extends PlayerEvent implements GroupEvent, Cancellable {

    private static final HandlerList HANDLER = new HandlerList();
    @Getter
    private final Group group;
    private boolean cancel;

    public GroupLeaveEvent(final Player who, final Group groupLeaved) {

        super(who);

        this.group = groupLeaved;
        this.cancel = false;
    }

    public static HandlerList getHandlerList() {

        return HANDLER;
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

        return HANDLER;
    }
}
