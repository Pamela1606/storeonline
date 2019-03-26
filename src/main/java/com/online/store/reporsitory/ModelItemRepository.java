package com.online.store.reporsitory;

import com.online.store.models.ModelItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelItemRepository extends JpaRepository<ModelItem, Long> {
}
