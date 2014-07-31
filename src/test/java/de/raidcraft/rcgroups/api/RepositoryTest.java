package de.raidcraft.rcgroups.api;

import de.raidcraft.rcgroups.api.entity.Group;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class RepositoryTest {

    private Repository<Group> groupRepository;

    @Before
    public void setUp() {

        this.groupRepository = new Repository<>();
    }

    @After
    @SuppressWarnings("AssignmentToNull")
    public void tearDown() {

    }

    @Test
    public void shouldBeItemExists() {

    }

    @Test
    public void shouldBeItemNotExists() {

    }

    @Test
    public void shouldBeContainItem() {

    }

    @Test
    public void shouldBeReturnItem() {

    }

    @Test
    public void shouldBeReturnMappedId() {

    }

    @Test
    public void shouldBeReturnCollectionOfItems() {

    }
}
