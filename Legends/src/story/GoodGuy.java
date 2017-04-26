package story;

public class GoodGuy extends Character {

	public GoodGuy(Culture cult) {
		super(cult);
		motivation = Rand.motivation("good", gender);
	}
}
