package lab2;
/**
 * ZeroDenominatorException - a runtime exception that signals there was a zero denominator
 * for a Rational number.
 * 
 */
public class ZeroDenominatorException extends RuntimeException
{

	public ZeroDenominatorException(String reason)
	{
		super(reason);
	}
}
