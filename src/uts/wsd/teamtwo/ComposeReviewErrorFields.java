package uts.wsd.teamtwo;

/**
 * Defines the type(s) of errors that occurred for
 * the review composition form.
 * @author Deinyon L Davies (11688025)
 */
public enum ComposeReviewErrorFields
{
	NONE(0),
	TITLE_MISSING(1 << 0),
	TITLE_FORMAT(1 << 1),
	RATING_MISSING(1 << 2),
	RATING_FORMAT(1 << 3),
	MESSAGE_MISSING(1 << 4);
	
	private int numVal;
	
	ComposeReviewErrorFields(int numVal)
	{
		this.numVal = numVal;
	}
	
	public int getNumVal()
	{
		return numVal;
	}
}
