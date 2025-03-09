#

APP = Main
MODULES = javafx.controls
JOPTS = --module-path $(PATH_TO_FX) --add-modules $(MODULES)
CLASSES = $(APP).class Car.class HighScoreScene.class RiverLevel.class \
	Enemy.class InvincibilityPowerUp.class RoadLevel.class \
	Frog.class Level.class ScoreManager.class \
	GameObject.class  Snake.class \
	GameScene.class MenuScene.class SpeedBoostPowerUp.class \
	GameWorld.class PowerUp.class WinScreen.class

all:	$(CLASSES)

run:
	java $(JOPTS) $(APP)

clean:
	rm $(CLASSES)

%.class:	%.java
	javac $(JOPTS) $<
