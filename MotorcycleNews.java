
package sportsnews;

public class MotorcycleNews extends News {

    private String team;

    public MotorcycleNews(String headline, String team) {
        super(headline);
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public double calculatePrice() {
        double price = 100;

        if (team.equalsIgnoreCase("Honda")
                || team.equalsIgnoreCase("Yamaha")) {
            price += 50;
        }

        return price;
    }

    public int calculateScore() {
        int score = 3;

        if (team.equalsIgnoreCase("Honda")
                || team.equalsIgnoreCase("Yamaha")) {
            score += 3;
        }

        return score;
    }
}
