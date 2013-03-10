/**
 * 
 */

package stratego.util;

/**
 * This enumeration is used to define the pieces used in Stratego.
 * 
 * @version Jan 12, 2013
 */
public enum StrategoPieceType
{
	FLAG("Flag", "F", 10), 
	BOMB("Bomb", "B", 0), 
	SPY("Spy", "S" , 9), 
	ONE("One", "1" , 1), 
	TWO("Two", "2" , 2), 
	THREE("Three", "3", 3),
	FOUR("Four","4", 4),
	FIVE("Five","5", 5),
	SIX("Six","6", 6),
	SEVEN("Seven","7", 7),
	EIGHT("Eight","8", 8);
	
	private final String printableName;
	private final String symbol;
	private final int value;
	
	/**
	 * The constructor for each enumerable item sets up the state so thatS
	 * the symbol for each item and the printable name are set up.
	 * 
	 * @param printableName the value returned from toString
	 * @param symbol a one character string that can be used when printing the board.
	 * @param value is the numerical value for calculating combat
	 */
	private StrategoPieceType(String printableName, String symbol, int value)
	{
		this.printableName = printableName;
		this.symbol = symbol;
		this.value = value;
	}

	/**
	 * @return the printableName
	 */
	public String getPrintableName()
	{
		return printableName;
	}
	/**
	 * @return the printableName
	 */
	public int getValue()
	{
		return value;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol()
	{
		return symbol;
	}
	
	
	@Override
	public String toString()
	{
		return printableName;
	}
}
