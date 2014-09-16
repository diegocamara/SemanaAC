package br.com.sac.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.sac.domain.Horario;

@Repository
public class HorarioDAO extends AbstractDAO<Horario>{

	public List<Horario> consultarHorarios(int eventoId) {
		
		Criteria criteria = createCriteria();
		criteria.createAlias("evento", "evento");
		
		criteria.add(Restrictions.eq("evento.id", eventoId));		
		criteria.addOrder(Order.asc("id"));
		
		return collection(criteria, Horario.class);
	}

}
