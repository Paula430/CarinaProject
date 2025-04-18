package com.solvd.carina.demo;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.solvd.carina.demo.api.*;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.api.APIMethodPoller;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;

/**
 * This sample shows how create REST API tests.
 *
 * @author Paula Kawalec
 */
public class APITest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "paula")
    public void testPostAddNewCart() throws Exception{
        PostAddNewCartMethod api = new PostAddNewCartMethod();
        api.setProperties("api/carts/carts.properties");
        api.callAPI();
        api.validateResponse();
        api.validateResponseAgainstSchema("api/carts/_post/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "paula")
    public void testUpdateCart() {
        PutUpdateCart api= new PutUpdateCart();
        api.callAPIExpectSuccess();
        api.validateResponse();
        api.validateResponseAgainstSchema("api/carts/_put/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "paula")
    public void testDeleteCart() throws Exception{ // -------------not work
        DeleteCartMethod api= new DeleteCartMethod();
        api.callAPIExpectSuccess();
        api.validateResponseAgainstSchema("api/carts/_delete/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "paula")
    public void testGetSingleCart(){
        GetSingleCartMethod api= new GetSingleCartMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();
        api.validateResponseAgainstSchema("api/carts/_get/_getSingle/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "paula")
    public void testGetCartsByUser(){ // -- not passed, because something is wrong with API implementation
        GetCartsByUserMethod api= new GetCartsByUserMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

}


