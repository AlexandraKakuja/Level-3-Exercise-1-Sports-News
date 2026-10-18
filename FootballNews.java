
package sportsnews;

public class FootballNews extends News {

    private String competition;
    private String club;
    private String player;

    public FootballNews(String headline, String competition,
                        String club, String player) {
        super(headline);
        this.competition = competition;
        this.club = club;
        this.player = player;
    }

    public String getCompetition() {
        return competition;
    }

    public String getClub() {
        return club;
    }

    public String getPlayer() {
        return player;
    }

    public double calculatePrice() {
        double price = 300;

        if (competition.equalsIgnoreCase("Lliga de Campions")) {
            price += 100;
        }

        if (club.equalsIgnoreCase("Barça")
                || club.equalsIgnoreCase("Madrid")) {
            price += 100;
        }

        if (player.equalsIgnoreCase("Ferran Torres")
                || player.equalsIgnoreCase("Benzema")) {
            price += 50;
        }

        return price;
    }

    public int calculateScore() {
        int score = 5;

        if (competition.equalsIgnoreCase("Lliga de Campions")) {
            score += 3;
        }

        if (competition.equalsIgnoreCase("Lliga")) {
            score += 2;
        }

        if (club.equalsIgnoreCase("Barça")
                || club.equalsIgnoreCase("Madrid")) {
            score += 1;
        }

        if (player.equalsIgnoreCase("Ferran Torres")
                || player.equalsIgnoreCase("Benzema")) {
            score += 1;
        }

        return score;
    }
}
