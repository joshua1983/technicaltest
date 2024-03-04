package com.inclusion.technicaltest.utils;

import com.inclusion.technicaltest.model.RequestReminder;

public class RequiredReminderRequestMother {
   public static RequestReminder createValidRequestReminder() {
      return new RequestReminder(7, 5, 12345);
   }
   public static RequestReminder createInvalidRequestReminder() {
      return new RequestReminder(7, -5, 12345);
   }
}
