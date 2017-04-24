package story;

import java.util.Random;
import util.*;

/**
 * Generates random data for story creation.
 * @author kevin
 *
 */
public class Rand {
	Random rdn = new Random();
	
	char genders[] = {'U','F','M'};
	private String maleNames[] = {
		"Bob","John","Philip","Georges"
	};
	private String femaleNames[] = {
		"Lily","Cynthia","Jenny","Tya"
	};
	
	private String jobs[] = {
		"cabbage seller","cleric","warrior","mage"
	};
	
	private String goodMotivation[] = {
		"avenge <pos> father's death","avenge <pos> mother's death",
		"get back <pos> cat","make the world a better place",
		"get a better life"
	};
	
	private String badMotivation[] = {
		"take over the world","destroy the world","create an age of darkness",
		"spread chaos","eat all the cookies"
	};
	
	/**
	 * Returns a random Gender.
	 * @return	Random Gender.
	 */
	public Gender gender(){
		return new Gender(genders[rdn.nextInt(genders.length)]);
	}
	
	/**
	 * Returns a random name.
	 * @param g	Gender of the name
	 * @return	Name
	 */
	public String name(Gender g){
		String res = "";
		switch(g.getId()){
		case 'M':
			res = maleNames[rdn.nextInt(maleNames.length)];
			break;
		case 'F':
			res = femaleNames[rdn.nextInt(femaleNames.length)];
			break;
		case 'U':
			if (rdn.nextInt(2) == 1)
				res = maleNames[rdn.nextInt(maleNames.length)];
			else
				res = femaleNames[rdn.nextInt(femaleNames.length)];
		default:
			res = "NULL";
		}
		
		return res;
	}
	
	/**
	 * Returns a random job
	 * @param age	Age of the character
	 * @return	Job of the character
	 */
	public String job(int age){
		String res = "";
		if (age < 16)
			res = "child";
		else if (age < 60)
			res = jobs[rdn.nextInt(jobs.length)];
		else
			res = "elder";
		return res;
	}
	/**
	 * Returns a random life goal. Accepted types are:<br>
	 * "good"	: Heroic motivations
	 * "bad"	: Villainous motivations
	 * @param type Type of motivation to return
	 * @return	motivation
	 */
	public String motivation(String type){
		String res = "";
		switch(type){
		case "good":
			res = goodMotivation[rdn.nextInt(goodMotivation.length)];
			break;
		case "bad":
			res = badMotivation[rdn.nextInt(badMotivation.length)];
			break;
		default:
			res = "live a peaceful life";
		}
		return res;
	}
}
