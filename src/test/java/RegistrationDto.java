
public class RegistrationDto {
    public RegistrationDto(String login, String password, Status status) {
        this.login = login;
        this.password = password;
        this.status = status;
    }

    private String login;
    private String password;
    private Status status;

    public enum Status{
        active,
        blocked
    }
}
