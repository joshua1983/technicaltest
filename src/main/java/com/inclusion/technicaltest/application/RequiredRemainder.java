package com.inclusion.technicaltest.application;

import com.inclusion.technicaltest.model.RequestReminder;
import com.inclusion.technicaltest.model.ResponseReminder;
import org.springframework.stereotype.Service;

@Service
public class RequiredRemainder {

   /*
   You are given three integers 𝑥, 𝑦 and 𝑛. Your task is to find the maximum integer 𝑘 such that 0 ≤ 𝑘 ≤ 𝑛
   that 𝑘 mod 𝑥 = 𝑦, where mod is modulo operation. Many programming languages use percent operator % to implement it.

   In other words, with given 𝑥, 𝑦 and 𝑛 you need to find the maximum possible integer from 0 to 𝑛 that has
   the remainder 𝑦 modulo 𝑥.
   */
   public ResponseReminder calculateRequiredRemainder(int x, int y, int n) {
      int result = 0;
      if (x < 0 || y < 0 || n < 0) {
         throw new IllegalArgumentException("The input values must be positive");
      }
      for (int i = n; i >= 0; i--) {
         if (i % x == y) {
            result = i;
            break;
         }
      }
      return ResponseReminder.builder().result(result).build();
   }

   // This method is used to test the application with a POST request
   public ResponseReminder calculateRequiredRemainder(RequestReminder requestReminder) throws IllegalArgumentException {

      return calculateRequiredRemainder(requestReminder.getX(), requestReminder.getY(), requestReminder.getN());
   }
}
