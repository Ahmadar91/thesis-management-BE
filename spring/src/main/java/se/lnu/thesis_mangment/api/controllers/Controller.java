package se.lnu.thesis_mangment.api.controllers;

import se.lnu.thesis_mangment.configurations.responses.ResourceNotFoundException;

import java.util.HashMap;

public class Controller
{


    protected HashMap<String, Object> response(ResponseArgument... args)
    {
        HashMap<String, Object> result = new HashMap<>();
        for (ResponseArgument arg : args)
        {
            result.put(arg.getName(), arg.getObject());
        }
        return result;
    }

    public class ResponseArgument<T>
    {
        private String name;
        private T value;

        public ResponseArgument(String name, T value)
        {
            this.name = name;
            this.value = value;
            if (value == null)
            {
                throw new ResourceNotFoundException("Item not found");
            }
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public T getObject()
        {
            return value;
        }

        public void setObject(T value)
        {
            this.value = value;
        }
    }
}
