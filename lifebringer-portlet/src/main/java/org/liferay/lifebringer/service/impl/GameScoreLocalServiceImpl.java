package org.liferay.lifebringer.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;

import java.util.ArrayList;
import java.util.List;

import org.liferay.lifebringer.model.GameScore;
import org.liferay.lifebringer.model.UserValue;
import org.liferay.lifebringer.model.impl.UserValueImpl;
import org.liferay.lifebringer.service.base.GameScoreLocalServiceBaseImpl;

/**
 * The implementation of the game score local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.liferay.lifebringer.service.GameScoreLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see org.liferay.lifebringer.service.base.GameScoreLocalServiceBaseImpl
 * @see org.liferay.lifebringer.service.GameScoreLocalServiceUtil
 */
public class GameScoreLocalServiceImpl extends GameScoreLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link org.liferay.lifebringer.service.GameScoreLocalServiceUtil} to access the game score local service.
     */
	
	@Override
	public GameScore addGameScore(GameScore gameScore) throws SystemException {
		long gameId = counterLocalService.increment(GameScore.class.getName());
		
		gameScore.setGameId(gameId);
		
		return super.addGameScore(gameScore);
	}
	
	public List<UserValue> findValues(long groupId, String sql, int start, int end) throws SystemException {
		List<UserValue> list = new ArrayList<UserValue>();
		
		for (Object[] objects : gameScoreFinder.findValues(groupId, sql, start, end)) {
			list.add(new UserValueImpl((User)objects[0], ((Integer)objects[1]).intValue()));
		}
		
		return list;
	}
	
	public List<UserValue> findValues(Object[] params, String sql, int start, int end) throws SystemException {
		List<UserValue> list = new ArrayList<UserValue>();
		
		for (Object[] objects : gameScoreFinder.findValues(params, sql, start, end)) {
			list.add(new UserValueImpl((User)objects[0], ((Integer)objects[1]).intValue()));
		}
		
		return list;
	}
	
	
	public int countTopPlayers(long groupId) throws SystemException {
		return gameScoreFinder.countTopPlayers(groupId);
	}	
}
