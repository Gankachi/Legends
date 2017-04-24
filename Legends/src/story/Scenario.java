package story;

public class Scenario {
	
	GoodGuy hero;
	BadGuy villain;
	String kingdom;
	
	public Scenario(){
		hero = new GoodGuy();
		villain = new BadGuy();
		kingdom = Rand.kingdom();
	}
	
	public void plot(){
		System.out.println("Basic Plot : ");
		System.out.println("The kingdom of "+kingdom+" was a calm and peaceful place until "+villain.name()+", the evil "+villain.job()+" arrived, "
		+ "planning to "+villain.motivation()+" !");
		System.out.println("Unbeknownst to "+villain.gender().accusative()+", there was also in "+kingdom+" a hero! "+hero.name()+", a perfect "+hero.job()+", "
		+ "took on to fight the monstrous "+villain.name()+", hoping to "+hero.motivation()+"!");
	}
}
