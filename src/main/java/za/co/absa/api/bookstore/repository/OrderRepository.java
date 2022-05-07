package za.co.absa.api.bookstore.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import za.co.absa.api.bookstore.model.Order;

public interface OrderRepository extends ReactiveMongoRepository<Order, ObjectId> {
}
