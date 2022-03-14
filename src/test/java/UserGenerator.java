
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserGenerator {
    private UserGenerator() {
    }

    public static String createUser(String login, String password, RegistrationDto.Status status) {
        RegistrationDto registrationDto = new RegistrationDto(login, password, status);

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(registrationDto);
    }
}
