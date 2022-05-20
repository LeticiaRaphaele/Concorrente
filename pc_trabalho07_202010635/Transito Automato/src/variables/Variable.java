package variables;

import java.util.concurrent.Semaphore;

public class Variable {

    public static Semaphore VRednGreen = new Semaphore(1);
    public static Semaphore HRednGreen = new Semaphore(1);

    public static Semaphore V1BlacknPurple = new Semaphore(1);
    public static Semaphore V2BlacknPurple = new Semaphore(1);
    public static Semaphore H1BlacknPurple = new Semaphore(1);


    //3 cars using the same street
    public static Semaphore HBlacknPurpleGreen = new Semaphore(1); 
    public static Semaphore VBlacknPurpleGreen = new Semaphore(1); 
}
