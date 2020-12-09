package io.github.lucianoza.domain.repository;

import io.github.lucianoza.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {
}
