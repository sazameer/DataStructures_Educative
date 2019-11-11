package com.zam.ds.linkedList;


public class DoublyLinkedList<T> {
	
	public class Node<T>{
		private T data;
		private Node<T> nextNode;
		private Node<T> previousNode;
	}
	
	public Node<T> headNode;
	public Node<T> tailNode;
	public int size;
	
	//No Arg Constructor
	public DoublyLinkedList(){
		headNode = null;
		tailNode = null;
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
		newNode.previousNode = null;
		//headNode.previousNode = newNode;
		
		if(headNode != null) {
			headNode.previousNode = newNode;
		}		
		headNode = newNode;
		if(tailNode == null)
			tailNode = newNode;
	}
	
	//Inserting the Node at End, This approach was used when tailNode was not available
	//This approach the complexity was O(n)
	/* 
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
		newNode.previousNode = temp;
	}
*/
	
	
	//When utilizing the TailNode then the insertAtEnd complexity becomes O(1)
	public void insertAtEnd(T newValue) {
		
		if(isEmpty()) {
			insertAtHead(newValue);
			return;
		}
		Node<T> newNode = new Node<T>();	
		newNode.data = newValue;
		newNode.nextNode = null;
		
		tailNode.nextNode = newNode;
		newNode.previousNode = tailNode;
		
		tailNode = newNode;	
	}
	
	
	//Inserting the Node After a Specific Node
	public void insertAfter(T insertAfter, T newValue) {
		if(isEmpty()) {
			insertAtHead(newValue);
			return;
		}
		
		Node<T> newNode = new Node<T>();
		newNode.data = newValue;
		
		boolean insertAfterFound = false;
		
		Node<T> temp = headNode;
		while(temp != null) {
			if(temp.data.equals(insertAfter)) {
				insertAfterFound = true;
				newNode.nextNode = temp.nextNode;
				if(temp.nextNode != null) {
					Node<T> nextNode = temp.nextNode;
					nextNode.previousNode = newNode;
				}
				temp.nextNode = newNode;
				newNode.previousNode = temp;
				if(temp.nextNode == null) {
					tailNode = newNode;
				}
				break;
			}
			temp = temp.nextNode;
		}
		
		if(!insertAfterFound) {
			System.out.println("Unable to Insert, Value " + insertAfter + " Not Found");
		}
	}
	
	public void printList() {
		Node<T> temp = headNode;
		System.out.print("List         : ");
		while(temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.nextNode;
		}
		System.out.println("null");
	}
	
	public void printListReverseOrder() {
		Node<T> temp = tailNode;
		System.out.print("Reverse List : ");
		while(temp != null) {
			System.out.print(temp.data + " <- ");
			temp = temp.previousNode;
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
		Node<T> current = headNode;
		Node<T> previous = null;
		
		while(current != null) {
			if(current.data.equals(nodeToDelete)) {
				Node<T> nextNode = current.nextNode;
				
				if(current.nextNode == null)
					tailNode = previous;
				
				if(previous == null) {
					headNode = nextNode;
					nextNode.previousNode = null;
					break;
				}else {
					previous.nextNode = nextNode;
					if(nextNode != null)
						nextNode.previousNode = previous;
					break;
				}
			}
			previous = current;
			current = current.nextNode;
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<Integer>();
		
		//Insert at Head Test
		/*
		linkedList.insertAtHead(10);
		linkedList.insertAtHead(20);
		linkedList.insertAtHead(30);
		linkedList.insertAtHead(40);
		
		linkedList.printList();
		linkedList.printListReverseOrder();
		*/
		
		
		//Insert At End Test
		linkedList.insertAtEnd(10);
		linkedList.insertAtEnd(20);
		linkedList.insertAtEnd(30);
		linkedList.insertAtEnd(40);
		linkedList.printList();
		linkedList.printListReverseOrder();
		
		//Insert After Test
		
		linkedList.insertAfter(10, 50);
		linkedList.printList();
		linkedList.printListReverseOrder();
		
		
		if(linkedList.searchNode(60)) {
			System.out.println("Value found!");
		}else {
			System.out.println("Couldnt find the value");
		}
		
		linkedList.deleteNode(40);
		linkedList.printList();
		linkedList.printListReverseOrder();
		/*
		linkedList.deleteNode(30);
		linkedList.printList();
		*/
		

	}

}
