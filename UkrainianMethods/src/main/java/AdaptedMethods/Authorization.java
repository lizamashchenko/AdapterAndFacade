package AdaptedMethods;

import UAMethods.Авторизація;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Authorization extends Авторизація {
    private Авторизація authorization;

    public boolean authorize(DataBase db) {
        return authorization.авторизуватися(db);
    }
}
