package com.jeffwork.UserWork.models.data;

import com.jeffwork.UserWork.models.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImageRepository extends CrudRepository<Image, Integer> {
}
