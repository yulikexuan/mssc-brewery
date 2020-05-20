//: guru.springframework.msscbrewery.web.controller.CustomerController.java


package guru.springframework.msscbrewery.web.controller;


import guru.springframework.msscbrewery.services.ICustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Slf4j
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final ICustomerService customerService;

    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(this.customerService.getCustomerById(id));
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody CustomerDto customer) {

        log.info(">>>>>>> Creating a new customer: {}", customer.toString());

        CustomerDto savedCustomer = this.customerService.save(customer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", buildUrl("/api/v1/customer",
                savedCustomer.getId().toString()));

        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(
            @PathVariable("id") UUID id,
            @Valid @RequestBody CustomerDto customer) {

        log.info(">>>>>>> Updating a existing customer: {}", customer.toString());
        this.customerService.update(id, customer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("id") UUID id) {
        log.info(">>>>>>> Deleting a customer: {}", id);
        this.customerService.delete(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<String>> validationErrorHandler(
            MethodArgumentNotValidException e) {

        int size = e.getBindingResult().getAllErrors().size();

        List<String> errors = new ArrayList<>(size);

        e.getBindingResult().getAllErrors().stream()
                .forEach(oe -> {
                    String field = ((FieldError) oe).getField();
                    String errMsg = String.join(" ", field,
                            oe.getDefaultMessage());
                    log.info(">>>>>>> " + errMsg);
                    errors.add(errMsg);
                });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    private String buildUrl(String uri, String pathVariable) {
        // TODO: Add host name to URI parameter
        return String.join("/", uri, pathVariable);
    }

}///:~