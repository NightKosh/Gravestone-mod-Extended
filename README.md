# [GraveStone mod - Extended](http://gravestone.nightkosh.com/) [![Curseforge](http://cf.way2muchnoise.eu/full_gravestone-mod-extended_downloads.svg)](https://minecraft.curseforge.com/projects/gravestone-mod-extended) [![Curseforge](http://cf.way2muchnoise.eu/versions/For%20MC_gravestone-mod-extended_all.svg)](https://minecraft.curseforge.com/projects/gravestone-mod-extended)

This is an addition to the [Gravestone mod - Graves](https://github.com/NightKosh/Gravestone-mod-Graves).  In minecraft 1.7.10 and earlier it was a standalone mod, but I decide ti split it on two parts in next versions of minecraft. This module adds additional features to the graves, new blocks, items, mobs, potions, enchantments and structures to the original mod.

For more information visit [official site](http://gravestone.nightkosh.com/) or [minecraft forum](http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/1288082-gravestone-mod)

## Minecraft versions
"Master branch" contains mod sources for the latest version of the Minecraft I'm working on. Any previous versions contains in an own branches.

## Requirements
1. [Forge](http://files.minecraftforge.net/) (check "build.gradle" file to know required forge version)
   * Latest versions of Forge requires [Gradle 2.0](https://gradle.org/) or higher
2. Version of the mod in "Master branch" requires [jdk 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)(do not forget to enable java 8 support in your IDE)

## Dependencies.
**Be careful some of these API/MODS may not be updated yet, or may be bugged!**

## Dependencies - MODS.

1. [Gravestone mod - Graves](https://minecraft.curseforge.com/projects/gravestone-mod-graves/files) 
2. [Forestry](https://minecraft.curseforge.com/projects/forestry/files)

## Dependencies - API.

1. [Sophisticated wolves API](https://github.com/NightKosh/Sophisticated-wolves-API) (will be loaded as git submodule)
2. ~~[Thaumcraft API](https://github.com/Azanor/thaumcraft-api) (will be loaded as git submodule)~~

## Get started

1. Clone mod repository 
2. [Download forge](http://files.minecraftforge.net/) and copy "gradlew.bat", "gradlew" files and "gradle" directory to mod folder
3. Download required mods and place them to the "external_libs" folder (look to the "build.gradle" to "dependencies" section for the mods versions):
   * [Gravestone mod - Graves](https://www.curseforge.com/minecraft/mc-mods/gravestone-mod-graves/files/2634989)
   * [Forestry](https://www.curseforge.com/minecraft/mc-mods/forestry/files/2511367  )
   * [Advanced Fishing](https://www.curseforge.com/minecraft/mc-mods/advanced-fishing/files/2628531)
4. Download mod's API
   * Download [submodules](https://git-scm.com/book/en/v2/Git-Tools-Submodules)
      * Run next commands from mod folder:
      ```
        git submodule init
        git submodule update
      ```
   * ~~Download other API's manually and place them into "src/main/java/" folder~~
5. Run "./gradlew setupDecompWorkspace idea" from mod folder
6. Import mod to your ide as "new Gradle project"
   
