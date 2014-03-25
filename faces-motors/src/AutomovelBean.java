import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@ManagedBean
public class AutomovelBean {

	private Automovel automovel = new Automovel();
	
	private List<Automovel> automoveis;
	public List<Automovel> getAutomoveis() {
		EntityManager em = JPAUtil.getEntityManager();
		Query q = em.createQuery("select a from Automovel a", Automovel.class);
		this.automoveis = q.getResultList();
		em.close();
		return automoveis;
	}
	
	public void salva(Automovel automovel) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(automovel);
		em.getTransaction().commit();
		em.close();
		System.out.println("salvo");
		
	}

	public Automovel getAutomovel() {
		return automovel;
	}


	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}


	
}