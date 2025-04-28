# Design Patterns in Spring Boot

This project demonstrates the implementation of various design patterns in a Spring Boot application. It serves as a practical reference for understanding and applying design patterns in Java applications.

## Overview

Design patterns are typical solutions to common problems in software design. They represent best practices evolved over time by experienced software developers. This project provides concrete examples of design patterns implemented in a Spring Boot context.

## Project Structure

The project is organized by design patterns, with each pattern implemented in its own package.

## Design Patterns Implemented

### Strategy Pattern

The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. It lets the algorithm vary independently from clients that use it.

#### Implementation Details

In this project, the Strategy pattern is implemented for a notification system:

- **Interface**: `NotificationStrategy` - Defines the contract for all notification strategies
- **Concrete Strategies**:
  - `EmailNotificationService` - Sends email notifications
  - `PushNotificationService` - Sends push notifications
  - `InAppNotificationService` - Sends in-app notifications
- **Context**: `NotificationContext` - Maintains a reference to a strategy object and delegates the work to it
- **Client**: `NotificationRouter` - Selects the appropriate strategy based on the notification type

#### Class Diagram

```
┌───────────────────┐      ┌───────────────────┐
│ NotificationRouter│─────>│NotificationContext│
└───────────────────┘      └─────────┬─────────┘
                                     │
                                     │ uses
                                     ▼
                           ┌─────────────────────┐
                           │ NotificationStrategy│
                           └─────────────────────┘
                                     ▲
                                     │ implements
                 ┌───────────────────┼───────────────────┐
                 │                   │                   │
    ┌────────────────────┐ ┌─────────────────────┐ ┌────────────────────┐
    │EmailNotification   │ │PushNotification     │ │InAppNotification   │
    │Service             │ │Service              │ │Service             │
    └────────────────────┘ └─────────────────────┘ └────────────────────┘
```

## Getting Started

### Prerequisites

- Java 21 or higher

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/fahimfahad92/design-pattern.git
   cd design-pattern
   ```

2. Build the project:
   ```bash
   ./mvnw clean install
   ```

3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

## Usage Examples

### Strategy Pattern Example

```java
// Import necessary classes
import org.fahim.designpattern.DesignPatternApplication;
import org.fahim.designpattern.strategy.NotificationRouter;
import org.fahim.designpattern.strategy.NotificationType;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;

// Get the router from Spring context
ApplicationContext context = SpringApplication.run(DesignPatternApplication.class, args);
NotificationRouter router = context.getBean(NotificationRouter.class);

// Send an email notification
NotificationType sentType = router.sendNotification(NotificationType.EMAIL);
// Output: Sending email notification

// Send a push notification
NotificationType pushType = router.sendNotification(NotificationType.PUSH);
// Output: Sending push notification

// Send an in-app notification
NotificationType inAppType = router.sendNotification(NotificationType.IN_APP);
// Output: Sending in-app notification
```



