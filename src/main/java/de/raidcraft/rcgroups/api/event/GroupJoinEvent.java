package de.raidcraft.rcgroups.api.event;

import de.raidcraft.rcgroups.api.entity.Group;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

/**
 * Called when a player joins a group.
 */
public class GroupJoinEvent extends PlayerEvent implements GroupEvent, Cancellable {

    private static final HandlerList HANDLER = new HandlerList();

    @Getter
    private final Group group;
    private boolean cancel;

    public GroupJoinEvent(final Player playerJoined, final Group groupJoined) {

        super(playerJoined);

        this.group = groupJoined;
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