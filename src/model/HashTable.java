package model;

public class HashTable<K extends Comparable<K>, V> {

    private NodeHash<K, V>[] list;

    private int length;

    public HashTable(int length) {
        list = new NodeHash[length];
        this.length = length;
    }

    public void insert(K key, V value) {
        int index = hash(key);
        NodeHash<K, V> node = new NodeHash<K, V>(key, value);
        if (list[index] != null) {
            list[index].setPrev(node);
            node.setNext(list[index]);
        }
        list[index] = node;
    }

    public V get(K key) {
        int index = hash(key);
        NodeHash<K, V> node = list[index];
        while (node != null) {
            if (node.getKey().compareTo(key) == 0) {
                return node.getValue();
            }
            node = node.getNext();
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        NodeHash<K, V> current = list[index];
        while (current != null) {
            if (current.getKey().equals(key)) {
                if (current.getPrev() == null) {
                    list[index] = current.getNext();
                } else {
                    current.getPrev().setNext(current.getNext());
                }
                if (current.getNext() != null) {
                    current.getNext().setPrev(current.getPrev());
                }
                return;
            }
            current = current.getNext();
        }
    }

    public String print() {
        String msg = "";
        for (int i = 0; i < length; i++) {
            if (list[i] != null) {
                NodeHash<K, V> node = list[i];
                while (node != null) {
                    if (node.getNext() == null) {
                        msg += node.getValue().toString() + ", ";
                    } else {
                        msg += node.getValue().toString() + ", ";
                    }
                    node = node.getNext();
                }

            }

        }
        return msg;
    }

    public int hash(K key) {
        int hash = key.hashCode();
        hash = hash < 0 ? -hash : hash; // asegura que el hash sea positivo
        return hash % length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public NodeHash<K, V>[] getList() {
        return list;
    }

    public void setList(NodeHash<K, V>[] list) {
        this.list = list;
    }

    
    public boolean isEmpty() {
        for (int i = 0; i < length; i++) {
            if (list[i] != null) {
                return false;
            }
        }
        return true;
    }

}