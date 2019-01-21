package test;

import java.util.ArrayList;
import java.util.Random;

public class ProducerConsumerCustom {

	public static void main(String[] args) throws InterruptedException {

		ProducerConsumer t = new ProducerConsumer();

		Thread producer = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					t.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread consumer = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					t.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		producer.start();
		consumer.start();
		producer.join();
		consumer.join();
	}
}

class ProducerConsumer {

	ArrayList<Integer> buffer = new ArrayList<Integer>();

	public void produce() throws InterruptedException {
		while (true) {
			synchronized (this) {
				if (buffer.size() == 4)
					wait();
				Integer num = new Random().nextInt(100);
				buffer.add(num);
				System.out.println("Number addded:" + num);
				notify();
				Thread.sleep(7000);
			}
		}
	}

	public void consume() throws InterruptedException {

		while (true) {
			synchronized (this) {
				if (buffer.isEmpty())
					wait();
				Integer num = buffer.remove(0);
				System.out.println("Number removed:" + num);
				notify();
				Thread.sleep(7000);

			}
		}
	}
}
