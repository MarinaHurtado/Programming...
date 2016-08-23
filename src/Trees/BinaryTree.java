/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees;

import java.util.ArrayList;
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
    
    //Given a binary tree, return the inorder traversal of its nodes’ values.
    //Using recursion is not allowed.
    /**
    * Definition for binary tree
    * class TreeNode {
    *     int val;
    *     TreeNode left;
    *     TreeNode right;
    *     TreeNode(int x) { val = x; }
    * }
    */
    public ArrayList<Integer> inorderTraversal(TreeNode a) {  
        if(a==null)
            return null;
        ArrayList<Integer> arr = new ArrayList();
        Stack waiting = new Stack();
        waiting.push(a);
        while(!waiting.empty()){
            TreeNode pop = (TreeNode)waiting.pop();
            if(pop!=null){
                TreeNode left = pop.left;
                if(left!=null){
                    pop.left = null;
                    waiting.push(pop);
                    waiting.push(left);
                }
                else{
                    arr.add(pop.val);
                    waiting.push(pop.right);
                }
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
    
        /**
        Given a binary tree, determine if it is height-balanced.
        Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
        Return 0 / 1 ( 0 for false, 1 for true ) for this problem
        
        * Definition for binary tree
        * class TreeNode {
        *     int val;
        *     TreeNode left;
        *     TreeNode right;
        *     TreeNode(int x) { val = x; }
        * }
        */
        public int isBalanced(TreeNode a) {
            int ans = levels(a, 0);
            if(ans >-1)
                return 1;

            return 0;
	}
	
	public int levels(TreeNode node, int level){
	    if(node == null)
	        return level;
	    
	    int left = levels(node.left, level +1);
	    int right = levels(node.right, level +1);
	    if(left == -1 || right == -1)
	        return -1;
	    if(Math.abs(left-right)<=1)
                         return Math.max(left, right);
	    else return -1;
	}
	
        /*
        Given a binary tree, find its maximum depth.
        The maximum depth of a binary tree is the number of nodes along the longest path from the root node down to the farthest leaf node.
        */
        public int maxDepth(TreeNode a) {
	    return maxD(a, 0);
	}
	
	public int maxD(TreeNode a, int max){
	    if(a == null)
	        return max;
	    return Math.max(maxD(a.left, max+1), maxD(a.right, max+1));
	}
        

}
    
     
}


