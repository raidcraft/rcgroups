package de.raidcraft.rcgroups.api.entity;

import de.raidcraft.rcgroups.api.rule.ExpRule;
import de.raidcraft.rcgroups.api.rule.LootRule;
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

    void setLeader(OfflinePlayer player);

    OfflinePlayer getLeader();

    boolean isLeader(OfflinePlayer player);

    void setModerator(OfflinePlayer player);

    boolean isModerator(OfflinePlayer player);

    Set<OfflinePlayer> getModerators();

    int getSize();

    void setLootRule(LootRule lootRule);

    void setExpRule(ExpRule expRule);

    LootRule getLootRule();

    ExpRule getExpRule();
}
