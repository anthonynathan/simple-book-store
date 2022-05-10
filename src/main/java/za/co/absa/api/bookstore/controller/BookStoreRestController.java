package za.co.absa.api.bookstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.support.ModelAndViewContainer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import za.co.absa.api.bookstore.model.Order;
import za.co.absa.api.bookstore.model.OrderDTO;
import za.co.absa.api.bookstore.service.OrderService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Valid
@CrossOrigin
@RestController
@SecurityRequirement(name = "security_auth")
//@RequestMapping("/bookstore")
public class BookStoreRestController {
    private final OrderService orderService;

    @Autowired
    public BookStoreRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public ModelAndViewContainer redirectToSwagger() {
        return new ModelAndViewContainer().addAttribute("redirect", "/webjars/swagger-ui/index.html");
    }

    @Valid
    @CrossOrigin
    @SecurityRequirement(name = "code")
    @PostMapping("/order")
    @RouterOperation(
            path = "/order",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE},
            method = RequestMethod.POST,
            beanClass = BookStoreRestController.class,
            beanMethod = "createOrder",
            operation = @Operation(
                    operationId = "createOrder",
                    responses = {
                            @ApiResponse(responseCode = "200", description = "Success",
                                         content = @Content(schema = @Schema(implementation = Order.class))),
                            @ApiResponse(responseCode = "500", description = "Internal server error"),
                            @ApiResponse(responseCode = "404", description = "Service not found")},
                    requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                            content = @Content(schema = @Schema(implementation = OrderDTO.class)))))
    public Mono<Order> createOrder(@RequestBody @Valid OrderDTO orderDTO) {
        Order order = new Order();
        order.setIsbn(orderDTO.getIsbn());
        order.setTitle(orderDTO.getTitle());
        order.setAuthor(orderDTO.getAuthor());
        order.setOrderQuantity(orderDTO.getOrderQuantity());
        order.setOderTimeStamp(LocalDateTime.now());

        return orderService.createOrder(order);
    }

    @CrossOrigin
    @SecurityRequirement(name = "code")
    @GetMapping("/orders")
    @RouterOperation(
            path = "/orders",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            method = RequestMethod.GET,
            beanClass = BookStoreRestController.class,
            beanMethod = "getOrders",
            operation = @Operation(
                    operationId = "getOrders",
                    responses = {
                            @ApiResponse(responseCode = "200", description = "Success",
                                         content = @Content(schema = @Schema(implementation = List.class))),
                            @ApiResponse(responseCode = "500", description = "Internal server error"),
                            @ApiResponse(responseCode = "404", description = "Service not found")}))
    public Flux<Order> getOrders() {
        return orderService.getOrders();
    }
}
