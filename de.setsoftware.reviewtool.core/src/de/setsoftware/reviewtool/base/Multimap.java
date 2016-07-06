package de.setsoftware.reviewtool.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A simple multimap with a list of values for each key.
 * @param <K> Type of the key.
 * @param <V> Type of the value.
 */
public final class Multimap<K, V> {

    private final Map<K, List<V>> map = new LinkedHashMap<>();

    /**
     * Add the given key value pair. If there already is an entry
     * for the given key, add the value to the end of this key's list.
     */
    public void put(K key, V value) {
        List<V> list = this.map.get(key);
        if (list == null) {
            list = new ArrayList<>();
            this.map.put(key, list);
        }
        list.add(value);
    }

    /**
     * Get the values for the given key. If there are no values, the
     * empty list is returned.
     */
    public List<V> get(K key) {
        final List<V> list = this.map.get(key);
        return list == null ? Collections.<V>emptyList() : list;
    }

    /**
     * Adds all entries from the given map to this map.
     */
    public void putAll(Multimap<? extends K, ? extends V> other) {
        for (final K key : other.map.keySet()) {
            for (final V value : other.map.get(key)) {
                this.put(key, value);
            }
        }
    }

    /**
     * Returns all entries of this multimap.
     */
    public Set<Map.Entry<K, List<V>>> entrySet() {
        return Collections.unmodifiableSet(this.map.entrySet());
    }

    @Override
    public String toString() {
        return this.map.toString();
    }

    @Override
    public int hashCode() {
        return this.map.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Multimap)) {
            return false;
        }
        final Multimap<?, ?> m = (Multimap<?, ?>) o;
        return this.map.equals(m.map);
    }

}