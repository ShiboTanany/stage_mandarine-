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

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ntgclarity.mandarine.constants.Constants;
import com.ntgclarity.mandarine.dto.IdValueDTO;
import com.ntgclarity.mandarine.util.Utils;

@MappedSuperclass
@Where(clause = "deleted <> 1")
@Audited
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	//change to sequence if required
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "AppGeneratorTable")
	@Column(name = "ID")
	protected Long id;

	// Footprint attributes
	@JsonIgnore
	@Column(name = "created_at", updatable = false)
	private Date createdAt;
	
	@JsonIgnore
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@JsonIgnore
	@Column(name = "created_by", updatable = false)
	private String createdBy;
	
	@JsonIgnore
	@Column(name = "updated_by")
	private String updatedBy;

	@JsonIgnore
	@Column(name = "deleted")
	private Integer deleted;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the deleted
	 */
	public Integer getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted
	 *            the deleted to set
	 */
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BaseEntity [id=" + getId() + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", createdBy=" + createdBy + ", updatedBy="
				+ updatedBy + ", deleted=" + deleted
				+ "]";
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	/**
	 * This return id-value dto
	 * 
	 * @return
	 */
	public abstract IdValueDTO returnIDValueDTO();

	@PrePersist
	protected void onCreate() {

		ServletRequestAttributes t = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest req = t.getRequest();
		String headerDataSt = "";
		if (Utils.isNotEmpty(req.getHeader(Constants.creatorIdHTTPHeaderField))) {
			if (req.getHeader(Constants.creatorIdHTTPHeaderField).contains(",")) {
				String[] parts = req.getHeader(Constants.creatorIdHTTPHeaderField).split(",");
				if (Utils.isNotEmpty(parts))
					headerDataSt = parts[0].trim();
			} else {
				headerDataSt = req.getHeader(Constants.creatorIdHTTPHeaderField).trim();
			}
		}
		createdBy = headerDataSt;
		createdAt = new Date();

		deleted = 0;
	}

	@PreUpdate
	protected void onUpdate() {
		ServletRequestAttributes t = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest req = t.getRequest();
		updatedAt = new Date();
		String headerData = "";
		if (req.getHeader(Constants.creatorIdHTTPHeaderField) != null) {
			if (req.getHeader(Constants.creatorIdHTTPHeaderField).contains(",")) {
				String[] parts = req.getHeader(Constants.creatorIdHTTPHeaderField).split(",");
				if (Utils.isNotEmpty(parts))
					headerData = parts[0].trim();
			} else {
				headerData = req.getHeader(Constants.creatorIdHTTPHeaderField).trim();
			}
		}
		updatedBy = headerData;
		if (deleted == null)
			deleted = 0;
	}

}
