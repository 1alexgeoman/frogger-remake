# 🐸 Frogger: Legacy Refactor & Modernization

**Frogger** is a modernized re-implementation of the classic retro arcade game. This project focused on transforming unorganized legacy code into a maintainable, high-quality application through **SOLID principles**, **MVC architecture**, and **Test-Driven Refactoring**.

## 🎮 Key Features

* **Classic Gameplay:** Navigate the main character across hazardous roads and rivers to reach safe zones.
* **Dynamic Obstacle System:** Includes moving **Logs**, **Turtles**, and **WetTurtles** that require careful timing to traverse.
* **Lives & Scoring System:**
    * Players start with **5 lives**, visually tracked via a heart UI.
    * Scoring is dynamic: points are awarded for forward progress (+10) and reaching goals (+50), with penalties (-50) for deaths.
* **Challenge Timer:** A 20-second countdown timer per round adds high-stakes pressure to every move.
* **Visual Death Animations:** Custom sprite sequences for both "car deaths" and "water deaths."

## 🛠 Project Evolution & Refactoring

The software underwent a complete architectural overhaul to meet professional standards:

* **MVC Architecture:** Re-structured the code into a strict **Model-View-Controller** pattern to decouple game logic from the rendering interface.
* **Build Automation:** Migrated to an **IntelliJ Gradle** project for professional dependency management and reliable builds.
* **Code Quality:** Eliminated "code smells," followed standard coding conventions, and implemented meaningful package structures.
* **Test-Driven Development:** Utilized test-driven refactoring with documented evidence of failing and passing tests to ensure long-term maintainability.

## 🚀 Technical Stack

* **Language:** Java
* **Framework:** JavaFX (for UI and Event Management)
* **Build Tool:** Gradle
* **Version Control:** Git (utilizing feature branching and descriptive commit messaging)

## 🕹️ How to Play

* **W / A / S / D:** Move the character Up, Left, Down, or Right.
* **The Goal:** Occupy all 5 "End" zones at the top of the map to win the game.
* **The Hazards:** * **Traffic:** Avoid all vehicles; a single collision results in the loss of a life.
    * **The River:** You must stay on logs or turtles while over water.
    * **Wet Turtles:** Be careful—these turtles will sink periodically, causing you to drown if you remain on them.

