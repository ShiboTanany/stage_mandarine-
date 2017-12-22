/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntgclarity.mandarine.service;

import com.ntgclarity.mandarine.entity.CancelationReason;
import com.ntgclarity.mandarine.repository.CancelationReasonRepository;
import com.ntgclarity.mandarine.service.base.BaseRepository;
import com.ntgclarity.mandarine.service.base.BaseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yasmeen
 */
@Service
public class CancelationReasonService extends BaseService<CancelationReason>{
        @Autowired
        CancelationReasonRepository cancelationReasonRepository;

   
    public void addCancelationReason(CancelationReason cancelationReason)
    {
        cancelationReasonRepository.save(cancelationReason);
    }
    public void updateCancelationReason(CancelationReason cancelationReason) {
		cancelationReasonRepository.save(cancelationReason);
	}
    public void deleteCancelationReason(CancelationReason cancelationReason) {
		cancelationReason.setDeleted(1);
		cancelationReasonRepository.save(cancelationReason);
	}
    public List<CancelationReason> getAllCancelationReasons()
    {
        return (List<CancelationReason>) cancelationReasonRepository.findAll();
    }
    
    public CancelationReason getCancelationReasonById(Long id) {

		return cancelationReasonRepository.findOne(id);
	}

    @Override
    public BaseRepository<CancelationReason> getRepositoryInstance() {
    return cancelationReasonRepository;
    }
}
