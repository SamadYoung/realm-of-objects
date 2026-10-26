# Realm of Objects

A small Java raid simulator I'm building to practice object-oriented programming. A party of heroes (Warrior, Mage, Healer), each with their own inventory, fights a boss, and each hero attacks in its own way.

I'm building it one milestone at a time, with each milestone focused on one OOP concept. The full spec is in [ASSIGNMENT.md](ASSIGNMENT.md).

## Progress

- [x] 1. Classes, constructors, encapsulation (`Hero`)
- [ ] 2. `static` and constants
- [ ] 3. Composition (`Item`, `Inventory`)
- [ ] 4. Inheritance (`Warrior`, `Mage`, `Healer`, `Weapon`, `Potion`)
- [ ] 5. Abstract classes and methods
- [ ] 6. Polymorphism (`Boss`, `Raid`)
- [ ] 7. `equals` / `hashCode` / `toString`
- [ ] 8. Javadoc, UML diagram, runnable `Main`

## Running

Requires a JDK. From the project root:

```
./gradlew build
./gradlew test
```

## Tech

Java · Gradle · JUnit
