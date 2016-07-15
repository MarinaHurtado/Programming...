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
//Creo una interfaz que a decir verdad creo que sólo “se ve bonita” porque no se me hace //muy útil
public interface InterfaceLL {
    boolean push (Object data, Node head);
    Object pop (Node head);
    Node createStack (Object data);
    boolean deleteStack(Node head);
}

