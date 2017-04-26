package story;

public class Scenario {
	
	private Culture culture;
	private GoodGuy hero;
	private BadGuy villain;
	private Territory location;
	
	public Scenario(){
		culture = Rand.culture();
		hero = new GoodGuy(culture);
		villain = new BadGuy(culture);
		location = Rand.territory(culture);
	}
	
	public void plot(){
		System.out.println("Basic Plot : ");
		System.out.println("The "+culture.name()+" kingdom of "+location.name()+" was a calm and peaceful place until "+villain.name()+", the evil "+villain.job()+", arrived "
		+ "with a plan to "+villain.motivation()+" !");
		System.out.println("Unbeknownst to "+villain.gender().accusative()+", there was also in "+location.name()+" a hero! "+hero.name()+", a great "+hero.job()+", ");
		System.out.println("took on to fight the monstrous "+villain.name()+", hoping to "+hero.motivation()+"!");
	}
}
