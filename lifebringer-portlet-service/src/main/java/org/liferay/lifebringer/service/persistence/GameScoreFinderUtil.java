package org.liferay.lifebringer.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;


public class GameScoreFinderUtil {
    private static GameScoreFinder _finder;

    public static java.util.List<java.lang.Object[]> findValues(long groupId,
        java.lang.String sql, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().findValues(groupId, sql, start, end);
    }

    public static java.util.List<java.lang.Object[]> findValues(
        java.lang.Object[] params, java.lang.String sql, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().findValues(params, sql, start, end);
    }

    public static int countTopPlayers(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getFinder().countTopPlayers(groupId);
    }

    public static GameScoreFinder getFinder() {
        if (_finder == null) {
            _finder = (GameScoreFinder) PortletBeanLocatorUtil.locate(org.liferay.lifebringer.service.ClpSerializer.getServletContextName(),
                    GameScoreFinder.class.getName());

            ReferenceRegistry.registerReference(GameScoreFinderUtil.class,
                "_finder");
        }

        return _finder;
    }

    public void setFinder(GameScoreFinder finder) {
        _finder = finder;

        ReferenceRegistry.registerReference(GameScoreFinderUtil.class, "_finder");
    }
}
