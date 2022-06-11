package lt.viko.eif.tpetrauskas.saitynas_rest;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * CarResource entity is used for REST CRUD methods implementation.
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "cars")
@Path("/cars")
public class CarResource {
    private static Map<Integer, Car> DB = new HashMap<>();


    /**
     * Gets all cars.
     *
     * @return list of cars
     */
    @GET
    @Produces("application/json")
    public Cars getAllCars() {
        Cars cars = new Cars();
        cars.setCars(new ArrayList<>(DB.values()));
        return cars;
    }


    /**
     * Creates a new car.
     *
     * @param car
     * @return 400 / 201 HTTP responses depending on the result
     * @throws URISyntaxException
     */
    @POST
    @Consumes("application/json")
    public Response createCar(Car car) throws URISyntaxException
    {
        if(car.getManufacturer() == null || car.getManufacturer() == null || car.getYear() <= 1886) {
            return Response.status(400).entity("Please provide all mandatory inputs").build();
        }
        car.setId(DB.values().size() + 1);
        car.setUri("/car-management/" + car.getId());
        DB.put(car.getId(), car);
        return Response.status(201).contentLocation(new URI(car.getUri())).build();
    }


    /**
     * Gets car by its ID.
     *
     * @param id
     * @return 404 / 200 HTTP responses depending on the result
     * @throws URISyntaxException
     */
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getCarById(@PathParam("id") int id) throws URISyntaxException
    {
        Car car = DB.get(id);
        if(car == null) {
            return Response.status(404).build();
        }
        return Response
                .status(200)
                .entity(car)
                .contentLocation(new URI("/car-management/" + id)).build();
    }

    /**
     * Updates car which is selected by its ID.
     *
     * @param id
     * @param car
     * @return 404 / 200 HTTP responses depending on the result
     */
    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateUCar(@PathParam("id") int id, Car car)
    {
        Car temp = DB.get(id);
        if(car == null) {
            return Response.status(404).build();
        }
        temp.setManufacturer(car.getManufacturer());
        temp.setModel(car.getModel());
        temp.setYear(car.getYear());
        temp.setAWD(car.isAWD());
        DB.put(temp.getId(), temp);
        return Response.status(200).entity(temp).build();
    }

    /**
     * Deletes car which is selected by its ID.
     *
     * @param id
     * @return 404 / 200 HTTP responses depending on the result
     */
    @DELETE
    @Path("/{id}")
    public Response deleteCar(@PathParam("id") int id) {
        Car car = DB.get(id);
        if(car != null) {
            DB.remove(car.getId());
            return Response.status(200).build();
        }
        return Response.status(404).build();
    }

    /**
     * Hardcoded testing data.
     */
    static {
        Car car1 = new Car();
        car1.setId(1);
        car1.setManufacturer("Mazda");
        car1.setModel("CX-5");
        car1.setYear(2016);
        car1.setAWD(true);
        car1.setUri("/car-management/1");

        Car car2 = new Car();
        car2.setId(2);
        car2.setManufacturer("VW");
        car2.setModel("Touareg");
        car2.setYear(2014);
        car2.setAWD(true);
        car2.setUri("/car-management/2");

        Car car3 = new Car();
        car3.setId(3);
        car3.setManufacturer("Toyota");
        car3.setModel("Auris");
        car3.setYear(2013);
        car3.setAWD(false);
        car3.setUri("/car-management/3");

        Car car4 = new Car();
        car4.setId(4);
        car4.setManufacturer("Mazda");
        car4.setModel("5");
        car4.setYear(2007);
        car4.setAWD(false);
        car4.setUri("/car-management/4");

        DB.put(car1.getId(), car1);
        DB.put(car2.getId(), car2);
        DB.put(car3.getId(), car3);
        DB.put(car4.getId(), car4);
    }
}