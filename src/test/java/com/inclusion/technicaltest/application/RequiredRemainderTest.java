package com.inclusion.technicaltest.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequiredRemainderTest {

   @Test
   public void validRequiredRemainderOutputTest() {

      RequiredRemainder requiredRemainder = new RequiredRemainder();
      assertEquals(12339, requiredRemainder.calculateRequiredRemainder(7, 5, 12345).getResult());
      assertEquals(0, requiredRemainder.calculateRequiredRemainder(5, 0, 4).getResult());
      assertEquals(15, requiredRemainder.calculateRequiredRemainder(10, 5, 15).getResult());
      assertEquals(54306, requiredRemainder.calculateRequiredRemainder(17, 8, 54321).getResult());
      assertEquals(999999995, requiredRemainder.calculateRequiredRemainder(499999993, 9, 1000000000).getResult());
      assertEquals(185, requiredRemainder.calculateRequiredRemainder(10, 5, 187).getResult());
      assertEquals(999999998, requiredRemainder.calculateRequiredRemainder(2, 0, 999999999).getResult());
   }

}