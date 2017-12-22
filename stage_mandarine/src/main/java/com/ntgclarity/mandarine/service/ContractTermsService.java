package com.ntgclarity.mandarine.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
//import org.apache.poi.hssf.record.crypto.Biff8DecryptingStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntgclarity.mandarine.entity.Contractterms;
import com.ntgclarity.mandarine.repository.ComponentRepository;
import com.ntgclarity.mandarine.repository.ContractTermsRepository;
@Service
public class ContractTermsService {
	@Autowired
	ContractTermsRepository contractTermsReposirtory;

	public Contractterms addContractTerm(Contractterms contractTerm) {

		contractTermsReposirtory.save(contractTerm);
		return contractTerm;
	}

	public Contractterms deleteContractTerm(Contractterms contractTerm) {

		contractTerm.setDeleted(1);
		contractTermsReposirtory.save(contractTerm);

		return contractTerm;
	}

	public Contractterms updateContractTerm(Contractterms contractTerm) {

		contractTermsReposirtory.save(contractTerm);

		return contractTerm;
	}

	public List<Contractterms> getAllContractTerms() {
		
		
				
		
		return (List<Contractterms>) contractTermsReposirtory.findAll();
	}

	public Contractterms getContractTerm(Long id) {

		return contractTermsReposirtory.findOne(id);
	}

}
