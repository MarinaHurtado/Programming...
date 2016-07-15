/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author M
 */
public class LinkedList implements InterfaceLL{
        
    public boolean push (Object data, Node head){
        Node newHead = new Node(data, head);
        head = newHead;
        return true;
    }
    
    public Object pop (Node head){
//Se da el caso en el que me pasen un apuntador nulo, entonces no le puedo pedir //propiedades
        if(!head.equals(null)){
            Object data = head.data;
            head = head.next;
            return data;
        }
        else
            return null; 
    }
    
    public Node createStack (Object data){
        Node newHead = new Node(data, null);
        return newHead;
    }
    
    public boolean deleteStack(Node head){
        while(head.next!=null){
            pop(head);
        }
        head = null;
        return true;
    }

}