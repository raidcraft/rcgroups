package de.raidcraft.rcgroups.api;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 */
public class Repository<V> {

    public static final int DEFAULT_INITIAL_CAPACITY = 16;
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private final Map<UUID, V> collection;

    public Repository() {

        this(DEFAULT_INITIAL_CAPACITY);
    }

    public Repository(final int initialCapacity) {

        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    public Repository(final int initialCapacity, final float loadFactor) {

        this.collection = new HashMap<>(initialCapacity, loadFactor);
    }

    /**
     * Appends the specified item.
     *
     * @param item to append
     *
     * @return the assigned id
     */
    public UUID add(final V item) {

        UUID result = getId(item);

        if (result == null) {

            result = UUID.randomUUID();
            this.collection.put(result, item);
        }

        return result;
    }

    /**
     * Removes the specified item from this repository.
     *
     * @param item to be removed
     *
     * @return true
     */
    public boolean remove(final V item) {

        final UUID key = getId(item);
        return (key == null) || this.collection.remove(key, item);
    }

    /**
     * Removes the item mapped to the specified id from this repository.
     *
     * @param id whose mapped item is to be removed from this repository
     */
    public void remove(final UUID id) {

        this.collection.remove(id);
    }

    /**
     * Return true if this repository contains the specified item.
     *
     * @param item whose presence is in this repository is to be tested
     *
     * @return true if this repository contains the specified item
     */
    public boolean contains(final V item) {

        return this.collection.containsValue(item);
    }

    /**
     * Returns the item with the specified id.
     *
     * @param id of the item to return
     *
     * @return the item with the specified id
     */
    public V get(final UUID id) {

        return this.collection.get(id);
    }

    /**
     * Return the id of the specified item.
     *
     * @param item whose id to be returned
     *
     * @return the id of the specified item
     */
    public UUID getId(final V item) {

        UUID result = null;

        if (this.contains(item)) {
            for (final Map.Entry<UUID, V> entry : this.collection.entrySet()) {
                if (entry.equals(item)) {
                    result = entry.getKey();
                }
            }
        }

        return result;
    }

    /**
     * Returns a {@link Collection} view of the items contained in this repository.
     *
     * @return a collection view of the items contained in this repository
     */
    public Collection<V> items() {

        return this.collection.values();
    }

    /**
     * Returns a string representation of the object.
     * <p/>
     * Only for debugging
     */
    @Override
    public String toString() {

        final StringBuilder result = new StringBuilder();
        final String newLine = System.lineSeparator();

        result.append(this.getClass().getName()).append(" Object {").append(newLine);
        result.append(" collection = ").append(this.collection).append(newLine);
        result.append("}").append(newLine);

        return result.toString();
    }
}
