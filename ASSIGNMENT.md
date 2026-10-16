# Practice Assignment: "Realm of Objects" (Mini MMO)

A practice project built to the same size and style as CS5010 homework. You write every class
yourself. Claude teaches one concept per milestone, gives hints only when you ask, and reviews
your code once you've written it.

**End goal:** a small raid simulator. A party of heroes (Warrior, Mage, Healer), each carrying
an inventory of items, fights a boss. One loop runs the fight and every hero attacks in its
own way.

All classes go in package `mmo` (`src/main/java/mmo`). Tests go in `src/test/java/mmo`.

> Why `Hero` and not `Character`? `java.lang` already has a class called `Character` (the
> wrapper for `char`). Reusing that name compiles, but it causes confusing bugs.

---

## Milestone 1: Your first class (classes, objects, constructors, `this`, encapsulation)

Create class **`Hero`**.

- Every hero has a **name**, a **level**, a **current HP**, and a **max HP**.
- Constructor takes a name and a max HP. A new hero starts at **level 1** with **full HP**.
- Invalid input throws `IllegalArgumentException` with a *specific* message:
  - name is null or blank
  - max HP is not positive
- Fields are `private`. Provide getters, and **no setters** for HP or level.
- Methods:
  - `void takeDamage(int amount)`: HP never drops below 0. A negative amount is invalid.
  - `void heal(int amount)`: HP never goes above max HP. A negative amount is invalid. A dead hero cannot be healed (decide: throw, or do nothing? Write down why).
  - `boolean isAlive()`
  - `void levelUp()`: level +1, max HP +10, and HP is restored to full.
- **Tests:** `HeroTest` covers each rule above, including boundaries (exactly 0 HP, healing to exactly max).

## Milestone 2: Shared vs. per-object data (`static`, constants)

- Add a `static final` constant for the **max level (60)**. `levelUp()` past it is invalid.
- Track **how many heroes have been created** on the server, in total. Add a way to read that count.
- Replace any other magic numbers (like the +10 HP) with well-named constants.
- **Tests:** level cap; the creation counter (watch out: static state carries over between tests).

## Milestone 3: Has-a (composition, `ArrayList`)

- Class **`Item`**: name (non-blank), gold value (≥ 0).
- Class **`Inventory`**: holds `Item`s in an `ArrayList`, with a **capacity** set in the constructor (> 0).
  - `boolean add(Item item)`: returns `false` if full. Null is invalid.
  - `boolean remove(Item item)`
  - `int size()`, `boolean isFull()`
  - `int totalValue()`: sum of all item values.
- Every `Hero` **has an** `Inventory` (capacity 10) that is created when the hero is created.
- **Tests:** `ItemTest`, `InventoryTest` (full bag, removing something that isn't there, empty-bag total).

## Milestone 4: Is-a (inheritance, `extends`, `super(...)`)

- **Items:**
  - `Weapon extends Item`: adds a **damage** value (> 0).
  - `Potion extends Item`: adds a **heal amount** (> 0).
- **Heroes:**
  - `Warrior extends Hero`: adds **armor** (0 to 50). Incoming damage is reduced by armor, and a hit always deals at least 1.
  - `Mage extends Hero`: adds **mana** (starts at a constant max, e.g. 100).
  - `Healer extends Hero`: no new fields yet (that's allowed).
- Override where behavior differs (`Warrior.takeDamage`). Use `super.` to reuse the parent's logic instead of copy-pasting it.
- Hero subclass constructors take **only** what the caller should choose. Fixed values (like starting mana) are *not* constructor parameters.
- **Tests:** one test class per subclass.

## Milestone 5: `abstract`

- No one should be able to create a plain `Hero` or a plain `Item`. Make them `abstract`.
- Add `abstract int attack(Hero target)` to `Hero`. It returns the damage dealt.
  - **Warrior:** fixed base damage, plus the damage of the best `Weapon` in their inventory.
  - **Mage:** costs mana. Deals big damage with enough mana, otherwise a weak fallback hit.
  - **Healer:** weak damage.
- Add `void drinkPotion()` to `Hero`: uses the first `Potion` in the inventory (heals, then removes it). Does nothing if there isn't one. *(You'll need `instanceof`.)*
- **Tests:** each `attack` path, including the mage running out of mana.

## Milestone 6: Polymorphism (the raid)

- Class **`Boss`**: name, HP, and damage per turn. Decide: should `Boss` be a `Hero`? Justify it in a comment (is-a vs. has-a).
- Class **`Raid`**: has a `List<Hero>` party (1 to 5 heroes, no nulls) and a `Boss`.
  - `void playRound()`: every living hero attacks the boss. Then, if the boss is alive, it hits **every** living hero.
  - `boolean isOver()`, `String getWinner()` (or something better. Design choice!)
  - **Rule:** `Raid` may not use `instanceof` or check hero types. Each hero's own `attack` decides what happens.
- **Tests:** a raid the heroes win, a raid they lose, a party with one dead member.

## Milestone 7: Equality (`equals` / `hashCode` / `toString`)

- Two `Item`s are equal if they are the same type with the same name and stats. (Is a `Weapon` named "Sword" equal to a `Potion` named "Sword"? It shouldn't be!)
- Override `toString()` on heroes and items for readable output.
- **Tests:** equal, not equal, different subclass, `hashCode` consistent with `equals`.

## Milestone 8: Wrap-up

- Javadoc on all public classes and methods.
- A UML diagram (Mermaid `.md`, like your homework).
- Optional `Main` that runs and prints a full raid.

---

### Concept map (milestone → homework)

| Milestone | Concept | Seen in |
|---|---|---|
| 1 | class/object, constructor validation, `this`, encapsulation | A1 Frequent Flyer, A2 Product |
| 2 | `static`, constants | A1 account map, LEGAL_DRINKING_AGE |
| 3 | composition, `ArrayList` | StockItem, Inventory |
| 4 | inheritance, `super(...)`, overriding | Grocery/Beer, Lab 2 Athletes |
| 5 | abstract classes/methods, `instanceof` | Product, calculateTaxes |
| 6 | polymorphism | Inventory over `List<Product>` |
| 7 | `equals`/`hashCode`/`toString` | Name, Account |
