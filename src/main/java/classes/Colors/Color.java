package classes.Colors;
public class Color {
    private String color;

    public Color(String color) {
        setColor(color);
    }

    @Override
    public String toString() {
        return "Color{" +
                "color='" + color + '\'' + " " +
                '}';
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

}
