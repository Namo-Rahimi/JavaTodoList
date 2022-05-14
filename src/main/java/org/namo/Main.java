package org.namo;
import com.github.lalyos.jfiglet.FigletFont;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Functions.ClearScreen();
            Functions.Figlet("TodoList");
            Functions.FileCreate();
            System.out.println(" 1. Add to the list");
            System.out.println(" 2. Remove from the list");
            System.out.println(" 3. Quit");
            String input = Functions.Input("Enter an option: ");

            switch (input) {
                case "1" -> Pages.AddToList();
                case "2" -> Pages.RemoveFromlist();
                case "3" -> Functions.Quit();
                default -> System.out.println("\n This is not an option.");
            }

        }
    }


}