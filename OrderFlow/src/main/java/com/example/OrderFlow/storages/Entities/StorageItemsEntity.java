package com.example.OrderFlow.storages.Entities;

import com.example.OrderFlow.products.ProductEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "storage_items")
public class StorageItemsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "storage_id", nullable = false)
    private StorageEntity storage;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @Column(name = "count", nullable = false)
    private int count;

    @Column(name = "reserv", nullable = false)
    private int reserve;

    public void changeCount(int count){
        if(count < 0 || count < reserve){
            throw new IllegalArgumentException();
        }

        this.count = count;
    }

    public void changeReserve(int count){
        if(count < 0 || count > this.count){
            throw new IllegalArgumentException();
        }

        this.reserve = count;
    }
}
