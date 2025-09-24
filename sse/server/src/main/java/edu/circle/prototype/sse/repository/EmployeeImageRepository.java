package edu.circle.prototype.sse.repository;

import edu.circle.prototype.sse.domain.EmployeeImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeImageRepository extends JpaRepository<EmployeeImage, Long> {
    Optional<EmployeeImage> findByEmployeeId(Long employeeId);
}
