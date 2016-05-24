package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Taylor on 5/21/16.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {

}