package fr.unicorn.lumiobase;

import java.util.HashMap;
import java.util.Map;

public class Color {
    
    public static Map<String, Color> colors = new HashMap<String, Color>();

    private String name;
    private int r;
    private int g;
    private int b;

    private Color(String name, int r, int g, int b) {
        this.name = name;
        this.r = r;
        this.g = g;
        this.b = b;
        colors.put(name, this);
    }

    public static Color create (String name, int r, int g, int b) throws NameAlreadyUsedException {
        Color c = Color.getExisting(r, g, b);
        if (c != null) {
            return c;
        } else {
            if (colors.containsKey(name)) {
                throw new NameAlreadyUsedException();
            }
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

    public boolean reduce(){
        if(r>0 && g>0 && b>0){
            r--;
            g--;
            b--;
            return true;
        }
        return false;
    }

    public boolean increase(){
        if(r<255 && g<255 && b<255){
            r++;
            g++;
            b++;
            return true;
        }
        return false;
    }

    private static Color getExisting(int red, int green, int blue) {
        for (Color c : colors.values() ) {
            if (red == c.getR() && green == c.getG() && blue == c.getB()) {
                return c;
            }
        }
        return null;
    }
}
