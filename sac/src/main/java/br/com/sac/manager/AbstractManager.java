package br.com.sac.manager;

import org.springframework.transaction.annotation.Transactional;


@Transactional
public abstract class AbstractManager<E> {

	public abstract E getDao();

}
