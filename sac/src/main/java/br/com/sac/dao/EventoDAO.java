package br.com.sac.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.sac.domain.Evento;
import br.com.sac.dto.EventoDTO;
import br.com.sac.dto.EventoFiltroDTO;

@Repository
public class EventoDAO extends AbstractDAO<Evento> {

	public List<EventoDTO> consultarEventos(EventoFiltroDTO eventoFiltroDTO) {

		Criteria criteria = createCriteria();

		if (StringUtils.isNotBlank(eventoFiltroDTO.getNome())) {
			criteria.add(Restrictions.ilike("nome", eventoFiltroDTO.getNome()
					.trim()));
		}

		if (StringUtils.isNotBlank(eventoFiltroDTO.getNomeProfessor())) {
			criteria.add(Restrictions.ilike("nomeProfessor", eventoFiltroDTO
					.getNomeProfessor().trim()));
		}

		if (StringUtils.isNotBlank(eventoFiltroDTO.getAno())) {
			criteria.add(Restrictions.ilike("ano", eventoFiltroDTO.getAno()
					.trim()));
		}

		criteria.addOrder(Order.desc("ano"));

		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("id"), "id");
		projectionList.add(Projections.property("numeroVagas"), "numeroVagas");
		projectionList.add(Projections.property("nome"), "nome");
		projectionList.add(Projections.property("descricao"), "descricao");
		projectionList.add(Projections.property("nomeProfessor"), "nomeProfessor");
		projectionList.add(Projections.property("ano"), "ano");

		criteria.setProjection(projectionList);
		
		setResultTransformer(criteria, EventoDTO.class);

		return collection(criteria, EventoDTO.class);
	}

}
