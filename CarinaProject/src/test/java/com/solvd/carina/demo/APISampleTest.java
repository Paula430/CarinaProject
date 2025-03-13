package com.solvd.carina.demo;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.solvd.carina.demo.api.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
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
public class APISampleTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testCreateUser() throws Exception {
        LOGGER.info("test");
        setCases("4555,54545");
        PostUserMethod api = new PostUserMethod();
        api.setProperties("api/users/user.properties");

        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testCreateUserMissingSomeFields() throws Exception {
        PostUserMethod api = new PostUserMethod();
        api.setProperties("api/users/user.properties");
        api.getProperties().remove("name");
        api.getProperties().remove("username");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    public void testGetUsers() {
        GetUserMethods getUsersMethods = new GetUserMethods();
        getUsersMethods.callAPIExpectSuccess();
        getUsersMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        getUsersMethods.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestPriority(Priority.P1)
    public void testDeleteUsers() {
        DeleteUserMethod deleteUserMethod = new DeleteUserMethod();
        deleteUserMethod.setProperties("api/users/user.properties");
        deleteUserMethod.callAPIExpectSuccess();
        deleteUserMethod.validateResponse();
    }

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


