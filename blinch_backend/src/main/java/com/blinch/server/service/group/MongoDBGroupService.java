package com.blinch.server.service.group;

import com.blinch.server.domain.group.BLIGroup;
import com.blinch.server.domain.group.BLIGroupDTO;
import com.blinch.server.domain.group.BLIGroupRepository;
import com.blinch.server.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by markuskopf on 26/01/16.
 */
@Service
final class MongoDBGroupService implements BLIGroupService {

    private final BLIGroupRepository groupRepository;

    @Autowired
    MongoDBGroupService(BLIGroupRepository repository) {
        this.groupRepository = repository;
    }

    @Override
    public BLIGroupDTO create(BLIGroupDTO customer) {
        BLIGroup persistend = new BLIGroup(customer.getDomainName(), customer.getGroupName(),customer.getCity(), customer.getCountry());
        persistend = groupRepository.save(persistend);

        return convertToDTO(persistend);
    }

    @Override
    public BLIGroupDTO findById(String id) {
        return convertToDTO(findGroupEntityById(id));
    }

    @Override
    public BLIGroupDTO findByDomainName(String domainName) {
        return convertToDTO(findGroupEntityByDomain(domainName));
    }

    @Override
    public BLIGroupDTO findByGroupName(String groupName) {
        return convertToDTO(findGroupByGroupName(groupName));
    }

    private BLIGroup findGroupByGroupName(String groupName) {
        Optional<BLIGroup> result = groupRepository.findByGroupName(groupName);
        return result.orElseThrow(() -> new UserNotFoundException(groupName));
    }

    private BLIGroup findGroupEntityByDomain(String domainName) {
        Optional<BLIGroup> result = groupRepository.findByDomainName(domainName);
        return result.orElseThrow(() -> new UserNotFoundException(domainName));
    }

    private BLIGroup findGroupEntityById(String id) {
        Optional<BLIGroup> result = groupRepository.findById(id);
        return result.orElseThrow(() -> new UserNotFoundException(id));
    }

    // convert entity into dto

    private BLIGroupDTO convertToDTO(BLIGroup model) {
        BLIGroupDTO dto =  new BLIGroupDTO();
        dto.setGroupName(model.getGroupName());
        dto.setDomainName(model.getDomainName());
        dto.setCity(model.getCity());
        dto.setCountry(model.getCountry());
        dto.setId(model.getId());

        return dto;
    }



}
