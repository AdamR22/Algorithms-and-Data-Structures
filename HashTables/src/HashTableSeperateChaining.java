import java.util.Arrays;
import java.util.LinkedList;

class Entry<K, V> {
    int hashKey;
    K key;
    V value;

    Entry(K key, V value) {
        hashKey = key.hashCode();
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("Key: %s, Value: %s", key, value);
    }
}

@SuppressWarnings("unchecked")
public class HashTableSeperateChaining<K, V> {
    private LinkedList<Entry<K, V>>[] hashTable;
    private int size = 0;
    private int capacity;
    private int threshold;
    private static double LOAD_FACTOR = 0.75;

    HashTableSeperateChaining(int capacity) {
        this.capacity = capacity;
        threshold = (int) (capacity * LOAD_FACTOR);
        hashTable = new LinkedList[this.capacity];
    }

    public void addEntry(K key, V value) {
        Entry<K, V> data = new Entry<K, V>(key, value);
        int entryIndex = normalizeHashKey(data.hashKey);

        LinkedList<Entry<K, V>> dataBucket = hashTable[entryIndex];

        if (dataBucket == null) {
            hashTable[entryIndex] = dataBucket = new LinkedList<>();
            dataBucket.add(data);
            if (++size > threshold) doubleHashTableSize();
        } else {
            Entry<K, V> existingData = findExistantEntry(entryIndex, data.key);
            if (existingData != null) {
                existingData.value = data.value;
                return;
            }
            dataBucket.add(data);
            if (++size > threshold) doubleHashTableSize();
        }
    }

    private Entry<K, V> findExistantEntry(int entryIndex, K entryKey) {
        LinkedList<Entry<K, V>> bucket = hashTable[entryIndex];

        if (bucket == null) return null;
        if (entryKey == null) return null;
        for (Entry<K,V> entry : bucket) {
            if (entry.key.equals(entryKey)) return entry;
        }
        return null;
    }

    private void doubleHashTableSize() {
        capacity *= 2;
        threshold = (int) (capacity * LOAD_FACTOR);

        LinkedList<Entry<K, V>>[] newHashTable = new LinkedList[capacity];

        for (int i = 0; i < hashTable.length; i++) {
            LinkedList<Entry<K, V>> dataBucket = hashTable[i];

            if (dataBucket != null) {
                for (Entry<K, V> entry : dataBucket) {
                    int entryIndex = normalizeHashKey(entry.hashKey);
                    LinkedList<Entry<K, V>> bucket = newHashTable[entryIndex];
                    if (bucket == null) {
                        bucket = new LinkedList<>();
                        newHashTable[entryIndex] = bucket;
                    }

                    bucket.add(entry);
                }
                hashTable[i].clear();
                hashTable[i] = null;
            }
        }

        hashTable = newHashTable;
    }

    private int normalizeHashKey(int key) {
        return (key & 0x7FFFFFFF) % capacity;
        // The above is simillar to: return key < 0 ? (key * -1) % capacity : key % capacity;
    }

    private Entry<K, V> getEntry(K key) {
        for (LinkedList<Entry<K,V>> bucket : hashTable) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    if (entry.key.equals(key)) return entry;
                }
            }
        }
        return null;
    }

    private boolean hasKey(K key) {
        for (LinkedList<Entry<K,V>> bucket : hashTable) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    if (entry.key.equals(key)) return true;
                }
            }
        }
        return false;
    }

    private boolean hasValue(V value) {
        for (LinkedList<Entry<K,V>> bucket : hashTable) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    if (entry.value.equals(value)) return true;
                }
            }
        }
        return false;
    }

    private void removeEntry(K key) {
        Entry<K, V> desiredData = findEntry(key);

        if (desiredData != null) {
            LinkedList<Entry<K, V>> bucket = hashTable[normalizeHashKey(desiredData.hashKey)];
            bucket.remove(desiredData);
            size--;
        }
    }

    public void remove(K key) {
        removeEntry(key);
    }

    public Entry<K, V> findEntry(K key) {
        return getEntry(key);
    }

    public boolean containsKey(K key) {
        return hasKey(key);
    }

    public boolean containsValue(V value) {
        return hasValue(value);
    }

    public void clear() {
        Arrays.fill(hashTable, null);
        size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void printAllData() {
        for (int i = 0; i < hashTable.length; i++) {
            LinkedList<Entry<K, V>> dataBucket = hashTable[i];
            if (dataBucket != null) {
                for (Entry<K, V> entry : dataBucket) {
                    System.out.println(entry.toString());
                }
            }
        }
    }
}
