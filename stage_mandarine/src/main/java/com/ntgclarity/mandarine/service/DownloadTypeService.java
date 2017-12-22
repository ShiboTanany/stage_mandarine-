/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.service;

import com.ntgclarity.mandarine.constants.CodesAndKeys;
import com.ntgclarity.mandarine.dto.StatusResponse;
import com.ntgclarity.mandarine.entity.Category;
import com.ntgclarity.mandarine.entity.DownloadType;
import com.ntgclarity.mandarine.exception.ApplicationException;
import com.ntgclarity.mandarine.repository.DownloadTypeRepository;
import com.ntgclarity.mandarine.service.base.BaseRepository;
import com.ntgclarity.mandarine.service.base.BaseService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yasmeen
 */
@Service
public class DownloadTypeService extends BaseService<DownloadType> {

    @Autowired
    DownloadTypeRepository downloadTypeRepository;

    public void addDownloadType(DownloadType downloadType) {

        downloadTypeRepository.save(downloadType);
    }

    public void updateDownloadType(DownloadType downloadType) {
        if (downloadType.getName().trim().isEmpty()) {
            throw new ApplicationException("400", "category name and type are required");
        }
        downloadTypeRepository.save(downloadType);
    }

    public void deleteDownloadType(DownloadType downloadType) {
      
        downloadType.setDeleted(1);
        downloadTypeRepository.save(downloadType);
    }

    public List<DownloadType> getAllDownloadTypes() {
        List<DownloadType> downloadTypes = new ArrayList<>();
        downloadTypes = (List<DownloadType>) downloadTypeRepository.findAll();
        return downloadTypes;
    }

    public DownloadType getDownloadTypeById(Long id) {

		return downloadTypeRepository.findOne(id);
	}
    @Override
    public BaseRepository<DownloadType> getRepositoryInstance() {
        return downloadTypeRepository;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
