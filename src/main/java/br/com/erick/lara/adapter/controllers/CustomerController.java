package br.com.erick.lara.adapter.controllers;

import br.com.erick.lara.adapter.controllers.dtos.request.CustomerRequestDTO;
import br.com.erick.lara.domain.Customer;
import br.com.erick.lara.usecases.CustomerService;
import org.jboss.resteasy.reactive.ResponseStatus;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path(value = "/customers")
public class CustomerController {

    @Inject
    CustomerService customerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseStatus(value = 200)
    public List<Customer> findAllCustomers(){
        return customerService.findAllCustomers();
    }

    @POST
    @Transactional
    public Response saveCustomer(CustomerRequestDTO customerRequestDTO){
        try {
            customerService.createNewCustomer(customerRequestDTO);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path(value = "/{id}")
    @Transactional
    public Response updateCustomer(@PathParam(value = "id") Long id, CustomerRequestDTO customerRequestDTO){
        try {
            customerService.updateCustomer(id, customerRequestDTO);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path(value = "/{id}")
    @Transactional
    public Response deleteCustomer(@PathParam(value = "id") Long id){
        try {
            customerService.deleteCustomer(id);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
