# CS 320 Software Testing Portfolio

This repository contains my Contact Service project files and my summary and reflections report from CS 320: Software Test Automation and QA. The project demonstrates my experience creating Java classes, validating requirements, and using JUnit tests to verify that code behaves correctly.

## How Can I Ensure My Code Program or Software Is Functional and Secure

I can help ensure my software is functional by translating each requirement into testable behavior and writing unit tests for both valid and invalid cases. For the Contact Service, I tested field requirements, duplicate IDs, adding contacts, updating contacts, and deleting contacts. I also used coverage reports to confirm that the normal and error paths in the code were executed. To improve security, I would validate user input, reject invalid or missing data, protect sensitive information, use secure authentication when needed, and keep dependencies updated. Testing does not guarantee that software is perfect, but it helps find defects before users are affected.

## How I Interpret User Needs and Incorporate Them Into a Program

I begin by reading the requirements carefully and breaking them into smaller rules that can be implemented and tested. For example, the Contact Service requirements stated that contact IDs must be unique and cannot exceed 10 characters, while names, phone numbers, and addresses also had specific validation rules. I turned those requirements into validation logic in the Contact class and JUnit tests that checked whether the application accepted valid input and rejected invalid input. This process helps make sure the final program solves the problem the user actually asked for.

## How I Approach Designing Software

My approach is to start with the requirements, identify the data and actions the program needs, and separate responsibilities into clear classes. I then build the program in small pieces and test each part as I go. For this project, I created the Contact object first, then built the service responsible for storing, adding, updating, and deleting contacts. Writing tests alongside the code helped me catch issues early and confirm that each feature met its requirement. In future projects, I will continue using unit tests, code reviews, automated testing, and clear documentation to maintain software quality and reduce technical debt.
