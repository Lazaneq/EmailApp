package App.view;

public enum FontSize {
    MALY("fontSmall"),
    MID("fontMedium"),
    DUZY("fontBig");

    private String css;

    FontSize(String css) {
        this.css = css;
    }

    public String getCssPath() {
        return "css/" + css + ".css";
    }

}
