/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoublyLinkedList;

/**
 *
 * @author M
 */
public class Node {
    
    int data;
    Node next;
    Node prev;
    Node child;

    public Node(int data, Node next, Node prev, Node child) {
        this.data = data;
        this.next = next;
        this.prev = prev;
        this.child = child;
    }
}
