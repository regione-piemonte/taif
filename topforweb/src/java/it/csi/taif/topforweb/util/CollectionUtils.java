/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.util;



import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

import static it.csi.taif.topforweb.util.guava.common.base.Preconditions.checkArgument;
import static it.csi.taif.topforweb.util.guava.common.base.Preconditions.checkElementIndex;
import static it.csi.taif.topforweb.util.guava.common.base.Preconditions.checkNotNull;
import static it.csi.taif.topforweb.util.guava.common.base.Preconditions.checkState;

import it.csi.taif.topforweb.util.guava.common.base.Function;
import it.csi.taif.topforweb.util.guava.common.base.Predicate;
import it.csi.taif.topforweb.util.guava.common.collect.PeekingIterator;

/**
 * Classe di utilit&agrave; per l'utilizzo e la gestione delle <code>Collections</code>.
 *
 * @author 71781 (Luca Davico)
 * @author 71740 (Simone Cornacchia)
 */
public final class CollectionUtils {
	

    /**
     *
     * @param values
     * @return
     */
    public static <T> boolean isEmpty(Collection<T> values) {
        return org.apache.commons.collections.CollectionUtils.isEmpty(values);
    }

    /**
     *
     * @param values
     * @return
     */
    public static <T> boolean isNotEmpty(Collection<T> values) {
        return org.apache.commons.collections.CollectionUtils.isNotEmpty(values);
    }

    /**
     *
     * @param values
     * @return
     */
    public static <T> T getFirst(List<T> values) {
        if (isEmpty(values)) {
            return null;
        }

        return values.get(0);
    }

    /**
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> Iterator<T> emptyIterator() {
        return (Iterator<T>) EmptyIterator.EMPTY_ITERATOR;
    }

    /**
     *
     * @see http://www.php.net/manual/en/function.array-combine.php
     * @see http://forums.sun.com/thread.jspa?threadID=5290363
     * @param <K>
     * @param <V>
     * @param keys
     * @param values
     * @return
     */
    public static <K, V> Map<K, V> combine(Collection<K> keys, Collection<V> values) {
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException("For two Collections to be combined into a Map, they must return the same value from size() invokation. (keys.size: " + keys.size() + ", values.size: " + values.size() + ")");
        }

        if (keys.isEmpty() || values.isEmpty()) {
            throw new IllegalArgumentException("For two Collections to be combined into a Map, they must each contain at least one element.");
        }

        final Map<K, V> tmp = new LinkedHashMap<K, V>();
        final Iterator<K> ki = keys.iterator();
        final Iterator<V> vi = values.iterator();
        while (ki.hasNext()) {
            tmp.put(ki.next(), vi.next());
        }

        return tmp;
    }

    /**
     * Selects all elements from input collection which match the given predicate
     * into an output collection.
     * <p>
     * A <code>null</code> predicate matches no elements.
     *
     * @param inputCollection  the collection to get the input from, may not be null
     * @param predicate  the predicate to use, may be null
     * @return the elements matching the predicate (new list)
     * @throws NullPointerException if the input collection is null
     */
    public static <E> Collection<E> select(Collection<E> inputCollection, Predicate<? super E> predicate) {
        final List<E> answer = new ArrayList<E>(inputCollection.size());

        select(inputCollection, predicate, answer);

        return answer;
    }

    /**
     * Selects all elements from input collection which match the given predicate
     * and adds them to outputCollection.
     * <p>
     * If the input collection or predicate is null, there is no change to the
     * output collection.
     *
     * @param inputCollection  the collection to get the input from, may be null
     * @param predicate  the predicate to use, may be null
     * @param outputCollection  the collection to output into, may not be null
     */
    public static <E> void select(Collection<E> inputCollection, Predicate<? super E> predicate, Collection<E> outputCollection) {
        if (inputCollection != null && predicate != null) {
            for (final Iterator<E> iter = inputCollection.iterator(); iter.hasNext();) {
                final E item = iter.next();
                if (predicate.apply(item)) {
                    outputCollection.add(item);
                }
            }
        }
    }

    /**
     *
     * @param <E>
     * @param iterable
     * @param predicate
     */
    public static <E> void filter(Iterable<E> iterable, Predicate<? super E> predicate) {
        if (iterable != null && predicate != null) {
            for (final Iterator<E> it = iterable.iterator(); it.hasNext();) {
                if (! predicate.apply(it.next())) {
                    it.remove();
                }
            }
        }
    }

    /**
     * Returns a new Collection consisting of the elements of inputCollection
     * transformed by the given transformer.
     * <p>
     * If the input transformer is null, the result is an empty list.
     *
     * @param <I>
     * @param <O>
     * @param inputCollection  the collection to get the input from, may not be null
     * @param transformer  the transformer to use, may be null
     * @return the transformed result (new list)
     * @throws NullPointerException if the input collection is null
     */
    public static <I, O> Collection<O> collect(Collection<I> inputCollection, Function<? super I, O> transformer) {
        final List<O> output = new ArrayList<O>(inputCollection.size());

        collect(inputCollection, transformer, output);

        return output;
    }

    /**
     * Transforms all elements from the inputIterator with the given transformer
     * and adds them to the outputCollection.
     * <p>
     * If the input iterator or transformer is null, the result is an empty list.
     *
     * @param <I>
     * @param <O>
     * @param inputIterator  the iterator to get the input from, may be null
     * @param transformer  the transformer to use, may be null
     * @return the transformed result (new list)
     */
    public static <I, O> Collection<O> collect(Iterator<I> inputIterator, Function<? super I, O> transformer) {
        final List<O> output = new ArrayList<O>();

        collect(inputIterator, transformer, output);

        return output;
    }

    /**
     * Transforms all elements from inputCollection with the given transformer
     * and adds them to the outputCollection.
     * <p>
     * If the input collection or transformer is null, there is no change to the
     * output collection.
     *
     * @param <I>
     * @param <O>
     * @param inputCollection  the collection to get the input from, may be null
     * @param transformer  the transformer to use, may be null
     * @param outputCollection  the collection to output into, may not be null
     * @return the outputCollection with the transformed input added
     * @throws NullPointerException if the output collection is null
     */
    public static <I, O> Collection<O> collect(Collection<I> inputCollection, final Function<? super I, O> transformer, final Collection<O> outputCollection) {
        if (inputCollection != null) {
            return collect(inputCollection.iterator(), transformer, outputCollection);
        }

        return outputCollection;
    }

    /**
     * Transforms all elements from the inputIterator with the given transformer
     * and adds them to the outputCollection.
     * <p>
     * If the input iterator or transformer is null, there is no change to the
     * output collection.
     *
     * @param <I>
     * @param <O>
     * @param inputIterator  the iterator to get the input from, may be null
     * @param transformer  the transformer to use, may be null
     * @param outputCollection  the collection to output into, may not be null
     * @return the outputCollection with the transformed input added
     * @throws NullPointerException if the output collection is null
     */
    public static <I, O> Collection<O> collect(Iterator<I> inputIterator, final Function<? super I, O> transformer, final Collection<O> outputCollection) {
        if (inputIterator != null && transformer != null) {
            while (inputIterator.hasNext()) {
                final I inputItem  = inputIterator.next();
                final O outputItem = transformer.apply(inputItem);

                outputCollection.add(outputItem);
            }
        }

        return outputCollection;
    }

    /**
     * Returns consecutive {@linkplain List#subList(int, int) sublists} of a list,
     * each of the same partitionSize (the final list may be smaller). For example,
     * partitioning a list containing {@code [a, b, c, d, e]} with a partition
     * partitionSize of 3 yields {@code [[a, b, c], [d, e]]} -- an outer list containing
     * two inner lists of three and two elements, all in the original order.
     *
     * <p>The outer list is unmodifiable, but reflects the latest state of the
     * source list. The inner lists are sublist views of the original list,
     * produced on demand using {@link List#subList(int, int)}, and are subject
     * to all the usual caveats about modification as explained in that API.
     *
     * @param list the list to return consecutive sublists of
     * @param partitionSize the desired partitionSize of each sublist (the last may be smaller)
     * @return a list of consecutive sublists
     * @throws IllegalArgumentException if {@code partitionSize} is nonpositive
     */
    public static <E> List<List<E>> partitionList(List<E> list, int partitionSize) {
        checkNotNull(list);
        checkArgument(partitionSize > 0, "'partitionSize' parameter must be greater than 0");

        return (list instanceof RandomAccess)
            ? new RandomAccessPartitionList<E>(list, partitionSize)
            : new PartitionList<E>(list, partitionSize);
    }

    /**
     * Returns {@code true} if any element in {@code collection} satisfies the given {@code predicate}.
     *
     * @param collection
     * @param predicate
     * @return {@code true} if any element in {@code collection} satisfies the given predicate.
     */
    public static <T> boolean any(Collection<T> collection, Predicate<? super T> predicate) {
        return any(collection.iterator(), predicate);
    }

    /**
     * Returns {@code true} if any element in {@code iterable} satisfies the given {@code predicate}.
     *
     * @param iterable
     * @param predicate
     * @return {@code true} if any element in {@code iterable} satisfies the given predicate.
     */
    public static <T> boolean any(Iterable<T> iterable, Predicate<? super T> predicate) {
        return any(iterable.iterator(), predicate);
    }

    /**
     * Returns {@code true} if one or more elements returned by {@code iterator} satisfy the given {@code predicate}.
     *
     * @param iterable
     * @param predicate
     * @return {@code true} if one or more elements returned by {@code iterator} satisfy the given predicate
     */
    public static <T> boolean any(Iterator<T> iterator, Predicate<? super T> predicate) {
        checkNotNull(predicate);

        while (iterator.hasNext()) {
            final T element = iterator.next();
            if (predicate.apply(element)) {
                return true;
            }
        }

        return false;
    }

    public static <T> T find(Collection<T> collection, Predicate<? super T> predicate) {
        return find(collection.iterator(), predicate);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<? super T> predicate) {
        return find(iterable.iterator(), predicate);
    }

    public static <T> T find(Iterator<T> iterator, Predicate<? super T> predicate) {
        checkNotNull(predicate);

		T result = null;

        while (iterator.hasNext()) {
            T element = iterator.next();
            if (predicate.apply(element)) {
                result = element;

				break;
            }
        }

        return result;
    }

    /**
     *
     * @param iter
     * @return
     */
    public static <T> List<T> iteratorToCollection(Iterator<T> iter) {
        checkNotNull(iter);

        final List<T> copy = new ArrayList<T>();
        while (iter.hasNext()) {
            copy.add(iter.next());
        }

        return copy;
    }

    /**
     *
     * @param iter
     * @return
     */
    public static <T> List<T> iteratorToCollection(Iterable<T> iter) {
        checkNotNull(iter);

        return iteratorToCollection(iter.iterator());
    }

    /**
     * Returns a {@code PeekingIterator} backed by the given iterator.
     *
     * <p>Calls to the {@code peek} method with no intervening calls to {@code
     * next} do not affect the iteration, and hence return the same object each
     * time. A subsequent call to {@code next} is guaranteed to return the same
     * object again. For example: <pre>   {@code
     *
     *   PeekingIterator<String> peekingIterator = Iterators.peekingIterator(Iterators.forArray("a", "b"));
     *   String a1 = peekingIterator.peek(); // returns "a"
     *   String a2 = peekingIterator.peek(); // also returns "a"
     *   String a3 = peekingIterator.next(); // also returns "a"}</pre>
     *
     * Any structural changes to the underlying iteration (aside from those
     * performed by the iterator's own {@link PeekingIterator#remove()} method)
     * will leave the iterator in an undefined state.
     *
     * <p>The returned iterator does not support removal after peeking, as
     * explained by {@link PeekingIterator#remove()}.
     *
     * <p>Note: If the given iterator is already a {@code PeekingIterator},
     * it <i>might</i> be returned to the caller, although this is neither
     * guaranteed to occur nor required to be consistent.  For example, this
     * method <i>might</i> choose to pass through recognized implementations of
     * {@code PeekingIterator} when the behavior of the implementation is
     * known to meet the contract guaranteed by this method.
     *
     * <p>There is no {@link Iterable} equivalent to this method, so use this
     * method to wrap each individual iterator as it is generated.
     *
     * @param iterator the backing iterator. The {@link PeekingIterator} assumes
     *     ownership of this iterator, so users should cease making direct calls
     *     to it after calling this method.
     * @return a peeking iterator backed by that iterator. Apart from the
     *     additional {@link PeekingIterator#peek()} method, this iterator behaves
     *     exactly the same as {@code iterator}.
     */
    public static <T> PeekingIterator<T> peekingIterator(Iterator<? extends T> iterator) {
        if (iterator instanceof PeekingImpl) {
            // Safe to cast <? extends T> to <T> because PeekingImpl only uses T
            // covariantly (and cannot be subclassed to add non-covariant uses).
            @SuppressWarnings("unchecked")
            final PeekingImpl<T> peeking = (PeekingImpl<T>) iterator;

            return peeking;
        }

        return new PeekingImpl<T>(iterator);
    }

    /**
     * Simply returns its argument.
     *
     * @deprecated no need to use this
     */
    @Deprecated
    public static <T> PeekingIterator<T> peekingIterator(PeekingIterator<T> iterator) {
        return checkNotNull(iterator);
    }

    // === Utility inner classes === BEGIN ===

    /**
     *
     * @author 71740 (Simone Cornacchia)
     */
    private static class PartitionList<E> extends AbstractList<List<E>> {

        private final List<E> list;
        private final int     partitionSize;

        PartitionList(List<E> list, int partitionSize) {
            this.list          = list;
            this.partitionSize = partitionSize;
        }

        @Override
        public List<E> get(int i) {
            final int listSize = size();

            checkElementIndex(i, listSize);

            final int start = i * this.partitionSize;
            final int end   = Math.min(start + this.partitionSize, this.list.size());

            return this.list.subList(start, end);
        }

        @Override
        public int size() {
            return (this.list.size() + this.partitionSize - 1) / this.partitionSize;
        }

        @Override
        public boolean isEmpty() {
            return this.list.isEmpty();
        }

    }

    /**
     *
     * @author 71740 (Simone Cornacchia)
     */
    private static final class RandomAccessPartitionList<E> extends PartitionList<E> implements RandomAccess {
        RandomAccessPartitionList(List<E> list, int partitionSize) {
            super(list, partitionSize);
        }
    }

    /**
     *
     * @author 71740 (Simone Cornacchia)
     */
    private static final class EmptyIterator<E> implements Iterator<E> {
        static final EmptyIterator<Object> EMPTY_ITERATOR = new EmptyIterator<Object>();

        public boolean hasNext() {
            return false;
        }

        public E next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new IllegalStateException();
        }
    }

    /**
     * Implementation of PeekingIterator that avoids peeking unless necessary.
     *
     * @author 71740 (Simone Cornacchia)
     */
    private static class PeekingImpl<E> implements PeekingIterator<E> {

        private final Iterator<? extends E> iterator;
        private boolean hasPeeked;
        private E peekedElement;

        PeekingImpl(Iterator<? extends E> iterator) {
            this.iterator = checkNotNull(iterator);
        }

        public boolean hasNext() {
            return this.hasPeeked || this.iterator.hasNext();
        }

        public E next() {
            if (! this.hasPeeked) {
                return this.iterator.next();
            }
            final E result = this.peekedElement;
            this.hasPeeked = false;
            this.peekedElement = null;

            return result;
        }

        public void remove() {
            checkState(! this.hasPeeked, "Can't remove after you've peeked at next");

            this.iterator.remove();
        }

        public E peek() {
            if (! this.hasPeeked) {
                this.peekedElement = this.iterator.next();
                this.hasPeeked = true;
            }

            return this.peekedElement;
        }
    }

    // === Utility inner classes ===   END ===

    /**
     * Constructor.
     */
    private CollectionUtils() {
        // no instances allowed, sucker
    }

}
