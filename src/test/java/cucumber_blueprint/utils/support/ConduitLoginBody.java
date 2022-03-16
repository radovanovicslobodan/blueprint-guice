package cucumber_blueprint.utils.support;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConduitLoginBody {

    private String email;
    private String password;

    public ConduitLoginBody(String username, String password) {
        this.email = username;
        this.password = password;
    }
}
