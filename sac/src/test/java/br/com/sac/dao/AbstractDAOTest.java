package br.com.sac.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
public abstract class AbstractDAOTest extends AbstractTest {

	private @Autowired
	SessionFactory sessionFactory;
	private Session session;

	public void save(Object... entityObject) {
		for (Object object : entityObject) {
			getCurrentSession().save(object);
		}
		flush();
	}

	public void update(Object... entityObject) {
		for (Object object : entityObject) {
			getCurrentSession().update(object);
		}
		flush();
	}

	public void delete(Object... entityObject) {
		for (Object object : entityObject) {
			getCurrentSession().delete(object);
		}
		flush();
	}

	public void evict(Object... entityObject) {
		for (Object object : entityObject) {
			getCurrentSession().evict(object);
		}
		flush();
	}

	private void flush() {
		getCurrentSession().flush();
	}

	protected Session getCurrentSession() {
		if (session == null) {
			session = sessionFactory.getCurrentSession();
		}
		return session;
	}

}
