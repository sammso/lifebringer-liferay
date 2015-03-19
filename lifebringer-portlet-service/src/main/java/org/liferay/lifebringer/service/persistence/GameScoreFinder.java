package org.liferay.lifebringer.service.persistence;

public interface GameScoreFinder {
    public java.util.List<java.lang.Object[]> findValues(long groupId,
        java.lang.String sql, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<java.lang.Object[]> findValues(
        java.lang.Object[] params, java.lang.String sql, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    public int countTopPlayers(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;
}
