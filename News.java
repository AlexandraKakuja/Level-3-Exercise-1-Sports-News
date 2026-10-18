package sportsnews;

public abstract class News {

    private String headline;
    private String text;
    private int score;
    private double price;

    public News(String headline) {
        this.headline = headline;
        this.text = "";
        this.score = 0;
        this.price = 0.0;
    }

    public String getHeadline() {
        return headline;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getScore() {
        return score;
    }

    public double getPrice() {
        return price;
    }
}