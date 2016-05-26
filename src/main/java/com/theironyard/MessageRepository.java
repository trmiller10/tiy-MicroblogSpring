package com.theironyard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Taylor on 5/21/16.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
    //List<Message> findById(String message, int id);
}