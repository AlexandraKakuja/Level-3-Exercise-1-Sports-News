
package sportsnews;

import java.util.ArrayList;

public class Reporter {

    private String name;
    private final String dni;
    private static double salary = 1500.0;
    private ArrayList<News> newsList;

    public Reporter(String name, String dni) {
        this.name = name;
        this.dni = dni;
        this.newsList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDni() {
        return dni;
    }

    public double getSalary() {
        return salary;
    }

    public static void setSalary(double newSalary) {
        salary = newSalary;
    }

    public ArrayList<News> getNewsList() {
        return newsList;
    }

    public void addNews(News news) {
        newsList.add(news);
    }

    public void removeNews(News news) {
        newsList.remove(news);
    }
}
