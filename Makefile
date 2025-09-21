NAME = avaj-launcher

BUILD_DIR = build

all: ${NAME}

${NAME}:
	@echo Compiling all files...
	@find * -name "*.java" > sources.txt
	@javac -d ${BUILD_DIR} @sources.txt
	@echo Compiled all files !

run:
	@java -cp ${BUILD_DIR} fr.cauvray.launcher.Main .tests/scenario.txt

clean:
	@echo Removing ${BUILD_DIR} folder and sources.txt
	@rm -rf build
	@rm sources.txt

re: clean all

.PHONY: all run clean re
