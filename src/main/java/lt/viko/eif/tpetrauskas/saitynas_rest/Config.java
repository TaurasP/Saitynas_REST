package lt.viko.eif.tpetrauskas.saitynas_rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;


/**
 * ResourceConfig provides advanced capabilities to simplify registration of JAX-RS components.
 */
@Component
public class Config extends ResourceConfig
{
    public Config()
    {
        register(CarResource.class);
    }
}
