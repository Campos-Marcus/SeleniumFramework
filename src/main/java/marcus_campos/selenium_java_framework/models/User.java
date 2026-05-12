package marcus_campos.selenium_java_framework.models;

public class User {

    private String username;
    private String password;
    private boolean shouldLoginSucceed;

    public User(String username, String password, boolean shouldLoginSucceed) {
        this.username = username;
        this.password = password;
        this.shouldLoginSucceed = shouldLoginSucceed;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean shouldLoginSucceed() {
        return shouldLoginSucceed;
    }
}