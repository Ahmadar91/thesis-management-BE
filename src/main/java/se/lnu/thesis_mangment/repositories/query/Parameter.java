package se.lnu.thesis_mangment.repositories.query;

public class Parameter<T>
{
    private String name;
    private T value;

    public Parameter(String name, T value)
    {
        this.name = name;
        this.value = value;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public T getValue()
    {
        return value;
    }
}