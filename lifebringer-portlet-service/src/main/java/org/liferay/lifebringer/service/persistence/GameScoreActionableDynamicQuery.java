package org.liferay.lifebringer.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import org.liferay.lifebringer.model.GameScore;
import org.liferay.lifebringer.service.GameScoreLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class GameScoreActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public GameScoreActionableDynamicQuery() throws SystemException {
        setBaseLocalService(GameScoreLocalServiceUtil.getService());
        setClass(GameScore.class);

        setClassLoader(org.liferay.lifebringer.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("gameId");
    }
}
