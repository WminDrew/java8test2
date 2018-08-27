package fangfayinyong;

public class Color {
    private String red;
    private String blue;
    private String white;

    public Color(String red, String blue, String white) {
        this.red = red;
        this.blue = blue;
        this.white = white;
    }

    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public String getBlue() {
        return blue;
    }

    public void setBlue(String blue) {
        this.blue = blue;
    }

    public String getWhite() {
        return white;
    }

    public void setWhite(String white) {
        this.white = white;
    }

    @Override
    public String toString() {
        return "Color{" +
                "red='" + red + '\'' +
                ", blue='" + blue + '\'' +
                ", white='" + white + '\'' +
                '}';
    }
}
