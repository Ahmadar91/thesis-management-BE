package se.lnu.thesis_mangment.api.controllers;

import se.lnu.thesis_mangment.configurations.responses.ResourceNotFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Controller.
 */
public class Controller
{


    /**
     * Response map.
     *
     * @param args the args
     * @return the map
     */
    protected Map<String, Object> response(ResponseArgument... args)
    {
        Map<String, Object> result = new HashMap<>();
        for (ResponseArgument arg : args)
        {
            result.put(arg.getName(), arg.getObject());
        }
        return result;
    }

    /**
     * The type Response argument.
     *
     * @param <T> the type parameter
     */
    public class ResponseArgument<T>
    {
        private String name;
        private T value;

        /**
         * Instantiates a new Response argument.
         *
         * @param name  the name
         * @param value the value
         */
        public ResponseArgument(String name, T value)
        {
            this.name = name;
            this.value = value;
            if (value == null)
            {
                throw new ResourceNotFoundException("Item not found");
            }
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
         * Gets object.
         *
         * @return the object
         */
        public T getObject()
        {
            return value;
        }

        /**
         * Sets object.
         *
         * @param value the value
         */
        public void setObject(T value)
        {
            this.value = value;
        }
    }
}
