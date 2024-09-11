package controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exceptions.CustomerNotFoundException;
import model.Customer;
import service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
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
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> loginCustomer(@RequestBody Map<String, String> loginData) {
        Optional<Customer> customer = customerService.findCustomerByEmail(loginData.get("email"));
        if (customer.isPresent() && customer.get().getPassword().equals(loginData.get("password"))) {
            return ResponseEntity.ok("Login successful");
        }
        throw new CustomerNotFoundException ("Invalid credentials");
    }
}

