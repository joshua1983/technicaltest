package com.inclusion.technicaltest.model;

import lombok.Data;

@Data
public class RequestReminder {

   int x;
   int y;
   int n;


   public RequestReminder(int x, int y, int n) {

      this.x = x;
      this.y = y;
      this.n = n;

   }
}
