# 📝 Online Exam App

An Android application for taking online exams, built with modern Android development practices and a scalable **Clean Architecture + MVVM** structure.

## ✨ Features

* 📝 Take online exams
* ❓ Display exam questions and answers
* 📊 View exam results
* 🌐 REST API integration
* 🔄 Loading, success, and error state handling
* 📱 Modern UI built entirely with Jetpack Compose

## 🛠️ Tech Stack

* **Kotlin**
* **Jetpack Compose**
* **Clean Architecture**
* **MVVM**
* **Koin** – Dependency Injection
* **Retrofit** – REST API integration
* **Coroutines** – Asynchronous programming

## 🏗️ Architecture

The project follows **Feature-Based Clean Architecture with MVVM**.

Each feature is separated into three main layers:

```text
Feature
│
├── data
│   ├── remote
│   ├── dto
│   ├── mapper
│   └── repo
│
├── domain
│   ├── models
│   ├── repo
│   └── usecases
│
└── presentation
    ├── presentation
    └── viewmodels
```

This structure keeps each feature independent and makes the project easier to maintain, test, and scale.

## 📂 Project Structure

```text
app/
│
├── core/
│   ├── ...
│   └── ...
│
└── features/
    │
    ├── exam/
    │   │
    │   ├── data/
    │   │   ├── remote/
    │   │   ├── dto/
    │   │   ├── mapper/
    │   │   └── repo/
    │   │
    │   ├── domain/
    │   │   ├── models/
    │   │   ├── repo/
    │   │   └── usecases/
    │   │
    │   └── presentation/
    │       ├── presentation/
    │       └── viewmodels/
    │
    └── results/
        │
        ├── data/
        │   ├── remote/
        │   ├── dto/
        │   ├── mapper/
        │   └── repo/
        │
        ├── domain/
        │   ├── models/
        │   ├── repo/
        │   └── usecases/
        │
        └── presentation/
            ├── presentation/
            └── viewmodels/
```

### 🔹 Core

The `core` package contains shared components that can be used across different features.

Examples include:

* Network configuration
* Common utilities
* Shared components
* Dependency Injection
* Common error handling

### 🔹 Features

Each feature is isolated and follows the same Clean Architecture structure.

### Data Layer

Responsible for handling external data sources.

```text
data/
├── remote/
├── dto/
├── mapper/
└── repo/
```

* **Remote** → API services and remote data sources
* **DTO** → API response/request models
* **Mapper** → Converts DTOs into domain models
* **Repo** → Repository implementations

### Domain Layer

Contains the business logic of the feature.

```text
domain/
├── models/
├── repo/
└── usecases/
```

* **Models** → Business/domain models
* **Repo** → Repository interfaces
* **Use Cases** → Encapsulate business logic

### Presentation Layer

Responsible for the UI and user interaction.

```text
presentation/
├── presentation/
└── viewmodels/
```

* **Presentation** → Jetpack Compose screens and UI components
* **ViewModels** → Manage UI state and communicate with use cases

## 💉 Dependency Injection

**Koin** is used for Dependency Injection across the application.

It provides dependencies such as:

* Repositories
* Use Cases
* ViewModels
* API services

This helps achieve loose coupling and makes the application easier to maintain and test.

## 🌐 API Integration

The application communicates with backend services using **REST APIs**.

**Retrofit** is used to handle API communication and retrieve exam-related data.

## 🎨 UI

The entire UI is built using **Jetpack Compose**, providing a modern declarative approach to Android UI development.

## 🎯 What This Project Demonstrates

* Modern Android Development
* Jetpack Compose
* Feature-Based Architecture
* Clean Architecture
* MVVM
* Dependency Injection with Koin
* REST API Integration
* Repository Pattern
* Use Case Pattern
* DTO → Domain Mapping
* UI State Management
* Separation of Concerns

## 👨‍💻 Author

**Keroles Hany**

Android / Mobile Developer

GitHub: https://github.com/SWE-Keroles-Hany
