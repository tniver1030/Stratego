/**
 * 
 */

package stratego.common;

/**
 * The StrategoException is the Exception that is thrown for any error that occurs during the
 * 
 * @author David Keleey
 * @version Mar 4, 2013
 */
public class StrategoException extends Exception
{
	/**
	 * Every instance of this exception must have a message describing the exception.
	 * 
	 * @param message
	 *            the string describing the error causing the exception
	 */
	public StrategoException(String message)
	{
		super(message);
	}

	/**
	 * An exception that was caused by some other exception.
	 * 
	 * @param message
	 *            the string describing the error causing the exception
	 * @param cause
	 *            the error that caused this exception
	 */
	public StrategoException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
