package story;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;
import util.*;

/**
 * Generates random data for story creation. Uses lib/data.db as source for data.
 * @author Gankachi
 *
 */
public class Rand {
	
	private static Random rdn = new Random();
	
	private static char genders[] = {'F','M'};
	private static String maleNames[] = {
		"Bob","John","Philip","Georges","Jack","John","Mark","Jimmy","Luther","Carter","Larry","Harry","Cedric","Matthias","Timothy"
	};
	private static String femaleNames[] = {
		"Lily","Cynthia","Jenny","Tya","Martha","Joana","Eleanor","Mary","Christina","Lea","Margaret","Astrid","Maeva","Courtney","Jessie"
	};
	
	private static String jobs[] = {
		"cabbage seller","cleric","warrior","mage","teacher","master","carpet merchant", "thief","king",
	};
	
	private static String goodMotivation[] = {
		"avenge <pos> father's death","avenge <pos> mother's death",
		"get back <pos> cat","make the world a better place",
		"get a better life"
	};
	
	private static String badMotivation[] = {
		"take over the world","destroy the world","create an age of darkness",
		"spread chaos","eat all the cookies"
	};
	
	private static String kingdoms[] = {
			"Elasia","Al'Hakmar","Chiu-Li","Feralios","Antroy"
	};
	
	private static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:/lib/data.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
	
	/**
	 * Returns a random age.
	 * @return	Age
	 */
	public static int age(){
		return 13 + rdn.nextInt(80 - 13);
	}
	
	/**
	 * Returns a random Gender.
	 * @return	Random Gender.
	 */
	public static Gender gender(){
		return new Gender(genders[rdn.nextInt(genders.length)]);
	}
	
	/**
	 * Returns a random name.
	 * @param g	Gender of the name
	 * @return	Name
	 */
	public static String name(Gender g){
		String res = "";
		switch(g.id()){
		case 'M':
			res = maleNames[rdn.nextInt(maleNames.length)];
			break;
		case 'F':
			res = femaleNames[rdn.nextInt(femaleNames.length)];
			break;
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
	public static String job(int age){
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
	public static String motivation(String type, Gender g){
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
		res = res.replaceAll("<nom>", g.nominative());
		res = res.replaceAll("<acc>", g.accusative());
		res = res.replaceAll("<pos>", g.possessive());
		return res;
	}
	
	public static String kingdom(){
		return kingdoms[rdn.nextInt(kingdoms.length)];
	}
}
