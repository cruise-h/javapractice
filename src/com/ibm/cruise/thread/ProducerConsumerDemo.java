package com.ibm.cruise.thread;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int maxSize = 10;
		new Producer(queue, maxSize, "peoducer1").start();
		new Producer(queue, maxSize, "peoducer2").start();
		new Consumer(queue, maxSize, "consume1").start();
		new Consumer(queue, maxSize, "consume2").start();
		

	}

}
