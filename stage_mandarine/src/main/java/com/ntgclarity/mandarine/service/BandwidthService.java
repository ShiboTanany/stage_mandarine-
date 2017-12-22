package com.ntgclarity.mandarine.service;

import com.ntgclarity.mandarine.entity.Bandwidth;
import com.ntgclarity.mandarine.exception.ApplicationException;
import com.ntgclarity.mandarine.repository.BandwidthRepository;
import com.ntgclarity.mandarine.service.base.BaseEntity;
import com.ntgclarity.mandarine.service.base.BaseRepository;
import com.ntgclarity.mandarine.service.base.BaseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sheko
 */
@Service
public class BandwidthService extends BaseService<Bandwidth> {

    @Autowired
    BandwidthRepository bandwidthRepository;

    public List<Bandwidth> getAll() {
        return (List<Bandwidth>) bandwidthRepository.findAll();
    }

    public void addBandwidth(Bandwidth bandwidth) {
        if (bandwidth.getName().trim().isEmpty()) {
            throw new ApplicationException("400", "name is required");
        }
        if (bandwidth.getValue() < 0) {
            throw new ApplicationException("400", "bandwidth must be grater than 0");
        }
        bandwidthRepository.save(bandwidth);

    }

    public void updateBandwidth(Bandwidth bandwidth) {
        if (bandwidth.getName().trim().isEmpty()) {
            throw new ApplicationException("400", "name is required");
        }
        if (bandwidth.getValue() < 0) {
            throw new ApplicationException("400", "bandwidth must be grater than 0");
        }
        bandwidthRepository.save(bandwidth);

    }

    @Override
    public BaseRepository<Bandwidth> getRepositoryInstance() {
        return bandwidthRepository;
    }

}
