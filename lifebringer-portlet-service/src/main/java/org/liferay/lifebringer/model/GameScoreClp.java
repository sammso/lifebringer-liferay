package org.liferay.lifebringer.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.liferay.lifebringer.service.ClpSerializer;
import org.liferay.lifebringer.service.GameScoreLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class GameScoreClp extends BaseModelImpl<GameScore> implements GameScore {
    private long _gameId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private int _gameTime;
    private int _gameScore;
    private int _redZombiesKilled;
    private int _greenZombiesKilled;
    private int _missed;
    private int _fired;
    private int _level;
    private BaseModel<?> _gameScoreRemoteModel;
    private Class<?> _clpSerializerClass = org.liferay.lifebringer.service.ClpSerializer.class;

    public GameScoreClp() {
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
    public long getPrimaryKey() {
        return _gameId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setGameId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _gameId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getGameId() {
        return _gameId;
    }

    @Override
    public void setGameId(long gameId) {
        _gameId = gameId;

        if (_gameScoreRemoteModel != null) {
            try {
                Class<?> clazz = _gameScoreRemoteModel.getClass();

                Method method = clazz.getMethod("setGameId", long.class);

                method.invoke(_gameScoreRemoteModel, gameId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_gameScoreRemoteModel != null) {
            try {
                Class<?> clazz = _gameScoreRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_gameScoreRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_gameScoreRemoteModel != null) {
            try {
                Class<?> clazz = _gameScoreRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_gameScoreRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_gameScoreRemoteModel != null) {
            try {
                Class<?> clazz = _gameScoreRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_gameScoreRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_gameScoreRemoteModel != null) {
            try {
                Class<?> clazz = _gameScoreRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_gameScoreRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_gameScoreRemoteModel != null) {
            try {
                Class<?> clazz = _gameScoreRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_gameScoreRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_gameScoreRemoteModel != null) {
            try {
                Class<?> clazz = _gameScoreRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_gameScoreRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getGameTime() {
        return _gameTime;
    }

    @Override
    public void setGameTime(int gameTime) {
        _gameTime = gameTime;

        if (_gameScoreRemoteModel != null) {
            try {
                Class<?> clazz = _gameScoreRemoteModel.getClass();

                Method method = clazz.getMethod("setGameTime", int.class);

                method.invoke(_gameScoreRemoteModel, gameTime);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getGameScore() {
        return _gameScore;
    }

    @Override
    public void setGameScore(int gameScore) {
        _gameScore = gameScore;

        if (_gameScoreRemoteModel != null) {
            try {
                Class<?> clazz = _gameScoreRemoteModel.getClass();

                Method method = clazz.getMethod("setGameScore", int.class);

                method.invoke(_gameScoreRemoteModel, gameScore);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getRedZombiesKilled() {
        return _redZombiesKilled;
    }

    @Override
    public void setRedZombiesKilled(int redZombiesKilled) {
        _redZombiesKilled = redZombiesKilled;

        if (_gameScoreRemoteModel != null) {
            try {
                Class<?> clazz = _gameScoreRemoteModel.getClass();

                Method method = clazz.getMethod("setRedZombiesKilled", int.class);

                method.invoke(_gameScoreRemoteModel, redZombiesKilled);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getGreenZombiesKilled() {
        return _greenZombiesKilled;
    }

    @Override
    public void setGreenZombiesKilled(int greenZombiesKilled) {
        _greenZombiesKilled = greenZombiesKilled;

        if (_gameScoreRemoteModel != null) {
            try {
                Class<?> clazz = _gameScoreRemoteModel.getClass();

                Method method = clazz.getMethod("setGreenZombiesKilled",
                        int.class);

                method.invoke(_gameScoreRemoteModel, greenZombiesKilled);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getMissed() {
        return _missed;
    }

    @Override
    public void setMissed(int missed) {
        _missed = missed;

        if (_gameScoreRemoteModel != null) {
            try {
                Class<?> clazz = _gameScoreRemoteModel.getClass();

                Method method = clazz.getMethod("setMissed", int.class);

                method.invoke(_gameScoreRemoteModel, missed);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getFired() {
        return _fired;
    }

    @Override
    public void setFired(int fired) {
        _fired = fired;

        if (_gameScoreRemoteModel != null) {
            try {
                Class<?> clazz = _gameScoreRemoteModel.getClass();

                Method method = clazz.getMethod("setFired", int.class);

                method.invoke(_gameScoreRemoteModel, fired);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getLevel() {
        return _level;
    }

    @Override
    public void setLevel(int level) {
        _level = level;

        if (_gameScoreRemoteModel != null) {
            try {
                Class<?> clazz = _gameScoreRemoteModel.getClass();

                Method method = clazz.getMethod("setLevel", int.class);

                method.invoke(_gameScoreRemoteModel, level);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getGameScoreRemoteModel() {
        return _gameScoreRemoteModel;
    }

    public void setGameScoreRemoteModel(BaseModel<?> gameScoreRemoteModel) {
        _gameScoreRemoteModel = gameScoreRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _gameScoreRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_gameScoreRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            GameScoreLocalServiceUtil.addGameScore(this);
        } else {
            GameScoreLocalServiceUtil.updateGameScore(this);
        }
    }

    @Override
    public GameScore toEscapedModel() {
        return (GameScore) ProxyUtil.newProxyInstance(GameScore.class.getClassLoader(),
            new Class[] { GameScore.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        GameScoreClp clone = new GameScoreClp();

        clone.setGameId(getGameId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setGameTime(getGameTime());
        clone.setGameScore(getGameScore());
        clone.setRedZombiesKilled(getRedZombiesKilled());
        clone.setGreenZombiesKilled(getGreenZombiesKilled());
        clone.setMissed(getMissed());
        clone.setFired(getFired());
        clone.setLevel(getLevel());

        return clone;
    }

    @Override
    public int compareTo(GameScore gameScore) {
        int value = 0;

        value = DateUtil.compareTo(getCreateDate(), gameScore.getCreateDate());

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof GameScoreClp)) {
            return false;
        }

        GameScoreClp gameScore = (GameScoreClp) obj;

        long primaryKey = gameScore.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(29);

        sb.append("{gameId=");
        sb.append(getGameId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", gameTime=");
        sb.append(getGameTime());
        sb.append(", gameScore=");
        sb.append(getGameScore());
        sb.append(", redZombiesKilled=");
        sb.append(getRedZombiesKilled());
        sb.append(", greenZombiesKilled=");
        sb.append(getGreenZombiesKilled());
        sb.append(", missed=");
        sb.append(getMissed());
        sb.append(", fired=");
        sb.append(getFired());
        sb.append(", level=");
        sb.append(getLevel());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(46);

        sb.append("<model><model-name>");
        sb.append("org.liferay.lifebringer.model.GameScore");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>gameId</column-name><column-value><![CDATA[");
        sb.append(getGameId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>gameTime</column-name><column-value><![CDATA[");
        sb.append(getGameTime());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>gameScore</column-name><column-value><![CDATA[");
        sb.append(getGameScore());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>redZombiesKilled</column-name><column-value><![CDATA[");
        sb.append(getRedZombiesKilled());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>greenZombiesKilled</column-name><column-value><![CDATA[");
        sb.append(getGreenZombiesKilled());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>missed</column-name><column-value><![CDATA[");
        sb.append(getMissed());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fired</column-name><column-value><![CDATA[");
        sb.append(getFired());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>level</column-name><column-value><![CDATA[");
        sb.append(getLevel());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
