package org.liferay.lifebringer.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.liferay.lifebringer.service.http.GameScoreServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see org.liferay.lifebringer.service.http.GameScoreServiceSoap
 * @generated
 */
public class GameScoreSoap implements Serializable {
    private long _gameId;
    private long _groupId;
    private long _companyId;
    private long _userId;
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

    public GameScoreSoap() {
    }

    public static GameScoreSoap toSoapModel(GameScore model) {
        GameScoreSoap soapModel = new GameScoreSoap();

        soapModel.setGameId(model.getGameId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setGameTime(model.getGameTime());
        soapModel.setGameScore(model.getGameScore());
        soapModel.setRedZombiesKilled(model.getRedZombiesKilled());
        soapModel.setGreenZombiesKilled(model.getGreenZombiesKilled());
        soapModel.setMissed(model.getMissed());
        soapModel.setFired(model.getFired());
        soapModel.setLevel(model.getLevel());

        return soapModel;
    }

    public static GameScoreSoap[] toSoapModels(GameScore[] models) {
        GameScoreSoap[] soapModels = new GameScoreSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static GameScoreSoap[][] toSoapModels(GameScore[][] models) {
        GameScoreSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new GameScoreSoap[models.length][models[0].length];
        } else {
            soapModels = new GameScoreSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static GameScoreSoap[] toSoapModels(List<GameScore> models) {
        List<GameScoreSoap> soapModels = new ArrayList<GameScoreSoap>(models.size());

        for (GameScore model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new GameScoreSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _gameId;
    }

    public void setPrimaryKey(long pk) {
        setGameId(pk);
    }

    public long getGameId() {
        return _gameId;
    }

    public void setGameId(long gameId) {
        _gameId = gameId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public int getGameTime() {
        return _gameTime;
    }

    public void setGameTime(int gameTime) {
        _gameTime = gameTime;
    }

    public int getGameScore() {
        return _gameScore;
    }

    public void setGameScore(int gameScore) {
        _gameScore = gameScore;
    }

    public int getRedZombiesKilled() {
        return _redZombiesKilled;
    }

    public void setRedZombiesKilled(int redZombiesKilled) {
        _redZombiesKilled = redZombiesKilled;
    }

    public int getGreenZombiesKilled() {
        return _greenZombiesKilled;
    }

    public void setGreenZombiesKilled(int greenZombiesKilled) {
        _greenZombiesKilled = greenZombiesKilled;
    }

    public int getMissed() {
        return _missed;
    }

    public void setMissed(int missed) {
        _missed = missed;
    }

    public int getFired() {
        return _fired;
    }

    public void setFired(int fired) {
        _fired = fired;
    }

    public int getLevel() {
        return _level;
    }

    public void setLevel(int level) {
        _level = level;
    }
}
