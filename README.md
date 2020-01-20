# Hanabi
A Deob-freed mixin-based injection hacked client for Minecraft using Minecraft Forge.
Version : 1.5.1 (1.4.2 could be downloaded at OpenHanabi/Hanabi/Jars)
some methods in this source are missing try decomp yourself with fernflower/cfr insteaded with [Deob remapped Unrunnable jar ](https://github.com/OpenHanabi/Hanabi/releases/download/1.4.2/Original_Deobfued_jar_Unrunnable.jar)

### DOWNLOAD

* Runnable Jar [Runnable](https://github.com/OpenHanabi/Hanabi/releases/download/1.4.2/Hanabi_Freed.jar)
* Deob remapped Unrunnable jar [Mapped](https://github.com/OpenHanabi/Hanabi/releases/download/1.4.2/Original_Deobfued_jar_Unrunnable.jar)
** Warnning !If you want to fix the method/field call form like `mc.field_xxxx` or `mc.func_xxxx` <br> Try use [MCPMAPPINGVIEW](https://github.com/bspkrs/MCPMappingViewer)
* Backup Link: [here](https://git.liquidbounce.net/Hanabi/hanabi_backup/tree/master)

this project entirely or partially for free and even commercially. However, please consider the following:

- **You must disclose the source code of your modified work and the source code you took from this project. This means you are not allowed to use code from this project (even partially) in a closed-source (or even obfuscated) application.**
- **Your modified application must also be licensed under the GPL** 

Do the above and share your source code with everyone; just like we do.

## Setting up a Workspace
Hanabi is using Gradle, so make sure that it is installed properly. Instructions can be found on [Gradle's website](https://gradle.org/install/).
1. Clone the repository using `git clone
2. CD into the local repository folder.
3. Depending on which IDE you are using execute either of the following commands:
    - For IntelliJ: `gradlew --debug setupDevWorkspace idea genIntellijRuns build`
    - For Eclipse: `gradlew --debug setupDevWorkspace eclipse build`
4. Open the folder as a Gradle project in your IDE.
