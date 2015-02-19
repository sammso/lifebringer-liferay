package org.liferay.lifebringer.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for GameScore. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see GameScoreServiceUtil
 * @see org.liferay.lifebringer.service.base.GameScoreServiceBaseImpl
 * @see org.liferay.lifebringer.service.impl.GameScoreServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface GameScoreService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link GameScoreServiceUtil} to access the game score remote service. Add custom service methods to {@link org.liferay.lifebringer.service.impl.GameScoreServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    public org.liferay.lifebringer.model.GameScore storeScore(
        java.util.Date startTime, long groupId, int score,
        int redZombiesKilled, int greenZombiesKilled, int fired, int missed,
        int level) throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<org.liferay.lifebringer.model.GameScore> findGameScoreByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    public int countGameScoreByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<org.liferay.lifebringer.model.GameScore> findGameScoreByUserId(
        long groupId, long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    public int countGameScoreByUserId(long groupId, long userId)
        throws com.liferay.portal.kernel.exception.SystemException;
}
