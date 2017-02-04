package genericDeser.util;

public class Second {
	private int IntValue;
	private boolean BooleanValue; 
	private double DoubleValue;

	/**
	 * Empty constructor
	 */
	public Second(){
		Logger.writeMessage("Constructor of Second Called", Logger.DebugLevel.CONSTRUCTORCALLED);
	}
	
	/**
	 * getter for IntValue
	 * @return IntValue
	 */
	public int getIntValue(){
	
		return IntValue;
	}
	
	/**
	 * getter for DoubleValue
	 * @return DoubleValue
	 */
	public double getDoubleValue(){
		
		return DoubleValue;
	}
	/**
	 * getter for BooleanValue
	 * @return BooleanValue
	 */
	public boolean getBooleanValue(){
		
		return BooleanValue;
	}
	
	/**
	 * setter for IntValue
	 * 
	 */
	public void setIntValue(int iIn){
		this.IntValue=iIn;
	}
	

	/**
	 * setter for DoubleValue
	 * 
	 */
	public void setDoubleValue(double dIn){
		this.DoubleValue=dIn;
	}
	

	/**
	 * setter for BooleanValue
	 * 
	 */
	public void setBooleanValue(boolean bIn){
		this.BooleanValue=bIn;
	}
	


	/**
	 * Overridden hashCode method
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		final int prime = 31;
        int result = 1;
        result = prime * result + IntValue;
        result = prime * result + new Double(DoubleValue).hashCode();
        result = prime * result + new Boolean(BooleanValue).hashCode();

        return result;
	}

	/**
	 * Overridden equals method
	 */
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub

		if (arg0 == this) 
			return true;
        if (!(arg0 instanceof Second)) {
            return false;
        }

        Second second = (Second) arg0;

        return  second.BooleanValue==BooleanValue &&
        		second.IntValue == IntValue &&
        		second.DoubleValue == DoubleValue;
        
	}

}

