package br.com.sac.dao;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class AbstractDAO<E> {

	private @Autowired SessionFactory sessionFactory;

	private Class<E> persistentClass;

	@PostConstruct
	private void sessionCreate() {
		persistentClass = (Class<E>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Criteria createCriteria() {

		Criteria criteria = getCurrentSession()
				.createCriteria(getEntityClass());

		return criteria;
	}

	public void save(Object... entityObject) {
		for (Object object : entityObject) {
			getCurrentSession().save(object);
		}
		getCurrentSession().flush();
	}
	
	public void saveAll(List<E> entityObjects){
		for (E object : entityObjects) {
			getCurrentSession().save(object);
		}
		getCurrentSession().flush();
	}
	
	public void update(Object... entityObject) {
		for (Object object : entityObject) {
			getCurrentSession().update(object);
		}
	}

	public void delete(Object... entityObject) {
		for (Object object : entityObject) {
			getCurrentSession().delete(object);
		}
	}

	public void evict(Object... entityObject) {
		for (Object object : entityObject) {
			getCurrentSession().evict(object);
		}
	}

	public boolean existsResult(Criteria criteria) {
		return criteria.list().size() > 0;
	}

	@SuppressWarnings("unchecked")
	public <T> T uniqueResult(Criteria criteria) {
		return (T) criteria.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> collection(Criteria criteria, Class<T> clazz){
		List<T> collection = new ArrayList<T>();
		collection.addAll(Collections.checkedCollection(criteria.list(), clazz));
		return collection;
	}

	public void setResultTransformer(Criteria criteria, Class<?> type) {
		criteria.setResultTransformer(Transformers.aliasToBean(type));
	}

	protected Class<E> getEntityClass() {
		return persistentClass;
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
