package de.raidcraft.rcgroups.type;

import de.raidcraft.rcgroups.GroupType;
import de.raidcraft.rcgroups.rule.ExpRule;
import de.raidcraft.rcgroups.rule.LootRule;
import org.bukkit.OfflinePlayer;

import java.util.Set;

/**
 * A small or large number of people.
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

    int getMaxSize();

    void setLootRule(LootRule lootRule);

    LootRule getLootRule();

    void setExpRule(ExpRule expRule);

    ExpRule getExpRule();

    GroupType getGroupType();
}
