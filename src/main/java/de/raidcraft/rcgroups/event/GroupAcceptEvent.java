package de.raidcraft.rcgroups.event;

import de.raidcraft.rcgroups.model.InviteRequest;
import de.raidcraft.rcgroups.type.Group;
import lombok.Getter;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * When a player accepts a group invite.
 */
public class GroupAcceptEvent extends Event implements GroupEvent, Cancellable {

    private static final HandlerList HANDLER = new HandlerList();

    @Getter
    private final InviteRequest inviteRequest;
    @Getter
    private final Group group;
    private boolean cancel;

    public GroupAcceptEvent(final InviteRequest inviteRequest, final Group group) {

        this.inviteRequest = inviteRequest;
        this.group = group;
        this.cancel = false;
    }

    public static HandlerList getHandlerList() {

        return HANDLER;
    }

    @Override
    public HandlerList getHandlers() {

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
}
