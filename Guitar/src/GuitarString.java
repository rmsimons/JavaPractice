//Robert Simons
//creates a GuitarString object to be used by Guitar37

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class GuitarString {
	public static final double ENERGY_DECAY_FACTOR = 0.996;
	private static final double SAMPLING_RATE = StdAudio.SAMPLE_RATE;
	private Queue<Double> ringBuffer;

	//creates a ringBuffer
	public GuitarString(double frequency) {
		int N = (int) Math.rint(SAMPLING_RATE / frequency);
		if (frequency <= 0 || N < 2) {
			throw new IllegalArgumentException();
		}
		ringBuffer = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			ringBuffer.add(0.0);
		}
	}

	//this constructor is used for testing purposes only
	public GuitarString(double[] init) {
		if (init.length < 2) {
			throw new IllegalArgumentException();
		}
		ringBuffer = new LinkedList<>();
		for (int i = 0; i < init.length; i++) {
			ringBuffer.add(init[i]);
		}
	}

	//simulates excitation for the string
	public void pluck() {
		int size = ringBuffer.size();
		ringBuffer.clear();
		for (int i = 0; i < size; i++) {
			double random = ThreadLocalRandom.current().nextDouble(-0.5, 0.5);
			ringBuffer.add(random);
		}
	}

	//applies the Karplus-Strong update once
	public void tic() {
		double front = ringBuffer.remove();
		double next = ringBuffer.peek();
		double karplusStrong = ENERGY_DECAY_FACTOR * ((front + next) / 2);
		ringBuffer.add(karplusStrong);
	}

	//returns the sound at the front of the queue
	public double sample() {
		return ringBuffer.peek();
	}
}
