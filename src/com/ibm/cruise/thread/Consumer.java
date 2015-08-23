package com.ibm.cruise.thread;

import java.util.Queue;

public class Consumer extends Thread {
	private Queue<Integer> queue;
	private int maxSize;

	public Consumer(Queue<Integer> queue, int maxSize, String name) {
		super(name);
		this.queue = queue;
		this.maxSize = maxSize;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				while (queue.isEmpty()) {
					try {
						System.out.println("Queue is empty," + "Consumer thread is waiting" + " for producer thread to put something in queue");
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				int i = queue.remove();
				System.out.println(this.getName() + " Consuming value : " + i);
				queue.notifyAll();
			}
		}
	}

}
