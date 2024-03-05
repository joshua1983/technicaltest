package com.inclusion.technicaltest.infrastructure;


import com.inclusion.technicaltest.application.RequiredRemainder;
import com.inclusion.technicaltest.model.RequestReminder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequiredReminderController {

   private final RequiredRemainder requiredRemainder;


   @Autowired
   public RequiredReminderController(RequiredRemainder requiredRemainder) {

      this.requiredRemainder = requiredRemainder;
   }


   @GetMapping("/required-remainder/{x}/{y}/{n}")
   public ResponseEntity<?> requiredRemainder(
      @PathVariable int x,
      @PathVariable int y,
      @PathVariable int n
   ) {

      try {
         return ResponseEntity.ok(requiredRemainder.calculateRequiredRemainder(x, y, n));
      } catch (Exception e) {
         return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
      }
   }

   @GetMapping("/required-remainder")
    public ResponseEntity<?> requiredRemainderGet(
        @RequestParam int x,
        @RequestParam int y,
        @RequestParam int n
    ) {

        try {
          return ResponseEntity.ok(requiredRemainder.calculateRequiredRemainder(x, y, n));
        } catch (IllegalArgumentException e) {
          return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


   @PostMapping("/required-remainder")
   public ResponseEntity<?> requiredRemainderPost(
      @RequestBody RequestReminder requestReminder
   ) {

      try {
         return ResponseEntity.ok(requiredRemainder.calculateRequiredRemainder(requestReminder));
      } catch (IllegalArgumentException e) {
         return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
      }
   }
}
