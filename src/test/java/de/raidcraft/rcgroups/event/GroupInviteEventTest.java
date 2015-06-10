package de.raidcraft.rcgroups.event;

import de.raidcraft.rcgroups.type.Group;
import org.bukkit.entity.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.mock;

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
    public void shouldBe() {

        // DISPATCH

        // TEST
    }
}
