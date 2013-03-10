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
	FLAG("Flag", "F"), 
	BOMB("Bomb", "B"), 
	SPY("Spy", "S"), 
	ONE("One", "1"), 
	TWO("Two", "2"), 
	THREE("Three", "3"),
	FOUR("Four","4"),
	FIVE("Five","5"),
	SIX("Six","6"),
	SEVEN("Seven","7"),
	EIGHT("Eight","8");
	
	private final String printableName;
	private final String symbol;
	
	/**
	 * The constructor for each enumerable item sets up the state so that
	 * the symbol for each item and the printable name are set up.
	 * 
	 * @param printableName the value returned from toString
	 * @param symbol a one character string that can be used when printing the board.
	 */
	private StrategoPieceType(String printableName, String symbol)
	{
		this.printableName = printableName;
		this.symbol = symbol;
	}

	/**
	 * @return the printableName
	 */
	public String getPrintableName()
	{
		return printableName;
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
