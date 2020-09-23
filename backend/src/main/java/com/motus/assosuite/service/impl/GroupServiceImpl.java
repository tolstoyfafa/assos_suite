package com.motus.assosuite.service.impl;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.motus.assosuite.api.exceptions.BusinessException;
import com.motus.assosuite.enums.AssosBusinessErrorCode;
import com.motus.assosuite.models.Group;
import com.motus.assosuite.repository.GroupRepository;
import com.motus.assosuite.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {

	private final GroupRepository repository;

	public GroupServiceImpl(GroupRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Group create(Group group) throws BusinessException {
		if (!(repository.findByName() == null)) {
			throw new BusinessException("Group with this name already exists", AssosBusinessErrorCode.GROUP_EXISTS);
		}
		return repository.save(group);
	}

	@Override
	public Group update(Group group, String uuid) throws BusinessException {
		Group found = repository.findByUuid(uuid);
		if (found == null) {
			throw new BusinessException("No Group has been found", AssosBusinessErrorCode.ADHERENT_NOT_FOUND);
		}
		found.setName(group.getName());
		found.setModificationDate(group.getModificationDate());
		return repository.save(found);
	}

	@Override
	public Group find(String uuid) throws BusinessException {
		Group found = repository.findByUuid(uuid);
		if (found == null) {
			throw new BusinessException("No Group has been found", AssosBusinessErrorCode.ADHERENT_NOT_FOUND);
		}
		return found;
	}

	@Override
	public void delete(String uuid) throws BusinessException {
		Group found = repository.findByUuid(uuid);
		if (found == null) {
			throw new BusinessException("No Group has been found", AssosBusinessErrorCode.ADHERENT_NOT_FOUND);
		}
		repository.delete(found);
	}
	
	@Override
	public List<Group> findAll(Integer pageNum, Integer pageSize, String order, String field) {
		pageNum = pageNum - 1;
		List<Group> fullList = repository.findAll();
		if (pageNum != null & pageSize != null) {
			Pageable paging = PageRequest.of(pageNum, pageSize);
			if (order.equals("DESC")) {
				paging = PageRequest.of(pageNum, pageSize, Sort.by(Direction.DESC, field));
			} else {
				paging = PageRequest.of(pageNum, pageSize, Sort.by(Direction.ASC, field));
			}
			return repository.findAll(paging).toList();
		}
		return fullList;
	}

	@Override
	public List<Group> findAll() {
		return repository.findAll();
	}

}
