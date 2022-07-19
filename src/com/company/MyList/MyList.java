package com.company.MyList;

public class MyList<T> {
    private int capacity;
    private T[] data;
    private int lastIndex = 0;

    public MyList() {
        this.capacity = 10;
        this.data = (T[]) new Object[capacity];
    }

    public MyList(int capacity) {
        this.capacity = capacity;
        this.data = (T[]) new Object[this.capacity];
    }

    public int size() {
        return this.lastIndex;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(T data) {
        if (lastIndex < capacity) {
            this.data[lastIndex] = data;
            lastIndex++;
        } else {
            capacity *= 2;
            T[] newData = (T[]) new Object[capacity];
            for (int i = 0; i < this.data.length; i++) {
                newData[i] = this.data[i];
            }
            this.data = newData;
            this.data[lastIndex] = data;
            lastIndex++;
        }
    }

    public T get(int index) {
        return index < lastIndex ? this.data[index] : null;
    }

    public T remove(int index) {
        T val;
        if (index < this.lastIndex) {
            val = this.data[index];
            for (int i = index; i < lastIndex; i++) {
                this.data[i] = this.data[i + 1];
            }
            this.data[lastIndex - 1] = null;
            lastIndex--;
        } else {
            val = null;
        }
        return val;
    }

    public T set(int index, T data) {
        if (index < lastIndex) {
            this.data[index] = data;
            return this.data[index];
        }
        return null;
    }

    @Override
    public String toString() {
        String valueRepresentation = "[";
        for (int i = 0; i < lastIndex; i++) {
            if (this.data[i] != null) {
                valueRepresentation += this.data[i].toString() + ", ";
            }
        }
        return valueRepresentation + "]";
    }

    public int indexOf(T data) {
        int index = -1;
        for (int i = 0; i < lastIndex; i++) {
            if (this.data[i].equals(data)) {
                index = i;
            }
        }
        return index;
    }

    public int lastIndexOf(T data) {
        return indexOf(data);
    }

    public boolean isEmpty() {
        return lastIndex > 0 ? false : true;
    }

    //class cast exception
    /*public T[] toArray() {
        T[] arr = (T[])new Object[lastIndex];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = this.data[i];
        }
        return arr;
    }*/
    public void clear() {
        for (T t : this.data) {
            t = null;
        }
    }

    public MyList<T> sublist(int start, int finish) {
        MyList<T> sublist = new MyList<>();
        if (start >= 0 && finish < lastIndex) {
            for (int i = start; i < finish; i++) {
                sublist.add(this.data[i]);
            }
            return sublist;
        }
        return null;
    }

    public boolean contains(T data) {
        for (int i = 0; i < lastIndex; i++) {
            if (this.data[i].equals(data))
                return true;
        }
        return false;
    }
}
