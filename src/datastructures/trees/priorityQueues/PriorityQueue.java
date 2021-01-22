package datastructures.trees.priorityQueues;

/* Priority Queue implementation using an ordered arrayList */

import java.util.ArrayList;
import java.util.Arrays;

class Node {
    String value;
    int priority;

    public Node(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }
}

public class PriorityQueue {
    private ArrayList<Node> queueArray = new ArrayList<>();

    // The smaller number means the higher priority
    public void enqueue(String value, int priority) {
        Node newNode = new Node(value, priority);
        boolean check = false;

        for (int i = 0; i < queueArray.size(); i++) {
            if (queueArray.get(i).priority > newNode.priority) {
                queueArray.add(i, newNode);
                check = true;
                break;
            }
        }
        if (!check) {  
            queueArray.add(newNode);
        }
    }

    // Remove the node which has the highest priority (The lowest number) 
    public String dequeue() {
        if (queueArray.isEmpty()) {
            return "Empty array";
        }
        Node removal = queueArray.get(0);
        queueArray.remove(0);
        return removal.value;
    }

    // Return a node which is in the front of the queue
    public Node front() {
        if (!queueArray.isEmpty()) {
            return queueArray.get(0);
        }
        return null;
    }

    // Return a node which is in the rear of the queue
    public Node rear() {
        if (!queueArray.isEmpty()) {
            return queueArray.get(queueArray.size() - 1);
        }
        return null;
    }

    // Checks whether the queue is empty or not
    public boolean isEmpty() {
        return queueArray.isEmpty();
    }

    // Prints out each value of nodes in the queue with its order maintained
    public String[] printQueue() {
        String[] array = new String[queueArray.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = queueArray.get(i).value;
        }
        return array;
    }

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.enqueue("cherry", 3);
        queue.enqueue("apple", 1);
        queue.enqueue("banana", 2);
        queue.enqueue("egg", 5);
        queue.enqueue("drink", 4);
        System.out.println(Arrays.toString(queue.printQueue()));
        System.out.println(queue.dequeue());
        System.out.println(Arrays.toString(queue.printQueue()));
        System.out.println(queue.front().value);
        System.out.println(queue.rear().value);
        System.out.println(queue.isEmpty());
    }
}
