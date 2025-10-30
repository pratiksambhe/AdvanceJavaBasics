package com.example.AUg5_SpringProject.designPattern.behavioral.iterators;

class NameRepository implements Container {
    private String[] names = {"Pratik", "Rajesh", "Sambhe"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    // Inner class implementing Iterator
    private class NameIterator implements Iterator {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}