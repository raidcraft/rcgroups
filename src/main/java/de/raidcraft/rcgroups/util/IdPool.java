package de.raidcraft.rcgroups.util;

import java.util.Arrays;

/**
 * A utility class that returns indices (consecutive number of integers
 * starting at zero) through a {@link #pop()} method.
 * <p/>
 * Once an index is done being used it is passed to {@link #put(int)} so it
 * can be recycled and reused the next time {@link #pop()} is called.
 * <p/>
 * When the last index {@link #pop()}'d is {@link #put(int)}'d is caused the
 * pool to shrink by removing all previous consecutive indices from the
 * recycled index list and updated the maximum index that can be returned
 * (accessible via {@link #maxActiveIndex()}). This keeps the range of indices
 * returnable as small as possible. If an object with a large index holds onto
 * to it for a long time it will never be released and there could be a waste
 * of space. It's best to {@link #pop()} indices for long lived objects first
 * and then short lived objects last.
 */
public class IdPool {

    public static final int MIN_CAPACITY = 16;

    private int[] indices;
    private int size;
    private int previousIndex;

    /**
     * Instantiates a new IdPool.
     */

    public IdPool() {

        this(MIN_CAPACITY);
    }

    /**
     * Instantiates a new IdPool with a given capacity.
     *
     * @param capacity The initial number of indices to store for reuse before
     *                 te array used to store recycled indices need to be
     *                 resized.
     */

    public IdPool(final int capacity) {

        this.indices = new int[capacity];

        clear();
    }

    /**
     * Clears the IdPool of all indices and resets the next index to 0.
     */

    public void clear() {

        size = 0;
        previousIndex = -1;
    }

    /**
     * The number of recycled indices available to be returned from
     * {@link #pop()} before new indices need to be generated.
     *
     * @return The size of the pool.
     */

    public int size() {

        return size;
    }

    /**
     * The current capacity of the pool of recycled indices. The pool expands
     * and shrinks as indices are {@link #pop()}'d and {@link #put(int)}'d.
     *
     * @return The current capacity of the pool.
     */

    public int capacity() {

        return indices.length;
    }

    /**
     * The maximum active index this pool has returned from {@link #pop()}.
     * <p/>
     * An index is not active when it has been {@link #put(int)}'d onto the
     * pool. The maximum active index can shrink when it's {@link #put(int)}
     * onto the pool
     *
     * @return The maximum active index.
     */

    public int maxActiveIndex() {

        return previousIndex;
    }

    /**
     * Retrieves an index from the pool. If a reusable index is stored in the
     * pool, it is used. Otherwise a new index is created.
     *
     * @return A new index that is not currently in use.
     */

    public int pop() {

        return (size == 0) ? ++previousIndex : indices[--size];
    }

    /**
     * Puts the <code>index</code> back into the pool.
     * <p/>
     * Every {@link #pop()}'d index needs to be {@link #put(int)}'d back once
     * it's done being used.
     *
     * @param index The index to put back into the pool.
     *
     * @return True if the pool has shrunk and reusable indices have been
     * removed from the pool to keep the values returned by {@link #pop()} at
     * their smallest possible values, otherwise false.
     */

    public boolean put(final int index) {

        // Last index popped?
        final boolean result = index == previousIndex;

        if (result) {
            //  Try shrinking the pool.
            shrink();
        } else {
            // Increase backing pool by 50% if it's full.
            if (size == indices.length) {
                indices = Arrays.copyOf(indices, size + (size >> 1));
            }

            indices[size++] = index;
        }

        return result;
    }

    /**
     * Invoked when {@link #put(int)} is called on the last {@link #pop()}'d
     * index. This will traverse through the stack of indices and remove the
     * largest descending consecutive sequence of indices starting with the
     * last index. If it's shrunk such that 75% of the stack is empty, the
     * capacity of the stack is decreased by 25%.
     */

    private void shrink() {

        final int largestIndex = previousIndex - 1;
        int lastIndex = largestIndex;
        int removeAt = size;

        while (removeAt != -1) {
            // Find the index of lastIndex in the pool (or -1 if not found).
            while ((--removeAt >= 0) && (indices[removeAt] != lastIndex)) {
                // no body operation
            }

            // If lastIndex was found in the pool..
            if (removeAt != -1) {

                // Mark it for removal.
                indices[removeAt] = -1;

                // Find the previous index.
                lastIndex--;
                removeAt = size;

                // All indices have been popped off the stack.
                if (lastIndex == -1) {
                    break;
                }
            }
        }

        // If any additional indices have been popped off the stack..
        if (lastIndex != largestIndex) {

            int indicesAlive = 0;

            // Overwrite all indices that are marked for removal (-1)
            for (int i = 0; i < size; i++) {
                if (indices[i] != -1) {
                    indices[indicesAlive++] = indices[i];
                }
            }

            // Reset size to new size.
            size = indicesAlive;

            // Shrink backing array by 25% if 75% is free.
            final int stackSurplus = indices.length >> 2;
            final int newStackSize = indices.length - stackSurplus;

            if ((stackSurplus >= size) && (newStackSize < MIN_CAPACITY)) {
                indices = Arrays.copyOf(indices, newStackSize);
            }
        }

        previousIndex = lastIndex;
    }
}
