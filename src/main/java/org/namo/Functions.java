package org.namo;

import com.github.lalyos.jfiglet.FigletFont;

public class Functions {
    public static void Figlet(String text) {
        try {
            String asciiArt = FigletFont.convertOneLine(text);
            System.out.println(asciiArt);
        } catch (final Exception e) {
            System.out.println("error");
        }
    }
}
