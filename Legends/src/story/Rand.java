package story;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	public static Culture culture(){
		String sql="select id,name from cultures order by random() limit 1";
		Culture res = new Culture(0,"NULL");
		try (Connection conn = connect();
			Statement stmt  = conn.createStatement();
			ResultSet rs    = stmt.executeQuery(sql)){

			// loop through the result set
	        while (rs.next())
	        	res = new Culture(rs.getInt("id"),rs.getString("name"));
	        conn.close();
	        
		} catch (SQLException e) {
			System.out.println(e.getMessage());
	    }
		return res;
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
	public static String name(Gender g, Culture culture){
		String sql="select value from names where id in (select id from names where gender = ? and culture = ? order by random() limit 1)";
		String res = "";
		try (Connection conn = connect();
			PreparedStatement pstmt  = conn.prepareStatement(sql);
			){
			pstmt.setString(1,java.lang.Character.toString(g.id()));
			pstmt.setInt(2, culture.id());
			ResultSet rs    = pstmt.executeQuery();
			while (rs.next())
	        	res = rs.getString("value");
			conn.close();
	        
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
	
	public static Territory territory(Culture c){
		
		String sql = "Select name,size "
				   + "from territories where id in "
				   + "(select id from territories where culture = ? order by random() limit 1)";
		Territory territory = new Territory(c,"","");
		try(
			Connection conn = connect();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, c.id());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				territory = new Territory(c,rs.getString("name"),rs.getString("size"));
			}
			conn.close();
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
		return territory;
	}
}
