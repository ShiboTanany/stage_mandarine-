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

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface BaseRepository<S extends BaseEntity> extends PagingAndSortingRepository<S, Long>, QueryDslPredicateExecutor<S> {

	public default void softDelete(@Param("id") Long id) {

		S e = findOne(id);
		e.setDeleted(1);
		save(e);
	}

	public default void softDelete(S e) {
		e.setDeleted(1);
		save(e);
	}

	public default void softDelete(Iterable<S> list) {

		list.forEach(e -> e.setDeleted(1));
		save(list);
	}


}