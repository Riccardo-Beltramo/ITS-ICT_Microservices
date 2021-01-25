package org.example.borrow.repos;

import org.example.borrow.models.Borrow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepository extends CrudRepository<Borrow,Long> {
}