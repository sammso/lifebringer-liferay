package org.liferay.lifebringer.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.liferay.lifebringer.service.GameScoreServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link org.liferay.lifebringer.service.GameScoreServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link org.liferay.lifebringer.model.GameScoreSoap}.
 * If the method in the service utility returns a
 * {@link org.liferay.lifebringer.model.GameScore}, that is translated to a
 * {@link org.liferay.lifebringer.model.GameScoreSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GameScoreServiceHttp
 * @see org.liferay.lifebringer.model.GameScoreSoap
 * @see org.liferay.lifebringer.service.GameScoreServiceUtil
 * @generated
 */
public class GameScoreServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(GameScoreServiceSoap.class);

    public static org.liferay.lifebringer.model.GameScoreSoap storeScore(
        java.util.Date startTime, long groupId, int score,
        int redZombiesKilled, int greenZombiesKilled, int fired, int missed,
        int level) throws RemoteException {
        try {
            org.liferay.lifebringer.model.GameScore returnValue = GameScoreServiceUtil.storeScore(startTime,
                    groupId, score, redZombiesKilled, greenZombiesKilled,
                    fired, missed, level);

            return org.liferay.lifebringer.model.GameScoreSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static org.liferay.lifebringer.model.GameScoreSoap[] findGameScoreByGroupId(
        long groupId, int start, int end) throws RemoteException {
        try {
            java.util.List<org.liferay.lifebringer.model.GameScore> returnValue = GameScoreServiceUtil.findGameScoreByGroupId(groupId,
                    start, end);

            return org.liferay.lifebringer.model.GameScoreSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static int countGameScoreByGroupId(long groupId)
        throws RemoteException {
        try {
            int returnValue = GameScoreServiceUtil.countGameScoreByGroupId(groupId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static org.liferay.lifebringer.model.GameScoreSoap[] findGameScoreByUserId(
        long groupId, long userId, int start, int end)
        throws RemoteException {
        try {
            java.util.List<org.liferay.lifebringer.model.GameScore> returnValue = GameScoreServiceUtil.findGameScoreByUserId(groupId,
                    userId, start, end);

            return org.liferay.lifebringer.model.GameScoreSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static int countGameScoreByUserId(long groupId, long userId)
        throws RemoteException {
        try {
            int returnValue = GameScoreServiceUtil.countGameScoreByUserId(groupId,
                    userId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
