/**
 * 
 */
package stratego.util;

/**
 * The StrategoCoordinate identifies a specific hex on the Stratego board.
 * 
 * @author David Keeley
 * @version Mar 4, 2013
 */
public interface StrategoCoordinate
{
	/**
	 * @return the X-coordinate
	 */
	int getX();

	/**
	 * @return the Y-coordinate
	 */
	int getY();
}
