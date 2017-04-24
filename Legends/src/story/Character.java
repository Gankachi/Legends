package story;

import util.*;

public abstract class Character {
	protected Gender gender;
	protected String name;
	protected int age;
	protected String job;
	protected String motivation;
	
	public Character(){
		gender 		= Rand.gender();
		name 		= Rand.name(gender);
		age 		= Rand.age(); 
		job			= Rand.job(age);
		motivation	= Rand.motivation("", gender);
	}

	public Gender gender() {
		return gender;
	}

	public String name() {
		return name;
	}

	public int age() {
		return age;
	}

	public String job() {
		return job;
	}

	public String motivation() {
		return motivation;
	}
}
