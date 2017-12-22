/**
* DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER. Copyright 1997-2016 NTG Clarity and/or its affiliates. All
* rights reserved. NTG CLARITY is a leader in delivering network, telecom, IT and infrastructure solutions to network
* service providers and medium and large enterprises. www.ntgclarity.com The contents of this file are subject to the
* terms of "NTG Clarity License". You must not use this file except in compliance with the License. You can obtain a
* copy of the License at http://www.ntgclarity.com/ See the License for the specific language governing permissions and
* limitations under the License. Contributor(s): The Initial Developer of the Original Software is NTG Clarity . , Inc.
* Copyright 1997-2016 NTG Clarity. All Rights Reserved. CLASS NAME
* <h4>Description</h4>
* <h4>Notes</h4>
* <h4>References</h4>
* 
 * @author: VoWifiDeveloper <A HREF="mailto:hr@ntgclarity.com">VoWIFI Development Team</A>
* @version Revision: 1.0 Date: 12/10/16 10:22 AM
* @see [String]
* @see [URL]
* @see [Class name#method name]
*/

package com.ntgclarity.mandarine.service.base;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.common.collect.Iterables;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.BooleanExpression;
import com.ntgclarity.mandarine.constants.CodesAndKeys;
import com.ntgclarity.mandarine.constants.Constants;
import com.ntgclarity.mandarine.dto.IdValueDTO;
import com.ntgclarity.mandarine.dto.StatusResponse;
import com.ntgclarity.mandarine.exception.ApplicationException;
import com.ntgclarity.mandarine.mapper.Mapper;
import com.ntgclarity.mandarine.util.Utils;


/**
 * @creator Mohamed Alatroush
 */

public abstract class BaseCachedService<S extends BaseEntity> {

	private static final Logger log = LoggerFactory.getLogger(BaseCachedService.class);

	/**
	 * Childs of BaseService MUST override this method
	 *
	 * @return
	 */
	public abstract BaseRepository<S> getRepositoryInstance();

	/**
	 * get entity By Id
	 *
	 * @param id
	 * @return
	 * @throws ApplicationException
	 */
	public BaseEntity get(Long id, QBaseEntity qEntity) {

		BooleanExpression be = getRequestHeaderExpressions(qEntity);
		BooleanExpression booleanExpressionId = qEntity.id.eq(id);
		Iterable<S> resultList = null;
		BaseEntity e = null;
		try {
			if (be != null) {
				resultList = getRepositoryInstance().findAll(be.and(booleanExpressionId));
			} else {
				e = getRepositoryInstance().findOne(id);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (Utils.isNotEmpty(resultList) && Iterables.size(resultList) != 0) {
			e = resultList.iterator().next();
		}
		// BaseEntity e = getRepositoryInstance().findOne(id);// ,
		// Constants.NOT_DELETED);
		if (e == null)
			throw new ApplicationException(
					new StatusResponse(CodesAndKeys.ENTITY_NOT_FOUND_CODE, CodesAndKeys.ENTITY_NOT_FOUND_KEY));

		return e;
	}

	@Cacheable(value = "empcache", key = "T(java.util.Objects).hash(#root.targetClass)")
	public Page<IdValueDTO> getIdValue(Pageable pageable, Predicate predicate, QBaseEntity qEntity) {
		Iterable<S> resultList = null;
		try {
			BooleanExpression be = getRequestHeaderExpressions(qEntity);
			if (be != null) {
				resultList = getRepositoryInstance().findAll(be.and(predicate), pageable);
			} else {
				resultList = getRepositoryInstance().findAll(predicate, pageable);
			}
		} catch (Exception e) {
			log.error("[NTG_LOG_START] Error retrieving ID Value pair object with error: (" + e.getMessage()
					+ ") [NTG_LOG_END]");

		}
		Mapper<S> mapper = new Mapper<>();

		List<IdValueDTO> mappedList = new ArrayList<>();
		if (Utils.isNotEmpty(resultList) && Iterables.size(resultList) != 0) {
			mappedList = mapper.mapEntity(resultList);
		}

		return new PageImpl<>(mappedList, pageable, mappedList.size());
	}

	@Transactional
	@CacheEvict(value = "empcache", key = "T(java.util.Objects).hash(#root.targetClass)")
	public S save(S entity) {

		try {
			entity.setDeleted(Constants.NOT_DELETED);
			entity.setId(null);
			entity = getRepositoryInstance().save(entity);

		} catch (InvalidDataAccessApiUsageException ex) {
			throw new ApplicationException(new StatusResponse(CodesAndKeys.CAN_NOT_CREATE_ENTITY_CODE,
					CodesAndKeys.CAN_NOT_CREATE_ENTITY_KEY, ex.getMessage()));

		} catch (Exception ex) {

			throw new ApplicationException(new StatusResponse(CodesAndKeys.CAN_NOT_CREATE_ENTITY_CODE,
					CodesAndKeys.CAN_NOT_CREATE_ENTITY_KEY, ex.getMessage()));

		}
		return entity;

	}

	@Transactional
	@CacheEvict(value = "empcache", key = "T(java.util.Objects).hash(#root.targetClass)")
	public Long update(Long id, S entity) {
		S savedEntity = getRepositoryInstance().findOne(id);
		if (savedEntity == null)
			throw new ApplicationException(
					new StatusResponse(CodesAndKeys.ENTITY_NOT_FOUND_CODE, CodesAndKeys.ENTITY_NOT_FOUND_KEY));
		if (entity.getId() != null && !entity.getId().equals(id))
			throw new ApplicationException(
					new StatusResponse(CodesAndKeys.INVALID_ENTITY_ID_CODE, CodesAndKeys.INVALID_ENTITY_ID_KEY));
		try {
			// TODO copy footprint attributes from savedEntity to the entity
			// object
			entity.setId(id);
			// entity.setDeleted(Constants.NOT_DELETED);
			entity = getRepositoryInstance().save(entity);
		} catch (Exception ex) {
			throw new ApplicationException(new StatusResponse(CodesAndKeys.CAN_NOT_UPDATE_ENTITY_CODE,
					CodesAndKeys.CAN_NOT_UPDATE_ENTITY_KEY, ex.getMessage()));
		}
		return entity.getId();
	}

	/**
	 * save Bulk of entities
	 *
	 * @param list
	 * @return
	 */

	@Transactional
	@CacheEvict(value = "empcache", key = "T(java.util.Objects).hash(#root.targetClass)")
	public List<Long> save(Iterable<S> list) {
		Iterable<S> savedList;
		try {
			savedList = getRepositoryInstance().save(list);

		} catch (InvalidDataAccessApiUsageException ex) {
			throw new ApplicationException(new StatusResponse(CodesAndKeys.CAN_NOT_CREATE_ENTITY_CODE,
					CodesAndKeys.CAN_NOT_CREATE_ENTITY_KEY, ex.getMessage()));

		} catch (Exception ex) {

			throw new ApplicationException(new StatusResponse(CodesAndKeys.CAN_NOT_CREATE_ENTITY_CODE,
					CodesAndKeys.CAN_NOT_CREATE_ENTITY_KEY, ex.getMessage()));

		}
		List<Long> idList = new ArrayList<Long>();
		savedList.forEach((entity) -> idList.add(entity.getId()));
		return idList;
	}

	/**
	 * delete by id
	 *
	 * @param id
	 * @throws EmptyResultDataAccessException
	 */
	@CacheEvict(value = "empcache", key = "T(java.util.Objects).hash(#root.targetClass)")
	public void delete(Long id) throws ApplicationException {

		try {
			getRepositoryInstance().softDelete(id);
			// getRepositoryInstance().delete(id);
		} catch (Exception ex) {

			throw new ApplicationException(new StatusResponse(CodesAndKeys.CAN_NOT_DELETE_ENTITY_CODE,
					CodesAndKeys.CAN_NOT_DELETE_ENTITY_KEY, ex.getMessage()));

		}

	}

	/**
	 * Delete by entit
	 *
	 * @param e
	 * @throws EmptyResultDataAccessException
	 */

	@Transactional
	@CacheEvict(value = "empcache", key = "T(java.util.Objects).hash(#root.targetClass)")
	public void delete(S e) throws ApplicationException {
		try {
			getRepositoryInstance().softDelete(e);
		} catch (Exception ex) {

			throw new ApplicationException(new StatusResponse(CodesAndKeys.CAN_NOT_DELETE_ENTITY_CODE,
					CodesAndKeys.CAN_NOT_DELETE_ENTITY_KEY, ex.getMessage()));

		}

	}

	/**
	 * delete bulk
	 *
	 * @param list
	 */

	@Transactional
	@CacheEvict(value = "empcache", key = "T(java.util.Objects).hash(#root.targetClass)")
	public void delete(Iterable<S> list) throws ApplicationException {
		try {
			getRepositoryInstance().softDelete(list);
		} catch (Exception ex) {

			throw new ApplicationException(new StatusResponse(CodesAndKeys.CAN_NOT_DELETE_ENTITY_CODE,
					CodesAndKeys.CAN_NOT_DELETE_ENTITY_KEY, ex.getMessage()));

		}

	}

	/**
	 * Fetch orgization , location and department HTTPHeaderFields and construct
	 * a single 'and' experssion for them
	 *
	 * @param qEntity
	 */
	private BooleanExpression getRequestHeaderExpressions(QBaseEntity qEntity) {

		try {

			log.info("Appending HTTP request headers to the filter expression ");

			HttpServletRequest httpRequest = ((ServletRequestAttributes) RequestContextHolder
					.currentRequestAttributes()).getRequest();

			BooleanExpression[] booleanExpressionArray = new BooleanExpression[2];

			if (httpRequest.getHeader(Constants.creatorIdHTTPHeaderField) != null
					&& !httpRequest.getHeader(Constants.creatorIdHTTPHeaderField).equals("")) {
				String headerData = "";
				if (httpRequest.getHeader(Constants.creatorIdHTTPHeaderField).contains(",")) {
					String[] parts = httpRequest.getHeader(Constants.creatorIdHTTPHeaderField).split(",");

					booleanExpressionArray[0] = qEntity.createdBy.in(parts);
				} else {
					headerData = httpRequest.getHeader(Constants.creatorIdHTTPHeaderField).trim();
					booleanExpressionArray[0] = qEntity.createdBy.eq(headerData);
				}

			}

			return BooleanExpression.allOf((BooleanExpression[]) booleanExpressionArray);

		} catch (Exception e) {

			log.warn("Exception  " + e.getClass().getName() + " message " + e.getMessage());
		}

		return null;

	}

	/**
	 * Get list based on the URL critera and the http header attributes
	 * organization , location and department
	 *
	 * @param pageable
	 * @param predicate
	 * @return
	 */
	@Cacheable(value = "empcache", key = "T(java.util.Objects).hash(#root.targetClass)")
	public Iterable<S> get(Pageable pageable, Predicate predicate, QBaseEntity qEntity) {

		Iterable<S> resultList = null;

		BooleanExpression be = getRequestHeaderExpressions(qEntity);

		if (be != null)

			resultList = getRepositoryInstance().findAll(be.and(predicate), pageable);
		else
			resultList = getRepositoryInstance().findAll(predicate, pageable);

		return resultList;
	}
}
