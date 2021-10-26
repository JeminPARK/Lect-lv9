package model;

import controller.Game;
import model.Player;
import model.Unit;

public class Zombie extends Unit implements Attack, Damageable {
	private int dam;
	
	public Zombie(String name, int hp, int att, int def, int position) {
		super(name, hp, att, def, position);
	}
	@Override
	public void attack(Unit target) {
		this.dam = (this.getAtt() - target.getDef())*(Game.rand.nextInt(150)+50/100);
		if(this.dam <= 0) {
			this.dam = 1;
		}
		System.out.printf("%s�� ����!\n", this.getName());
		System.out.printf("%d�� ������!\n", dam);
		((Player) target).damage(this.dam);
		
	}
	@Override
	public void damage(int attack) {
		this.setHp(this.getHp()-attack);
		System.out.println(this.getName()+"�� ���� ü��: "+this.getHp());
		
	}
}
