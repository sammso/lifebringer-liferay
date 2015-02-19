package org.liferay.lifebringer.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.liferay.lifebringer.model.GameScore;

import java.util.List;

/**
 * The persistence utility for the game score service. This utility wraps {@link GameScorePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GameScorePersistence
 * @see GameScorePersistenceImpl
 * @generated
 */
public class GameScoreUtil {
    private static GameScorePersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(GameScore gameScore) {
        getPersistence().clearCache(gameScore);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<GameScore> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<GameScore> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<GameScore> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static GameScore update(GameScore gameScore)
        throws SystemException {
        return getPersistence().update(gameScore);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static GameScore update(GameScore gameScore,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(gameScore, serviceContext);
    }

    /**
    * Returns all the game scores where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching game scores
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<org.liferay.lifebringer.model.GameScore> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

    /**
    * Returns a range of all the game scores where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.liferay.lifebringer.model.impl.GameScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of game scores
    * @param end the upper bound of the range of game scores (not inclusive)
    * @return the range of matching game scores
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<org.liferay.lifebringer.model.GameScore> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

    /**
    * Returns an ordered range of all the game scores where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.liferay.lifebringer.model.impl.GameScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of game scores
    * @param end the upper bound of the range of game scores (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching game scores
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<org.liferay.lifebringer.model.GameScore> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId(groupId, start, end, orderByComparator);
    }

    /**
    * Returns the first game score in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching game score
    * @throws org.liferay.lifebringer.NoSuchGameScoreException if a matching game score could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.liferay.lifebringer.model.GameScore findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.liferay.lifebringer.NoSuchGameScoreException {
        return getPersistence().findByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the first game score in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching game score, or <code>null</code> if a matching game score could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.liferay.lifebringer.model.GameScore fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the last game score in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching game score
    * @throws org.liferay.lifebringer.NoSuchGameScoreException if a matching game score could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.liferay.lifebringer.model.GameScore findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.liferay.lifebringer.NoSuchGameScoreException {
        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the last game score in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching game score, or <code>null</code> if a matching game score could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.liferay.lifebringer.model.GameScore fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the game scores before and after the current game score in the ordered set where groupId = &#63;.
    *
    * @param gameId the primary key of the current game score
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next game score
    * @throws org.liferay.lifebringer.NoSuchGameScoreException if a game score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.liferay.lifebringer.model.GameScore[] findByGroupId_PrevAndNext(
        long gameId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.liferay.lifebringer.NoSuchGameScoreException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(gameId, groupId, orderByComparator);
    }

    /**
    * Removes all the game scores where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Returns the number of game scores where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching game scores
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Returns all the game scores where groupId = &#63; and userId = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @return the matching game scores
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<org.liferay.lifebringer.model.GameScore> findByG_U(
        long groupId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_U(groupId, userId);
    }

    /**
    * Returns a range of all the game scores where groupId = &#63; and userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.liferay.lifebringer.model.impl.GameScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param start the lower bound of the range of game scores
    * @param end the upper bound of the range of game scores (not inclusive)
    * @return the range of matching game scores
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<org.liferay.lifebringer.model.GameScore> findByG_U(
        long groupId, long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByG_U(groupId, userId, start, end);
    }

    /**
    * Returns an ordered range of all the game scores where groupId = &#63; and userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.liferay.lifebringer.model.impl.GameScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param start the lower bound of the range of game scores
    * @param end the upper bound of the range of game scores (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching game scores
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<org.liferay.lifebringer.model.GameScore> findByG_U(
        long groupId, long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByG_U(groupId, userId, start, end, orderByComparator);
    }

    /**
    * Returns the first game score in the ordered set where groupId = &#63; and userId = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching game score
    * @throws org.liferay.lifebringer.NoSuchGameScoreException if a matching game score could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.liferay.lifebringer.model.GameScore findByG_U_First(
        long groupId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.liferay.lifebringer.NoSuchGameScoreException {
        return getPersistence()
                   .findByG_U_First(groupId, userId, orderByComparator);
    }

    /**
    * Returns the first game score in the ordered set where groupId = &#63; and userId = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching game score, or <code>null</code> if a matching game score could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.liferay.lifebringer.model.GameScore fetchByG_U_First(
        long groupId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_U_First(groupId, userId, orderByComparator);
    }

    /**
    * Returns the last game score in the ordered set where groupId = &#63; and userId = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching game score
    * @throws org.liferay.lifebringer.NoSuchGameScoreException if a matching game score could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.liferay.lifebringer.model.GameScore findByG_U_Last(
        long groupId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.liferay.lifebringer.NoSuchGameScoreException {
        return getPersistence()
                   .findByG_U_Last(groupId, userId, orderByComparator);
    }

    /**
    * Returns the last game score in the ordered set where groupId = &#63; and userId = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching game score, or <code>null</code> if a matching game score could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.liferay.lifebringer.model.GameScore fetchByG_U_Last(
        long groupId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByG_U_Last(groupId, userId, orderByComparator);
    }

    /**
    * Returns the game scores before and after the current game score in the ordered set where groupId = &#63; and userId = &#63;.
    *
    * @param gameId the primary key of the current game score
    * @param groupId the group ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next game score
    * @throws org.liferay.lifebringer.NoSuchGameScoreException if a game score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.liferay.lifebringer.model.GameScore[] findByG_U_PrevAndNext(
        long gameId, long groupId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.liferay.lifebringer.NoSuchGameScoreException {
        return getPersistence()
                   .findByG_U_PrevAndNext(gameId, groupId, userId,
            orderByComparator);
    }

    /**
    * Removes all the game scores where groupId = &#63; and userId = &#63; from the database.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByG_U(long groupId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByG_U(groupId, userId);
    }

    /**
    * Returns the number of game scores where groupId = &#63; and userId = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @return the number of matching game scores
    * @throws SystemException if a system exception occurred
    */
    public static int countByG_U(long groupId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByG_U(groupId, userId);
    }

    /**
    * Caches the game score in the entity cache if it is enabled.
    *
    * @param gameScore the game score
    */
    public static void cacheResult(
        org.liferay.lifebringer.model.GameScore gameScore) {
        getPersistence().cacheResult(gameScore);
    }

    /**
    * Caches the game scores in the entity cache if it is enabled.
    *
    * @param gameScores the game scores
    */
    public static void cacheResult(
        java.util.List<org.liferay.lifebringer.model.GameScore> gameScores) {
        getPersistence().cacheResult(gameScores);
    }

    /**
    * Creates a new game score with the primary key. Does not add the game score to the database.
    *
    * @param gameId the primary key for the new game score
    * @return the new game score
    */
    public static org.liferay.lifebringer.model.GameScore create(long gameId) {
        return getPersistence().create(gameId);
    }

    /**
    * Removes the game score with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param gameId the primary key of the game score
    * @return the game score that was removed
    * @throws org.liferay.lifebringer.NoSuchGameScoreException if a game score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.liferay.lifebringer.model.GameScore remove(long gameId)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.liferay.lifebringer.NoSuchGameScoreException {
        return getPersistence().remove(gameId);
    }

    public static org.liferay.lifebringer.model.GameScore updateImpl(
        org.liferay.lifebringer.model.GameScore gameScore)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(gameScore);
    }

    /**
    * Returns the game score with the primary key or throws a {@link org.liferay.lifebringer.NoSuchGameScoreException} if it could not be found.
    *
    * @param gameId the primary key of the game score
    * @return the game score
    * @throws org.liferay.lifebringer.NoSuchGameScoreException if a game score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.liferay.lifebringer.model.GameScore findByPrimaryKey(
        long gameId)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.liferay.lifebringer.NoSuchGameScoreException {
        return getPersistence().findByPrimaryKey(gameId);
    }

    /**
    * Returns the game score with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param gameId the primary key of the game score
    * @return the game score, or <code>null</code> if a game score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.liferay.lifebringer.model.GameScore fetchByPrimaryKey(
        long gameId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(gameId);
    }

    /**
    * Returns all the game scores.
    *
    * @return the game scores
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<org.liferay.lifebringer.model.GameScore> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<org.liferay.lifebringer.model.GameScore> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the game scores.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.liferay.lifebringer.model.impl.GameScoreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of game scores
    * @param end the upper bound of the range of game scores (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of game scores
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<org.liferay.lifebringer.model.GameScore> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the game scores from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of game scores.
    *
    * @return the number of game scores
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static GameScorePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (GameScorePersistence) PortletBeanLocatorUtil.locate(org.liferay.lifebringer.service.ClpSerializer.getServletContextName(),
                    GameScorePersistence.class.getName());

            ReferenceRegistry.registerReference(GameScoreUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(GameScorePersistence persistence) {
    }
}
