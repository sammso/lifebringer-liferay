package org.liferay.lifebringer.service.persistence;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.util.List;

import org.liferay.lifebringer.model.GameScore;
import org.liferay.lifebringer.util.CustomFinderHelperUtil;

public class GameScoreFinderImpl extends BasePersistenceImpl<GameScore> implements
		GameScoreFinder {
	
	public static final String FIND_TOP_PLAYERS =
			GameScoreFinder.class.getName() + ".findTopPlayers";
	
	public List<Object[]> findValues(long groupId, String sql, int start, int end) throws SystemException {
		Session session = null;
		
		try {
			session = CustomFinderHelperUtil.openPortalSession();

			//String sql = "SELECT {u.*}, lgs.gameScore as value FROM lifebringer_GameScore as lgs INNER JOIN User_ as u ON lgs.userId = u.userId  WHERE groupId = ? GROUP BY u.userId ORDER BY value DESC";
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("u", CustomFinderHelperUtil.getImplClass(User.class, PortalClassLoaderUtil.getClassLoader()));
			q.addScalar("value", Type.INTEGER);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			qPos.add(groupId);

			return (List<Object[]>)QueryUtil.list(
					q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}
	
	public int countTopPlayers(long groupId) throws SystemException {
		Session session = null;
		try {
			session = openSession();


			String sql = "SELECT count(userId) as count FROM lifebringer_GameScore WHERE groupId = ? GROUP BY userId";
			
			
			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar("count", Type.INTEGER);
			
			QueryPos qPos = QueryPos.getInstance(q);
			
			qPos.add(groupId);

			List<Integer> list = (List<Integer>)QueryUtil.list(
					q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			return list.get(0);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}
}
