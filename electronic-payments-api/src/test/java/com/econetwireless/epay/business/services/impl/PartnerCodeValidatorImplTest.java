package com.econetwireless.epay.business.services.impl;

import com.econetwireless.epay.api.aspects.RequestInterceptor;
import com.econetwireless.epay.api.rest.messages.TransactionsResponse;
import com.econetwireless.epay.dao.requestpartner.api.RequestPartnerDao;
import com.econetwireless.epay.domain.RequestPartner;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class PartnerCodeValidatorImplTest extends TestCase {


    private String partnerCode;

    @Mock
    private RequestPartnerDao requestPartnerDao;

    @Before
    public void init() {
        partnerCode = "hot-recharge";
        RequestPartner requestPartner = new RequestPartner();
        requestPartner.setId(123l);
        requestPartner.setCode(partnerCode);
        requestPartner.setName("Hot Recharge");
        requestPartner.setDescription("HOT RECHARGE PLATFORM");
        when(requestPartnerDao.findByCode(partnerCode)).thenReturn(requestPartner);
    }

    @Test
    public void testValidatePartnerCode() {
        assertTrue(requestPartnerDao.findByCode(partnerCode) != null);
    }
}