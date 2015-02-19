package org.liferay.lifebringer.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GameScoreService}.
 *
 * @author Brian Wing Shun Chan
 * @see GameScoreService
 * @generated
 */
public class GameScoreServiceWrapper implements GameScoreService,
    ServiceWrapper<GameScoreService> {
    private GameScoreService _gameScoreService;

    public GameScoreServiceWrapper(GameScoreService gameScoreService) {
        _gameScoreService = gameScoreService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _gameScoreService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _gameScoreService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _gameScoreService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public org.liferay.lifebringer.model.GameScore storeScore(
        java.util.Date startTime, long groupId, int score,
        int redZombiesKilled, int greenZombiesKilled, int fired, int missed,
        int level) throws com.liferay.portal.kernel.exception.SystemException {
        return _gameScoreService.storeScore(startTime, groupId, score,
            redZombiesKilled, greenZombiesKilled, fired, missed, level);
    }

    @Override
    public java.util.List<org.liferay.lifebringer.model.GameScore> findGameScoreByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _gameScoreService.findGameScoreByGroupId(groupId, start, end);
    }

    @Override
    public int countGameScoreByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _gameScoreService.countGameScoreByGroupId(groupId);
    }

    @Override
    public java.util.List<org.liferay.lifebringer.model.GameScore> findGameScoreByUserId(
        long groupId, long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _gameScoreService.findGameScoreByUserId(groupId, userId, start,
            end);
    }

    @Override
    public int countGameScoreByUserId(long groupId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _gameScoreService.countGameScoreByUserId(groupId, userId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public GameScoreService getWrappedGameScoreService() {
        return _gameScoreService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedGameScoreService(GameScoreService gameScoreService) {
        _gameScoreService = gameScoreService;
    }

    @Override
    public GameScoreService getWrappedService() {
        return _gameScoreService;
    }

    @Override
    public void setWrappedService(GameScoreService gameScoreService) {
        _gameScoreService = gameScoreService;
    }
}
