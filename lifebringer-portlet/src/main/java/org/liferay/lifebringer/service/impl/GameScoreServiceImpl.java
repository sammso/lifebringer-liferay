package org.liferay.lifebringer.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.liferay.lifebringer.model.GameScore;
import org.liferay.lifebringer.service.base.GameScoreServiceBaseImpl;

/**
 * The implementation of the game score remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link org.liferay.lifebringer.service.GameScoreService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see org.liferay.lifebringer.service.base.GameScoreServiceBaseImpl
 * @see org.liferay.lifebringer.service.GameScoreServiceUtil
 */
public class GameScoreServiceImpl extends GameScoreServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * org.liferay.lifebringer.service.GameScoreServiceUtil} to access the game
	 * score remote service.
	 */
	public GameScore storeScore(Date startTime, long groupId, int score, int redZombiesKilled,
			int greenZombiesKilled, int fired, int missed, int level) throws SystemException {

		try {
			Group group = groupLocalService.getGroup(groupId);
			
			PermissionChecker permissionChecker = getPermissionChecker();

			User user = permissionChecker.getUser();

			if (user == null) {
				return null;
			}

			GameScore gameScore = gameScoreLocalService.createGameScore(0);

			gameScore.setUserId(user.getUserId());
			gameScore.setUserName(user.getFullName());
			gameScore.setCompanyId(user.getCompanyId());
			gameScore.setGroupId(group.getGroupId());
			gameScore.setCompanyId(group.getCompanyId());
			gameScore.setCreateDate(new Date());
			gameScore.setModifiedDate(new Date());
			gameScore.setGameScore(score);
			gameScore.setRedZombiesKilled(redZombiesKilled);
			gameScore.setGreenZombiesKilled(greenZombiesKilled);
			gameScore.setFired(fired);
			gameScore.setMissed(missed);
			gameScore.setLevel(level);
			return gameScoreLocalService.addGameScore(gameScore);
			
		} catch (PrincipalException pe) {
			return null;
		} catch (PortalException e) {
			throw new SystemException(e);
		} 
	}
	
	public List<GameScore> findGameScoreByGroupId(long groupId, int start, int end) throws SystemException {
		return gameScorePersistence.findByGroupId(groupId, start, end);
	}
	
	public int countGameScoreByGroupId(long groupId) throws SystemException {
		return gameScorePersistence.countByGroupId(groupId);
	}
	
	public List<GameScore> findGameScoreByUserId(long groupId, long userId, int start, int end) throws SystemException {
		return gameScorePersistence.findByG_U(groupId, userId);
	}
	
	public int countGameScoreByUserId(long groupId, long userId) throws SystemException {
		return gameScorePersistence.countByG_U(groupId, userId);
	}		
}
