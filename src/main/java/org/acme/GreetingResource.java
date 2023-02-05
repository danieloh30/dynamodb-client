package org.acme;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/hello")
public class GreetingResource {

    @Inject
    PersonService pService;

    @GET
    @Path("person/all")
    public List<Person> findAll () {
        return pService.findAll();
    }

    @POST
    @Path("/person")
    public void addPerson(Person person) {
        pService.addPerson(person);
    }

    @GET
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }
}