package genericDeser.util;

public class First {
	private int IntValue;
	private String StringValue; 
	private short ShortValue;
	private float FloatValue;

	/**
	 * Empty Constructor 
	 */
	public First(){
	
		Logger.writeMessage("Constructor of First Called", Logger.DebugLevel.CONSTRUCTORCALLED);
	}
	
	/**
	 * getter for IntValue
	 * @return IntValue
	 */
	public int getIntValue(){
	
		return IntValue;
	}
	/**
	 * getter for ShortValue
	 * @return ShortValue
	 */
	public short getShortValue(){
		
		return ShortValue;
	}
	/**
	 * getter for FloatValue
	 * @return FloatValue
	 */
	public float getFloatValue(){
		
		return FloatValue;
	}
	/**
	 * getter for StringValue
	 * @return StringValue
	 */
	public String getStringValue(){
		
		return StringValue;
	}

	/**
	 * setter for IntValue
	 * 
	 */
	public void setIntValue(int iIn){
		this.IntValue=iIn;
	}

	/**
	 * setter for ShortValue
	 * 
	 */
	public void setShortValue(short sIn){
		this.ShortValue=sIn;
	}

	/**
	 * setter for FloatValue
	 * 
	 */
	public void setFloatValue(float fIn){
		this.FloatValue=fIn;
	}

	/**
	 * setter for StringValue
	 * 
	 */
	public void setStringValue(String strIn){
		this.StringValue=strIn;
	}

	
	/**
	 * Overridden hashCode method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(FloatValue);
		result = prime * result + IntValue;
		result = prime * result + ShortValue;
		result = prime * result + ((StringValue == null) ? 0 : StringValue.hashCode());
		
		return result;
	}

	/**
	 * Overidden equals method 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		First other = (First) obj;
		if (Float.floatToIntBits(FloatValue) != Float.floatToIntBits(other.FloatValue))
			return false;
		if (IntValue != other.IntValue)
			return false;
		if (ShortValue != other.ShortValue)
			return false;
		if (StringValue == null) {
			if (other.StringValue != null)
				return false;
		} else if (!StringValue.equals(other.StringValue))
			return false;


		return true;
	}


}
