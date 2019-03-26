package com.online.store.reporsitory;

import com.online.store.models.InventoryState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryStateRepository extends JpaRepository<InventoryState, Long> {
}
