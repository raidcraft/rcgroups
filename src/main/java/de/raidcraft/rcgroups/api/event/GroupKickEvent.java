package de.raidcraft.rcgroups.api.event;

import de.raidcraft.api.events.RCPlayerEvent;
import de.raidcraft.rcgroups.api.Group;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

/**
 * Called when a player gets kicked from a group.
 */
public class GroupKickEvent extends RCPlayerEvent implements GroupEvent, Cancellable {

    @Getter
    private final CommandSender executor;
    @Getter
    private final Group group;
    private boolean cancel;

    public GroupKickEvent(final Player playerKicked, final Group fromGroup, final CommandSender executor) {

        super(playerKicked);

        this.group = fromGroup;
        this.executor = executor;
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