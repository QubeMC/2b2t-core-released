# 2b2tpe
This is a portion of the Core plugin for 2b2tmcpe, it is used to implements all bug fixes, and new features in one plugin. This way there won't be too much concurrent task that mess up all the plugin functions, this project is only half open source.

Any empty directories means that the code is either un-released or the directory is empty by default
# Build Status
[![Build Status](https://travis-ci.com/2B2TMCBE/2b2tpe.svg?token=xvymS3hSvzb4cCSjsscb&branch=master)](https://travis-ci.com/2B2TMCBE/2b2tpe)
# Coding Style
[![Coding Style](https://img.shields.io/badge/Coding%20Style-Google%20Style-green.svg)](https://google.github.io/styleguide/javaguide.html)
# API/Framework Used
- Nukkitx Engine [![Nukkitx](https://img.shields.io/badge/Software-Nukkitx-brightgreen.svg)](https://github.com/Nukkitx/Nukkit)
- Raknet Networking Engine
# Installation
- This installation guide is for Debian linux only, windows please download the newest jar file from https://github.com/2B2TMCBE/2b2tpe/releases and then proceed to step 7.

1. require installation of Nukkitx, please go to https://www.nukkitx.com/ for instruction
2. Download maven using this command:
```sudo apt-get install maven```
3. After installation, run this command to clone this git repository:
```git clone https://github.com/2B2TMCBE/2b2t-core-released.git```
4. Change directory to the plugin's base directory, which contains the file named pom.xml
5. Run this command to compile the plugin using maven
```mvn clean package```
6. Wait until the compiling process is completed, a new directory named `target` should now be created, nevigate into target.
7. move the jar file named `2b2tpe-1.0-SNAPSHOT.jar` into Nukkit's server directory, move it into a directory named plugins.
8. Restart the server, the plugin should be installed.
# Contribution
This project is proprietary, contribution is only allowed with permission from the owner of the repository. If you have permission to contribute, you **must** code accoding to Google Coding Style.
# License
MIT License
