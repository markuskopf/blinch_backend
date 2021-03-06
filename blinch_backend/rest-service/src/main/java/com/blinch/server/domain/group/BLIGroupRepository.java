package com.blinch.server.domain.group;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Created by markuskopf on 26/01/16.
 */

public interface BLIGroupRepository extends MongoRepository<BLIGroup, String> {

    Optional<BLIGroup> findByDomainName(String domainName);

    Optional<BLIGroup> findById(String id);

    BLIGroup save(BLIGroup saved);

    Optional<BLIGroup> findByGroupName(String groupName);
}
