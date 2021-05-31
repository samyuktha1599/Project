package com.g6.onlineeyecare.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g6.onlineeyecare.admin.dto.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer>{

}
