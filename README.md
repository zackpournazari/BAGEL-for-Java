# BAGEL for Java - Game Class Library

This repository now contains a starter Java library of reusable classes for common game-programming assignments.

## Included classes

- `Vector2`: immutable vector math (`add`, `subtract`, `scale`, `normalize`, etc.).
- `BoundingBox`: axis-aligned collision rectangle.
- `GameEntity`: basic entity with position, velocity, and optional hit box.
- `AnimationTrack`: frame advancement over time.
- `GameTimer`: utility for cooldowns and delays.

## Structure

```text
src/main/java/com/gameclass/library
src/test/java/com/gameclass/library
```

## Quick compile and test

```bash
mkdir -p out
javac -d out $(find src/main/java src/test/java -name '*.java')
java -ea -cp out com.gameclass.library.LibrarySmokeTest
```

The smoke test uses Java assertions (`-ea`) and runs without external dependencies.
