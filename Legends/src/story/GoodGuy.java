package story;

public class GoodGuy extends Character {

	public GoodGuy() {
		super();
		motivation = Rand.motivation("good", gender);
	}
}
