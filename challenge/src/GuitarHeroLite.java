/*******************************************************************************
 *
 *  Plays two guitar strings (concert A and concert C) when the user either
 *  types the corresponding keys in an interactive window.
 *
 ******************************************************************************/
 
public class GuitarHeroLite {
 
    public static void main(String[] args) {
 
        // create two guitar strings, for concert A and concert C
        double CONCERT_A = 110.0;
        double CONCERT_C = CONCERT_A * Math.pow(2, 3.0/12.0);
        double CONCERT_B = CONCERT_A * Math.pow(2, 2.0/12.0);
        GuitarString stringA = new GuitarString(CONCERT_A);
        GuitarString stringC = new GuitarString(CONCERT_C);
        GuitarString stringB = new GuitarString(CONCERT_B);
 
        // the main input loop
        Keyboard keyboard = new Keyboard();
        while (true) {
 
            // check if the user has played a key; if so, process it
            if (keyboard.hasNextKeyPlayed()) {
 
                // the key the user played
                char key = keyboard.nextKeyPlayed();
 
                // pluck the corresponding string
                if (key == 'v') { stringA.pluck(); }
                if (key == 'n') { stringC.pluck(); }
                if (key == 'b') { stringB.pluck(); }
            }
 
            // compute the superposition of the samples
            double sample = stringA.sample() + stringC.sample() + stringB.sample();
 
            // play the sample on standard audio
            StdAudio.play(sample);
 
            // advance the simulation of each guitar string by one step
            stringA.tic();
            stringC.tic();
            stringB.tic();
        }
    }
}