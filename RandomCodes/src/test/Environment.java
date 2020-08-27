package test;

public enum Environment {

    PROD("https://prod.vpz.co:8086"), DEV("https://dev.vpz.co:8080"), SIT("https://prod.vpz.co:8084"), UAT(
            "https://prod.vpz.co:8088");
    private String URL;

    private Environment(String env) {
        this.URL = env;
    }

    public String getURL() {
        return URL;
    }
}
