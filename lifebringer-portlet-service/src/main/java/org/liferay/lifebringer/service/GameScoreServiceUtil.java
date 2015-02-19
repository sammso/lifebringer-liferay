package org.liferay.lifebringer.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for GameScore. This utility wraps
 * {@link org.liferay.lifebringer.service.impl.GameScoreServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see GameScoreService
 * @see org.liferay.lifebringer.service.base.GameScoreServiceBaseImpl
 * @see org.liferay.lifebringer.service.impl.GameScoreServiceImpl
 * @generated
 */
public class GameScoreServiceUtil {
    private static GameScoreService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link org.liferay.lifebringer.service.impl.GameScoreServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

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

    public static org.liferay.lifebringer.model.GameScore storeScore(
        java.util.Date startTime, long groupId, int score,
        int redZombiesKilled, int greenZombiesKilled, int fired, int missed,
        int level) throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .storeScore(startTime, groupId, score, redZombiesKilled,
            greenZombiesKilled, fired, missed, level);
    }

    public static java.util.List<org.liferay.lifebringer.model.GameScore> findGameScoreByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findGameScoreByGroupId(groupId, start, end);
    }

    public static int countGameScoreByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countGameScoreByGroupId(groupId);
    }

    public static java.util.List<org.liferay.lifebringer.model.GameScore> findGameScoreByUserId(
        long groupId, long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findGameScoreByUserId(groupId, userId, start, end);
    }

    public static int countGameScoreByUserId(long groupId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().countGameScoreByUserId(groupId, userId);
    }

    public static void clearService() {
        _service = null;
    }

    public static GameScoreService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    GameScoreService.class.getName());

            if (invokableService instanceof GameScoreService) {
                _service = (GameScoreService) invokableService;
            } else {
                _service = new GameScoreServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(GameScoreServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(GameScoreService service) {
    }
}
