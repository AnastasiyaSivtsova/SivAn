package Helper;

public class DataUser {
    private String userId;
    private String title;
    private String body;

    public DataUser(String userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    @Override
    public String toString() {
        return "{\n" +
                "userId: " + userId + "\n" +
                "title: " + title + "\n" +
                "body: " + body + "\n" +
                "}";
    }
}
