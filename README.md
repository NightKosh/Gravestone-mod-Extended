# [GraveStone mod - Extended](http://gravestone.nightkosh.com/) [![Curseforge](http://cf.way2muchnoise.eu/full_gravestone-mod-extended_downloads.svg)](https://minecraft.curseforge.com/projects/gravestone-mod-extended) [![Curseforge](http://cf.way2muchnoise.eu/versions/For%20MC_gravestone-mod-extended_all.svg)](https://minecraft.curseforge.com/projects/gravestone-mod-extended)

This is an addition to the [Gravestone mod - Graves](https://github.com/NightKosh/Gravestone-mod-Graves).  In minecraft 1.7.10 and earlier it was a standalone mod, but I decide ti split it on two parts in next versions of minecraft. This module adds additional features to the graves, new blocks, items, mobs, potions, enchantments and structures to the original mod.

For more information visit [official site](http://gravestone.nightkosh.com/) or [minecraft forum](http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/1288082-gravestone-mod)

## Minecraft versions
"Master branch" contains mod sources for the latest version of the Minecraft I'm working on. Any previous versions contains in an own branches.

## Requirements
1. [NeoForge](https://neoforged.net/) (check "build.gradle" file to know required NeoForge version)
2. [Jdk 21.0.2](https://jdk.java.net/archive/) (do not forget to enable its support in your IDE)
3. [Gradle 9.2.1](https://gradle.org/releases/)

## Dependencies.
**Be careful some of these API/MODS may not be updated yet, or may be bugged!**

## Dependencies - MODS.

1. [Gravestone mod - Graves](https://minecraft.curseforge.com/projects/gravestone-mod-graves/files) 

## Dependencies - API.

1. [Sophisticated wolves API](https://github.com/NightKosh/Sophisticated-wolves-API) (will be loaded as git submodule)
2. ~~[Thaumcraft API](https://github.com/Azanor/thaumcraft-api) (will be loaded as git submodule)~~

## Get started

1. Clone mod repository
2. ~~Download NeoForge and copy "gradlew.bat", "gradlew" files and "gradle" directory to mod folder(and any other files which may requires)~~
3. Download required mods and place them to the "external_libs" folder (look to the "build.gradle" to "dependencies" section for the mods versions):
   * [Gravestone mod - Graves](https://www.curseforge.com/minecraft/mc-mods/gravestone-mod-graves/files/2634989)
   * [Advanced Fishing](https://www.curseforge.com/minecraft/mc-mods/advanced-fishing/files/2628531)
4. Download mod's API
   * Download [submodules](https://git-scm.com/book/en/v2/Git-Tools-Submodules)
      * Run next commands from mod folder:
      ```
        git submodule init
        git submodule update
      ```
   * ~~Download other API's manually and place them into "src/main/java/" folder~~
5. Download MDK from NeoForge
6. Import mod to your ide as "new Gradle project"


## Gradle commands
1. Running client
    ```
        gradlew runClient
    ```
2. Running Server
    ```
        gradlew runServer
    ```
3. Build mod as .jar file
    ```
        gradlew build
    ```

For more information, look at "minecraft NeoForge" README.txt file (it's not included to this repository) or [this link](https://docs.neoforged.net/)



## Useful commands

## Apply an enchantment on item:
### Weapon enchantments:
1. Vampiric Touch
    ```
        /enchant @s gravestone_extended:vampiric_touch 1
    ```
2. Poisoned Blade
    ```
        /enchant @s gravestone_extended:poisoned_blade 2
    ```
3. Withered Blade
    ```
        /enchant @s gravestone_extended:withered_blade 2
    ```
4. True Strike
    ```
        /enchant @s gravestone_extended:true_strike 2
    ```

### Shield enchantments:
1. Mirror of Pain
    ```
        /enchant @s gravestone_extended:mirror_of_pain 3
    ```

### Tools enchantments:
1. Bone Rain
    ```
        /enchant @s gravestone_extended:bone_rain 1
    ```

### Armor enchantments:
1. Web Crawler
    ```
        /enchant @s gravestone_extended:web_crawler 1
    ```

### Curse enchantments:
1. Curse of Awkwardness
    ```
        /enchant @s gravestone_extended:curse_of_awkwardness 1
    ```
2. Curse of Fragility
    ```
        /enchant @s gravestone_extended:curse_of_fragility 3
    ```
