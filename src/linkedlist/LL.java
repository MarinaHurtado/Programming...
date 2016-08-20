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
public class LL {
    
    private Node head;
    private Node tail;

    public LL(Object data) {
        Node n = new Node (data, null);
        this.head = n;
        this.tail = n;
    }
    
    public boolean remove (Object data){
        if(head==null)
            return false;
        Node aux = head;
        boolean flag = false;
        if(aux.data.equals(data)){
            head=aux.next;
            if(head==null)
                tail=null;
            flag = true;
        }
        else{
            while(!aux.next.equals(null) && !aux.next.data.equals(data))
                aux = aux.next;
            if(aux.next.data.equals(data)){
                aux.next = aux.next.next;
                if(aux.next.equals(null))
                    tail = aux;
                flag = true;
            }
        }
        return flag;
    }
    
    public boolean insertAfter (Object data, Node where){
        Node aux = head;
        boolean flag = false;
        if(where==null){
            Node n = new Node (data, head);
            head = n;
            flag=true;
        }
        else{
            while(aux!=null && !where.equals(aux))
                aux = aux.next;
            if(where.equals(aux)){
                Node toInsert = new Node (data, aux.next);
                aux.next = toInsert;
                flag=true;
            }
        }
        if(aux.next==null)
            tail=aux.next;
        return flag;
    }
    
    ///////////////
    
    public Object MtoToLastElement(int mth){
        if(head==null || mth<0)
            return false;
        Node aux = head;
        Object ans=null;
        counter(mth, aux, ans);
        return ans;
    }
    
    private int counter(int mth, Node aux, Object ans){
        if(aux.next == null){
            if(mth==0)
                ans = aux.data;
            return 1; 
        }
        else {
            int n = counter(mth, aux.next, ans);
            if(n==mth){
                ans = aux.data;  
            }
            return n++;
        }
    }
    
    ////////////// Opción 2
    
    public Object MtoToLastElement2(int mth){
        int i=0;
        Node aux = head;
        
        while (aux!=null && i<mth)
            aux=aux.next;
        if(aux==null)
            return null;
        
        Node m = head;
        while(aux.next!=null){
            aux=aux.next;
            m=m.next;
        }
        return m;
    }
    
    ///////////// Revisar si es cíclica
    
    public boolean isCyclic(Node head){
        if(head==null)
            return false;
        int i=1;
        boolean flag = true;
        Node aux=head.next;
        while(aux.next!=null && flag){
            Node list2aux = head;
            for(int j=0; j<i; i++){
                if(aux.equals(list2aux))
                    flag = false;
                list2aux = list2aux.next;
            }
            i++;
            aux=aux.next;
        }
        return !flag;
    }
    
    /*
    Given a sorted linked list, delete all duplicates such that each element appear only once.

    For example,
    Given 1->1->2, return 1->2.
    Given 1->1->2->3->3, return 1->2->3.
    */
    public ListNode deleteDuplicates(ListNode a) {
	    ListNode act = a.next;
	    ListNode ant = a;
	    while(act != null){
	        if(act.val != ant.val){
	            act= act.next;
	            ant = ant.next;
	        } else {
	            act = act.next;
	            ant.next = act;
	        }
	    }
	    return a;
	}
    
}
