package de.raidcraft.rcgroups.api.event;

import de.raidcraft.rcgroups.api.Group;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

/**
 * Called when a player gets invited to a group.
 */
public class GroupInviteEvent extends PlayerEvent implements GroupEvent, Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();
    private boolean cancel;
    @Getter
    private Player inviter;
    @Getter
    private Group group;

    public GroupInviteEvent(final Player who, final Group group, final Player inviter) {

        super(who);

        this.group = group;
        this.inviter = inviter;
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
