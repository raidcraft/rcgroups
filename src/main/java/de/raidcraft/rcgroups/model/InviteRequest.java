package de.raidcraft.rcgroups.model;

import lombok.Value;
import org.bukkit.entity.Player;

/**
 *
 */
@Value
public class InviteRequest {

    private final Player invitee;
    private final Player inviter;
    private final Long timestamp;

    public InviteRequest(final Player invitee, final Player inviter) {

        this.invitee = invitee;
        this.inviter = inviter;
        this.timestamp = System.currentTimeMillis();
    }

    public InviteRequest(final Player invitee, final Player inviter, final long timestamp) {

        this.invitee = invitee;
        this.inviter = inviter;
        this.timestamp = timestamp;
    }
}
