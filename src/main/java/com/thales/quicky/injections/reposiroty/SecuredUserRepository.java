package com.thales.quicky.injections.reposiroty;

import com.thales.quicky.injections.model.SecuredUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SecuredUserRepository extends CrudRepository<SecuredUser, Long> {
    List<SecuredUser> findAllByUsername(String username);
}

