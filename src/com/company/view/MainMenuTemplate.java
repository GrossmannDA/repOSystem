package company.view;

public class MainMenuTemplate {

    private static final String template = "Please ..:\n%s";

    public String format(String menuItem) {
        return String.format(template, menuItem);
    }

    public static void main(String[] args) {
        System.out.println(new MainMenuTemplate().format("1. Privet"));
    }
}
