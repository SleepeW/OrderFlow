package com.example.OrderFlow.storages.Repositories;

import com.example.OrderFlow.storages.Entities.StorageItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageItemsRepository extends JpaRepository<StorageItemsEntity, Long> {
}
