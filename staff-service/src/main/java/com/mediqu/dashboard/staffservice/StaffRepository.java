package com.mediqu.dashboard.staffservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mediqu.dashboard.staffservice.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
	Long countByType(Integer type);
}
