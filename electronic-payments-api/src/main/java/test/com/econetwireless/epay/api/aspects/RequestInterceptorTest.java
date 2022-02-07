package test.com.econetwireless.epay.api.aspects;

import com.econetwireless.epay.api.aspects.RequestInterceptor;
import com.econetwireless.epay.api.rest.messages.TransactionsResponse;
import com.econetwireless.epay.business.services.api.PartnerCodeValidator;
import com.econetwireless.utils.enums.ResponseCode;
import com.econetwireless.utils.formatters.UtilityBuilder;
import com.econetwireless.utils.messages.AirtimeBalanceResponse;
import com.econetwireless.utils.messages.AirtimeTopupResponse;
import org.apache.commons.lang3.StringUtils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * RequestInterceptor Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Feb 6, 2022</pre>
 */
public class RequestInterceptorTest {
    TransactionsResponse transactionsResponse;
    AirtimeBalanceResponse airtimeBalanceResponse;
    AirtimeTopupResponse airtimeTopupResponse;

    @Autowired
    private PartnerCodeValidator partnerCodeValidator;

    @Before
    public void before() throws Exception {
        transactionsResponse = new TransactionsResponse();
        airtimeBalanceResponse = new AirtimeBalanceResponse();
        airtimeTopupResponse = new AirtimeTopupResponse();
    }

    @After
    public void after() throws Exception {
        transactionsResponse = null;
        airtimeBalanceResponse= null;
        airtimeTopupResponse= null;

    }

    /**
     * Method: getPartnerTransactions(final ProceedingJoinPoint joinPoint, final String partnerCode)
     */
    @Test
    public void testGetPartnerTransactions() throws Exception {

        //transactionsResponse = (TransactionsResponse) response;
        transactionsResponse = checkingMissingFields("774222278");
        Assert.assertEquals(transactionsResponse.getResponseCode(),200);

    }

    private TransactionsResponse checkingMissingFields(String partnerCode) {
        final TransactionsResponse transactionsResponse = new TransactionsResponse();
        transactionsResponse.setPartnerCode(partnerCode);
        final StringBuilder builder = new StringBuilder();
        validatePartnerCode(builder, partnerCode);
        if(builder.length() > 0) {
            transactionsResponse.setNarrative(builder.toString());
            transactionsResponse.setResponseCode(ResponseCode.INVALID_REQUEST.getCode());
        }
        return  transactionsResponse;
    }

    private static void validatePartnerCode(final StringBuilder builder, final String partnerCode) {
        UtilityBuilder.buildErrorMessage(builder, StringUtils.isEmpty(partnerCode), "Partner Code is required");

    }

    /**
     * Method: enquireAirtimeBalance(final ProceedingJoinPoint joinPoint, final String partnerCode, final String msisdn)
     */
    @Test
    public void testEnquireAirtimeBalance() throws Exception {
        boolean isEmpty = StringUtils.isNotEmpty(airtimeBalanceResponse.getResponseCode());
        Assert.assertEquals(isEmpty,false);

    }

    /**
     * Method: creditAirtime(final ProceedingJoinPoint joinPoint, final AirtimeTopupRequest airtimeTopupRequest)
     */
    @Test
    public void testCreditAirtime() throws Exception {

    }


    /**
     * Method: checkingMissingFields(final AirtimeTopupRequest airtimeTopupRequest)
     */
    @Test
    public void testCheckingMissingFieldsAirtimeTopupRequest() throws Exception {


    }

    /**
     * Method: checkingMissingFields(final String partnerCode, final String msisdn)
     */
    @Test
    public void testCheckingMissingFieldsForPartnerCodeMsisdn() throws Exception {


try { 
   Method method = RequestInterceptor.class.getMethod("checkingMissingFields", String.class, String.class);
   method.setAccessible(true); 
   method.invoke( null, "partnerCode","msisdn");
} catch(NoSuchMethodException e) {
    System.out.println(e.getMessage());
} catch(IllegalAccessException e) {
    System.out.println(e.getMessage());
} catch(InvocationTargetException e) {
    System.out.println(e.getMessage());

}

    }

    /**
     * Method: checkingMissingFields(final String partnerCode)
     */
    @Test
    public void testCheckingMissingFieldsPartnerCode() throws Exception {

    }




} 
