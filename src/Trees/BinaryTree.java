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
public class BinaryTree {
    
    public void preorderTransversal (Node root){
        if(root==null){ return;}
        System.out.println(root.data);
        preorderTransversal(root.left);
        preorderTransversal(root.right);
    }
    
    public void inorderTransversal (Node root){
        if(root==null){ return; }
        preorderTransversal(root.left);
        System.out.println(root.data);
        preorderTransversal(root.right);
    }
    
    public void postOrderTransversal (Node root){
        if(root==null){ return; }
        preorderTransversal(root.left);
        preorderTransversal(root.right);
        System.out.println(root.data);
    }
    
    //Without recurssion
    public void preorderTransversalWR (Node root){
        NodeOfNodes rootNode = new NodeOfNodes(root, null);
        NodeList list = new NodeList(rootNode);
        while(rootNode!=null){
            System.out.println(list.head.nodeOfTree.data);
            list.addInOrder();
        }
    }
    
     
}


