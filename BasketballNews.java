
package sportsnews;

public class BasketballNews extends News {

    private String competition;
    private String club;

    public BasketballNews(String headline, String competition, String club) {
        super(headline);
        this.competition = competition;
        this.club = club;
    }

    public String getCompetition() {
        return competition;
    }

    public String getClub() {
        return club;
    }

    public double calculatePrice() {
        double price = 250;

        if (competition.equalsIgnoreCase("Eurolliga")) {
            price += 75;
        }

        if (club.equalsIgnoreCase("Barça")
                || club.equalsIgnoreCase("Madrid")) {
            price += 75;
        }

        return price;
    }

    public int calculateScore() {
        int score = 4;

        if (competition.equalsIgnoreCase("Eurolliga")) {
            score += 3;
        }

        if (competition.equalsIgnoreCase("ACB")) {
            score += 2;
        }

        if (club.equalsIgnoreCase("Barça")
                || club.equalsIgnoreCase("Madrid")) {
            score += 1;
        }

        return score;
    }
}
