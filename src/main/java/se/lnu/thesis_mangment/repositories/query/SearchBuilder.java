package se.lnu.thesis_mangment.repositories.query;

import java.util.ArrayList;
import java.util.List;


public class SearchBuilder
{
    private String statement = "";
    private List<Parameter> parameterList = new ArrayList<>();

    public <T> void add(String statement, String parameterName, T parameterValue)
    {
        this.statement += statement;
        this.parameterList.add(new Parameter<>(parameterName, parameterValue));
    }

    public String getStatement()
    {
        return statement;
    }

    public List<Parameter> getParameterList()
    {
        return parameterList;
    }
}
