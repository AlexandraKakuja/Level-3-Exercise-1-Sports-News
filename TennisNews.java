
package sportsnews;

public class TennisNews extends News {

    private String competition;
    private String tennisPlayers;

    public TennisNews(String headline, String competition,
                      String tennisPlayers) {
        super(headline);
        this.competition = competition;
        this.tennisPlayers = tennisPlayers;
    }

    public String getCompetition() {
        return competition;
    }

    public String getTennisPlayers() {
        return tennisPlayers;
    }

    public double calculatePrice() {
        double price = 150;

        if (tennisPlayers.toLowerCase().contains("federer")
                || tennisPlayers.toLowerCase().contains("nadal")
                || tennisPlayers.toLowerCase().contains("djokovic")) {
            price += 100;
        }

        return price;
    }

    public int calculateScore() {
        int score = 4;

        if (tennisPlayers.toLowerCase().contains("federer")
                || tennisPlayers.toLowerCase().contains("nadal")
                || tennisPlayers.toLowerCase().contains("djokovic")) {
            score += 3;
        }

        return score;
    }
}
