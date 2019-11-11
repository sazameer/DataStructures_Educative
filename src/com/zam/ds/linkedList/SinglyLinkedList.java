package com.zam.ds.linkedList;

import java.util.HashSet;
import java.util.Set;

public class SinglyLinkedList<T> {
	
	public class Node<T>{
		protected T data;
		protected Node<T> nextNode;
	}
	
	public Node<T> headNode;
	public int size;
	
	//No Arg Constructor
	public SinglyLinkedList(){
		headNode = null;
		size = 0;
	}
	
	//Method to check if the List is Empty
	public boolean isEmpty() {
		if(headNode == null)
			return true;
		else
			return false;
	}
	
	//Inserting the Node at Head
	public void insertAtHead(T newValue) {
		Node<T> newNode = new Node<T>();
		newNode.data = newValue;
		newNode.nextNode = headNode;
		
		headNode = newNode;
	}
	
	//Inserting the Node at End
	public void insertAtEnd(T newValue) {
		
		if(isEmpty()) {
			insertAtHead(newValue);
			return;
		}
		
		Node<T> newNode = new Node<T>();	
		newNode.data = newValue;
		newNode.nextNode = null;
		
		Node<T> temp = headNode;
		while(temp.nextNode != null) {
			temp = temp.nextNode;
		}
		
		temp.nextNode = newNode;
	}
	
	//Inserting the Node After a Specific Node
	public void insertAfter(T insertAfterValue, T newValue) {
		if(isEmpty()) {
			insertAtHead(newValue);
			return;
		}
		
		Node<T> newNode = new Node<T>();
		newNode.data = newValue;
		
		boolean insertAfterValueFound = false;
		
		Node<T> temp = headNode;
		while(temp != null) {
			if(temp.data.equals(insertAfterValue)) {
				insertAfterValueFound = true;
				newNode.nextNode = temp.nextNode;
				temp.nextNode = newNode;
				break;
			}
			temp = temp.nextNode;
		}
		
		if(!insertAfterValueFound) {
			System.out.println("Unable to Insert, Value " + insertAfterValue + " Not Found");
		}
	}
	
	public void printList() {
		Node<T> temp = headNode;
		
		while(temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.nextNode;
		}
		System.out.println("null");
	}
	
	public boolean searchNode(T valueToFind) {
		Node<T> temp = this.headNode;
		
		while(temp != null) {
			if(temp.data.equals(valueToFind))
				return true;
			temp = temp.nextNode;
		}
		
		return false;
	}
	
	public void deleteNode(T nodeToDelete) {
		Node current = headNode;
		Node previous = null;
		
		while(current != null) {
			if(current.data.equals(nodeToDelete)) {
				if(previous == null) {
					headNode = current.nextNode;
					break;
				}else {
					previous.nextNode = current.nextNode;
					break;
				}
			}
			previous = current;
			current = current.nextNode;
			
		}
	}
	
	public <T> void reverse(SinglyLinkedList<T> list){
        //Write -- Your -- Code
        Node current = headNode;
        Node next = null;
        Node skipLevelNext = null;

        while(current.nextNode != null){
            if(current == headNode)
                next = current.nextNode;
            if(next != null)
                skipLevelNext = next.nextNode;

            next.nextNode = current;
            if(headNode == current)
                current.nextNode = null;

            current = next;
            next = skipLevelNext;

            if(skipLevelNext == null)
                headNode = next;
        }
    }
	
	public static <T> Object findMiddle(SinglyLinkedList<T> list){
		
		int size = 0;
		SinglyLinkedList.Node current = list.headNode;
		SinglyLinkedList.Node middle = list.headNode;
		
		while(current.nextNode != null) {
			size++;
			if(size % 2 == 0)
				middle = middle.nextNode;
			
			current = current.nextNode;
		}
		
		return middle.data;
	}
	
	//NOTE: This is the optimized solution by using HashSet
	//		Least efficient approach would be to use the Brute Force approach
	public static <T> void removeDuplicates(SinglyLinkedList<T> list) {
		SinglyLinkedList<T>.Node<T> current = list.headNode;
        SinglyLinkedList<T>.Node<T> previous = null;
        Set<T> set = new HashSet<T>();

        while(current != null){
            if(set.contains(current.data)){
                previous.nextNode = current.nextNode;
            }else{
                set.add((T) current.data);
            }         

            previous = current;
            current = current.nextNode;
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();
		
		//Insert at Head
		/*
		linkedList.insertAtHead(10);
		linkedList.insertAtHead(20);
		linkedList.insertAtHead(30);
		linkedList.insertAtHead(40);
		
		linkedList.printList();
		
		
		linkedList.insertAtEnd(10);
		linkedList.insertAtEnd(20);
		linkedList.insertAtEnd(30);
		linkedList.insertAtEnd(40);
		linkedList.printList();
		
		
		linkedList.insertAtEnd(10);
		linkedList.insertAtEnd(20);
		linkedList.insertAtEnd(30);
		linkedList.insertAtEnd(40);
		linkedList.insertAfter(40, 50);
		linkedList.printList();
		
		if(linkedList.searchNode(60)) {
			System.out.println("Value found!");
		}else {
			System.out.println("Couldnt find the value");
		}
		
		linkedList.deleteNode(50);
		linkedList.insertAtEnd(60);
		linkedList.insertAtEnd(70);
		//linkedList.insertAtEnd(80);
		linkedList.printList();
		
		System.out.println("Middle Element : " + SinglyLinkedList.findMiddle(linkedList));
		*/
		
		linkedList.insertAtEnd(10);
		linkedList.insertAtEnd(20);
		linkedList.insertAtEnd(30);
		linkedList.insertAtEnd(20);
		linkedList.insertAtEnd(40);
		linkedList.insertAtEnd(30);
		linkedList.insertAtEnd(50);
		linkedList.insertAtEnd(60);
		linkedList.insertAtEnd(60);
		linkedList.printList();
		
		SinglyLinkedList.removeDuplicates(linkedList);
		
		linkedList.printList();
	}
}
