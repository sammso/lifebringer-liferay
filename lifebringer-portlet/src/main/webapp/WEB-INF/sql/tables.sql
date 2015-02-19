create table lifebringer_GameScore (
	gameId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	gameTime INTEGER,
	gameScore INTEGER,
	redZombiesKilled INTEGER,
	greenZombiesKilled INTEGER,
	missed INTEGER,
	fired INTEGER,
	level INTEGER
);