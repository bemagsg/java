package tictactoe;

public class Player {
	
	private String name;
	private int score = 0;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore() {
		this.score = score + 1;
	}
	
	Player() {}
	
	Player(String name){
		this.name = name;
	}
	
}
