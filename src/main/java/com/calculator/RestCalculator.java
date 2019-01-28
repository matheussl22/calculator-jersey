package com.calculator;

import org.glassfish.jersey.server.JSONP;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

/**
 * exposed at "rest-calculator" path
 */

@Path("rest-calculator")
public class RestCalculator {

    /**
     * Method handling the add operation for up to three params.
     * to the client as "application/json" media type.
     *
     * @param firstValue the first number
     * @param secondValue the second number
     * @param thirdValue the third number
     * @return String response.
     */
    @GET
    @JSONP
    @Path("/add/{firstValue}/{secondValue}/{thirdValue}")
    @Produces({"application/javascript", MediaType.APPLICATION_JSON})
    public Response add(@PathParam("firstValue") double firstValue, @PathParam("secondValue") double secondValue, @PathParam("thirdValue") double thirdValue) {
        ResultDto resultDto = new ResultDto();
        resultDto.setResult(firstValue + secondValue + thirdValue);
        return CacheController.build(resultDto);
    }

    /**
     * Method handling the subtract operation for up to three params.
     * to the client as "application/json" media type.
     *
     * @param firstValue the first number
     * @param secondValue the second number
     * @param thirdValue the third number
     * @return String response.
     */
    @GET
    @JSONP
    @Path("/subtract/{firstValue}/{secondValue}/{thirdValue}")
    @Produces({"application/javascript", MediaType.APPLICATION_JSON})
    public Response subtract(@PathParam("firstValue") double firstValue, @PathParam("secondValue") double secondValue, @PathParam("thirdValue") double thirdValue) {
        ResultDto resultDto = new ResultDto();
        resultDto.setResult(firstValue - secondValue - thirdValue);
        return CacheController.build(resultDto);
    }

    /**
     * Method handling the multiply operation for up to three params.
     * to the client as "application/json" media type.
     *
     * @param firstValue firstValue the first number
     * @param secondValue secondValue the second number
     * @param thirdValue thirdValue the third number
     * @return String response.
     */
    @GET
    @JSONP
    @Path("/multiply/{firstValue}/{secondValue}/{thirdValue}")
    @Produces({"application/javascript", MediaType.APPLICATION_JSON})
    public Response multiply(@PathParam("firstValue") double firstValue, @PathParam("secondValue") double secondValue, @PathParam("thirdValue") double thirdValue) {
        ResultDto resultDto = new ResultDto();
        resultDto.setResult(firstValue * secondValue * thirdValue);
        return CacheController.build(resultDto);
    }

    /**
     * Method handling the divide operation for up to two params.
     * to the client as "application/json" media type.
     *
     * @param firstValue the first number
     * @param secondValue the second number
     * @return String response.
     */
    @GET
    @JSONP
    @Path("/divide/{firstValue}/{secondValue}")
    @Produces({"application/javascript", MediaType.APPLICATION_JSON})
    public Response divide(@PathParam("firstValue") double firstValue, @PathParam("secondValue") double secondValue) {
        ResultDto resultDto = new ResultDto();
        if (secondValue > 0 && firstValue > 0)
            resultDto.setResult(firstValue / secondValue);
        else
            resultDto.setResult(0.0);
        return CacheController.build(resultDto);
    }

    /**
     * Method handling the add operation for up to two params.
     * to the client as "application/json" media type.
     *
     * @param firstValue firstValue the first number
     * @param secondValue secondValue the second number percentage
     * @return String response.
     */
    @GET
    @JSONP
    @Path("/add-percent/{firstValue}/{secondValue}")
    @Produces({"application/javascript", MediaType.APPLICATION_JSON})
    public Response addPercent(@PathParam("firstValue") double firstValue, @PathParam("secondValue") double secondValue) {
        ResultDto resultDto = new ResultDto();
        resultDto.setResult(firstValue + (firstValue * secondValue / 100));
        return CacheController.build(resultDto);
    }

    /**
     * Method handling the subtract operation for up to two params.
     * to the client as "application/json" media type.
     *
     * @param firstValue firstValue the first number
     * @param secondValue secondValue the second number percentage
     * @return String response.
     */
    @GET
    @JSONP
    @Path("/subtract-percent/{firstValue}/{secondValue}")
    @Produces({"application/javascript", MediaType.APPLICATION_JSON})
    public Response subtractPercent(@PathParam("firstValue") double firstValue, @PathParam("secondValue") double secondValue) {
        ResultDto resultDto = new ResultDto();
        resultDto.setResult(firstValue - (firstValue * secondValue / 100));
        return CacheController.build(resultDto);
    }

}