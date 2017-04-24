package util;

/**
 * Gender class creating genders to manage different forms of words depending on the gender (ex : possessive).
 * @author kevin
 *
 */
public class Gender {
	private String name;
	private String nominative;
	private String accusative;
	private String possessive;
	private char id;
	
	/**
	 * Constructs a Gender. Currently supported genders are :<br>
	 * M : Male<br>
	 * F : Female<br>
	 *  
	 * @param i	Gender ID
	 */
	public Gender(char i){
		switch(i){
		case 'M':
			name = "male";
			nominative = "he";
			accusative = "him";
			possessive = "his";
			break;
		case 'F':
			name = "female";
			nominative = "she";
			accusative = "her";
			possessive = "her";
			break;
		}
		id = i;
	}
	
	/**
	 * Gets the name of the gender.
	 * @return	Name of the gender
	 */
	public String name() {
		return name;
	}

	/**
	 * Returns the nominative form of the gender (ex : they).
	 * @return	Nominative form
	 */
	public String nominative() {
		return nominative;
	}

	/**
	 * Returns the accusative form of the gender (ex: them).
	 * @return	Accusative form
	 */
	public String accusative() {
		return accusative;
	}

	/**
	 * Returns the possessive form of the gender (ex: their).
	 * @return	Possessive form
	 */
	public String possessive() {
		return possessive;
	}
	
	/**
	 * Returns the ID of the gender (ex: U).
	 * @return	Gender ID
	 */
	public char id() {
		return id;
	}
}
