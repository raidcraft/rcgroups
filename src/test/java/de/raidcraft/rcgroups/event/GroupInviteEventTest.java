package de.raidcraft.rcgroups.event;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import de.raidcraft.rcgroups.api.Group;
import de.raidcraft.rcgroups.api.event.GroupInviteEvent;
import org.bukkit.entity.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 *
 */
@RunWith(PowerMockRunner.class)
public class GroupInviteEventTest {

    private Player mockPlayer;
    private Player mockInviter;
    private Group mockGroup;
    private GroupInviteEvent event;

    @Before
    public void setUp() {

        this.mockPlayer = mock(Player.class);
        this.mockInviter = mock(Player.class);
    }

    @After
    @SuppressWarnings("AssignmentToNull")
    public void tearDown() {

        this.mockPlayer = null;
        this.mockInviter = null;
        this.mockGroup = null;
    }

    @Test
    public void ShouldBe() {

        this.event = new GroupInviteEvent(this.mockPlayer, this.mockGroup, this.mockInviter);

        // DISPATCH

        // TEST
    }
}
