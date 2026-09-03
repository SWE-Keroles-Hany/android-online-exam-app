# 📝 Online Exam App

An Android application for taking online exams, built with modern Android development practices and a clean, scalable architecture.

## 🚀 Overview

**Online Exam App** allows users to take exams through a simple and user-friendly interface. The application communicates with remote APIs to retrieve exam data and submit answers.

The project was built with a focus on **clean code, separation of concerns, scalability, and maintainability**.

## ✨ Features

* 📝 Take online exams
* ❓ Display exam questions and answers
* 📊 View exam results
* 🌐 Fetch data from REST APIs
* 🔄 Handle loading, success, and error states
* 🧭 Smooth and modern UI
* 📱 Fully built with Jetpack Compose

## 🛠️ Tech Stack

* **Kotlin**
* **Jetpack Compose**
* **MVVM**
* **Clean Architecture**
* **Koin** – Dependency Injection
* **Retrofit** – API integration
* **Coroutines** – Asynchronous operations
* **REST APIs**
* **Android Jetpack**

## 🏗️ Architecture

The project follows **Clean Architecture + MVVM** to keep the application modular and maintainable.

```text
Presentation
     ↓
   Domain
     ↓
    Data
```

### Presentation Layer

Responsible for the UI and user interactions.

* Jetpack Compose
* ViewModel
* UI State

### Domain Layer

Contains the application's business logic.

* Use Cases
* Domain Models
* Repository Interfaces

### Data Layer

Responsible for handling external data sources.

* API Services
* DTOs
* Repository Implementations
* Remote Data Source

## 💉 Dependency Injection

**Koin** is used for Dependency Injection.

It is responsible for providing dependencies such as:

* ViewModels
* Repositories
* Use Cases
* Retrofit services

This helps reduce tight coupling between components and makes the project easier to test and maintain.

## 🌐 API Integration

The application communicates with backend services through **REST APIs**.

**Retrofit** is used for:

* Sending API requests
* Receiving exam data
* Submitting answers
* Handling API responses

## 🎨 UI

The application UI is completely built using **Jetpack Compose**, Google's modern toolkit for building native Android interfaces.

Compose provides:

* Declarative UI
* Reusable components
* Reactive state management
* Less boilerplate code

## 📂 Project Structure

```text
app/
├── data/
│   ├── remote/
│   ├── repository/
│   └── model/
│
├── domain/
│   ├── model/
│   ├── repository/
│   └── usecase/
│
├── presentation/
│   ├── screens/
│   ├── components/
│   └── viewmodel/
│
└── di/
    └── modules/
```

## ▶️ Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/SWE-Keroles-Hany/online-exam.git
```

### 2. Open the project

Open the project using **Android Studio**.

### 3. Sync Gradle

Allow Android Studio to download and synchronize the required dependencies.

### 4. Run the application

Connect an Android device or start an Android Emulator, then run the application.

## 🎯 Project Goals

This project was built to practice and demonstrate:

* Modern Android development
* Jetpack Compose
* Clean Architecture
* MVVM
* Dependency Injection with Koin
* REST API integration
* Repository Pattern
* Separation of concerns
* State management

## 👨‍💻 Author

**Keroles Hany**

Android / Mobile Developer

GitHub: [SWE-Keroles-Hany](https://github.com/SWE-Keroles-Hany)
