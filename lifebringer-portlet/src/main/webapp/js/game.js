	console.log("createPortlet");

	AUI().use('liferay-portlet','liferay-portlet-url','aui-button','json-parse', function(A) {
		Liferay.createPortlet({
			PLUGIN_NAME: "lifebringer-portlet",
			PORTLET_NAME: "lifebringer-portlet",
			prototype: {
				initPortlet : function(portletId, node) {
					var instance = this;
					var rootNode = instance.rootNode;
					var config = instance.getConfig();
					
					console.log("portletId:" + portletId);
					
					if (!config) return;
					if (!config.gameOverPageUrl) return;

					var sendScoreToServer = function() {
						Liferay.Service(
						  '/lifebringer-portlet.gamescore/store-score',
						  {
						    groupId: config.groupId,
						    score: score,
						    redZombiesKilled: redZombiesKilled,
						    greenZombiesKilled: greenZombiesKilled,
						    fired: firedTotal,
						    missed: missedTotal
						  },
						  function(obj) {
						    console.log(obj);
						  }
						);					
					}
					
					var redirectToGameOverPage = function() {	
						window.location = config.gameOverPageUrl;
					};
					
					// Steal whole body
					
					var bodyElement = document.body;
					
					for (var i=bodyElement.children.length - 1 ;  i >= 0 ; i-- ) {
						var element = bodyElement.children[i];
						if (element.tagName!=="SCRIPT") {
							bodyElement.removeChild(element);
						}
					}
					
					var aBody = A.one(bodyElement);
					
					var aDiv = A.Node.create('<div id="game"></div>');
					
					aBody.insert(aDiv);
					
				    var lzs = new Phaser.Game(720, 900, Phaser.AUTO, "game", { preload: preload, create: create, update: update, render: render });

				    var contextRoot = "/lifebringer-portlet/";

				        function preload() {
				            lzs.load.spritesheet('ray', contextRoot + 'assets/sprites/ray-sheet.png', 145, 128, 7);
				            lzs.load.spritesheet('zombie', contextRoot + 'assets/sprites/zombie-sheet.png', 119, 128);

				            lzs.load.spritesheet('buttonvertical', contextRoot + 'assets/buttons/button-vertical.png',64,64);
				            lzs.load.spritesheet('buttonhorizontal', contextRoot + 'assets/buttons/button-horizontal.png',96,64);
				            lzs.load.spritesheet('buttonfire', contextRoot + 'assets/buttons/button-round-a.png',96,96);

				            lzs.load.image('beam', contextRoot + 'assets/sprites/beam-01.png');
				            lzs.load.image('background', contextRoot + 'assets/sprites/grass-dirt-mix-pixeled-gray.png');
				            lzs.load.image('logo', contextRoot + 'assets/sprites/logo.png');

				            lzs.load.audio('alive', contextRoot + 'assets/sounds/angel1.mp3');
				            lzs.load.audio('hit', contextRoot + 'assets/sounds/grunt1.mp3');
				            lzs.load.audio('pew', contextRoot + 'assets/sounds/raygun1.mp3');
				            lzs.load.audio('soundtrack', contextRoot + 'assets/sounds/soundtrack.mp3');
				            lzs.load.audio('zombie', contextRoot + 'assets/sounds/zombie1.mp3');

				            // fullscreen setup
				            if (!lzs.device.desktop){
				            	lzs.scale.scaleMode = Phaser.ScaleManager.SHOW_ALL;
				            	lzs.scale.fullScreenScaleMode = Phaser.ScaleManager.EXACT_FIT;
				            }
				        }

				    //
				    // Game vars
				    //

				    var alive;
				    var bulletSpeed = 1500;
				    var cursors;
				    var fireButton;
				    var fireDelay = 200;
				    var fireTime = 0;
				    var gameLost = false;
				    var hit;
				    var level = 1;
				    var levelText = 'Level ';
				    var levelUpCounter = 0;
				    var levelUpReq = 20;
				    var logo;
				    var loseText = 'Game over, man! Game over!';
				    var pauseText = 'Paused';
				    var pew;
				    var ray;
				    var raySpeed = 500;

				    var score = 0;
				    var missedTotal = 0;
				    var firedTotal = 0;
				    var redZombiesKilled = 0;
				    var greenZombiesKilled = 0;

				    var scoreString = 'Score: ';
				    var scoreText;
				    var soundtrack;
				    var stateText;
				    var tween;
				    var volume = 1;
				    var zombieHitboxScale = 0.5;
				    var zombieHitPoints = 3;
				    var zombies;
				    var zombieSpawn;
				    var zombieSpawnLoop;
				    var zombieSpeed = 50;
				    var zombieWidth = 119;
				    var missedCount = 0;



				    var bullets;


				    var touchDown=false;
				    var touchLeft=false;
				    var touchRight=false;
				    var touchUp=false;
				    var touchFire=false;

				    function gofull() { 
				    	lzs.scale.startFullScreen(false);
				    }

				    function create() {
				    	if (!lzs.device.desktop){ lzs.input.onDown.add(gofull, this); } //go fullscreen on mobile devices
				        
				    	
				        lzs.add.tileSprite(0, 0, lzs.world.width, lzs.world.height, 'background');

				        logo = lzs.add.sprite((lzs.width - 937)/2, (lzs.height - 311)/2, 'logo');

				        setTimeout(function() {
				            logo.destroy();
				            ray.play('walkForward');
				        }, 4000);

				        lzs.physics.startSystem(Phaser.Physics.ARCADE);

				        ray = lzs.add.sprite(lzs.world.width * 0.5, lzs.world.height * 0.8, 'ray');

				        ray.animations.add('walkForward', [1, 2], 6, false);
				        ray.animations.add('walkSide', [3, 4], 6, false);
				        ray.animations.add('walkBack', [0], 6, false);
				        ray.animations.add('fireForward', [5], true);

				        ray.anchor.setTo(0.5, 1);

				        //rays
				        bullets = lzs.add.group();
				        bullets.enableBody = true;
				        bullets.physicsBodyType = Phaser.Physics.ARCADE;
				        bullets.createMultiple(30, 'beam');
				        bullets.setAll('anchor.x', 0.5);
				        bullets.setAll('anchor.y', 1);
				        bullets.setAll('outOfBoundsKill', true);
				        bullets.setAll('checkWorldBounds', true);

				        lzs.physics.enable(ray, Phaser.Physics.ARCADE);

				        //controls
				        cursors = lzs.input.keyboard.createCursorKeys();
				        fireButton = lzs.input.keyboard.addKey(Phaser.Keyboard.SPACEBAR);

				        var pauseButton = lzs.input.keyboard.addKey(Phaser.Keyboard.P);

				        pauseButton.onDown.add(togglePaused, this);

				        var muteButton = lzs.input.keyboard.addKey(Phaser.Keyboard.M);

				        muteButton.onDown.add(toggleMuted, this);

				        createZombies();

				        //audio
				        alive = lzs.add.audio('alive', volume);
				        hit = lzs.add.audio('hit', volume);
				        pew = lzs.add.audio('pew', volume);
				        zombieSpawn = lzs.add.audio('zombie', volume);
				        soundtrack = lzs.add.audio('soundtrack');

				        soundtrack.play('', 0, volume / 3, true);

				        setTimeout(function() {
				            zombieSpawn.play();
				        }, 2000);

				        //text
				        stateText = lzs.add.text(lzs.world.centerX, lzs.world.centerY, ' ', {fill: '#E9B3F7'});
				        stateText.anchor.setTo(0.5, 0.5);
				        stateText.visible = false;
				        stateText.font = 'badaboom';
				        stateText.fontSize  = '56';

				        //Score
				        scoreText = lzs.add.text(20, 20, scoreString + score, {fill: '#E9B3F7' });
				        scoreText.font = 'badaboom';
				        scoreText.fontSize  = '32';
				        scoreText.visible = false;

				        if (!lzs.device.desktop){
				    	    var buttondown = lzs.add.button(20+96, lzs.height - (20 + 64), 'buttonvertical', null, this, 0, 1, 0, 1);
				    	    buttondown.fixedToCamera = true;
				    	    buttondown.events.onInputOver.add(function(){touchDown=true;});
				    	    buttondown.events.onInputOut.add(function(){touchDown=false;});
				    	    buttondown.events.onInputDown.add(function(){touchDown=true;});
				    	    buttondown.events.onInputUp.add(function(){touchDown=false;});
				    	
				    	    var buttonleft = lzs.add.button(20, lzs.height - (20 + 64 + 64), 'buttonhorizontal', null, this, 0, 1, 0, 1);
				    	    buttonleft.fixedToCamera = true;
				    	    buttonleft.events.onInputOver.add(function(){touchLeft=true;});
				    	    buttonleft.events.onInputOut.add(function(){touchLeft=false;});
				    	    buttonleft.events.onInputDown.add(function(){touchLeft=true;});
				    	    buttonleft.events.onInputUp.add(function(){touchLeft=false;});
				    	
				    	    var buttonright = lzs.add.button(20+96+64, lzs.height - (20 + 64 + 64), 'buttonhorizontal', null, this, 0, 1, 0, 1);
				    	    buttonright.fixedToCamera = true;
				    	    buttonright.events.onInputOver.add(function(){touchRight=true;});
				    	    buttonright.events.onInputOut.add(function(){touchRight=false;});
				    	    buttonright.events.onInputDown.add(function(){touchRight=true;});
				    	    buttonright.events.onInputUp.add(function(){touchRight=false;});
				    	
				    	    var buttonup = lzs.add.button(20+96, lzs.height - (20 + 64 + 64 + 64), 'buttonvertical', null, this, 0, 1, 0, 1);
				    	    buttonup.fixedToCamera = true;
				    	    buttonup.events.onInputOver.add(function(){touchUp=true;});
				    	    buttonup.events.onInputOut.add(function(){touchUp=false;});
				    	    buttonup.events.onInputDown.add(function(){touchUp=true;});
				    	    buttonup.events.onInputUp.add(function(){touchUp=false;});
				    	
				    	
				    	
				    	    // create our virtual game controller buttons
				    	    var buttonfire = lzs.add.button(lzs.width - (20+96), lzs.height-(20+96), 'buttonfire', null, this, 0, 1, 0, 1);  //game, x, y, key, callback, callbackContext, overFrame, outFrame, downFrame, upFrame
				    	    buttonfire.fixedToCamera = true;  //our buttons should stay on the same place
				    	    buttonfire.events.onInputOver.add(function(){touchFire=true;});
				    	    buttonfire.events.onInputOut.add(function(){touchFire=false;});
				    	    buttonfire.events.onInputDown.add(function(){touchFire=true;});
				    	    buttonfire.events.onInputUp.add(function(){touchFire=false;});
				        }
				    }

				    function walkLeft() {
				        if (ray.position.x > 0) {
				            ray.body.velocity.x = -raySpeed;
				            ray.scale.x = 1;
				            ray.play('walkSide');
				        }
				    }

				    function walkRight() {
				        if (ray.position.x < lzs.world.width) {
				            ray.body.velocity.x = raySpeed;
				            ray.scale.x = -1;
				            ray.play('walkSide');
				        }
				    }

				    function walkUp() {
				        if (ray.position.y > (lzs.world.height / 2)) {
				            ray.body.velocity.y = -raySpeed;
				            ray.scale.x = 1;
				            ray.play('walkForward');
				        }
				    }

				    function walkDown() {
				        if (ray.position.y < (lzs.world.height)) {
				            ray.body.velocity.y = raySpeed;
				            ray.scale.x = 1;
				            ray.play('walkBack');
				        }
				    }


				    function update() {
				        updateRay();
				        updateMissedBullets();
				       
				        if (lzs.input.currentPointers == 0 && !lzs.input.activePointer.isMouse){ touchFire=false; touchDown=false; touchUp=false; touchRight=false; touchLeft=false;} //this works around a "bug" where a button gets stuck in pressed state
				    }

				    function updateRay() {
				        if (ray.alive) {
				            ray.body.velocity.setTo(0, 0);

				            if (cursors.left.isDown || touchLeft) {
				                walkLeft();
				            }
				            else if (cursors.right.isDown || touchRight) {
				                walkRight();
				            }
				            else if (cursors.up.isDown || touchUp) {
				                walkUp();
				            }
				            else if (cursors.down.isDown || touchDown) {
				                walkDown();
				            }

				            if (fireButton.isDown || touchFire) {
				                fireRay();
				            }

				            //collision detection
				            lzs.physics.arcade.overlap(bullets, zombies, zombieBulletCollisionHandler);
				            lzs.physics.arcade.overlap(ray, zombies, loseGame);

				            zombies.forEach(function(zombie) {
				                if (zombie.position.y > (lzs.world.height - zombie.height)) {
				                    gameLost = true;
				                }
				            }, this);

				            if (gameLost) {
				                loseGame();
				            }
				            else if (levelUpCounter == levelUpReq) {
				                levelUpCounter = 0;

				                increaseLevel();
				            }
				        }
				    }

				    function updateMissedBullets() {
				        bullets.forEach(function(bullet) {
				        	
				        	if (bullet.fireY && bullet.position.y < 0) {
				        		bullet.fireY=undefined;
				        		bullet.fireX=undefined;
				        		redZombiesKilled=0;
				        		greenZombiesKilled=0;
				        		missedCount++;
				        		missedTotal++;
				        		addScore(-5);
				        	}
				        });	
				    }

				    function fireRay() {
				        if (lzs.time.now > fireTime) {
				            pew.play();

				            bullet = bullets.getFirstExists(false);

				            if (bullet) {

				                bullet.fireX = ray.x + 10;
				                bullet.fireY = ray.y - ray.height;

				                bullet.reset(bullet.fireX, bullet.fireY);
				                bullet.body.velocity.y = -bulletSpeed;
				                fireTime = lzs.time.now + fireDelay;

				                missedTotal++;
				                
				                ray.play('fireForward');

				                setTimeout(function() {
				                    ray.play('walkForward');
				                }, 100);
				            }
				        }
				    }

				    function createZombies() {
				        zombies = lzs.add.group();
				        zombies.enableBody = true;
				        zombies.physicsBodyType = Phaser.Physics.ARCADE;
				        zombies.setAll('outOfBoundsKill', true);

				        zombieSpawnLoop = lzs.time.events.loop(2000, createZombie, this);
				    }

				    function createZombie() {
				        var position = Math.min(lzs.world.width * Math.random(), lzs.world.width - zombieWidth);
				        var zombie = zombies.create(position, -30, 'zombie');

				        zombie.anchor.setTo(0.5, 1);

				        zombie.animations.add('walkGreen', [0, 1, 2, 3], 3, true);
				        zombie.animations.add('walkRed', [4, 5, 6, 7], 3, true);
				        zombie.animations.add('leave', [9, 10, 11], 6, true);
				        zombie.animations.add('transform', [8], 1, false);

				        if (Math.random() > 0.5) {
				            zombie.play('walkGreen');
				            zombie.hits = 0;
				            zombie.type="green";
				        }
				        else {
				            zombie.play('walkRed');
				            zombie.hits = 0;
				            zombie.type="red";
				        }

				        zombie.body.velocity.y = zombieSpeed;
				        zombie.alive = false;

				        zombie.body.setSize(zombie.width * zombieHitboxScale, zombie.height * zombieHitboxScale, 0, -40);
				    }

				    function zombieBulletCollisionHandler(bullet, zombie) {
				        if (!zombie.alive) {
				        	bullet.fireY=undefined;
				        	bullet.fireX=undefined;
				            bullet.kill();
				            zombie.hits++;
				            var bulletExtra = 1;
				            var rayExtra = 1;
				            
				            var bulletDistance = (bullet.fireY - bullet.position.Y);
				            
				            if (bulletDistance < 200 ) {
				                bulletExtra = 2;
				            }
				            if (bulletDistance < 100 ) {
				                bulletExtra = 3;
				            }
				            
				            var hitPoints = zombieHitPoints;

				            if (zombie.type==="red") {
				            	hitPoints = zombieHitPoints * 2;
				            	greenZombiesKilled=0;
				            }
				            else {
				            	redZombiesKilled=0;
				            }
				            
				            
				            if (zombie.hits < hitPoints) {
				                hit.play();
				                if (zombie.type==="red") {
				                	addScore(1 * bulletExtra)
				                }
				                else {
				                	addScore(2 * bulletExtra)
				                }
				            }

				            if (zombie.hits == hitPoints) {
				                zombie.alive = true;
				                zombie.body.velocity.y = 0;
				                levelUpCounter++;

				                if (zombie.position.x > (lzs.world.width * 0.5)) {
				                    zombie.body.velocity.x = zombieSpeed * 3;
				                }
				                else {
				                    zombie.body.velocity.x = -zombieSpeed * 3;
				                    zombie.scale.x = -1;
				                }
				                
				                if (zombie.type==="red") {
				                	redZombiesKilled++;
				                	
				                }
				                else {
				                	greenZombiesKilled++;	
				                }
				                
				                if (redZombiesKilled>=3) {
				                	addScore(500);
				                }
				                if (greenZombiesKilled>=5) {
				                	addScore(250);
				                }

				                zombie.play('transform');

				                setTimeout(function() {
				                    zombie.play('leave');
				                }, 200);

				                alive.play();

				                addScore(countKillScore(10 * bulletExtra));
				            }
				        }
				    }

				    function countKillScore(points) {
				        var levelScore = 10 * level;
				        points = points * 10;

				        var countedScore= (levelScore * points)/100;

				        if (missedCount===0) {
				        	countedScore = countedScore + 20;	
				        }
				        
				        return countedScore;
				    }

				    function addScore(points) {

				        score = score + points;

				        if (score<0)
				            score=0;



				        scoreText.visible = true;
				        scoreText.text = scoreString + score;
				    }


				    function increaseLevel() {
				        level++;
				        levelUpReq += 5;
				        zombieSpawnLoop.delay -= 80;
				        zombieSpeed += 12;

				        zombieHitPoints=zombieHitPoints+1;
				        
				        stateText.text = levelText + level;
				        stateText.visible = true;

				        setTimeout(function() {
				            stateText.visible = false;
				        }, 2000);
				    }

				    function loseGame() {
				        stateText.text = loseText;
				        stateText.visible = true;
				        zombies.destroy();
				        bullets.destroy();
				        ray.destroy();
				        sendScoreToServer();
				        setTimeout(redirectToGameOverPage, 1000);
				    }

				    function render() {
				        // debug

				        lzs.debug.text("", 20, 20);
				    }

				    function toggleMuted() {
				        volume = 1 - volume;

				        for (var audio in [alive, hit, pew, zombieSpawn]) {
				            audio.volume = 1 - audio.volume;
				        }

				        if (!soundtrack.paused) {
				            soundtrack.pause();

				            document.getElementById('mute').innerHTML = 'Unmute';
				        }
				        else {
				            soundtrack.resume();

				            document.getElementById('mute').innerHTML = 'Mute';
				        }
				    }

				    function togglePaused(game) {
				        lzs.paused = !lzs.paused;

				        if (lzs.paused) {
				            stateText.text = pauseText;
				            stateText.visible = true;

				            document.getElementById('pause').innerHTML = 'Unpause';
				        }
				        else {
				            stateText.visible = false;

				            document.getElementById('pause').innerHTML = 'Pause';
				        }
				    }
				}
			}
		});
	});