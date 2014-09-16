package br.com.sac.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.sac.domain.Usuario;
import br.com.sac.dto.UsuarioLoginDTO;

@Repository
public class UsuarioDAO extends AbstractDAO<Usuario> {

	public boolean isExisteEmailCadastrado(String email) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.ilike("email", email.trim().toLowerCase()));
		return existsResult(criteria);
	}

	public String buscarSenhaUsuarioLogin(String email) {		
		Criteria criteria = createCriteria();		
		criteria.add(Restrictions.ilike("email", email));		
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("senha"));		
		criteria.setProjection(projectionList);						
		return uniqueResult(criteria);
	}

	public UsuarioLoginDTO buscarUsuarioLogin(String email) {
		
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("email", email.trim().toLowerCase()));
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("id"), "id");
		projectionList.add(Projections.property("nome"), "nome");
		projectionList.add(Projections.property("tipo"), "tipo");
		
		criteria.setProjection(projectionList);
		setResultTransformer(criteria, UsuarioLoginDTO.class);		
		
		return uniqueResult(criteria);
	}

}
