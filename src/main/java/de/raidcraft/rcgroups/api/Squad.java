package de.raidcraft.rcgroups.api;

import org.bukkit.ChatColor;

/**
 * Represents a group with colors and names.
 */
public interface Squad extends Group {

    String getName();

    String getPrefix();

    void setPrefix(String prefix);

    ChatColor getColor();

    void setColor(ChatColor color);

}
