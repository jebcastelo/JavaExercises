package com.lmig;

import java.util.Random;

abstract public class LivingThing {
	public String name;
	public double health;
	public double attackPower;

	// constructor
	public LivingThing(String name, double health, double attackPower) {
		this.name = name;
		this.health = health;
		this.attackPower = attackPower;
	}

	public void takeDamage(double impactHealth) {
		this.health = this.health - impactHealth;
	}

	public void attack(LivingThing target) {
		target.takeDamage(this.attackPower);
	}

	public static void main(String[] args) {
		LivingThing[] creatures;
		creatures = new LivingThing[4];
		// creatures[0] = new Ogre();
		// creatures[1] = new Rat();

		creatures[0] = new Rat("Jeb", 100, 1, 10);
		creatures[1] = new Rat("Jake", 200, 1, 2);
		creatures[2] = new Ogre("Jess", 300, 1, 10);
		creatures[3] = new Ogre("Jason", 400, 1, 2);

		Hero ravi = new Hero("Hero", 10, 10);
		ravi.fight(creatures);
		// jeb.attack(jake);
		// jason.attack(jess);
		// System.out.println(jake.health);
		// System.out.println(jason.health);
	}
}

// Rat class
class Rat extends LivingThing {
	// contsructor
	private double hairLength;

	public Rat(String name, double health, double attackPower, double hairLength) {
		super(name, health, attackPower);
		this.hairLength = hairLength;
	}

	public void attack(LivingThing target) {
		Random r = new Random();
		double d = r.nextDouble();
		target.takeDamage(this.attackPower);
	}
}

// Ogre class
class Ogre extends LivingThing {
	// constructor
	private double height;

	public Ogre(String name, double health, double attackPower, double height) {
		super(name, health, attackPower);
		this.height = height;
	}

	public void takeDamage(double impactHealth) {
		this.health = this.health - impactHealth;
	}

	public void attack(LivingThing target) {
		Random r = new Random();
		double d = r.nextDouble();
		target.takeDamage(this.attackPower * d);
	}
}

// Goblin class
class Goblin extends LivingThing {
	// constructor
	private double size;

	public Goblin(String name, double health, double attackPower, double size) {
		super(name, health, attackPower);
	}

	public void takeDamage(double impactHealth) {
		this.health = this.health - impactHealth;
	}

	public void attack(LivingThing target) {
		Random r = new Random();
		double d = r.nextDouble();
		target.takeDamage(this.attackPower * d);
	}

}

// Hero class
class Hero extends LivingThing {
	// constructor
	private double size;

	public Hero(String name, double health, double attackPower) {
		super(name, health, attackPower);
	}

	public void takeDamage(double impactHealth) {
		this.health = this.health - impactHealth;
	}

	public void attack(LivingThing target) {
		Random r = new Random();
		double d = r.nextDouble();
		target.takeDamage(this.attackPower * (d *100));
	}

	public void fight(LivingThing[] creatures) {
		boolean creatureAlive = true;
		while (creatureAlive) {
			for (int i = 0; i < creatures.length; i++) {
			// living things assigned to c variable 
				LivingThing c = creatures[i];
				this.attack(c);
				c.attack(this);
				System.out.println("Creature " + c.name + ": " + c.health);
			}
			if (this.health <= 0) {
				System.out.println("Hero is dead!");
				return; 
			}
			creatureAlive = false;
			for (int i = 0; i < creatures.length; i++){
				if (creatures[i].health > 0){
					creatureAlive = true;
				}
			}
		}
	}

}
