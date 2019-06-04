package se.lnu.thesis_mangment.repositories.query;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Search builder.
 */
public class SearchBuilder
{
    private String statement = "";
    private List<Parameter> parameterList = new ArrayList<>();

    /**
     * Add.
     *
     * @param <T>            the type parameter
     * @param statement      the statement
     * @param parameterName  the parameter name
     * @param parameterValue the parameter value
     */
    public <T> void add(String statement, String parameterName, T parameterValue)
    {
        this.statement += statement;
        this.parameterList.add(new Parameter<>(parameterName, parameterValue));
    }

    /**
     * Gets statement.
     *
     * @return the statement
     */
    public String getStatement()
    {
        return statement;
    }

    /**
     * Gets parameter list.
     *
     * @return the parameter list
     */
    public List<Parameter> getParameterList()
    {
        return parameterList;
    }
}
