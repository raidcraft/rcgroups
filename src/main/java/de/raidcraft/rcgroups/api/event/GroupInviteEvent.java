package de.raidcraft.rcgroups.api.event;

import de.raidcraft.rcgroups.api.entity.Group;
import de.raidcraft.rcgroups.api.InviteRequest;
import lombok.Getter;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Called when a player gets invited to a group.
 */
public class GroupInviteEvent extends Event implements GroupEvent, Cancellable {

    private static final HandlerList HANDLER = new HandlerList();

    @Getter
    private final InviteRequest inviteRequest;
    @Getter
    private final Group group;
    private boolean cancel;

    public GroupInviteEvent(final InviteRequest inviteRequest, final Group group) {

        this.inviteRequest = inviteRequest;
        this.group = group;
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