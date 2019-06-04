package se.lnu.thesis_mangment.configurations;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import se.lnu.thesis_mangment.model.User;
import se.lnu.thesis_mangment.services.UserServices;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static se.lnu.thesis_mangment.configurations.SecurityConstants.*;

/**
 * The type Jwt authentication filter.
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter
{
    private AuthenticationManager authenticationManager;

    private UserServices userServices;


    /**
     * Instantiates a new Jwt authentication filter.
     *
     * @param authenticationManager the authentication manager
     * @param userServices          the user services
     */
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, UserServices userServices)
    {
        this.authenticationManager = authenticationManager;
        this.userServices = userServices;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException
    {

        String query = req.getQueryString();
        var elements = query.split(Pattern.quote("&"));
        if (elements.length == 0)
        {
            throw new UsernameNotFoundException("");
        }
        String username = "";
        String password = "";
        for (String element : elements)
        {
            if (element.startsWith("username"))
            {
                username = element.substring(element.indexOf('=') + 1);

            } else if (element.startsWith("password"))
            {
                password = element.substring(element.indexOf('=') + 1);
            }
        }
        // Prevent SQL injection by checking username and password
        if (username.isEmpty() || username.indexOf(' ') != -1)
        {
            throw new UsernameNotFoundException("Invalid username.");
        }
        if (password.isEmpty() || password.indexOf(' ') != -1)
        {
            throw new UsernameNotFoundException("Invalid password.");
        }

        var user = userServices.findByUsernameAndPassword(username);
        if (user == null)
        {
            throw new UsernameNotFoundException("User not found.");
        }
        // verify the password
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (!bCryptPasswordEncoder.matches(password, user.getPassword()))
        {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        return new UsernamePasswordAuthenticationToken(user, password, new ArrayList<>());
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException, ServletException
    {
        var user = ((User) auth.getPrincipal());
        String token = JWT.create().withSubject(user.getUsername()).withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME)).sign(HMAC512(SECRET.getBytes()));
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);

        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("user", user);

        var mapper = new ObjectMapper();
        res.setContentType("application/json;charset=UTF-8");
        mapper.writeValue(res.getWriter(), tokenMap);
    }
}