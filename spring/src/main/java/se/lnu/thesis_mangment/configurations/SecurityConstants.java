package se.lnu.thesis_mangment.configurations;

/**
 * The type Security constants.
 */
public class SecurityConstants
{
    /**
     * The constant SECRET.
     */
    public static final String SECRET = "SecretKeyToGenJWTs";
    /**
     * The constant EXPIRATION_TIME.
     */
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    /**
     * The constant TOKEN_PREFIX.
     */
    public static final String TOKEN_PREFIX = "Bearer ";
    /**
     * The constant HEADER_STRING.
     */
    public static final String HEADER_STRING = "Authorization";
    /**
     * The constant SIGN_IN.
     */
    public static final String SIGN_IN = "/login";
}
