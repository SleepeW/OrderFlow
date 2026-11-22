package com.example.OrderFlow.orders.Entities;

import com.example.OrderFlow.products.ProductEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "order_items")
public class OrderItemsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @Column(name = "count", nullable = false)
    private int count;

    @Column(name = "unit_price", nullable = false)
    private int unit_price;

    public void plusCount() {count += 1;}

    public void minusCount() {
        if(count == 0){
            throw new IllegalArgumentException();
        }

        count -= 1;
    }

    public void changeCount(int count){
        if(count < 0){
            throw new IllegalArgumentException();
        }

        this.count = count;
    }

    public void changeUnitPrice(int price){
        if(price < 0){
            throw new IllegalArgumentException();
        }

        this.unit_price = price;
    }
}
