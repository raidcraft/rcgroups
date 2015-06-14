package de.raidcraft.rcgroups.util;

import com.google.common.collect.BiMap;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.HashBiMap;

import java.util.Collection;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Each element of which is assigned an unique ID in the set.
 */
@SuppressWarnings("NullableProblems")
public class IndexedSet<E> extends ForwardingSet<E> {

    public static final int INVALID_ID = -1;

    private final IdPool idPool;
    private final BiMap<Integer, E> toValueMap;
    private final Set<E> delegate;

    public IndexedSet(final int expectedSize) {

        this.idPool = new IdPool(expectedSize);
        this.toValueMap = HashBiMap.create(expectedSize);
        this.delegate = toValueMap.inverse().keySet();
    }

    /**
     * Adds the specified <code>element</code> to this set if possible and
     * returns the associated id.
     *
     * @return The id the added <code>element</code> is mapped to.
     */

    public int set(final E element) {

        checkNotNull(element);

        int id = getId(element);

        if(id == INVALID_ID) {
            id = idPool.pop();
            toValueMap.put(id, element);
        }

        return id;
    }

    /**
     * Adds the specified <code>element</code> associated with a new id to this
     * set if possible.
     *
     * @return false if <code>element</code> already exists.
     */

    @Override
    public boolean add(final E element) {

        checkNotNull(element);

        return !toValueMap.containsValue(element)
                && (toValueMap.put(idPool.pop(), element) == null);
    }

    @Override
    public boolean addAll(final Collection<? extends E> collection) {

        return standardAddAll(collection);
    }

    /**
     * Returns the backing delegate instance that methods are forwarded to.
     */

    @Override
    protected Set<E> delegate() {

        return delegate;
    }

    /**
     * Returns the element mapped to <code>id</code>, or null is no
     * corresponding element is found in the set.
     */

    public E get(final int id) {

        return toValueMap.get(id);
    }

    /**
     * Returns the id that is mapped to <code>element</code>, or
     * {@link #INVALID_ID} is no corresponding element found in the set.
     */

    public int getId(final E element) {

        return toValueMap.containsValue(element)
                ? toValueMap.inverse().get(element)
                : INVALID_ID;
    }
}
