package Model.ObserverPatteren;



public interface Observer {

	void bulletHitEnemy();
	void bulletHitBomb();
	void shooterDestroyed();
	void enemiesReachBottom();
	void enemiesDefeated();

	
}
