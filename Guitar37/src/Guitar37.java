//Robert Simons
//Simulates a guitar with 37 strings
//plays notes

public class Guitar37 implements Guitar {
    public static final String KEYBOARD =
        "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";  // keyboard layout
    public static final int NUMBER_OF_STRINGS = 37;
    private GuitarString[] instrument;
    private int count;

    //creates 37 guitar strings of varying frequencies
    public Guitar37() {
    	count = 0;
    	instrument = new GuitarString[NUMBER_OF_STRINGS];
    	for (int i = 0; i < NUMBER_OF_STRINGS; i++) {
    		instrument[i] = new GuitarString(Math.pow(2, ((i - 24.0) / 12.0)) * 440.0);
    	}
    }

    //allows the user to specify which note to play
    public void playNote(int pitch) {
    	if (pitch > -13 && pitch < 25) {
    	instrument[pitch + 12].pluck();
    	}
    }

    //returns true if the specified key is available to play
    public boolean hasString(char key) {
    	return (KEYBOARD.indexOf(key) != -1);
    }

    //allows user to specify a character that indicates which note to play
    public void pluck(char key) {
    	if (!hasString(key)) {
    		throw new IllegalArgumentException("Not a valid key");
    	} else {
    		instrument[KEYBOARD.indexOf(key)].pluck();
    	}
    	
    }

    //calculates the sum of all the strings in the guitar
    public double sample() {
    	double sum = 0.0;
    	for (GuitarString note: instrument) {
    		sum += note.sample();
    	}
    	return sum;
    }

    //advances the strings by one tic
    public void tic() {
    	for (GuitarString note: instrument) {
    		note.tic();
    	}
    	count++;
    }

   //returns the number of tics performed
    public int time() {
    	return count;
    }
}





