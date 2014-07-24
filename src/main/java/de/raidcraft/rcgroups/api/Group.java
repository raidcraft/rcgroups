package de.raidcraft.rcgroups.api;

import org.bukkit.OfflinePlayer;

import java.util.Set;

/**
 *
 */
public interface Group {

    void addPlayer(OfflinePlayer player);

    boolean removePlayer(OfflinePlayer player);

    boolean hasPlayer(OfflinePlayer player);

    Set<OfflinePlayer> getPlayers();

    int getSize();
}
