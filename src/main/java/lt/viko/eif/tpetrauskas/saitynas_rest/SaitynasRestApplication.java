package lt.viko.eif.tpetrauskas.saitynas_rest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * This is a main class of this application.
 */
@SpringBootApplication
public class SaitynasRestApplication extends SpringBootServletInitializer {

    /**
     * This is a main method of this application.
     */
    public static void main(String[] args) {
        new SaitynasRestApplication().configure(new SpringApplicationBuilder(SaitynasRestApplication.class)).run(args);
    }

}
