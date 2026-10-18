package sportsnews;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Reporter> reporters = new ArrayList<>();

        int option;

        do {
            System.out.println("\n===== SPORTS NEWS =====");
            System.out.println("1. Introduce reporter");
            System.out.println("2. Remove reporter");
            System.out.println("3. Add news to a reporter");
            System.out.println("4. Remove news");
            System.out.println("5. Show reporter's news");
            System.out.println("6. Calculate news score");
            System.out.println("7. Calculate news price");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    introduceReporter(scanner, reporters);
                    break;

                case 2:
                    removeReporter(scanner, reporters);
                    break;

                case 3:
                    addNews(scanner, reporters);
                    break;

                case 4:
                    removeNews(scanner, reporters);
                    break;

                case 5:
                    showNews(scanner, reporters);
                    break;

                case 6:
                    calculateScore(scanner, reporters);
                    break;

                case 7:
                    calculatePrice(scanner, reporters);
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (option != 0);

        scanner.close();
    }

    private static void introduceReporter(
            Scanner scanner, ArrayList<Reporter> reporters) {

        System.out.print("Enter reporter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter reporter DNI: ");
        String dni = scanner.nextLine();

        reporters.add(new Reporter(name, dni));

        System.out.println("Reporter added successfully.");
    }

    private static void removeReporter(
            Scanner scanner, ArrayList<Reporter> reporters) {

        System.out.print("Enter reporter DNI: ");
        String dni = scanner.nextLine();

        for (int i = 0; i < reporters.size(); i++) {
            if (reporters.get(i).getDni().equalsIgnoreCase(dni)) {
                reporters.remove(i);
                System.out.println("Reporter removed.");
                return;
            }
        }

        System.out.println("Reporter not found.");
    }

    private static Reporter findReporter(
            Scanner scanner, ArrayList<Reporter> reporters) {

        System.out.print("Enter reporter DNI: ");
        String dni = scanner.nextLine();

        for (Reporter reporter : reporters) {
            if (reporter.getDni().equalsIgnoreCase(dni)) {
                return reporter;
            }
        }

        System.out.println("Reporter not found.");
        return null;
    }

    private static void addNews(
            Scanner scanner, ArrayList<Reporter> reporters) {

        Reporter reporter = findReporter(scanner, reporters);

        if (reporter == null) {
            return;
        }

        System.out.println("1. Football");
        System.out.println("2. Basketball");
        System.out.println("3. Tennis");
        System.out.println("4. Formula 1");
        System.out.println("5. Motorcycle racing");
        System.out.print("Choose news type: ");

        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter headline: ");
        String headline = scanner.nextLine();

        News news;

        switch (type) {
            case 1:
                System.out.print("Competition: ");
                String footballCompetition = scanner.nextLine();

                System.out.print("Club: ");
                String club = scanner.nextLine();

                System.out.print("Player: ");
                String player = scanner.nextLine();

                news = new FootballNews(
                        headline, footballCompetition, club, player);
                break;

            case 2:
                System.out.print("Competition: ");
                String basketballCompetition = scanner.nextLine();

                System.out.print("Club: ");
                String basketballClub = scanner.nextLine();

                news = new BasketballNews(
                        headline, basketballCompetition, basketballClub);
                break;

            case 3:
                System.out.print("Competition: ");
                String tennisCompetition = scanner.nextLine();

                System.out.print("Tennis players: ");
                String players = scanner.nextLine();

                news = new TennisNews(
                        headline, tennisCompetition, players);
                break;

            case 4:
                System.out.print("Team: ");
                String f1Team = scanner.nextLine();

                news = new F1News(headline, f1Team);
                break;

            case 5:
                System.out.print("Team: ");
                String motorcycleTeam = scanner.nextLine();

                news = new MotorcycleNews(headline, motorcycleTeam);
                break;

            default:
                System.out.println("Invalid news type.");
                return;
        }

        reporter.addNews(news);
        System.out.println("News added successfully.");
    }

    private static void removeNews(
            Scanner scanner, ArrayList<Reporter> reporters) {

        Reporter reporter = findReporter(scanner, reporters);

        if (reporter == null) {
            return;
        }

        System.out.print("Enter news headline: ");
        String headline = scanner.nextLine();

        for (News news : reporter.getNewsList()) {
            if (news.getHeadline().equalsIgnoreCase(headline)) {
                reporter.removeNews(news);
                System.out.println("News removed.");
                return;
            }
        }

        System.out.println("News not found.");
    }

    private static void showNews(
            Scanner scanner, ArrayList<Reporter> reporters) {

        Reporter reporter = findReporter(scanner, reporters);

        if (reporter == null) {
            return;
        }

        if (reporter.getNewsList().isEmpty()) {
            System.out.println("This reporter has no news.");
            return;
        }

        for (News news : reporter.getNewsList()) {
            System.out.println("- " + news.getHeadline());
        }
    }

    private static News findNews(
            Scanner scanner, ArrayList<Reporter> reporters) {

        Reporter reporter = findReporter(scanner, reporters);

        if (reporter == null) {
            return null;
        }

        System.out.print("Enter news headline: ");
        String headline = scanner.nextLine();

        for (News news : reporter.getNewsList()) {
            if (news.getHeadline().equalsIgnoreCase(headline)) {
                return news;
            }
        }

        System.out.println("News not found.");
        return null;
    }

    private static void calculateScore(
            Scanner scanner, ArrayList<Reporter> reporters) {

        News news = findNews(scanner, reporters);

        if (news != null) {
            System.out.println("Score: " + getScore(news) + " points");
        }
    }

    private static int getScore(News news) {
        if (news instanceof FootballNews) {
            return ((FootballNews) news).calculateScore();
        } else if (news instanceof BasketballNews) {
            return ((BasketballNews) news).calculateScore();
        } else if (news instanceof TennisNews) {
            return ((TennisNews) news).calculateScore();
        } else if (news instanceof F1News) {
            return ((F1News) news).calculateScore();
        } else if (news instanceof MotorcycleNews) {
            return ((MotorcycleNews) news).calculateScore();
        }

        return 0;
    }

    private static void calculatePrice(
            Scanner scanner, ArrayList<Reporter> reporters) {

        News news = findNews(scanner, reporters);

        if (news != null) {
            System.out.println("Price: " + getPrice(news) + " euros");
        }
    }

    private static double getPrice(News news) {
        if (news instanceof FootballNews) {
            return ((FootballNews) news).calculatePrice();
        } else if (news instanceof BasketballNews) {
            return ((BasketballNews) news).calculatePrice();
        } else if (news instanceof TennisNews) {
            return ((TennisNews) news).calculatePrice();
        } else if (news instanceof F1News) {
            return ((F1News) news).calculatePrice();
        } else if (news instanceof MotorcycleNews) {
            return ((MotorcycleNews) news).calculatePrice();
        }

        return 0;
    }
}
