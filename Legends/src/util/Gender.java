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
	 * U : Undefine
	 * 
	 * @param i	Gender ID
	 */
	public Gender(char i){
		switch(id){
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
		case 'U':
			name = "undefined";
			nominative = "they";
			accusative = "them";
			possessive = "their";
			break;
		}
	}
	
	/**
	 * Gets the name of the gender.
	 * @return	Name of the gender
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the nominative form of the gender (ex : they).
	 * @return	Nominative form
	 */
	public String getNominative() {
		return nominative;
	}

	/**
	 * Returns the accusative form of the gender (ex: them).
	 * @return	Accusative form
	 */
	public String getAccusative() {
		return accusative;
	}

	/**
	 * Returns the possessive form of the gender (ex: their).
	 * @return	Possessive form
	 */
	public String getPossessive() {
		return possessive;
	}
	
	/**
	 * Returns the ID of the gender (ex: U).
	 * @return	Gender ID
	 */
	public char getId() {
		return id;
	}
}
