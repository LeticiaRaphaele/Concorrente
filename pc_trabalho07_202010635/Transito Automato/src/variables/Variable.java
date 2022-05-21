package variables;

import java.util.concurrent.Semaphore;

public class Variable {

    public static Semaphore VRednGreen = new Semaphore(1);
    public static Semaphore HRednGreen = new Semaphore(1);    

    public static Semaphore VRednBlack = new Semaphore(1);
    public static Semaphore HRednBlack = new Semaphore(1);

    
    public static Semaphore V1BlacknPurple = new Semaphore(1);
    public static Semaphore V2BlacknPurple = new Semaphore(1);
    public static Semaphore H1BlacknPurple = new Semaphore(1);

    public static Semaphore H1BlacknGreen = new Semaphore(1);


//Yellow - 2 elements
    public static Semaphore VGreenYellow = new Semaphore(1); //green and yellow

    //black n yellow
    public static Semaphore VYellownBlack = new Semaphore(1);
    public static Semaphore V2YellownBlack = new Semaphore(1);
    public static Semaphore HYellownBlack = new Semaphore(1);

    public static Semaphore VYellownPurple = new Semaphore(1); //yellow n purple

    public static Semaphore VYellownnRed = new Semaphore(1); // yellow n red
    
//Yellow - 3 elements
    //black n yellow n red
    public static Semaphore VBlackRednYellow = new Semaphore(1); 
    public static Semaphore HBlackRednYellow = new Semaphore(1); 

    //purple n green n yellow
    public static Semaphore HPurpleGreenYellow = new Semaphore(1);
    
    //3 cars using the same street
    public static Semaphore HBlacknPurpleGreen = new Semaphore(1); 
    public static Semaphore VBlacknPurpleGreen = new Semaphore(1); 



}
