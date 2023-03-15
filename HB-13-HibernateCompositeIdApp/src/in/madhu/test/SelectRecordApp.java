package in.madhu.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.madhu.model.ProgrammerProjId;
import in.madhu.model.ProgrammerProjInfo;
import in.madhu.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) throws Exception {

		Session session = null;

		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				ProgrammerProjId id = new ProgrammerProjId();
				id.setPid(100);
				id.setProjId(503);
				ProgrammerProjInfo object = session.get(ProgrammerProjInfo.class, id);
				if (object != null)
					System.out.println(object);
				else
					System.out.println("Record not available for the given id :: " + id);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}
