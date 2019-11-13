package com.zam.ds.stacksQueues;

public class Queue<V> {

	private int maxSize;
	private V[] array;
	private int front;
	private int back;
	private int currentSize;

	@SuppressWarnings("unchecked")
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
		if(isFull()) {
			System.out.println("Queue Full, Can't Insert : " + newElement);
			return;
		}

		array[back] = newElement;
		back = (back + 1) % maxSize;
		currentSize++;
	}

	public V deQueue() {
		if(isEmpty()) {
			System.out.println("Queue Empty, Can't deQueue");
			return null;
		}

		V temp = array[front];
		front = (front + 1) % maxSize;
		currentSize--;
		return temp;
	}

	public String toString() {
		String output = "";
		if(currentSize == 0) {
			output = "Empty Queue";
		} else {
			for(int i = front, j = 0; j < currentSize ; j++ ) {
				output += array[i % maxSize] + " ";
				i++;
			}
		}

		return output;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue queue = new Queue(5);
		System.out.println("isQueue Empty : " + queue.isEmpty());
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		System.out.println(queue.toString());
		queue.deQueue();
		queue.enQueue(40);
		queue.enQueue(50);
		queue.enQueue(60);
		queue.enQueue(70);
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		System.out.println(queue.toString());
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		//queue.enQueue(40);
		System.out.println(queue.toString());
	}

}
