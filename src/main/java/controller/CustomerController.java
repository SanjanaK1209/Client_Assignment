package controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exceptions.CustomerNotFoundException;
import model.Customer;
import model.RewardResponse;
import service.CustomerService;
import service.RewardService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    
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
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> loginCustomer(@RequestBody Map<String, String> loginData) {
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
    
    @GetMapping("/rewards/batch")
    public ResponseEntity<Map<Long, RewardResponse>> getRewardPointsForCustomers(@RequestParam List<Long> customerIds) {
    	logger.info("Received request for calculating rewards for multiple customers: {}", customerIds);
        Map<Long, RewardResponse> rewardsMap = rewardService.calculateRewardsForMultipleCustomers(customerIds);
        logger.info("Rewards calculated for customers: {}", rewardsMap.keySet());
        return new ResponseEntity<>(rewardsMap, HttpStatus.OK);
    }
}

