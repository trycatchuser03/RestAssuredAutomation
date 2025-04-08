package nonBDDApproach;

public class ChainingMethods {

	String sport;
	String venue;
	public String getSport() {
		return sport;
	}
	public ChainingMethods setSport(String sport) {
		this.sport = sport;
		return this;
	}
	public String getVenue() {
		return venue;
	}
	public ChainingMethods setVenue(String venuee) {
		this.venue = venuee;
		return this;
	}

	public void friend() {
		System.out.println("We are going to play "+getSport()+ " at "+getVenue());
	}

	public static void main(String[] args) {

		ChainingMethods game = new ChainingMethods();
		game.setSport("Cricket");
		game.setVenue("Nets");
		game.friend();

		game.setSport("Carrom").setVenue("Home").friend();

	}



}
