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
public class NodeOfNodes {
    
    Node nodeOfTree;
    NodeOfNodes next;

    public NodeOfNodes(Node nodeOfTree, NodeOfNodes next) {
        this.nodeOfTree = nodeOfTree;
        this.next = next;
    }
    
}
