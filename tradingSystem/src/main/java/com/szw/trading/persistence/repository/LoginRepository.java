package com.szw.trading.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.szw.trading.persistence.entity.Login;


@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
	public Login findByLoginName(String loginName);

	public Login findByLoginId(int loginId);
}
