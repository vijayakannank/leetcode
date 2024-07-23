package ownimpl;

public class HashMapImpl<K, V> {

    private class Entry<K,V> {
        K key;
        V value;
        Entry<K,V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setValue(V value) {
            this.value = value;
        }

    }

    private int capacity = 16;
    private Entry<K, V>[] table;

    public HashMapImpl(){
        this.table = new Entry[capacity];
    }
    public HashMapImpl(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[capacity];
    }

    void put(K key, V value){
        int index = getIndex(key);
        Entry<K, V> entry = table[index];
        Entry<K,V> prevEntry = null;
        while (entry != null){
            if(entry.getKey().equals(key)){
                entry.setValue(value);
                return;
            }
            prevEntry = entry;
            entry = entry.next;
        }
        if(prevEntry == null)
            table[index] = new Entry<>(key, value);
        else
            prevEntry.next = new Entry<>(key, value);

    }
    public V get(K key){
        int index = getIndex(key);
        Entry<K, V> entry = table[index];
        while(entry != null){
            if(entry.getKey().equals(key))
                return entry.value;
            entry = entry.next;
        }
        return null;
    }
    public void delete(K key){
        int index = getIndex(key);
        Entry<K,V> entry = table[index];
        if(entry == null)
            return;
        if(entry.key.equals(key)){
            table[index] = entry.next;
        }
        Entry<K, V> prev = null;
        while (entry != null){
            if(entry.key.equals(key)){
                prev.next = entry.next;
                return;
            }
            prev = entry;
            entry  = entry.next;
        }
    }

    int getIndex(K key){
        if(key == null)
            return 0;
        if("c".equals(key))
            return 1;
        return Math.abs(key.hashCode() %capacity);
    }

    public static void main(String[] args) {
        HashMapImpl<String, Integer> map = new HashMapImpl<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 4);
        map.put("a",3);
        System.out.println(map.get("c"));
        System.out.println(map.get("a"));



    }
}
