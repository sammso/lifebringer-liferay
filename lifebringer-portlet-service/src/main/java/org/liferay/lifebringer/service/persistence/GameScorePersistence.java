package org.liferay.lifebringer.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.liferay.lifebringer.model.GameScore;

/**
 * The persistence interface for the game score service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GameScorePersistenceImpl
 * @see GameScoreUtil
 * @generated
 */
public interface GameScorePersistence extends BasePersistence<GameScore> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link GameScoreUtil} to access the game score persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the game scores where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching game scores
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<org.liferay.lifebringer.model.GameScore> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<org.liferay.lifebringer.model.GameScore> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<org.liferay.lifebringer.model.GameScore> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first game score in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching game score
    * @throws org.liferay.lifebringer.NoSuchGameScoreException if a matching game score could not be found
    * @throws SystemException if a system exception occurred
    */
    public org.liferay.lifebringer.model.GameScore findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.liferay.lifebringer.NoSuchGameScoreException;

    /**
    * Returns the first game score in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching game score, or <code>null</code> if a matching game score could not be found
    * @throws SystemException if a system exception occurred
    */
    public org.liferay.lifebringer.model.GameScore fetchByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last game score in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching game score
    * @throws org.liferay.lifebringer.NoSuchGameScoreException if a matching game score could not be found
    * @throws SystemException if a system exception occurred
    */
    public org.liferay.lifebringer.model.GameScore findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.liferay.lifebringer.NoSuchGameScoreException;

    /**
    * Returns the last game score in the ordered set where groupId = &#63;.
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching game score, or <code>null</code> if a matching game score could not be found
    * @throws SystemException if a system exception occurred
    */
    public org.liferay.lifebringer.model.GameScore fetchByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public org.liferay.lifebringer.model.GameScore[] findByGroupId_PrevAndNext(
        long gameId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.liferay.lifebringer.NoSuchGameScoreException;

    /**
    * Removes all the game scores where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of game scores where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching game scores
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the game scores where groupId = &#63; and userId = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @return the matching game scores
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<org.liferay.lifebringer.model.GameScore> findByG_U(
        long groupId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<org.liferay.lifebringer.model.GameScore> findByG_U(
        long groupId, long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<org.liferay.lifebringer.model.GameScore> findByG_U(
        long groupId, long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public org.liferay.lifebringer.model.GameScore findByG_U_First(
        long groupId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.liferay.lifebringer.NoSuchGameScoreException;

    /**
    * Returns the first game score in the ordered set where groupId = &#63; and userId = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching game score, or <code>null</code> if a matching game score could not be found
    * @throws SystemException if a system exception occurred
    */
    public org.liferay.lifebringer.model.GameScore fetchByG_U_First(
        long groupId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public org.liferay.lifebringer.model.GameScore findByG_U_Last(
        long groupId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.liferay.lifebringer.NoSuchGameScoreException;

    /**
    * Returns the last game score in the ordered set where groupId = &#63; and userId = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching game score, or <code>null</code> if a matching game score could not be found
    * @throws SystemException if a system exception occurred
    */
    public org.liferay.lifebringer.model.GameScore fetchByG_U_Last(
        long groupId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public org.liferay.lifebringer.model.GameScore[] findByG_U_PrevAndNext(
        long gameId, long groupId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.liferay.lifebringer.NoSuchGameScoreException;

    /**
    * Removes all the game scores where groupId = &#63; and userId = &#63; from the database.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByG_U(long groupId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of game scores where groupId = &#63; and userId = &#63;.
    *
    * @param groupId the group ID
    * @param userId the user ID
    * @return the number of matching game scores
    * @throws SystemException if a system exception occurred
    */
    public int countByG_U(long groupId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the game score in the entity cache if it is enabled.
    *
    * @param gameScore the game score
    */
    public void cacheResult(org.liferay.lifebringer.model.GameScore gameScore);

    /**
    * Caches the game scores in the entity cache if it is enabled.
    *
    * @param gameScores the game scores
    */
    public void cacheResult(
        java.util.List<org.liferay.lifebringer.model.GameScore> gameScores);

    /**
    * Creates a new game score with the primary key. Does not add the game score to the database.
    *
    * @param gameId the primary key for the new game score
    * @return the new game score
    */
    public org.liferay.lifebringer.model.GameScore create(long gameId);

    /**
    * Removes the game score with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param gameId the primary key of the game score
    * @return the game score that was removed
    * @throws org.liferay.lifebringer.NoSuchGameScoreException if a game score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public org.liferay.lifebringer.model.GameScore remove(long gameId)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.liferay.lifebringer.NoSuchGameScoreException;

    public org.liferay.lifebringer.model.GameScore updateImpl(
        org.liferay.lifebringer.model.GameScore gameScore)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the game score with the primary key or throws a {@link org.liferay.lifebringer.NoSuchGameScoreException} if it could not be found.
    *
    * @param gameId the primary key of the game score
    * @return the game score
    * @throws org.liferay.lifebringer.NoSuchGameScoreException if a game score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public org.liferay.lifebringer.model.GameScore findByPrimaryKey(long gameId)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.liferay.lifebringer.NoSuchGameScoreException;

    /**
    * Returns the game score with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param gameId the primary key of the game score
    * @return the game score, or <code>null</code> if a game score with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public org.liferay.lifebringer.model.GameScore fetchByPrimaryKey(
        long gameId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the game scores.
    *
    * @return the game scores
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<org.liferay.lifebringer.model.GameScore> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<org.liferay.lifebringer.model.GameScore> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<org.liferay.lifebringer.model.GameScore> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the game scores from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of game scores.
    *
    * @return the number of game scores
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
