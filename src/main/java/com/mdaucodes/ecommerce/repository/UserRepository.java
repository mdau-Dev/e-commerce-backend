package com.mdaucodes.ecommerce.repository;

import com.mdaucodes.ecommerce.entity.GeneralUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<GeneralUser,Long> {

    Optional<GeneralUser> findGeneralUserByEmailIgnoreCase(String email);
    Optional<GeneralUser> findGeneralUserByTellNo(String tellNo);
}
