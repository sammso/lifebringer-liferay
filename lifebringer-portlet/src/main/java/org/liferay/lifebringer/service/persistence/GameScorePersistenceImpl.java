package org.liferay.lifebringer.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.liferay.lifebringer.NoSuchGameScoreException;
import org.liferay.lifebringer.model.GameScore;
import org.liferay.lifebringer.model.impl.GameScoreImpl;
import org.liferay.lifebringer.model.impl.GameScoreModelImpl;
import org.liferay.lifebringer.service.persistence.GameScorePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the game score service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GameScorePersistence
 * @see GameScoreUtil
 * @generated
 */
public class GameScorePersistenceImpl extends BasePersistenceImpl<GameScore>
    implements GameScorePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link GameScoreUtil} to access the game score persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = GameScoreImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GameScoreModelImpl.ENTITY_CACHE_ENABLED,
            GameScoreModelImpl.FINDER_CACHE_ENABLED, GameScoreImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GameScoreModelImpl.ENTITY_CACHE_ENABLED,
            GameScoreModelImpl.FINDER_CACHE_ENABLED, GameScoreImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GameScoreModelImpl.ENTITY_CACHE_ENABLED,
            GameScoreModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(GameScoreModelImpl.ENTITY_CACHE_ENABLED,
            GameScoreModelImpl.FINDER_CACHE_ENABLED, GameScoreImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
        new FinderPath(GameScoreModelImpl.ENTITY_CACHE_ENABLED,
            GameScoreModelImpl.FINDER_CACHE_ENABLED, GameScoreImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
            new String[] { Long.class.getName() },
            GameScoreModelImpl.GROUPID_COLUMN_BITMASK |
            GameScoreModelImpl.CREATEDATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(GameScoreModelImpl.ENTITY_CACHE_ENABLED,
            GameScoreModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "gameScore.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_U = new FinderPath(GameScoreModelImpl.ENTITY_CACHE_ENABLED,
            GameScoreModelImpl.FINDER_CACHE_ENABLED, GameScoreImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_U",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U = new FinderPath(GameScoreModelImpl.ENTITY_CACHE_ENABLED,
            GameScoreModelImpl.FINDER_CACHE_ENABLED, GameScoreImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_U",
            new String[] { Long.class.getName(), Long.class.getName() },
            GameScoreModelImpl.GROUPID_COLUMN_BITMASK |
            GameScoreModelImpl.USERID_COLUMN_BITMASK |
            GameScoreModelImpl.CREATEDATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_G_U = new FinderPath(GameScoreModelImpl.ENTITY_CACHE_ENABLED,
            GameScoreModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_U",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_G_U_GROUPID_2 = "gameScore.groupId = ? AND ";
    private static final String _FINDER_COLUMN_G_U_USERID_2 = "gameScore.userId = ?";
    private static final String _SQL_SELECT_GAMESCORE = "SELECT gameScore FROM GameScore gameScore";
    private static final String _SQL_SELECT_GAMESCORE_WHERE = "SELECT gameScore FROM GameScore gameScore WHERE ";
    private static final String _SQL_COUNT_GAMESCORE = "SELECT COUNT(gameScore) FROM GameScore gameScore";
    private static final String _SQL_COUNT_GAMESCORE_WHERE = "SELECT COUNT(gameScore) FROM GameScore gameScore WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "gameScore.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GameScore exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GameScore exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(GameScorePersistenceImpl.class);
    private static GameScore _nullGameScore = new GameScoreImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<GameScore> toCacheModel() {
                return _nullGameScoreCacheModel;
            }
        };

    private static CacheModel<GameScore> _nullGameScoreCacheModel = new CacheModel<GameScore>() {
            @Override
            public GameScore toEntityModel() {
                return _nullGameScore;
            }
        };

    public GameScorePersistenceImpl() {
        setModelClass(GameScore.class);
    }

    /**
     * Returns all the game scores where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the matching game scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<GameScore> findByGroupId(long groupId)
        throws SystemException {
        return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<GameScore> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
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
    @Override
    public List<GameScore> findByGroupId(long groupId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
            finderArgs = new Object[] { groupId, start, end, orderByComparator };
        }

        List<GameScore> list = (List<GameScore>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (GameScore gameScore : list) {
                if ((groupId != gameScore.getGroupId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_GAMESCORE_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(GameScoreModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<GameScore>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<GameScore>(list);
                } else {
                    list = (List<GameScore>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public GameScore findByGroupId_First(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchGameScoreException, SystemException {
        GameScore gameScore = fetchByGroupId_First(groupId, orderByComparator);

        if (gameScore != null) {
            return gameScore;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchGameScoreException(msg.toString());
    }

    /**
     * Returns the first game score in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching game score, or <code>null</code> if a matching game score could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GameScore fetchByGroupId_First(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<GameScore> list = findByGroupId(groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public GameScore findByGroupId_Last(long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchGameScoreException, SystemException {
        GameScore gameScore = fetchByGroupId_Last(groupId, orderByComparator);

        if (gameScore != null) {
            return gameScore;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchGameScoreException(msg.toString());
    }

    /**
     * Returns the last game score in the ordered set where groupId = &#63;.
     *
     * @param groupId the group ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching game score, or <code>null</code> if a matching game score could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GameScore fetchByGroupId_Last(long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByGroupId(groupId);

        if (count == 0) {
            return null;
        }

        List<GameScore> list = findByGroupId(groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public GameScore[] findByGroupId_PrevAndNext(long gameId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchGameScoreException, SystemException {
        GameScore gameScore = findByPrimaryKey(gameId);

        Session session = null;

        try {
            session = openSession();

            GameScore[] array = new GameScoreImpl[3];

            array[0] = getByGroupId_PrevAndNext(session, gameScore, groupId,
                    orderByComparator, true);

            array[1] = gameScore;

            array[2] = getByGroupId_PrevAndNext(session, gameScore, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected GameScore getByGroupId_PrevAndNext(Session session,
        GameScore gameScore, long groupId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_GAMESCORE_WHERE);

        query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(GameScoreModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(gameScore);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<GameScore> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the game scores where groupId = &#63; from the database.
     *
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByGroupId(long groupId) throws SystemException {
        for (GameScore gameScore : findByGroupId(groupId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(gameScore);
        }
    }

    /**
     * Returns the number of game scores where groupId = &#63;.
     *
     * @param groupId the group ID
     * @return the number of matching game scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByGroupId(long groupId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

        Object[] finderArgs = new Object[] { groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_GAMESCORE_WHERE);

            query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the game scores where groupId = &#63; and userId = &#63;.
     *
     * @param groupId the group ID
     * @param userId the user ID
     * @return the matching game scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<GameScore> findByG_U(long groupId, long userId)
        throws SystemException {
        return findByG_U(groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
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
    @Override
    public List<GameScore> findByG_U(long groupId, long userId, int start,
        int end) throws SystemException {
        return findByG_U(groupId, userId, start, end, null);
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
    @Override
    public List<GameScore> findByG_U(long groupId, long userId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U;
            finderArgs = new Object[] { groupId, userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_U;
            finderArgs = new Object[] {
                    groupId, userId,
                    
                    start, end, orderByComparator
                };
        }

        List<GameScore> list = (List<GameScore>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (GameScore gameScore : list) {
                if ((groupId != gameScore.getGroupId()) ||
                        (userId != gameScore.getUserId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_GAMESCORE_WHERE);

            query.append(_FINDER_COLUMN_G_U_GROUPID_2);

            query.append(_FINDER_COLUMN_G_U_USERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(GameScoreModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(userId);

                if (!pagination) {
                    list = (List<GameScore>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<GameScore>(list);
                } else {
                    list = (List<GameScore>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public GameScore findByG_U_First(long groupId, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchGameScoreException, SystemException {
        GameScore gameScore = fetchByG_U_First(groupId, userId,
                orderByComparator);

        if (gameScore != null) {
            return gameScore;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchGameScoreException(msg.toString());
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
    @Override
    public GameScore fetchByG_U_First(long groupId, long userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<GameScore> list = findByG_U(groupId, userId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public GameScore findByG_U_Last(long groupId, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchGameScoreException, SystemException {
        GameScore gameScore = fetchByG_U_Last(groupId, userId, orderByComparator);

        if (gameScore != null) {
            return gameScore;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("groupId=");
        msg.append(groupId);

        msg.append(", userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchGameScoreException(msg.toString());
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
    @Override
    public GameScore fetchByG_U_Last(long groupId, long userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByG_U(groupId, userId);

        if (count == 0) {
            return null;
        }

        List<GameScore> list = findByG_U(groupId, userId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public GameScore[] findByG_U_PrevAndNext(long gameId, long groupId,
        long userId, OrderByComparator orderByComparator)
        throws NoSuchGameScoreException, SystemException {
        GameScore gameScore = findByPrimaryKey(gameId);

        Session session = null;

        try {
            session = openSession();

            GameScore[] array = new GameScoreImpl[3];

            array[0] = getByG_U_PrevAndNext(session, gameScore, groupId,
                    userId, orderByComparator, true);

            array[1] = gameScore;

            array[2] = getByG_U_PrevAndNext(session, gameScore, groupId,
                    userId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected GameScore getByG_U_PrevAndNext(Session session,
        GameScore gameScore, long groupId, long userId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_GAMESCORE_WHERE);

        query.append(_FINDER_COLUMN_G_U_GROUPID_2);

        query.append(_FINDER_COLUMN_G_U_USERID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(GameScoreModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(groupId);

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(gameScore);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<GameScore> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the game scores where groupId = &#63; and userId = &#63; from the database.
     *
     * @param groupId the group ID
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByG_U(long groupId, long userId)
        throws SystemException {
        for (GameScore gameScore : findByG_U(groupId, userId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(gameScore);
        }
    }

    /**
     * Returns the number of game scores where groupId = &#63; and userId = &#63;.
     *
     * @param groupId the group ID
     * @param userId the user ID
     * @return the number of matching game scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByG_U(long groupId, long userId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_G_U;

        Object[] finderArgs = new Object[] { groupId, userId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_GAMESCORE_WHERE);

            query.append(_FINDER_COLUMN_G_U_GROUPID_2);

            query.append(_FINDER_COLUMN_G_U_USERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(userId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the game score in the entity cache if it is enabled.
     *
     * @param gameScore the game score
     */
    @Override
    public void cacheResult(GameScore gameScore) {
        EntityCacheUtil.putResult(GameScoreModelImpl.ENTITY_CACHE_ENABLED,
            GameScoreImpl.class, gameScore.getPrimaryKey(), gameScore);

        gameScore.resetOriginalValues();
    }

    /**
     * Caches the game scores in the entity cache if it is enabled.
     *
     * @param gameScores the game scores
     */
    @Override
    public void cacheResult(List<GameScore> gameScores) {
        for (GameScore gameScore : gameScores) {
            if (EntityCacheUtil.getResult(
                        GameScoreModelImpl.ENTITY_CACHE_ENABLED,
                        GameScoreImpl.class, gameScore.getPrimaryKey()) == null) {
                cacheResult(gameScore);
            } else {
                gameScore.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all game scores.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(GameScoreImpl.class.getName());
        }

        EntityCacheUtil.clearCache(GameScoreImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the game score.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(GameScore gameScore) {
        EntityCacheUtil.removeResult(GameScoreModelImpl.ENTITY_CACHE_ENABLED,
            GameScoreImpl.class, gameScore.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<GameScore> gameScores) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (GameScore gameScore : gameScores) {
            EntityCacheUtil.removeResult(GameScoreModelImpl.ENTITY_CACHE_ENABLED,
                GameScoreImpl.class, gameScore.getPrimaryKey());
        }
    }

    /**
     * Creates a new game score with the primary key. Does not add the game score to the database.
     *
     * @param gameId the primary key for the new game score
     * @return the new game score
     */
    @Override
    public GameScore create(long gameId) {
        GameScore gameScore = new GameScoreImpl();

        gameScore.setNew(true);
        gameScore.setPrimaryKey(gameId);

        return gameScore;
    }

    /**
     * Removes the game score with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param gameId the primary key of the game score
     * @return the game score that was removed
     * @throws org.liferay.lifebringer.NoSuchGameScoreException if a game score with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GameScore remove(long gameId)
        throws NoSuchGameScoreException, SystemException {
        return remove((Serializable) gameId);
    }

    /**
     * Removes the game score with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the game score
     * @return the game score that was removed
     * @throws org.liferay.lifebringer.NoSuchGameScoreException if a game score with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GameScore remove(Serializable primaryKey)
        throws NoSuchGameScoreException, SystemException {
        Session session = null;

        try {
            session = openSession();

            GameScore gameScore = (GameScore) session.get(GameScoreImpl.class,
                    primaryKey);

            if (gameScore == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchGameScoreException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(gameScore);
        } catch (NoSuchGameScoreException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected GameScore removeImpl(GameScore gameScore)
        throws SystemException {
        gameScore = toUnwrappedModel(gameScore);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(gameScore)) {
                gameScore = (GameScore) session.get(GameScoreImpl.class,
                        gameScore.getPrimaryKeyObj());
            }

            if (gameScore != null) {
                session.delete(gameScore);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (gameScore != null) {
            clearCache(gameScore);
        }

        return gameScore;
    }

    @Override
    public GameScore updateImpl(
        org.liferay.lifebringer.model.GameScore gameScore)
        throws SystemException {
        gameScore = toUnwrappedModel(gameScore);

        boolean isNew = gameScore.isNew();

        GameScoreModelImpl gameScoreModelImpl = (GameScoreModelImpl) gameScore;

        Session session = null;

        try {
            session = openSession();

            if (gameScore.isNew()) {
                session.save(gameScore);

                gameScore.setNew(false);
            } else {
                session.merge(gameScore);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !GameScoreModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((gameScoreModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        gameScoreModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);

                args = new Object[] { gameScoreModelImpl.getGroupId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
                    args);
            }

            if ((gameScoreModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        gameScoreModelImpl.getOriginalGroupId(),
                        gameScoreModelImpl.getOriginalUserId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_U, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U,
                    args);

                args = new Object[] {
                        gameScoreModelImpl.getGroupId(),
                        gameScoreModelImpl.getUserId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_U, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_U,
                    args);
            }
        }

        EntityCacheUtil.putResult(GameScoreModelImpl.ENTITY_CACHE_ENABLED,
            GameScoreImpl.class, gameScore.getPrimaryKey(), gameScore);

        return gameScore;
    }

    protected GameScore toUnwrappedModel(GameScore gameScore) {
        if (gameScore instanceof GameScoreImpl) {
            return gameScore;
        }

        GameScoreImpl gameScoreImpl = new GameScoreImpl();

        gameScoreImpl.setNew(gameScore.isNew());
        gameScoreImpl.setPrimaryKey(gameScore.getPrimaryKey());

        gameScoreImpl.setGameId(gameScore.getGameId());
        gameScoreImpl.setGroupId(gameScore.getGroupId());
        gameScoreImpl.setCompanyId(gameScore.getCompanyId());
        gameScoreImpl.setUserId(gameScore.getUserId());
        gameScoreImpl.setUserName(gameScore.getUserName());
        gameScoreImpl.setCreateDate(gameScore.getCreateDate());
        gameScoreImpl.setModifiedDate(gameScore.getModifiedDate());
        gameScoreImpl.setGameTime(gameScore.getGameTime());
        gameScoreImpl.setGameScore(gameScore.getGameScore());
        gameScoreImpl.setRedZombiesKilled(gameScore.getRedZombiesKilled());
        gameScoreImpl.setGreenZombiesKilled(gameScore.getGreenZombiesKilled());
        gameScoreImpl.setMissed(gameScore.getMissed());
        gameScoreImpl.setFired(gameScore.getFired());
        gameScoreImpl.setLevel(gameScore.getLevel());

        return gameScoreImpl;
    }

    /**
     * Returns the game score with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the game score
     * @return the game score
     * @throws org.liferay.lifebringer.NoSuchGameScoreException if a game score with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GameScore findByPrimaryKey(Serializable primaryKey)
        throws NoSuchGameScoreException, SystemException {
        GameScore gameScore = fetchByPrimaryKey(primaryKey);

        if (gameScore == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchGameScoreException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return gameScore;
    }

    /**
     * Returns the game score with the primary key or throws a {@link org.liferay.lifebringer.NoSuchGameScoreException} if it could not be found.
     *
     * @param gameId the primary key of the game score
     * @return the game score
     * @throws org.liferay.lifebringer.NoSuchGameScoreException if a game score with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GameScore findByPrimaryKey(long gameId)
        throws NoSuchGameScoreException, SystemException {
        return findByPrimaryKey((Serializable) gameId);
    }

    /**
     * Returns the game score with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the game score
     * @return the game score, or <code>null</code> if a game score with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GameScore fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        GameScore gameScore = (GameScore) EntityCacheUtil.getResult(GameScoreModelImpl.ENTITY_CACHE_ENABLED,
                GameScoreImpl.class, primaryKey);

        if (gameScore == _nullGameScore) {
            return null;
        }

        if (gameScore == null) {
            Session session = null;

            try {
                session = openSession();

                gameScore = (GameScore) session.get(GameScoreImpl.class,
                        primaryKey);

                if (gameScore != null) {
                    cacheResult(gameScore);
                } else {
                    EntityCacheUtil.putResult(GameScoreModelImpl.ENTITY_CACHE_ENABLED,
                        GameScoreImpl.class, primaryKey, _nullGameScore);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(GameScoreModelImpl.ENTITY_CACHE_ENABLED,
                    GameScoreImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return gameScore;
    }

    /**
     * Returns the game score with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param gameId the primary key of the game score
     * @return the game score, or <code>null</code> if a game score with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GameScore fetchByPrimaryKey(long gameId) throws SystemException {
        return fetchByPrimaryKey((Serializable) gameId);
    }

    /**
     * Returns all the game scores.
     *
     * @return the game scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<GameScore> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<GameScore> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<GameScore> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<GameScore> list = (List<GameScore>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_GAMESCORE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_GAMESCORE;

                if (pagination) {
                    sql = sql.concat(GameScoreModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<GameScore>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<GameScore>(list);
                } else {
                    list = (List<GameScore>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the game scores from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (GameScore gameScore : findAll()) {
            remove(gameScore);
        }
    }

    /**
     * Returns the number of game scores.
     *
     * @return the number of game scores
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_GAMESCORE);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the game score persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.org.liferay.lifebringer.model.GameScore")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<GameScore>> listenersList = new ArrayList<ModelListener<GameScore>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<GameScore>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(GameScoreImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
