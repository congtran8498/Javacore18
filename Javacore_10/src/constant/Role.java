package constant;

public enum Role {
    ADMIN("Admin"),
    USER("User");
    private String value;

    Role(String value) {
        this.value = value;
    }
}
