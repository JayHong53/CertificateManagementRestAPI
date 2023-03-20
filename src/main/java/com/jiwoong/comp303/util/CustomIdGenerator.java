package com.jiwoong.comp303.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.util.List;

import com.jiwoong.comp303.models.Candidate;
import com.jiwoong.comp303.models.Certification;
import com.jiwoong.comp303.models.Test;
import com.jiwoong.comp303.models.TestCentre;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class CustomIdGenerator implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		// Setup prefix based on class
		String prefix = "";
		if (object instanceof Candidate) {
			prefix = "CAND-";
		} else if (object instanceof Certification) {
			prefix = "CERT-";
		} else if (object instanceof TestCentre) {
			prefix = "CTRE-";
		} else if (object instanceof Test) {
			prefix = "TEST-";
		}

		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<String> criteria = builder.createQuery(String.class);
		
		Root<?> root = criteria.from(object.getClass());
		
		criteria.select(root.get("id"));
		criteria.orderBy(builder.desc(root.get("id")));

		List<String> ids = session.createQuery(criteria).setMaxResults(1).getResultList();

		if (ids != null && !ids.isEmpty()) {
			String lastId = ids.get(0);
			if (lastId != null && lastId.startsWith(prefix)) {
				// Extract the numeric part of the last ID
				int num = Integer.parseInt(lastId.substring(5));
				// Increment the numeric part and generate the new ID
	            return prefix + String.format("%06d", num + 1);
			}
		}
		
		// If no existing IDs were found, generate a new one starting Prefix + 000001 
	    return prefix + String.format("%06d", 1);
	}
}
