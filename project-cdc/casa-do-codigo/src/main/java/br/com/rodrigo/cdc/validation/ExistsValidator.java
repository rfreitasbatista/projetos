package br.com.rodrigo.cdc.validation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

import br.com.rodrigo.cdc.annotations.Exists;

public class ExistsValidator implements ConstraintValidator<Exists, Object> {

	private String atributoAPesquisar;
	private Class<?> classeEntidade;
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void initialize(Exists params) {
		atributoAPesquisar = params.fieldName();
		classeEntidade = params.domainClass();
	};
	
	@Override
	public boolean isValid(Object valorAPesquisar, ConstraintValidatorContext context) {
		Query query = manager.createQuery("select 1 from " + classeEntidade.getName() + " where " + atributoAPesquisar + "=:value");
		query.setParameter("value", valorAPesquisar);
		List<?> list = query.getResultList();
		Assert.state(list.size() <= 1, "Foi encontrado mais de um " + classeEntidade + "com o atributo " + atributoAPesquisar + " = " + valorAPesquisar);
		
		return list.size() >= 1;
	}

}
