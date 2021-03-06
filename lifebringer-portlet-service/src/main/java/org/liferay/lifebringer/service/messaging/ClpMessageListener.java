package org.liferay.lifebringer.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import org.liferay.lifebringer.service.ClpSerializer;
import org.liferay.lifebringer.service.GameScoreLocalServiceUtil;
import org.liferay.lifebringer.service.GameScoreServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            GameScoreLocalServiceUtil.clearService();

            GameScoreServiceUtil.clearService();
        }
    }
}
