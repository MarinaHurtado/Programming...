/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoublyLinkedList;

import java.util.*;
/**
 *
 * @author M
 */
public class Flat {
    
    public Node flatting(Node head){
        if (head == null)  
            return null;
        flatMet(head);
        return head;
    }
    
    private Node flatMet(Node nod){
        if(nod.child!=null){
            Node aux = nod.next;
            nod.next = nod.child;
            nod.child.prev = nod;
            Node tail = flatMet(nod.child);
            tail.next = aux;
            aux.prev = tail;
        }
        if(nod.next!=null)
            nod = flatMet(nod.next);
        return nod;
    }
    
    
    ////////////// Por niveles
    
    public Node flattingByNevel(Node head){
        if (head == null)  
            return null;
        Node aux = head;
        Node newList = null;
        Node tail = checkNiv(aux, newList);
        while(newList!=null){
            tail.next = newList;
            newList.prev = tail;
            aux = newList;
            newList = null;
            tail = checkNiv(aux, newList);
        }
        return head;
    }
    
    private Node checkNiv(Node aux, Node newList){
        if(aux==null)
            return null;
        while(aux.next!=null){
            if(aux.child!=null)
                newList.add(aux.child); //Suponiendo existe, agrega a la cola
            aux = aux.next;
        }
        if(aux.child!=null)
                newList.add(aux.child); //Suponiendo existe, agrega a la cola
        return aux;
    }
    
    
    
}
