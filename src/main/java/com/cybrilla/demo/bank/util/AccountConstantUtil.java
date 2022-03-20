package com.cybrilla.demo.bank.util;

/**
 * 
 * @author Rajesh NK
 *
 */
public class AccountConstantUtil {

    private AccountConstantUtil() {
    	
    }
    
    public static final String BAD_REQUEST_EXCEPTION_MSG = "Request could not be "
    		+ " processed due to illegal argument";
    
    public static final String INTERNAL_SERVER_ERROR_EXCEPTION_MSG = "Error occured while "
    		+ " processing the request";
    
    public static final String UNAUTHORIZED_EXCEPTION_MSG = "You are not authorized to perform the operation";
    
    public static final String CONFLICT_MSG = "Data provided already in database";
    
    
    
}
