package com.blinch.server.service.group;

import com.blinch.server.domain.group.BLIGroupDTO;


/**
 * Created by markuskopf on 26/01/16.
 */
public interface BLIGroupService {

    BLIGroupDTO create(BLIGroupDTO customer);

    BLIGroupDTO findById(String id);

    BLIGroupDTO findByDomainName(String domainName);

    BLIGroupDTO findByGroupName(String findByGroupName);

}
