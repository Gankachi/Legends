package story;

public class BadGuy extends Character {
	
	public BadGuy() {
		super();
		motivation = Rand.motivation("bad", gender);
	}
}
