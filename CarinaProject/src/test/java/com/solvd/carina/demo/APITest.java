package com.solvd.carina.demo;

import java.lang.invoke.MethodHandles;
import com.solvd.carina.demo.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

/**
 * API tests validate CRUD operations for a "Cart" API endpoints.
 *
 * @author Paula Kawalec
 */
public class APITest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    /**
     * Tests the POST endpoint for creating a new cart.
     *
     */
    @Test()
    @MethodOwner(owner = "paula")
    public void testPostAddNewCart() throws Exception{
        PostAddNewCartMethod api = new PostAddNewCartMethod();
        api.setProperties("api/carts/carts.properties");
        api.callAPI();
        api.validateResponse();
        api.validateResponseAgainstSchema("api/carts/_post/rs.schema");
    }

    /**
     * Tests the PUT endpoint for modifying an existing cart.
     *
     */
    @Test()
    @MethodOwner(owner = "paula")
    public void testUpdateCart() {
        PutUpdateCart api= new PutUpdateCart();
        api.callAPIExpectSuccess();
        api.validateResponse();
        api.validateResponseAgainstSchema("api/carts/_put/rs.schema");
    }

    /**
     * Tests the DELETE endpoint for removing a cart.
     *
     */
    @Test()
    @MethodOwner(owner = "paula")
    public void testDeleteCart() throws Exception{ // -------------not work
        DeleteCartMethod api= new DeleteCartMethod();
        api.callAPIExpectSuccess();
        api.validateResponseAgainstSchema("api/carts/_delete/rs.schema");
    }

    /**
     * Tests the GET endpoint for retrieving a single cart.
     *
     */
    @Test()
    @MethodOwner(owner = "paula")
    public void testGetSingleCart(){
        GetSingleCartMethod api= new GetSingleCartMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();
        api.validateResponseAgainstSchema("api/carts/_get/_getSingle/rs.schema");
    }

    /**
     * Tests the GET endpoint for fetching carts associated with a user.
     *
     */
    @Test()
    @MethodOwner(owner = "paula")
    public void testGetCartsByUser(){ // -- not passed, because something is wrong with API implementation
        GetCartsByUserMethod api= new GetCartsByUserMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

}


