package org.liferay.lifebringer.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link GameScore}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GameScore
 * @generated
 */
public class GameScoreWrapper implements GameScore, ModelWrapper<GameScore> {
    private GameScore _gameScore;

    public GameScoreWrapper(GameScore gameScore) {
        _gameScore = gameScore;
    }

    @Override
    public Class<?> getModelClass() {
        return GameScore.class;
    }

    @Override
    public String getModelClassName() {
        return GameScore.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("gameId", getGameId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("gameTime", getGameTime());
        attributes.put("gameScore", getGameScore());
        attributes.put("redZombiesKilled", getRedZombiesKilled());
        attributes.put("greenZombiesKilled", getGreenZombiesKilled());
        attributes.put("missed", getMissed());
        attributes.put("fired", getFired());
        attributes.put("level", getLevel());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long gameId = (Long) attributes.get("gameId");

        if (gameId != null) {
            setGameId(gameId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        Integer gameTime = (Integer) attributes.get("gameTime");

        if (gameTime != null) {
            setGameTime(gameTime);
        }

        Integer gameScore = (Integer) attributes.get("gameScore");

        if (gameScore != null) {
            setGameScore(gameScore);
        }

        Integer redZombiesKilled = (Integer) attributes.get("redZombiesKilled");

        if (redZombiesKilled != null) {
            setRedZombiesKilled(redZombiesKilled);
        }

        Integer greenZombiesKilled = (Integer) attributes.get(
                "greenZombiesKilled");

        if (greenZombiesKilled != null) {
            setGreenZombiesKilled(greenZombiesKilled);
        }

        Integer missed = (Integer) attributes.get("missed");

        if (missed != null) {
            setMissed(missed);
        }

        Integer fired = (Integer) attributes.get("fired");

        if (fired != null) {
            setFired(fired);
        }

        Integer level = (Integer) attributes.get("level");

        if (level != null) {
            setLevel(level);
        }
    }

    /**
    * Returns the primary key of this game score.
    *
    * @return the primary key of this game score
    */
    @Override
    public long getPrimaryKey() {
        return _gameScore.getPrimaryKey();
    }

    /**
    * Sets the primary key of this game score.
    *
    * @param primaryKey the primary key of this game score
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _gameScore.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the game ID of this game score.
    *
    * @return the game ID of this game score
    */
    @Override
    public long getGameId() {
        return _gameScore.getGameId();
    }

    /**
    * Sets the game ID of this game score.
    *
    * @param gameId the game ID of this game score
    */
    @Override
    public void setGameId(long gameId) {
        _gameScore.setGameId(gameId);
    }

    /**
    * Returns the group ID of this game score.
    *
    * @return the group ID of this game score
    */
    @Override
    public long getGroupId() {
        return _gameScore.getGroupId();
    }

    /**
    * Sets the group ID of this game score.
    *
    * @param groupId the group ID of this game score
    */
    @Override
    public void setGroupId(long groupId) {
        _gameScore.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this game score.
    *
    * @return the company ID of this game score
    */
    @Override
    public long getCompanyId() {
        return _gameScore.getCompanyId();
    }

    /**
    * Sets the company ID of this game score.
    *
    * @param companyId the company ID of this game score
    */
    @Override
    public void setCompanyId(long companyId) {
        _gameScore.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this game score.
    *
    * @return the user ID of this game score
    */
    @Override
    public long getUserId() {
        return _gameScore.getUserId();
    }

    /**
    * Sets the user ID of this game score.
    *
    * @param userId the user ID of this game score
    */
    @Override
    public void setUserId(long userId) {
        _gameScore.setUserId(userId);
    }

    /**
    * Returns the user uuid of this game score.
    *
    * @return the user uuid of this game score
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _gameScore.getUserUuid();
    }

    /**
    * Sets the user uuid of this game score.
    *
    * @param userUuid the user uuid of this game score
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _gameScore.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this game score.
    *
    * @return the user name of this game score
    */
    @Override
    public java.lang.String getUserName() {
        return _gameScore.getUserName();
    }

    /**
    * Sets the user name of this game score.
    *
    * @param userName the user name of this game score
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _gameScore.setUserName(userName);
    }

    /**
    * Returns the create date of this game score.
    *
    * @return the create date of this game score
    */
    @Override
    public java.util.Date getCreateDate() {
        return _gameScore.getCreateDate();
    }

    /**
    * Sets the create date of this game score.
    *
    * @param createDate the create date of this game score
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _gameScore.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this game score.
    *
    * @return the modified date of this game score
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _gameScore.getModifiedDate();
    }

    /**
    * Sets the modified date of this game score.
    *
    * @param modifiedDate the modified date of this game score
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _gameScore.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the game time of this game score.
    *
    * @return the game time of this game score
    */
    @Override
    public int getGameTime() {
        return _gameScore.getGameTime();
    }

    /**
    * Sets the game time of this game score.
    *
    * @param gameTime the game time of this game score
    */
    @Override
    public void setGameTime(int gameTime) {
        _gameScore.setGameTime(gameTime);
    }

    /**
    * Returns the game score of this game score.
    *
    * @return the game score of this game score
    */
    @Override
    public int getGameScore() {
        return _gameScore.getGameScore();
    }

    /**
    * Sets the game score of this game score.
    *
    * @param gameScore the game score of this game score
    */
    @Override
    public void setGameScore(int gameScore) {
        _gameScore.setGameScore(gameScore);
    }

    /**
    * Returns the red zombies killed of this game score.
    *
    * @return the red zombies killed of this game score
    */
    @Override
    public int getRedZombiesKilled() {
        return _gameScore.getRedZombiesKilled();
    }

    /**
    * Sets the red zombies killed of this game score.
    *
    * @param redZombiesKilled the red zombies killed of this game score
    */
    @Override
    public void setRedZombiesKilled(int redZombiesKilled) {
        _gameScore.setRedZombiesKilled(redZombiesKilled);
    }

    /**
    * Returns the green zombies killed of this game score.
    *
    * @return the green zombies killed of this game score
    */
    @Override
    public int getGreenZombiesKilled() {
        return _gameScore.getGreenZombiesKilled();
    }

    /**
    * Sets the green zombies killed of this game score.
    *
    * @param greenZombiesKilled the green zombies killed of this game score
    */
    @Override
    public void setGreenZombiesKilled(int greenZombiesKilled) {
        _gameScore.setGreenZombiesKilled(greenZombiesKilled);
    }

    /**
    * Returns the missed of this game score.
    *
    * @return the missed of this game score
    */
    @Override
    public int getMissed() {
        return _gameScore.getMissed();
    }

    /**
    * Sets the missed of this game score.
    *
    * @param missed the missed of this game score
    */
    @Override
    public void setMissed(int missed) {
        _gameScore.setMissed(missed);
    }

    /**
    * Returns the fired of this game score.
    *
    * @return the fired of this game score
    */
    @Override
    public int getFired() {
        return _gameScore.getFired();
    }

    /**
    * Sets the fired of this game score.
    *
    * @param fired the fired of this game score
    */
    @Override
    public void setFired(int fired) {
        _gameScore.setFired(fired);
    }

    /**
    * Returns the level of this game score.
    *
    * @return the level of this game score
    */
    @Override
    public int getLevel() {
        return _gameScore.getLevel();
    }

    /**
    * Sets the level of this game score.
    *
    * @param level the level of this game score
    */
    @Override
    public void setLevel(int level) {
        _gameScore.setLevel(level);
    }

    @Override
    public boolean isNew() {
        return _gameScore.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _gameScore.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _gameScore.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _gameScore.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _gameScore.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _gameScore.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _gameScore.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _gameScore.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _gameScore.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _gameScore.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _gameScore.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new GameScoreWrapper((GameScore) _gameScore.clone());
    }

    @Override
    public int compareTo(org.liferay.lifebringer.model.GameScore gameScore) {
        return _gameScore.compareTo(gameScore);
    }

    @Override
    public int hashCode() {
        return _gameScore.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<org.liferay.lifebringer.model.GameScore> toCacheModel() {
        return _gameScore.toCacheModel();
    }

    @Override
    public org.liferay.lifebringer.model.GameScore toEscapedModel() {
        return new GameScoreWrapper(_gameScore.toEscapedModel());
    }

    @Override
    public org.liferay.lifebringer.model.GameScore toUnescapedModel() {
        return new GameScoreWrapper(_gameScore.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _gameScore.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _gameScore.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _gameScore.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof GameScoreWrapper)) {
            return false;
        }

        GameScoreWrapper gameScoreWrapper = (GameScoreWrapper) obj;

        if (Validator.equals(_gameScore, gameScoreWrapper._gameScore)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public GameScore getWrappedGameScore() {
        return _gameScore;
    }

    @Override
    public GameScore getWrappedModel() {
        return _gameScore;
    }

    @Override
    public void resetOriginalValues() {
        _gameScore.resetOriginalValues();
    }
}
