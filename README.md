# Train Booking System (CLI)

A Java-based console application inspired by an online railway reservation system. Built to practice core Java backend concepts such as OOP, Collections, JSON persistence, file handling, password hashing, and exception handling.

---

## Features

- User Signup & Login with BCrypt password hashing
- Search trains by source and destination
- Seat booking using a 2D seat matrix
- View booking history
- Cancel booked tickets
- Local JSON-based data persistence (no database required)
- UUID-based ticket generation

---

## Tech Stack

- **Java** - Core language
- **Gradle** - Build tool
- **Jackson** - JSON serialization/deserialization
- **jBCrypt** - Password hashing
- **Java Collections & Streams**
- **File I/O**

---

## Project Structure

```
app/
└── src/
    └── main/
        └── java/
            └── ticket/
                └── booking/
                    ├── App.java
                    ├── Services/
                    │   ├── UserBookingService.java
                    │   └── TrainService.java
                    ├── booking/
                    │   └── entities/
                    │       ├── User.java
                    │       ├── Train.java
                    │       └── Ticket.java
                    ├── util/
                    │   └── UserServiceUtil.java
                    └── localdb/
                        ├── users.json
                        └── trains.json
```

---

## Getting Started

### Prerequisites

- Java 17 or above
- Gradle

### Clone the repository

```bash
git clone https://github.com/yourusername/train-booking-system-cli.git
cd train-booking-system-cli
```

### Run the application

```bash
./gradlew run
```

---

## Sample Search

```
Source: bangalore
Destination: delhi
```

---

## Concepts Practiced

- Object-Oriented Programming (OOP)
- Java Collections Framework
- Java Streams & Optional
- JSON Serialization & Deserialization
- BCrypt Password Hashing
- File Handling
- Exception Handling
- UUID Generation

---

## Future Improvements

- Spring Boot REST API version
- MySQL integration
- Spring Data JPA
- JWT Authentication
- Unit testing with JUnit

---

## License

This project is created for learning purposes.
