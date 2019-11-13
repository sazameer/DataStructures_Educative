package com.zam.ds.stacksQueues;

public class Queue<V> {
	
	private int maxSize;
	private V[] array;
	private int front;
	private int back;
	private int currentSize;
	
	public Queue(int maxSize){
		this.maxSize = maxSize;
		array = (V[])new Object[maxSize];
		front = 0;
		back = 0;
		currentSize = 0;
	}
	
	public int getMaxSize() {
		return maxSize;
	}
	
	public boolean isEmpty() {
		return currentSize == 0;
	}
	
	public boolean isFull() {
		return currentSize == maxSize;
	}
	
	public V top() {
		return array[front];
	}
	
	public void enQueue(V newElement) {
		if(isFull())
			return;
		back = (back + 1) % maxSize;
		array[back] = newElement;
		currentSize++;
	}
	
	public V deQueue() {
		if(isEmpty())
			return null;
		
		V temp = array[front];
		front = (front + 1) % maxSize;
		currentSize--;
		return temp;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
