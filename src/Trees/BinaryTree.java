/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees;

import java.util.Stack;

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
    
    //Without recurssion -list-
    public void preorderTransversalList (Node root){
        NodeOfNodes rootNode = new NodeOfNodes(root, null);
        NodeList list = new NodeList(rootNode);
        while(rootNode!=null){
            System.out.println(list.head.nodeOfTree.data);
            list.addInOrder();
        }
    }
    
    //Without recurssion -Stack-
    public void preorderTransversalStack (Node root){
        if(root==null)
            return;
        Stack waiting = new Stack();
        waiting.add(root);
        while(!waiting.empty()){
            Node pop = (Node)waiting.pop();
            System.out.println(pop.data);
            if(pop.right!=null)
                waiting.push(pop.right);
            if(pop.left!=null)
            waiting.push(pop.left);
        }
    }
    
    public Node lowestCommonAncestor(Node root, Node c1, Node c2){
        if ((root.data<c1.data && root.data>c2.data) || (root.data>c1.data && root.data<c2.data))
            return root;
        if(root==null)
            return null;
        if(root.data>c1.data)
            return lowestCommonAncestor(root.left, c1, c2);
        else
            return lowestCommonAncestor(root.right, c1, c2);
    }
    
     
}


