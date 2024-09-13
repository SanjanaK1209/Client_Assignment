package controller;

<<<<<<< HEAD
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
=======
import java.util.Map;
import java.util.Optional;

>>>>>>> aeb808a8a5fb0aecd6bfc047de98b6c9437014c3
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestParam;
=======
>>>>>>> aeb808a8a5fb0aecd6bfc047de98b6c9437014c3
import org.springframework.web.bind.annotation.RestController;

import exceptions.CustomerNotFoundException;
import model.Customer;
<<<<<<< HEAD
import model.RewardResponse;
import service.CustomerService;
import service.RewardService;
=======
import service.CustomerService;
>>>>>>> aeb808a8a5fb0aecd6bfc047de98b6c9437014c3

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
<<<<<<< HEAD
    
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private RewardService rewardService;
    
    @GetMapping("/getcust")  //testing
    public String getCustomers() {
        logger.info("Request received for getting the list of customers.");
        return "List of customers";
    }
    

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) {
        logger.info("Request received to register customer with email: {}", customer.getEmail());
        try {
            Customer registeredCustomer = customerService.registerCustomer(customer);
            logger.info("Customer registered successfully with email: {}", registeredCustomer.getEmail());
            return ResponseEntity.ok(registeredCustomer);
        } catch (Exception e) {
            logger.error("Error registering customer with email: {}", customer.getEmail(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error registering customer");
        }
=======
    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/getcust")  //testing
    public String getCustomers() {
        return "List of customers";
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
        Customer registeredCustomer = customerService.registerCustomer(customer);
        return ResponseEntity.ok(registeredCustomer);
>>>>>>> aeb808a8a5fb0aecd6bfc047de98b6c9437014c3
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> loginCustomer(@RequestBody Map<String, String> loginData) {
<<<<<<< HEAD
        logger.info("Login attempt for email: {}", loginData.get("email"));
        Optional<Customer> customer = customerService.findCustomerByEmail(loginData.get("email"));
        if (customer.isPresent() && customer.get().getPassword().equals(loginData.get("password"))) {
            logger.info("Login successful for email: {}", loginData.get("email"));
            return ResponseEntity.ok("Login successful");
        } else {
            logger.warn("Invalid credentials for email: {}", loginData.get("email"));
            throw new CustomerNotFoundException("Invalid credentials");
        }
    }
    
=======
        Optional<Customer> customer = customerService.findCustomerByEmail(loginData.get("email"));
        if (customer.isPresent() && customer.get().getPassword().equals(loginData.get("password"))) {
            return ResponseEntity.ok("Login successful");
        }
        throw new CustomerNotFoundException ("Invalid credentials");
    }
>>>>>>> aeb808a8a5fb0aecd6bfc047de98b6c9437014c3
}

