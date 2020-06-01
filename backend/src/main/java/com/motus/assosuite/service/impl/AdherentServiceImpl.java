package com.motus.assosuite.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.motus.assosuite.api.exceptions.BusinessException;
import com.motus.assosuite.enums.AssosBusinessErrorCode;
import com.motus.assosuite.models.Adherent;
import com.motus.assosuite.repository.AdherentRepository;
import com.motus.assosuite.service.AdherentService;
import com.motus.assosuite.service.MailService;

@Service
public class AdherentServiceImpl implements AdherentService {

	private final AdherentRepository repository;
	
	private final MailService mailService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AdherentServiceImpl.class);

	@Autowired
	public AdherentServiceImpl(AdherentRepository repository,
			MailService mailSender) {
		this.repository = repository;
		this.mailService = mailSender;
	}

	@Override
	public Adherent create(Adherent adherent) {
		try {
			mailService.sendMailOnAdd(adherent.getMail());
		} catch (MessagingException e) {
			e.printStackTrace();
		}catch (IOException e) {
            e.printStackTrace();
        }
		return repository.save(adherent);
	}

	@Override
	public List<Adherent> findAll(Integer pageNum, Integer pageSize, String order, String field) {
		if (pageNum != null & pageSize != null) {
			LOGGER.info("Service ==> PAGINATION findAll");
			Pageable paging = PageRequest.of(pageNum, pageSize);
			if (field != null) {
				LOGGER.info("Service ==> SORTING findAll");
				paging = PageRequest.of(pageNum, pageSize, Sort.by(field));
				if (order != null) {
					if (order.equals("DESC")) {
						LOGGER.info("Service ==> ORDER DESC findAll", order);
						paging = PageRequest.of(pageNum, pageSize, Sort.by(Direction.DESC, field));
					} else {
						paging = PageRequest.of(pageNum, pageSize, Sort.by(Direction.ASC, field));
					}
				}
			}
			return repository.findAll(paging).toList();
		}
		LOGGER.info("Service ==> FULL findAll");
		return repository.findAll();
	}

	@Override
	public Adherent update(Adherent adherent, String uuid) {
		Adherent adherentIn = repository.findByUuid(uuid);
		if (adherentIn == null) {
			throw new BusinessException("Adherent not found in DB", AssosBusinessErrorCode.ADHERENT_NOT_FOUND);
		}
		adherentIn.setFirstName(adherent.getFirstName());
		adherentIn.setLastName(adherent.getLastName());
		adherentIn.setMail(adherent.getMail());
		adherentIn.setPhone(adherent.getPhone());
		adherentIn.setAddress(adherent.getAddress());
		adherentIn.setBirthDay(adherent.getBirthDay());
		adherentIn.setFamilialSituation(adherent.getFamilialSituation());
		adherentIn.setGenderType(adherent.getGenderType());
		adherentIn.setModificationDate(new Date());
		return repository.save(adherentIn);
	}

	@Override
	public Adherent find(String uuid) {
		Adherent adherent = repository.findByUuid(uuid);
		if (adherent == null) {
			throw new BusinessException("Adherent not found in DB", AssosBusinessErrorCode.ADHERENT_NOT_FOUND);
		}
		return adherent;
	}

	@Override
	public void delete(String uuid) {
		Adherent adherent = repository.findByUuid(uuid);
		if (adherent == null) {
			throw new BusinessException("Adherent not found in DB", AssosBusinessErrorCode.ADHERENT_NOT_FOUND);
		}
		repository.delete(adherent);
	}

}
