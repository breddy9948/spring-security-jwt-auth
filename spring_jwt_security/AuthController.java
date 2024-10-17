
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/authenticate")
    public String createAuthenticationToken(@RequestBody AuthRequest authRequest) {
        return jwtTokenUtil.generateAccessToken(authRequest.getUsername(), new HashMap<>());
    }

    @PostMapping("/refresh-token")
    public String refreshToken(@RequestHeader("Authorization") String refreshToken) {
        if (jwtTokenUtil.validateToken(refreshToken)) {
            String username = jwtTokenUtil.extractUsername(refreshToken);
            return jwtTokenUtil.generateAccessToken(username, new HashMap<>());
        }
        return "Invalid refresh token";
    }
}
