package com.inclusion.technicaltest.application;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequiredRemainderTest {

   @Test
   public void validRequiredRemainderOutputTest() {

      RequiredRemainder requiredRemainder = new RequiredRemainder();
      assertEquals(12339, requiredRemainder.requiredRemainder(7, 5, 12345).getResult());
      assertEquals(0, requiredRemainder.requiredRemainder(5, 0, 4).getResult());
      assertEquals(15, requiredRemainder.requiredRemainder(10, 5, 15).getResult());
      assertEquals(54306, requiredRemainder.requiredRemainder(17, 8, 54321).getResult());
      assertEquals(999999995, requiredRemainder.requiredRemainder(499999993, 9, 1000000000).getResult());
      assertEquals(185, requiredRemainder.requiredRemainder(10, 5, 187).getResult());
      assertEquals(999999998, requiredRemainder.requiredRemainder(2, 0, 999999999).getResult());
   }

}