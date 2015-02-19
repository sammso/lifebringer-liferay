<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<%@page import="org.liferay.lifebringer.service.GameScoreServiceUtil"%>
<%@page import="org.liferay.lifebringer.service.GameScoreLocalServiceUtil"%>
<%@page import="org.liferay.lifebringer.model.GameScore"%>
<%@page import="org.liferay.lifebringer.model.UserValue"%>

<%@page import="com.liferay.portal.service.UserLocalService"%>
<%@page import="com.liferay.portal.model.User"%>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@page import="java.util.List"%>

<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>

<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletMode"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />