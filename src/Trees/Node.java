/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees;

/**
 *
 * @author M
 */
public class Node {
    
    int data;
    Node right;
    Node left;
    
    public Node(int data, Node right, Node left){
        this.data=data;
        this.right=right;
        this.left=left;
    }
    
}
