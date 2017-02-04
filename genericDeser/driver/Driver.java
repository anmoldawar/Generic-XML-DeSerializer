package genericDeser.driver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import genericDeser.fileOperations.FileProcessor;
import genericDeser.util.Logger;
import genericDeser.util.PopulateObjects;

/**
 * Main driver class
 * @author anmol
 *
 */
public class Driver {

	public static void main(String[] args) {
		
		/**
		 * Input arguments validation
		 */
		if(args.length != 2){
			System.err.println("Please enter the correct number of arguments..!");
			System.exit(0);
		}
		
		int DEBUG_VALUE=0;
		String inputFile = args[0];
		
		/**
		 * checking if the debug value
		 * passed is an integer
		 */
		
		if(isInteger(args[1])){
			DEBUG_VALUE = Integer.parseInt(args[1]);
		}
		else{
			System.err.println("DEBUG_VALUE should be an Integer");
			System.exit(1);
		}
		
	
		BufferedReader br = null;
		FileInputStream is;
		InputStreamReader isr;
		
		try {
			is = new FileInputStream(inputFile);
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
		} catch (FileNotFoundException e){
			System.err.println("Input file not present");
			System.exit(1);
		}
		
		
		Logger.setDebugValue(DEBUG_VALUE);
	
		FileProcessor fpobj = new FileProcessor(br);
		
		PopulateObjects po = new PopulateObjects(fpobj);
		
		po.deserObjects();
		
	}

	/**
	 * Method to check if the entered
	 * debug value is an integer
	 * @param string
	 * @return true or false
	 */
	private static boolean isInteger(String s) {
		try{
			Integer.parseInt(s);
		}
		catch(NumberFormatException e){
			//e.printStackTrace();
			return false;
		}
		return true;
	}
}
