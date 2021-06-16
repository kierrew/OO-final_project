package Model.ObserverPatteren;

import Model.EnemyComposite;
import Model.Shooter;

public interface Subject {

	void addShooterListener(Observer o);
	void addEnemyListener(Observer o);
	void removeShooterListener(Observer o);
	void removeEnemyListener(Observer o);
	void notifyEnemyObservers(EnemyComposite.Event event);
	void notifyShooterObservers(Shooter.Event event);
	
}
