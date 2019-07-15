package s12_sample011;

public class Nobita {
	private Friend friend;
	public void setFriend(Friend friend) {
		this.friend=friend;
	}
	public String getAverageScore() {
		return friend.getAverageScoreOfNobita();
	}
}
