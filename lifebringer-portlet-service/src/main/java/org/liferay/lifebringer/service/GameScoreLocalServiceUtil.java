package org.liferay.lifebringer.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for GameScore. This utility wraps
 * {@link org.liferay.lifebringer.service.impl.GameScoreLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see GameScoreLocalService
 * @see org.liferay.lifebringer.service.base.GameScoreLocalServiceBaseImpl
 * @see org.liferay.lifebringer.service.impl.GameScoreLocalServiceImpl
 * @generated
 */
public class GameScoreLocalServiceUtil {
    private static GameScoreLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link org.liferay.lifebringer.service.impl.GameScoreLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the game score to the database. Also notifies the appropriate model listeners.
    *
    * @param gameScore the game score
    * @return the game score that was added
    * @throws SystemException if a system exception occurred
    */
    public static org.liferay.lifebringer.model.GameScore addGameScore(
        org.liferay.lifebringer.model.GameScore gameScore)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addGameScore(gameScore);
    }

    /**
    * Creates a new game score with the primary key. Does not add the game score to the database.
    *
    * @param gameId the primary key for the new game score
    * @return the new game score
    */
    public static org.liferay.lifebringer.model.GameScore createGameScore(
        long gameId) {
        return getService().createGameScore(gameId);
    }

    /**
    * Deletes the game score with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param gameId the primary key of the game score
    * @return the game score that was removed
    * @throws PortalException if a game score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.liferay.lifebringer.model.GameScore deleteGameScore(
        long gameId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteGameScore(gameId);
    }

    /**
    * Deletes the game score from the database. Also notifies the appropriate model listeners.
    *
    * @param gameScore the game score
    * @return the game score that was removed
    * @throws SystemException if a system exception occurred
    */
    public static org.liferay.lifebringer.model.GameScore deleteGameScore(
        org.liferay.lifebringer.model.GameScore gameScore)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteGameScore(gameScore);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.liferay.lifebringer.model.impl.GameScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.liferay.lifebringer.model.impl.GameScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static org.liferay.lifebringer.model.GameScore fetchGameScore(
        long gameId) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchGameScore(gameId);
    }

    /**
    * Returns the game score with the primary key.
    *
    * @param gameId the primary key of the game score
    * @return the game score
    * @throws PortalException if a game score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.liferay.lifebringer.model.GameScore getGameScore(
        long gameId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getGameScore(gameId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the game scores.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.liferay.lifebringer.model.impl.GameScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of game scores
    * @param end the upper bound of the range of game scores (not inclusive)
    * @return the range of game scores
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<org.liferay.lifebringer.model.GameScore> getGameScores(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getGameScores(start, end);
    }

    /**
    * Returns the number of game scores.
    *
    * @return the number of game scores
    * @throws SystemException if a system exception occurred
    */
    public static int getGameScoresCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getGameScoresCount();
    }

    /**
    * Updates the game score in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param gameScore the game score
    * @return the game score that was updated
    * @throws SystemException if a system exception occurred
    */
    public static org.liferay.lifebringer.model.GameScore updateGameScore(
        org.liferay.lifebringer.model.GameScore gameScore)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateGameScore(gameScore);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static java.util.List<org.liferay.lifebringer.model.UserValue> findValues(
        long groupId, java.lang.String sql, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findValues(groupId, sql, start, end);
    }

    public static int countTopPlayers(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countTopPlayers(groupId);
    }

    public static void clearService() {
        _service = null;
    }

    public static GameScoreLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    GameScoreLocalService.class.getName());

            if (invokableLocalService instanceof GameScoreLocalService) {
                _service = (GameScoreLocalService) invokableLocalService;
            } else {
                _service = new GameScoreLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(GameScoreLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(GameScoreLocalService service) {
    }
}
