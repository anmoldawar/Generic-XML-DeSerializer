package genericDeser.util;

/**
 * 
 * @author anmol
 *
 */

public class Logger{
    public static enum DebugLevel {CONSTRUCTORCALLED,ENTRYTOHASHMAP, PRINTOUTPUT};

    private static DebugLevel debugLevel;

    /**Method to set the debuglevel to their corresponding enum
     * 
     * @param levelIn - integer value taken from command line
     */
   
    public static void setDebugValue (int levelIn) {
    	switch (levelIn) {
    		case 2: debugLevel = DebugLevel.CONSTRUCTORCALLED; break;
    		case 1: debugLevel = DebugLevel.ENTRYTOHASHMAP; break;
    		case 0: debugLevel = DebugLevel.PRINTOUTPUT; break;
		}
    }

    /**Method to set the debug level value
     * 
     * @param levelIn
     */
    public static void setDebugValue (DebugLevel levelIn) {
    	debugLevel = levelIn;
    }
    
    /**
     * 
     * @param message- message to be printed
     * @param levelIn- enum value corresponding to that integer
     */
    public synchronized static void writeMessage (String message  , DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

    public String toString() {
	return "Debug Level is " + debugLevel;
    }
}
