package br.com.original.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.original.model.security.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
