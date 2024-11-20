package com.jeffwork.UserWork.models.data;

import com.jeffwork.UserWork.models.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends CrudRepository<Image, Integer> {
}
