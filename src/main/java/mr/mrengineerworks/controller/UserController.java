package mr.mrengineerworks.controller;

import mr.mrengineerworks.entity.UserDetails;
import mr.mrengineerworks.service.EmailService;
import mr.mrengineerworks.service.UserDetailService;
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;


@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "https://mrengineeringworks.netlify.app")  
public class UserController {

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private EmailService emailService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class); 

    @PostMapping("/SubmitDetails")
    public ResponseEntity<String> userDetailsForm(@RequestBody UserDetails userDetails) {
        try {
            UserDetails user = userDetailService.saveUser(userDetails);

            String subject = "New User Details Submitted";
            String body = "User Details:\n" +
                          "Name: " + user.getName() + "\n" +
                          "Email: " + user.getEmail() + "\n" +
                          "Phone Number: " + user.getPhoneNumber() + "\n" +
                          "Subject: " + user.getSubject() + "\n" +
                          "Message: " + user.getMessage();

            String adminEmail = "admin@example.com"; 
            emailService.sendEmail(adminEmail, subject, body);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Submitted Successfully");
        } catch (Exception e) {
            logger.error("Error occurred while submitting user details: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to process request: " + e.getMessage());
        }
    }
}
