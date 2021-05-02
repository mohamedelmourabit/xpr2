package com.xpr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.xpr.entities.News;


@RepositoryRestResource(collectionResourceRel = "news", path = "news")
public interface NewsRepository extends JpaRepository<News, String> {
		

}
