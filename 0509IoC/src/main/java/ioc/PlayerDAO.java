package ioc;

public class PlayerDAO {
	//패키지 외부에서는 객체 생성을 못하도록 생성자를 default로 생성
	PlayerDAO(){}
	
	//player 1개를 리턴해주는 메소드 
	public Player getPlayer() {
		Player player = new Player();
		player.setNum(11);
		player.setName("차붐");
		player.setEvents("축구");
		return player;
	}
}
