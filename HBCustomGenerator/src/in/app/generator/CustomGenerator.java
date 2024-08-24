package in.app.generator;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomGenerator implements IdentifierGenerator {

	static {
		System.out.println("CustomGenerator is loading...");
	}

	public CustomGenerator() {
		System.out.println("CustomGenerator is loaded");
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
		System.out.println("CustomGenerator is generating");
		Integer id = new Random().nextInt(1000);
		return id;
	}

}
