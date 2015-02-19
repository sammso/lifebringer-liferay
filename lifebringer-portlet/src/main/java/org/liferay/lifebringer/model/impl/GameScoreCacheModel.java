package org.liferay.lifebringer.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.liferay.lifebringer.model.GameScore;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GameScore in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see GameScore
 * @generated
 */
public class GameScoreCacheModel implements CacheModel<GameScore>,
    Externalizable {
    public long gameId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public int gameTime;
    public int gameScore;
    public int redZombiesKilled;
    public int greenZombiesKilled;
    public int missed;
    public int fired;
    public int level;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(29);

        sb.append("{gameId=");
        sb.append(gameId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", gameTime=");
        sb.append(gameTime);
        sb.append(", gameScore=");
        sb.append(gameScore);
        sb.append(", redZombiesKilled=");
        sb.append(redZombiesKilled);
        sb.append(", greenZombiesKilled=");
        sb.append(greenZombiesKilled);
        sb.append(", missed=");
        sb.append(missed);
        sb.append(", fired=");
        sb.append(fired);
        sb.append(", level=");
        sb.append(level);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public GameScore toEntityModel() {
        GameScoreImpl gameScoreImpl = new GameScoreImpl();

        gameScoreImpl.setGameId(gameId);
        gameScoreImpl.setGroupId(groupId);
        gameScoreImpl.setCompanyId(companyId);
        gameScoreImpl.setUserId(userId);

        if (userName == null) {
            gameScoreImpl.setUserName(StringPool.BLANK);
        } else {
            gameScoreImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            gameScoreImpl.setCreateDate(null);
        } else {
            gameScoreImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            gameScoreImpl.setModifiedDate(null);
        } else {
            gameScoreImpl.setModifiedDate(new Date(modifiedDate));
        }

        gameScoreImpl.setGameTime(gameTime);
        gameScoreImpl.setGameScore(gameScore);
        gameScoreImpl.setRedZombiesKilled(redZombiesKilled);
        gameScoreImpl.setGreenZombiesKilled(greenZombiesKilled);
        gameScoreImpl.setMissed(missed);
        gameScoreImpl.setFired(fired);
        gameScoreImpl.setLevel(level);

        gameScoreImpl.resetOriginalValues();

        return gameScoreImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        gameId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        gameTime = objectInput.readInt();
        gameScore = objectInput.readInt();
        redZombiesKilled = objectInput.readInt();
        greenZombiesKilled = objectInput.readInt();
        missed = objectInput.readInt();
        fired = objectInput.readInt();
        level = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(gameId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);
        objectOutput.writeInt(gameTime);
        objectOutput.writeInt(gameScore);
        objectOutput.writeInt(redZombiesKilled);
        objectOutput.writeInt(greenZombiesKilled);
        objectOutput.writeInt(missed);
        objectOutput.writeInt(fired);
        objectOutput.writeInt(level);
    }
}
