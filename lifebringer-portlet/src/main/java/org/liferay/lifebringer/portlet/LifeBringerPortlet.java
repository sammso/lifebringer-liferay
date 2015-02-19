package org.liferay.lifebringer.portlet;

import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;

import org.liferay.lifebringer.model.GameScore;
import org.liferay.lifebringer.service.GameScoreServiceUtil;

/**
 * Portlet implementation class LifeBringerPortlet
 */
public class LifeBringerPortlet extends MVCPortlet {
	
	public void gameOver(
			ActionRequest actionRequest, ActionResponse actionResponse) 
		throws IOException, PortletException {
				
		long gameId = ParamUtil.get(actionRequest, "gameId", -1);
		
		actionResponse.setWindowState(WindowState.NORMAL);
		actionResponse.setPortletMode(PortletMode.VIEW);
		actionResponse.setRenderParameter("mvcPath", "/html/lifebringer/view.jsp");
		actionResponse.setRenderParameter("gameId", String.valueOf(gameId));
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		if (!themeDisplay.isSignedIn()) {
			return;
		}
		
		String action = ParamUtil.get(resourceRequest, "action", "");
		
		PortletSession portletSession = resourceRequest.getPortletSession();
		
		if (action.equals("START")) {
			portletSession.setAttribute("STARTTIME", new Date(), PortletSession.PORTLET_SCOPE);
		}
		else if (action.equals("STORE")) {
			Date date = (Date)portletSession.getAttribute("STARTTIME", PortletSession.PORTLET_SCOPE);
			
			long groupId = themeDisplay.getScopeGroupId();
			int score = ParamUtil.get(resourceRequest, "score", -1);
			int redZombiesKilled = ParamUtil.get(resourceRequest, "redZombiesKilled", -1);
			int greenZombiesKilled = ParamUtil.get(resourceRequest, "greenZombiesKilled", -1);
			int fired = ParamUtil.get(resourceRequest, "fired", -1);
			int missed = ParamUtil.get(resourceRequest, "missed", -1);
			int level = ParamUtil.get(resourceRequest, "level", -1);		
						
			try {
				GameScore gameScore = GameScoreServiceUtil.storeScore(date, groupId, score, redZombiesKilled, greenZombiesKilled, fired, missed, level);
			    
			    String json = new Gson().toJson(gameScore.getGameId());

			    resourceResponse.setContentType("application/json");
			    resourceResponse.getWriter().write(json);
			} catch (SystemException e) {
				_log.error(e);
			}			
		}
	}
	
	private Log _log = LogFactoryUtil.getLog(LifeBringerPortlet.class);
}
