package model;

public class ZombieKing extends Unit implements Attack{		//����ŷŬ������ ����Ŭ������ ����� �޴��ڽ�Ŭ�����̴�.
	int shield;								//������ ������ �߰��Ѵ�.
	public ZombieKing(String name, int hp, int att, int def, int position, int shield) {// ������ ����տ� GAME���� ���� ������� ������ ���ڷ��ش�.
		super(name, hp, att, def, position);		//�θ�Ŭ������ ���ڷ� ���� ������� ������ super�� �θ�Ŭ������ �����ڿ� ���ٽ�Ų��.
		this.shield = shield;					//���ڷ� ���� ���带 ������� ���庯���� �����Ѵ�.
	}
	public int getShield() {					//���ͷ� �����ġ ���
		return this.shield;
	}
	public void setShield(int shield) {			//���ͷ� �����ġ ����
		this.shield = shield;
	}
	public void attack(Unit target) {			//���ݸ޼ҵ忡 ����Ŭ������ �ڷ������� �޴� Ÿ���� ���ڷ� ������
		if(rand.nextInt(100)>74) {				//���� ������ 100�� ������ 74���� ū���� ������
			int dam = (this.getAtt() - target.getDef())*(rand.nextInt(150)+50)/100; //�������� Unit�� ���ݰ� ���� ����� ���� ���ϱ� ������ 150�� ������ ���� ��+50������ 100
			if(dam <= 0 ) {						//�������� 0 �����̸�
				dam = 1;						//�������� 1�̵ȴ�.
				
			}
			dam*=2;												
			System.out.println(getName()+"�� �ʻ��!!");				//����ŷ�� �ʻ������Ҷ� ��¹�
			System.out.println(dam+"�� ������");						//������ �����
			target.setHp(target.getHp()-dam);						//�������� �޴� ����� ü���� ����� ü��-�������� �����Ѵ�.
			System.out.println(target.getName()+"�� ����ü�� : "+target.getHp());		//�������� ���� ����� ü���� ����Ѵ�.
			
		}
		else {
			super.attack(target);
		}
	}
}
