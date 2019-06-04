package se.lnu.thesis_mangment.repositories.query;

/**
 * The type Parameter.
 *
 * @param <T> the type parameter
 */
public class Parameter<T>
{
    private String name;
    private T value;

    /**
     * Instantiates a new Parameter.
     *
     * @param name  the name
     * @param value the value
     */
    public Parameter(String name, T value)
    {
        this.name = name;
        this.value = value;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public T getValue()
    {
        return value;
    }
}