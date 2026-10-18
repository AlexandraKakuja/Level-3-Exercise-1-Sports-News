
package sportsnews;

public class F1News extends News {

    private String team;

    public F1News(String headline, String team) {
        super(headline);
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public double calculatePrice() {
        double price = 100;

        if (team.equalsIgnoreCase("Ferrari")
                || team.equalsIgnoreCase("Mercedes")) {
            price += 50;
        }

        return price;
    }

    public int calculateScore() {
        int score = 4;

        if (team.equalsIgnoreCase("Ferrari")
                || team.equalsIgnoreCase("Mercedes")) {
            score += 2;
        }

        return score;
    }
}
