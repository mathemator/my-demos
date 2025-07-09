package ru.mathemator.demo.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mathemator.demo.graphql.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}