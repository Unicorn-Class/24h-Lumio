package fr.unicorn.lumiobase;

import java.util.ArrayList;
import java.util.List;

public class Color {
    
    public static List<Color> colors = new ArrayList<Color>();

    private String name;
    private int r;
    private int g;
    private int b;

    private Color(String name, int r, int g, int b) {
        this.name = name;
        this.r = r;
        this.g = g;
        this.b = b;
        colors.add(this);
    }

    public static Color create (String name, int r, int g, int b) {
        Color c = Color.getExisting(r, g, b);
        if (c != null) {
            return c;
        } else {
            return new Color(name, r, g, b);
        }
    }

    public String getName() {
        return name;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    public int[] getRGB() {
        int[] tab = {r, g, b};
        return tab;
    }

    private static Color getExisting(int red, int green, int blue) {
        for (Color c : colors ) {
            if (red == c.getR() && green == c.getG() && blue == c.getB()) {
                return c;
            }
        }
        return null;
    }
}
