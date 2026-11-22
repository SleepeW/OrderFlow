package com.example.OrderFlow.storages.Repositories;

import com.example.OrderFlow.storages.Entities.StorageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends JpaRepository<StorageEntity, Long> {
}
