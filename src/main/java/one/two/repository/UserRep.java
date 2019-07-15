package one.two.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import one.two.domain.User;

public interface UserRep extends JpaRepository<User, Long>{

}
