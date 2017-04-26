package story;

public class BadGuy extends Character {
	
	public BadGuy(Culture cult) {
		super(cult);
		motivation = Rand.motivation("bad", gender);
	}
}
