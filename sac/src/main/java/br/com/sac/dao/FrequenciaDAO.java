package br.com.sac.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.sac.domain.Frequencia;

@Repository
public class FrequenciaDAO extends AbstractDAO<Frequencia>{

	@Override
	public Frequencia findById(int objectId) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("id", objectId));		
		return uniqueResult(criteria);
	}

	

}
