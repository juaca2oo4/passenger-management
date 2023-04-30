package model;

public class NodeHash<K extends Comparable<K>, V> {

    private K key;
    private V value;
    private NodeHash<K, V> next;
    private NodeHash<K, V> prev;

    public NodeHash(K key, V value) {
        this.key = key;
        this.value = value;
        next = null;
        prev = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public NodeHash<K, V> getNext() {
        return next;
    }

    public void setNext(NodeHash<K, V> next) {
        this.next = next;
    }

    public NodeHash<K, V> getPrev() {
        return prev;
    }

    public void setPrev(NodeHash<K, V> prev) {
        this.prev = prev;
    }

}
