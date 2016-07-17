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
public class NodeList {
    
    NodeOfNodes head;

    public NodeList(NodeOfNodes node) {
        head = node;
    }
    
    public void addInOrder(){
        NodeOfNodes nodeRight = new NodeOfNodes(head.nodeOfTree.right, head.next);
        NodeOfNodes nodeLeft = new NodeOfNodes(head.nodeOfTree.left, nodeRight);
        head = nodeLeft;
    }
    
}
