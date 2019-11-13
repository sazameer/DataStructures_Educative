package com.zam.ds.stacksQueues;

public class Stack<V> {
	
	private int maxSize;
	private int top;
	private V array[];
	
	@SuppressWarnings("unchecked")
	public Stack(int maxSize) {
		this.maxSize = maxSize;
		top = -1;
		array = (V[])new Object[maxSize];
	}
	
	public boolean isEmpty() {
		return (top == -1) ? true : false;
	}
	
	public boolean isFull() {
		return (top == maxSize - 1) ? true : false;
	}
	
	public V top() {
		if(isEmpty())
			return null;
		return array[top];
	}
	
	public void push(V value) {
		if(isFull()) {
			System.out.println("Stack is already Full");
			return;
		}
		array[++top] = value;
	}
	
	public V pop() {
		if(isEmpty()) {
			System.out.println("Stack is already Empty");
			return null;
		}
		return array[top--];
	}
	
	@Override
	public String toString() {
		if(isEmpty()) {
			return "Stack is Empty";
		}
		String output = "";
		for(int i = 0; i < top ; i++) {
			output += array[i].toString() + " ";
		}
		return output;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack stack = new Stack(10);
		System.out.println("Stack isEmpty? : " + stack.isEmpty());
		
		System.out.println("Stack isFull? : " + stack.isFull());
		
		System.out.println("Stack : " + stack.toString());
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		
		System.out.println("Stack : " + stack.toString());
		
		stack.pop();
		
		System.out.println("Stack : " + stack.toString());

	}

}
