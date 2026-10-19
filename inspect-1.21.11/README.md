# Item Inspect (Fabric 1.21.11)

Press **G** (rebindable under Controls > Item Inspect) to inspect the item in your main hand.
Swords, axes, maces, spears/tridents, pickaxes/shovels/hoes and everything else get their own
twirls, flips, slams and thrusts, and each press picks one of two variants at random.

First-person hands are hidden at all times except during an inspection.
Inspection stops if you attack, use an item, open a menu or change the held item.

## Build

Needs JDK 21.

    ./gradlew build        (Windows: gradlew.bat build)

The jar is in `build/libs/` (use the one without `-sources`). To test in game: `./gradlew runClient`.

## Config

`config/inspectitems.json` is created on first launch:

- `animationSpeed`: 1.0 normal, 2.0 twice as fast
- `hideHandsOutsideInspect`: set false to get vanilla hands back
- `handOffsetX/Y/Z`, `handFollow`: where the hand sits on the item. Tune these if the hand is off the grip.

## Add or change animations

Everything is in `anim/Animations.java`. Each animation is a few keyframe tracks
(`Track.smooth(time, value, time, value, ...)`, time 0..1). Item categories are matched by
registry name in `categoryOf`.

## Status

Written against the 1.21.11 Mojang-mapped sources, but not yet compiled or run in game.
If the game crashes at launch with a Mixin error, the method named in the error is the one to fix.
