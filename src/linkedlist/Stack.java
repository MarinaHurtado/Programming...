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
public class Stack {
    
    private Node head;

    public Stack(Object data) {
        Node newHead = new Node(data, null);
        head = newHead;
    }
    
    public boolean push (Object data){
        Node newHead = new Node(data, head);
        head = newHead;
        return true;
    }
    
    public Object pop (){
        //Se da el caso en el que me pasen un apuntador nulo, entonces no le puedo pedir propiedades
        if(!head.equals(null)){
            Object data = head.data;
            head = head.next;
            return data;
        }
        else
            return null; 
    } 
   
}
