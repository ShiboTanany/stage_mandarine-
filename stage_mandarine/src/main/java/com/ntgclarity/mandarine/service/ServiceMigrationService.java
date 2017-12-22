package com.ntgclarity.mandarine.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntgclarity.mandarine.entity.Contractterms;
import com.ntgclarity.mandarine.entity.Servicemigration;
import com.ntgclarity.mandarine.repository.ContractTermsRepository;
import com.ntgclarity.mandarine.repository.ServiceMigrationRepository;

@Service
public class ServiceMigrationService {
	@Autowired
	ServiceMigrationRepository serviceMigrationRepository;

	public Servicemigration addMigrationService(Servicemigration serviceMigration) {

		serviceMigrationRepository.save(serviceMigration);
		return serviceMigration;
	}

	public Servicemigration deleteMigrationService(Servicemigration serviceMigration) {

		serviceMigration.setDeleted(1);
		serviceMigrationRepository.save(serviceMigration);

		return serviceMigration;
	}

	public Servicemigration updateMigrationService(Servicemigration serviceMigration) {

		serviceMigrationRepository.save(serviceMigration);

		return serviceMigration;
	}

	public List<Servicemigration> getAllMigrationService() {
		
		Servicemigration x=new Servicemigration();
		x.setRecid(new BigDecimal("55"));
		x.setRequestid(new BigInteger("55"));
		x.setServiceid(new BigInteger("55"));
		x.setToserviceid(new BigInteger("55"));
		x.setFromserviceid(new BigInteger("55"));
		serviceMigrationRepository.save(x);
		

		return (List<Servicemigration>) serviceMigrationRepository.findAll();
	}

	public Servicemigration getMigrationService(Long id) {

		return serviceMigrationRepository.findOne(id);
	}

}