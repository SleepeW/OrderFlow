package com.example.OrderFlow.products;

import com.example.OrderFlow.users.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@Table(name="products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="owner_user_id", nullable = false)
    private UserEntity owner_user_id;

    @Column(name="name", nullable = false)
    private String name;

    @Setter
    @Column(name="description")
    private String description;

    @Column(name="price", nullable = false)
    private int price;

    public void changeName(String name){
        if(name == null){
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    public void changePrice(int price){
        if(price < 0){
            throw new IllegalArgumentException();
        }

        this.price = price;
    }
}
