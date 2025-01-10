# Fibonacci Java Project with Maven, Jenkins, and Integrated Tools

## Overview
This repository contains the contents of my midterm and final projects for CEN4802C - Software Integration, Configuration, and Testing. The final project builds on the midterm foundation.

The project implements a simple Fibonacci sequence calculator written in Java, built with Maven, and deployed using a Jenkins Maven pipeline. The integration highlights the use of modern tools and practices for software development and deployment.

---

## Features
1. **Continuous Integration/Continuous Deployment (CI/CD):**
   - Utilizes Jenkins pipelines for automated building, testing, and deployment of the Fibonacci application.

2. **Automated Testing:**
   - Integrated JUnit for unit testing of the Fibonacci logic.
   - JMeter for lightweight performance testing after updates in Jenkins.

3. **Logging and Notifications:**
   - Implements `java.util.logging` to log application activity and errors.
   - Configured `javax.mail` for automated email notifications with logs to relevant team members.

4. **Monitoring and Deployment:**
   - Docker used for containerized deployment of the application.
   - DataDog integrated for monitoring application performance and metrics.

---

## Tools and Technologies Used
- **Version Control:** Git
- **Build and Dependency Management:** Maven
- **Deployment:** Docker
- **CI/CD:** Jenkins
- **Testing:** JUnit and JMeter
- **Monitoring:** DataDog
- **Logging and Notifications:** `java.util.logging` and `javax.mail`

---

## Key Functions

### Fibonacci Calculator (`Fibonacci.java`):
- A Java program that computes Fibonacci numbers efficiently.
- Built with Maven for modularity and dependency management.

### CI/CD Pipeline:
- Configured Jenkins to:
  - Automatically build the project upon changes in the repository.
  - Run JUnit and JMeter tests as part of the pipeline.
  - Deploy the application using Docker.

### Logging and Notifications:
- Logs application data and events using `java.util.logging`.
- Automatically emails logs to team members after updates using `javax.mail`.

### Monitoring:
- Integrated DataDog to:
  - Monitor application performance.
  - Track key metrics such as response time and system resource usage.

---

## Performance Highlights
- **Automation:** Streamlined development and deployment using Jenkins pipelines.
- **Efficiency:** Ensures high reliability and maintainability through automated testing and monitoring.
- **Scalability:** Utilized Docker for easy deployment and scaling of the application.

---

## Presentations
- **Midterm Presentation:** [Link to Notes and Materials](#)
- **Final Presentation:** [Link to Notes and Materials](#)

---

All materials used in the presentations are available in this repository.
