package ivan.boiko.algorithms.prometheus;

public class LinkedList {

    private Node begin;
    private Node finish;

    public LinkedList() {
        //PUT YOUR CODE HERE
        //PUT YOUR CODE HERE
    }

    public void add(Integer data) {
        //PUT YOUR CODE HERE
        if (begin == null) {
            begin = new Node();
            begin.setData(data);
            finish = begin;
        } else {
            Node newNode = new Node();
            newNode.setData(data);
            finish.setNext(newNode);
            finish = newNode;
        }
        //PUT YOUR CODE HERE
    }

    public Integer get(int index) {
        //PUT YOUR CODE HERE
        Node node = begin;
        for (int i = 0; i < index; i++) {
            if (node != null)
                node = node.getNext();
        }
        if (node == null) return null;
        else return node.getData();
        //PUT YOUR CODE HERE
    }

    public boolean delete(int index) {
        //PUT YOUR CODE HERE

        if (index < 0) return false;
        Node node = begin;
        for (int i = 0; i < index - 1; i++) {
            if (node == null)
                return false;
            else
                node = node.getNext();
        }

        if (node == null) {
            return false;
        } else if (node.getNext() == null) {
            return false;
        } else {
            node.setNext(node.getNext().getNext());
            return true;
        }
        //PUT YOUR CODE HERE
    }

    public int size() {
        //PUT YOUR CODE HERE
        int count = 0;
        Node node = begin;

        if (node == null) return count;
        else count++;

        while (node.getNext() != null) {
            node = node.getNext();
            count++;
        }
        return count++;
        //PUT YOUR CODE HERE
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        Node node = begin;
        while (node.getNext() != null) {
            builder.append(node.getData()).append(" ");
            node = node.getNext();
        }
        builder.append(node.getData()).append(" ");

        return builder.toString();
    }

    private class Node {

        private Node next;
        private Integer data;

        Node() {
        }

        Node getNext() {
            return next;
        }

        void setNext(Node next) {
            this.next = next;
        }

        Integer getData() {
            return data;
        }

        void setData(Integer data) {
            this.data = data;
        }
    }
}