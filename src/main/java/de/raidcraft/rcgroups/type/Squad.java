package de.raidcraft.rcgroups.type;

import org.bukkit.ChatColor;

/**
 * Represents a group with colors and names.
 */
public interface Squad extends Group {

    void setName();

    String getName();

    String getPrefix();

    void setPrefix(String prefix);

    boolean hasPrefix();

    ChatColor getColor();

    void setColor(ChatColor color);

    boolean canSeeFriendlyInvisibles();

    void setCanSeeFriendlyInvisibles(boolean enabled);
}
