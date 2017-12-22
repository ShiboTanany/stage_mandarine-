package com.ntgclarity.mandarine.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntgclarity.mandarine.entity.Contractterms;
import com.ntgclarity.mandarine.entity.Modifyreason;
import com.ntgclarity.mandarine.repository.ContractTermsRepository;
import com.ntgclarity.mandarine.repository.ModifyReasonRepository;

@Service
public class ModifyReasonService {

	
	@Autowired
	ModifyReasonRepository modifyReasonRepository;

	public Modifyreason addModifyReason(Modifyreason modifyReson) {

		modifyReasonRepository.save(modifyReson);
		return modifyReson;
	}

	public Modifyreason deleteModifyReason(Modifyreason modifyReson) {

		modifyReson.setDeleted(1);
		modifyReasonRepository.save(modifyReson);

		return modifyReson;
	}

	public Modifyreason updateModifyReason(Modifyreason modifyReson) {

		modifyReasonRepository.save(modifyReson);

		return modifyReson;
	}

	public List<Modifyreason> getAllModifyReason() {
		
		Modifyreason x=new  Modifyreason();
		x.setRecid(new BigDecimal("5"));
		x.setId(new Long("55"));
		x.setModifyreason("dslkdlskds");
		modifyReasonRepository.save(x);

		return (List<Modifyreason>) modifyReasonRepository.findAll();
	}

	public Modifyreason getModifyReason(Long id) {

		return modifyReasonRepository.findOne(id);
	}


}
