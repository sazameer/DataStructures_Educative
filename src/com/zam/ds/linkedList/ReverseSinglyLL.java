package com.zam.ds.linkedList;

import com.zam.ds.linkedList.SinglyLinkedList;

public class ReverseSinglyLL {
	public static <T> void reverse(SinglyLinkedList<T> list){
        //Write -- Your -- Code
        SinglyLinkedList.Node current = list.headNode;
        SinglyLinkedList.Node next = null;
        SinglyLinkedList.Node skipLevelNext = null;

        while(current.nextNode != null){
            if(current == list.headNode)
                next = current.nextNode;
            if(next != null)
                skipLevelNext = next.nextNode;

            next.nextNode = current;
            if(list.headNode == current)
                current.nextNode = null;

            if(skipLevelNext == null) {
                list.headNode = next;
                break;
            }
            
            current = next;
            
            if(skipLevelNext != null)
            	next = skipLevelNext;
            
            if(next != null)
            	skipLevelNext = next.nextNode;
 
        }
    }
	
	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
		linkedList.insertAtEnd(10);
		linkedList.insertAtEnd(20);
		linkedList.insertAtEnd(30);
		linkedList.insertAtEnd(40);
		linkedList.insertAfter(40, 50);
		linkedList.printList();
		
		ReverseSinglyLL.reverse(linkedList);
		linkedList.printList();
	}
}