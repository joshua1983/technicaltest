package com.inclusion.technicaltest;

import com.inclusion.technicaltest.application.RequiredRemainder;
import com.inclusion.technicaltest.model.RequestReminder;
import com.inclusion.technicaltest.model.ResponseReminder;
import com.inclusion.technicaltest.utils.RequiredReminderRequestMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TechnicalTestApplicationTests {

   private final RequiredRemainder requiredReminderApplication;


   @Autowired
   TechnicalTestApplicationTests(RequiredRemainder requiredReminderApplication) {

      this.requiredReminderApplication = requiredReminderApplication;
   }


   @Test
   void testEndpointRequiredRemainderValidPost() {

      RequestReminder validRequestReminder = RequiredReminderRequestMother.createValidRequestReminder();
      ResponseReminder responseReminder =  requiredReminderApplication.requiredRemainder(validRequestReminder);
      Assertions.assertNotNull(responseReminder);
      Assertions.assertEquals(12339,responseReminder.getResult());

   }

   @Test
   void testEndpointRequiredRemainderValidGet() {
      ResponseReminder responseReminder = requiredReminderApplication.requiredRemainder(7, 5, 12345);
      Assertions.assertNotNull(responseReminder);
      Assertions.assertEquals(12339, responseReminder.getResult());
   }

   @Test
   void testEndpointRequiredRemainderInvalidPost() {
      RequestReminder invalidRequestReminder = RequiredReminderRequestMother.createInvalidRequestReminder();
      try{
         requiredReminderApplication.requiredRemainder(invalidRequestReminder);
      } catch (IllegalArgumentException e) {
         Assertions.assertEquals("The input values must be positive", e.getMessage());
      }
   }

}
