package de.raidcraft.rcgroups.command;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Command to invite other players to a group.
 */
public class InviteCommand {

    @Command(
            aliases = {"invite", "i"},
            desc = "Invites the given member to the group.",
            usage = "[player] - The player to invite to the group.",
            min = 1,
            max = 1
    )
    public void onCommand(final CommandContext context, final CommandSender sender) throws CommandException {

        // TODO(denis): Check if invitee is a leader or moderator.

        String playerName = context.getString(0);
        Player player = Bukkit.getPlayer(playerName);

        if(player == null)
        {
            throw new CommandException("Player " + playerName + " not found!");
        }

        // TODO(denis): Check if player already in a group.
    }
}
