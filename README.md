# The Minecraft link desktop app
This project was made for a server me and my friends have, it creates a link between minecraft chat and some other server events to a electron desktop app. If you're looking for a quick and dirty way to do this, this is not for you. instead use [discordSRV](https://www.spigotmc.org/resources/discordsrv.18494/). If you're looking for some fun and something special, this is the place to be!
It works as following:
![how it works](https://raw.githubusercontent.com/Terebo/electrontest/master/githubimg/howitworks.png)
**What you need to compile/use this system yourself**
 - a minecraft server with [spigot](https://www.spigotmc.org/) or [papermc](https://papermc.io/).
 - a web server with [php](https://www.php.net/) and [mysql](https://www.mysql.com/) support (can be the same server as the MC server)
 - an IDE with [maven](https://maven.apache.org/), i recommend [Visual Studio Code](https://code.visualstudio.com/) with the needed plugins
 - [Node.JS](https://nodejs.org/en/)
 - [NPM](https://www.npmjs.com/)
 -  [a brain](https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Skull_and_brain_normal_human.svg/800px-Skull_and_brain_normal_human.svg.png)

**How to set it up**
 first replace all the paths to the web server and database with your own, these are in:
 - Java/.../Terebo/App.java 
 - Java/.../Terebo/commands.java
 - Java/.../Terebo/messages.java
 - server/get.php
 - server/reset.php
 - server/script.php
 - electron/renderer.js

compile the Java directory using Maven. plop the compiled .jar in the plugin directory of you MC server.
Create a database on your mySQL and php capable web server and create a new table called `Messages` within it a column `Messages` put the php files in the server directory on that same server aswell.
Compile the electron directory with your node compiler of choice.
I'd recommend to do all these tasks in [Visual Studio Code](https://code.visualstudio.com/) as that is what i wrote it all in, you'll need some plugins, but i'm sure you can figure that out, that's what the brain listed above is.
