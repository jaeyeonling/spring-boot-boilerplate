package com.jaeyeonling.boilerplate.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PostRepository extends JpaRepository<Post, Long> {
}
