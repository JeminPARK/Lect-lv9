package model;

public class ZombieKing extends Unit{
	int shield;
	public ZombieKing(String name, int hp, int att, int def, int position, int shield) {
		super(name, hp, att, def, position);
		this.shield = shield;
	}
	public int getShield() {
		return this.shield;
	}
	public void setShield(int shield) {
		this.shield = shield;
	}
	public void attack(Unit target) {
		if(rand.nextInt(100)>74) {
			int dam = (this.getAtt() - target.getDef())*(rand.nextInt(150)+50)/100;
			if(dam <= 0 ) {
				dam = 1;
				
			}
			dam*=2;
			System.out.println(getName()+"의 필살기!!");
			System.out.println(dam+"의 데미지");
			target.setHp(target.getHp()-dam);
			System.out.println(target.getName()+"의 남은체력 : "+target.getHp());
			
		}
		else {
			super.attack(target);
		}
	}
}
