# Horizon-HR
HorizonHR — Enterprise Workforce & Leave Management Platform

HorizonHR is a role-based workforce management platform designed to streamline employee management, attendance tracking, leave management, approval workflows, holiday management, and workforce reporting.

The platform is designed around real-world enterprise requirements such as role-based access control, configurable business policies, service-to-service communication, transactional consistency, auditability, and scalable architecture.

 User Roles

Admin / HR — Manage employees, departments, leave policies, holidays, and organization-wide reports.

Manager — Monitor team attendance, review leave requests, and manage team-level workflows.

Employee — Track attendance, apply for leave, view leave balances, and access relevant workforce information.

 Core Capabilities

Employee and department management

Role-based authentication and authorization

Daily attendance check-in/check-out

Leave types and configurable leave policies

Leave balance and carry-forward management

Weekend and holiday-aware leave calculation

Multi-level leave approval workflows

Approval history and audit logging

Holiday and team calendar

Monthly attendance reporting

Asynchronous notification processing

Role-based dashboards

Planned Architecture

The system will progressively evolve into a service-oriented architecture consisting of:

API Gateway

Identity Service

Employee Service

Attendance Service

Leave Service

Notification Service

Reporting Service

Supporting technologies and concepts will include:

Java & Spring Boot

Spring Security & JWT

Spring Data JPA / Hibernate

PostgreSQL

OpenFeign

RabbitMQ

Resilience patterns

React & TypeScript

Docker

JUnit & integration testing

 Engineering Focus

HorizonHR is being developed as a production-style learning project with emphasis on:

Clean service boundaries

Database ownership

REST API design

Secure authorization

Transaction management

Concurrency handling

Configurable business rules

Event-driven processing

Resilience and failure handling

Testing and maintainability

Professional Git practices

Documentation

Architecture decisions, database design, service boundaries, API contracts, and other technical documentation will be maintained under the docs/ directory.

Project Status

Phase 0 — Architecture & Project Foundation

The project is currently in the architecture and repository setup stage. Features will be implemented progressively, tested, reviewed, and documented throughout development.
