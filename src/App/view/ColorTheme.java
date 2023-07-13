package App.view;

public enum ColorTheme {
    JASNY("themeLight"),
    STANDARDOWY("themeDefault"),
    CIEMNY("themeDark");

    private String css;

    ColorTheme(String css) {
        this.css = css;
    }

    public String getCssPath() {
        return "css/" + css + ".css";
    }

}