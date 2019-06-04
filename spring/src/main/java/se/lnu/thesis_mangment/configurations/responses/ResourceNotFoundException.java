package se.lnu.thesis_mangment.configurations.responses;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Resource not found exception.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException
{
    /**
     * Instantiates a new Resource not found exception.
     */
    public ResourceNotFoundException()
    {
        super();
    }

    /**
     * Instantiates a new Resource not found exception.
     *
     * @param exception the exception
     */
    public ResourceNotFoundException(String exception)
    {
        super(exception);
    }
}