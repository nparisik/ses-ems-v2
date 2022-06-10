package org.securitases.union.sesems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.securitases.union.sesems.domain.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> { // Useful for basic CRUD ops.

	// Auto-implemented by Spring into a Bean
}
