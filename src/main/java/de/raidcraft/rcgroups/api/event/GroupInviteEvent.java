package de.raidcraft.rcgroups.api.event;

import de.raidcraft.api.events.RCEvent;
import de.raidcraft.rcgroups.api.Group;
import de.raidcraft.rcgroups.api.InviteRequest;
import lombok.Getter;
import org.bukkit.event.Cancellable;

/**
 * Called when a player gets invited to a group.
 */
public class GroupInviteEvent extends RCEvent implements GroupEvent, Cancellable {

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

    @Override
    public boolean isCancelled() {

        return this.cancel;
    }

    @Override
    public void setCancelled(final boolean cancel) {

        this.cancel = cancel;
    }
}