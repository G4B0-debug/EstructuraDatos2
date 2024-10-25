package BBVA;

public class LinkedQueue {
    private Node front;
    private Node rear;

    private class Node {
        Cliente data;
        Node next;

        Node(Cliente data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedQueue() {
        front = null;
        rear = null;
    }

    public void enqueue(Cliente cliente) {
        Node newNode = new Node(cliente);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public Cliente dequeue() {
        if (isEmpty()) {
            return null;
        }
        Cliente cliente = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return cliente;
    }

    public void enqueuePriority(Cliente cliente) {
        Node newNode = new Node(cliente);
        if (front == null) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front = newNode;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }
}

    

