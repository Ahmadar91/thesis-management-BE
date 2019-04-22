package se.lnu.thesis_mangment.configurations.responses;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException
{
    public ResourceNotFoundException()
    {
        super();
    }

    public ResourceNotFoundException(String exception)
    {
        super(exception);
    }
}